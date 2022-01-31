package com.tencent.mobileqq.mini.launch;

import ajya;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.LruCache;
import bbkb;
import bcql;
import bekt;
import beku;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.MiniCrashHandler;
import com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.RenderInfo;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver1;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver2;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver3;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver4;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver5;
import com.tencent.mobileqq.mini.app.InternalAppBrandTaskPreloadReceiver;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI1;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI2;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI4;
import com.tencent.mobileqq.mini.appbrand.ui.InternalAppBrandUI;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04746;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.tissue.TissueEnvImpl;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.NavigateBackUtils;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.mobileqq.minigame.manager.EngineVersion;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.ui.GameActivity2;
import com.tencent.mobileqq.minigame.ui.GameActivity3;
import com.tencent.mobileqq.minigame.ui.GameActivity4;
import com.tencent.mobileqq.minigame.ui.GameActivity5;
import com.tencent.mobileqq.minigame.ui.InternalGameActivity;
import com.tencent.mobileqq.minigame.utils.CPUUtil;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSdkUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class AppBrandLaunchManager
  implements IAppLaunch
{
  private static final int KILL_MODE_PID = 0;
  private static final int KILL__MODE_BROADCAST = 1;
  public static final int MINI_APP_CRASH_PROTECT_TIME_DEFAULT = 3600000;
  private static final int MINI_APP_PROCESS_DETECT_TIME_DEFAULT = 600000;
  private static final int MINI_GAME_PROCESS_REUSE_DEFAULT = 1;
  private static final int PROCESS_APP_RECYCLE_TIME = 1800000;
  private static final int PROCESS_GAME_MAX_COUNT_DEFAULT = 3;
  private static final int PROCESS_GAME_RECYCLE_TIME = 900000;
  private static final int PROCESS_MAX_COUNT_DEFAULT = 6;
  private static final int PROCESS_PRELOAD_COUNT_DEFAULT = 2;
  private static final String TAG = "miniapp-process_AppBrandLaunchManager";
  private static List<String> gameProcessReuseBlacklist;
  private static AppBrandLaunchManager instance;
  private static byte[] lock = new byte[0];
  private static AppBrandLaunchManager.MiniAppSubProcessorInfo sInternalProcessInfo;
  private static List<AppBrandLaunchManager.MiniAppSubProcessorInfo> sSupportProcessList;
  public static LinkedHashMap<String, AppBrandLaunchManager.MiniAppSubProcessorInfo> subAppProcessorInfoMap;
  public static LinkedHashMap<String, AppBrandLaunchManager.MiniAppSubProcessorInfo> subGameProcessorInfoMap;
  public static LinkedHashMap<String, AppBrandLaunchManager.MiniAppSubProcessorInfo> subProcessorInfoMap = new LinkedHashMap();
  public long appProcessRecycleTime = 1800000L;
  public long gameProcessRecycleTime = 900000L;
  private boolean isFirstTimeUpdateBaseLib;
  private boolean isUpdatingBaseLib;
  private AppBrandLaunchManager.MiniAppSubProcessorInfo lastKillingProcessor;
  private Context mContext = BaseApplicationImpl.getApplication();
  protected Handler mHandler = new Handler(ThreadManager.getSubThreadHandler().getLooper());
  private int mKillProcessMode = 0;
  private long mLastPreloadDetectTime;
  private boolean mMiniAppUsed;
  private ConcurrentHashMap<String, String> mPreloadingTask = new ConcurrentHashMap();
  private int mProcessGameMaxCount;
  private int mProcessMaxCount = bbkb.a(this.mContext, 6);
  private int mProcessPreloadCount;
  private LruCache<String, AppBrandLaunchManager.MiniAppSubProcessorInfo> mProcessStack;
  private int mStartTimeInterval = 1500;
  private long mStartTimestamp;
  private MiniAppConfig mStartingMiniAppConfig;
  private ConcurrentHashMap<String, AppBrandLaunchManager.RecommendRunnable> recommendMap = new ConcurrentHashMap();
  private HashMap<String, Long> startAppIdMap = new HashMap();
  
  static
  {
    subAppProcessorInfoMap = new LinkedHashMap();
    subGameProcessorInfoMap = new LinkedHashMap();
    sSupportProcessList = new ArrayList();
    sInternalProcessInfo = new AppBrandLaunchManager.MiniAppSubProcessorInfo("com.tencent.mobileqq:mini_internal", InternalAppBrandUI.class, InternalGameActivity.class, InternalAppBrandTaskPreloadReceiver.class);
    sSupportProcessList.add(new AppBrandLaunchManager.MiniAppSubProcessorInfo("com.tencent.mobileqq:mini", AppBrandUI.class, GameActivity.class, AppBrandTaskPreloadReceiver.class));
    sSupportProcessList.add(new AppBrandLaunchManager.MiniAppSubProcessorInfo("com.tencent.mobileqq:mini1", AppBrandUI1.class, GameActivity1.class, AppBrandTaskPreloadReceiver1.class));
    sSupportProcessList.add(new AppBrandLaunchManager.MiniAppSubProcessorInfo("com.tencent.mobileqq:mini2", AppBrandUI2.class, GameActivity2.class, AppBrandTaskPreloadReceiver2.class));
    sSupportProcessList.add(new AppBrandLaunchManager.MiniAppSubProcessorInfo("com.tencent.mobileqq:mini3", null, GameActivity3.class, AppBrandTaskPreloadReceiver3.class));
    sSupportProcessList.add(new AppBrandLaunchManager.MiniAppSubProcessorInfo("com.tencent.mobileqq:mini4", AppBrandUI4.class, GameActivity4.class, AppBrandTaskPreloadReceiver4.class));
    sSupportProcessList.add(new AppBrandLaunchManager.MiniAppSubProcessorInfo("com.tencent.mobileqq:mini5", null, GameActivity5.class, AppBrandTaskPreloadReceiver5.class));
  }
  
  private AppBrandLaunchManager()
  {
    if (this.mProcessMaxCount <= 0) {
      this.mProcessMaxCount = 6;
    }
    if (this.mProcessMaxCount > sSupportProcessList.size()) {
      this.mProcessMaxCount = sSupportProcessList.size();
    }
    subProcessorInfoMap.clear();
    try
    {
      i = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_process_info_count", 3);
      for (;;)
      {
        if (j >= this.mProcessMaxCount) {
          break label253;
        }
        AppBrandLaunchManager.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppBrandLaunchManager.MiniAppSubProcessorInfo)sSupportProcessList.get(j);
        subProcessorInfoMap.put(localMiniAppSubProcessorInfo.processName, localMiniAppSubProcessorInfo);
        if (this.mProcessMaxCount - j <= i) {
          break;
        }
        subAppProcessorInfoMap.put(localMiniAppSubProcessorInfo.processName, localMiniAppSubProcessorInfo);
        j += 1;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, "get config MINI_GAME_PROCESS_INFO_COUNT exception!", localThrowable1);
        int i = 3;
        continue;
        subGameProcessorInfoMap.put(localThrowable1.processName, localThrowable1);
      }
      label253:
      subProcessorInfoMap.put(sInternalProcessInfo.processName, sInternalProcessInfo);
      this.mProcessPreloadCount = bbkb.c(this.mContext, 2);
      if (this.mProcessPreloadCount < 0) {
        this.mProcessPreloadCount = 2;
      }
      if (this.mProcessPreloadCount > this.mProcessMaxCount) {
        this.mProcessPreloadCount = this.mProcessMaxCount;
      }
      this.mProcessGameMaxCount = bbkb.b(this.mContext, 3);
      if (this.mProcessGameMaxCount <= 0) {
        this.mProcessGameMaxCount = 3;
      }
      if (this.mProcessGameMaxCount > this.mProcessMaxCount) {
        this.mProcessGameMaxCount = this.mProcessMaxCount;
      }
      if (this.mProcessGameMaxCount > subGameProcessorInfoMap.size()) {
        this.mProcessGameMaxCount = subGameProcessorInfoMap.size();
      }
      this.appProcessRecycleTime = bbkb.b(this.mContext, "mini_app_process_recycle_time", 1800000);
      this.gameProcessRecycleTime = bbkb.b(this.mContext, "mini_game_process_recycle_time", 900000);
    }
    try
    {
      this.mStartTimeInterval = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_start_interval_time", 1500);
      this.mKillProcessMode = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_process_kill_mode", 0);
      this.mProcessStack = new LruCache(this.mProcessMaxCount);
      getHandler().postDelayed(new AppBrandLaunchManager.1(this), 10000L);
      return;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, "get config StartTimeInterval exception!", localThrowable2);
      }
    }
  }
  
  private boolean canPreloadApp(AppBrandLaunchManager.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_crash_protect", 1) > 0)
    {
      i = 1;
      if (i != 0) {
        break label28;
      }
    }
    label28:
    long l1;
    long l2;
    do
    {
      return true;
      i = 0;
      break;
      l1 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_crash_protect_time", 3600000);
      l2 = MiniCrashHandler.getLastCrashTime(paramMiniAppSubProcessorInfo.processName);
    } while ((l2 <= 0L) || (System.currentTimeMillis() - l2 > l1));
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, "Disable preload. CrashHandler last crash time:" + l2 + " processName:" + paramMiniAppSubProcessorInfo.processName);
    return false;
  }
  
  private boolean canPreloadProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.mProcessStack.snapshot();
    ((Map)localObject1).remove(sInternalProcessInfo.processName);
    int j;
    label47:
    int i;
    if ("preload_game".equals(paramString))
    {
      j = this.mProcessGameMaxCount;
      localObject1 = ((Map)localObject1).entrySet().iterator();
      i = 0;
      label63:
      if (!((Iterator)localObject1).hasNext()) {
        break label134;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 == null) {
        break label141;
      }
      localObject2 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
      if ((localObject2 == null) || (!paramString.equals(((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).preloadType))) {
        break label141;
      }
      i += 1;
    }
    label134:
    label141:
    for (;;)
    {
      break label63;
      j = this.mProcessMaxCount;
      break label47;
      if (i >= j) {
        break;
      }
      return true;
    }
  }
  
  private void checkAndCleanAllMiniProcess()
  {
    for (;;)
    {
      Iterator localIterator1;
      Object localObject4;
      Object localObject3;
      int i;
      try
      {
        Object localObject1 = (ActivityManager)this.mContext.getSystemService("activity");
        if (localObject1 == null) {
          break label376;
        }
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if (localObject1 == null) {
          break label375;
        }
        if (((List)localObject1).size() <= 0) {
          return;
        }
        localIterator1 = this.mProcessStack.snapshot().entrySet().iterator();
        if (localIterator1.hasNext())
        {
          localObject4 = (Map.Entry)localIterator1.next();
          if (localObject4 == null) {
            continue;
          }
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject4).getValue();
          if (localObject4 == null) {
            continue;
          }
          Iterator localIterator2 = ((List)localObject1).iterator();
          if (localIterator2.hasNext())
          {
            if (((ActivityManager.RunningAppProcessInfo)localIterator2.next()).pid != ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject4).pid) {
              continue;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            QLog.i("miniapp-process_AppBrandLaunchManager", 1, "Process has been died, clean the record! processName=" + (String)localObject3 + " pid=" + ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject4).pid);
            localObject3 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)this.mProcessStack.remove(localObject3);
            if (localObject3 == null) {
              continue;
            }
            ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).clean();
          }
        }
        else
        {
          localIterator1 = this.mPreloadingTask.entrySet().iterator();
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, "", localThrowable);
        return;
      }
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localObject3 = (Map.Entry)localIterator1.next();
          if (localObject3 != null)
          {
            localObject3 = (String)((Map.Entry)localObject3).getKey();
            localObject4 = localThrowable.iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
            } while (!TextUtils.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject4).next()).processName, (CharSequence)localObject3));
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label368;
              }
              QLog.i("miniapp-process_AppBrandLaunchManager", 1, "Process has been died, clean the preloading record! processName=" + (String)localObject3);
              localIterator1.remove();
              break;
            }
            label368:
            continue;
            i = 0;
            break;
          }
        }
      }
      label375:
      return;
      label376:
      Object localObject2 = null;
    }
  }
  
  private boolean checkAppVersionId(MiniAppConfig paramMiniAppConfig1, MiniAppConfig paramMiniAppConfig2)
  {
    if ((paramMiniAppConfig1 == null) || (paramMiniAppConfig1.config == null) || (paramMiniAppConfig2 == null) || (paramMiniAppConfig2.config == null)) {
      return false;
    }
    return paramMiniAppConfig1.config.versionIdEquals(paramMiniAppConfig2.config);
  }
  
  private void checkNetworkStatus(MiniAppConfig paramMiniAppConfig)
  {
    int i;
    if (this.mContext != null)
    {
      Object localObject = (ConnectivityManager)this.mContext.getSystemService("connectivity");
      if (localObject == null) {
        break label62;
      }
      localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
      i = 0;
      if (i >= localObject.length) {
        break label62;
      }
      localState = localObject[i].getState();
      if (NetworkInfo.State.CONNECTED != localState) {
        break label55;
      }
    }
    label55:
    label62:
    while ((paramMiniAppConfig == null) || ((paramMiniAppConfig.isEngineTypeMiniGame()) && (GpkgManager.isGpkgValid(paramMiniAppConfig))))
    {
      NetworkInfo.State localState;
      return;
      i += 1;
      break;
    }
    bcql.a(this.mContext, ajya.a(2131700605), 0).a();
  }
  
  private void checkPreload()
  {
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, "checkPreload MiniAppUsed:" + this.mMiniAppUsed);
    try
    {
      if (this.mMiniAppUsed)
      {
        this.mLastPreloadDetectTime = System.currentTimeMillis();
        checkAndCleanAllMiniProcess();
        preloadInternalMiniApp();
        preloadExtraMiniApp(true);
        preloadExtraMiniApp(false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "", localThrowable);
    }
  }
  
  private void cleanProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      AppBrandLaunchManager.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppBrandLaunchManager.MiniAppSubProcessorInfo)this.mProcessStack.remove(paramString);
      if (localMiniAppSubProcessorInfo != null) {
        localMiniAppSubProcessorInfo.clean();
      }
    } while ((this.lastKillingProcessor == null) || (!paramString.equals(this.lastKillingProcessor.processName)));
    paramString = this.lastKillingProcessor;
    getHandler().postDelayed(new AppBrandLaunchManager.2(this, paramString), 2000L);
    this.lastKillingProcessor = null;
  }
  
  private void doPreloadApp(AppBrandLaunchManager.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramMiniAppSubProcessorInfo == null) || ((!paramBoolean2) && (!canPreloadApp(paramMiniAppSubProcessorInfo)))) {
      return;
    }
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, "do preload mini process name=" + paramMiniAppSubProcessorInfo.processName + " Preload=" + paramMiniAppSubProcessorInfo.appPreLoadClass.getSimpleName() + " isMiniApp:" + paramBoolean1);
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, paramMiniAppSubProcessorInfo.appPreLoadClass);
    Object localObject;
    String str;
    if (paramBoolean1)
    {
      localObject = "mini_preload_app";
      localIntent.setAction((String)localObject);
      localObject = this.mPreloadingTask;
      str = paramMiniAppSubProcessorInfo.processName;
      if (!paramBoolean1) {
        break label159;
      }
    }
    label159:
    for (paramMiniAppSubProcessorInfo = "preload_app";; paramMiniAppSubProcessorInfo = "preload_game")
    {
      ((ConcurrentHashMap)localObject).put(str, paramMiniAppSubProcessorInfo);
      this.mContext.sendBroadcast(localIntent);
      return;
      localObject = "mini_preload_game";
      break;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  private void doStartMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    if ((paramMiniAppConfig.config.renderInfo != null) && (paramMiniAppConfig.config.renderInfo.renderMode == 1) && (paramMiniAppConfig.config.renderInfo.renderMaterialMap.get(Integer.valueOf(1)) != null) && (enableFlutter()))
    {
      paramMiniAppConfig.isSdkMode = true;
      paramResultReceiver = new Bundle();
      paramResultReceiver.putString("tissuenativelibdir", beku.a.getNativeLibDir());
      MiniSdkLauncher.startMiniApp(paramActivity, paramMiniAppConfig, paramResultReceiver);
      return;
    }
    if (MiniSdkUtil.needJumpToMiniSDK(paramMiniAppConfig.config.appId))
    {
      MiniSdkLauncher.startMiniApp(paramActivity, paramMiniAppConfig, null);
      return;
    }
    paramMiniAppConfig.isSdkMode = false;
    AppBrandLaunchManager.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = obtainIdleProcessor(paramMiniAppConfig);
    if ((localMiniAppSubProcessorInfo == null) || (paramMiniAppConfig == null))
    {
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "obtain idle processor config failed!");
      return;
    }
    if ((this.mStartingMiniAppConfig != null) && (this.mStartingMiniAppConfig.equals(paramMiniAppConfig)) && (System.currentTimeMillis() - this.mStartTimestamp <= this.mStartTimeInterval))
    {
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, "startMiniApp duplicate. The miniapp is starting! interval=" + this.mStartTimeInterval + " appId=" + paramMiniAppConfig.config.appId);
      return;
    }
    Object localObject1;
    if (paramMiniAppConfig.isEngineTypeMiniGame())
    {
      MiniAppReportManager.reportClickDc04239(paramMiniAppConfig, MiniProgramLpReportDC04239.getAppType(paramMiniAppConfig), null, "click", null, true);
      MiniAppReportManager2.reportPageView("2click", null, null, paramMiniAppConfig);
      QLog.i("[minigame][start]", 1, "game[" + paramMiniAppConfig.config.getEngineType() + "][" + paramMiniAppConfig.config.name + "] 启动游戏!");
      if (!GameWnsUtils.gameEnable())
      {
        MiniProgramLpReportDC04239.reportPageView(paramMiniAppConfig, MiniProgramLpReportDC04239.getAppType(paramMiniAppConfig), null, "load_fail", "system_version_limit_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "system_version_limit_fail", null, paramMiniAppConfig);
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, "尾号 & 机型 不匹配！");
        ThreadManager.getUIHandler().post(new AppBrandLaunchManager.4(this));
      }
    }
    else
    {
      localObject2 = MiniProgramLpReportDC04239.getAppType(paramMiniAppConfig);
      if (paramMiniAppConfig.launchParam == null) {
        break label787;
      }
      localObject1 = paramMiniAppConfig.launchParam.entryPath;
      MiniAppReportManager.reportClickDc04239(paramMiniAppConfig, (String)localObject2, (String)localObject1, "click", null, true);
      if (paramMiniAppConfig.launchParam == null) {
        break label793;
      }
      localObject1 = paramMiniAppConfig.launchParam.entryPath;
      label413:
      MiniAppReportManager2.reportPageView("2click", null, (String)localObject1, paramMiniAppConfig);
      localObject2 = new StringBuilder().append("--- report click appid:");
      if (paramMiniAppConfig.config == null) {
        break label799;
      }
      localObject1 = paramMiniAppConfig.config.appId;
      label454:
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, localObject1);
    }
    if (paramMiniAppConfig.config != null) {
      this.startAppIdMap.put(paramMiniAppConfig.config.appId, Long.valueOf(System.currentTimeMillis()));
    }
    NavigateBackUtils.clearTag();
    this.mStartingMiniAppConfig = paramMiniAppConfig;
    this.mStartTimestamp = System.currentTimeMillis();
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, "[MiniEng]doStartMiniApp appId=" + paramMiniAppConfig.config.appId + " appName=" + paramMiniAppConfig.config.name + " engineType=" + paramMiniAppConfig.config.getEngineType() + " reportType=" + paramMiniAppConfig.config.getReportType() + " targetProcess=" + localMiniAppSubProcessorInfo.processName);
    Object localObject2 = this.mContext;
    label627:
    int i;
    label727:
    int j;
    if (paramMiniAppConfig.isEngineTypeMiniGame())
    {
      localObject1 = localMiniAppSubProcessorInfo.gameUIClass;
      localObject1 = new Intent((Context)localObject2, (Class)localObject1);
      if (paramMiniAppConfig.isEngineTypeMiniGame()) {
        MiniAppStartUtils.saveMiniAppInfoToFile(paramMiniAppConfig, localMiniAppSubProcessorInfo.processName);
      }
      ((Intent)localObject1).addFlags(805371904);
      ((Intent)localObject1).putExtra("CONFIG", paramMiniAppConfig);
      ((Intent)localObject1).putExtra("receiver", paramResultReceiver);
      ((Intent)localObject1).putExtra("processName", localMiniAppSubProcessorInfo.processName);
      ((Intent)localObject1).putExtra("startDuration", System.currentTimeMillis());
      localObject2 = EngineManager.g();
      if (!paramMiniAppConfig.isEngineTypeMiniGame()) {
        break label818;
      }
      i = 2;
      ((Intent)localObject1).putExtra("engineChannel", ((EngineManager)localObject2).getChannelForType(i));
      j = 3;
      if ((localMiniAppSubProcessorInfo.pid <= 0) || (localMiniAppSubProcessorInfo.appConfig != null)) {
        break label824;
      }
      i = 1;
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("start_mode", i);
      if (paramActivity == null) {
        break label854;
      }
      paramActivity.startActivity((Intent)localObject1);
      return;
      label787:
      localObject1 = null;
      break;
      label793:
      localObject1 = null;
      break label413;
      label799:
      localObject1 = Integer.valueOf(0);
      break label454;
      localObject1 = localMiniAppSubProcessorInfo.appBrandUIClass;
      break label627;
      label818:
      i = 3;
      break label727;
      label824:
      i = j;
      if (localMiniAppSubProcessorInfo.pid > 0)
      {
        i = j;
        if (localMiniAppSubProcessorInfo.appConfig != null) {
          i = 2;
        }
      }
    }
    label854:
    if (paramResultReceiver != null)
    {
      paramActivity = ((Intent)localObject1).getExtras();
      paramActivity.putParcelable("Activity", ((Intent)localObject1).getComponent());
      paramResultReceiver.send(1, paramActivity);
      return;
    }
    this.mContext.startActivity((Intent)localObject1);
  }
  
  private boolean enableFlutter()
  {
    boolean bool1;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_flutter_enable", 1) == 1)
    {
      bool1 = true;
      if (beku.a == null) {
        beku.a = new TissueEnvImpl();
      }
      if ((TextUtils.isEmpty(beku.a.getNativeLibDir())) || (!beku.a(beku.a.getNativeLibDir()))) {
        break label115;
      }
    }
    label115:
    for (boolean bool2 = true;; bool2 = false)
    {
      QZLog.i("Tissue", " enableFlutter enable:" + bool1 + ",envReady:" + bool2);
      if ((!bool1) || (!bool2)) {
        break label120;
      }
      return true;
      bool1 = false;
      break;
    }
    label120:
    return false;
  }
  
  private boolean enableGameProcessReuse()
  {
    boolean bool = true;
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_process_reuse", 1) > 0)
    {
      i = 1;
      if (i != 0) {
        break label30;
      }
    }
    label30:
    String str;
    do
    {
      return false;
      i = 0;
      break;
      str = Build.MODEL;
    } while (TextUtils.isEmpty(str));
    if (gameProcessReuseBlacklist == null)
    {
      gameProcessReuseBlacklist = new ArrayList();
      Object localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_process_reuse_blacklist", "");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = ((String)localObject).split(",");
          if (localObject != null)
          {
            int j = localObject.length;
            i = 0;
            while (i < j)
            {
              CharSequence localCharSequence = localObject[i];
              if (!TextUtils.isEmpty(localCharSequence)) {
                gameProcessReuseBlacklist.add(localCharSequence);
              }
              i += 1;
            }
          }
          if (gameProcessReuseBlacklist.contains(str)) {}
        }
        catch (Throwable localThrowable)
        {
          QLog.e("miniapp-process_AppBrandLaunchManager", 1, "init gameProcessReuseBlacklist error,", localThrowable);
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private AppBrandLaunchManager.MiniAppSubProcessorInfo findLastMiniGameProcessor(MiniAppConfig paramMiniAppConfig)
  {
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    int i = 0;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      if (localObject2 != null)
      {
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 == null) || (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig == null) || (!((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig.isEngineTypeMiniGame())) {
          break label136;
        }
        i += 1;
        if ((((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).equalAppConfig(paramMiniAppConfig)) || (localObject1 != null)) {
          break label133;
        }
        localObject1 = localObject2;
      }
    }
    label133:
    label136:
    for (;;)
    {
      break;
      if (i >= this.mProcessGameMaxCount) {
        return localObject1;
      }
      return null;
    }
  }
  
  private boolean finishAndRemoveTask(AppBrandLaunchManager.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)this.mContext.getSystemService("activity");
      if (localObject == null) {
        return false;
      }
      localObject = ((ActivityManager)localObject).getAppTasks();
      if (localObject == null) {
        return false;
      }
      if (paramMiniAppSubProcessorInfo == null)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, "finishAndRemoveTask 当前进程信息为空");
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.AppTask localAppTask = (ActivityManager.AppTask)((Iterator)localObject).next();
        if ((localAppTask != null) && (localAppTask.getTaskInfo() != null) && (localAppTask.getTaskInfo().baseIntent != null) && (localAppTask.getTaskInfo().baseIntent.getComponent() != null))
        {
          String str = localAppTask.getTaskInfo().baseIntent.getComponent().getClassName();
          QLog.i("miniapp-process_AppBrandLaunchManager", 1, "finishAndRemoveTask try finish and remove task: id=" + localAppTask.getTaskInfo().id + ", componentName:" + str);
          if ((!TextUtils.isEmpty(str)) && (((paramMiniAppSubProcessorInfo.appBrandUIClass != null) && (str.equals(paramMiniAppSubProcessorInfo.appBrandUIClass.getName()))) || ((paramMiniAppSubProcessorInfo.gameUIClass != null) && (str.equals(paramMiniAppSubProcessorInfo.gameUIClass.getName())))))
          {
            QLog.i("miniapp-process_AppBrandLaunchManager", 1, "finishAndRemoveTask finish and remove task: id=" + localAppTask.getTaskInfo().id);
            localAppTask.finishAndRemoveTask();
          }
        }
      }
      return true;
    }
    catch (Throwable paramMiniAppSubProcessorInfo)
    {
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "finishAndRemoveAllTasks exception.", paramMiniAppSubProcessorInfo);
    }
    return false;
  }
  
  public static AppBrandLaunchManager g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new AppBrandLaunchManager();
      }
      return instance;
    }
  }
  
  private AppBrandLaunchManager.MiniAppSubProcessorInfo getCacheApp(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null)) {
      return getCacheApp(paramMiniAppConfig.config);
    }
    return null;
  }
  
  private static void handleStartMiniappByBroadcast(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString)
  {
    if (paramMiniAppInfo != null) {
      try
      {
        MiniAppConfig localMiniAppConfig = new MiniAppConfig(paramMiniAppInfo);
        localMiniAppConfig.launchParam = new LaunchParam();
        localMiniAppConfig.launchParam.miniAppId = paramMiniAppInfo.appId;
        localMiniAppConfig.launchParam.scene = 2016;
        localMiniAppConfig.launchParam.shareTicket = paramString;
        if (paramInt == 1)
        {
          localMiniAppConfig.forceReroad = 3;
          paramMiniAppInfo = g().getCacheApp(localMiniAppConfig);
          if ((paramMiniAppInfo != null) && ((localMiniAppConfig.forceReroad & 0x2) != 0)) {
            g().forceKillProcess(paramMiniAppInfo);
          }
        }
        else if (paramInt == 3)
        {
          localMiniAppConfig.forceReroad = 3;
        }
        MiniAppController.startApp(null, localMiniAppConfig, null);
        return;
      }
      catch (Throwable paramMiniAppInfo)
      {
        paramMiniAppInfo.printStackTrace();
      }
    }
  }
  
  private boolean hasPreloadProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.mProcessStack.snapshot();
    ((Map)localObject1).remove(sInternalProcessInfo.processName);
    localObject1 = ((Map)localObject1).entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig == null) && (paramString.equals(((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).preloadType))) {
          return true;
        }
      }
    }
    localObject1 = this.mPreloadingTask.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((localObject2 != null) && (paramString.equals((String)((Map.Entry)localObject2).getValue()))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isProcessValid(String paramString)
  {
    return subProcessorInfoMap.containsKey(paramString);
  }
  
  private boolean needPreloadMiniApp()
  {
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        localObject = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject).appConfig == null)) {
          return false;
        }
      }
    }
    return this.mPreloadingTask.size() <= 0;
  }
  
  private void notifyBaselibUpdate(int paramInt)
  {
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        localObject = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
        if (localObject != null)
        {
          Intent localIntent = new Intent();
          localIntent.setClass(this.mContext, ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject).appPreLoadClass);
          localIntent.setAction("mini_baselib_updated");
          localIntent.putExtra("key_retcode", paramInt);
          this.mContext.sendBroadcast(localIntent);
        }
      }
    }
  }
  
  private AppBrandLaunchManager.MiniAppSubProcessorInfo obtainIdleMiniAppProcessor(MiniAppConfig paramMiniAppConfig)
  {
    Object localObject1 = this.mProcessStack.snapshot();
    ((Map)localObject1).remove(sInternalProcessInfo.processName);
    Object localObject3;
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.forceReroad == 0))
    {
      localObject2 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        if (localObject4 != null)
        {
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject4).getValue();
          if ((localObject4 != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject4).equalAppConfig(paramMiniAppConfig)))
          {
            QLog.i("miniapp-process_AppBrandLaunchManager", 1, "obtain loaded processor from stack:" + (String)localObject3);
            return localObject4;
          }
        }
      }
    }
    paramMiniAppConfig = ((Map)localObject1).entrySet().iterator();
    while (paramMiniAppConfig.hasNext())
    {
      localObject3 = (Map.Entry)paramMiniAppConfig.next();
      if (localObject3 != null)
      {
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject3).getValue();
        if ((localObject3 != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).appConfig == null) && ("preload_app".equals(((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).preloadType)))
        {
          QLog.i("miniapp-process_AppBrandLaunchManager", 1, "obtain idle processor from stack:" + (String)localObject2);
          return localObject3;
        }
      }
    }
    if (this.mProcessStack.size() < this.mProcessMaxCount)
    {
      paramMiniAppConfig = subAppProcessorInfoMap.entrySet().iterator();
      while (paramMiniAppConfig.hasNext())
      {
        localObject3 = (Map.Entry)paramMiniAppConfig.next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject3).getValue();
        if ((!((Map)localObject1).containsKey(localObject2)) && (localObject3 != null))
        {
          QLog.i("miniapp-process_AppBrandLaunchManager", 1, "obtain idle processor from create:" + (String)localObject2);
          return localObject3;
        }
      }
    }
    paramMiniAppConfig = this.mProcessStack.snapshot();
    paramMiniAppConfig.remove(sInternalProcessInfo.processName);
    Object localObject2 = paramMiniAppConfig.entrySet().iterator();
    paramMiniAppConfig = null;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      paramMiniAppConfig = (MiniAppConfig)localObject1;
      if (localObject1 != null)
      {
        localObject3 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
        paramMiniAppConfig = (MiniAppConfig)localObject1;
        if (localObject3 != null)
        {
          paramMiniAppConfig = (MiniAppConfig)localObject1;
          if (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).appConfig != null)
          {
            paramMiniAppConfig = (MiniAppConfig)localObject1;
            if (!((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).appConfig.isEngineTypeMiniGame())
            {
              paramMiniAppConfig = (MiniAppConfig)localObject1;
              if (!((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).isAppStore()) {
                paramMiniAppConfig = (MiniAppConfig)localObject1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramMiniAppConfig != null)
      {
        localObject1 = (String)paramMiniAppConfig.getKey();
        paramMiniAppConfig = (AppBrandLaunchManager.MiniAppSubProcessorInfo)paramMiniAppConfig.getValue();
        if (paramMiniAppConfig != null)
        {
          QLog.i("miniapp-process_AppBrandLaunchManager", 1, "obtain idle processor from stack bottom:" + (String)localObject1);
          return paramMiniAppConfig;
        }
      }
      return null;
    }
  }
  
  private AppBrandLaunchManager.MiniAppSubProcessorInfo obtainIdleMiniGameProcessor(MiniAppConfig paramMiniAppConfig)
  {
    Object localObject1 = this.mProcessStack.snapshot();
    ((Map)localObject1).remove(sInternalProcessInfo.processName);
    Object localObject3;
    Object localObject2;
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.forceReroad == 0))
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        if (localObject3 != null)
        {
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject3).getValue();
          if ((localObject3 != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).equalAppConfig(paramMiniAppConfig)))
          {
            QLog.i("miniapp-process_AppBrandLaunchManager", 1, "obtain loaded processor from stack:" + (String)localObject2);
            return localObject3;
          }
        }
      }
    }
    int j = this.mProcessGameMaxCount;
    localObject1 = this.mProcessStack.snapshot();
    ((Map)localObject1).remove(sInternalProcessInfo.processName);
    localObject1 = ((Map)localObject1).entrySet().iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 == null) || (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig == null) || (!((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig.isEngineTypeMiniGame())) {
          break label922;
        }
        i += 1;
      }
    }
    label919:
    label922:
    for (;;)
    {
      break;
      if (i < j)
      {
        localObject1 = this.mProcessStack.snapshot();
        ((Map)localObject1).remove(sInternalProcessInfo.processName);
        localObject2 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
          if (localObject4 != null)
          {
            localObject3 = (String)((Map.Entry)localObject4).getKey();
            localObject4 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject4).getValue();
            if ((localObject4 != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject4).appConfig == null) && ("preload_game".equals(((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject4).preloadType)) && (paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
            {
              QLog.i("miniapp-process_AppBrandLaunchManager", 1, "obtain idle processor from preload, baselibMiniVersion required: " + paramMiniAppConfig.config.baselibMiniVersion + ", current preload:" + ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject4).preloadGameBaseLibVersion);
              if ((TextUtils.isEmpty(paramMiniAppConfig.config.baselibMiniVersion)) || (TextUtils.isEmpty(((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject4).preloadGameBaseLibVersion)))
              {
                QLog.i("miniapp-process_AppBrandLaunchManager", 1, "obtain idle processor from preload, required baselibMiniVersion is empty: " + (String)localObject3);
                return localObject4;
              }
              if ((!TextUtils.isEmpty(paramMiniAppConfig.config.baselibMiniVersion)) && (!TextUtils.isEmpty(((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject4).preloadGameBaseLibVersion)) && (EngineVersion.compareVersion(paramMiniAppConfig.config.baselibMiniVersion, ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject4).preloadGameBaseLibVersion) <= 0))
              {
                QLog.i("miniapp-process_AppBrandLaunchManager", 1, "obtain idle processor from preload, required baselibMiniVersion matched: " + (String)localObject3);
                return localObject4;
              }
              QLog.e("miniapp-process_AppBrandLaunchManager", 1, "obtain idle processor from preload, baselibMiniVersion does not match, required: " + paramMiniAppConfig.config.baselibMiniVersion + ", current preload:" + ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject4).preloadGameBaseLibVersion);
            }
          }
        }
        if (((Map)localObject1).size() < this.mProcessMaxCount)
        {
          paramMiniAppConfig = subGameProcessorInfoMap.entrySet().iterator();
          do
          {
            if (!paramMiniAppConfig.hasNext()) {
              break;
            }
            localObject3 = (Map.Entry)paramMiniAppConfig.next();
            localObject2 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject3).getValue();
          } while ((((Map)localObject1).containsKey(localObject2)) || (localObject3 == null));
          QLog.i("miniapp-process_AppBrandLaunchManager", 1, "obtain idle processor from create:" + (String)localObject2);
          return localObject3;
        }
      }
      else
      {
        paramMiniAppConfig = this.mProcessStack.snapshot();
        paramMiniAppConfig.remove(sInternalProcessInfo.processName);
        localObject2 = paramMiniAppConfig.entrySet().iterator();
        paramMiniAppConfig = null;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (Map.Entry)((Iterator)localObject2).next();
          if (localObject1 != null)
          {
            localObject3 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
            if ((localObject3 == null) || (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).isAppStore()) || (paramMiniAppConfig != null) || (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).appConfig == null) || (!((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).appConfig.isEngineTypeMiniGame())) {
              break label919;
            }
            paramMiniAppConfig = (MiniAppConfig)localObject1;
          }
        }
      }
      for (;;)
      {
        break;
        if (paramMiniAppConfig != null)
        {
          localObject1 = (String)paramMiniAppConfig.getKey();
          paramMiniAppConfig = (AppBrandLaunchManager.MiniAppSubProcessorInfo)paramMiniAppConfig.getValue();
          if (paramMiniAppConfig != null)
          {
            QLog.i("miniapp-process_AppBrandLaunchManager", 1, "obtain idle processor from stack bottom:" + (String)localObject1);
            return paramMiniAppConfig;
          }
        }
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, "has no idle processor!!!");
        return null;
      }
    }
  }
  
  private AppBrandLaunchManager.MiniAppSubProcessorInfo obtainIdleProcessor(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
      return null;
    }
    if (paramMiniAppConfig.isInternalApp()) {
      return sInternalProcessInfo;
    }
    if (paramMiniAppConfig.isEngineTypeMiniGame()) {
      return obtainIdleMiniGameProcessor(paramMiniAppConfig);
    }
    return obtainIdleMiniAppProcessor(paramMiniAppConfig);
  }
  
  private void printProcessStack()
  {
    StringBuilder localStringBuilder = new StringBuilder(500);
    Object localObject = this.mProcessStack.snapshot();
    int i = this.mProcessStack.size();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (localEntry != null) {
        localStringBuilder.append("{").append(localEntry.getKey()).append(" ").append(localEntry.getValue()).append("}*******");
      }
    }
    QLog.w("miniapp-process_AppBrandLaunchManager", 1, "current process count=" + i + " " + localStringBuilder.toString());
  }
  
  private void registerStartMiniAppReceiver(Context paramContext)
  {
    if (this.mContext == null)
    {
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "registerStartMiniAppReceiver, context = " + paramContext);
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.miniapp.debugger");
    paramContext.registerReceiver(new AppBrandLaunchManager.StartMiniAppReceiver(null), localIntentFilter);
  }
  
  public int checkIfAnyMiniProcessForeground()
  {
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        localObject = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject).isForeground))
        {
          if (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject).appConfig != null)
          {
            if (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject).appConfig.isEngineTypeMiniGame()) {
              return 1;
            }
            return 2;
          }
          return 2;
        }
      }
    }
    return 0;
  }
  
  public void forceKillProcess(AppBrandLaunchManager.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    if (paramMiniAppSubProcessorInfo == null) {
      return;
    }
    this.lastKillingProcessor = paramMiniAppSubProcessorInfo;
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, "kill mini process: " + this.lastKillingProcessor);
    int i = paramMiniAppSubProcessorInfo.pid;
    if (i > 0) {
      try
      {
        if (this.mKillProcessMode == 0)
        {
          QLog.w("miniapp-process_AppBrandLaunchManager", 1, "kill process by pid:" + i);
          Process.killProcess(i);
          finishAndRemoveTask(paramMiniAppSubProcessorInfo);
          cleanProcess(paramMiniAppSubProcessorInfo.processName);
          printProcessStack();
          return;
        }
      }
      catch (Throwable paramMiniAppSubProcessorInfo)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, "kill process exception!", paramMiniAppSubProcessorInfo);
        return;
      }
    }
    QLog.w("miniapp-process_AppBrandLaunchManager", 1, "kill process by broadcast" + paramMiniAppSubProcessorInfo.processName);
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, paramMiniAppSubProcessorInfo.appPreLoadClass);
    localIntent.setAction("mini_process_kill");
    this.mContext.sendBroadcast(localIntent);
  }
  
  public AppBrandLaunchManager.MiniAppSubProcessorInfo getCacheApp(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject1 = this.mProcessStack.snapshot();
    if (paramMiniAppInfo != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
          if ((localObject2 != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig.config != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig.config.appId.equals(paramMiniAppInfo.appId)))
          {
            QLog.i("miniapp-process_AppBrandLaunchManager", 1, "obtain loaded processor from stack:" + str);
            return localObject2;
          }
        }
      }
    }
    return null;
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public void onAppBackground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    int k = -1;
    Object localObject2 = null;
    if (!isProcessValid(paramString)) {
      return;
    }
    MiniAppUtils.updateMiniAppList(7);
    label39:
    Object localObject1;
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      paramBundle = paramMiniAppConfig.config.appId;
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break label380;
      }
      localObject1 = paramMiniAppConfig.config.name;
      label59:
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break label386;
      }
    }
    label386:
    for (int i = paramMiniAppConfig.config.getEngineType();; i = -1)
    {
      int j = k;
      if (paramMiniAppConfig != null)
      {
        j = k;
        if (paramMiniAppConfig.config != null) {
          j = paramMiniAppConfig.config.getReportType();
        }
      }
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, "onAppBackground process=" + paramString + " appId=" + paramBundle + " appName=" + (String)localObject1 + " engineType=" + i + " reportType=" + j);
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      AppBrandLaunchManager.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (AppBrandLaunchManager.MiniAppSubProcessorInfo)this.mProcessStack.snapshot().get(paramString);
      if (localMiniAppSubProcessorInfo == null) {
        break label392;
      }
      paramString = (String)localObject2;
      if (localMiniAppSubProcessorInfo.appConfig != null)
      {
        paramString = (String)localObject2;
        if (localMiniAppSubProcessorInfo.appConfig.config != null) {
          paramString = localMiniAppSubProcessorInfo.appConfig.config.appId;
        }
      }
      if (paramString != null)
      {
        localObject1 = localMiniAppSubProcessorInfo;
        if (paramString.equals(paramBundle)) {}
      }
      else
      {
        localMiniAppSubProcessorInfo.appConfig = paramMiniAppConfig;
        localObject1 = localMiniAppSubProcessorInfo;
      }
      ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).onEnterBackground();
      printProcessStack();
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (this.recommendMap == null) || (!this.recommendMap.containsKey(paramMiniAppConfig.config.appId))) {
        break;
      }
      paramString = (AppBrandLaunchManager.RecommendRunnable)this.recommendMap.remove(paramMiniAppConfig.config.appId);
      if (paramString == null) {
        break;
      }
      QLog.e("miniapp-process_AppBrandLaunchManager", 2, "removeCallbacks recommendRunnable : " + paramMiniAppConfig.config.appId);
      ThreadManager.getSubThreadHandler().removeCallbacks(paramString);
      return;
      paramBundle = null;
      break label39;
      label380:
      localObject1 = null;
      break label59;
    }
    label392:
    localObject2 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)subProcessorInfoMap.get(paramString);
    if (localObject2 != null)
    {
      paramBundle = ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appBrandUIClass;
      label415:
      if (localObject2 == null) {
        break label479;
      }
      localObject1 = ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).gameUIClass;
      label427:
      if (localObject2 == null) {
        break label485;
      }
    }
    label479:
    label485:
    for (localObject2 = ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appPreLoadClass;; localObject2 = null)
    {
      localObject1 = new AppBrandLaunchManager.MiniAppSubProcessorInfo(paramString, paramBundle, (Class)localObject1, (Class)localObject2);
      ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).appConfig = paramMiniAppConfig;
      this.mProcessStack.put(paramString, localObject1);
      break;
      paramBundle = null;
      break label415;
      localObject1 = null;
      break label427;
    }
  }
  
  public void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    boolean bool = false;
    if (!isProcessValid(paramString)) {}
    Object localObject1;
    label32:
    Object localObject2;
    label52:
    int i;
    label72:
    int j;
    label92:
    int k;
    label105:
    do
    {
      return;
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break;
      }
      localObject1 = paramMiniAppConfig.config.appId;
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break label562;
      }
      localObject2 = paramMiniAppConfig.config.name;
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break label568;
      }
      i = paramMiniAppConfig.config.getEngineType();
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break label574;
      }
      j = paramMiniAppConfig.config.getReportType();
      if (paramBundle == null) {
        break label580;
      }
      k = paramBundle.getInt("PID");
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, "onAppForeground process=" + paramString + " appId=" + (String)localObject1 + " appName=" + (String)localObject2 + " engineType=" + i + " reportType=" + j);
    } while (TextUtils.isEmpty(paramString));
    paramBundle = (AppBrandLaunchManager.MiniAppSubProcessorInfo)this.mProcessStack.get(paramString);
    if (paramBundle != null)
    {
      paramBundle.appConfig = paramMiniAppConfig;
      paramString = paramBundle;
      if ((this.mStartingMiniAppConfig != null) && (this.mStartingMiniAppConfig.equals(paramMiniAppConfig))) {
        this.mStartingMiniAppConfig = null;
      }
      if (k > 0) {
        paramString.pid = k;
      }
      paramString.onEnterForeground();
      printProcessStack();
      if (paramMiniAppConfig != null)
      {
        if (!paramMiniAppConfig.isEngineTypeMiniGame()) {
          break label746;
        }
        paramString = findLastMiniGameProcessor(paramMiniAppConfig);
        if (paramString == null) {
          break label718;
        }
        if (!enableGameProcessReuse()) {
          break label684;
        }
        QLog.w("miniapp-process_AppBrandLaunchManager", 1, "onAppForeground enableGameProcessReuse, try finishAndRemoveTask lastMiniGameProcessor =" + paramString);
        finishAndRemoveTask(paramString);
      }
    }
    for (;;)
    {
      getHandler().postDelayed(new AppBrandLaunchManager.9(this), 600L);
      if (paramMiniAppConfig != null) {
        checkNetworkStatus(paramMiniAppConfig);
      }
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (paramMiniAppConfig.config.noNeedRealRecommend != 0) || (this.startAppIdMap == null) || (!this.startAppIdMap.containsKey(paramMiniAppConfig.config.appId))) {
        break;
      }
      long l1 = StorageUtil.getPreference().getLong("key_mini_app_recommend_time", 5L) * 1000L;
      paramString = new ArrayList();
      long l2 = System.currentTimeMillis();
      long l3 = ((Long)this.startAppIdMap.get(paramMiniAppConfig.config.appId)).longValue();
      paramString = new AppBrandLaunchManager.RecommendRunnable(this, paramMiniAppConfig.config.appId, paramMiniAppConfig.config.verType, l2 - l3, paramString);
      if (this.recommendMap != null) {
        this.recommendMap.put(paramMiniAppConfig.config.appId, paramString);
      }
      this.startAppIdMap.remove(paramMiniAppConfig.config.appId);
      QLog.e("miniapp-process_AppBrandLaunchManager", 2, "postDelayed recommendRunnable : " + paramMiniAppConfig.config.appId + "; recommendTime : " + l1);
      ThreadManager.getSubThreadHandler().postDelayed(paramString, l1);
      return;
      localObject1 = null;
      break label32;
      label562:
      localObject2 = null;
      break label52;
      label568:
      i = -1;
      break label72;
      label574:
      j = -1;
      break label92;
      label580:
      k = 0;
      break label105;
      localObject2 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)subProcessorInfoMap.get(paramString);
      if (localObject2 != null)
      {
        paramBundle = ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appBrandUIClass;
        label609:
        if (localObject2 == null) {
          break label672;
        }
        localObject1 = ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).gameUIClass;
        label621:
        if (localObject2 == null) {
          break label678;
        }
      }
      label672:
      label678:
      for (localObject2 = ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appPreLoadClass;; localObject2 = null)
      {
        paramBundle = new AppBrandLaunchManager.MiniAppSubProcessorInfo(paramString, paramBundle, (Class)localObject1, (Class)localObject2);
        paramBundle.appConfig = paramMiniAppConfig;
        this.mProcessStack.put(paramString, paramBundle);
        paramString = paramBundle;
        break;
        paramBundle = null;
        break label609;
        localObject1 = null;
        break label621;
      }
      label684:
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, "onAppForeground disableGameProcessReuse, try kill lastMiniGameProcessor = " + paramString);
      forceKillProcess(paramString);
      continue;
      label718:
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, "onAppForeground lastMiniGameProcessor is null, try preload process");
      if (!paramMiniAppConfig.isEngineTypeMiniGame()) {
        bool = true;
      }
      preloadExtraMiniApp(bool);
      continue;
      label746:
      if (paramMiniAppConfig != null) {
        getHandler().postDelayed(new AppBrandLaunchManager.8(this, paramMiniAppConfig), 500L);
      }
    }
  }
  
  public void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    Object localObject4 = null;
    if (!isProcessValid(paramString)) {}
    label52:
    int i;
    label72:
    int j;
    label92:
    int k;
    label105:
    do
    {
      return;
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break;
      }
      localObject1 = paramMiniAppConfig.config.appId;
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break label388;
      }
      localObject2 = paramMiniAppConfig.config.name;
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break label394;
      }
      i = paramMiniAppConfig.config.getEngineType();
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break label400;
      }
      j = paramMiniAppConfig.config.getReportType();
      if (paramBundle == null) {
        break label406;
      }
      k = paramBundle.getInt("PID");
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, "[MiniEng]onAppStart process=" + paramString + " appId=" + (String)localObject1 + " appName=" + (String)localObject2 + " engineType=" + i + " reportType=" + j);
    } while (TextUtils.isEmpty(paramString));
    Object localObject2 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)this.mProcessStack.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = (AppBrandLaunchManager.MiniAppSubProcessorInfo)subProcessorInfoMap.get(paramString);
      if (localObject3 == null) {
        break label412;
      }
      localObject1 = ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).appBrandUIClass;
      label228:
      if (localObject3 == null) {
        break label418;
      }
      localObject2 = ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).gameUIClass;
      label240:
      if (localObject3 == null) {
        break label424;
      }
    }
    label388:
    label394:
    label400:
    label406:
    label412:
    label418:
    label424:
    for (Object localObject3 = ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject3).appPreLoadClass;; localObject3 = null)
    {
      localObject2 = new AppBrandLaunchManager.MiniAppSubProcessorInfo(paramString, (Class)localObject1, (Class)localObject2, (Class)localObject3);
      ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig = paramMiniAppConfig;
      localObject1 = localObject4;
      if (paramBundle != null) {
        localObject1 = paramBundle.getString("key_preload_type", null);
      }
      ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).preloadType = ((String)localObject1);
      this.mProcessStack.put(paramString, localObject2);
      localObject1 = localObject2;
      if (paramMiniAppConfig != null) {
        ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).appConfig = paramMiniAppConfig;
      }
      ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).pid = k;
      this.mPreloadingTask.remove(paramString);
      printProcessStack();
      paramString = BaseApplicationImpl.getApplication().getQQProcessName();
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, "[MiniEng]updateBaseLib onAppStart " + paramString);
      updateBaseLib();
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label52;
      i = -1;
      break label72;
      j = -1;
      break label92;
      k = 0;
      break label105;
      localObject1 = null;
      break label228;
      localObject2 = null;
      break label240;
    }
  }
  
  public void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    int k = -1;
    if (!isProcessValid(paramString)) {
      return;
    }
    String str;
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      paramBundle = paramMiniAppConfig.config.appId;
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break label183;
      }
      str = paramMiniAppConfig.config.name;
      label51:
      if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
        break label189;
      }
    }
    label183:
    label189:
    for (int i = paramMiniAppConfig.config.getEngineType();; i = -1)
    {
      int j = k;
      if (paramMiniAppConfig != null)
      {
        j = k;
        if (paramMiniAppConfig.config != null) {
          j = paramMiniAppConfig.config.getReportType();
        }
      }
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, "onAppStop process=" + paramString + " appId=" + paramBundle + " appName=" + str + " engineType=" + i + " reportType=" + j);
      cleanProcess(paramString);
      printProcessStack();
      return;
      paramBundle = null;
      break;
      str = null;
      break label51;
    }
  }
  
  public void onEnterForeground()
  {
    long l = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_process_detect_time", 600000);
    if ((System.currentTimeMillis() - this.mLastPreloadDetectTime > l) && (this.mMiniAppUsed))
    {
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, "doProcessDetect MiniAppUsed:" + this.mMiniAppUsed + " lastTime:" + this.mLastPreloadDetectTime);
      getHandler().postDelayed(new AppBrandLaunchManager.12(this), 3000L);
    }
  }
  
  public void preloadExtraMiniApp(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        int i = this.mProcessStack.size();
        int j = this.mProcessMaxCount;
        Object localObject1;
        Map localMap;
        if (i >= j) {}else
        {
          if (!paramBoolean) {
            break label150;
          }
          localObject1 = "preload_app";
          if ((hasPreloadProcess((String)localObject1)) || (!canPreloadProcess((String)localObject1))) {
            continue;
          }
          localMap = this.mProcessStack.snapshot();
          if (!paramBoolean) {
            break label158;
          }
          localObject1 = subAppProcessorInfoMap;
          localObject1 = ((Map)localObject1).entrySet().iterator();
        }
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        if (localMap.containsKey((String)localEntry.getKey())) {
          continue;
        }
        doPreloadApp((AppBrandLaunchManager.MiniAppSubProcessorInfo)localEntry.getValue(), paramBoolean, false);
        continue;
        localObject3 = "preload_game";
      }
      finally {}
      label150:
      continue;
      label158:
      Object localObject3 = subGameProcessorInfoMap;
    }
  }
  
  /* Error */
  public void preloadInternalMiniApp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 295	com/tencent/mobileqq/mini/launch/AppBrandLaunchManager:mProcessStack	Landroid/util/LruCache;
    //   6: invokevirtual 1023	android/util/LruCache:size	()I
    //   9: istore_1
    //   10: aload_0
    //   11: getfield 226	com/tencent/mobileqq/mini/launch/AppBrandLaunchManager:mProcessMaxCount	I
    //   14: istore_2
    //   15: iload_1
    //   16: iload_2
    //   17: if_icmplt +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 295	com/tencent/mobileqq/mini/launch/AppBrandLaunchManager:mProcessStack	Landroid/util/LruCache;
    //   27: invokevirtual 387	android/util/LruCache:snapshot	()Ljava/util/Map;
    //   30: getstatic 111	com/tencent/mobileqq/mini/launch/AppBrandLaunchManager:sInternalProcessInfo	Lcom/tencent/mobileqq/mini/launch/AppBrandLaunchManager$MiniAppSubProcessorInfo;
    //   33: getfield 254	com/tencent/mobileqq/mini/launch/AppBrandLaunchManager$MiniAppSubProcessorInfo:processName	Ljava/lang/String;
    //   36: invokeinterface 1025 2 0
    //   41: ifne -21 -> 20
    //   44: aload_0
    //   45: getstatic 111	com/tencent/mobileqq/mini/launch/AppBrandLaunchManager:sInternalProcessInfo	Lcom/tencent/mobileqq/mini/launch/AppBrandLaunchManager$MiniAppSubProcessorInfo;
    //   48: iconst_1
    //   49: iconst_0
    //   50: invokespecial 1257	com/tencent/mobileqq/mini/launch/AppBrandLaunchManager:doPreloadApp	(Lcom/tencent/mobileqq/mini/launch/AppBrandLaunchManager$MiniAppSubProcessorInfo;ZZ)V
    //   53: goto -33 -> 20
    //   56: astore_3
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_3
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	AppBrandLaunchManager
    //   9	9	1	i	int
    //   14	4	2	j	int
    //   56	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	56	finally
    //   23	53	56	finally
  }
  
  public void preloadMiniApp()
  {
    boolean bool;
    int j;
    Map localMap;
    int i;
    label140:
    Map.Entry localEntry;
    for (;;)
    {
      label230:
      label237:
      try
      {
        bool = CPUUtil.sIsX86Emulator;
        if (bool) {
          return;
        }
        if (!needPreloadMiniApp()) {
          continue;
        }
        j = this.mProcessPreloadCount - this.mProcessStack.size();
        if (j <= 0) {
          continue;
        }
        localObject1 = BaseApplicationImpl.getApplication().getQQProcessName();
        QLog.i("miniapp-process_AppBrandLaunchManager", 1, "[MiniEng]updateBaseLib preloadMiniApp " + (String)localObject1 + ", process count=" + j);
        printProcessStack();
        updateBaseLib();
        ThreadManagerV2.executeOnFileThread(new AppBrandLaunchManager.3(this));
        if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_process_preload_priority", 1) != 1) {
          break label282;
        }
        doPreloadApp(sInternalProcessInfo, true, true);
        localMap = this.mProcessStack.snapshot();
        i = 0;
      }
      finally {}
      if (bool)
      {
        localObject1 = subAppProcessorInfoMap;
        localObject1 = ((LinkedHashMap)localObject1).entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label437;
        }
        localEntry = (Map.Entry)((Iterator)localObject1).next();
        if (localMap.containsKey((String)localEntry.getKey())) {
          continue;
        }
        doPreloadApp((AppBrandLaunchManager.MiniAppSubProcessorInfo)localEntry.getValue(), bool, true);
        break label437;
      }
      Object localObject1 = subGameProcessorInfoMap;
      continue;
      MiniSdkLauncher.preloadMiniApp(this.mContext);
      if ((SplashMiniGameStarter.hasPreloaded) && (SplashMiniGameStarter.curData != null)) {
        if (SplashMiniGameStarter.hasClickJumpBtn)
        {
          MiniProgramLpReportDC04746.report(SplashMiniGameStarter.curData.appId, SplashMiniGameStarter.curData.version, 1, 1);
          continue;
          label282:
          doPreloadApp(sInternalProcessInfo, true, true);
          MiniSdkLauncher.preloadMiniApp(this.mContext);
          localMap = this.mProcessStack.snapshot();
          i = 0;
          break label453;
        }
      }
    }
    for (;;)
    {
      if (bool) {}
      for (Object localObject3 = subAppProcessorInfoMap;; localObject3 = subGameProcessorInfoMap)
      {
        localObject3 = ((LinkedHashMap)localObject3).entrySet().iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localEntry = (Map.Entry)((Iterator)localObject3).next();
        } while (localMap.containsKey((String)localEntry.getKey()));
        doPreloadApp((AppBrandLaunchManager.MiniAppSubProcessorInfo)localEntry.getValue(), bool, true);
        break;
      }
      MiniProgramLpReportDC04746.report(SplashMiniGameStarter.curData.appId, SplashMiniGameStarter.curData.version, 1, 0);
      break;
      for (;;)
      {
        if (j <= 0) {
          break label446;
        }
        if (i % 2 != 0) {
          break label448;
        }
        bool = true;
        break;
        label437:
        j -= 1;
        i += 1;
      }
      label446:
      break label230;
      label448:
      bool = false;
      break label140;
      for (;;)
      {
        label453:
        if (j <= 0) {
          break label477;
        }
        if (i % 2 != 0) {
          break label479;
        }
        bool = true;
        break;
        j -= 1;
        i += 1;
      }
      label477:
      break label237;
      label479:
      bool = false;
    }
  }
  
  public void preloadPackage(@NonNull MiniAppInfo paramMiniAppInfo)
  {
    ApkgMainProcessManager.checkShouldLoadPkgInMainProcess(new MiniAppConfig(paramMiniAppInfo), null, true);
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, "preloadPackage" + paramMiniAppInfo.appId + " " + paramMiniAppInfo.name);
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    if ("cmd_on_preload_game_baselib".equals(paramString))
    {
      if (paramBundle != null)
      {
        paramString = paramBundle.getString("bundle_key_process_name", null);
        paramBundle = paramBundle.getString("bundle_key_preload_game_baselib_version", null);
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramBundle))) {
          getHandler().post(new AppBrandLaunchManager.10(this, paramString, paramBundle));
        }
      }
      return;
    }
    MiniAppCmdServlet.g().onMiniAppCmd(paramString, paramBundle, paramCmdCallback);
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppConfig == null) {
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "startMiniApp params is empty! ,appConfig=" + paramMiniAppConfig + " Activity=" + paramActivity);
    }
    for (;;)
    {
      return;
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, "[MiniEng]startMiniApp. " + paramMiniAppConfig.config.name + ",size=" + paramMiniAppConfig.config.fileSize + ", versionId:" + paramMiniAppConfig.config.versionId + ", versionUpdateTime:" + paramMiniAppConfig.config.versionUpdateTime + " fromProcess=" + BaseApplicationImpl.getApplication().getQQProcessName());
      if ((paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
      {
        AppBrandTask.runTaskOnUiThread(new AppBrandLaunchManager.5(this, paramMiniAppConfig, paramActivity));
        return;
      }
      if ((paramMiniAppConfig.launchParam == null) || (paramMiniAppConfig.launchParam.scene == 9999))
      {
        AppBrandTask.runTaskOnUiThread(new AppBrandLaunchManager.6(this, paramMiniAppConfig));
        return;
      }
      if ((paramMiniAppConfig.config.verType == 3) || (!TextUtils.isEmpty(paramMiniAppConfig.config.ide_scene))) {}
      try
      {
        int i = Integer.parseInt(paramMiniAppConfig.config.ide_scene);
        paramMiniAppConfig.launchParam.scene = i;
        if (!TextUtils.isEmpty(paramMiniAppConfig.config.ide_extraAppid)) {
          paramMiniAppConfig.launchParam.fromMiniAppId = paramMiniAppConfig.config.ide_extraAppid;
        }
        if (!TextUtils.isEmpty(paramMiniAppConfig.config.ide_extraData)) {
          paramMiniAppConfig.launchParam.navigateExtData = paramMiniAppConfig.config.ide_extraData;
        }
        this.mMiniAppUsed = true;
        Object localObject1;
        if ((paramMiniAppConfig.isEngineTypeMiniGame()) && (GameWnsUtils.enableHotReload()) && (paramMiniAppConfig.config.verType == 3))
        {
          localObject1 = obtainIdleProcessor(paramMiniAppConfig);
          if ((localObject1 != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).appConfig != null) && (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).appConfig.config != null) && (AppBrandUtil.needUpdate(((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).appConfig.config, paramMiniAppConfig.config)))
          {
            paramMiniAppConfig.forceReroad = 3;
            QLog.i("miniapp-process_AppBrandLaunchManager", 1, "启动版本有变化,forceReroad=true,oldVersionId=" + ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).appConfig.config.versionId + " newVersionId=" + paramMiniAppConfig.config.versionId + " oldVersionUpdateTime=" + ((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).appConfig.config.versionUpdateTime + " newVersionUpdateTime=" + paramMiniAppConfig.config.versionUpdateTime);
          }
        }
        if ((paramMiniAppConfig.config.firstPage != null) && (paramMiniAppConfig.launchParam != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.firstPage.pagePath)))
        {
          if (paramMiniAppConfig.config.firstPage.pagePath.startsWith("/")) {
            paramMiniAppConfig.config.firstPage.pagePath = paramMiniAppConfig.config.firstPage.pagePath.substring(1);
          }
          if (paramMiniAppConfig.config.firstPage.pagePath.contains(".html")) {
            paramMiniAppConfig.launchParam.entryPath = paramMiniAppConfig.config.firstPage.pagePath;
          }
        }
        else
        {
          Object localObject2 = new StringBuilder().append("---startApp----");
          if (paramMiniAppConfig.launchParam == null) {
            break label999;
          }
          localObject1 = paramMiniAppConfig.launchParam.entryPath;
          QLog.i("miniapp-start", 1, (String)localObject1);
          QLog.i("miniapp-start", 1, "---startApp---- appid:" + paramMiniAppConfig.config.appId + " appName:" + paramMiniAppConfig.config.name);
          QLog.e("miniapp-process_AppBrandLaunchManager", 1, "---startApp----");
          checkAndCleanAllMiniProcess();
          localObject1 = null;
          if (paramMiniAppConfig.forceReroad != 0)
          {
            localObject2 = getCacheApp(paramMiniAppConfig);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig != null)
              {
                localObject1 = localObject2;
                if (((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig.equals(paramMiniAppConfig))
                {
                  localObject1 = localObject2;
                  if (checkAppVersionId(((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject2).appConfig, paramMiniAppConfig))
                  {
                    paramMiniAppConfig.forceReroad = 0;
                    QLog.w("miniapp-process_AppBrandLaunchManager", 1, "reset forceReroad for " + paramMiniAppConfig);
                    localObject1 = localObject2;
                  }
                }
              }
            }
          }
          doStartMiniApp(paramActivity, paramMiniAppConfig, paramResultReceiver);
          MiniAppUtils.preFetchAppCacheData(paramActivity, paramMiniAppConfig.config);
          if ((localObject1 != null) && (!paramMiniAppConfig.isInternalApp()) && ((paramMiniAppConfig.forceReroad & 0x2) != 0)) {
            forceKillProcess((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1);
          }
          if (((paramMiniAppConfig.forceReroad & 0x2) != 0) && (localObject1 != null)) {
            cleanProcess(((AppBrandLaunchManager.MiniAppSubProcessorInfo)localObject1).processName);
          }
          if (!paramMiniAppConfig.isEngineTypeMiniGame()) {
            break label1007;
          }
          AnimUtil.clearAnim(paramActivity);
          if ((paramMiniAppConfig.isFromShowInfo()) || (paramMiniAppConfig.isShortcutFakeApp())) {
            continue;
          }
          MiniAppUtils.updatePullDownEntryListData(paramMiniAppConfig);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("miniapp-process_AppBrandLaunchManager", 1, "parse ide scene fail", localException);
          continue;
          if (paramMiniAppConfig.config.firstPage.pagePath.contains("?"))
          {
            paramMiniAppConfig.launchParam.entryPath = paramMiniAppConfig.config.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
          }
          else
          {
            paramMiniAppConfig.launchParam.entryPath = (paramMiniAppConfig.config.firstPage.pagePath + ".html");
            continue;
            label999:
            String str = "N/A";
            continue;
            label1007:
            if (paramMiniAppConfig.launchParam.scene != 2004) {
              AnimUtil.setOpenAnim(paramActivity);
            }
          }
        }
      }
    }
  }
  
  public void updateBaseLib()
  {
    try
    {
      BaseLibManager.g().updateBaseLib(new AppBrandLaunchManager.11(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, "updateBaseLib failed ", localThrowable);
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager
 * JD-Core Version:    0.7.0.1
 */