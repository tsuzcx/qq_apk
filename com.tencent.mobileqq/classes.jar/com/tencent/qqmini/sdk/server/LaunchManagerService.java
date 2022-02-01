package com.tencent.qqmini.sdk.server;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RenderInfo;
import com.tencent.qqmini.sdk.manager.EngineManager;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LaunchManagerService
{
  public static final String KEY_APP_INTENT_APP_ID = "APP_INTENT_APP_ID";
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
  private static final String TAG = "minisdk-start_LaunchManagerService";
  private static List<String> gameProcessReuseBlacklist;
  private static LaunchManagerService.MiniAppSubProcessorInfo sInternalProcessInfo;
  public static LinkedHashMap<String, LaunchManagerService.MiniAppSubProcessorInfo> subAppProcessorInfoMap = new LinkedHashMap();
  public static LinkedHashMap<String, LaunchManagerService.MiniAppSubProcessorInfo> subGameProcessorInfoMap = new LinkedHashMap();
  public static LinkedHashMap<String, LaunchManagerService.MiniAppSubProcessorInfo> subProcessorInfoMap = new LinkedHashMap();
  public long appProcessRecycleTime = 1800000L;
  public long gameProcessRecycleTime = 900000L;
  private LaunchManagerService.MiniAppSubProcessorInfo lastKillingProcessor;
  private final Map<String, Messenger> mClientMessengerMap = new HashMap();
  private Context mContext;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  private int mKillProcessMode = 0;
  private long mLastPreloadDetectTime;
  private boolean mMiniAppUsed = false;
  private ConcurrentHashMap<String, String> mPreloadingTask = new ConcurrentHashMap();
  private int mProcessGameMaxCount = 0;
  private int mProcessMaxCount = 0;
  private int mProcessPreloadCount = 0;
  private LruCache<String, LaunchManagerService.MiniAppSubProcessorInfo> mProcessStack;
  private IBinder mServiceBinder = new LaunchManagerService.ServiceBinder(this);
  private int mStartTimeInterval = 1500;
  private long mStartTimestamp;
  private MiniAppBaseInfo mStartingMiniAppConfig;
  private HashMap<String, Long> startAppIdMap = new HashMap();
  
  private boolean canPreloadApp(LaunchManagerService.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    return true;
  }
  
  private boolean canPreloadProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      ((Map)localObject1).remove(sInternalProcessInfo.processName);
    }
    int j;
    label52:
    int i;
    if ("preload_game".equals(paramString))
    {
      j = this.mProcessGameMaxCount;
      localObject1 = ((Map)localObject1).entrySet().iterator();
      i = 0;
      label68:
      if (!((Iterator)localObject1).hasNext()) {
        break label139;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 == null) {
        break label146;
      }
      localObject2 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
      if ((localObject2 == null) || (!paramString.equals(((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).preloadType))) {
        break label146;
      }
      i += 1;
    }
    label139:
    label146:
    for (;;)
    {
      break label68;
      j = this.mProcessMaxCount;
      break label52;
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
          break label371;
        }
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if (localObject1 == null) {
          break label370;
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
          localObject4 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject4).getValue();
          if (localObject4 == null) {
            continue;
          }
          Iterator localIterator2 = ((List)localObject1).iterator();
          if (localIterator2.hasNext())
          {
            if (((ActivityManager.RunningAppProcessInfo)localIterator2.next()).pid != ((LaunchManagerService.MiniAppSubProcessorInfo)localObject4).pid) {
              continue;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            QMLog.i("minisdk-start_LaunchManagerService", "Process has been died, clean the record! processName=" + (String)localObject3 + " pid=" + ((LaunchManagerService.MiniAppSubProcessorInfo)localObject4).pid);
            localObject3 = (LaunchManagerService.MiniAppSubProcessorInfo)this.mProcessStack.remove(localObject3);
            if (localObject3 == null) {
              continue;
            }
            ((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).clean();
          }
        }
        else
        {
          localIterator1 = this.mPreloadingTask.entrySet().iterator();
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "", localThrowable);
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
                break label363;
              }
              QMLog.i("minisdk-start_LaunchManagerService", "Process has been died, clean the preloading record! processName=" + (String)localObject3);
              localIterator1.remove();
              break;
            }
            label363:
            continue;
            i = 0;
            break;
          }
        }
      }
      label370:
      return;
      label371:
      Object localObject2 = null;
    }
  }
  
  private void checkPreload()
  {
    QMLog.i("minisdk-start_LaunchManagerService", "checkPreload MiniAppUsed:" + this.mMiniAppUsed);
    try
    {
      if (this.mMiniAppUsed)
      {
        this.mLastPreloadDetectTime = System.currentTimeMillis();
        checkAndCleanAllMiniProcess();
        preloadExtraMiniApp(true);
        preloadExtraMiniApp(false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "", localThrowable);
    }
  }
  
  private void cleanProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      LaunchManagerService.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (LaunchManagerService.MiniAppSubProcessorInfo)this.mProcessStack.remove(paramString);
      if (localMiniAppSubProcessorInfo != null) {
        localMiniAppSubProcessorInfo.clean();
      }
    } while ((this.lastKillingProcessor == null) || (!paramString.equals(this.lastKillingProcessor.processName)));
    paramString = this.lastKillingProcessor;
    getHandler().postDelayed(new LaunchManagerService.1(this, paramString), 2000L);
    this.lastKillingProcessor = null;
  }
  
  private void doPreLaunchMiniApp(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    if ((paramMiniAppInfo == null) || (!paramMiniAppInfo.isEngineTypeMiniApp())) {
      return;
    }
    LaunchManagerService.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo;
    try
    {
      QMLog.i("minisdk-start_LaunchManagerService", "PreLaunch mini app. appId:" + paramMiniAppInfo.appId + " appName:" + paramMiniAppInfo.name);
      localMiniAppSubProcessorInfo = obtainPreLaunchProcessor(paramMiniAppInfo);
      if (localMiniAppSubProcessorInfo == null)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "obtain processor config failed!");
        return;
      }
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "send preload Broadcast exception!", paramMiniAppInfo);
      return;
    }
    QMLog.i("minisdk-start_LaunchManagerService", "PreLaunch mini app in process:" + localMiniAppSubProcessorInfo.processName + " appId:" + paramMiniAppInfo.appId + " appName:" + paramMiniAppInfo.name);
    paramMiniAppInfo = new Intent();
    paramMiniAppInfo.setClass(this.mContext, localMiniAppSubProcessorInfo.appPreLoadClass);
    paramMiniAppInfo.setAction("mini_prelaunch_app");
    paramMiniAppInfo.putExtra("sdk_mode", true);
    if (paramBundle != null) {
      paramMiniAppInfo.putExtras(paramBundle);
    }
    paramBundle = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    paramMiniAppInfo.putExtra("KEY_LOGININFO", new LoginInfo(paramBundle.getLoginType(), paramBundle.getAccount(), paramBundle.getNickName(), paramBundle.getPayOpenId(), paramBundle.getPayOpenKey(), paramBundle.getPayAccessToken(), paramBundle.getLoginSig(), paramBundle.getPlatformId(), paramBundle.getAppId()));
    paramMiniAppInfo.putExtra("KEY_MINI_SERVICE_MANAGER", MiniServer.g().getMiniServiceFetcher());
    this.mContext.sendBroadcast(paramMiniAppInfo);
  }
  
  private void doPreloadApp(LaunchManagerService.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle)
  {
    if ((paramMiniAppSubProcessorInfo == null) || ((!paramBoolean2) && (!canPreloadApp(paramMiniAppSubProcessorInfo)))) {
      return;
    }
    for (;;)
    {
      try
      {
        QMLog.i("minisdk-start_LaunchManagerService", "do preload mini process name=" + paramMiniAppSubProcessorInfo.processName + " Preload=" + paramMiniAppSubProcessorInfo.appPreLoadClass.getSimpleName() + " isMiniApp:" + paramBoolean1);
        Intent localIntent = new Intent();
        localIntent.setClass(this.mContext, paramMiniAppSubProcessorInfo.appPreLoadClass);
        if (paramBoolean1)
        {
          str = "mini_preload_app";
          localIntent.setAction(str);
          localIntent.putExtra("sdk_mode", true);
          if (paramBundle != null) {
            localIntent.putExtras(paramBundle);
          }
          paramBundle = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
          localIntent.putExtra("KEY_LOGININFO", new LoginInfo(paramBundle.getLoginType(), paramBundle.getAccount(), paramBundle.getNickName(), paramBundle.getPayOpenId(), paramBundle.getPayOpenKey(), paramBundle.getPayAccessToken(), paramBundle.getLoginSig(), paramBundle.getPlatformId(), paramBundle.getAppId()));
          localIntent.putExtra("KEY_MINI_SERVICE_MANAGER", MiniServer.g().getMiniServiceFetcher());
          paramBundle = this.mPreloadingTask;
          str = paramMiniAppSubProcessorInfo.processName;
          if (!paramBoolean1) {
            break label279;
          }
          paramMiniAppSubProcessorInfo = "preload_app";
          paramBundle.put(str, paramMiniAppSubProcessorInfo);
          this.mContext.sendBroadcast(localIntent);
          return;
        }
      }
      catch (Throwable paramMiniAppSubProcessorInfo)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "send preload Broadcast exception!", paramMiniAppSubProcessorInfo);
        return;
      }
      String str = "mini_preload_game";
      continue;
      label279:
      paramMiniAppSubProcessorInfo = "preload_game";
    }
  }
  
  private void doPreloadApp(Map<String, LaunchManagerService.MiniAppSubProcessorInfo> paramMap, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    for (Object localObject = subAppProcessorInfoMap;; localObject = subGameProcessorInfoMap)
    {
      localObject = ((LinkedHashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (!paramMap.containsKey((String)localEntry.getKey())) {
          doPreloadApp((LaunchManagerService.MiniAppSubProcessorInfo)localEntry.getValue(), paramBoolean, true, true, paramBundle);
        }
      }
      return;
    }
  }
  
  private void doPreloadByRuntimeType(int paramInt)
  {
    QMLog.e("minisdk-start_LaunchManagerService", "preload by runtime type:" + paramInt);
    checkAndCleanAllMiniProcess();
    Iterator localIterator = subAppProcessorInfoMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
      if ((localObject != null) && ((((LaunchManagerService.MiniAppSubProcessorInfo)localObject).supportRuntimeType & paramInt) != 0))
      {
        QMLog.i("minisdk-start_LaunchManagerService", "obtain targe processor:" + str);
        if (!isProcessAlive(((LaunchManagerService.MiniAppSubProcessorInfo)localObject).processName))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "preload targe processor:" + str);
          doPreloadApp((LaunchManagerService.MiniAppSubProcessorInfo)localObject, true, true, true, null);
        }
      }
    }
  }
  
  private void doPreloadExtraMiniApp(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {}
    do
    {
      do
      {
        return;
        if (!paramMiniAppBaseInfo.isEngineTypeMiniGame()) {
          break;
        }
        LaunchManagerService.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = findLastMiniGameProcessor(paramMiniAppBaseInfo);
        if (localMiniAppSubProcessorInfo != null)
        {
          if (enableGameProcessReuse())
          {
            QMLog.w("minisdk-start_LaunchManagerService", "onAppForeground enableGameProcessReuse, try finishAndRemoveTask lastMiniGameProcessor =" + localMiniAppSubProcessorInfo);
            finishAndRemoveTask(localMiniAppSubProcessorInfo, true);
            return;
          }
          QMLog.w("minisdk-start_LaunchManagerService", "onAppForeground disableGameProcessReuse, try kill lastMiniGameProcessor = " + localMiniAppSubProcessorInfo);
          forceKillProcess(localMiniAppSubProcessorInfo);
          return;
        }
      } while (paramMiniAppBaseInfo == null);
      getHandler().postDelayed(new LaunchManagerService.5(this, paramMiniAppBaseInfo), 1000L);
      return;
    } while (paramMiniAppBaseInfo == null);
    getHandler().postDelayed(new LaunchManagerService.6(this, paramMiniAppBaseInfo), 1000L);
  }
  
  @SuppressLint({"WrongConstant"})
  private void doStartMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    LaunchManagerService.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = obtainIdleProcessor(paramMiniAppInfo);
    if ((localMiniAppSubProcessorInfo == null) || (paramMiniAppInfo == null))
    {
      QMLog.e("minisdk-start_LaunchManagerService", "obtain idle processor config failed!");
      return;
    }
    if ((this.mStartingMiniAppConfig != null) && (this.mStartingMiniAppConfig.equals(paramMiniAppInfo)) && (System.currentTimeMillis() - this.mStartTimestamp <= this.mStartTimeInterval))
    {
      QMLog.w("minisdk-start_LaunchManagerService", "startMiniApp duplicate. The miniapp is starting! interval=" + this.mStartTimeInterval + " appId=" + paramMiniAppInfo.appId);
      return;
    }
    MiniAppReportManager2.reportPageView("2click", null, paramMiniAppInfo.launchParam.entryPath, paramMiniAppInfo);
    if (paramMiniAppInfo != null) {
      this.startAppIdMap.put(paramMiniAppInfo.appId, Long.valueOf(System.currentTimeMillis()));
    }
    this.mStartingMiniAppConfig = paramMiniAppInfo;
    this.mStartTimestamp = System.currentTimeMillis();
    boolean bool = localMiniAppSubProcessorInfo.containsAppConfig(paramMiniAppInfo);
    QMLog.i("minisdk-start_LaunchManagerService", "doStartMiniApp appId=" + paramMiniAppInfo.appId + " appName=" + paramMiniAppInfo.name + " isInternal:" + paramMiniAppInfo.isInternalApp() + " engineType=" + paramMiniAppInfo.getEngineType() + " reportType=" + -1 + " targetProcess=" + localMiniAppSubProcessorInfo.processName + " alreadyStarted=" + bool);
    Object localObject2 = this.mContext;
    Object localObject1;
    int i;
    label491:
    int j;
    if ((paramMiniAppInfo.isInternalApp()) && (localMiniAppSubProcessorInfo.internalUIClass != null))
    {
      localObject1 = localMiniAppSubProcessorInfo.internalUIClass;
      localObject1 = new Intent((Context)localObject2, (Class)localObject1);
      setIntentFlags((Intent)localObject1, paramMiniAppInfo);
      localObject2 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      ((Intent)localObject1).putExtra("KEY_LOGININFO", new LoginInfo(((MiniAppProxy)localObject2).getLoginType(), ((MiniAppProxy)localObject2).getAccount(), ((MiniAppProxy)localObject2).getNickName(), ((MiniAppProxy)localObject2).getPayOpenId(), ((MiniAppProxy)localObject2).getPayOpenKey(), ((MiniAppProxy)localObject2).getPayAccessToken(), ((MiniAppProxy)localObject2).getLoginSig(), ((MiniAppProxy)localObject2).getPlatformId(), ((MiniAppProxy)localObject2).getAppId()));
      ((Intent)localObject1).putExtra("KEY_APPINFO", paramMiniAppInfo);
      ((Intent)localObject1).putExtra("KEY_MINI_SERVICE_MANAGER", MiniServer.g().getMiniServiceFetcher());
      ((Intent)localObject1).putExtra("sdk_mode", true);
      if (paramBundle != null) {
        ((Intent)localObject1).putExtras(paramBundle);
      }
      ((Intent)localObject1).putExtra("APP_INTENT_APP_ID", paramMiniAppInfo.appId);
      ((Intent)localObject1).putExtra("receiver", paramResultReceiver);
      ((Intent)localObject1).putExtra("processName", localMiniAppSubProcessorInfo.processName);
      ((Intent)localObject1).putExtra("startDuration", System.currentTimeMillis());
      paramBundle = EngineManager.g();
      if (paramMiniAppInfo.engineType != 1) {
        break label565;
      }
      i = 2;
      ((Intent)localObject1).putExtra("engineChannel", paramBundle.getChannelForType(i));
      j = 3;
      if ((localMiniAppSubProcessorInfo.pid <= 0) || (!localMiniAppSubProcessorInfo.allMiniAppInfo.isEmpty())) {
        break label571;
      }
      i = 1;
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("start_mode", i);
      if (paramActivity == null) {
        break label606;
      }
      paramActivity.startActivity((Intent)localObject1);
      return;
      localObject1 = localMiniAppSubProcessorInfo.uiClass;
      break;
      label565:
      i = 3;
      break label491;
      label571:
      i = j;
      if (localMiniAppSubProcessorInfo.pid > 0)
      {
        i = j;
        if (!localMiniAppSubProcessorInfo.allMiniAppInfo.isEmpty()) {
          i = 2;
        }
      }
    }
    label606:
    if (paramResultReceiver != null)
    {
      paramActivity = new Bundle();
      paramActivity.putParcelable("LAUNCH_ACTIVITY_INTENT", (Parcelable)localObject1);
      paramResultReceiver.send(1, paramActivity);
      return;
    }
    this.mContext.startActivity((Intent)localObject1);
  }
  
  private boolean enableGameProcessReuse()
  {
    boolean bool = true;
    int i;
    if (WnsConfig.getConfig("qqminiapp", "mini_game_process_reuse", 1) > 0)
    {
      i = 1;
      if (i != 0) {
        break label28;
      }
    }
    label28:
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
      Object localObject = WnsConfig.getConfig("qqminiapp", "mini_game_process_reuse_blacklist", "");
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
          QMLog.e("minisdk-start_LaunchManagerService", "init gameProcessReuseBlacklist error,", localThrowable);
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean equalAppInfo(MiniAppBaseInfo paramMiniAppBaseInfo1, MiniAppBaseInfo paramMiniAppBaseInfo2)
  {
    if ((paramMiniAppBaseInfo1 == null) || (paramMiniAppBaseInfo2 == null)) {}
    do
    {
      do
      {
        return false;
      } while (paramMiniAppBaseInfo1.getEngineType() != paramMiniAppBaseInfo2.getEngineType());
      if ((!TextUtils.isEmpty(paramMiniAppBaseInfo1.appId)) && (TextUtils.equals(paramMiniAppBaseInfo1.appId, paramMiniAppBaseInfo2.appId))) {
        return true;
      }
    } while ((TextUtils.isEmpty(paramMiniAppBaseInfo1.link)) || (!TextUtils.equals(paramMiniAppBaseInfo1.link, paramMiniAppBaseInfo2.link)));
    return true;
  }
  
  private LaunchManagerService.MiniAppSubProcessorInfo findCacheMiniProcessInfo(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Object localObject1;
    if (paramMiniAppBaseInfo == null)
    {
      localObject1 = null;
      return localObject1;
    }
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    Object localObject2;
    do
    {
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = (Map.Entry)localIterator.next();
          } while (localObject1 == null);
          localObject2 = (String)((Map.Entry)localObject1).getKey();
          localObject2 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
        } while (localObject2 == null);
        localObject1 = localObject2;
        if (((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).containsAppConfig(paramMiniAppBaseInfo)) {
          break;
        }
        localObject1 = ((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).allMiniAppInfo.iterator();
      }
    } while (!equalAppInfo(paramMiniAppBaseInfo, (MiniAppBaseInfo)((Iterator)localObject1).next()));
    return localObject2;
    return null;
  }
  
  private LaunchManagerService.MiniAppSubProcessorInfo findLastMiniGameProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
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
        localObject2 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 == null) || (((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).allMiniAppInfo.isEmpty()) || (!TextUtils.equals(((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).preloadType, "preload_game"))) {
          break label143;
        }
        i += 1;
        if ((((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).containsAppConfig(paramMiniAppBaseInfo)) || (localObject1 != null)) {
          break label140;
        }
        localObject1 = localObject2;
      }
    }
    label140:
    label143:
    for (;;)
    {
      break;
      if (i >= this.mProcessGameMaxCount) {
        return localObject1;
      }
      return null;
    }
  }
  
  private LaunchManagerService.MiniAppSubProcessorInfo findMiniAppProcessInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    Object localObject;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
      } while (localObject == null);
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
    } while ((localObject == null) || (!((LaunchManagerService.MiniAppSubProcessorInfo)localObject).containsAppConfig(paramMiniAppInfo)));
    for (paramMiniAppInfo = (MiniAppInfo)localObject;; paramMiniAppInfo = null) {
      return paramMiniAppInfo;
    }
  }
  
  private boolean finishAndRemoveTask(LaunchManagerService.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    for (;;)
    {
      ActivityManager.AppTask localAppTask;
      try
      {
        localObject1 = (ActivityManager)this.mContext.getSystemService("activity");
        if (localObject1 == null) {
          return false;
        }
        Object localObject2 = ((ActivityManager)localObject1).getAppTasks();
        if (localObject2 == null) {
          return false;
        }
        if (paramMiniAppSubProcessorInfo == null)
        {
          QMLog.e("miniapp", "当前进程信息为空");
          return false;
        }
        if ((paramBoolean) || (paramMiniAppSubProcessorInfo.allMiniAppInfo.isEmpty())) {
          break label356;
        }
        localObject1 = (MiniAppBaseInfo)paramMiniAppSubProcessorInfo.allMiniAppInfo.get(paramMiniAppSubProcessorInfo.allMiniAppInfo.size() - 1);
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label354;
        }
        localAppTask = (ActivityManager.AppTask)((Iterator)localObject2).next();
        if ((localAppTask == null) || (localAppTask.getTaskInfo() == null) || (localAppTask.getTaskInfo().baseIntent == null) || (localAppTask.getTaskInfo().baseIntent.getComponent() == null)) {
          continue;
        }
        if (paramBoolean)
        {
          String str = localAppTask.getTaskInfo().baseIntent.getComponent().getClassName();
          if ((TextUtils.isEmpty(str)) || (paramMiniAppSubProcessorInfo.uiClass == null) || (!str.equals(paramMiniAppSubProcessorInfo.uiClass.getName()))) {
            continue;
          }
          QMLog.i("minisdk-start_LaunchManagerService", "finishAndRemoveTask finish and remove task: id=" + localAppTask.getTaskInfo().id + " ui:" + paramMiniAppSubProcessorInfo.uiClass);
          localAppTask.finishAndRemoveTask();
          continue;
        }
        if (!TextUtils.equals(localAppTask.getTaskInfo().baseIntent.getStringExtra("APP_INTENT_APP_ID"), ((MiniAppBaseInfo)localObject1).appId)) {
          continue;
        }
      }
      catch (Throwable paramMiniAppSubProcessorInfo)
      {
        QMLog.e("miniapp", "finishAndRemoveAllTasks exception.");
        return false;
      }
      QMLog.i("minisdk-start_LaunchManagerService", "finishAndRemoveTask finish and remove task: id=" + localAppTask.getTaskInfo().id + " app:" + ((MiniAppBaseInfo)localObject1).name);
      localAppTask.finishAndRemoveTask();
      label354:
      return true;
      label356:
      Object localObject1 = null;
    }
  }
  
  @Nullable
  private LaunchManagerService.MiniAppSubProcessorInfo getAvailableMiniGameProcess(MiniAppBaseInfo paramMiniAppBaseInfo, Map<String, LaunchManagerService.MiniAppSubProcessorInfo> paramMap)
  {
    if (paramMiniAppBaseInfo == null) {
      return null;
    }
    Object localObject1 = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    Object localObject2;
    while (paramMap.hasNext())
    {
      localObject2 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)paramMap.next()).getValue();
      if ((localObject2 != null) && ("preload_game".equals(((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).preloadType))) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    Collections.sort((List)localObject1, new LaunchManagerService.2(this));
    paramMap = ((ArrayList)localObject1).iterator();
    while (paramMap.hasNext())
    {
      localObject1 = (LaunchManagerService.MiniAppSubProcessorInfo)paramMap.next();
      localObject2 = ((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).processName;
      if (((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).allMiniAppInfo.size() < getMiniGameMultiInstanceMaxCount())
      {
        if ((TextUtils.isEmpty(paramMiniAppBaseInfo.baselibMiniVersion)) || (TextUtils.isEmpty(((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).preloadGameBaseLibVersion)))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from preload, required baselibMiniVersion is empty: " + (String)localObject2 + " " + paramMiniAppBaseInfo.name);
          return localObject1;
        }
        if ((!TextUtils.isEmpty(paramMiniAppBaseInfo.baselibMiniVersion)) && (!TextUtils.isEmpty(((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).preloadGameBaseLibVersion)) && (EngineVersion.compareVersion(paramMiniAppBaseInfo.baselibMiniVersion, ((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).preloadGameBaseLibVersion) <= 0))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from preload, required baselibMiniVersion matched: " + (String)localObject2 + " " + paramMiniAppBaseInfo.name);
          return localObject1;
        }
        QMLog.e("minisdk-start_LaunchManagerService", "obtain idle processor from preload, baselibMiniVersion does not match, required: " + paramMiniAppBaseInfo.baselibMiniVersion + ", current preload:" + ((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).preloadGameBaseLibVersion + " " + paramMiniAppBaseInfo.name);
      }
    }
    return null;
  }
  
  private int getMiniGameMultiInstanceMaxCount()
  {
    if (Build.VERSION.SDK_INT <= 21) {}
    while (!enableGameProcessReuse()) {
      return 1;
    }
    return WnsConfig.getConfig("qqminiapp", "mini_game_multi_instance", 5);
  }
  
  private boolean hasPreloadProcess(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      ((Map)localObject1).remove(sInternalProcessInfo.processName);
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).allMiniAppInfo.isEmpty()) && (paramString.equals(((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).preloadType))) {
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
  
  private boolean hasPreloadingTask(String paramString)
  {
    if (paramString == null) {
      return this.mPreloadingTask.size() > 0;
    }
    return this.mPreloadingTask.containsValue(paramString);
  }
  
  private void initWnsConfig()
  {
    if (QUAUtil.isQQApp()) {
      return;
    }
    ThreadManager.executeOnNetworkIOThreadPool(new LaunchManagerService.4(this));
  }
  
  private boolean isProcessAlive(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ActivityManager)this.mContext.getSystemService("activity");
        if (localObject1 == null) {
          break label106;
        }
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if (localObject1 == null) {
          break label104;
        }
        if (((List)localObject1).size() <= 0) {
          return false;
        }
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          int i = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next()).pid;
          if (i != paramInt) {
            continue;
          }
          bool = true;
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "", localThrowable);
        return false;
      }
      boolean bool = false;
      continue;
      label104:
      return false;
      label106:
      Object localObject2 = null;
    }
  }
  
  private boolean isProcessAlive(String paramString)
  {
    try
    {
      Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
          if ((paramString.equals(str)) && (localObject != null))
          {
            boolean bool = isProcessAlive(((LaunchManagerService.MiniAppSubProcessorInfo)localObject).pid);
            return bool;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "", paramString);
    }
    return false;
  }
  
  private boolean needPreloadMiniApp(String paramString)
  {
    checkAndCleanAllMiniProcess();
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        localObject = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
        if ((localObject != null) && (((LaunchManagerService.MiniAppSubProcessorInfo)localObject).isIdleProcess()) && (paramString != null) && (paramString.equals(((LaunchManagerService.MiniAppSubProcessorInfo)localObject).preloadType)))
        {
          QMLog.d("minisdk-start_LaunchManagerService", "No need to preload mini process. " + paramString + ". Already has idle process " + localObject);
          return false;
        }
      }
    }
    if (hasPreloadingTask(paramString))
    {
      QMLog.d("minisdk-start_LaunchManagerService", "No need to preload mini process " + paramString + ". Already has preloading task " + this.mPreloadingTask);
      return false;
    }
    return true;
  }
  
  private LaunchManagerService.MiniAppSubProcessorInfo obtainAppProcessorForPreLaunch(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Object localObject1 = this.mProcessStack.snapshot();
    boolean bool = paramMiniAppBaseInfo.isInternalApp();
    if ((paramMiniAppBaseInfo.renderInfo != null) && (paramMiniAppBaseInfo.renderInfo.renderMode == 1) && (paramMiniAppBaseInfo.renderInfo.renderMaterialMap.get(Integer.valueOf(1)) != null))
    {
      i = 1;
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (int i = 2;; i = 1)
    {
      if (findCacheMiniProcessInfo(paramMiniAppBaseInfo) == null) {
        break label87;
      }
      QMLog.i("minisdk-start_LaunchManagerService", "The app has loaded, no need to PreLaunch again.");
      return null;
      i = 0;
      break;
    }
    label87:
    paramMiniAppBaseInfo = ((Map)localObject1).entrySet().iterator();
    Object localObject3;
    while (paramMiniAppBaseInfo.hasNext())
    {
      localObject3 = (Map.Entry)paramMiniAppBaseInfo.next();
      if (localObject3 != null)
      {
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject3).getValue();
        if ((localObject3 != null) && (((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).currentAppInfo == null) && ("preload_app".equals(((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).preloadType)) && (((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).support(bool, i)))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain PreLaunch processor from stack:" + (String)localObject2);
          return localObject3;
        }
      }
    }
    if (bool)
    {
      paramMiniAppBaseInfo = subAppProcessorInfoMap.entrySet().iterator();
      while (paramMiniAppBaseInfo.hasNext())
      {
        localObject1 = (Map.Entry)paramMiniAppBaseInfo.next();
        localObject2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
        if ((localObject1 != null) && (((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).support(bool, i)))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain PreLaunch processor support internal mode " + ((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).processName);
          return localObject1;
        }
      }
      return null;
    }
    if (this.mProcessStack.size() < this.mProcessMaxCount)
    {
      paramMiniAppBaseInfo = subAppProcessorInfoMap.entrySet().iterator();
      while (paramMiniAppBaseInfo.hasNext())
      {
        localObject3 = (Map.Entry)paramMiniAppBaseInfo.next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject3).getValue();
        if ((!((Map)localObject1).containsKey(localObject2)) && (localObject3 != null) && (((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).support(bool, i)))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from create:" + (String)localObject2);
          return localObject3;
        }
      }
    }
    paramMiniAppBaseInfo = subAppProcessorInfoMap.entrySet().iterator();
    while (paramMiniAppBaseInfo.hasNext())
    {
      localObject1 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)paramMiniAppBaseInfo.next()).getValue();
      if ((localObject1 != null) && (((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).support(bool, i)))
      {
        QMLog.i("minisdk-start_LaunchManagerService", "obtain PreLaunch processor from config list: " + ((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).processName);
        return localObject1;
      }
    }
    Object localObject2 = this.mProcessStack.snapshot().entrySet().iterator();
    paramMiniAppBaseInfo = null;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
      if (localObject1 != null)
      {
        localObject3 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
        paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
        if (localObject3 != null)
        {
          paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
          if (((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).currentAppInfo != null)
          {
            paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
            if (TextUtils.equals(((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).preloadType, "preload_app")) {
              paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramMiniAppBaseInfo != null)
      {
        localObject1 = (String)paramMiniAppBaseInfo.getKey();
        paramMiniAppBaseInfo = (LaunchManagerService.MiniAppSubProcessorInfo)paramMiniAppBaseInfo.getValue();
        if (paramMiniAppBaseInfo != null)
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain PreLaunch idle processor from stack bottom:" + (String)localObject1);
          return paramMiniAppBaseInfo;
        }
      }
      return null;
    }
  }
  
  private LaunchManagerService.MiniAppSubProcessorInfo obtainIdleMiniAppProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Object localObject1 = this.mProcessStack.snapshot();
    boolean bool = paramMiniAppBaseInfo.isInternalApp();
    int i;
    Object localObject3;
    if ((paramMiniAppBaseInfo.renderInfo != null) && (paramMiniAppBaseInfo.renderInfo.renderMode == 1) && (paramMiniAppBaseInfo.renderInfo.renderMaterialMap.get(Integer.valueOf(1)) != null))
    {
      i = 1;
      if (sInternalProcessInfo != null) {
        ((Map)localObject1).remove(sInternalProcessInfo.processName);
      }
      if (paramMiniAppBaseInfo != null) {
        localObject2 = ((Map)localObject1).entrySet().iterator();
      }
    }
    else
    {
      Object localObject4;
      Iterator localIterator;
      do
      {
        while (!localIterator.hasNext())
        {
          do
          {
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject4 = (Map.Entry)((Iterator)localObject2).next();
            } while (localObject4 == null);
            localObject3 = (String)((Map.Entry)localObject4).getKey();
            localObject4 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject4).getValue();
          } while (localObject4 == null);
          if (((LaunchManagerService.MiniAppSubProcessorInfo)localObject4).containsAppConfig(paramMiniAppBaseInfo))
          {
            QMLog.i("minisdk-start_LaunchManagerService", "obtain loaded processor from stack:" + (String)localObject3);
            return localObject4;
            i = 0;
            break;
          }
          localIterator = ((LaunchManagerService.MiniAppSubProcessorInfo)localObject4).allMiniAppInfo.iterator();
        }
      } while (!equalAppInfo(paramMiniAppBaseInfo, (MiniAppBaseInfo)localIterator.next()));
      QMLog.i("minisdk-start_LaunchManagerService", "obtain loaded processor from stack for cache runtime:" + (String)localObject3);
      return localObject4;
    }
    paramMiniAppBaseInfo = ((Map)localObject1).entrySet().iterator();
    while (paramMiniAppBaseInfo.hasNext())
    {
      localObject3 = (Map.Entry)paramMiniAppBaseInfo.next();
      if (localObject3 != null)
      {
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject3).getValue();
        if ((localObject3 != null) && (((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).currentAppInfo == null) && ("preload_app".equals(((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).preloadType)) && ((!bool) || (((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).internalUIClass != null)) && ((i == 0) || ((((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).supportRuntimeType & 0x2) > 0)))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from stack:" + (String)localObject2);
          return localObject3;
        }
      }
    }
    if (bool)
    {
      paramMiniAppBaseInfo = subAppProcessorInfoMap.entrySet().iterator();
      while (paramMiniAppBaseInfo.hasNext())
      {
        localObject1 = (Map.Entry)paramMiniAppBaseInfo.next();
        localObject2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
        if ((localObject1 != null) && (((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).internalUIClass != null))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain processor support internal mode " + ((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).processName);
          return localObject1;
        }
      }
      return null;
    }
    if (this.mProcessStack.size() < this.mProcessMaxCount)
    {
      paramMiniAppBaseInfo = subAppProcessorInfoMap.entrySet().iterator();
      while (paramMiniAppBaseInfo.hasNext())
      {
        localObject3 = (Map.Entry)paramMiniAppBaseInfo.next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject3).getValue();
        if ((!((Map)localObject1).containsKey(localObject2)) && (localObject3 != null))
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from create:" + (String)localObject2);
          return localObject3;
        }
      }
    }
    paramMiniAppBaseInfo = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      paramMiniAppBaseInfo.remove(sInternalProcessInfo.processName);
    }
    Object localObject2 = paramMiniAppBaseInfo.entrySet().iterator();
    paramMiniAppBaseInfo = null;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
      if (localObject1 != null)
      {
        localObject3 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
        paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
        if (localObject3 != null)
        {
          paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
          if (((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).currentAppInfo != null)
          {
            paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
            if ((((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).supportRuntimeType & 0x3) != 0) {
              paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramMiniAppBaseInfo != null)
      {
        localObject1 = (String)paramMiniAppBaseInfo.getKey();
        paramMiniAppBaseInfo = (LaunchManagerService.MiniAppSubProcessorInfo)paramMiniAppBaseInfo.getValue();
        if (paramMiniAppBaseInfo != null)
        {
          QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from stack bottom:" + (String)localObject1);
          return paramMiniAppBaseInfo;
        }
      }
      return null;
    }
  }
  
  private LaunchManagerService.MiniAppSubProcessorInfo obtainIdleMiniGameProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    Object localObject1 = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      ((Map)localObject1).remove(sInternalProcessInfo.processName);
    }
    Object localObject2;
    if (paramMiniAppBaseInfo != null)
    {
      localObject2 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)((Iterator)localObject2).next()).getValue();
        if ((localObject1 != null) && (((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).containsAppConfig(paramMiniAppBaseInfo)))
        {
          paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
          return paramMiniAppBaseInfo;
        }
      }
    }
    int j = this.mProcessGameMaxCount;
    localObject1 = this.mProcessStack.snapshot();
    if (sInternalProcessInfo != null) {
      ((Map)localObject1).remove(sInternalProcessInfo.processName);
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    int i = 0;
    label146:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if ((localObject2 == null) || (!TextUtils.equals(((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).preloadType, "preload_game"))) {
        break label521;
      }
      i += 1;
    }
    label518:
    label521:
    for (;;)
    {
      break label146;
      localObject2 = this.mProcessStack.snapshot();
      if (sInternalProcessInfo != null) {
        ((Map)localObject2).remove(sInternalProcessInfo.processName);
      }
      localObject1 = getAvailableMiniGameProcess(paramMiniAppBaseInfo, (Map)localObject2);
      paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
      if (localObject1 != null) {
        break;
      }
      Object localObject3;
      if (i < j)
      {
        if (((Map)localObject2).size() < this.mProcessMaxCount)
        {
          paramMiniAppBaseInfo = subGameProcessorInfoMap.entrySet().iterator();
          do
          {
            if (!paramMiniAppBaseInfo.hasNext()) {
              break;
            }
            localObject3 = (Map.Entry)paramMiniAppBaseInfo.next();
            localObject1 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject3).getValue();
          } while ((((Map)localObject2).containsKey(localObject1)) || (localObject3 == null));
          QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from create:" + (String)localObject1);
          return localObject3;
        }
      }
      else
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        paramMiniAppBaseInfo = null;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (Map.Entry)((Iterator)localObject2).next();
          if (localObject1 != null)
          {
            localObject3 = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject1).getValue();
            if ((localObject3 == null) || (paramMiniAppBaseInfo != null) || (!TextUtils.equals(((LaunchManagerService.MiniAppSubProcessorInfo)localObject3).preloadType, "preload_game"))) {
              break label518;
            }
            paramMiniAppBaseInfo = (MiniAppBaseInfo)localObject1;
          }
        }
      }
      for (;;)
      {
        break;
        if (paramMiniAppBaseInfo != null)
        {
          localObject1 = (String)paramMiniAppBaseInfo.getKey();
          paramMiniAppBaseInfo = (LaunchManagerService.MiniAppSubProcessorInfo)paramMiniAppBaseInfo.getValue();
          if (paramMiniAppBaseInfo != null)
          {
            QMLog.i("minisdk-start_LaunchManagerService", "obtain idle processor from stack bottom:" + (String)localObject1);
            return paramMiniAppBaseInfo;
          }
        }
        QMLog.e("minisdk-start_LaunchManagerService", "has no idle processor!!!");
        return null;
      }
    }
  }
  
  private LaunchManagerService.MiniAppSubProcessorInfo obtainIdleProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {
      return null;
    }
    if (paramMiniAppBaseInfo.isEngineTypeMiniGame()) {
      return obtainIdleMiniGameProcessor(paramMiniAppBaseInfo);
    }
    return obtainIdleMiniAppProcessor(paramMiniAppBaseInfo);
  }
  
  private LaunchManagerService.MiniAppSubProcessorInfo obtainPreLaunchProcessor(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo == null) {}
    while (paramMiniAppBaseInfo.isEngineTypeMiniGame()) {
      return null;
    }
    return obtainAppProcessorForPreLaunch(paramMiniAppBaseInfo);
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
      localStringBuilder.append("{").append((String)localEntry.getKey()).append(" ").append(localEntry.getValue()).append("}\n");
    }
    QMLog.w("minisdk-start_LaunchManagerService", "current process count=" + i + " " + localStringBuilder.toString());
  }
  
  private void setIntentFlags(Intent paramIntent, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo.engineType == 0) || (Build.VERSION.SDK_INT < 21))
    {
      paramIntent.addFlags(805371904);
      return;
    }
    paramIntent.addFlags(8192);
    paramIntent.addFlags(524288);
    paramIntent.addFlags(268435456);
    paramIntent.setData(Uri.parse("miniapp://" + paramMiniAppInfo.appId));
  }
  
  private void updateAllMiniAppInfoForProcess(@Nullable MiniAppBaseInfo paramMiniAppBaseInfo, @NonNull Bundle paramBundle, @NonNull LaunchManagerService.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
    paramBundle = paramBundle.getParcelableArrayList("bundle_key_runtime_list");
    if (paramMiniAppBaseInfo != null) {
      paramMiniAppSubProcessorInfo.currentAppInfo = paramMiniAppBaseInfo;
    }
    paramMiniAppSubProcessorInfo.setAllMiniAppInfo(paramMiniAppBaseInfo, paramBundle);
  }
  
  public void forceKillProcess(LaunchManagerService.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo)
  {
    if (paramMiniAppSubProcessorInfo == null) {
      return;
    }
    this.lastKillingProcessor = paramMiniAppSubProcessorInfo;
    QMLog.i("minisdk-start_LaunchManagerService", "kill mini process: " + this.lastKillingProcessor);
    int i = paramMiniAppSubProcessorInfo.pid;
    if (i > 0) {
      try
      {
        if (this.mKillProcessMode == 0)
        {
          QMLog.w("minisdk-start_LaunchManagerService", "kill process by pid:" + i);
          finishAndRemoveTask(paramMiniAppSubProcessorInfo, true);
          Process.killProcess(i);
          cleanProcess(paramMiniAppSubProcessorInfo.processName);
          printProcessStack();
          return;
        }
      }
      catch (Throwable paramMiniAppSubProcessorInfo)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "kill process exception!", paramMiniAppSubProcessorInfo);
        return;
      }
    }
    QMLog.w("minisdk-start_LaunchManagerService", "kill process by broadcast" + paramMiniAppSubProcessorInfo.processName);
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, paramMiniAppSubProcessorInfo.appPreLoadClass);
    this.mContext.sendBroadcast(localIntent);
  }
  
  public IBinder getBinder()
  {
    return this.mServiceBinder;
  }
  
  public LaunchManagerService.MiniAppSubProcessorInfo getCacheApp(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if (paramMiniAppBaseInfo != null) {
      return getCacheApp(paramMiniAppBaseInfo.appId);
    }
    return null;
  }
  
  public LaunchManagerService.MiniAppSubProcessorInfo getCacheApp(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject;
      String str;
      Iterator localIterator2;
      do
      {
        Iterator localIterator1 = this.mProcessStack.snapshot().entrySet().iterator();
        while (!localIterator2.hasNext())
        {
          do
          {
            do
            {
              if (!localIterator1.hasNext()) {
                break;
              }
              localObject = (Map.Entry)localIterator1.next();
            } while (localObject == null);
            str = (String)((Map.Entry)localObject).getKey();
            localObject = (LaunchManagerService.MiniAppSubProcessorInfo)((Map.Entry)localObject).getValue();
          } while ((localObject == null) || (((LaunchManagerService.MiniAppSubProcessorInfo)localObject).allMiniAppInfo.isEmpty()));
          localIterator2 = ((LaunchManagerService.MiniAppSubProcessorInfo)localObject).allMiniAppInfo.iterator();
        }
      } while (!TextUtils.equals(((MiniAppBaseInfo)localIterator2.next()).appId, paramString));
      QMLog.i("minisdk-start_LaunchManagerService", "obtain loaded processor from stack:" + str);
      return localObject;
    }
    return null;
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public void init(Context paramContext)
  {
    if (this.mContext != null) {
      return;
    }
    this.mContext = paramContext;
    this.mProcessPreloadCount = 2;
    this.mProcessGameMaxCount = subGameProcessorInfoMap.size();
    this.appProcessRecycleTime = 1800000L;
    this.gameProcessRecycleTime = 900000L;
    try
    {
      this.mStartTimeInterval = 1500;
      this.mKillProcessMode = 0;
      this.mProcessMaxCount = (subAppProcessorInfoMap.size() + subGameProcessorInfoMap.size());
      this.mProcessStack = new LruCache(this.mProcessMaxCount);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "get config StartTimeInterval exception!", paramContext);
      }
    }
  }
  
  public boolean isMiniProcess(String paramString)
  {
    return subProcessorInfoMap.containsKey(paramString);
  }
  
  public void onAppBackground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    Class localClass = null;
    if (paramBundle != null) {
      paramBundle.setClassLoader(LaunchManagerService.ServiceBinder.class.getClassLoader());
    }
    if (paramMiniAppBaseInfo != null)
    {
      localObject1 = paramMiniAppBaseInfo.appId;
      if (paramMiniAppBaseInfo == null) {
        break label128;
      }
      localObject2 = paramMiniAppBaseInfo.name;
      label36:
      if (paramMiniAppBaseInfo == null) {
        break label134;
      }
    }
    label128:
    label134:
    for (int i = paramMiniAppBaseInfo.getEngineType();; i = -1)
    {
      QMLog.i("minisdk-start_LaunchManagerService", "onAppBackground process=" + paramString + " appId=" + (String)localObject1 + " appName=" + (String)localObject2 + " engineType=" + i + " reportType=" + -1);
      if (!TextUtils.isEmpty(paramString)) {
        break label140;
      }
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label36;
    }
    label140:
    Object localObject2 = (LaunchManagerService.MiniAppSubProcessorInfo)this.mProcessStack.snapshot().get(paramString);
    Object localObject1 = localObject2;
    LaunchManagerService.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo;
    if (localObject2 == null)
    {
      localMiniAppSubProcessorInfo = (LaunchManagerService.MiniAppSubProcessorInfo)subProcessorInfoMap.get(paramString);
      if (localMiniAppSubProcessorInfo == null) {
        break label266;
      }
      localObject1 = localMiniAppSubProcessorInfo.uiClass;
      if (localMiniAppSubProcessorInfo == null) {
        break label272;
      }
    }
    label266:
    label272:
    for (localObject2 = localMiniAppSubProcessorInfo.internalUIClass;; localObject2 = null)
    {
      if (localMiniAppSubProcessorInfo != null) {
        localClass = localMiniAppSubProcessorInfo.appPreLoadClass;
      }
      localObject1 = new LaunchManagerService.MiniAppSubProcessorInfo(this, paramString, (Class)localObject1, (Class)localObject2, localClass, localMiniAppSubProcessorInfo.supportRuntimeType);
      this.mProcessStack.put(paramString, localObject1);
      updateAllMiniAppInfoForProcess(paramMiniAppBaseInfo, paramBundle, (LaunchManagerService.MiniAppSubProcessorInfo)localObject1);
      ((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).onEnterBackground();
      printProcessStack();
      return;
      localObject1 = null;
      break;
    }
  }
  
  public void onAppForeground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
    }
    label34:
    int i;
    if (paramMiniAppBaseInfo != null)
    {
      localObject1 = paramMiniAppBaseInfo.appId;
      if (paramMiniAppBaseInfo == null) {
        break label139;
      }
      localObject2 = paramMiniAppBaseInfo.name;
      if (paramMiniAppBaseInfo == null) {
        break label145;
      }
      i = paramMiniAppBaseInfo.getEngineType();
      label44:
      if (paramBundle == null) {
        break label151;
      }
    }
    label139:
    label145:
    label151:
    for (int j = paramBundle.getInt("PID");; j = 0)
    {
      QMLog.i("minisdk-start_LaunchManagerService", "onAppForeground process=" + paramString + " appId=" + (String)localObject1 + " appName=" + (String)localObject2 + " engineType=" + i + " reportType=" + -1);
      if (!TextUtils.isEmpty(paramString)) {
        break label157;
      }
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label34;
      i = -1;
      break label44;
    }
    label157:
    Object localObject2 = (LaunchManagerService.MiniAppSubProcessorInfo)this.mProcessStack.get(paramString);
    Object localObject1 = localObject2;
    label215:
    Class localClass;
    if (localObject2 == null)
    {
      LaunchManagerService.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (LaunchManagerService.MiniAppSubProcessorInfo)subProcessorInfoMap.get(paramString);
      if (localMiniAppSubProcessorInfo == null) {
        break label348;
      }
      localObject1 = localMiniAppSubProcessorInfo.uiClass;
      if (localMiniAppSubProcessorInfo == null) {
        break label354;
      }
      localObject2 = localMiniAppSubProcessorInfo.internalUIClass;
      if (localMiniAppSubProcessorInfo == null) {
        break label360;
      }
      localClass = localMiniAppSubProcessorInfo.appPreLoadClass;
      label227:
      localObject2 = new LaunchManagerService.MiniAppSubProcessorInfo(this, paramString, (Class)localObject1, (Class)localObject2, localClass, localMiniAppSubProcessorInfo.supportRuntimeType);
      if ((((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).preloadType == null) && (paramMiniAppBaseInfo != null)) {
        if (!paramMiniAppBaseInfo.isEngineTypeMiniApp()) {
          break label366;
        }
      }
    }
    label348:
    label354:
    label360:
    label366:
    for (localObject1 = "preload_app";; localObject1 = "preload_game")
    {
      ((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).preloadType = ((String)localObject1);
      this.mProcessStack.put(paramString, localObject2);
      localObject1 = localObject2;
      updateAllMiniAppInfoForProcess(paramMiniAppBaseInfo, paramBundle, (LaunchManagerService.MiniAppSubProcessorInfo)localObject1);
      if ((this.mStartingMiniAppConfig != null) && (this.mStartingMiniAppConfig.equals(paramMiniAppBaseInfo))) {
        this.mStartingMiniAppConfig = null;
      }
      if (j > 0) {
        ((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).pid = j;
      }
      ((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).onEnterForeground();
      printProcessStack();
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label215;
      localClass = null;
      break label227;
    }
  }
  
  public void onAppStart(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    Object localObject3 = null;
    if (paramBundle != null) {
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
    }
    label37:
    int i;
    if (paramMiniAppBaseInfo != null)
    {
      localObject1 = paramMiniAppBaseInfo.appId;
      if (paramMiniAppBaseInfo == null) {
        break label142;
      }
      localObject2 = paramMiniAppBaseInfo.name;
      if (paramMiniAppBaseInfo == null) {
        break label148;
      }
      i = paramMiniAppBaseInfo.getEngineType();
      label47:
      if (paramBundle == null) {
        break label154;
      }
    }
    label142:
    label148:
    label154:
    for (int j = paramBundle.getInt("PID");; j = 0)
    {
      QMLog.i("minisdk-start_LaunchManagerService", "onAppStart process=" + paramString + " appId=" + (String)localObject1 + " appName=" + (String)localObject2 + " engineType=" + i + " reportType=" + -1);
      if (!TextUtils.isEmpty(paramString)) {
        break label160;
      }
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label37;
      i = -1;
      break label47;
    }
    label160:
    Object localObject2 = (LaunchManagerService.MiniAppSubProcessorInfo)this.mProcessStack.get(paramString);
    Object localObject1 = localObject2;
    label218:
    Class localClass;
    if (localObject2 == null)
    {
      LaunchManagerService.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = (LaunchManagerService.MiniAppSubProcessorInfo)subProcessorInfoMap.get(paramString);
      if (localMiniAppSubProcessorInfo == null) {
        break label393;
      }
      localObject1 = localMiniAppSubProcessorInfo.uiClass;
      if (localMiniAppSubProcessorInfo == null) {
        break label399;
      }
      localObject2 = localMiniAppSubProcessorInfo.internalUIClass;
      if (localMiniAppSubProcessorInfo == null) {
        break label405;
      }
      localClass = localMiniAppSubProcessorInfo.appPreLoadClass;
      label230:
      localObject2 = new LaunchManagerService.MiniAppSubProcessorInfo(this, paramString, (Class)localObject1, (Class)localObject2, localClass, localMiniAppSubProcessorInfo.supportRuntimeType);
      localObject1 = localObject3;
      if (paramBundle != null) {
        localObject1 = paramBundle.getString("mini_key_preload_type", null);
      }
      ((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).preloadType = ((String)localObject1);
      if ((((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).preloadType == null) && (paramMiniAppBaseInfo != null)) {
        if (!paramMiniAppBaseInfo.isEngineTypeMiniApp()) {
          break label411;
        }
      }
    }
    label393:
    label399:
    label405:
    label411:
    for (localObject1 = "preload_app";; localObject1 = "preload_game")
    {
      ((LaunchManagerService.MiniAppSubProcessorInfo)localObject2).preloadType = ((String)localObject1);
      this.mProcessStack.put(paramString, localObject2);
      localObject1 = localObject2;
      updateAllMiniAppInfoForProcess(paramMiniAppBaseInfo, paramBundle, (LaunchManagerService.MiniAppSubProcessorInfo)localObject1);
      ((LaunchManagerService.MiniAppSubProcessorInfo)localObject1).pid = j;
      this.mPreloadingTask.remove(paramString);
      printProcessStack();
      paramString = ProcessUtil.getCurrentProcessName(this.mContext);
      QMLog.i("minisdk-start_LaunchManagerService", "updateBaseLib onAppStart " + paramString);
      updateBaseLib();
      initWnsConfig();
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label218;
      localClass = null;
      break label230;
    }
  }
  
  public void onAppStop(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(LaunchManagerService.ServiceBinder.class.getClassLoader());
    }
    String str1;
    String str2;
    if (paramMiniAppBaseInfo != null)
    {
      str1 = paramMiniAppBaseInfo.appId;
      if (paramMiniAppBaseInfo == null) {
        break label193;
      }
      str2 = paramMiniAppBaseInfo.name;
      label33:
      if (paramMiniAppBaseInfo == null) {
        break label199;
      }
    }
    label193:
    label199:
    for (int i = paramMiniAppBaseInfo.getEngineType();; i = -1)
    {
      if (paramBundle != null) {
        paramBundle.getInt("PID");
      }
      QMLog.i("minisdk-start_LaunchManagerService", "onAppStop process=" + paramString + " appId=" + str1 + " appName=" + str2 + " engineType=" + i + " reportType=" + -1);
      paramMiniAppBaseInfo = (LaunchManagerService.MiniAppSubProcessorInfo)this.mProcessStack.get(paramString);
      if (paramMiniAppBaseInfo == null) {
        break label217;
      }
      paramBundle = paramMiniAppBaseInfo.allMiniAppInfo.iterator();
      while (paramBundle.hasNext()) {
        if (TextUtils.equals(((MiniAppBaseInfo)paramBundle.next()).appId, str1)) {
          paramBundle.remove();
        }
      }
      str1 = null;
      break;
      str2 = null;
      break label33;
    }
    if (paramMiniAppBaseInfo.isIdleProcess()) {
      cleanProcess(paramString);
    }
    label217:
    printProcessStack();
  }
  
  public void onHostAppBackground() {}
  
  public void onPreloadBaseLib(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      getHandler().post(new LaunchManagerService.7(this, paramString1, paramString2));
    }
  }
  
  public void onRecvCommand(String paramString1, String paramString2, Bundle paramBundle)
  {
    QMLog.i("minisdk-start_LaunchManagerService", "onRecvCommand cmd=" + paramString1 + " processName=" + paramString2);
    if ("cmd_notify_runtime_info".equals(paramString1))
    {
      paramString1 = (LaunchManagerService.MiniAppSubProcessorInfo)this.mProcessStack.snapshot().get(paramString2);
      if (paramString1 != null) {
        updateAllMiniAppInfoForProcess(null, paramBundle, paramString1);
      }
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
      paramString1 = paramBundle.getParcelableArrayList("bundle_key_runtime_list");
      if (paramString1 != null)
      {
        Iterator localIterator = paramString1.iterator();
        for (paramString1 = "";; paramString1 = paramString1 + paramBundle.name + ";")
        {
          paramBundle = paramString1;
          if (!localIterator.hasNext()) {
            break;
          }
          paramBundle = (MiniAppInfo)localIterator.next();
        }
      }
      paramBundle = "";
      QMLog.i("minisdk-start_LaunchManagerService", "notify runtime info from process:" + paramString2 + " appsDecc:" + paramBundle);
    }
    for (;;)
    {
      printProcessStack();
      return;
      if ("cmd_notify_runtime_lifecycle".equals(paramString1))
      {
        paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        paramString1 = paramBundle.getString("bundle_key_runtime_lifecycle", "N/A");
        paramBundle = (MiniAppInfo)paramBundle.getParcelable("bundle_key_appinfo");
        QMLog.i("minisdk-start_LaunchManagerService", "notify runtime lifecycle from process:" + paramString2 + " lifecycle:" + paramString1);
        if ((paramBundle != null) && ("first_frame".equals(paramString1))) {
          doPreloadExtraMiniApp(paramBundle);
        }
      }
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
            break label152;
          }
          localObject1 = "preload_app";
          if ((hasPreloadProcess((String)localObject1)) || (!canPreloadProcess((String)localObject1))) {
            continue;
          }
          localMap = this.mProcessStack.snapshot();
          if (!paramBoolean) {
            break label159;
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
        doPreloadApp((LaunchManagerService.MiniAppSubProcessorInfo)localEntry.getValue(), paramBoolean, false, false, null);
        continue;
        localObject3 = "preload_game";
      }
      finally {}
      label152:
      continue;
      label159:
      Object localObject3 = subGameProcessorInfoMap;
    }
  }
  
  public void preloadMiniApp(Bundle paramBundle)
  {
    MiniAppInfo localMiniAppInfo;
    break label270;
    label36:
    int i;
    for (;;)
    {
      try
      {
        paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        localMiniAppInfo = (MiniAppInfo)paramBundle.getParcelable("mini_appinfo");
        if (localMiniAppInfo == null) {
          continue;
        }
        doPreLaunchMiniApp(localMiniAppInfo, paramBundle);
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_LaunchManagerService", "", localThrowable);
        if (paramBundle == null) {
          continue;
        }
        str = paramBundle.getString("mini_key_preload_type");
        if (!needPreloadMiniApp(str)) {
          continue;
        }
        n = this.mProcessPreloadCount - this.mProcessStack.size();
        if (n <= 0) {
          continue;
        }
        localObject = ProcessUtil.getCurrentProcessName(this.mContext);
        QMLog.i("minisdk-start_LaunchManagerService", "updateBaseLib preloadMiniApp " + (String)localObject + ", process count=" + n);
        printProcessStack();
        updateBaseLib();
        localObject = this.mProcessStack.snapshot();
        if (str != null) {
          continue;
        }
        i = 1;
        if (!"preload_app".equals(str)) {
          continue;
        }
        j = 1;
        if (!"preload_game".equals(str)) {
          continue;
        }
        k = 1;
        break label267;
        doPreloadApp((Map)localObject, bool, paramBundle);
        n -= 1;
        m = i1;
        break label270;
        str = null;
        continue;
        i = 0;
        continue;
        j = 0;
        continue;
        k = 0;
        break label267;
        bool = false;
      }
      finally {}
      return;
      i = paramBundle.getInt("mini_key_preload_runtime_type", 0);
      if (i <= 0) {
        continue;
      }
      doPreloadByRuntimeType(i);
    }
    for (;;)
    {
      String str;
      int n;
      Object localObject;
      int j;
      int k;
      boolean bool;
      int i1;
      label267:
      int m = 0;
      label270:
      if (n <= 0) {
        break label36;
      }
      if (m % 2 == 0)
      {
        bool = true;
        i1 = m + 1;
        if (((!bool) || (j == 0)) && ((bool) || (k == 0)))
        {
          m = i1;
          if (i == 0) {
            break;
          }
        }
      }
    }
  }
  
  public void registerClientMessenger(String paramString, Messenger paramMessenger)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMessenger == null)) {
      return;
    }
    QMLog.w("minisdk-start_LaunchManagerService", "registerClientMessenger pName=" + paramString + " messenger:" + paramMessenger);
    this.mClientMessengerMap.put(paramString, paramMessenger);
  }
  
  public void registerProcessInfo(List<MiniProcessorConfig> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MiniProcessorConfig localMiniProcessorConfig = (MiniProcessorConfig)paramList.next();
        if ((localMiniProcessorConfig != null) && (!TextUtils.isEmpty(localMiniProcessorConfig.processName)))
        {
          LaunchManagerService.MiniAppSubProcessorInfo localMiniAppSubProcessorInfo = new LaunchManagerService.MiniAppSubProcessorInfo(this, localMiniProcessorConfig.processName, localMiniProcessorConfig.processType, localMiniProcessorConfig.appUIClass, localMiniProcessorConfig.internalUIClass, localMiniProcessorConfig.appPreLoadClass, localMiniProcessorConfig.supportRuntimeType);
          QMLog.i("minisdk-start_LaunchManagerService", "registerProcessInfo " + localMiniProcessorConfig);
          switch (LaunchManagerService.9.$SwitchMap$com$tencent$qqmini$sdk$launcher$shell$ProcessType[localMiniProcessorConfig.processType.ordinal()])
          {
          default: 
            break;
          case 1: 
            if (localMiniProcessorConfig.appUIClass != null)
            {
              subAppProcessorInfoMap.put(localMiniProcessorConfig.processName, localMiniAppSubProcessorInfo);
              subProcessorInfoMap.put(localMiniProcessorConfig.processName, localMiniAppSubProcessorInfo);
            }
            break;
          case 2: 
            if (localMiniProcessorConfig.appUIClass != null)
            {
              subGameProcessorInfoMap.put(localMiniProcessorConfig.processName, localMiniAppSubProcessorInfo);
              subProcessorInfoMap.put(localMiniProcessorConfig.processName, localMiniAppSubProcessorInfo);
            }
            break;
          case 3: 
            if (localMiniProcessorConfig.appUIClass != null)
            {
              sInternalProcessInfo = localMiniAppSubProcessorInfo;
              subProcessorInfoMap.put(localMiniProcessorConfig.processName, localMiniAppSubProcessorInfo);
            }
            break;
          }
        }
      }
    }
  }
  
  public boolean sendCmdToMiniProcess(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "sendCmdToMiniProcess failed! miniAppInfo is null.");
      return false;
    }
    Object localObject = findMiniAppProcessInfo(paramMiniAppInfo);
    if ((localObject == null) || (TextUtils.isEmpty(((LaunchManagerService.MiniAppSubProcessorInfo)localObject).processName)))
    {
      QMLog.e("minisdk-start_LaunchManagerService", "sendCmdToMiniProcess failed! Has no processor info.");
      return false;
    }
    Messenger localMessenger = (Messenger)this.mClientMessengerMap.get(((LaunchManagerService.MiniAppSubProcessorInfo)localObject).processName);
    if (localMessenger == null)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "sendCmdToMiniProcess failed! Messenger is null.");
      return false;
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    ((Bundle)localObject).putParcelable("KEY_APPINFO", paramMiniAppInfo);
    if (paramResultReceiver != null) {
      ((Bundle)localObject).putParcelable("receiver", paramResultReceiver);
    }
    localMessage.setData((Bundle)localObject);
    try
    {
      QMLog.i("minisdk-start_LaunchManagerService", "Messenger sendCmdToMiniProcess cmd=" + paramInt);
      localMessenger.send(localMessage);
      return true;
    }
    catch (Throwable paramBundle)
    {
      QMLog.e("minisdk-start_LaunchManagerService", "Messenger sendCmdToMiniProcess exception!", paramBundle);
      if (paramResultReceiver != null) {
        paramResultReceiver.send(-1, new Bundle());
      }
    }
    return false;
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppInfo == null) {
      QMLog.e("minisdk-start_LaunchManagerService", "startMiniApp params is empty! ,appConfig=" + paramMiniAppInfo + " Activity=" + paramActivity);
    }
    do
    {
      return;
      this.mMiniAppUsed = true;
      QMLog.i("minisdk-start_LaunchManagerService", "---startApp---- appid:" + paramMiniAppInfo.appId + " appName:" + paramMiniAppInfo.name);
      checkAndCleanAllMiniProcess();
      doStartMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      if ((paramActivity != null) && (paramMiniAppInfo != null) && (paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.launchParam.scene != 2004)) {
        paramActivity.overridePendingTransition(R.anim.mini_sdk_activity_slide_in_from_bottom, R.anim.mini_sdk_activity_slide_out_to_back);
      }
    } while ((paramMiniAppInfo.isFakeAppInfo()) || (paramMiniAppInfo.isShortcutFakeApp()));
    paramResultReceiver = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (paramMiniAppInfo.launchParam != null)
    {
      paramActivity = String.valueOf(paramMiniAppInfo.launchParam.scene);
      if (paramMiniAppInfo.via == null) {
        break label227;
      }
    }
    label227:
    for (paramBundle = paramMiniAppInfo.via;; paramBundle = "")
    {
      paramResultReceiver.useUserApp(paramMiniAppInfo.appId, paramMiniAppInfo.verType, 0, paramActivity, paramBundle, null, new LaunchManagerService.3(this));
      return;
      paramActivity = "";
      break;
    }
  }
  
  public void stopAllMiniApp()
  {
    Iterator localIterator = this.mProcessStack.snapshot().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        String str = (String)localEntry.getKey();
        forceKillProcess((LaunchManagerService.MiniAppSubProcessorInfo)localEntry.getValue());
        cleanProcess(str);
      }
    }
  }
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo = getCacheApp(paramMiniAppInfo);
    if (paramMiniAppInfo != null) {
      forceKillProcess(paramMiniAppInfo);
    }
  }
  
  public void stopMiniApp(String paramString)
  {
    paramString = getCacheApp(paramString);
    if (paramString != null) {
      forceKillProcess(paramString);
    }
  }
  
  /* Error */
  public void updateBaseLib()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 1271	com/tencent/qqmini/sdk/utils/QUAUtil:isQQMainApp	()Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifeq +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: invokestatic 1276	com/tencent/qqmini/sdk/manager/BaseLibManager:g	()Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   16: new 1278	com/tencent/qqmini/sdk/server/LaunchManagerService$8
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 1279	com/tencent/qqmini/sdk/server/LaunchManagerService$8:<init>	(Lcom/tencent/qqmini/sdk/server/LaunchManagerService;)V
    //   24: invokevirtual 1282	com/tencent/qqmini/sdk/manager/BaseLibManager:updateBaseLib	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;)V
    //   27: goto -17 -> 10
    //   30: astore_2
    //   31: ldc 31
    //   33: ldc_w 1284
    //   36: aload_2
    //   37: invokestatic 283	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   40: goto -30 -> 10
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	LaunchManagerService
    //   5	2	1	bool	boolean
    //   30	7	2	localThrowable	Throwable
    //   43	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	27	30	java/lang/Throwable
    //   2	6	43	finally
    //   13	27	43	finally
    //   31	40	43	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService
 * JD-Core Version:    0.7.0.1
 */