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
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.RenderInfo;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoEntity;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04746;
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
  private final Runnable mCheckPreloadRunnable = new AppBrandLaunchManager.10(this);
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
      this.mMiniAppLastUseTimeStamp = StorageUtil.getPreference().getLong("key_mini_app_last_use_time", 0L);
      getHandler().postDelayed(new AppBrandLaunchManager.1(this), 10000L);
      MiniGameBeaconReport.init();
      this.hardCoderTimeout = WnsConfig.getConfig("qqminiapp", "mini_app_hard_coder_timeout", 10000);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, "get config StartTimeInterval exception!", localThrowable);
      }
    }
  }
  
  private void checkPreload()
  {
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, "checkPreload MiniAppUsed:" + isMiniAppUsed());
    try
    {
      if (isMiniAppUsed())
      {
        this.mLastPreloadDetectTime = System.currentTimeMillis();
        MiniSdkLauncher.preloadMiniApp(this.mContext, true);
      }
      return;
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
        if (!(localObject1 instanceof QQAppInterface)) {
          break;
        }
        localObject1 = ((MiniAppEntityManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER)).queryEntity(MiniAppInfoEntity.class, false, null, null, null, null, null, null);
        if (localObject1 == null) {
          break;
        }
        if (((List)localObject1).size() <= 0) {
          return;
        }
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = (MiniAppInfoEntity)((Iterator)localObject1).next();
        INTERFACE.StApiAppInfo localStApiAppInfo = new INTERFACE.StApiAppInfo();
        localStApiAppInfo.mergeFrom(((MiniAppInfoEntity)localObject2).appInfo);
        localObject2 = com.tencent.mobileqq.mini.apkg.MiniAppInfo.from(localStApiAppInfo);
        boolean bool;
        if (!new MiniAppConfig((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2).isEngineTypeMiniGame())
        {
          bool = true;
          if (MiniSdkUtil.a(bool))
          {
            localObject2 = MiniSdkLauncher.convert((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2);
            MiniSDK.init(this.mContext);
            AppLoaderFactory.g().getCommonManager().fetchPeriodicCacheIfNeed((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject2);
          }
        }
        else
        {
          bool = false;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, localThrowable, new Object[0]);
        return;
      }
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
    boolean bool = false;
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {}
    label217:
    do
    {
      return;
      if (WnsConfig.getConfig("qqminiapp", "mini_app_hard_coder_enabled", true))
      {
        int i = HardCoderManager.a().a(0, 1, 1, Process.myTid(), this.hardCoderTimeout, 601, 1L, Process.myTid(), "miniLaunch");
        QMLog.w("miniapp-process_AppBrandLaunchManager", "hard coder started, reqId: " + i);
      }
      for (;;)
      {
        if (!paramMiniAppConfig.isEngineTypeMiniGame()) {
          bool = true;
        }
        if ((paramMiniAppConfig.config.renderInfo == null) || (paramMiniAppConfig.config.renderInfo.renderMode != 1) || (paramMiniAppConfig.config.renderInfo.renderMaterialMap.get(Integer.valueOf(1)) == null) || (!enableFlutter()) || (!MiniSdkUtil.a(bool))) {
          break label217;
        }
        paramMiniAppConfig.isSdkMode = true;
        paramResultReceiver = new Bundle();
        paramResultReceiver.putString("tissuenativelibdir", TissueEnvImpl.getNativeLibDir());
        MiniSdkLauncher.startMiniApp(paramActivity, paramMiniAppConfig, paramResultReceiver);
        if ((paramMiniAppConfig.isEngineTypeMiniGame()) || (paramMiniAppConfig.launchParam.scene == 2004)) {
          break;
        }
        AnimUtil.setOpenAnim(paramActivity);
        return;
        QMLog.w("miniapp-process_AppBrandLaunchManager", "hard coder disabled");
      }
    } while (!MiniSdkUtil.a(bool));
    paramResultReceiver = null;
    if (bool)
    {
      paramResultReceiver = new Bundle();
      paramResultReceiver.putBoolean("sdk_mode", true);
    }
    paramMiniAppConfig.isSdkMode = true;
    MiniSdkLauncher.startMiniApp(paramActivity, paramMiniAppConfig, paramResultReceiver);
    getHandler().postDelayed(new AppBrandLaunchManager.5(this), 1000L);
  }
  
  private boolean enableFlutter()
  {
    boolean bool1;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_flutter_enable", 0) == 1)
    {
      bool1 = true;
      if ((TextUtils.isEmpty(TissueEnvImpl.getNativeLibDir())) || (!TissueEnvImpl.verifyTissueEngine(TissueEnvImpl.getNativeLibDir()))) {
        break label89;
      }
    }
    label89:
    for (boolean bool2 = true;; bool2 = false)
    {
      QZLog.i("Tissue", " enableFlutter enable:" + bool1 + ",envReady:" + bool2);
      if ((!bool1) || (!bool2)) {
        break label94;
      }
      return true;
      bool1 = false;
      break;
    }
    label94:
    return false;
  }
  
  private void fetchPeriodicCache()
  {
    doFetchPeriodicCache();
    getHandler().postDelayed(new AppBrandLaunchManager.2(this), 7200000L);
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
        if (paramInt == 1) {}
        for (;;)
        {
          MiniAppController.startApp(null, localMiniAppConfig, null);
          return;
          if (paramInt == 3) {
            localMiniAppConfig.forceReroad = 3;
          }
        }
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
    getHandler().postDelayed(new AppBrandLaunchManager.11(this), 600L);
  }
  
  private void prelaunchLatestMiniApp()
  {
    int i;
    for (;;)
    {
      try
      {
        if (!MiniSdkUtil.a(true)) {
          return;
        }
        if (MiniAppConfProcessor.a("mini_sdk_prelaunch_all_enable", 1) == 1)
        {
          i = 1;
          if (i != 0) {
            break;
          }
          QLog.i("miniapp-process_AppBrandLaunchManager", 1, "prelaunchLatestMiniApp disable");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 1, localThrowable, new Object[0]);
        return;
      }
      i = 0;
    }
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, "prelaunch Latest MiniApp.");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = ((MiniAppEntityManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER)).queryEntity(MiniAppInfoEntity.class, false, null, null, null, null, null, null);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (MiniAppInfoEntity)((Iterator)localObject1).next();
          Object localObject3 = new INTERFACE.StApiAppInfo();
          ((INTERFACE.StApiAppInfo)localObject3).mergeFrom(((MiniAppInfoEntity)localObject2).appInfo);
          localObject2 = com.tencent.mobileqq.mini.apkg.MiniAppInfo.from((INTERFACE.StApiAppInfo)localObject3);
          localObject3 = new MiniAppConfig((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2);
          if (!((MiniAppConfig)localObject3).isEngineTypeMiniGame()) {}
          for (i = 1; (i != 0) && (!"1108291530".equals(((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2).appId)); i = 0)
          {
            QLog.i("miniapp-process_AppBrandLaunchManager", 1, "prelaunch MiniApp appid=" + ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject2).appId);
            MiniSdkLauncher.preLaunchMiniApp(this.mContext, (MiniAppConfig)localObject3);
            return;
          }
        }
      }
    }
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
  
  private void removeRecommendCallback(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (this.recommendMap != null) && (this.recommendMap.containsKey(paramMiniAppConfig.config.appId)))
    {
      AppBrandLaunchManager.RecommendRunnable localRecommendRunnable = (AppBrandLaunchManager.RecommendRunnable)this.recommendMap.remove(paramMiniAppConfig.config.appId);
      if (localRecommendRunnable != null)
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 2, "removeCallbacks recommendRunnable : " + paramMiniAppConfig.config.appId);
        ThreadManager.getSubThreadHandler().removeCallbacks(localRecommendRunnable);
      }
    }
  }
  
  public void checkPreloadApp()
  {
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, "checkPreloadApp MiniAppUsed:" + isMiniAppUsed());
    try
    {
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_preload_extra", 1) > 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (isMiniAppUsed())) {
          MiniSdkLauncher.preloadMiniApp(this.mContext, true);
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-process_AppBrandLaunchManager", 1, "", localThrowable);
    }
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
    if (paramMiniAppConfig != null) {
      if (paramMiniAppConfig.isEngineTypeMiniGame()) {
        break label33;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      if (MiniSdkUtil.a(bool)) {}
      return;
    }
  }
  
  public void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    notifyDesktop();
    if (paramMiniAppConfig != null) {
      if (paramMiniAppConfig.isEngineTypeMiniGame()) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      if (MiniSdkUtil.a(bool)) {}
      return;
    }
  }
  
  public void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    if (paramMiniAppConfig != null) {
      if (paramMiniAppConfig.isEngineTypeMiniGame()) {
        break label23;
      }
    }
    label23:
    for (boolean bool = true;; bool = false)
    {
      if (MiniSdkUtil.a(bool)) {}
      return;
    }
  }
  
  public void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    if (paramMiniAppConfig != null) {
      if (paramMiniAppConfig.isEngineTypeMiniGame()) {
        break label23;
      }
    }
    label23:
    for (boolean bool = true;; bool = false)
    {
      if (MiniSdkUtil.a(bool)) {}
      return;
    }
  }
  
  public void onEnterForeground()
  {
    long l = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_process_detect_time", 600000);
    if ((System.currentTimeMillis() - this.mLastPreloadDetectTime > l) && (isMiniAppUsed()))
    {
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, "doProcessDetect MiniAppUsed:" + isMiniAppUsed() + " lastTime:" + this.mLastPreloadDetectTime);
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
  
  public void preLaunchMiniApp(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig == null) {}
    for (;;)
    {
      return;
      if (!paramMiniAppConfig.isEngineTypeMiniGame()) {}
      for (boolean bool = true; (bool) && (MiniSdkUtil.a(bool)); bool = false)
      {
        MiniSdkLauncher.preLaunchMiniApp(paramContext, paramMiniAppConfig);
        return;
      }
    }
  }
  
  public void preloadMiniApp()
  {
    for (;;)
    {
      try
      {
        boolean bool = CPUUtil.sIsX86Emulator;
        if (bool) {
          return;
        }
        updateBaseLib();
        ThreadManagerV2.executeOnFileThread(new AppBrandLaunchManager.3(this));
        doPreloadApp(true, true);
        doPreloadApp(false, true);
        long l = MiniAppConfProcessor.a("mini_sdk_prelaunch_all_delay_time", 60000);
        ThreadManager.getFileThreadHandler().postDelayed(new AppBrandLaunchManager.4(this), l);
        if ((SplashMiniGameStarter.hasPreloaded) && (SplashMiniGameStarter.curData != null)) {
          if (SplashMiniGameStarter.hasClickJumpBtn) {
            MiniProgramLpReportDC04746.report(SplashMiniGameStarter.curData.appId, SplashMiniGameStarter.curData.version, 1, 1);
          } else {
            MiniProgramLpReportDC04746.report(SplashMiniGameStarter.curData.appId, SplashMiniGameStarter.curData.version, 1, 0);
          }
        }
      }
      finally {}
    }
  }
  
  public void preloadPackage(@NonNull com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo) {}
  
  public void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
  {
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
        AppBrandTask.runTaskOnUiThread(new AppBrandLaunchManager.6(this, paramMiniAppConfig, paramActivity));
        return;
      }
      if ((paramMiniAppConfig.launchParam == null) || (paramMiniAppConfig.launchParam.scene == 9999))
      {
        AppBrandTask.runTaskOnUiThread(new AppBrandLaunchManager.7(this, paramMiniAppConfig));
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
        markMiniAppUsed();
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
          StringBuilder localStringBuilder = new StringBuilder().append("---startApp----");
          if (paramMiniAppConfig.launchParam == null) {
            break label663;
          }
          String str1 = paramMiniAppConfig.launchParam.entryPath;
          QLog.i("miniapp-start", 1, str1);
          QLog.i("miniapp-start", 1, "---startApp---- appid:" + paramMiniAppConfig.config.appId + " appName:" + paramMiniAppConfig.config.name);
          doStartMiniApp(paramActivity, paramMiniAppConfig, paramResultReceiver);
          MiniAppUtils.preFetchAppCacheData(paramActivity, paramMiniAppConfig.config);
          if (!paramMiniAppConfig.isEngineTypeMiniGame()) {
            break label671;
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
            label663:
            String str2 = "N/A";
            continue;
            label671:
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
      BaseLibManager.g().updateBaseLib(new AppBrandLaunchManager.9(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager
 * JD-Core Version:    0.7.0.1
 */