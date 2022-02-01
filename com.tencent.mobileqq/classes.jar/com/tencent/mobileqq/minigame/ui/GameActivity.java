package com.tencent.mobileqq.minigame.ui;

import Override;
import abla;
import ablu;
import ablv;
import ablw;
import amtj;
import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.ResultReceiver;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apkn;
import apoh;
import apoj;
import bbgo;
import bbgp;
import bhlx;
import bjds;
import bjnd;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.DebugInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.NavigationBarInfo;
import com.tencent.mobileqq.mini.apkg.WindowInfo;
import com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule;
import com.tencent.mobileqq.mini.app.PreCacheManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.AdFrequencyLimit;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.AddColorSignListener;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.onActivityFinishListener;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.launch.MiniAppStartUtils;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.monitor.ui.MiniAppMonitorInfoView;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics;
import com.tencent.mobileqq.mini.report.MiniGdtReporter;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04746;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskExecutionStatics;
import com.tencent.mobileqq.mini.tfs.TaskExecutionStatics.Status;
import com.tencent.mobileqq.mini.tfs.TaskStaticsVisualizer;
import com.tencent.mobileqq.mini.ui.MiniAIOEntryView;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.api.QQMiniErrorListener;
import com.tencent.mobileqq.minigame.api.QQMiniGamePackage;
import com.tencent.mobileqq.minigame.api.QQMiniGamePackageManager;
import com.tencent.mobileqq.minigame.data.BannerAdPosInfo;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.data.FloatDragAdInfo;
import com.tencent.mobileqq.minigame.debug.QQDebugWebSocket;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.jsapi.callbacks.IGameUI;
import com.tencent.mobileqq.minigame.jsapi.manager.FloatDragAdDataManager.DragAdListener;
import com.tencent.mobileqq.minigame.jsapi.manager.FloatDragAdManager;
import com.tencent.mobileqq.minigame.jsapi.manager.GameVideoPlayerManager;
import com.tencent.mobileqq.minigame.jsapi.manager.JsApiUpdateManager;
import com.tencent.mobileqq.minigame.jsapi.manager.KeyboardHandler;
import com.tencent.mobileqq.minigame.jsapi.plugins.LifecyclePlugin;
import com.tencent.mobileqq.minigame.jsapi.widgets.KeyboardLayout;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.manager.GameCloseManager;
import com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GamePreConnectManager;
import com.tencent.mobileqq.minigame.manager.GameReportManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader.GameRuntimeListener;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.manager.PreloadManager;
import com.tencent.mobileqq.minigame.manager.PreloadManager.PreloadListener;
import com.tencent.mobileqq.minigame.report.MiniGameBeaconReport;
import com.tencent.mobileqq.minigame.report.QQGameFrameReport;
import com.tencent.mobileqq.minigame.report.QQGameSubpackageReport;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.task.GpkgLoadAsyncTask;
import com.tencent.mobileqq.minigame.task.LaunchEngineUISteps;
import com.tencent.mobileqq.minigame.task.TritonEngineInitTask;
import com.tencent.mobileqq.minigame.utils.CPUUtil;
import com.tencent.mobileqq.minigame.utils.GameActivityStatusWatcher;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.minigame.utils.VConsoleLogManager;
import com.tencent.mobileqq.minigame.utils.VConsoleManager;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.mobileqq.minigame.widget.DragLinearLayout;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Orientation;
import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QUA;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class GameActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener, IGameUI, FloatDragAdDataManager.DragAdListener, GameRuntimeLoader.GameRuntimeListener, PreloadManager.PreloadListener, VConsoleDragView.Listener
{
  private static final int LAUNCH_STATUS_CLICK = 0;
  private static final int LAUNCH_STATUS_FIRST_FRAME = 2;
  private static final int LAUNCH_STATUS_LOAD = 1;
  private static final int LOADING_AD_DISABLE = 0;
  private static final int LOADING_AD_DONE = 3;
  private static final int LOADING_AD_SELECTING = 1;
  private static final int LOADING_AD_SHOWING = 2;
  private static final String TAG = "[minigame] GameActivity";
  private static boolean killAllGamesWhenDestroy = GameWnsUtils.killAllGamesWhenDestroy();
  private static boolean killAllGamesWhenReuse = ;
  public static boolean mHasStorageReport;
  protected ablu bannerParams;
  Runnable execJS = new GameActivity.35(this);
  private long firstRenderTimeForLoadingAdReport;
  private long loadingAdSelectStartTime;
  public AdExposureChecker.ExposureCallback mAdExposureCheckerCallback;
  public ArrayList<AdExposureChecker> mAdExposureCheckers = new ArrayList();
  private OtherJsPlugin.AddColorSignListener mAddColorSingListener;
  private ApkgInfo mApkgInfo;
  private String mBackPressHint = GameWnsUtils.getBackPressHint();
  protected FrameLayout mBannerAdContainer;
  protected long mBannerAdLastClickTime;
  protected qq_ad_get.QQAdGetRsp.AdInfo mBannerAdOpInfo;
  protected BannerAdPosInfo mBannerAdPosInfo;
  private long mBeginExecJs;
  private long mBeginOnCreate;
  private long mBeginOnResume;
  private LinearLayout mBottonLayout;
  private GameActivityStatusWatcher mBroadCastWatcher;
  private LinearLayout mCenterLayout;
  protected apkn mColorNoteController;
  private apoj mColorNoteServiceListenr;
  private ViewGroup mContentView;
  private TextView mDebuggerEndBtn;
  private View mDebuggerLayer;
  private TextView mDebuggerStatusTv;
  private DragLinearLayout mDebuggerView;
  private LinearLayout mDeveloperDescLayout;
  private TextView mDeveloperDescView;
  private long mFirstBackPressTime;
  private FloatDragAdManager mFloatDragAdManager;
  private final Runnable mFpsScheduler = new GameActivity.1(this);
  protected MiniAppConfig mGameAppConfig;
  private View mGameContainerView;
  private float mGameDensity = -1.0F;
  private URLImageView mGameFakeFirstFrame;
  private RelativeLayout mGameFakeFirstFrameDownLoadRect;
  private TextView mGameFakeFrameGameName;
  private ProgressBar mGameFakeFrameProgres;
  private TextView mGameFakeFrameProgressText;
  private SquareImageView mGameFakeGameLogo;
  private int mGameHeight;
  private TextView mGameInstruction;
  private Runnable mGameLaunchWatchDog = new GameActivity.2(this);
  private QQMiniGamePackage mGamePackage;
  private GameRuntimeLoader mGameRuntimeLoader;
  private SurfaceView mGameSurfaceView;
  private TextView mGameVersionDesc;
  private int mGameWidth;
  protected abla mGdtAdListener;
  protected GdtBannerAd mGdtBannerAd;
  protected ablv mGdtBannerView;
  protected GdtDwellTimeStatisticsAfterClick mGdtDwellTimeStatisticsAfterClick;
  protected GdtAppReceiver mGgtAppReceiver;
  private boolean mHasExecJS;
  private boolean mHasInitDataMustOnResume;
  private boolean mHasInitUI;
  protected boolean mHasNewAd;
  private boolean mHasReportStepOnResume;
  private boolean mIsEngineLoaded;
  private boolean mIsEngineResumed;
  private boolean mIsFakeFrameValid;
  private boolean mIsForground = true;
  private boolean mIsFromSplash;
  private boolean mIsOrientationLandscape;
  private TextView mJumpBtn;
  private KeyboardLayout mKeyboardLayout;
  private long mLastOnShowReportTime;
  private final LaunchEngineUISteps mLaunchEngineUISteps = new LaunchEngineUISteps(this);
  private int mLaunchStatus = 0;
  private boolean mLaunchSuccess;
  private bbgp mListener = new GameActivity.43(this);
  private long mLoadGameStartTime;
  private int mLoadingAdStatus = 0;
  private RelativeLayout mLoadingContainer;
  private SquareImageView mLogoView;
  private String mMenuStyle = "light";
  public MiniAppMonitorInfoView mMiniAppMonitorInfoView;
  private TextView mNameView;
  private NavigatorBarForMiniGame mNavBar;
  private boolean mNeedLaunchGameOnResume;
  private boolean mNeedShowMonitorView;
  private boolean mOnFirstBlackScreenReport = true;
  private boolean mOnFirstHide = true;
  private long mOnGameLaunchedTime;
  private long mOnShowReportInterval = GameWnsUtils.getGameOnShowReportInterval();
  private boolean mOnShowReported;
  private long mOnShowTime;
  private PayForFriendView mPayForFriendView;
  private final MiniGamePerformanceStatics mPerformanceStatics = MiniGamePerformanceStatics.getInstance();
  private boolean mPkgDownloadFlag;
  private String mProgressStr = "0%";
  private TextView mProgressTxt;
  private QQDebugWebSocket mQQDebugSocket;
  private MqqHandler mReportHandler;
  private RelativeLayout mRightContainer;
  private bbgo mSoftKeyboardStateHelper;
  private LinearLayout mSplashLayout;
  private boolean mSplashLoadComplete;
  private ProgressBar mSplashProgressBar;
  private TextView mSplashProgressTxt;
  private long mStartActivityTime;
  private int mStartMode = 3;
  private ImageView mStartView;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private VConsoleLogManager mVConsoleManager;
  private MiniAIOEntryView miniAIOEntryView;
  private VConsoleDragView vConsoleBtn;
  private VConsoleView vConsoleView;
  private boolean vConsoleViewHasInited;
  
  private void bannerDestroy()
  {
    if (this.mGdtBannerView != null) {
      this.mGdtBannerView.c(this);
    }
    if (this.mGgtAppReceiver != null) {}
    try
    {
      this.mGgtAppReceiver.unregister(this);
      label32:
      this.mGgtAppReceiver = null;
      if (this.mAdExposureCheckers != null)
      {
        Iterator localIterator = this.mAdExposureCheckers.iterator();
        while (localIterator.hasNext())
        {
          AdExposureChecker localAdExposureChecker = (AdExposureChecker)localIterator.next();
          localAdExposureChecker.onActivityDestroy();
          localAdExposureChecker.setCallback(null);
        }
        this.mAdExposureCheckers.clear();
        this.mAdExposureCheckerCallback = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label32;
    }
  }
  
  private void bannerOnPause()
  {
    if (this.mGdtBannerView != null) {
      this.mGdtBannerView.a(this);
    }
    if (this.mAdExposureCheckers != null)
    {
      Iterator localIterator = this.mAdExposureCheckers.iterator();
      while (localIterator.hasNext())
      {
        AdExposureChecker localAdExposureChecker = (AdExposureChecker)localIterator.next();
        if (localAdExposureChecker != null) {
          localAdExposureChecker.onActivityPause();
        }
      }
    }
  }
  
  private void bannerOnResume()
  {
    if (this.mGdtBannerView != null) {
      this.mGdtBannerView.b(this);
    }
    if (this.mAdExposureCheckers != null)
    {
      Iterator localIterator = this.mAdExposureCheckers.iterator();
      while (localIterator.hasNext())
      {
        AdExposureChecker localAdExposureChecker = (AdExposureChecker)localIterator.next();
        if (localAdExposureChecker != null) {
          localAdExposureChecker.onActivityResume();
        }
      }
    }
  }
  
  private void callEngineOnResume()
  {
    runOnUiThread(new GameActivity.8(this));
  }
  
  private void checkPayForFriendLogic()
  {
    if ((this.mGameAppConfig == null) || (this.mGameAppConfig.config == null) || (TextUtils.isEmpty(this.mGameAppConfig.config.appId)) || (TextUtils.isEmpty(this.mGameAppConfig.config.prepayId))) {
      QLog.d("[minigame] PayForFriendView", 1, "checkPayForFriendLogic not payforfriend mode");
    }
    do
    {
      return;
      if (this.mLoadingAdStatus == 2)
      {
        QLog.d("[minigame] PayForFriendView", 1, "checkPayForFriendLogic loading ad is showing");
        return;
      }
      if ((this.mPayForFriendView != null) && ((this.mPayForFriendView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.mPayForFriendView.getParent()).removeView(this.mPayForFriendView);
      }
      this.mPayForFriendView = new PayForFriendView(this);
    } while (!this.mPayForFriendView.setUrl(this.mGameAppConfig.config.prepayId, this.mGameAppConfig.config.appId, this.mGameAppConfig.config.name, this.mGameAppConfig.config.iconUrl, this.mGameAppConfig.config.versionId, this.mGameAppConfig.config.verType));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.mPayForFriendView.setLayoutParams(localLayoutParams);
    this.mContentView.addView(this.mPayForFriendView);
    this.mPayForFriendView.setVisibility(0);
    this.mPayForFriendView.bringToFront();
    QLog.d("[minigame] PayForFriendView", 1, "checkPayForFriendLogic show webview success at " + System.currentTimeMillis());
  }
  
  private void doOnEngineExit()
  {
    QLog.i("[minigame] GameActivity", 1, "doOnEngineExit");
    GameRuntimeLoaderManager.g().unbindAndRemove(this);
  }
  
  private void doRequestByAppid(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new GameActivity.22(this, paramLaunchParam));
  }
  
  private void doRequestByLink(String paramString1, int paramInt, String paramString2, LaunchParam paramLaunchParam)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString1, paramInt, new GameActivity.23(this, paramLaunchParam));
  }
  
  private void exitWhenFail()
  {
    this.mUIHandler.postDelayed(new GameActivity.3(this), 1500L);
  }
  
  private WindowInfo fakeWindowInfo()
  {
    NavigationBarInfo localNavigationBarInfo = new NavigationBarInfo();
    localNavigationBarInfo.backgoundColor = 0;
    localNavigationBarInfo.textStyle = "gray";
    localNavigationBarInfo.style = "default";
    WindowInfo localWindowInfo = new WindowInfo();
    localWindowInfo.navigationBarInfo = localNavigationBarInfo;
    localWindowInfo.backgroundColor = DisplayUtil.parseColor("#ffffff");
    localWindowInfo.backgroundTextStyle = "dark";
    localWindowInfo.enablePullDownRefresh = Boolean.valueOf(false);
    localWindowInfo.onReachBottomDistance = 50;
    return localWindowInfo;
  }
  
  private boolean finishMiniProcesses(boolean paramBoolean)
  {
    QLog.e("[minigame] GameActivity", 1, "need finishMiniProcesses killAll:" + paramBoolean);
    if (Build.VERSION.SDK_INT < 21)
    {
      QLog.e("[minigame] GameActivity", 1, "finishMiniProcesses 版本低.");
      return false;
    }
    for (;;)
    {
      ActivityManager.AppTask localAppTask;
      try
      {
        Object localObject = (ActivityManager)getSystemService("activity");
        if (localObject == null)
        {
          QLog.e("[minigame] GameActivity", 1, "finishMiniProcesses am is null");
          return false;
        }
        localObject = ((ActivityManager)localObject).getAppTasks();
        if (localObject == null)
        {
          QLog.e("[minigame] GameActivity", 1, "finishMiniProcesses appTasks is null");
          return false;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localAppTask = (ActivityManager.AppTask)((Iterator)localObject).next();
        if ((localAppTask == null) || (localAppTask.getTaskInfo() == null) || (localAppTask.getTaskInfo().baseIntent == null) || (localAppTask.getTaskInfo().baseIntent.getComponent() == null)) {
          continue;
        }
        QLog.i("[minigame] GameActivity", 1, "finishMiniProcesses all id=" + localAppTask.getTaskInfo().id + ",className:" + localAppTask.getTaskInfo().baseIntent.getComponent().getClassName());
        if (!localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().contains("GameActivity")) {
          continue;
        }
        if (paramBoolean)
        {
          QLog.i("[minigame] GameActivity", 1, "finishMiniProcesses kill all games:" + localAppTask.getTaskInfo().baseIntent.getComponent().getClassName());
          localAppTask.finishAndRemoveTask();
          continue;
        }
        if (localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(getClass().getName())) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[minigame] GameActivity", 1, "finishMiniProcesses exception.", localThrowable);
        return false;
      }
      QLog.i("[minigame] GameActivity", 1, "finishMiniProcesses kill other games:" + localAppTask.getTaskInfo().baseIntent.getComponent().getClassName());
      localAppTask.finishAndRemoveTask();
    }
    return true;
  }
  
  private int gameDpTopx(float paramFloat)
  {
    if (this.mGameDensity > 0.0F) {
      return Math.round(this.mGameDensity * paramFloat);
    }
    return Math.round(getGameDensity() * paramFloat);
  }
  
  private GdtHandler.Params getBannerClickParams()
  {
    Object localObject;
    if (this.mBannerAdOpInfo == null) {
      localObject = null;
    }
    GdtHandler.Params localParams;
    do
    {
      do
      {
        return localObject;
        if (this.mGgtAppReceiver == null)
        {
          this.mGgtAppReceiver = new GdtAppReceiver();
          this.mGgtAppReceiver.register(this);
        }
        localParams = new GdtHandler.Params();
        localParams.jdField_c_of_type_Int = 11;
        localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
        localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(this.mBannerAdOpInfo);
        localParams.jdField_a_of_type_Boolean = true;
        localParams.jdField_b_of_type_Boolean = true;
        localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.mGgtAppReceiver);
        localParams.jdField_b_of_type_JavaLangClass = GameBannerAdFragment.class;
        localObject = new Bundle();
        ((Bundle)localObject).putString("big_brother_ref_source_key", "biz_src_miniapp");
        localParams.jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject);
        localObject = localParams;
      } while (this.mBannerAdOpInfo == null);
      localObject = localParams;
    } while (this.mBannerAdOpInfo.report_info == null);
    localParams.jdField_a_of_type_OrgJsonJSONObject = bjds.a(this, this.mBannerAdOpInfo.report_info.click_url.get());
    return localParams;
  }
  
  private String getBannerExtraReportParams()
  {
    if (this.mBannerAdPosInfo == null) {
      return "";
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("px", String.valueOf(gameDpTopx(this.mBannerAdPosInfo.mAdLeft)));
      ((JSONObject)localObject).put("py", String.valueOf(gameDpTopx(this.mBannerAdPosInfo.mAdTop)));
      ((JSONObject)localObject).put("da", String.valueOf(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth)));
      ((JSONObject)localObject).put("db", String.valueOf(gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight)));
      localObject = "s=" + URLEncoder.encode(((JSONObject)localObject).toString(), "utf-8");
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("[minigame] GameActivity", 1, "getBannerExtraReportParams error", localJSONException);
      return "";
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QLog.e("[minigame] GameActivity", 1, "getBannerExtraReportParams error", localUnsupportedEncodingException);
      }
    }
  }
  
  private static Drawable getDefaultDrawable()
  {
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130841306);
  }
  
  private static int getDefaultIconSize()
  {
    return DisplayUtil.dip2px(BaseApplicationImpl.getContext(), 100.0F);
  }
  
  private String getFakeFristFrameUrlByAppid(String paramString1, String paramString2)
  {
    int i = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        if (TextUtils.isEmpty(paramString2)) {
          return null;
        }
        paramString1 = paramString1.split(";");
        if ((paramString1 != null) && (paramString1.length > 0)) {
          while (i < paramString1.length)
          {
            String[] arrayOfString = paramString1[i].split("\\|\\|");
            if ((arrayOfString != null) && (arrayOfString.length == 2) && (paramString2.equals(arrayOfString[0])))
            {
              paramString1 = arrayOfString[1];
              return paramString1;
            }
            i += 1;
          }
        }
      }
      return null;
    }
    catch (Throwable paramString1) {}
  }
  
  private String getGameInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("gameConfig:");
    if (this.mGameAppConfig != null) {}
    for (String str = this.mGameAppConfig.toString();; str = "null") {
      return str;
    }
  }
  
  private String getLaunchMsg()
  {
    if (this.mPkgDownloadFlag) {
      return "firstLaunch" + this.mStartMode;
    }
    return "twiceLaunch" + this.mStartMode;
  }
  
  private int getLaunchStatus()
  {
    return this.mLaunchStatus;
  }
  
  @NonNull
  private TaskExecutionStatics getTaskExecutionStatics(long paramLong)
  {
    int j = this.mGameRuntimeLoader.getTasks().length;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TaskExecutionStatics("StartActivity", this.mStartActivityTime));
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.mGameRuntimeLoader.getTasks()[i].getExecutionStatics());
      i += 1;
    }
    localArrayList.add(this.mLaunchEngineUISteps.getExecutionStatics());
    return new TaskExecutionStatics("root", this.mStartActivityTime + paramLong, this.mStartActivityTime + paramLong, TaskExecutionStatics.Status.SUCCESS, "", localArrayList);
  }
  
  @NonNull
  private List<TaskExecutionStatics> getTaskExecutionStatics()
  {
    int j = this.mGameRuntimeLoader.getTasks().length;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TaskExecutionStatics("StartActivity", this.mStartActivityTime));
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.mGameRuntimeLoader.getTasks()[i].getExecutionStatics());
      i += 1;
    }
    localArrayList.add(this.mLaunchEngineUISteps.getExecutionStatics());
    return localArrayList;
  }
  
  private String getTaskStaticsString()
  {
    return TaskStaticsVisualizer.visualizeToString(getTaskExecutionStatics());
  }
  
  private void hideLoadingLayout()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mLoadingContainer, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.addListener(new GameActivity.11(this));
    localObjectAnimator.start();
    localObjectAnimator = ObjectAnimator.ofFloat(this.mGameContainerView, "alpha", new float[] { 0.5F, 1.0F });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.start();
    if ((!this.mIsOrientationLandscape) && (LiuHaiUtils.jdField_c_of_type_Int > LiuHaiUtils.b))
    {
      LiuHaiUtils.jdField_c_of_type_Boolean = false;
      LiuHaiUtils.a(this);
      if (LiuHaiUtils.b()) {
        LiuHaiUtils.enableNotch(this);
      }
      if (this.mNavBar != null) {
        this.mNavBar.requestPortraitLayout();
      }
    }
  }
  
  private void initAdExposureChecker(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, View paramView)
  {
    if ((paramAdInfo == null) || (paramView == null)) {
      QLog.i("[minigame] GameActivity", 1, "initAdExposureChecker null");
    }
    while (!AdUtils.isHitReport50ViewAndOneSecond(new GdtAd(paramAdInfo))) {
      return;
    }
    if (this.mAdExposureCheckers == null) {
      this.mAdExposureCheckers = new ArrayList();
    }
    paramAdInfo = new AdExposureChecker(new GdtAd(paramAdInfo), new WeakReference(paramView));
    if (this.mAdExposureCheckerCallback == null) {
      this.mAdExposureCheckerCallback = new GameActivity.39(this);
    }
    paramAdInfo.setCallback(new WeakReference(this.mAdExposureCheckerCallback));
    this.mAdExposureCheckers.add(paramAdInfo);
    paramAdInfo.startCheck();
    QLog.i("[minigame] GameActivity", 1, "startonExposure");
  }
  
  private void initBannerAdListener()
  {
    if (this.mGdtAdListener == null) {
      this.mGdtAdListener = new GameActivity.38(this);
    }
  }
  
  private boolean initDataMustOnResume()
  {
    long l = System.currentTimeMillis();
    Object localObject = getIntent();
    if (localObject == null)
    {
      QLog.e("[minigame] GameActivity", 1, "initDataMustOnResume intent==null");
      return false;
    }
    if (this.mGameAppConfig == null) {
      this.mGameAppConfig = loadMiniAppConfig((Intent)localObject);
    }
    this.mPerformanceStatics.setGameConfig(this.mGameAppConfig);
    if (this.mGameAppConfig == null)
    {
      QLog.e("[minigame] GameActivity", 1, "initDataMustOnResume gameConfig is null");
      return false;
    }
    if (this.mIsFromSplash) {
      MiniAppUtils.notityPullDownEntryInMainProcess(this.mGameAppConfig);
    }
    if (this.mGameAppConfig.isShortcutFakeApp())
    {
      QLog.i("[minigame] GameActivity", 1, "GameActivity doOnCreate gameConfig is from Shortcut.");
      doRequestByAppid(this.mGameAppConfig.config.appId, "", this.mGameAppConfig.config.getVerTypeStr(), this.mGameAppConfig.launchParam);
      return true;
    }
    if (this.mGameAppConfig.isFromShowInfo())
    {
      if (this.mGameAppConfig.link != null) {
        doRequestByLink(this.mGameAppConfig.link, this.mGameAppConfig.linkType, this.mGameAppConfig.config.getVerTypeStr(), this.mGameAppConfig.launchParam);
      }
      for (;;)
      {
        return true;
        doRequestByAppid(this.mGameAppConfig.config.appId, this.mGameAppConfig.entryPath, this.mGameAppConfig.config.getVerTypeStr(), this.mGameAppConfig.launchParam);
      }
    }
    this.mApkgInfo = new ApkgInfo(ApkgManager.getApkgFolderPath(this.mGameAppConfig.config), this.mGameAppConfig);
    localObject = new GameBrandRuntime(this, this.mApkgInfo);
    ((GameBrandRuntime)localObject).setAppId(this.mApkgInfo.appId);
    GameJsPluginEngine localGameJsPluginEngine = this.mGameRuntimeLoader.getJsPluginEngine();
    localGameJsPluginEngine.onAttachWindow(this);
    localGameJsPluginEngine.setAppBrandRuntime((BaseAppBrandRuntime)localObject);
    l = System.currentTimeMillis() - l;
    MiniReportManager.reportEventType(this.mGameAppConfig, 1032, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
    QLog.e("[minigame][timecost] ", 1, new Object[] { "step[initDataMustOnResume] cost time ", Long.valueOf(l) });
    this.mLoadGameStartTime = System.currentTimeMillis();
    if (this.mIsFromSplash) {
      if (PreloadManager.g().getState() == 2)
      {
        this.mUIHandler.post(new GameActivity.19(this));
        this.mSplashLoadComplete = true;
        this.mProgressStr = "100%";
      }
    }
    for (;;)
    {
      ThreadManagerV2.excute(new GameActivity.20(this), 16, null, false);
      return true;
      if (PreloadManager.g().getState() == 1)
      {
        PreloadManager.g().setListener(this);
        this.mProgressStr = ((int)(PreloadManager.g().getProgress() * 100.0F) + "%");
      }
      else
      {
        MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "load_fail", "splash_exit_when_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "splash_exit_when_fail", null, this.mGameAppConfig);
        QLog.e("[minigame] GameActivity", 1, "initDataMustOnResume exitWhenFail state=" + PreloadManager.g().getState());
        exitWhenFail();
        continue;
        this.mGameRuntimeLoader.registerListener(this);
        this.mGameRuntimeLoader.prepareGameRuntime(this.mGameAppConfig);
      }
    }
  }
  
  private void initDebuggerLayout()
  {
    if (this.mDebuggerView == null)
    {
      this.mDebuggerView = ((DragLinearLayout)((ViewStub)findViewById(2131365353)).inflate());
      this.mDebuggerLayer = findViewById(2131365349);
      this.mDebuggerStatusTv = ((TextView)findViewById(2131365352));
      this.mDebuggerEndBtn = ((TextView)findViewById(2131365350));
      this.mDebuggerEndBtn.setOnClickListener(new GameActivity.34(this));
    }
  }
  
  private void initGameUI()
  {
    if (this.mHasInitUI) {
      return;
    }
    this.mGamePackage = QQMiniGamePackageManager.createGamePackage(this.mGameRuntimeLoader.getMiniGamePkg());
    Object localObject = this.mGameRuntimeLoader.getMiniGamePkg();
    long l2;
    int j;
    int i;
    int k;
    if (((MiniGamePkg)localObject).isOrientationLandscape())
    {
      setOrientation(true);
      if (this.mNavBar != null) {
        this.mNavBar.requestLandscapeLayout();
      }
      if (this.vConsoleBtn != null) {
        this.vConsoleBtn.requestLandscapeLayout();
      }
      boolean bool = ((MiniGamePkg)localObject).isShowStatusBar();
      QLog.i("[minigame] GameActivity", 1, "initGameUI game config showStatusBar=" + bool);
      if (bool) {
        showStatusBar();
      }
      QLog.e("[minigame] GameActivity", 1, "initGameUI start create game SurfaceView");
      l2 = System.currentTimeMillis();
      j = getResources().getDisplayMetrics().widthPixels;
      i = getResources().getDisplayMetrics().heightPixels;
      if (Build.VERSION.SDK_INT >= 17)
      {
        localObject = new DisplayMetrics();
        ((WindowManager)getSystemService("window")).getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
        i = ((DisplayMetrics)localObject).heightPixels;
        j = ((DisplayMetrics)localObject).widthPixels;
        this.mGameDensity = ((DisplayMetrics)localObject).density;
        if (!Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
          break label524;
        }
        k = j;
        if (Settings.Secure.getInt(getContentResolver(), "display_notch_status", 0) == 1)
        {
          k = j;
          if (this.mGamePackage.getOrientation() == GamePackage.Orientation.LANDSCAPE) {
            k = j - ViewUtils.getStatusBarHeight(this);
          }
        }
        j = k;
      }
    }
    for (;;)
    {
      int m;
      if ((this.mGamePackage.getOrientation() != GamePackage.Orientation.LANDSCAPE) || (j > i))
      {
        m = i;
        k = j;
        if (this.mGamePackage.getOrientation() != GamePackage.Orientation.LANDSCAPE)
        {
          m = i;
          k = j;
          if (i > j) {}
        }
      }
      else
      {
        k = i;
        m = j;
      }
      this.mGameWidth = k;
      this.mGameHeight = m;
      QLog.d("[minigame] GameActivity", 1, " createGameView width :" + k + " height:" + m);
      this.mGameContainerView = findViewById(2131371168);
      this.mGameSurfaceView = ((SurfaceView)this.mGameContainerView.findViewById(2131371167));
      GameVideoPlayerManager.getInstance().init(this, (ViewGroup)this.mGameContainerView);
      long l1 = System.currentTimeMillis();
      l2 = l1 - l2;
      MiniReportManager.reportEventType(this.mGameAppConfig, 1039, null, String.valueOf(this.mStartMode), null, 0, "1", l2, null);
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[create surfaceView] cost time ", Long.valueOf(l2), "(from create SurfaceView), " + (l1 - this.mBeginOnCreate) + "(from onCreate), include steps[create surfaceView, inject jssdk]" });
      this.mLaunchSuccess = true;
      startLoadGame();
      this.mHasInitUI = true;
      return;
      setOrientation(false);
      break;
      label524:
      if ((Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) && (Settings.Global.getInt(getContentResolver(), "force_black", 0) == 1))
      {
        QLog.i("[minigame] GameActivity", 1, "xiaomi has notch");
        if (this.mGamePackage.getOrientation() == GamePackage.Orientation.LANDSCAPE)
        {
          j -= ViewUtils.getStatusBarHeight(this);
        }
        else
        {
          k = ViewUtils.getStatusBarHeight(this);
          i -= k;
        }
      }
    }
  }
  
  private void initJsPluginEngine()
  {
    long l = System.currentTimeMillis();
    GameJsPluginEngine localGameJsPluginEngine = this.mGameRuntimeLoader.getJsPluginEngine();
    localGameJsPluginEngine.init();
    localGameJsPluginEngine.onCreate();
    MiniAppClientQIPCModule.registerModule();
    MiniAppClientQIPCModule.getQIPCModule().attachGameJsPluginEngine(localGameJsPluginEngine);
    if (this.mNavBar != null) {
      this.mNavBar.setGameJsPluginEngine(localGameJsPluginEngine, (GameBrandRuntime)localGameJsPluginEngine.appBrandRuntime);
    }
    syncForceGroundAndRefreshBadge();
    l = System.currentTimeMillis() - l;
    MiniReportManager.reportEventType(this.mGameAppConfig, 1038, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
    QLog.e("[minigame][timecost] ", 1, new Object[] { "step[initJsPluginEngine] cost time ", Long.valueOf(l) });
  }
  
  private void initNavBar()
  {
    this.mNavBar = ((NavigatorBarForMiniGame)findViewById(2131371166));
    if (this.mIsFromSplash)
    {
      this.mNavBar.setVisibility(8);
      return;
    }
    this.mNavBar.setApkgInfoAndInit(this.mApkgInfo);
    this.mNavBar.setWindowInfo(fakeWindowInfo());
    this.mNavBar.findViewById(2131363882).setOnLongClickListener(this);
    this.mNavBar.bringToFront();
  }
  
  private void initOrientation(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.isLandScape()))
    {
      setOrientation(true);
      return;
    }
    setOrientation(false);
  }
  
  private void initStatusBar(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.isShowStatusBar())) {
      showStatusBar();
    }
  }
  
  private void initUI()
  {
    setContentView(2131559426);
    this.mContentView = ((ViewGroup)findViewById(2131371164));
    this.mBannerAdContainer = ((FrameLayout)findViewById(2131371157));
    this.mLoadingContainer = ((RelativeLayout)findViewById(2131367134));
    this.mCenterLayout = ((LinearLayout)findViewById(2131364333));
    this.mBottonLayout = ((LinearLayout)findViewById(2131363657));
    this.mSplashLayout = ((LinearLayout)findViewById(2131377682));
    this.mGameInstruction = ((TextView)findViewById(2131367404));
    this.mGameVersionDesc = ((TextView)findViewById(2131367430));
    this.mJumpBtn = ((TextView)findViewById(2131369465));
    this.mNameView = ((TextView)findViewById(2131367410));
    this.mDeveloperDescView = ((TextView)findViewById(2131365489));
    this.mDeveloperDescLayout = ((LinearLayout)findViewById(2131365490));
    this.mLogoView = ((SquareImageView)findViewById(2131370374));
    this.mLogoView.setRoundRect(getDefaultIconSize());
    this.mGameFakeFirstFrameDownLoadRect = ((RelativeLayout)findViewById(2131371281));
    this.mGameFakeFirstFrame = ((URLImageView)findViewById(2131367402));
    this.mGameFakeFrameProgres = ((ProgressBar)findViewById(2131371279));
    this.mGameFakeFrameProgressText = ((TextView)findViewById(2131371280));
    this.mGameFakeFrameGameName = ((TextView)findViewById(2131371278));
    this.mGameFakeGameLogo = ((SquareImageView)findViewById(2131371277));
    this.mProgressTxt = ((TextView)findViewById(2131379975));
    this.mSplashProgressTxt = ((TextView)findViewById(2131377684));
    this.mSplashProgressBar = ((ProgressBar)findViewById(2131377681));
    this.mJumpBtn.setOnClickListener(this);
    new ImmersionBar(this, 0, findViewById(2131377733));
    this.mColorNoteController = new apkn(this, false, true);
    this.mColorNoteController.a(this);
    this.mColorNoteController.a(new GameActivity.24(this));
    this.mColorNoteController.a(new GameActivity.25(this));
    this.mColorNoteServiceListenr = new GameActivity.26(this);
    this.mColorNoteController.a(this.mColorNoteServiceListenr);
    this.mVConsoleManager = new VConsoleLogManager();
    VConsoleManager.getInstance().registerLogManager(Process.myPid(), this.mVConsoleManager);
    initNavBar();
  }
  
  private void initVConsoleLayout()
  {
    if ((this.vConsoleBtn == null) || (this.vConsoleViewHasInited)) {
      return;
    }
    this.vConsoleView = new VConsoleView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.vConsoleView.setLayoutParams(localLayoutParams);
    this.mContentView.addView(this.vConsoleView);
    this.vConsoleView.setVisibility(8);
    this.vConsoleView.bringToFront();
    this.vConsoleBtn.bringToFront();
    this.vConsoleBtn.setListener(null);
    this.vConsoleViewHasInited = true;
  }
  
  private void initVConsoleView()
  {
    this.vConsoleBtn = new VConsoleDragView(this);
    this.vConsoleBtn.setImageResource(2130841054);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(90.0F), -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    localLayoutParams.setMargins(0, 0, ViewUtils.dpToPx(12.0F), ViewUtils.dpToPx(12.0F));
    this.vConsoleBtn.setLayoutParams(localLayoutParams);
    this.vConsoleBtn.setListener(this);
    this.mContentView.addView(this.vConsoleBtn);
    this.vConsoleBtn.bringToFront();
    this.vConsoleBtn.setVisibility(0);
    this.mUIHandler.postDelayed(new GameActivity.16(this), 1500L);
  }
  
  private boolean isGameLaunchSuccess(GameLaunchStatistic paramGameLaunchStatistic)
  {
    if (paramGameLaunchStatistic.getSuccess()) {}
    while (paramGameLaunchStatistic.getEngineInitStatistic().getSuccess()) {
      return true;
    }
    return false;
  }
  
  private void launchGame()
  {
    if (!this.mIsForground)
    {
      MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "load_fail", "not_foreground");
      MiniAppReportManager2.reportPageView("2launch_fail", "not_foreground", null, this.mGameAppConfig);
      this.mNeedLaunchGameOnResume = true;
      QLog.e("[minigame] GameActivity", 1, "not in forground, donot lauchGame");
    }
    do
    {
      return;
      this.mNeedLaunchGameOnResume = false;
    } while (this.mHasExecJS);
    this.execJS.run();
    this.mHasExecJS = true;
  }
  
  private void lifecycleReport(String paramString)
  {
    MiniAppConfig localMiniAppConfig = this.mGameAppConfig;
    Object localObject = localMiniAppConfig;
    if (localMiniAppConfig == null) {
      localObject = loadMiniAppConfig(getIntent());
    }
    if (localObject != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("app_config", this.mGameAppConfig);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", paramString, (Bundle)localObject);
    }
  }
  
  private MiniAppConfig loadMiniAppConfig(Intent paramIntent)
  {
    this.mIsFromSplash = paramIntent.getBooleanExtra("fromSplash", false);
    Object localObject2;
    Object localObject1;
    if (this.mIsFromSplash)
    {
      localObject2 = PreloadManager.g().getMiniAppConfig();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramIntent = (SplashMiniGameData)paramIntent.getParcelableExtra("splashData");
        localObject1 = localObject2;
        if (paramIntent != null)
        {
          PreloadManager.g().start(paramIntent);
          return PreloadManager.g().getMiniAppConfig();
        }
      }
    }
    else
    {
      localObject1 = MiniAppStartUtils.loadMiniAppInfoFromFile(BaseApplicationImpl.getApplication().getQQProcessName());
      if (localObject1 == null) {
        try
        {
          paramIntent = (MiniAppConfig)paramIntent.getParcelableExtra("CONFIG");
          localObject2 = new StringBuilder().append("loadMiniAppInfoFromIntent ");
          if ((paramIntent == null) || (paramIntent.config == null))
          {
            localObject1 = "null";
            QLog.i("[minigame] GameActivity", 1, (String)localObject1);
            return paramIntent;
          }
        }
        catch (Throwable paramIntent)
        {
          for (;;)
          {
            QLog.e("[minigame] GameActivity", 1, "loadMiniAppInfoFromIntent crash" + paramIntent.getMessage());
            paramIntent = (Intent)localObject1;
            continue;
            localObject1 = paramIntent.config.simpleInfo();
          }
        }
      }
      localObject2 = new StringBuilder().append("loadMiniAppInfoFromFile ");
      if (((MiniAppConfig)localObject1).config != null) {
        break label220;
      }
    }
    label220:
    for (paramIntent = "null";; paramIntent = ((MiniAppConfig)localObject1).config.simpleInfo())
    {
      QLog.i("[minigame] GameActivity", 1, paramIntent);
      return localObject1;
    }
  }
  
  private void logActivityOnCreate(MiniAppConfig paramMiniAppConfig)
  {
    Object localObject3 = null;
    if (Build.VERSION.SDK_INT >= 22)
    {
      localObject1 = getReferrer();
      if (localObject1 == null) {}
    }
    for (Object localObject1 = ((Uri)localObject1).toString();; localObject1 = null)
    {
      Object localObject2 = localObject3;
      if (paramMiniAppConfig != null)
      {
        localObject2 = localObject3;
        if (paramMiniAppConfig.config != null) {
          localObject2 = paramMiniAppConfig.config.simpleInfo();
        }
      }
      QLog.e("[minigame][timecost] ", 1, "step[startActivity] cost time: " + this.mStartActivityTime + " startMode: " + this.mStartMode + " miniAppInfo: " + (String)localObject2 + " referrer: " + (String)localObject1);
      return;
    }
  }
  
  private void notifyEvent(MiniAppConfig paramMiniAppConfig, String paramString, long paramLong)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.launchParam == null) || (paramMiniAppConfig.config == null)) {
      return;
    }
    String str = paramMiniAppConfig.config.appId;
    int i = paramMiniAppConfig.launchParam.scene;
    paramMiniAppConfig = paramMiniAppConfig.config.via;
    Bundle localBundle = new Bundle();
    localBundle.putString("key_appid", str);
    localBundle.putInt("key_scene", i);
    localBundle.putString("key_via", paramMiniAppConfig);
    localBundle.putString("key_event", paramString);
    localBundle.putLong("key_timestamp", paramLong);
    AppBrandProxy.g().sendCmd("cmd_notify_event_info", localBundle, null);
  }
  
  private void onFirstRender(FirstFrameStatistic paramFirstFrameStatistic)
  {
    if (getLaunchStatus() == 2)
    {
      QLog.e("[minigame][timecost] ", 1, "onFirstRender() repeat call! something wrong!");
      return;
    }
    setLaunchStatus(2);
    Object localObject = this.mGameRuntimeLoader.getReportManager();
    ((GameReportManager)localObject).setAppConfig(this.mGameAppConfig);
    ((GameReportManager)localObject).onFirstFrame();
    long l1 = 0L;
    if (this.mBeginExecJs > 0L) {
      l1 = System.currentTimeMillis() - this.mBeginExecJs;
    }
    MiniReportManager.reportEventType(this.mGameAppConfig, 636, null, null, null, 0, "1", l1, null);
    MiniAppStartState.updateState(this.mGameAppConfig.config.appId, true);
    long l2;
    long l3;
    if (this.mPkgDownloadFlag)
    {
      this.mPkgDownloadFlag = false;
      QLog.i("[minigame][start] ", 1, "game[" + this.mGameAppConfig.config.appId + "][" + this.mGameAppConfig.config.name + "] 冷启动，首帧出现!");
      MiniReportManager.reportEventType(this.mGameAppConfig, 1022, "1");
      MiniReportManager.reportEventType(this.mGameAppConfig, 21, "1");
      MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "show", "first_frame");
      MiniAppReportManager2.reportPageView("2launch", "first_frame", null, this.mGameAppConfig);
      this.mLastOnShowReportTime = System.currentTimeMillis();
      this.mOnShowReported = true;
      MiniGdtReporter.report(this.mGameAppConfig, 0);
      this.mOnShowTime = System.currentTimeMillis();
      this.firstRenderTimeForLoadingAdReport = System.currentTimeMillis();
      bjds.a();
      localObject = getLaunchMsg();
      l1 = paramFirstFrameStatistic.getFirstRenderTimeMs();
      l2 = this.mOnShowTime - this.mBeginOnCreate;
      l3 = this.mOnShowTime - this.mOnGameLaunchedTime;
      MiniReportManager.reportEventType(this.mGameAppConfig, 1042, null, (String)localObject, null, 0, "1", l3, null);
      paramFirstFrameStatistic = this.mGameAppConfig;
      if (!this.mLaunchSuccess) {
        break label595;
      }
    }
    label595:
    for (int i = 0;; i = -1)
    {
      MiniReportManager.reportEventType(paramFirstFrameStatistic, 1043, null, (String)localObject, null, i, "1", l2, null);
      AdFrequencyLimit.setOnStartTime(this.mOnShowTime);
      this.mLaunchEngineUISteps.onFirstFrame();
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[onFirstFrameAppear] (首帧出现) cost time ", Long.valueOf(l1), "(from gameLaunched), ", Long.valueOf(l2), "(from onCreate) ", Long.valueOf(l3), " ms(from gameLaunched)" });
      paramFirstFrameStatistic = getTaskExecutionStatics(l2);
      MiniGameBeaconReport.reportLaunchStatics(paramFirstFrameStatistic, this.mGameAppConfig.config.appId, false);
      QLog.e("[minigame][timecost] ", 1, "[MiniEng] GameLoadTaskExecutionStatics\n" + TaskStaticsVisualizer.visualizeToString(paramFirstFrameStatistic));
      reportTraceInfo(true);
      runOnUiThread(new GameActivity.29(this));
      preloadGameRuntimeLoaderOnFirstFrame();
      return;
      QLog.i("[minigame][start] ", 1, "game[" + this.mGameAppConfig.config.appId + "][" + this.mGameAppConfig.config.name + "] 热启动,二次启动游戏!");
      MiniReportManager.reportEventType(this.mGameAppConfig, 1023, "1");
      JsApiUpdateManager.checkForUpdate(this.mGameAppConfig, MiniAppFileManager.getInstance(), new GameActivity.28(this));
      break;
    }
  }
  
  private void onGameLaunched(TritonEngine paramTritonEngine, GameLaunchStatistic paramGameLaunchStatistic)
  {
    int i = 0;
    if (paramTritonEngine != null)
    {
      paramTritonEngine.getStatisticsManager().setFrameCallback(new QQGameFrameReport(this.mGamePackage.getId()));
      paramTritonEngine.getStatisticsManager().setSubpackageLoadStatisticsCallback(new QQGameSubpackageReport());
      paramTritonEngine.getStatisticsManager().setErrorCallback(new QQMiniErrorListener(this, this.mGameAppConfig, this.mGameRuntimeLoader.getReportManager()));
      callEngineOnResume();
    }
    notifyGameOnShow();
    this.mLaunchSuccess = isGameLaunchSuccess(paramGameLaunchStatistic);
    this.mOnGameLaunchedTime = System.currentTimeMillis();
    this.mLaunchEngineUISteps.onGameLaunched(paramGameLaunchStatistic);
    long l1 = this.mOnGameLaunchedTime;
    long l2 = this.mBeginOnCreate;
    long l3 = this.mOnGameLaunchedTime;
    long l4 = this.mBeginOnResume;
    QLog.e("[minigame][timecost] ", 1, new Object[] { "step[launchGame] execJS success, cost time ", Long.valueOf(paramGameLaunchStatistic.getLaunchTimesMs()), ", ", Long.valueOf(l1 - l2), "ms (from onCreate), ", Long.valueOf(l3 - l4), "ms (from onResume), launchResult", Boolean.valueOf(this.mLaunchSuccess), " gameLaunchStatics=", paramGameLaunchStatistic });
    paramTritonEngine = this.mGameAppConfig;
    String str = getLaunchMsg();
    if (this.mLaunchSuccess)
    {
      MiniReportManager.reportEventType(paramTritonEngine, 1040, null, str, null, i, "1", paramGameLaunchStatistic.getLaunchTimesMs(), null);
      if (!this.mLaunchSuccess) {
        break label338;
      }
      paramTritonEngine = "0";
      label276:
      MiniAppReportManager2.reportPageView("2load_end", paramTritonEngine, null, this.mGameAppConfig);
      if (!this.mLaunchSuccess) {
        break label352;
      }
      paramGameLaunchStatistic = this.mGameAppConfig;
      if (!this.mPkgDownloadFlag) {
        break label345;
      }
    }
    label338:
    label345:
    for (paramTritonEngine = "1";; paramTritonEngine = "0")
    {
      MiniReportManager.addCostTimeEventAttachInfo(paramGameLaunchStatistic, 1008, paramTritonEngine);
      MiniReportManager.reportEventType(this.mGameAppConfig, 1008, "1");
      return;
      i = -1;
      break;
      paramTritonEngine = "-1";
      break label276;
    }
    label352:
    MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "show_fail", "load_pkg_fail");
    MiniAppReportManager2.reportPageView("2launch_fail", "load_pkg_fail", null, this.mGameAppConfig);
    MiniGdtReporter.report(this.mGameAppConfig, 512);
    MiniCacheFreeManager.freeCacheDialog(this, getCurrentAccountUin(), this.mGameAppConfig.config, GameWnsUtils.getGameLaunchFailContent());
  }
  
  private void onPauseReport()
  {
    lifecycleReport("launch_report_app_pause");
    this.mIsForground = false;
    long l2 = 0L;
    TritonEngine localTritonEngine = this.mGameRuntimeLoader.getGameEngine();
    long l1 = l2;
    if (localTritonEngine != null)
    {
      l1 = l2;
      if (localTritonEngine.getState() != EngineState.DESTROYED) {
        l1 = this.mGameRuntimeLoader.getGameEngine().getStatisticsManager().getLastBlackScreenTimeMillis();
      }
    }
    if ((this.mOnFirstBlackScreenReport) && (l1 > 0L))
    {
      l1 = System.currentTimeMillis() - l1;
      if (l1 > 0L)
      {
        this.mOnFirstBlackScreenReport = false;
        MiniReportManager.reportEventType(this.mGameAppConfig, 1018, null, null, null, 0, "1", l1, null);
        QLog.e("[minigame] GameActivity", 1, "doOnPause blackTimeDuration " + l1);
      }
    }
    if ((this.mOnFirstHide) && (this.mOnShowTime > 0L))
    {
      this.mOnFirstHide = false;
      MiniReportManager.reportEventType(this.mGameAppConfig, 1016, "1");
      l1 = System.currentTimeMillis() - this.mOnShowTime;
      if (l1 > 0L) {
        MiniReportManager.reportEventType(this.mGameAppConfig, 1020, null, null, null, 0, "1", l1, null);
      }
    }
    l1 = System.currentTimeMillis() - this.mOnShowTime;
    if ((l1 > 0L) && (this.mOnShowTime > 0L)) {
      MiniReportManager.reportEventType(this.mGameAppConfig, 1021, null, null, null, 0, "1", l1, null);
    }
    l2 = Storage.getCurrentStorageSize(this.mGameRuntimeLoader.getGameInfoManager().getAppId());
    if ((l2 >= 0L) && (!mHasStorageReport))
    {
      mHasStorageReport = true;
      MiniReportManager.reportEventType(this.mGameAppConfig, 639, null, String.valueOf(l2), null, 1, "1", 0L, null);
    }
    MiniReportManager.reportEventType(this.mGameAppConfig, 20, "1");
    l2 = System.currentTimeMillis();
    notifyEvent(this.mGameAppConfig, "onPause", l2);
    if (this.mOnShowReported)
    {
      this.mOnShowReported = false;
      MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "hide", null);
    }
    for (;;)
    {
      MiniAppReportManager2.reportPageView("2hide", String.valueOf(l1), null, this.mGameAppConfig);
      MiniProgramLpReportDC04239.deleteRecordDurationMsg();
      return;
      QLog.e("[minigame] GameActivity", 1, "no need report product onHide, mOnShowReported=false");
    }
  }
  
  private void preloadGameRuntimeLoaderOnFirstFrame()
  {
    if (GameWnsUtils.enableGameruntimePreloadOnFirstFrame())
    {
      QLog.i("[minigame] GameActivity", 1, "preloadGameRuntimeLoaderOnFirstFrame");
      ThreadManagerV2.excute(new GameActivity.31(this), 16, null, false);
    }
  }
  
  private void processLoadingAdPreloadLogic()
  {
    MiniLoadingAdManager.getInstance().preloadLoadingAd(this.mGameAppConfig, getCurrentAccountUin());
  }
  
  private void processSelectLoadingAdLogic(MiniAppConfig paramMiniAppConfig)
  {
    this.loadingAdSelectStartTime = System.currentTimeMillis();
    if (MiniLoadingAdManager.getInstance().selectAd(paramMiniAppConfig, getCurrentAccountUin(), new GameActivity.13(this, paramMiniAppConfig))) {
      setLoadingAdStatus(1);
    }
  }
  
  public static void reportAdByHttp(String paramString)
  {
    QLog.i("[minigame] GameActivity", 1, "reportBannerAd/BlockAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new GameActivity.42(paramString));
  }
  
  private void reportBannerAd(String paramString, long paramLong)
  {
    ThreadManager.executeOnNetWorkThread(new GameActivity.41(this, paramString, paramLong));
  }
  
  private void reportLaunch()
  {
    MiniAppConfig localMiniAppConfig = loadMiniAppConfig(getIntent());
    String str1;
    if ((localMiniAppConfig != null) && (localMiniAppConfig.config != null))
    {
      str1 = localMiniAppConfig.config.appId;
      if ((localMiniAppConfig == null) || (localMiniAppConfig.config == null)) {
        break label116;
      }
    }
    label116:
    for (String str2 = localMiniAppConfig.config.name;; str2 = "")
    {
      QLog.i("[minigame][start] ", 1, "game[" + str1 + "][" + str2 + "] 游戏启动(GameActivity onCreate)");
      if (localMiniAppConfig != null) {
        MiniReportManager.reportEventType(localMiniAppConfig, 24, "1");
      }
      setLaunchStatus(0);
      return;
      str1 = "";
      break;
    }
  }
  
  private void reportTraceInfo(boolean paramBoolean)
  {
    if ((paramBoolean) || (System.currentTimeMillis() - this.mBeginOnResume > 30000L))
    {
      TritonEngine localTritonEngine = this.mGameRuntimeLoader.getGameEngine();
      if ((localTritonEngine != null) && (localTritonEngine.getState() != EngineState.DESTROYED)) {
        localTritonEngine.getStatisticsManager().getTraceInfo(new GameActivity.30(this, paramBoolean));
      }
    }
  }
  
  private void requestFail(long paramLong, String paramString)
  {
    runOnUiThread(new GameActivity.21(this, paramString, paramLong));
  }
  
  private void setAppConfig()
  {
    MiniAppConfig localMiniAppConfig = loadMiniAppConfig(getIntent());
    if (localMiniAppConfig != null) {
      this.mGameRuntimeLoader.getGameInfoManager().setMiniAppConfig(localMiniAppConfig);
    }
  }
  
  private void setLaunchStatus(int paramInt)
  {
    this.mLaunchStatus = paramInt;
  }
  
  private void setLoadingAdStatus(@GameActivity.LoadingAdStatus int paramInt)
  {
    this.mLoadingAdStatus = paramInt;
  }
  
  private void setOrientation(boolean paramBoolean)
  {
    this.mIsOrientationLandscape = paramBoolean;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      setRequestedOrientation(i);
      return;
    }
  }
  
  private void setProgressTxt(float paramFloat, String paramString)
  {
    runOnUiThread(new GameActivity.5(this, paramFloat));
  }
  
  private void setupUI()
  {
    this.mProgressTxt.setText(this.mProgressStr);
    this.mSplashProgressTxt.setText(this.mProgressStr);
    label103:
    Object localObject1;
    if (this.mGameAppConfig.config != null)
    {
      this.mNameView.setText(this.mGameAppConfig.config.name);
      this.mNameView.setVisibility(0);
      if (this.mGameAppConfig.config.isReportTypeMiniApp())
      {
        this.mGameInstruction.setVisibility(4);
        if (!TextUtils.isEmpty(this.mGameAppConfig.config.developerDesc)) {
          break label276;
        }
        this.mDeveloperDescLayout.setVisibility(8);
      }
      for (;;)
      {
        if ((this.mGameAppConfig.config.qualifications != null) && (this.mGameAppConfig.config.qualifications.size() > 0))
        {
          this.mDeveloperDescLayout.setVisibility(8);
          this.mGameVersionDesc.setVisibility(0);
          localObject1 = new StringBuilder();
          int i = 0;
          for (;;)
          {
            if (i < this.mGameAppConfig.config.qualifications.size())
            {
              if ((i > 0) && (!TextUtils.isEmpty((CharSequence)this.mGameAppConfig.config.qualifications.get(i - 1)))) {
                ((StringBuilder)localObject1).append("\n");
              }
              if (!TextUtils.isEmpty((CharSequence)this.mGameAppConfig.config.qualifications.get(i))) {
                ((StringBuilder)localObject1).append((String)this.mGameAppConfig.config.qualifications.get(i));
              }
              i += 1;
              continue;
              this.mGameInstruction.setVisibility(0);
              break;
              label276:
              this.mDeveloperDescLayout.setVisibility(0);
              this.mDeveloperDescView.setText(amtj.a(2131704136) + this.mGameAppConfig.config.developerDesc + amtj.a(2131704135));
              break label103;
            }
          }
          this.mGameVersionDesc.setText(((StringBuilder)localObject1).toString());
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      if (!TextUtils.isEmpty(this.mGameAppConfig.config.iconUrl))
      {
        URLDrawable.URLDrawableOptions.obtain();
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = getDefaultIconSize();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = getDefaultIconSize();
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = getDefaultDrawable();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = getDefaultDrawable();
        localObject1 = URLDecoder.decode(this.mGameAppConfig.config.iconUrl);
      }
      try
      {
        localObject2 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).run();
        this.mLogoView.setImageDrawable((Drawable)localObject2);
        this.mLogoView.setVisibility(0);
        this.mGameFakeFrameGameName.setText(this.mGameAppConfig.config.name);
        this.mGameFakeGameLogo.setImageDrawable((Drawable)localObject2);
        localObject1 = getFakeFristFrameUrlByAppid(GameWnsUtils.getFakeFristFrameUrl(), this.mGameAppConfig.config.appId);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          if (!bjnd.a((String)localObject1)) {
            break label592;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.mIsFakeFrameValid = true;
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = getResources().getDisplayMetrics().widthPixels;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = getResources().getDisplayMetrics().heightPixels;
          Drawable localDrawable = getResources().getDrawable(2131167276);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
          localObject2 = URLDrawable.getDrawable(URLDecoder.decode((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2);
          this.mGameFakeFirstFrame.setURLDrawableDownListener(new GameActivity.27(this));
          ((URLDrawable)localObject2).run();
          this.mGameFakeFirstFrame.setImageDrawable((Drawable)localObject2);
          label592:
          if (this.mIsFromSplash)
          {
            this.mBottonLayout.setVisibility(8);
            this.mCenterLayout.setVisibility(8);
            this.mSplashLayout.setVisibility(0);
            this.mJumpBtn.setVisibility(0);
            if (Build.VERSION.SDK_INT < 16) {
              break label813;
            }
            this.mLoadingContainer.setBackground(new BitmapDrawable(getResources(), PreloadManager.g().mSlashPic));
            if (PreloadManager.g().mStartBtnPic != null)
            {
              this.mStartView = ((ImageView)findViewById(2131363976));
              this.mStartView.setImageDrawable(new BitmapDrawable(getResources(), PreloadManager.g().mStartBtnPic));
              this.mStartView.setOnClickListener(this);
              if (this.mSplashLoadComplete) {
                showStartView();
              }
            }
          }
          return;
          this.mDeveloperDescLayout.setVisibility(0);
          this.mGameVersionDesc.setVisibility(4);
          continue;
          localThrowable1 = localThrowable1;
          QLog.e("[minigame] GameActivity", 1, "initDataMustOnResume setGameDrawable error, url = " + (String)localObject1, localThrowable1);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            QLog.e("[minigame] GameActivity", 1, " wnsFakeFirstFrameDrawable error, url = " + (String)localObject1, localThrowable2);
            continue;
            label813:
            this.mLoadingContainer.setBackgroundDrawable(new BitmapDrawable(getResources(), PreloadManager.g().mSlashPic));
          }
        }
      }
    }
  }
  
  private void showDebugDialog()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(QUA.getQUA3()).append(" ").append(this.mGameRuntimeLoader.getTritonEnginePackage().toString()).append("\n\n").append(getTaskStaticsString());
    localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(DisplayUtil.dip2px(this, 8.0F)), 0, localSpannableStringBuilder.length(), 33);
    new AlertDialog.Builder(this).setTitle("GameDebug").setMessage(localSpannableStringBuilder).create().show();
  }
  
  private void showStartView()
  {
    this.mSplashProgressBar.setVisibility(8);
    this.mSplashProgressTxt.setVisibility(8);
    this.mStartView.setVisibility(0);
  }
  
  private void showStatusBar()
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.flags &= 0xFFFFFBFF;
    getWindow().setAttributes(localLayoutParams);
    getWindow().clearFlags(512);
  }
  
  private void showUpdateMobileQQDialog()
  {
    Object localObject1 = "";
    try
    {
      Object localObject3 = GameWnsUtils.getQQUpdateUrl();
      Object localObject2 = "";
      Object localObject4 = localObject2;
      localObject1 = localObject3;
      if (this.mGameAppConfig != null)
      {
        localObject4 = localObject2;
        localObject1 = localObject3;
        if (this.mGameAppConfig.config != null)
        {
          localObject1 = localObject3;
          localObject4 = this.mGameAppConfig.config.appId;
        }
      }
      localObject2 = localObject3;
      localObject1 = localObject3;
      if (((String)localObject3).contains("{appid}"))
      {
        localObject2 = localObject3;
        localObject1 = localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = localObject3;
          localObject2 = ((String)localObject3).replace("{appid}", (CharSequence)localObject4);
        }
      }
      localObject1 = localObject2;
      QLog.i("[minigame] GameActivity", 1, "showUpdateMobileQQDialog jump to upgrate page:" + (String)localObject2);
      localObject1 = localObject2;
      localObject3 = new Intent(getActivity(), QQBrowserActivity.class);
      localObject1 = localObject2;
      ((Intent)localObject3).putExtra("hide_more_button", true);
      localObject1 = localObject2;
      ((Intent)localObject3).putExtra("hide_operation_bar", true);
      localObject1 = localObject2;
      ((Intent)localObject3).putExtra("url", (String)localObject2);
      localObject1 = localObject2;
      startActivity((Intent)localObject3);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-start", 1, "jump to upgrate page exception! url=" + (String)localObject1, localThrowable);
    }
  }
  
  private void startMainActivity()
  {
    QLog.e("[minigame] GameActivity", 1, "startMainActivity SplashActivity");
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
    localIntent.setFlags(335544320);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("fragment_id", 1);
    startActivity(localIntent);
  }
  
  private void syncForceGroundAndRefreshBadge()
  {
    ThreadManagerV2.excute(new GameActivity.44(this), 16, null, true);
  }
  
  private void updateDebuggerStatus(String paramString1, String paramString2, boolean paramBoolean)
  {
    runOnUiThread(new GameActivity.33(this, paramString1, paramString2, paramBoolean));
  }
  
  private void updateLoadingAdUI(String paramString, GdtAd paramGdtAd)
  {
    MiniProgramLpReportDC04239.reportMiniAppEvent(this.mGameAppConfig, MiniProgramLpReportDC04239.getAppType(this.mGameAppConfig), null, "ad", "ad_loading", "expo_call", null);
    paramString = MiniLoadingAdManager.getInstance().getLoadingAdLayout(this.mGameAppConfig, this, true, paramString, paramGdtAd);
    if ((this.mGameAppConfig != null) && (this.mGameAppConfig.config != null) && (paramString != null))
    {
      this.mContentView.addView(paramString);
      if (this.mNavBar != null) {
        this.mNavBar.bringToFront();
      }
      MiniLoadingAdManager.getInstance().show(paramString, this.mGameAppConfig.config.appId, getCurrentAccountUin(), new GameActivity.14(this));
      MiniProgramLpReportDC04239.reportMiniAppEvent(this.mGameAppConfig, MiniProgramLpReportDC04239.getAppType(this.mGameAppConfig), null, "ad", "ad_loading", "expo_success", null);
    }
  }
  
  protected void changeWindowInfo(MiniAppConfig paramMiniAppConfig)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ThreadManagerV2.excute(new GameActivity.15(this, paramMiniAppConfig), 16, null, false);
  }
  
  public boolean clickMonitorPanel()
  {
    if (this.mContentView != null)
    {
      if (this.mMiniAppMonitorInfoView != null) {
        break label100;
      }
      this.mMiniAppMonitorInfoView = new MiniAppMonitorInfoView(this, null, 1);
      this.mMiniAppMonitorInfoView.setMiniAppType(1);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      this.mContentView.addView(this.mMiniAppMonitorInfoView, localLayoutParams);
      this.mMiniAppMonitorInfoView.setVisibility(0);
      this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
    }
    while ((this.mMiniAppMonitorInfoView != null) && (this.mMiniAppMonitorInfoView.getVisibility() == 0))
    {
      return true;
      label100:
      if (this.mMiniAppMonitorInfoView.getVisibility() == 0)
      {
        this.mMiniAppMonitorInfoView.stopRefreshMonitorUi();
        this.mMiniAppMonitorInfoView.setVisibility(8);
      }
      else
      {
        this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
        this.mMiniAppMonitorInfoView.setVisibility(0);
      }
    }
    return false;
  }
  
  public boolean createBannerAd(BannerAdPosInfo paramBannerAdPosInfo, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    try
    {
      QLog.i("[minigame] GameActivity", 1, "createBannerAd");
      this.mBannerAdPosInfo = paramBannerAdPosInfo;
      this.mBannerAdOpInfo = paramAdInfo;
      this.bannerParams = new ablu();
      this.bannerParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = getBannerClickParams();
      this.bannerParams.jdField_a_of_type_Int = 0;
      this.bannerParams.b = gameDpTopx(paramBannerAdPosInfo.mAdRealWidth);
      this.bannerParams.jdField_c_of_type_Int = gameDpTopx(paramBannerAdPosInfo.mAdRealHeight);
      this.mGdtBannerAd = new GdtBannerAd(this.bannerParams);
      this.mGdtBannerView = this.mGdtBannerAd.render(this, this.bannerParams.b, this.bannerParams.jdField_c_of_type_Int);
      if (this.mGdtBannerView != null)
      {
        this.bannerParams.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick = new GdtDwellTimeStatisticsAfterClick(new GdtAd(this.mBannerAdOpInfo), new WeakReference(this.mGdtBannerView.a()));
        initBannerAdListener();
        this.mGdtBannerAd.setListener(new WeakReference(this.mGdtAdListener));
        this.mHasNewAd = true;
      }
      for (;;)
      {
        paramAdInfo = new StringBuilder().append("createBannerAd result");
        if (this.mGdtBannerView == null) {
          break;
        }
        bool = true;
        QLog.i("[minigame] GameActivity", 1, bool + ",info = " + paramBannerAdPosInfo);
        if (this.mGdtBannerView == null) {
          break label284;
        }
        return true;
        QLog.e("[minigame] GameActivity", 1, "build Ad error");
      }
    }
    catch (Exception paramAdInfo)
    {
      for (;;)
      {
        QLog.e("[minigame] GameActivity", 1, "createBannerAd, error", paramAdInfo);
        continue;
        boolean bool = false;
      }
    }
    label284:
    return false;
  }
  
  public void destroyBannerAd()
  {
    try
    {
      runOnUiThread(new GameActivity.40(this));
      this.mGdtBannerView = null;
      this.mGdtDwellTimeStatisticsAfterClick = null;
      this.mBannerAdPosInfo = null;
      this.mBannerAdOpInfo = null;
      this.mGdtBannerAd = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void destroyBlockAd(BlockAdInfo paramBlockAdInfo)
  {
    if (paramBlockAdInfo == null) {}
    for (;;)
    {
      return;
      try
      {
        int i = paramBlockAdInfo.getCompId();
        paramBlockAdInfo = BlockAdManager.getInstance().getBlockAdView(i);
        if (paramBlockAdInfo == null) {
          continue;
        }
        paramBlockAdInfo.clearAnimation();
        paramBlockAdInfo.setVisibility(8);
        this.mContentView.removeView(paramBlockAdInfo);
        BlockAdManager.getInstance().destroyBlockAdView(i);
      }
      finally {}
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("[minigame] GameActivity", 1, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    if ((paramInt1 == 1001) || (paramInt1 == 1002)) {
      if ((getNavBar() != null) && (getNavBar().getCapsuleButton() != null)) {
        getNavBar().getCapsuleButton().doOnActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    do
    {
      return;
      if (paramInt1 != 3004) {
        break;
      }
    } while (this.mPayForFriendView == null);
    this.mPayForFriendView.callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);");
    return;
    MiniAppController.getInstance().notifyResultListener(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    QLog.e("[minigame] GameActivity", 1, "[doOnBackPressed]");
    reportOnBackPressed();
    quitDebugSocket();
    notifyGameStop();
    if (this.mIsFromSplash)
    {
      startMainActivity();
      this.mUIHandler.postDelayed(new GameActivity.37(this), 300L);
    }
    moveTaskToBack(true);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    QLog.d("[minigame] GameActivity", 1, "--onConfigurationChanged-- screenWidthDp=" + paramConfiguration.screenWidthDp + ", screenHeightDp=" + paramConfiguration.screenHeightDp);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    QLog.i("[minigame] GameActivity", 1, "doOnCreate " + this + ", pid:" + Process.myPid());
    this.mIsFakeFrameValid = false;
    this.mBeginOnCreate = System.currentTimeMillis();
    this.mBroadCastWatcher = new GameActivityStatusWatcher(this);
    this.mBroadCastWatcher.setOnHomePressedListener(new GameActivity.10(this));
    this.mBroadCastWatcher.startWatch();
    Intent localIntent = getIntent();
    MiniAppConfig localMiniAppConfig = loadMiniAppConfig(localIntent);
    long l = localIntent.getLongExtra("startDuration", 0L);
    if (paramBundle != null) {
      l = 0L;
    }
    this.mStartMode = localIntent.getIntExtra("start_mode", 3);
    if (l != 0L) {
      this.mStartActivityTime = (this.mBeginOnCreate - l);
    }
    if (localMiniAppConfig != null) {
      MiniReportManager.reportEventType(localMiniAppConfig, 1030, null, String.valueOf(this.mStartMode), null, 0, "1", this.mStartActivityTime, null);
    }
    QLog.e("[minigame][timecost] ", 1, new Object[] { "step[startActivity] cost time ", Long.valueOf(this.mStartActivityTime), ", startMode " + this.mStartMode });
    logActivityOnCreate(localMiniAppConfig);
    if (CPUUtil.sIsX86Emulator)
    {
      if (localMiniAppConfig != null)
      {
        MiniProgramLpReportDC04239.reportPageView(localMiniAppConfig, "1", null, "load_fail", "system_version_limit_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "system_version_limit_fail", null, localMiniAppConfig);
      }
      QQToast.a(getApplicationContext(), 2131693826, 1).a();
      finish();
      return false;
    }
    QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnCreate saved=" + paramBundle);
    try
    {
      super.getIntent().putExtra("fling_action_key", 0);
      MiniGdtReporter.prepareReport();
      this.mNeedStatusTrans = false;
      getWindow().setFlags(1024, 1024);
      getWindow().setFormat(-2);
      initOrientation(localMiniAppConfig);
      initStatusBar(localMiniAppConfig);
      reportLaunch();
      if (this.mIsFromSplash)
      {
        this.mGameRuntimeLoader = GameRuntimeLoaderManager.g().getBindRuntimeLoader(BaseApplicationImpl.getApplication());
        GameRuntimeLoaderManager.g().reBindRuntimeLoader(this.mGameRuntimeLoader, this);
        this.mPerformanceStatics.setVersion(this.mGameRuntimeLoader.getJsVersion(), this.mGameRuntimeLoader.getTritonVersion());
        this.mActNeedImmersive = false;
        LiuHaiUtils.a(this);
        if (LiuHaiUtils.b())
        {
          if ((!Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) || ((Build.VERSION.SDK_INT != 26) && (Build.VERSION.SDK_INT != 27))) {
            break label687;
          }
          DisplayUtil.enableXiaoMiNotch(this);
        }
        boolean bool = super.doOnCreate(paramBundle);
        this.mReportHandler = ThreadManager.getSubThreadHandler();
        initUI();
        l = System.currentTimeMillis() - this.mBeginOnCreate;
        if (localMiniAppConfig != null) {
          MiniReportManager.reportEventType(localMiniAppConfig, 1031, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
        }
        QLog.e("[minigame][timecost] ", 1, new Object[] { "step[doOnCreate] cost time ", Long.valueOf(l) });
        getSharedPreferences("sdk_conf", 4).edit().putInt("usersdk", 0).apply();
        GamePreConnectManager.reset();
        this.mUIHandler.postDelayed(this.mGameLaunchWatchDog, 10000L);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("[minigame] GameActivity", 1, "[MiniEng]禁用右滑关闭失败:" + localThrowable.getMessage());
        continue;
        this.mGameRuntimeLoader = GameRuntimeLoaderManager.g().obtain(this);
        QLog.i("[minigame] GameActivity", 1, "obtain GameRuntimeLoader:" + this.mGameRuntimeLoader);
        continue;
        label687:
        LiuHaiUtils.enableNotch(this);
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy " + this + ", killAllGamesWhenDestroy:" + killAllGamesWhenDestroy);
    if (this.mGameRuntimeLoader != null) {
      this.mGameRuntimeLoader.unRegisterListener(this);
    }
    MiniAppController.getInstance().unRegisterActivityResultListener();
    MiniAppClientQIPCModule.unRegisterModule();
    TritonEngine localTritonEngine;
    if (this.mGameRuntimeLoader != null) {
      localTritonEngine = this.mGameRuntimeLoader.getGameEngine();
    }
    for (;;)
    {
      if ((localTritonEngine != null) && (!killAllGamesWhenDestroy))
      {
        QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy killAllGamesWhenDestroy :" + killAllGamesWhenDestroy);
        QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy begin");
        localTritonEngine.destroy();
        QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy end");
      }
      try
      {
        this.mBroadCastWatcher.stopWatch();
        label151:
        MiniReportManager.reportEventType(this.mGameAppConfig, 22, "1");
        if (this.mGameAppConfig != null)
        {
          if ((getLaunchStatus() == 0) || (getLaunchStatus() == 1))
          {
            MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "load_fail", "loading_page_kill");
            MiniAppReportManager2.reportPageView("2launch_fail", "loading_page_kill", null, this.mGameAppConfig);
          }
          label216:
          MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "unload", null);
          MiniAppReportManager2.reportPageView("2unload", null, null, this.mGameAppConfig);
          MiniProgramLpReportDC04239.deleteRecordDurationMsg();
          VConsoleManager.getInstance().unRegisterLogManager(Process.myPid());
          bannerDestroy();
          if (this.mColorNoteController != null) {
            this.mColorNoteController.c();
          }
          if ((this.mNavBar == null) || (this.mNavBar.getCapsuleButton() == null) || (this.mNavBar.getCapsuleButton().mGameActivityFinishListener == null)) {
            break label336;
          }
          this.mNavBar.getCapsuleButton().mGameActivityFinishListener.onActivityFinish();
        }
        label336:
        while (!killAllGamesWhenDestroy)
        {
          return;
          localTritonEngine = null;
          break;
          QLog.e("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy kill self gameConfig=null");
          break label216;
        }
        QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy killProcess  :");
        QLog.e("[minigame] GameActivity", 1, "doOnDestroy kill process" + getGameInfo());
        this.mUIHandler.postDelayed(new GameActivity.18(this), 300L);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label151;
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    QLog.e("[minigame] GameActivity", 1, "--doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    GameInfoManager localGameInfoManager;
    if (this.mGameRuntimeLoader != null)
    {
      localGameInfoManager = this.mGameRuntimeLoader.getGameInfoManager();
      if ((paramIntent != null) && (localGameInfoManager != null))
      {
        MiniAppConfig localMiniAppConfig = localGameInfoManager.getMiniAppConfig();
        paramIntent = loadMiniAppConfig(paramIntent);
        if ((!MiniAppConfig.isValid(localMiniAppConfig)) || (!MiniAppConfig.isValid(paramIntent)) || (!MiniAppConfig.equalObj(localMiniAppConfig.config.appId, paramIntent.config.appId)) || (!MiniAppConfig.equalObj(Integer.valueOf(localMiniAppConfig.config.verType), Integer.valueOf(paramIntent.config.verType)))) {
          break label154;
        }
        if ((!paramIntent.isShortcutFakeApp()) && (localGameInfoManager != null)) {
          localGameInfoManager.updateMiniAppConfig(paramIntent);
        }
      }
    }
    for (;;)
    {
      this.mGameAppConfig = loadMiniAppConfig(getIntent());
      MiniGdtReporter.prepareReport();
      checkPayForFriendLogic();
      return;
      localGameInfoManager = null;
      break;
      label154:
      localGameInfoManager.updateMiniAppConfig(paramIntent);
    }
  }
  
  public void doOnPause()
  {
    QLog.e("[minigame] GameActivity", 1, "doOnPause " + getGameInfo());
    super.doOnPause();
    if (getLaunchStatus() == 2) {
      GamePreConnectManager.saveConnectHost(getMiniGameAppId());
    }
    onPauseReport();
    this.mIsEngineResumed = false;
    Object localObject = this.mGameRuntimeLoader.getJsPluginEngine();
    if ((localObject != null) && (((GameJsPluginEngine)localObject).hasInit())) {
      ((GameJsPluginEngine)localObject).onPause();
    }
    notifyGameOnHide();
    bannerOnPause();
    hideKeyBoard();
    this.mGameRuntimeLoader.getGameInfoManager().resetQuery();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.b();
    }
    apoh.a(BaseApplicationImpl.getContext(), 2, true);
    GameGrowthGuardianManager.executeEnd(this, this.mGameAppConfig);
    localObject = this.mGameRuntimeLoader.getGameEngine();
    if (localObject != null) {
      ((TritonEngine)localObject).stop();
    }
    reportTraceInfo(false);
    ThreadPools.getMainThreadHandler().removeCallbacks(this.mFpsScheduler);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.mBeginOnResume = System.currentTimeMillis();
    Intent localIntent = getIntent();
    if ((this.mGameAppConfig == null) && (localIntent != null))
    {
      this.mGameAppConfig = loadMiniAppConfig(localIntent);
      PreCacheManager.g().fetchPreCacheData(this.mGameAppConfig);
      PreCacheManager.g().fetchPreResourceIfNeed(this.mGameAppConfig);
    }
    MiniAppReportManager2.reportPageView("2show", "bring_to_front", null, this.mGameAppConfig);
    long l = System.currentTimeMillis();
    notifyEvent(this.mGameAppConfig, "onResume", l);
    MiniReportManager.reportEventType(this.mGameAppConfig, 1, "1");
    bhlx.a(this);
    lifecycleReport("launch_report_app_resume");
    Object localObject;
    label284:
    label332:
    int i;
    if (!this.mHasInitDataMustOnResume)
    {
      if (!initDataMustOnResume())
      {
        if (this.mGameAppConfig != null)
        {
          MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "load_fail", "init_data_fail");
          MiniAppReportManager2.reportPageView("2launch_fail", "init_data_fail", null, this.mGameAppConfig);
        }
        QLog.e("[minigame] GameActivity", 1, "doOnResume initDataMustOnResume==false finishactivity");
        return;
      }
      setupUI();
      if ((getEnableDebug()) && (this.vConsoleBtn == null)) {
        initVConsoleView();
      }
      this.mHasInitDataMustOnResume = true;
      MiniReportManager.reportEventType(this.mGameAppConfig, 1013, "1");
      processSelectLoadingAdLogic(this.mGameAppConfig);
      AppBrandProxy.g().setMiniAppConfig(this.mGameAppConfig);
      changeWindowInfo(this.mGameAppConfig);
      callEngineOnResume();
      localObject = this.mGameRuntimeLoader.getJsPluginEngine();
      if (((GameJsPluginEngine)localObject).hasInit()) {
        ((GameJsPluginEngine)localObject).onResume();
      }
      notifyGameOnShow();
      if (localIntent == null) {
        break label727;
      }
      l = localIntent.getLongExtra("startDuration", 0L);
      if ((l != 0L) && (MiniAppMonitorInfoView.sStartTime != l))
      {
        MiniAppMonitorInfoView.sStartTime = l;
        MiniAppMonitorInfoView.sStartDuration = System.currentTimeMillis() - l;
      }
      bannerOnResume();
      if (localIntent == null) {
        break label732;
      }
      localObject = (ResultReceiver)localIntent.getParcelableExtra("receiver");
      if (localObject != null) {
        ((ResultReceiver)localObject).send(0, new Bundle());
      }
      if ((this.mGameAppConfig != null) && (this.mGameAppConfig.config != null) && (!TextUtils.isEmpty(this.mGameAppConfig.config.appId)))
      {
        if (localIntent == null) {
          break label738;
        }
        i = localIntent.getIntExtra("start_mode", 3);
        label398:
        if (i != 3) {
          break label743;
        }
        MiniAppStartState.setProcessLoad(this.mGameAppConfig.config.appId, false);
      }
    }
    for (;;)
    {
      this.mIsForground = true;
      if (this.mNeedLaunchGameOnResume) {
        launchGame();
      }
      if (this.mColorNoteController != null) {
        this.mColorNoteController.a();
      }
      apoh.a(BaseApplicationImpl.getContext(), 2, false);
      l = System.currentTimeMillis() - this.mBeginOnResume;
      if (!this.mHasReportStepOnResume)
      {
        this.mHasReportStepOnResume = true;
        MiniReportManager.reportEventType(this.mGameAppConfig, 1035, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
      }
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[onResume] cost time ", Long.valueOf(l), ", include steps[initDataMustOnResume, setupUI] " + getGameInfo() });
      GameGrowthGuardianManager.executeBegin(this, this.mGameAppConfig);
      this.mFpsScheduler.run();
      return;
      this.mOnShowTime = System.currentTimeMillis();
      MiniReportManager.reportEventType(this.mGameAppConfig, 21, "1");
      if ((getLaunchStatus() == 2) && (this.mOnShowTime - this.mLastOnShowReportTime > this.mOnShowReportInterval))
      {
        this.mOnShowReported = true;
        MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "show", "bring_to_front");
      }
      for (;;)
      {
        if (getLaunchStatus() == 2) {
          MiniAppReportManager2.reportPageView("2launch", "click_resume", null, this.mGameAppConfig);
        }
        this.mLastOnShowReportTime = this.mOnShowTime;
        MiniGdtReporter.report(this.mGameRuntimeLoader.getGameInfoManager().getMiniAppConfig(), 0);
        break;
        QLog.e("[minigame] GameActivity", 1, "no need report product onShow, less than interval " + this.mOnShowReportInterval + " getLaunchStatus=" + getLaunchStatus());
      }
      label727:
      l = 0L;
      break label284;
      label732:
      localObject = null;
      break label332;
      label738:
      i = 3;
      break label398;
      label743:
      MiniAppStartState.setProcessLoad(this.mGameAppConfig.config.appId, true);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    QLog.i("[minigame] GameActivity", 1, "doOnStart game");
    Object localObject = getIntent();
    if (localObject == null)
    {
      QLog.e("[minigame] GameActivity", 1, "doOnStart intent==null return....");
      if (this.mGameAppConfig != null)
      {
        MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "load_fail", "start_no_intent");
        MiniAppReportManager2.reportPageView("2launch_fail", "start_no_intent", null, this.mGameAppConfig);
      }
      return;
    }
    if (killAllGamesWhenReuse)
    {
      MiniAppConfig localMiniAppConfig = this.mGameAppConfig;
      localObject = loadMiniAppConfig((Intent)localObject);
      if ((localObject != null) && (((MiniAppConfig)localObject).config != null) && (((MiniAppConfig)localObject).config.appId != null) && (localMiniAppConfig != null) && (localMiniAppConfig.config != null) && (!((MiniAppConfig)localObject).config.appId.equals(localMiniAppConfig.config.appId)))
      {
        QLog.e("[minigame] GameActivity", 1, "doOnStart gameConfig exception, kill self current ====> " + localMiniAppConfig + " <=== newGameConfig ====>" + localObject);
        MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject, "1", null, "load_fail", "appid_conflict");
        MiniAppReportManager2.reportPageView("2launch_fail", "appid_conflict", null, this.mGameAppConfig);
        finish();
        finishMiniProcesses(true);
        Process.killProcess(Process.myPid());
      }
    }
    if (this.mApkgInfo != null) {
      syncForceGroundAndRefreshBadge();
    }
    MiniAppBannerIPCModule.notifyEnterForeground(this.mApkgInfo);
    this.mPerformanceStatics.startReport();
    bjds.b();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    ThreadManagerV2.excute(new GameActivity.17(this), 16, null, true);
    MiniAppBannerIPCModule.notifyEnterBackground(this.mApkgInfo);
    float f2 = 60.0F;
    TritonEngine localTritonEngine = this.mGameRuntimeLoader.getGameEngine();
    float f1 = f2;
    if (localTritonEngine != null)
    {
      f1 = f2;
      if (localTritonEngine.getState() != EngineState.DESTROYED) {
        f1 = localTritonEngine.getStatisticsManager().getTargetFPS();
      }
    }
    this.mPerformanceStatics.stopReport(f1);
    this.mColorNoteController.n();
    bjds.c();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    DisplayUtil.setActivityFullScreen(this);
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void doRefreshMiniBadge(Bundle paramBundle)
  {
    QLog.i("[minigame] GameActivity", 1, "doRefreshMiniBadge");
    super.doRefreshMiniBadge(paramBundle);
    if (paramBundle != null)
    {
      String str = paramBundle.getString("miniAppID");
      if (QLog.isColorLevel()) {
        QLog.d("TAG", 2, "gameactivity doRefreshMiniBadge appID : " + str);
      }
      if (this.mApkgInfo.appId.equals(str))
      {
        int i = paramBundle.getInt("param_proc_badge_count");
        if (QLog.isColorLevel()) {
          QLog.e("[minigame] GameActivity", 2, "doRefreshMiniBadge badge : " + i);
        }
        if ((this.mNavBar != null) && (this.mNavBar.getCapsuleButton() != null)) {
          this.mNavBar.getCapsuleButton().setUnReadCount(i, false);
        }
      }
    }
  }
  
  public void finishActivity()
  {
    QLog.e("[minigame] GameActivity", 1, "finishActivity mIsFromSplash" + this.mIsFromSplash);
    if (this.mIsFromSplash)
    {
      startMainActivity();
      this.mUIHandler.postDelayed(new GameActivity.36(this), 300L);
      return;
    }
    finish();
  }
  
  public BannerAdPosInfo getBannerAdPosInfo()
  {
    return this.mBannerAdPosInfo;
  }
  
  public apkn getColorNoteController()
  {
    return this.mColorNoteController;
  }
  
  public boolean getEnableDebug()
  {
    if (this.mGameAppConfig == null) {
      return false;
    }
    return StorageUtil.getPreference().getBoolean(this.mGameAppConfig.config.appId + "_debug", false);
  }
  
  public GameBrandRuntime getGameBrandRuntime()
  {
    return (GameBrandRuntime)this.mGameRuntimeLoader.getJsPluginEngine().appBrandRuntime;
  }
  
  public JSONObject getGameConfigJson()
  {
    if (this.mGamePackage == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.mGamePackage.getGameConfig());
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public float getGameDensity()
  {
    if (this.mGameDensity > 0.0F) {
      return this.mGameDensity;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    this.mGameDensity = localDisplayMetrics.density;
    QLog.i("[minigame] GameActivity", 1, "density = " + localDisplayMetrics.density + ", ViewUtils.density = " + ViewUtils.getDensity() + ", screenW = " + localDisplayMetrics.widthPixels + ", screenH = " + localDisplayMetrics.heightPixels);
    return this.mGameDensity;
  }
  
  public int getGameHeight()
  {
    return this.mGameHeight;
  }
  
  public ViewGroup getGameParent()
  {
    return this.mContentView;
  }
  
  public View getGameView()
  {
    return this.mGameContainerView;
  }
  
  public int getGameWidth()
  {
    return this.mGameWidth;
  }
  
  public boolean getIsOrientationLandscape()
  {
    return this.mIsOrientationLandscape;
  }
  
  public KeyboardLayout getKeyboard()
  {
    if (this.mKeyboardLayout == null)
    {
      this.mKeyboardLayout = new KeyboardLayout(this);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      this.mContentView.addView(this.mKeyboardLayout, localLayoutParams);
      if (this.mNavBar != null) {
        this.mNavBar.bringToFront();
      }
      this.mSoftKeyboardStateHelper = new bbgo(this.mContentView);
      this.mSoftKeyboardStateHelper.a(this.mListener);
    }
    return this.mKeyboardLayout;
  }
  
  public String getMenuStyle()
  {
    return this.mMenuStyle;
  }
  
  public String getMiniGameAppId()
  {
    if ((this.mGameAppConfig != null) && (this.mGameAppConfig.config != null)) {
      return this.mGameAppConfig.config.appId;
    }
    return "";
  }
  
  public NavigatorBarForMiniGame getNavBar()
  {
    return this.mNavBar;
  }
  
  public long getStartTime()
  {
    return this.mBeginOnCreate;
  }
  
  public boolean hideBannerAd()
  {
    if ((this.mBannerAdPosInfo == null) || (this.mBannerAdOpInfo == null))
    {
      QLog.e("[minigame] GameActivity", 1, "hideBannerAd error, no data");
      return false;
    }
    if ((this.mGdtBannerView != null) && (this.mBannerAdContainer != null) && (this.mBannerAdContainer.getVisibility() == 0))
    {
      this.mBannerAdContainer.setVisibility(8);
      return true;
    }
    return false;
  }
  
  public void hideBlockAd(BlockAdInfo paramBlockAdInfo)
  {
    if (paramBlockAdInfo == null) {}
    for (;;)
    {
      return;
      try
      {
        int i = paramBlockAdInfo.getCompId();
        paramBlockAdInfo = BlockAdManager.getInstance().getBlockAdView(i);
        if (paramBlockAdInfo == null) {
          continue;
        }
        paramBlockAdInfo.clearAnimation();
        paramBlockAdInfo.setVisibility(8);
      }
      finally {}
    }
  }
  
  public void hideKeyBoard()
  {
    if ((this.mKeyboardLayout != null) && (this.mKeyboardLayout.getVisibility() == 0))
    {
      KeyboardHandler.get().hideSoftInput(this, this.mKeyboardLayout.getInputET());
      this.mKeyboardLayout.setVisibility(8);
    }
  }
  
  public void hideMiniAIOEntrance()
  {
    if (this.miniAIOEntryView != null)
    {
      this.miniAIOEntryView.setVisibility(8);
      this.miniAIOEntryView.onDestroy();
      this.miniAIOEntryView = null;
    }
  }
  
  public void notifyGameOnHide()
  {
    Object localObject = this.mGameRuntimeLoader.getJsPluginEngine();
    if (((GameJsPluginEngine)localObject).hasInit())
    {
      QLog.e("[minigame] GameActivity", 1, "onHide()");
      localObject = (LifecyclePlugin)((GameJsPluginEngine)localObject).getPlugin(LifecyclePlugin.class);
      if (localObject != null) {
        ((LifecyclePlugin)localObject).handleLifecycleEvent("onAppEnterBackground", null);
      }
    }
  }
  
  public void notifyGameOnShow()
  {
    GameJsPluginEngine localGameJsPluginEngine = this.mGameRuntimeLoader.getJsPluginEngine();
    JSONObject localJSONObject;
    StringBuilder localStringBuilder;
    if (localGameJsPluginEngine.hasInit())
    {
      localJSONObject = this.mGameRuntimeLoader.getGameInfoManager().getOnShowParam();
      localStringBuilder = new StringBuilder().append("onShow(");
      if (localJSONObject != null) {
        break label97;
      }
    }
    label97:
    for (Object localObject = "";; localObject = localJSONObject.toString())
    {
      QLog.e("[minigame] GameActivity", 1, (String)localObject + ")");
      localObject = (LifecyclePlugin)localGameJsPluginEngine.getPlugin(LifecyclePlugin.class);
      if (localObject != null) {
        ((LifecyclePlugin)localObject).handleLifecycleEvent("onAppEnterForeground", localJSONObject.toString());
      }
      return;
    }
  }
  
  public void notifyGameStop()
  {
    Object localObject = this.mGameRuntimeLoader.getJsPluginEngine();
    if (((GameJsPluginEngine)localObject).hasInit())
    {
      QLog.e("[minigame] GameActivity", 1, "onAppStop()");
      localObject = (LifecyclePlugin)((GameJsPluginEngine)localObject).getPlugin(LifecyclePlugin.class);
      if (localObject != null) {
        ((LifecyclePlugin)localObject).handleLifecycleEvent("onAppStop", null);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new GameActivity.4(this);
      if ((!GameCloseManager.showAlertViewForBattleGame(this, this.mGameAppConfig, (DialogInterface.OnClickListener)localObject)) && (!GameCloseManager.showRetainGuideDialog(this, this.mGameAppConfig, (DialogInterface.OnClickListener)localObject)))
      {
        performMiniGameClose();
        continue;
        QLog.e("[minigame] GameActivity", 1, "[jump_btn, loading page close]");
        finishActivity();
        localObject = PreloadManager.g().getMiniAppConfig();
        if ((localObject != null) && (((MiniAppConfig)localObject).config != null))
        {
          MiniProgramLpReportDC04746.report(((MiniAppConfig)localObject).config.appId, ((MiniAppConfig)localObject).config.version, 2, 1);
          continue;
          QLog.e("[minigame] GameActivity", 1, "[btn_start]");
          tryStartGameWhenReady();
          localObject = PreloadManager.g().getMiniAppConfig();
          if ((localObject != null) && (((MiniAppConfig)localObject).config != null)) {
            MiniProgramLpReportDC04746.report(((MiniAppConfig)localObject).config.appId, ((MiniAppConfig)localObject).config.version, 2, 2);
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onEngineLoad(boolean paramBoolean, String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.mLoadGameStartTime;
    paramString = this.mGameAppConfig;
    int j = this.mStartMode;
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      MiniReportManager.reportEventType(paramString, 1033, null, String.valueOf(j), null, i, "1", l, null);
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[load baseLib] success? " + paramBoolean + ", cost time ", Long.valueOf(l), ", include steps[initTTEngine]" });
      if (!paramBoolean) {
        break;
      }
      this.mIsEngineLoaded = true;
      callEngineOnResume();
      return;
    }
    this.mGameRuntimeLoader.dump();
    MiniGdtReporter.report(this.mGameAppConfig, 510);
    QLog.e("[minigame] GameActivity", 1, new Object[] { "step[load baseLib] fail, retCode=", Integer.valueOf(paramInt) });
    runOnUiThread(new GameActivity.9(this, paramInt));
  }
  
  public void onGpkgLoad(boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis() - this.mLoadGameStartTime;
    paramString = this.mGameAppConfig;
    String str = getLaunchMsg();
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      MiniReportManager.reportEventType(paramString, 1036, null, str, null, i, "1", l, null);
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[load gpkg] success? " + paramBoolean + ", cost time ", Long.valueOf(l), ", include steps[initFileMgr]" });
      if (!paramBoolean) {
        break;
      }
      setAppConfig();
      if ((this.mGameRuntimeLoader.getJsPluginEngine().appBrandRuntime != null) && (this.mGameRuntimeLoader.getMiniGamePkg() != null)) {
        ((GameBrandRuntime)this.mGameRuntimeLoader.getJsPluginEngine().appBrandRuntime).setNetworkTimeout(this.mGameRuntimeLoader.getMiniGamePkg().networkTimeoutInfo);
      }
      return;
    }
    this.mGameRuntimeLoader.dump();
    MiniGdtReporter.report(this.mGameAppConfig, 511);
    runOnUiThread(new GameActivity.7(this));
  }
  
  public void onInitRuntimeDone()
  {
    long l = System.currentTimeMillis() - this.mLoadGameStartTime;
    MiniReportManager.reportEventType(this.mGameAppConfig, 1037, null, getLaunchMsg(), null, 0, "1", l, null);
    QLog.e("[minigame][timecost] ", 1, new Object[] { "[MiniEng] step[init runTime] cost time ", Long.valueOf(l), ", include steps[load baseLib, load gpkg]" });
    this.mLaunchEngineUISteps.onRuntimeInitDone();
    if (this.mIsFromSplash)
    {
      this.mSplashLoadComplete = true;
      runOnUiThread(new GameActivity.6(this));
      return;
    }
    tryStartGameWhenReady();
  }
  
  public void onJsPluginEngineLoad(boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis() - this.mLoadGameStartTime;
    paramString = this.mGameAppConfig;
    int j = this.mStartMode;
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      MiniReportManager.reportEventType(paramString, 1034, null, String.valueOf(j), null, i, "1", l, null);
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[initJsPluginList] success? " + paramBoolean + ", cost time ", Long.valueOf(l) });
      if (!paramBoolean) {
        this.mGameRuntimeLoader.dump();
      }
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      notifyGameStop();
      if (GameWnsUtils.needBackPressHint(this.mGameRuntimeLoader.getGameInfoManager().getAppId()))
      {
        long l = System.currentTimeMillis();
        if (l - this.mFirstBackPressTime > 2000L)
        {
          if (!TextUtils.isEmpty(this.mBackPressHint)) {
            QQToast.a(this, 0, this.mBackPressHint, 0).a();
          }
          this.mFirstBackPressTime = l;
          paramKeyEvent = (LifecyclePlugin)this.mGameRuntimeLoader.getJsPluginEngine().getPlugin(LifecyclePlugin.class);
          if (paramKeyEvent != null) {
            paramKeyEvent.handleLifecycleEvent("onPause", "{}");
          }
          return true;
        }
      }
      if (this.mGameAppConfig != null)
      {
        if (getLaunchStatus() != 2) {
          break label140;
        }
        MiniAppReportManager2.reportPageView("2back_key", "inner_page", null, this.mGameAppConfig);
      }
    }
    for (;;)
    {
      return super.onKeyUp(paramInt, paramKeyEvent);
      label140:
      MiniAppReportManager2.reportPageView("2back_key", "loading_page", null, this.mGameAppConfig);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView.getId();
    return true;
  }
  
  public void onPreloadEngineLoad(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.i("[minigame] GameActivity", 1, "onPreloadEngineLoad");
    onEngineLoad(paramBoolean, paramString, paramInt);
  }
  
  public void onPreloadGpkgLoad(boolean paramBoolean, String paramString)
  {
    QLog.i("[minigame] GameActivity", 1, "onPreloadGpkgLoad");
    onGpkgLoad(paramBoolean, paramString);
  }
  
  public void onPreloadInitRuntimeDone()
  {
    QLog.i("[minigame] GameActivity", 1, "onPreloadInitRuntimeDone");
    onInitRuntimeDone();
  }
  
  public void onPreloadTaskProgress(BaseTask paramBaseTask, float paramFloat, String paramString)
  {
    QLog.i("[minigame] GameActivity", 1, "onPreloadTaskProgress");
    onTaskProgress(paramBaseTask, paramFloat, paramString);
  }
  
  public void onProcessBackground(Bundle paramBundle)
  {
    QLog.i("[minigame] GameActivity", 1, "onProcessBackground");
    super.onProcessBackground(paramBundle);
  }
  
  public void onProcessForeGround(Bundle paramBundle)
  {
    QLog.i("[minigame] GameActivity", 1, "onProcessForeGround");
    super.onProcessForeGround(paramBundle);
  }
  
  public void onRefreshMiniBadge(Bundle paramBundle)
  {
    QLog.i("[minigame] GameActivity", 1, "onRefreshMiniBadge");
    super.onRefreshMiniBadge(paramBundle);
  }
  
  public void onRequestDragAdData(FloatDragAdInfo paramFloatDragAdInfo)
  {
    if (paramFloatDragAdInfo != null)
    {
      if (this.mFloatDragAdManager == null) {
        this.mFloatDragAdManager = new FloatDragAdManager(this, getGameParent());
      }
      this.mFloatDragAdManager.showDragAd(this, paramFloatDragAdInfo);
    }
    while (this.mFloatDragAdManager == null) {
      return;
    }
    this.mFloatDragAdManager.removeDragAd();
  }
  
  public void onTaskProgress(BaseTask paramBaseTask, float paramFloat, String paramString)
  {
    if ((paramBaseTask instanceof GpkgLoadAsyncTask))
    {
      if ((paramFloat > 0.0F) && (paramFloat < 1.0F)) {
        this.mPkgDownloadFlag = true;
      }
      setProgressTxt(paramFloat, paramString);
    }
    while (!(paramBaseTask instanceof TritonEngineInitTask)) {
      return;
    }
    setProgressTxt(paramFloat, paramString);
  }
  
  public void onVConsoleMoveUp()
  {
    initVConsoleLayout();
    this.mVConsoleManager.updateVconsoleView(this.vConsoleView, this.vConsoleBtn, true);
  }
  
  protected void performMiniGameClose()
  {
    QLog.e("[minigame] GameActivity", 1, "[btn_close, loading page close]");
    MiniReportManager.reportEventType(this.mGameAppConfig, 1026, "1");
    MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "close", "loading_page");
    MiniAppReportManager2.reportPageView("2close", "loading_page", null, this.mGameAppConfig);
    notifyGameStop();
    finishActivity();
  }
  
  protected void quitDebugSocket()
  {
    if (this.mQQDebugSocket != null) {
      this.mQQDebugSocket.sendQuitDebugMsgInfo();
    }
  }
  
  protected void reportOnBackPressed()
  {
    if (this.mGameAppConfig != null)
    {
      if (getLaunchStatus() == 0) {
        MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "load_fail", "loading_page_back_press");
      }
      while (getLaunchStatus() != 1) {
        return;
      }
      MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "show_fail", "loading_page_back_press");
      return;
    }
    QLog.e("[minigame] GameActivity", 1, "reportOnBackPressed gameConfig=null");
  }
  
  public void setColorSignAddListener(OtherJsPlugin.AddColorSignListener paramAddColorSignListener)
  {
    this.mAddColorSingListener = paramAddColorSignListener;
  }
  
  public void setMenuStyle(String paramString)
  {
    if (("light".equals(paramString)) || ("dark".equals(paramString))) {
      this.mMenuStyle = paramString;
    }
  }
  
  public void setStatusBarTextColor(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().getDecorView().setSystemUiVisibility(1282);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    for (;;)
    {
      if ((Build.VERSION.SDK_INT >= 23) && (paramBoolean)) {
        getWindow().getDecorView().setSystemUiVisibility(9218);
      }
      return;
      if (Build.VERSION.SDK_INT >= 19)
      {
        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        localLayoutParams.flags = (0x4000000 | localLayoutParams.flags);
      }
    }
  }
  
  public boolean showBannerAd()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if ((this.mBannerAdOpInfo == null) || (this.mBannerAdPosInfo == null))
        {
          QLog.e("[minigame] GameActivity", 1, "showBannerAd error, data is null");
          return bool;
        }
        if (!this.mBannerAdPosInfo.isValid())
        {
          QLog.e("[minigame] GameActivity", 1, "showBannerAd error, adPosInfo is invalid." + this.mBannerAdPosInfo);
          continue;
        }
        if (this.mGdtBannerView == null) {
          break label92;
        }
      }
      finally {}
      if (this.mBannerAdContainer == null)
      {
        label92:
        QLog.e("[minigame] GameActivity", 1, "showBannerAd error, mGdtBannerView == null");
      }
      else if ((!this.mHasNewAd) && (this.mBannerAdContainer.getChildCount() > 0))
      {
        this.mBannerAdContainer.setVisibility(0);
        bool = true;
      }
      else
      {
        this.mBannerAdContainer.removeAllViews();
        if (this.mGdtBannerView != null)
        {
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth), gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight));
          localLayoutParams.leftMargin = gameDpTopx(this.mBannerAdPosInfo.mAdLeft);
          localLayoutParams.topMargin = gameDpTopx(this.mBannerAdPosInfo.mAdTop);
          this.mBannerAdContainer.addView(this.mGdtBannerView.a(), localLayoutParams);
          this.mBannerAdContainer.setVisibility(0);
          this.mGdtBannerAd.onDisplay();
          if (this.mNavBar != null) {
            this.mNavBar.bringToFront();
          }
          if (this.mHasNewAd)
          {
            if (!AdUtils.isHitReport50ViewAndOneSecond(new GdtAd(this.mBannerAdOpInfo))) {
              break label309;
            }
            initAdExposureChecker(this.mBannerAdOpInfo, this.mGdtBannerView.a());
          }
          for (;;)
          {
            this.mHasNewAd = false;
            bool = true;
            break;
            label309:
            if ((this.mBannerAdOpInfo != null) && (this.mBannerAdOpInfo.report_info != null) && (this.mBannerAdOpInfo.report_info.exposure_url != null)) {
              reportBannerAd(this.mBannerAdOpInfo.report_info.exposure_url.get(), System.currentTimeMillis());
            }
          }
        }
        QLog.e("[minigame] GameActivity", 1, "showBannerAd error, mGdtBannerView is null");
      }
    }
  }
  
  public boolean showBlockAd(BlockAdInfo paramBlockAdInfo)
  {
    boolean bool = false;
    if (paramBlockAdInfo == null) {}
    for (;;)
    {
      return bool;
      try
      {
        int i = paramBlockAdInfo.getCompId();
        Object localObject = BlockAdManager.getInstance().getBlockAdView(i);
        if (localObject != null)
        {
          i = paramBlockAdInfo.getLeft();
          int j = paramBlockAdInfo.getTop();
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(10);
          localLayoutParams.leftMargin = gameDpTopx(i);
          localLayoutParams.topMargin = gameDpTopx(j);
          ((BlockAdView)localObject).setVisibility(0);
          if (((BlockAdView)localObject).getParent() != null) {
            ((ViewGroup)((BlockAdView)localObject).getParent()).removeView((View)localObject);
          }
          this.mContentView.addView((View)localObject, localLayoutParams);
          ((BlockAdView)localObject).startBlockAnimation();
          if (this.mNavBar != null) {
            this.mNavBar.bringToFront();
          }
          paramBlockAdInfo = paramBlockAdInfo.getGdtAdInfoList();
          if ((paramBlockAdInfo != null) && (paramBlockAdInfo.size() > 0))
          {
            paramBlockAdInfo = paramBlockAdInfo.iterator();
            while (paramBlockAdInfo.hasNext())
            {
              localObject = (GdtAd)paramBlockAdInfo.next();
              if ((localObject != null) && (((GdtAd)localObject).info != null) && (((GdtAd)localObject).info.report_info != null) && (((GdtAd)localObject).info.report_info.exposure_url != null)) {
                reportAdByHttp(((GdtAd)localObject).info.report_info.exposure_url.get());
              }
            }
          }
          bool = true;
        }
      }
      finally {}
    }
  }
  
  public boolean showMiniAIOEntrance(JSONObject paramJSONObject)
  {
    int i = -10;
    Object localObject = "";
    int j;
    if (paramJSONObject != null)
    {
      j = (int)(this.mGameDensity * paramJSONObject.optInt("x", -10) + 0.5F);
      i = (int)(this.mGameDensity * paramJSONObject.optInt("y", -10) + 0.5F);
    }
    for (paramJSONObject = paramJSONObject.optString("style");; paramJSONObject = (JSONObject)localObject)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = j;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      if ((j < 0) || (i < 0)) {
        return false;
      }
      if (this.miniAIOEntryView == null)
      {
        this.miniAIOEntryView = new MiniAIOEntryView(this, paramJSONObject);
        this.mContentView.addView(this.miniAIOEntryView, (ViewGroup.LayoutParams)localObject);
      }
      for (;;)
      {
        return true;
        this.miniAIOEntryView.setMiniAIOStyle(paramJSONObject);
        this.miniAIOEntryView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mContentView.requestLayout();
      }
      j = -10;
    }
  }
  
  public void startLoadGame()
  {
    QLog.e("[minigame] GameActivity", 1, "--startLoadGame--");
    if ((this.mGameAppConfig != null) && (this.mGameAppConfig.config != null) && (this.mGameAppConfig.config.debugInfo != null) && (!TextUtils.isEmpty(this.mGameAppConfig.config.debugInfo.wsUrl)) && (this.mGameAppConfig.launchParam != null) && (this.mGameAppConfig.launchParam.scene == 1011))
    {
      QLog.e("[minigame] GameActivity", 1, "startLoadGame on ide debug mode");
      this.mQQDebugSocket = new QQDebugWebSocket(this.mGameAppConfig.config.appId, this.mGameAppConfig.config.debugInfo);
      GameJsPluginEngine localGameJsPluginEngine = this.mGameRuntimeLoader.getJsPluginEngine();
      if (localGameJsPluginEngine.hasInit()) {
        localGameJsPluginEngine.registerPlugin(this.mQQDebugSocket.jsPlugin);
      }
      this.mQQDebugSocket.startConnectIDE(new GameActivity.32(this));
      return;
    }
    QLog.e("[minigame] GameActivity", 1, "startLoadGame on real mode");
    launchGame();
  }
  
  public void tryStartGameWhenReady()
  {
    if (!this.mGameRuntimeLoader.isGameReadyStart())
    {
      QLog.e("[minigame] GameActivity", 1, "onLoadFail finish game Activity!");
      MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "load_fail", "not_ready");
      MiniAppReportManager2.reportPageView("2launch_fail", "not_ready", null, this.mGameAppConfig);
      return;
    }
    if (NetworkUtil.getSystemNetwork(getActivity()) == 0)
    {
      if (!this.mGameAppConfig.config.isSupportOffline)
      {
        MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "load_fail", "offline_not_support");
        MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_support", null, this.mGameAppConfig);
        QQToast.a(this, amtj.a(2131704126), 0).a();
        return;
      }
      if (!GpkgManager.isOfflineResourceReady(this.mGameAppConfig))
      {
        MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "load_fail", "offline_not_ready");
        MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_ready", null, this.mGameAppConfig);
        QQToast.a(this, amtj.a(2131704131), 0).a();
        return;
      }
    }
    QLog.i("[minigame] GameActivity", 1, "[MiniEng] Start Game! SO Engine:" + this.mGameRuntimeLoader.getTritonEnginePackage());
    runOnUiThread(new GameActivity.12(this));
  }
  
  public boolean updateBannerAdPosition(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        QLog.i("[minigame] GameActivity", 1, "updateBannerAdPosition");
        if ((this.mBannerAdPosInfo == null) || (this.mBannerAdOpInfo == null))
        {
          QLog.e("[minigame] GameActivity", 1, "updateBannerAdPosition error, no data");
          return bool;
        }
        switch (paramInt1)
        {
        default: 
          if ((this.mGdtBannerView == null) || (this.mBannerAdContainer == null) || (this.mBannerAdContainer.getChildCount() <= 0)) {
            break label275;
          }
          View localView = this.mBannerAdContainer.getChildAt(0);
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
          localLayoutParams.leftMargin = gameDpTopx(this.mBannerAdPosInfo.mAdLeft);
          localLayoutParams.topMargin = gameDpTopx(this.mBannerAdPosInfo.mAdTop);
          localLayoutParams.width = gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth);
          localLayoutParams.height = gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight);
          this.mGdtBannerView.setSize(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth), gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight));
          localView.setLayoutParams(localLayoutParams);
        }
      }
      finally {}
      this.mBannerAdPosInfo.mAdLeft = paramInt2;
      continue;
      this.mBannerAdPosInfo.mAdTop = paramInt2;
      continue;
      this.mBannerAdPosInfo.mAdRealWidth = paramInt2;
      this.mBannerAdPosInfo.mAdRealHeight = ablw.a(0, paramInt2);
      continue;
      label275:
      bool = true;
    }
  }
  
  public boolean updateBlockAdPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    BlockAdView localBlockAdView = BlockAdManager.getInstance().getBlockAdView(paramInt3);
    if (localBlockAdView == null) {
      return false;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(10);
    localLayoutParams.leftMargin = gameDpTopx(paramInt1);
    localLayoutParams.topMargin = gameDpTopx(paramInt2);
    localBlockAdView.setLayoutParams(localLayoutParams);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity
 * JD-Core Version:    0.7.0.1
 */