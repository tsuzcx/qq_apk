package com.tencent.qqmini.minigame;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.mobileqq.triton.statistic.JankTraceLevel;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import com.tencent.mobileqq.triton.view.GameView;
import com.tencent.mobileqq.triton.view.GameView.Companion;
import com.tencent.qqmini.minigame.api.MiniEnginePackage;
import com.tencent.qqmini.minigame.api.MiniErrorListener;
import com.tencent.qqmini.minigame.api.MiniGameDataFileSystem;
import com.tencent.qqmini.minigame.api.MiniGamePackage;
import com.tencent.qqmini.minigame.debug.QQDebugWebSocket;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.manager.GameReportManager;
import com.tencent.qqmini.minigame.manager.JsApiUpdateManager;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.qqmini.minigame.report.GameFrameReport;
import com.tencent.qqmini.minigame.report.GameSubpackageReport;
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
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.core.utils.thread.ThreadPools;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.IRuntimeLifecycleListener;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AdReportData;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
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
import com.tencent.qqmini.sdk.widget.MiniProgressDialog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

public class GameRuntime
  extends BaseRuntimeImpl
  implements Preloadable<TritonPlatform>
{
  private static final String TAG = "GameRuntime";
  private static boolean killAllGamesWhenDestroy = GameWnsUtils.killAllGamesWhenDestroy();
  private static boolean killAllGamesWhenReuse = ;
  public static boolean sStorageReport = false;
  public static volatile boolean webviewDataDirectoryInited = false;
  private Activity mActivity;
  private long mAttachWindowTime;
  private final Runnable mFpsListener = new GameRuntime.1(this);
  private GameInfoManager mGameInfoManager;
  private GameLaunchStatistic mGameLaunchStatics;
  private GamePage mGamePage;
  private GameReportManager mGameReportManager;
  private boolean mIsForground = true;
  private GameJsPluginEngine mJsPluginEngine;
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
  private TritonEngine mTritonEngine;
  private MiniEnginePackage mTritonEnginePackage;
  private TritonPlatform mTritonPlatform;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public GameRuntime(Context paramContext)
  {
    super(paramContext);
    try
    {
      if ((!webviewDataDirectoryInited) && (Build.VERSION.SDK_INT >= 28))
      {
        webviewDataDirectoryInited = true;
        WebView.setDataDirectorySuffix(AppLoaderFactory.g().getProcessName());
        return;
      }
    }
    catch (Throwable paramContext)
    {
      QMLog.e("GameRuntime", "setDataDirectorySuffix error", paramContext);
    }
  }
  
  @NonNull
  private GameLaunchParam createGameLaunchParam()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(getClass(), this);
    MiniGamePackage localMiniGamePackage = this.mGamePage.getGamePackage();
    MiniGameDataFileSystem localMiniGameDataFileSystem = new MiniGameDataFileSystem(this.mMiniAppInfo.apkgInfo);
    GameView localGameView = GameView.Companion.from(this.mGamePage.getGameSurfaceView());
    QQDebugWebSocket localQQDebugWebSocket = getQQDebugSocket();
    JankTraceLevel localJankTraceLevel;
    if (isJankCanaryBriefEnabled()) {
      localJankTraceLevel = JankTraceLevel.BRIEF;
    } else {
      localJankTraceLevel = JankTraceLevel.NONE;
    }
    return new GameLaunchParam(localMiniGamePackage, localMiniGameDataFileSystem, localGameView, localQQDebugWebSocket, localJankTraceLevel, localHashMap);
  }
  
  private void destroyGamePage()
  {
    GamePage localGamePage = this.mGamePage;
    if (localGamePage != null) {
      localGamePage.onDestroy();
    }
  }
  
  private void destroyTTEngine()
  {
    if (!killAllGamesWhenDestroy)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[MiniEng]doOnDestroy killAllGamesWhenDestroy :");
      ((StringBuilder)localObject).append(killAllGamesWhenDestroy);
      QMLog.i("GameRuntime", ((StringBuilder)localObject).toString());
      localObject = this.mTritonEngine;
      if (localObject != null) {
        ((TritonEngine)localObject).destroy();
      }
    }
    else
    {
      QMLog.i("GameRuntime", "[MiniEng]doOnDestroy killProcess");
      this.mUIHandler.postDelayed(new GameRuntime.5(this), 300L);
    }
  }
  
  private void doOnTTEngineExit()
  {
    QMLog.i("GameRuntime", "doOnEngineExit");
    if (this.mLifecycleListener != null) {
      this.mLifecycleListener.onDestroy(MiniAppEnv.g().getContext(), this.mMiniAppInfo);
    }
  }
  
  private String getLaunchMsg()
  {
    if (this.mPkgDownloadFlag)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("firstLaunch");
      localStringBuilder.append(this.mStartMode);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("twiceLaunch");
    localStringBuilder.append(this.mStartMode);
    return localStringBuilder.toString();
  }
  
  private void initGamePage()
  {
    this.mGamePage = new GamePage();
    this.mGamePage.init(this);
  }
  
  private void initJsPluginEngine() {}
  
  private boolean isGameLaunchSuccess(GameLaunchStatistic paramGameLaunchStatistic)
  {
    if (paramGameLaunchStatistic.getSuccess()) {
      return true;
    }
    if (!paramGameLaunchStatistic.getEngineInitStatistic().getSuccess()) {
      return false;
    }
    paramGameLaunchStatistic = paramGameLaunchStatistic.getGameScriptLoadStatics().iterator();
    while (paramGameLaunchStatistic.hasNext())
    {
      ScriptLoadStatistic localScriptLoadStatistic = (ScriptLoadStatistic)paramGameLaunchStatistic.next();
      if ((localScriptLoadStatistic.getScriptContextType() == ScriptContextType.MAIN) && (!localScriptLoadStatistic.getLoadResult().isSuccess())) {
        return false;
      }
    }
    return true;
  }
  
  private boolean isJankCanaryBriefEnabled()
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
    Activity localActivity = this.mActivity;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_user_sdk_minigame_");
    if (localActivity.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("_minigame_enable_jank_canary_brief", false)) {
      return true;
    }
    int i = WnsConfig.getConfig("qqminiapp", "mini_game_jank_trace_sampling_rate", 100);
    if (new Random().nextInt(10000) < i) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      QMLog.e("GameRuntime", "sampled for JankCanary Trace Info");
      return true;
    }
    return false;
  }
  
  private void onFirstFrame(FirstFrameStatistic paramFirstFrameStatistic)
  {
    paramFirstFrameStatistic = new StringBuilder();
    paramFirstFrameStatistic.append("onFirstRender. ");
    paramFirstFrameStatistic.append(this.mMiniAppInfo);
    QMLog.i("GameRuntime", paramFirstFrameStatistic.toString());
    if (this.mGameInfoManager != null) {
      this.mGameReportManager.onFirstFrame();
    }
    performAction(AppStateEvent.obtain(2032, Integer.valueOf(this.mLaunchResult)));
    this.mOnShowTime = System.currentTimeMillis();
    if (this.mPkgDownloadFlag)
    {
      this.mPkgDownloadFlag = false;
      paramFirstFrameStatistic = new StringBuilder();
      paramFirstFrameStatistic.append("game[");
      paramFirstFrameStatistic.append(this.mMiniAppInfo.appId);
      paramFirstFrameStatistic.append("][");
      paramFirstFrameStatistic.append(this.mMiniAppInfo.name);
      paramFirstFrameStatistic.append("] 冷启动，首帧出现!");
      QMLog.i("GameRuntime", paramFirstFrameStatistic.toString());
      MiniReportManager.reportEventType(this.mMiniAppInfo, 1022, "1");
    }
    else
    {
      paramFirstFrameStatistic = new StringBuilder();
      paramFirstFrameStatistic.append("game[");
      paramFirstFrameStatistic.append(this.mMiniAppInfo.appId);
      paramFirstFrameStatistic.append("][");
      paramFirstFrameStatistic.append(this.mMiniAppInfo.name);
      paramFirstFrameStatistic.append("] 热启动,二次启动游戏!");
      QMLog.i("GameRuntime", paramFirstFrameStatistic.toString());
      MiniReportManager.reportEventType(this.mMiniAppInfo, 1023, "1");
      JsApiUpdateManager.checkForUpdate(this.mMiniAppInfo, (MiniAppFileManager)getManager(MiniAppFileManager.class), new GameRuntime.3(this));
    }
    long l1 = this.mOnShowTime;
    long l2 = this.mOnGameLaunchedTime;
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1042, null, null, null, 0, "1", l1 - l2, null);
    AdFrequencyLimit.setOnStartTime(this.mOnShowTime);
    this.mUIHandler.post(new GameRuntime.4(this));
    preloadSpringHbRaffleMaterial();
    ((AdProxy)ProxyManager.get(AdProxy.class)).onFirstFrame();
  }
  
  private void onGameLaunched(TritonEngine paramTritonEngine, @NonNull GameLaunchStatistic paramGameLaunchStatistic)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGameLaunched: success?");
    localStringBuilder.append(paramGameLaunchStatistic.getSuccess());
    localStringBuilder.append(", exception:");
    localStringBuilder.append(paramGameLaunchStatistic.getException());
    QMLog.e("[minigame] ", localStringBuilder.toString());
    this.mGameLaunchStatics = paramGameLaunchStatistic;
    this.mTritonEngine = paramTritonEngine;
    if (paramTritonEngine != null)
    {
      paramTritonEngine.observeLifeCycle(new GameRuntime.2(this));
      paramTritonEngine.getStatisticsManager().setFrameCallback(new GameFrameReport(this.mMiniAppInfo.appId));
      paramTritonEngine.getStatisticsManager().setSubpackageLoadStatisticsCallback(new GameSubpackageReport());
      paramTritonEngine.getStatisticsManager().setErrorCallback(new MiniErrorListener(this.mContext, this.mMiniAppInfo, this.mGameReportManager));
      if (this.mIsForground) {
        paramTritonEngine.start();
      }
    }
    long l = paramGameLaunchStatistic.getEngineInitStatistic().getCreateEGLContextTimeMs();
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1039, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
    paramTritonEngine = new StringBuilder();
    paramTritonEngine.append("step[create surfaceView] cost time: ");
    paramTritonEngine.append(l);
    paramTritonEngine.append("(from create SurfaceView)");
    QMLog.e("[minigame][timecost] ", paramTritonEngine.toString());
    int i = 0;
    this.mLaunchResult = 0;
    l = paramGameLaunchStatistic.getLaunchTimesMs();
    if (!isGameLaunchSuccess(paramGameLaunchStatistic)) {
      i = -1;
    }
    this.mLaunchResult = i;
    this.mOnGameLaunchedTime = System.currentTimeMillis();
    paramTritonEngine = new StringBuilder();
    paramTritonEngine.append("step[launchGame] launchResult: ");
    paramTritonEngine.append(this.mLaunchResult);
    paramTritonEngine.append(", timeCost: ");
    paramTritonEngine.append(l);
    paramTritonEngine.append(", ");
    paramTritonEngine.append(this.mMiniAppInfo);
    paramTritonEngine.append(", statics=");
    paramTritonEngine.append(paramGameLaunchStatistic);
    QMLog.i("[minigame][timecost] ", paramTritonEngine.toString());
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1040, null, null, null, 0, "1", l, null);
    AppStateEvent.obtain(63, new Pair(Integer.valueOf(this.mLaunchResult), paramGameLaunchStatistic)).notifyRuntime(this);
    AppStateEvent.obtain(2051).notifyRuntime(this);
    MiniAppReportManager2.reportPageView("2load_end", String.valueOf(this.mLaunchResult), null, this.mMiniAppInfo);
    if (this.mLaunchResult >= 0)
    {
      paramGameLaunchStatistic = this.mMiniAppInfo;
      if (this.mPkgDownloadFlag) {
        paramTritonEngine = "1";
      } else {
        paramTritonEngine = "0";
      }
      MiniReportManager.addCostTimeEventAttachInfo(paramGameLaunchStatistic, 1008, paramTritonEngine);
      MiniReportManager.reportEventType(this.mMiniAppInfo, 1008, "1");
      return;
    }
    SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "show_fail", "load_pkg_fail");
    MiniAppReportManager2.reportPageView("2launch_fail", "load_pkg_fail", null, this.mMiniAppInfo);
    MiniGdtReporter.report(this.mMiniAppInfo, 512);
    MiniCacheFreeManager.freeCacheDialog(this.mActivity, LoginManager.getInstance().getAccount(), this.mMiniAppInfo, GameWnsUtils.getGameLaunchFailContent());
  }
  
  private void preloadSpringHbRaffleMaterial()
  {
    Object localObject1 = this.mGameInfoManager;
    if (localObject1 != null)
    {
      localObject1 = ((GameInfoManager)localObject1).getQueryPath();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("preloadSpringHbRaffleMaterial query: ");
      ((StringBuilder)localObject2).append(localObject1);
      QMLog.d("GameRuntime", ((StringBuilder)localObject2).toString());
      if ("springfestival".equals(((JSONObject)localObject1).optString("act")))
      {
        localObject1 = this.mMiniAppInfo;
        if (localObject1 != null) {
          localObject1 = ((MiniAppInfo)localObject1).appId;
        } else {
          localObject1 = null;
        }
        localObject2 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
        RaffleJsPlugin.preloadGameRaffleMaterial(this.mContext, (String)localObject1, (String)localObject2);
      }
    }
  }
  
  private void reportAppFirstStorageUsage()
  {
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    long l;
    if (localMiniAppInfo != null) {
      l = Storage.getCurrentStorageSize(localMiniAppInfo.appId);
    } else {
      l = -1L;
    }
    if ((l >= 0L) && (!sStorageReport))
    {
      sStorageReport = true;
      MiniReportManager.reportEventType(this.mMiniAppInfo, 639, null, String.valueOf(l), null, 1, "1", 0L, null);
    }
  }
  
  private void reportGameBlackScreen()
  {
    Object localObject = this.mTritonEngine;
    long l;
    if ((localObject != null) && (((TritonEngine)localObject).getState() != EngineState.DESTROYED)) {
      l = this.mTritonEngine.getStatisticsManager().getLastBlackScreenTimeMillis();
    } else {
      l = 0L;
    }
    if ((this.mOnFirstBlackScreenReport) && (l > 0L))
    {
      l = System.currentTimeMillis() - l;
      if (l > 0L)
      {
        this.mOnFirstBlackScreenReport = false;
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1018, null, null, null, 0, "1", l, null);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnPause blackTimeDuration ");
        ((StringBuilder)localObject).append(l);
        QMLog.e("GameRuntime", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void reportGameFirstStayDuration()
  {
    if ((this.mOnFirstHide) && (this.mOnShowTime > 0L))
    {
      this.mOnFirstHide = false;
      MiniReportManager.reportEventType(this.mMiniAppInfo, 1016, "1");
      long l = System.currentTimeMillis() - this.mOnShowTime;
      if (l > 0L) {
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1020, null, null, null, 0, "1", l, null);
      }
    }
  }
  
  private void reportGameStayDuration()
  {
    long l2 = System.currentTimeMillis();
    long l1 = this.mOnShowTime;
    l2 -= l1;
    if ((l2 > 0L) && (l1 > 0L)) {
      MiniReportManager.reportEventType(this.mMiniAppInfo, 1021, null, null, null, 0, "1", l2, null);
    }
  }
  
  private void reportOnDestroy()
  {
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    if (localMiniAppInfo == null) {
      return;
    }
    MiniReportManager.reportEventType(localMiniAppInfo, 22, "1");
    SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "unload", null);
    MiniAppReportManager2.reportPageView("2unload", null, null, this.mMiniAppInfo);
    SDKMiniProgramLpReportDC04239.deleteRecordDurationMsg();
  }
  
  private void reportOnPause()
  {
    reportGameBlackScreen();
    reportGameFirstStayDuration();
    reportGameStayDuration();
    reportAppFirstStorageUsage();
    SDKMiniProgramLpReportDC04239.deleteRecordDurationMsg();
  }
  
  public void captureImage(ICaptureImageCallback paramICaptureImageCallback) {}
  
  public void checkPayForFriendLogic(MiniAppInfo paramMiniAppInfo)
  {
    GamePage localGamePage = this.mGamePage;
    if (localGamePage != null) {
      localGamePage.checkPayForFriendLogic(paramMiniAppInfo);
    }
  }
  
  protected void dismissShareScreenshotProgress()
  {
    ThreadManager.getUIHandler().post(new GameRuntime.10(this));
  }
  
  public AdReportData getAdReportData()
  {
    AdReportData localAdReportData = super.getAdReportData();
    localAdReportData.path = "";
    localAdReportData.canScroll = 0;
    localAdReportData.referPath = "";
    localAdReportData.networkType = NetworkUtil.getActiveNetworkType(getContext());
    localAdReportData.lastClicks = getLastClicks();
    localAdReportData.isGame = 1;
    return localAdReportData;
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
    TritonEngine localTritonEngine = this.mTritonEngine;
    if ((localTritonEngine != null) && (localTritonEngine.getState() != EngineState.DESTROYED)) {
      return this.mTritonEngine.getStatisticsManager().getCurrentDrawCalls();
    }
    return 0L;
  }
  
  public MiniEnginePackage getEnginePackage()
  {
    return this.mTritonEnginePackage;
  }
  
  public TritonEngine getGameEngine()
  {
    return this.mTritonEngine;
  }
  
  public GameInfoManager getGameInfoManager()
  {
    return this.mGameInfoManager;
  }
  
  public GameLaunchStatistic getGameLaunchStatics()
  {
    return this.mGameLaunchStatics;
  }
  
  public IJsPluginEngine getJsPluginEngine()
  {
    GameJsPluginEngine localGameJsPluginEngine = this.mJsPluginEngine;
    if (localGameJsPluginEngine != null) {
      return localGameJsPluginEngine.getRealPluginEngine();
    }
    return null;
  }
  
  public IJsService getJsService()
  {
    GameJsPluginEngine localGameJsPluginEngine = this.mJsPluginEngine;
    if (localGameJsPluginEngine != null) {
      return localGameJsPluginEngine.getCommonJsService(ScriptContextType.MAIN);
    }
    return null;
  }
  
  public String getJsVersion()
  {
    MiniEnginePackage localMiniEnginePackage = this.mTritonEnginePackage;
    if ((localMiniEnginePackage != null) && (localMiniEnginePackage.getJsLibVersion() != null)) {
      return this.mTritonEnginePackage.getJsLibVersion().getVersion();
    }
    return "";
  }
  
  public String getLastClicks()
  {
    TritonEngine localTritonEngine = this.mTritonEngine;
    if ((localTritonEngine != null) && (localTritonEngine.getState() != EngineState.DESTROYED)) {
      return this.mTritonEngine.getStatisticsManager().getLastClicks();
    }
    return null;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
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
    TritonEngine localTritonEngine = this.mTritonEngine;
    if ((localTritonEngine == null) && (localTritonEngine.getState() != EngineState.DESTROYED))
    {
      QMLog.e("GameRuntime", "Failed to get screen shot. TTEngine is null");
      if (paramCallback != null) {
        paramCallback.onGetScreenshot(null);
      }
      return;
    }
    showShareScreenshotProgress();
    this.mShareState.isGettingScreenShot = true;
    this.mTritonEngine.takeScreenShot(new GameRuntime.8(this, paramCallback));
  }
  
  public ShareState getShareState()
  {
    return this.mShareState;
  }
  
  public String getTheLastClickInfo()
  {
    TritonEngine localTritonEngine = this.mTritonEngine;
    if ((localTritonEngine != null) && (localTritonEngine.getState() != EngineState.DESTROYED)) {
      return this.mTritonEngine.getStatisticsManager().getLastClickInfo();
    }
    return null;
  }
  
  public String getTritonVersion()
  {
    MiniEnginePackage localMiniEnginePackage = this.mTritonEnginePackage;
    if ((localMiniEnginePackage != null) && (localMiniEnginePackage.getVersion() != null)) {
      return this.mTritonEnginePackage.getVersion().getVersion();
    }
    return "";
  }
  
  public void handleFocusGain()
  {
    GameJsPluginEngine localGameJsPluginEngine = this.mJsPluginEngine;
    if (localGameJsPluginEngine != null) {
      localGameJsPluginEngine.handleFocusGain();
    }
  }
  
  public void handleFocusLoss()
  {
    GameJsPluginEngine localGameJsPluginEngine = this.mJsPluginEngine;
    if (localGameJsPluginEngine != null) {
      localGameJsPluginEngine.handleFocusLoss();
    }
  }
  
  public void init(TritonPlatform paramTritonPlatform)
  {
    this.mTritonPlatform = paramTritonPlatform;
    initJsPluginEngine();
    initGamePage();
  }
  
  public boolean isForground()
  {
    return this.mIsForground;
  }
  
  public boolean isMiniGame()
  {
    return true;
  }
  
  public boolean isOrientationLandscape()
  {
    GamePage localGamePage = this.mGamePage;
    if (localGamePage != null) {
      return localGamePage.isOrientationLandscape();
    }
    return false;
  }
  
  public void launchGame()
  {
    Activity localActivity = this.mActivity;
    if (localActivity == null) {
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
    localActivity.runOnUiThread(new GameRuntime.7(this));
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
    onLoadMiniAppInfo(this.mMiniAppInfo, false, null);
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
    this.mGamePage.onAttachWindow(paramActivity, paramViewGroup);
    startGame();
  }
  
  public void onRuntimeCreate() {}
  
  public void onRuntimeDestroy()
  {
    AppStateEvent.obtain(64).notifyRuntime(this);
    destroyGamePage();
    destroyTTEngine();
    reportOnDestroy();
  }
  
  public void onRuntimeDetachActivity(Activity paramActivity)
  {
    GamePage localGamePage = this.mGamePage;
    if (localGamePage != null) {
      localGamePage.onDetachWindow(paramActivity);
    }
    this.mActivity = null;
  }
  
  public void onRuntimePause()
  {
    try
    {
      reportOnPause();
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("GameRuntime", "doOnPause reportOnPause ", localThrowable);
    }
    this.mGamePage.onPause();
    this.mIsForground = false;
    this.lastStayTime += System.currentTimeMillis() - this.onResumeTime;
    this.mPerformanceStatics.stopReport();
    TritonEngine localTritonEngine = this.mTritonEngine;
    if (localTritonEngine != null) {
      localTritonEngine.stop();
    }
    ThreadPools.getMainThreadHandler().removeCallbacks(this.mFpsListener);
  }
  
  public void onRuntimeResume()
  {
    TritonEngine localTritonEngine = this.mTritonEngine;
    if (localTritonEngine != null) {
      localTritonEngine.start();
    }
    this.mFpsListener.run();
    this.mGamePage.onResume(this.mMiniAppInfo);
    this.mPerformanceStatics.startReport();
    this.mOnShowTime = System.currentTimeMillis();
    this.onResumeTime = this.mOnShowTime;
    this.mIsForground = true;
    if (this.startTime == 0L) {
      this.startTime = this.onResumeTime;
    }
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
    TritonEngine localTritonEngine = this.mTritonEngine;
    if ((localTritonEngine != null) && (localTritonEngine.getState() != EngineState.DESTROYED)) {
      this.mTritonEngine.stop();
    }
  }
  
  public void resumeEngineOnly()
  {
    TritonEngine localTritonEngine = this.mTritonEngine;
    if ((localTritonEngine != null) && (localTritonEngine.getState() != EngineState.DESTROYED)) {
      this.mTritonEngine.start();
    }
  }
  
  public void setEnginePackage(MiniEnginePackage paramMiniEnginePackage)
  {
    this.mTritonEnginePackage = paramMiniEnginePackage;
  }
  
  public void setGameInfoManager(GameInfoManager paramGameInfoManager)
  {
    this.mGameInfoManager = paramGameInfoManager;
  }
  
  public void setGameReportManager(GameReportManager paramGameReportManager)
  {
    this.mGameReportManager = paramGameReportManager;
  }
  
  public void setJsPluginEngine(GameJsPluginEngine paramGameJsPluginEngine)
  {
    this.mJsPluginEngine = paramGameJsPluginEngine;
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
    ThreadManager.getUIHandler().post(new GameRuntime.9(this));
  }
  
  public void startGame()
  {
    QMLog.i("GameRuntime", "startGame");
    if ((this.mMiniAppInfo.debugInfo != null) && (this.mMiniAppInfo.debugInfo.valid()))
    {
      MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
      if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam.scene == 1011))
      {
        QMLog.e("GameRuntime", "startLoadGame on ide debug mode");
        this.mQQDebugSocket = new QQDebugWebSocket(this, this.mMiniAppInfo);
        this.mQQDebugSocket.startConnectIDE(new GameRuntime.6(this));
        return;
      }
    }
    QMLog.e("GameRuntime", "startGame on real mode");
    launchGame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime
 * JD-Core Version:    0.7.0.1
 */