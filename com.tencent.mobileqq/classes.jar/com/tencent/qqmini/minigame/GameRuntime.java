package com.tencent.qqmini.minigame;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.tencent.mobileqq.triton.sdk.EnvConfig;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.Version;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.bridge.ScriptContextType;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.mobileqq.triton.sdk.statics.EngineInitStatistic;
import com.tencent.mobileqq.triton.sdk.statics.FirstRenderStatistic;
import com.tencent.mobileqq.triton.sdk.statics.GameLaunchStatistic;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadResult;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadStatics;
import com.tencent.qqmini.minigame.debug.QQDebugWebSocket;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.manager.GameReportManager;
import com.tencent.qqmini.minigame.manager.JsApiUpdateManager;
import com.tencent.qqmini.minigame.webaudio.WebAudioManager;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.cache.MiniCacheFreeManager;
import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.IRuntimeLifecycleListener;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;
import com.tencent.qqmini.sdk.report.MiniGdtReporter;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniProgressDialog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class GameRuntime
  extends BaseRuntimeImpl
  implements Preloadable<ITTEngine>
{
  private static final String TAG = "GameRuntime";
  private static boolean killAllGamesWhenDestroy = GameWnsUtils.killAllGamesWhenDestroy();
  private static boolean killAllGamesWhenReuse;
  public static boolean sStorageReport = false;
  public static volatile boolean webviewDataDirectoryInited = false;
  private Activity mActivity;
  private long mAttachWindowTime;
  private ComponentCallbacks2 mComponentCallback;
  private final FPSCallback mFpsListener = new GameRuntime.1(this);
  private GameInfoManager mGameInfoManager;
  private GamePage mGamePage;
  private GameReportManager mGameReportManager;
  private boolean mIsForground = true;
  private GameJsPluginEngine mJsPluginEngine;
  private Map<Integer, GameJsService> mJsServices = new HashMap();
  private int mLaunchResult = 0;
  private MiniAppInfo mMiniAppInfo;
  private boolean mNeedLaunchGameOnResume;
  private boolean mOnFirstBlackScreenReport = true;
  private boolean mOnFirstHide = true;
  private long mOnGameLaunchedTime;
  private long mOnShowTime;
  private final MiniGamePerformanceStatics mPerformanceStatics = MiniGamePerformanceStatics.getInstance();
  private boolean mPkgDownloadFlag = false;
  protected boolean mPrecacheFetched = false;
  private QQDebugWebSocket mQQDebugSocket;
  private ViewGroup mRootView;
  private MiniProgressDialog mShareScreenshotProgressDialog;
  private ShareState mShareState = new ShareState();
  private int mStartMode = 3;
  private ITTEngine mTTEngine;
  private EnvConfig mTritonEnvConfig;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    killAllGamesWhenReuse = GameWnsUtils.killAllGamesWhenReuse();
  }
  
  public GameRuntime(Context paramContext)
  {
    super(paramContext);
    try
    {
      if ((!webviewDataDirectoryInited) && (Build.VERSION.SDK_INT >= 28))
      {
        webviewDataDirectoryInited = true;
        WebView.setDataDirectorySuffix(AppLoaderFactory.g().getProcessName());
      }
      return;
    }
    catch (Throwable paramContext)
    {
      QMLog.e("GameRuntime", "setDataDirectorySuffix error", paramContext);
    }
  }
  
  private void destroyGameJsServices()
  {
    Iterator localIterator = this.mJsServices.entrySet().iterator();
    while (localIterator.hasNext())
    {
      GameJsService localGameJsService = (GameJsService)((Map.Entry)localIterator.next()).getValue();
      if (localGameJsService != null) {
        localGameJsService.clearUp();
      }
    }
  }
  
  private void destroyGamePage()
  {
    if (this.mGamePage != null) {
      this.mGamePage.onDestroy();
    }
  }
  
  private void destroyTTEngine()
  {
    if (!killAllGamesWhenDestroy)
    {
      if (this.mTTEngine != null) {
        this.mTTEngine.removeFPSCallback(this.mFpsListener);
      }
      QMLog.i("GameRuntime", "[MiniEng]doOnDestroy killAllGamesWhenDestroy :" + killAllGamesWhenDestroy);
      WebAudioManager.getInstance().closeAudioContext(this.mTTEngine);
      if (this.mTTEngine != null) {
        this.mTTEngine.onDestroy();
      }
      return;
    }
    QMLog.i("GameRuntime", "[MiniEng]doOnDestroy killProcess");
    this.mUIHandler.postDelayed(new GameRuntime.4(this), 300L);
  }
  
  private void doOnTTEngineExit()
  {
    QMLog.i("GameRuntime", "doOnEngineExit");
    if (this.mLifecycleListener != null) {
      this.mLifecycleListener.onDestroy(MiniAppEnv.g().getContext(), this.mMiniAppInfo);
    }
  }
  
  private static String getDeviceInfo()
  {
    return QUAUtil.getSimpleDeviceInfo(MiniAppEnv.g().getContext());
  }
  
  private String getLaunchMsg()
  {
    if (this.mPkgDownloadFlag) {
      return "firstLaunch" + this.mStartMode;
    }
    return "twiceLaunch" + this.mStartMode;
  }
  
  private void initGamePage(ITTEngine paramITTEngine)
  {
    this.mGamePage = new GamePage(paramITTEngine);
    this.mGamePage.init(this);
  }
  
  private void initJsPluginEngine()
  {
    long l = System.currentTimeMillis();
    this.mJsPluginEngine = ((GameJsPluginEngine)this.mTTEngine.getJsEngine());
    this.mJsPluginEngine.setGameRuntime(this);
    l = System.currentTimeMillis() - l;
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1038, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
    QMLog.i("[minigame][timecost] ", "step[initJsPluginEngine] cost time: " + l);
  }
  
  private void initTTEngine(ITTEngine paramITTEngine, IJSEngine paramIJSEngine)
  {
    this.mTTEngine = paramITTEngine;
    this.mTTEngine.addFPSCallback(this.mFpsListener);
    boolean bool = WnsConfig.getConfig("qqtriton", "MiniGameCodeCacheEnable", true);
    this.mTTEngine.setEnableCodeCache(bool);
  }
  
  private static void injectAccountInfoConfig(ITTEngine paramITTEngine, MiniAppInfo paramMiniAppInfo)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (paramMiniAppInfo != null)
    {
      paramMiniAppInfo = "var __wxConfig = __wxConfig || {}; __wxConfig.accountInfo = __wxConfig.accountInfo || {}; \n__wxConfig.accountInfo.appId = '" + paramMiniAppInfo.appId + "';\n__wxConfig.accountInfo.icon = '" + paramMiniAppInfo.iconUrl + "';\n __wxConfig.deviceinfo='" + getDeviceInfo() + "';\n __wxConfig.miniapp_version='" + paramMiniAppInfo.version + "';\n __wxConfig.sdk_version='" + QUAUtil.getQUA() + "';\n __wxConfig.source_app='" + localMiniAppProxy.getAppName() + "';\n __wxConfig.source_uin='" + LoginManager.getInstance().getAccount() + "';\n __wxConfig.source_version='" + localMiniAppProxy.getAppVersion() + "';\n __wxConfig.source_uin_platform='" + QUAUtil.getLoginType() + "';";
      QMLog.i("GameRuntime", "injectAccountInfoConfig:" + paramMiniAppInfo);
      paramITTEngine.getJsRuntime(1).evaluateJs(paramMiniAppInfo);
      paramITTEngine.getJsRuntime(2).evaluateJs(paramMiniAppInfo);
    }
  }
  
  private boolean isGameLaunchSuccess(GameLaunchStatistic paramGameLaunchStatistic)
  {
    if (paramGameLaunchStatistic.success) {
      return true;
    }
    if (!paramGameLaunchStatistic.engineInitStatistic.success) {
      return false;
    }
    paramGameLaunchStatistic = paramGameLaunchStatistic.gameScriptLoadStatics.iterator();
    while (paramGameLaunchStatistic.hasNext())
    {
      ScriptLoadStatics localScriptLoadStatics = (ScriptLoadStatics)paramGameLaunchStatistic.next();
      if ((localScriptLoadStatics.scriptContextType == ScriptContextType.MAIN) && (!localScriptLoadStatics.loadResult.isSuccess())) {
        return false;
      }
    }
    return true;
  }
  
  private boolean isJankCanaryBriefEnabled()
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
    if (this.mActivity.getSharedPreferences(str + "_user_sdk_minigame_", 0).getBoolean("_minigame_enable_jank_canary_brief", false)) {
      return true;
    }
    int i = WnsConfig.getConfig("qqminiapp", "mini_game_jank_trace_sampling_rate", 100);
    if (new Random().nextInt(10000) < i) {}
    for (i = 1; i != 0; i = 0)
    {
      QMLog.e("GameRuntime", "sampled for JankCanary Trace Info");
      return true;
    }
    return false;
  }
  
  private void onFirstRender(FirstRenderStatistic paramFirstRenderStatistic)
  {
    QMLog.i("GameRuntime", "onFirstRender. " + this.mMiniAppInfo);
    if (this.mGameInfoManager != null) {
      this.mGameReportManager.onFirstFrame();
    }
    performAction(AppStateEvent.obtain(2032, Integer.valueOf(this.mLaunchResult)));
    this.mOnShowTime = System.currentTimeMillis();
    if (this.mPkgDownloadFlag)
    {
      this.mPkgDownloadFlag = false;
      QMLog.i("GameRuntime", "game[" + this.mMiniAppInfo.appId + "][" + this.mMiniAppInfo.name + "] 冷启动，首帧出现!");
      MiniReportManager.reportEventType(this.mMiniAppInfo, 1022, "1");
    }
    for (;;)
    {
      long l1 = this.mOnShowTime;
      long l2 = this.mOnGameLaunchedTime;
      MiniReportManager.reportEventType(this.mMiniAppInfo, 1042, null, null, null, 0, "1", l1 - l2, null);
      AdFrequencyLimit.setOnStartTime(this.mOnShowTime);
      this.mUIHandler.post(new GameRuntime.3(this));
      ((AdProxy)ProxyManager.get(AdProxy.class)).onFirstFrame();
      return;
      QMLog.i("GameRuntime", "game[" + this.mMiniAppInfo.appId + "][" + this.mMiniAppInfo.name + "] 热启动,二次启动游戏!");
      MiniReportManager.reportEventType(this.mMiniAppInfo, 1023, "1");
      JsApiUpdateManager.checkForUpdate(this.mMiniAppInfo, this.mJsPluginEngine);
    }
  }
  
  private void onGameLaunched(@NonNull GameLaunchStatistic paramGameLaunchStatistic)
  {
    long l = paramGameLaunchStatistic.engineInitStatistic.createEGLContextTimeMs;
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1039, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
    QMLog.e("[minigame][timecost] ", "step[create surfaceView] cost time: " + l + "(from create SurfaceView)");
    this.mLaunchResult = 0;
    l = paramGameLaunchStatistic.launchTimesMs;
    int i;
    MiniAppInfo localMiniAppInfo;
    if (isGameLaunchSuccess(paramGameLaunchStatistic))
    {
      i = 0;
      this.mLaunchResult = i;
      this.mOnGameLaunchedTime = System.currentTimeMillis();
      QMLog.i("[minigame][timecost] ", "step[launchGame] launchResult: " + this.mLaunchResult + ", timeCost: " + l + ", " + this.mMiniAppInfo + " statics=" + paramGameLaunchStatistic);
      MiniReportManager.reportEventType(this.mMiniAppInfo, 1040, null, null, null, 0, "1", l, null);
      AppStateEvent.obtain(63, new Pair(Integer.valueOf(this.mLaunchResult), paramGameLaunchStatistic)).notifyRuntime(this);
      AppStateEvent.obtain(2051).notifyRuntime(this);
      MiniAppReportManager2.reportPageView("2load_end", String.valueOf(this.mLaunchResult), null, this.mMiniAppInfo);
      if (this.mLaunchResult < 0) {
        break label289;
      }
      localMiniAppInfo = this.mMiniAppInfo;
      if (!this.mPkgDownloadFlag) {
        break label282;
      }
    }
    label282:
    for (paramGameLaunchStatistic = "1";; paramGameLaunchStatistic = "0")
    {
      MiniReportManager.addCostTimeEventAttachInfo(localMiniAppInfo, 1008, paramGameLaunchStatistic);
      MiniReportManager.reportEventType(this.mMiniAppInfo, 1008, "1");
      return;
      i = -1;
      break;
    }
    label289:
    SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "show_fail", "load_pkg_fail");
    MiniAppReportManager2.reportPageView("2launch_fail", "load_pkg_fail", null, this.mMiniAppInfo);
    MiniGdtReporter.report(this.mMiniAppInfo, 512);
    MiniCacheFreeManager.freeCacheDialog(this.mActivity, LoginManager.getInstance().getAccount(), this.mMiniAppInfo, GameWnsUtils.getGameLaunchFailContent());
  }
  
  private void registerComponentCallback()
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      this.mComponentCallback = new GameRuntime.2(this);
      MiniAppEnv.g().getContext().getApplicationContext().registerComponentCallbacks(this.mComponentCallback);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void reportOnDestroy()
  {
    MiniReportManager.reportEventType(this.mMiniAppInfo, 22, "1");
    SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "unload", null);
    MiniAppReportManager2.reportPageView("2unload", null, null, this.mMiniAppInfo);
    SDKMiniProgramLpReportDC04239.deleteRecordDurationMsg();
  }
  
  private void reportOnPause()
  {
    if (this.mTTEngine != null)
    {
      l = this.mTTEngine.getLastBlackTime();
      if ((this.mOnFirstBlackScreenReport) && (l > 0L))
      {
        l = System.currentTimeMillis() - l;
        if (l > 0L)
        {
          this.mOnFirstBlackScreenReport = false;
          MiniReportManager.reportEventType(this.mMiniAppInfo, 1018, null, null, null, 0, "1", l, null);
          QMLog.e("GameRuntime", "doOnPause blackTimeDuration " + l);
        }
      }
      if ((this.mOnFirstHide) && (this.mOnShowTime > 0L))
      {
        this.mOnFirstHide = false;
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1016, "1");
        l = System.currentTimeMillis() - this.mOnShowTime;
        if (l > 0L) {
          MiniReportManager.reportEventType(this.mMiniAppInfo, 1020, null, null, null, 0, "1", l, null);
        }
      }
      l = System.currentTimeMillis() - this.mOnShowTime;
      if ((l > 0L) && (this.mOnShowTime > 0L)) {
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1021, null, null, null, 0, "1", l, null);
      }
      if (this.mMiniAppInfo == null) {
        break label267;
      }
    }
    label267:
    for (long l = Storage.getCurrentStorageSize(this.mMiniAppInfo.appId);; l = -1L)
    {
      if ((l >= 0L) && (!sStorageReport))
      {
        sStorageReport = true;
        MiniReportManager.reportEventType(this.mMiniAppInfo, 639, null, String.valueOf(l), null, 1, "1", 0L, null);
      }
      SDKMiniProgramLpReportDC04239.deleteRecordDurationMsg();
      return;
      l = 0L;
      break;
    }
  }
  
  private void unRegisterComponentCallback()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (this.mComponentCallback != null)) {}
    try
    {
      MiniAppEnv.g().getContext().getApplicationContext().unregisterComponentCallbacks(this.mComponentCallback);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("GameRuntime", "Failed to unRegisterComponentCallback", localException);
    }
  }
  
  public void checkPayForFriendLogic(MiniAppInfo paramMiniAppInfo)
  {
    if (this.mGamePage != null) {
      this.mGamePage.checkPayForFriendLogic(paramMiniAppInfo);
    }
  }
  
  protected void dismissShareScreenshotProgress()
  {
    ThreadManager.getUIHandler().post(new GameRuntime.9(this));
  }
  
  public Activity getAttachedActivity()
  {
    return this.mActivity;
  }
  
  public String getBaseLibVersion()
  {
    return getJsVersion();
  }
  
  public Context getContext()
  {
    return MiniAppEnv.g().getContext();
  }
  
  public long getCurrentDrawCount()
  {
    if (this.mTTEngine != null) {
      return this.mTTEngine.getCurrentDrawCount();
    }
    return 0L;
  }
  
  public ITTEngine getGameEngine()
  {
    return this.mTTEngine;
  }
  
  public GameInfoManager getGameInfoManager()
  {
    return this.mGameInfoManager;
  }
  
  public GameJsService getGameJsService(int paramInt)
  {
    GameJsService localGameJsService = (GameJsService)this.mJsServices.get(Integer.valueOf(paramInt));
    if (localGameJsService != null) {
      return localGameJsService;
    }
    try
    {
      localGameJsService = new GameJsService(this.mTTEngine.getJsRuntime(paramInt), paramInt);
      this.mJsServices.put(Integer.valueOf(paramInt), localGameJsService);
      return localGameJsService;
    }
    finally {}
  }
  
  public IJsPluginEngine getJsPluginEngine()
  {
    if (this.mJsPluginEngine != null) {
      return this.mJsPluginEngine.unwrap();
    }
    return null;
  }
  
  public IJsService getJsService()
  {
    return getGameJsService(1);
  }
  
  public String getJsVersion()
  {
    String str2 = "";
    String str1 = str2;
    if (this.mTritonEnvConfig != null)
    {
      str1 = str2;
      if (this.mTritonEnvConfig.getJSVersion() != null) {
        str1 = this.mTritonEnvConfig.getJSVersion().getVersion();
      }
    }
    return str1;
  }
  
  public String getLastClicks()
  {
    if (this.mTTEngine != null) {
      return this.mTTEngine.getLastClicks();
    }
    return null;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    if (this.mTTEngine != null) {
      return this.mTTEngine.getNativeBufferPool().getNativeBuffer(paramInt);
    }
    return new byte[0];
  }
  
  public IPage getPage()
  {
    return this.mGamePage;
  }
  
  public QQDebugWebSocket getQQDebugSocket()
  {
    return this.mQQDebugSocket;
  }
  
  public void getScreenshot(GetScreenshot.Callback paramCallback)
  {
    if (this.mTTEngine == null)
    {
      QMLog.e("GameRuntime", "Failed to get screen shot. TTEngine is null");
      if (paramCallback != null) {
        paramCallback.onGetScreenshot(null);
      }
      return;
    }
    showShareScreenshotProgress();
    this.mShareState.isGettingScreenShot = true;
    this.mTTEngine.getScreenShot(new GameRuntime.7(this, paramCallback));
  }
  
  public ShareState getShareState()
  {
    return this.mShareState;
  }
  
  public EnvConfig getTritonEnvConfig()
  {
    return this.mTritonEnvConfig;
  }
  
  public String getTritonVersion()
  {
    String str2 = "";
    String str1 = str2;
    if (this.mTritonEnvConfig != null)
    {
      str1 = str2;
      if (this.mTritonEnvConfig.getTritonVersion() != null) {
        str1 = this.mTritonEnvConfig.getTritonVersion().getVersion();
      }
    }
    return str1;
  }
  
  public void handleFocusGain()
  {
    if (this.mTTEngine != null) {
      this.mTTEngine.handleFocusGain();
    }
  }
  
  public void handleFocusLoss()
  {
    if (this.mTTEngine != null) {
      this.mTTEngine.handleFocusLoss();
    }
  }
  
  public void init(ITTEngine paramITTEngine)
  {
    this.mTTEngine = paramITTEngine;
    registerComponentCallback();
    initJsPluginEngine();
    initTTEngine(paramITTEngine, this.mJsPluginEngine);
    initGamePage(paramITTEngine);
  }
  
  public boolean isMiniGame()
  {
    return true;
  }
  
  public boolean isOrientationLandscape()
  {
    if (this.mGamePage != null) {
      return this.mGamePage.isOrientationLandscape();
    }
    return false;
  }
  
  public void launchGame()
  {
    if (this.mActivity == null) {
      return;
    }
    if (!this.mIsForground)
    {
      SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "not_foreground");
      MiniAppReportManager2.reportPageView("2launch_fail", "not_foreground", null, this.mMiniAppInfo);
      QMLog.e("GameRuntime", "not in forground, donot lauchGame");
      this.mNeedLaunchGameOnResume = true;
      return;
    }
    this.mNeedLaunchGameOnResume = false;
    this.mActivity.runOnUiThread(new GameRuntime.6(this));
  }
  
  public void loadMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
    if (!this.mPrecacheFetched)
    {
      this.mPrecacheFetched = true;
      PreCacheManager.g().fetchPreCacheData(this.mMiniAppInfo);
      PreCacheManager.g().fetchPreResourceIfNeed(this.mMiniAppInfo);
    }
    paramMiniAppInfo = (ApkgInfo)paramMiniAppInfo.apkgInfo;
    paramMiniAppInfo.mAppConfigInfo = new AppConfigInfo();
    paramMiniAppInfo.mAppConfigInfo.networkTimeoutInfo = new NetworkTimeoutInfo();
    paramMiniAppInfo.mAppConfigInfo.networkTimeoutInfo.request = 60000;
    paramMiniAppInfo.mAppConfigInfo.networkTimeoutInfo.connectSocket = 60000;
    paramMiniAppInfo.mAppConfigInfo.networkTimeoutInfo.downloadFile = 60000;
    paramMiniAppInfo.mAppConfigInfo.networkTimeoutInfo.uploadFile = 60000;
    ((MiniAppFileManager)getManager(MiniAppFileManager.class)).initFileManager(paramMiniAppInfo, true);
    injectAccountInfoConfig(this.mTTEngine, this.mMiniAppInfo);
    onLoadMiniAppInfo(this.mMiniAppInfo, false, null);
  }
  
  public int newNativeBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.mTTEngine != null) {
      return this.mTTEngine.getNativeBufferPool().newNativeBuffer(paramArrayOfByte, paramInt1, paramInt2);
    }
    return 0;
  }
  
  public boolean onBackPress()
  {
    if (this.mActivity == null) {}
    return false;
  }
  
  public void onLoadMiniAppInfo(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    this.mGamePage.onCreate(paramMiniAppInfo);
    this.mPerformanceStatics.setMiniAppInfo(paramMiniAppInfo);
    this.mPerformanceStatics.setVersion(getJsVersion(), getTritonVersion());
  }
  
  public void onRuntimeAttachActivity(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if ((this.mActivity == paramActivity) && (this.mRootView == paramViewGroup))
    {
      this.mGamePage.checkPayForFriendLogic(this.mMiniAppInfo);
      return;
    }
    this.mAttachWindowTime = System.currentTimeMillis();
    this.mActivity = paramActivity;
    this.mRootView = paramViewGroup;
    this.mTTEngine.onCreate(paramActivity);
    this.mGamePage.onAttachWindow(paramActivity, paramViewGroup);
    startGame();
  }
  
  public void onRuntimeCreate() {}
  
  public void onRuntimeDestroy()
  {
    AppStateEvent.obtain(64).notifyRuntime(this);
    destroyGamePage();
    destroyTTEngine();
    destroyGameJsServices();
    unRegisterComponentCallback();
    reportOnDestroy();
  }
  
  public void onRuntimeDetachActivity(Activity paramActivity)
  {
    if (this.mGamePage != null) {
      this.mGamePage.onDetachWindow(paramActivity);
    }
    this.mActivity = null;
  }
  
  public void onRuntimePause()
  {
    try
    {
      reportOnPause();
      this.mGamePage.onPause();
      this.mJsPluginEngine.onPause();
      this.mIsForground = false;
      this.mPerformanceStatics.stopReport();
      WebAudioManager.getInstance().suspendAudioContext(this.mTTEngine);
      this.mTTEngine.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("GameRuntime", "doOnPause reportOnPause ", localThrowable);
      }
    }
  }
  
  public void onRuntimeResume()
  {
    this.mTTEngine.onResume();
    WebAudioManager.getInstance().resumeAudioContext(this.mTTEngine);
    this.mGamePage.onResume(this.mMiniAppInfo);
    this.mJsPluginEngine.onResume();
    this.mPerformanceStatics.startReport();
    this.mOnShowTime = System.currentTimeMillis();
    this.mIsForground = true;
    if (this.mNeedLaunchGameOnResume)
    {
      QMLog.i("GameRuntime", "need launch game onResume");
      launchGame();
    }
  }
  
  public void onRuntimeStart() {}
  
  public void onRuntimeStop() {}
  
  public void onUpdateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
    super.onUpdateMiniAppInfo(paramMiniAppInfo);
  }
  
  public void pauseEngineOnly()
  {
    if (this.mTTEngine != null)
    {
      QMLog.i("GameRuntime", "yuki pauseEngineOnly");
      this.mTTEngine.onPause();
    }
  }
  
  public void resumeEngineOnly()
  {
    if (this.mTTEngine != null)
    {
      QMLog.i("GameRuntime", "yuki resumeEngineOnly");
      this.mTTEngine.onResume();
    }
  }
  
  public void setEnvConfig(EnvConfig paramEnvConfig)
  {
    this.mTritonEnvConfig = paramEnvConfig;
  }
  
  public void setGameInfoManager(GameInfoManager paramGameInfoManager)
  {
    this.mGameInfoManager = paramGameInfoManager;
  }
  
  public void setGameReportManager(GameReportManager paramGameReportManager)
  {
    this.mGameReportManager = paramGameReportManager;
  }
  
  public void setPackageDownloadFlag(boolean paramBoolean)
  {
    this.mPkgDownloadFlag = paramBoolean;
  }
  
  public void setStartMode(int paramInt)
  {
    this.mStartMode = paramInt;
  }
  
  protected void showShareScreenshotProgress()
  {
    ThreadManager.getUIHandler().post(new GameRuntime.8(this));
  }
  
  public void startGame()
  {
    QMLog.i("GameRuntime", "startGame");
    MiniGameInfo localMiniGameInfo = this.mGamePage.getGameInfo();
    if ((localMiniGameInfo != null) && (localMiniGameInfo.needOpenDebugSocket()) && (this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.scene == 1011))
    {
      QMLog.e("GameRuntime", "startLoadGame on ide debug mode");
      this.mQQDebugSocket = new QQDebugWebSocket(this, localMiniGameInfo);
      this.mQQDebugSocket.startConnectIDE(new GameRuntime.5(this));
      return;
    }
    QMLog.e("GameRuntime", "startGame on real mode");
    launchGame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime
 * JD-Core Version:    0.7.0.1
 */