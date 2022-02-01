package com.tencent.mobileqq.mini.launch;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.RenderInfo;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoEntity;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04746;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.tissue.TissueEnvImpl;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.report.MiniGameBeaconReport;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter;
import com.tencent.mobileqq.minigame.utils.CPUUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSdkUtil;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class AppBrandLaunchManager
  implements IAppLaunch
{
  private static final int KILL_MODE_PID = 0;
  private static final int KILL__MODE_BROADCAST = 1;
  private static final int MINI_APP_PROCESS_DETECT_TIME_DEFAULT = 600000;
  private static final long MINI_APP_USED_DURATION_MS = TimeUnit.HOURS.toMillis(36L);
  private static final String TAG = "miniapp-process_AppBrandLaunchManager";
  private static AppBrandLaunchManager instance;
  private static byte[] lock = new byte[0];
  private int hardCoderTimeout = 0;
  private final Runnable mCheckPreloadRunnable = new AppBrandLaunchManager.11(this);
  private Context mContext = BaseApplicationImpl.getApplication();
  protected Handler mHandler = new Handler(ThreadManager.getSubThreadHandler().getLooper());
  private int mKillProcessMode = 0;
  private long mLastPreloadDetectTime;
  private long mMiniAppLastUseTimeStamp;
  private long mStartTimestamp;
  private ConcurrentHashMap<String, AppBrandLaunchManager.RecommendRunnable> recommendMap = new ConcurrentHashMap();
  
  private AppBrandLaunchManager()
  {
    try
    {
      this.mKillProcessMode = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_process_kill_mode", 0);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "get config StartTimeInterval exception!", localThrowable);
    }
    this.mMiniAppLastUseTimeStamp = StorageUtil.getPreference().getLong("key_mini_app_last_use_time", 0L);
    getHandler().postDelayed(new AppBrandLaunchManager.1(this), 10000L);
    MiniGameBeaconReport.init();
    this.hardCoderTimeout = WnsConfig.getConfig("qqminiapp", "mini_app_hard_coder_timeout", 10000);
  }
  
  private void checkPreload()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkPreload MiniAppUsed:");
    localStringBuilder.append(isMiniAppUsed());
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, localStringBuilder.toString());
    try
    {
      if (isMiniAppUsed())
      {
        this.mLastPreloadDetectTime = System.currentTimeMillis();
        checkPreloadMiniGame();
        MiniSdkLauncher.preloadMiniApp(this.mContext, true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "", localThrowable);
    }
  }
  
  private void doFetchPeriodicCache()
  {
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, "start update periodicCache.");
    for (;;)
    {
      try
      {
        Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject1 instanceof QQAppInterface))
        {
          localObject1 = ((MiniAppEntityManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER)).queryEntity(MiniAppInfoEntity.class, false, null, null, null, null, null, null);
          if (localObject1 != null)
          {
            if (((List)localObject1).size() <= 0) {
              return;
            }
            localObject1 = ((List)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (MiniAppInfoEntity)((Iterator)localObject1).next();
              INTERFACE.StApiAppInfo localStApiAppInfo = new INTERFACE.StApiAppInfo();
              localStApiAppInfo.mergeFrom(((MiniAppInfoEntity)localObject2).appInfo);
              localObject2 = com.tencent.mobileqq.mini.apkg.MiniAppInfo.from(localStApiAppInfo);
              if (new MiniAppConfig((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2).isEngineTypeMiniGame()) {
                break label178;
              }
              bool = true;
              if (!MiniSdkUtil.a(bool)) {
                continue;
              }
              localObject2 = MiniSdkLauncher.convert((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2);
              MiniSDK.init(this.mContext);
              AppLoaderFactory.g().getCommonManager().fetchPeriodicCacheIfNeed((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject2);
              continue;
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, localThrowable, new Object[0]);
      }
      return;
      label178:
      boolean bool = false;
    }
  }
  
  private void doPreloadApp(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (MiniSdkUtil.a(paramBoolean1))
    {
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, "doPreloadApp needJumpToMiniSDK");
      MiniSdkLauncher.preloadMiniApp(BaseApplicationImpl.getContext(), paramBoolean1);
    }
  }
  
  @SuppressLint({"WrongConstant"})
  private void doStartMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppConfig != null)
    {
      if (paramMiniAppConfig.config == null) {
        return;
      }
      Object localObject;
      if (WnsConfig.getConfig("qqminiapp", "mini_app_hard_coder_enabled", true))
      {
        int i = HardCoderManager.getInstance().start(0, 1, 1, Process.myTid(), this.hardCoderTimeout, 601, 1L, Process.myTid(), "miniLaunch");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hard coder started, reqId: ");
        ((StringBuilder)localObject).append(i);
        QMLog.w("miniapp-process_AppBrandLaunchManager", ((StringBuilder)localObject).toString());
      }
      else
      {
        QMLog.w("miniapp-process_AppBrandLaunchManager", "hard coder disabled");
      }
      boolean bool = paramMiniAppConfig.isEngineTypeMiniGame() ^ true;
      if ((paramMiniAppConfig.config.renderInfo != null) && (paramMiniAppConfig.config.renderInfo.renderMode == 1) && (paramMiniAppConfig.config.renderInfo.renderMaterialMap.get(Integer.valueOf(1)) != null) && (enableFlutter()) && (MiniSdkUtil.a(bool)))
      {
        paramMiniAppConfig.isSdkMode = true;
        localObject = new Bundle();
        ((Bundle)localObject).putString("tissuenativelibdir", TissueEnvImpl.getNativeLibDir());
        MiniSdkLauncher.startMiniApp(paramActivity, paramMiniAppConfig, (Bundle)localObject, paramResultReceiver);
        if ((!paramMiniAppConfig.isEngineTypeMiniGame()) && (paramMiniAppConfig.launchParam.scene != 2004)) {
          AnimUtil.setOpenAnim(paramActivity);
        }
        return;
      }
      if (MiniSdkUtil.a(bool))
      {
        localObject = null;
        if (bool)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("sdk_mode", true);
        }
        paramMiniAppConfig.isSdkMode = true;
        MiniSdkLauncher.startMiniApp(paramActivity, paramMiniAppConfig, (Bundle)localObject, paramResultReceiver);
        getHandler().postDelayed(new AppBrandLaunchManager.5(this), 1000L);
      }
    }
  }
  
  private boolean enableFlutter()
  {
    Object localObject = QzoneConfig.getInstance();
    boolean bool4 = false;
    boolean bool1;
    if (((QzoneConfig)localObject).getConfig("qqminiapp", "mini_flutter_enable", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((!TextUtils.isEmpty(TissueEnvImpl.getNativeLibDir())) && (TissueEnvImpl.verifyTissueEngine(TissueEnvImpl.getNativeLibDir()))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" enableFlutter enable:");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(",envReady:");
    ((StringBuilder)localObject).append(bool2);
    QZLog.i("Tissue", ((StringBuilder)localObject).toString());
    boolean bool3 = bool4;
    if (bool1)
    {
      bool3 = bool4;
      if (bool2) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  private void fetchPeriodicCache()
  {
    doFetchPeriodicCache();
    getHandler().postDelayed(new AppBrandLaunchManager.2(this), 7200000L);
  }
  
  public static AppBrandLaunchManager g()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new AppBrandLaunchManager();
        }
      }
    }
    return instance;
  }
  
  private static void handleStartMiniappByBroadcast(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo, int paramInt, String paramString)
  {
    if (paramMiniAppInfo != null) {
      try
      {
        MiniAppConfig localMiniAppConfig = new MiniAppConfig(paramMiniAppInfo);
        localMiniAppConfig.launchParam = new LaunchParam();
        localMiniAppConfig.launchParam.miniAppId = paramMiniAppInfo.appId;
        localMiniAppConfig.launchParam.scene = 2016;
        localMiniAppConfig.launchParam.shareTicket = paramString;
        if ((paramInt != 1) && (paramInt == 3)) {
          localMiniAppConfig.launchParam.forceReload = 3;
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
  
  private void notifyDesktop()
  {
    getHandler().postDelayed(new AppBrandLaunchManager.12(this), 600L);
  }
  
  private void preDownloadPkgCallback(int paramInt, String paramString, IMiniCallback paramIMiniCallback)
  {
    if (paramIMiniCallback == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("retCode", paramInt);
    localBundle.putString("errMsg", paramString);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramIMiniCallback.onCallbackResult(bool, localBundle);
  }
  
  private void prelaunchLatestMiniApp()
  {
    for (;;)
    {
      try
      {
        if (!MiniSdkUtil.a(true)) {
          return;
        }
        if (MiniAppConfProcessor.a("mini_sdk_prelaunch_all_enable", 1) != 1) {
          break label242;
        }
        i = 1;
        if (i == 0)
        {
          QLog.i("miniapp-process_AppBrandLaunchManager", 1, "prelaunchLatestMiniApp disable");
          return;
        }
        QLog.i("miniapp-process_AppBrandLaunchManager", 1, "prelaunch Latest MiniApp.");
        Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject1 instanceof QQAppInterface))
        {
          localObject1 = ((MiniAppEntityManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER)).queryEntity(MiniAppInfoEntity.class, false, null, null, null, null, null, null);
          if (localObject1 != null)
          {
            if (((List)localObject1).size() <= 0) {
              return;
            }
            localObject1 = ((List)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (MiniAppInfoEntity)((Iterator)localObject1).next();
              Object localObject3 = new INTERFACE.StApiAppInfo();
              ((INTERFACE.StApiAppInfo)localObject3).mergeFrom(((MiniAppInfoEntity)localObject2).appInfo);
              localObject2 = com.tencent.mobileqq.mini.apkg.MiniAppInfo.from((INTERFACE.StApiAppInfo)localObject3);
              localObject3 = new MiniAppConfig((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2);
              if ((!(((MiniAppConfig)localObject3).isEngineTypeMiniGame() ^ true)) || ("1108291530".equals(((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2).appId))) {
                continue;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("prelaunch MiniApp appid=");
              ((StringBuilder)localObject1).append(((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2).appId);
              QLog.i("miniapp-process_AppBrandLaunchManager", 1, ((StringBuilder)localObject1).toString());
              MiniSdkLauncher.preLaunchMiniApp(this.mContext, (MiniAppConfig)localObject3);
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, localThrowable, new Object[0]);
      }
      return;
      label242:
      int i = 0;
    }
  }
  
  private void registerStartMiniAppReceiver(Context paramContext)
  {
    if (this.mContext == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("registerStartMiniAppReceiver, context = ");
      ((StringBuilder)localObject).append(paramContext);
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.mobileqq.miniapp.debugger");
    paramContext.registerReceiver(new AppBrandLaunchManager.StartMiniAppReceiver(null), (IntentFilter)localObject);
  }
  
  private void removeRecommendCallback(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      Object localObject = this.recommendMap;
      if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(paramMiniAppConfig.config.appId)))
      {
        localObject = (AppBrandLaunchManager.RecommendRunnable)this.recommendMap.remove(paramMiniAppConfig.config.appId);
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeCallbacks recommendRunnable : ");
          localStringBuilder.append(paramMiniAppConfig.config.appId);
          QLog.e("miniapp-process_AppBrandLaunchManager", 2, localStringBuilder.toString());
          ThreadManager.getSubThreadHandler().removeCallbacks((Runnable)localObject);
        }
      }
    }
  }
  
  public void checkPreloadApp()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkPreloadApp MiniAppUsed:");
    localStringBuilder.append(isMiniAppUsed());
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, localStringBuilder.toString());
    for (;;)
    {
      try
      {
        if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_preload_extra", 1) <= 0) {
          break label86;
        }
        i = 1;
        if ((i != 0) && (isMiniAppUsed()))
        {
          MiniSdkLauncher.preloadMiniApp(this.mContext, true);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, "", localThrowable);
      }
      return;
      label86:
      int i = 0;
    }
  }
  
  public boolean checkPreloadMiniGame()
  {
    boolean bool = MiniSdkUtil.a(BaseApplicationImpl.getContext());
    if (!bool) {
      MiniSdkLauncher.preloadMiniApp(this.mContext, false);
    }
    return bool ^ true;
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public boolean isMiniAppUsed()
  {
    return System.currentTimeMillis() - this.mMiniAppLastUseTimeStamp < MINI_APP_USED_DURATION_MS;
  }
  
  public void markMiniAppUsed()
  {
    this.mMiniAppLastUseTimeStamp = System.currentTimeMillis();
    StorageUtil.getPreference().edit().putLong("key_mini_app_last_use_time", this.mMiniAppLastUseTimeStamp).apply();
  }
  
  public void onAppBackground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    MiniAppUtils.updateMiniAppList(7);
    removeRecommendCallback(paramMiniAppConfig);
    if ((paramMiniAppConfig != null) && (MiniSdkUtil.a(paramMiniAppConfig.isEngineTypeMiniGame() ^ true))) {}
  }
  
  public void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    notifyDesktop();
    if ((paramMiniAppConfig != null) && (MiniSdkUtil.a(paramMiniAppConfig.isEngineTypeMiniGame() ^ true))) {}
  }
  
  public void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    if ((paramMiniAppConfig != null) && (MiniSdkUtil.a(paramMiniAppConfig.isEngineTypeMiniGame() ^ true))) {}
  }
  
  public void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    if ((paramMiniAppConfig != null) && (MiniSdkUtil.a(paramMiniAppConfig.isEngineTypeMiniGame() ^ true))) {}
  }
  
  public void onEnterForeground()
  {
    long l = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_process_detect_time", 600000);
    if ((System.currentTimeMillis() - this.mLastPreloadDetectTime > l) && (isMiniAppUsed()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doProcessDetect MiniAppUsed:");
      localStringBuilder.append(isMiniAppUsed());
      localStringBuilder.append(" lastTime:");
      localStringBuilder.append(this.mLastPreloadDetectTime);
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, localStringBuilder.toString());
      getHandler().postDelayed(this.mCheckPreloadRunnable, 3000L);
    }
  }
  
  public void onMiniAppUIOpen()
  {
    if ((System.currentTimeMillis() - this.mLastPreloadDetectTime > 10000L) && (isMiniAppUsed()))
    {
      getHandler().removeCallbacks(this.mCheckPreloadRunnable);
      getHandler().post(this.mCheckPreloadRunnable);
    }
  }
  
  public void preDownloadPkg(String paramString1, String paramString2, IMiniCallback paramIMiniCallback)
  {
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, "", paramString2, new AppBrandLaunchManager.9(this, paramIMiniCallback));
  }
  
  public void preLaunchMiniApp(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig == null) {
      return;
    }
    boolean bool = paramMiniAppConfig.isEngineTypeMiniGame() ^ true;
    if ((bool) && (MiniSdkUtil.a(bool))) {
      MiniSdkLauncher.preLaunchMiniApp(paramContext, paramMiniAppConfig);
    }
  }
  
  public void preloadMiniApp()
  {
    try
    {
      boolean bool = CPUUtil.sIsX86Emulator;
      if (bool) {
        return;
      }
      updateBaseLib();
      ThreadManagerV2.executeOnFileThread(new AppBrandLaunchManager.3(this));
      doPreloadApp(false, true);
      doPreloadApp(true, true);
      long l = MiniAppConfProcessor.a("mini_sdk_prelaunch_all_delay_time", 60000);
      ThreadManager.getFileThreadHandler().postDelayed(new AppBrandLaunchManager.4(this), l);
      if ((SplashMiniGameStarter.hasPreloaded) && (SplashMiniGameStarter.curData != null)) {
        if (SplashMiniGameStarter.hasClickJumpBtn) {
          MiniProgramLpReportDC04746.report(SplashMiniGameStarter.curData.appId, SplashMiniGameStarter.curData.version, 1, 1);
        } else {
          MiniProgramLpReportDC04746.report(SplashMiniGameStarter.curData.appId, SplashMiniGameStarter.curData.version, 1, 0);
        }
      }
      return;
    }
    finally {}
  }
  
  public void preloadPackage(@NonNull com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo) {}
  
  public void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    MiniAppCmdServlet.g().onMiniAppCmd(paramString, paramBundle, paramCmdCallback);
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppConfig == null)
    {
      paramResultReceiver = new StringBuilder();
      paramResultReceiver.append("startMiniApp params is empty! ,appConfig=");
      paramResultReceiver.append(paramMiniAppConfig);
      paramResultReceiver.append(" Activity=");
      paramResultReceiver.append(paramActivity);
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, paramResultReceiver.toString());
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[MiniEng]startMiniApp. ");
    localStringBuilder1.append(paramMiniAppConfig.config.name);
    localStringBuilder1.append(",size=");
    localStringBuilder1.append(paramMiniAppConfig.config.fileSize);
    localStringBuilder1.append(", versionId:");
    localStringBuilder1.append(paramMiniAppConfig.config.versionId);
    localStringBuilder1.append(", versionUpdateTime:");
    localStringBuilder1.append(paramMiniAppConfig.config.versionUpdateTime);
    localStringBuilder1.append(" fromProcess=");
    localStringBuilder1.append(BaseApplicationImpl.getApplication().getQQProcessName());
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, localStringBuilder1.toString());
    if ((paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      if ((paramMiniAppConfig.launchParam != null) && (paramMiniAppConfig.launchParam.scene != 9999))
      {
        if (paramMiniAppConfig.config.verType != 3)
        {
          if (!TextUtils.isEmpty(paramMiniAppConfig.config.ide_scene)) {
            try
            {
              int i = Integer.parseInt(paramMiniAppConfig.config.ide_scene);
              paramMiniAppConfig.launchParam.scene = i;
            }
            catch (Exception localException)
            {
              QLog.e("miniapp-process_AppBrandLaunchManager", 1, "parse ide scene fail", localException);
            }
          }
          if (!TextUtils.isEmpty(paramMiniAppConfig.config.ide_extraAppid)) {
            paramMiniAppConfig.launchParam.fromMiniAppId = paramMiniAppConfig.config.ide_extraAppid;
          }
          if (!TextUtils.isEmpty(paramMiniAppConfig.config.ide_extraData)) {
            paramMiniAppConfig.launchParam.navigateExtData = paramMiniAppConfig.config.ide_extraData;
          }
        }
        markMiniAppUsed();
        if ((paramMiniAppConfig.config.firstPage != null) && (paramMiniAppConfig.launchParam != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.firstPage.pagePath)))
        {
          if (paramMiniAppConfig.config.firstPage.pagePath.startsWith("/")) {
            paramMiniAppConfig.config.firstPage.pagePath = paramMiniAppConfig.config.firstPage.pagePath.substring(1);
          }
          if (paramMiniAppConfig.config.firstPage.pagePath.contains(".html"))
          {
            paramMiniAppConfig.launchParam.entryPath = paramMiniAppConfig.config.firstPage.pagePath;
          }
          else if (paramMiniAppConfig.config.firstPage.pagePath.contains("?"))
          {
            paramMiniAppConfig.launchParam.entryPath = paramMiniAppConfig.config.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
          }
          else
          {
            localObject = paramMiniAppConfig.launchParam;
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(paramMiniAppConfig.config.firstPage.pagePath);
            localStringBuilder2.append(".html");
            ((LaunchParam)localObject).entryPath = localStringBuilder2.toString();
          }
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("---startApp----");
        if (paramMiniAppConfig.launchParam != null) {
          localObject = paramMiniAppConfig.launchParam.entryPath;
        } else {
          localObject = "N/A";
        }
        localStringBuilder2.append((String)localObject);
        QLog.i("miniapp-start", 1, localStringBuilder2.toString());
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("---startApp---- appid:");
        ((StringBuilder)localObject).append(paramMiniAppConfig.config.appId);
        ((StringBuilder)localObject).append(" appName:");
        ((StringBuilder)localObject).append(paramMiniAppConfig.config.name);
        QLog.i("miniapp-start", 1, ((StringBuilder)localObject).toString());
        doStartMiniApp(paramActivity, paramMiniAppConfig, paramResultReceiver);
        MiniAppUtils.preFetchAppCacheData(paramActivity, paramMiniAppConfig.config);
        if (paramMiniAppConfig.isEngineTypeMiniGame()) {
          AnimUtil.clearAnim(paramActivity);
        } else if (paramMiniAppConfig.launchParam.scene != 2004) {
          AnimUtil.setOpenAnim(paramActivity);
        }
        if ((!paramMiniAppConfig.isFromShowInfo()) && (!paramMiniAppConfig.isShortcutFakeApp())) {
          MiniAppUtils.updatePullDownEntryListData(paramMiniAppConfig);
        }
        return;
      }
      AppBrandTask.runTaskOnUiThread(new AppBrandLaunchManager.7(this, paramMiniAppConfig));
      return;
    }
    AppBrandTask.runTaskOnUiThread(new AppBrandLaunchManager.6(this, paramMiniAppConfig, paramActivity));
  }
  
  /* Error */
  public void updateBaseLib()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 891	com/tencent/mobileqq/mini/apkg/BaseLibManager:g	()Lcom/tencent/mobileqq/mini/apkg/BaseLibManager;
    //   5: new 893	com/tencent/mobileqq/mini/launch/AppBrandLaunchManager$10
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 894	com/tencent/mobileqq/mini/launch/AppBrandLaunchManager$10:<init>	(Lcom/tencent/mobileqq/mini/launch/AppBrandLaunchManager;)V
    //   13: invokevirtual 897	com/tencent/mobileqq/mini/apkg/BaseLibManager:updateBaseLib	(Lcom/tencent/mobileqq/mini/apkg/BaseLibManager$UpdateListener;)V
    //   16: goto +18 -> 34
    //   19: astore_1
    //   20: goto +17 -> 37
    //   23: astore_1
    //   24: ldc 19
    //   26: iconst_1
    //   27: ldc_w 899
    //   30: aload_1
    //   31: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	AppBrandLaunchManager
    //   19	1	1	localObject	Object
    //   23	17	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
    //   24	34	19	finally
    //   2	16	23	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager
 * JD-Core Version:    0.7.0.1
 */