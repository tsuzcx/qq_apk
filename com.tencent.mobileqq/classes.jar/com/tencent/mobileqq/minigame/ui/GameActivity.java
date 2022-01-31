package com.tencent.mobileqq.minigame.ui;

import ajjy;
import alrv;
import aluq;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.ResultReceiver;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
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
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import avwj;
import avwk;
import babr;
import badq;
import bafb;
import bajq;
import bbmy;
import bbqo;
import bfpj;
import bjeh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.DebugInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniGamePluginInfo;
import com.tencent.mobileqq.mini.apkg.NavigationBarInfo;
import com.tencent.mobileqq.mini.apkg.NetworkTimeoutInfo;
import com.tencent.mobileqq.mini.apkg.WindowInfo;
import com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.launch.MiniAppStartUtils;
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
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.minigame.data.BannerAdPosInfo;
import com.tencent.mobileqq.minigame.debug.QQDebugWebSocket;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.mobileqq.minigame.jsapi.manager.GameVideoPlayerManager;
import com.tencent.mobileqq.minigame.jsapi.manager.KeyboardHandler;
import com.tencent.mobileqq.minigame.jsapi.widgets.KeyboardLayout;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.minigame.manager.GameLoadManager.GameLoadListener;
import com.tencent.mobileqq.minigame.manager.PreloadManager;
import com.tencent.mobileqq.minigame.manager.PreloadManager.PreloadListener;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.task.GameEngineLoadTask;
import com.tencent.mobileqq.minigame.task.GameJsPluginEngineTask;
import com.tencent.mobileqq.minigame.task.GpkgLoadAsyncTask;
import com.tencent.mobileqq.minigame.utils.CPUUtil;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.minigame.utils.VConsoleLogManager;
import com.tencent.mobileqq.minigame.utils.VConsoleManager;
import com.tencent.mobileqq.minigame.widget.DragLinearLayout;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.debug.GameDebugInfo;
import com.tencent.mobileqq.triton.sdk.game.GamePluginInfo;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import yjs;
import ykt;
import yku;
import ykv;

public class GameActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener, GameLoadManager.GameLoadListener, PreloadManager.PreloadListener, VConsoleDragView.Listener
{
  private static final int LAUNCH_STATUS_CLICK = 0;
  private static final int LAUNCH_STATUS_FIRST_FRAME = 2;
  private static final int LAUNCH_STATUS_LOAD = 1;
  private static final int MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES_THRESHOLD;
  private static final String PREF_KEY_MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES = "pref_key_mini_game_close_confirm_exposure_times";
  private static final String TAG = "[minigame] GameActivity";
  private static final Drawable defaultDrawable;
  private static int killAllGamesWhenDestroy = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillAllGamesWhenDestroy", 0);
  private static int killAllGamesWhenReuse;
  private static URLDrawable.URLDrawableOptions sDrawableOptions;
  public static URLDrawable sGameDrawable;
  public static final int sIconSize = DisplayUtil.dip2px(BaseApplicationImpl.getContext(), 100.0F);
  public static boolean sStorageReport;
  private RelativeLayout LoadingContainer;
  private ykt bannerParams;
  private long beginOnCreate;
  private long beginOnResume;
  private ViewGroup contentView;
  protected boolean doNotMoveTaskToBackThisTime;
  Runnable execJS = new GameActivity.29(this);
  private GameBrandRuntime gameBrandRuntime;
  protected MiniAppConfig gameConfig;
  private GameJsPluginEngine gameJsPluginEngine;
  private boolean hasInit;
  private boolean hasLaunchedGame;
  private boolean hasReportStepOnResume;
  private KeyboardLayout keyboardLayout;
  private long loadGameStartTime;
  private ApkgInfo mApkgInfo;
  private String mBackPressHint = GameWnsUtils.getBackPressHint();
  protected FrameLayout mBannerAdContainer;
  protected long mBannerAdLastClickTime;
  protected qq_ad_get.QQAdGetRsp.AdInfo mBannerAdOpInfo;
  protected BannerAdPosInfo mBannerAdPosInfo;
  private long mBeginExecJs;
  private LinearLayout mBottonLayout;
  private GameActivity.MonitorBroadcastReceiver mBroadcastReceiver;
  private LinearLayout mCenterLayout;
  private ImageView mCloseView;
  protected alrv mColorNoteController;
  private TextView mDebuggerEndBtn;
  private View mDebuggerLayer;
  private TextView mDebuggerStatusTv;
  private DragLinearLayout mDebuggerView;
  private LinearLayout mDeveloperDescLayout;
  private TextView mDeveloperDescView;
  private EngineChannel mEngineChannel;
  private long mFirstBackPressTime;
  private FPSCallback mFpsListener = new GameActivity.1(this);
  private float mGameDensity = -1.0F;
  private int mGameHeight;
  private MiniGameInfo mGameInfo;
  private TextView mGameInstruction;
  private View mGameSurfaceView;
  private TextView mGameVersionDesc;
  private int mGameWidth;
  protected yku mGdtBannerView;
  protected GdtDwellTimeStatisticsAfterClick mGdtDwellTimeStatisticsAfterClick;
  private boolean mHasInited;
  protected boolean mHasNewAd;
  private boolean mIsEngineLoaded;
  private boolean mIsEngineResumed;
  private boolean mIsForground = true;
  private boolean mIsFromSplash;
  private boolean mIsOrientationLandscape;
  private TextView mJumpBtn;
  private long mLastOnShowReportTime;
  private int mLaunchStatus = 0;
  private avwk mListener = new GameActivity.34(this);
  private SquareImageView mLogoView;
  private String mMenuStyle = "light";
  public MiniAppMonitorInfoView mMiniAppMonitorInfoView;
  private ImageView mMoreView;
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
  private final MiniGamePerformanceStatics mPerformanceStatics = new MiniGamePerformanceStatics();
  private boolean mPkgDownloadFlag;
  private String mProgressStr = "0%";
  private TextView mProgressTxt;
  private QQDebugWebSocket mQQDebugSocket;
  private MqqHandler mReportHandler;
  private avwj mSoftKeyboardStateHelper;
  private LinearLayout mSplashLayout;
  private boolean mSplashLoadComplete;
  private ProgressBar mSplashProgressBar;
  private TextView mSplashProgressTxt;
  private ImageView mStartView;
  private ITTEngine mTTEngine;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private VConsoleLogManager mVConsoleManager;
  private RelativeLayout rightContainer;
  private VConsoleDragView vConsoleBtn;
  private VConsoleView vConsoleView;
  private boolean vConsoleViewHasInited;
  
  static
  {
    defaultDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130840829);
    MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES_THRESHOLD = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_exit_confirm_animation_expoure_times_threshold", 3);
    killAllGamesWhenReuse = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillAllGamesWhenReuse", 0);
  }
  
  private void callEngineOnResume()
  {
    runOnUiThread(new GameActivity.8(this));
  }
  
  private void changeWindowInfo(MiniAppConfig paramMiniAppConfig)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ThreadManagerV2.excute(new GameActivity.12(this, paramMiniAppConfig), 16, null, false);
  }
  
  private boolean checkDoubleClick()
  {
    long l = System.currentTimeMillis();
    if (l - this.mBannerAdLastClickTime < 500L) {}
    for (boolean bool = true;; bool = false)
    {
      this.mBannerAdLastClickTime = l;
      return bool;
    }
  }
  
  private void doRequestByAppid(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new GameActivity.20(this, paramLaunchParam));
  }
  
  private void doRequestByLink(String paramString1, int paramInt, String paramString2, LaunchParam paramLaunchParam)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString1, paramInt, new GameActivity.21(this, paramLaunchParam));
  }
  
  private static boolean enableXiaoMiNotch(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getWindow();
      Window.class.getMethod("addExtraFlags", new Class[] { Integer.TYPE }).invoke(paramActivity, new Object[] { Integer.valueOf(1792) });
      if (QLog.isColorLevel()) {
        QLog.i("[minigame] GameActivity", 1, "enableXiaoMiNotch true");
      }
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("[minigame] GameActivity", 1, "enableXiaoMiNotch Exception", paramActivity);
      }
    }
    return false;
  }
  
  private void exitWhenFail()
  {
    this.mUIHandler.postDelayed(new GameActivity.2(this), 1500L);
  }
  
  private void exitWhenSuccess()
  {
    onBaseLibAndGameReady();
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
  
  private yjs getBannerClickParams()
  {
    if (this.mBannerAdOpInfo == null) {
      return null;
    }
    Object localObject = new GdtAppReceiver();
    yjs localyjs = new yjs();
    localyjs.jdField_a_of_type_Int = 11;
    localyjs.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getActivity());
    localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(this.mBannerAdOpInfo);
    localyjs.jdField_a_of_type_Boolean = true;
    localyjs.jdField_b_of_type_Boolean = true;
    localyjs.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
    localyjs.jdField_b_of_type_JavaLangClass = GameBannerAdFragment.class;
    localObject = new Bundle();
    ((Bundle)localObject).putString("big_brother_ref_source_key", "biz_src_miniapp");
    localyjs.jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject);
    return localyjs;
  }
  
  private String getGameInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("gameConfig:");
    if (this.gameConfig != null) {}
    for (String str = this.gameConfig.getConfigInfo();; str = "null") {
      return str;
    }
  }
  
  private GameJsPluginEngine getGameJsPluginEngine()
  {
    GameJsPluginEngine localGameJsPluginEngine2 = GameJsPluginEngineTask.g(BaseApplicationImpl.getApplication()).getJsPluginEngine();
    GameJsPluginEngine localGameJsPluginEngine1 = localGameJsPluginEngine2;
    if (localGameJsPluginEngine2 == null) {
      localGameJsPluginEngine1 = new GameJsPluginEngine();
    }
    localGameJsPluginEngine1.onAttachWindow(this);
    localGameJsPluginEngine1.setAppBrandRuntime(this.gameBrandRuntime);
    return localGameJsPluginEngine1;
  }
  
  private int getLaunchStatus()
  {
    return this.mLaunchStatus;
  }
  
  private void hideLoadingLayout()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.LoadingContainer, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.addListener(new GameActivity.10(this));
    localObjectAnimator.start();
    localObjectAnimator = ObjectAnimator.ofFloat(this.mGameSurfaceView, "alpha", new float[] { 0.5F, 1.0F });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.start();
    if ((!this.mIsOrientationLandscape) && (bjeh.jdField_c_of_type_Int > bjeh.b))
    {
      bjeh.jdField_c_of_type_Boolean = false;
      bjeh.a(this);
      if (bjeh.b()) {
        bjeh.c(this);
      }
      if (this.mNavBar != null) {
        this.mNavBar.requestPortraitLayout();
      }
    }
  }
  
  private boolean initDataMustOnResume()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = getIntent();
    if (localObject1 == null)
    {
      QLog.e("[minigame] GameActivity", 1, "initDataMustOnResume intent==null");
      return false;
    }
    this.mEngineChannel = ((EngineChannel)((Intent)localObject1).getParcelableExtra("engineChannel"));
    if (this.gameConfig == null) {
      this.gameConfig = loadMiniAppConfig((Intent)localObject1);
    }
    this.mPerformanceStatics.setGameConfig(this.gameConfig);
    if (this.gameConfig == null)
    {
      QLog.e("[minigame] GameActivity", 1, "initDataMustOnResume gameConfig is null");
      return false;
    }
    if (this.mIsFromSplash) {
      MiniAppUtils.notityPullDownEntryInMainProcess(this.gameConfig);
    }
    if (this.gameConfig.isShortcutFakeApp())
    {
      QLog.i("[minigame] GameActivity", 1, "GameActivity doOnCreate gameConfig is from Shortcut.");
      doRequestByAppid(this.gameConfig.config.appId, "", this.gameConfig.config.getVerTypeStr(), this.gameConfig.launchParam);
      return true;
    }
    if (this.gameConfig.isFromShowInfo())
    {
      if (this.gameConfig.link != null) {
        doRequestByLink(this.gameConfig.link, this.gameConfig.linkType, this.gameConfig.config.getVerTypeStr(), this.gameConfig.launchParam);
      }
      for (;;)
      {
        return true;
        doRequestByAppid(this.gameConfig.config.appId, this.gameConfig.entryPath, this.gameConfig.config.getVerTypeStr(), this.gameConfig.launchParam);
      }
    }
    if ((this.gameConfig.config != null) && (!TextUtils.isEmpty(this.gameConfig.config.appId))) {
      if (this.gameConfig.config.debugInfo == null) {
        break label799;
      }
    }
    label799:
    for (localObject1 = new GameDebugInfo(this.gameConfig.config.debugInfo.wsUrl, this.gameConfig.config.debugInfo.roomId, 0);; localObject1 = null)
    {
      if (this.gameConfig.config.miniGamePluginInfo != null) {
        localObject2 = this.gameConfig.config.miniGamePluginInfo;
      }
      for (Object localObject2 = Collections.singletonList(new GamePluginInfo(((MiniGamePluginInfo)localObject2).name, ((MiniGamePluginInfo)localObject2).id, ((MiniGamePluginInfo)localObject2).version, ApkgManager.getGpkgPluginFolderPath((MiniGamePluginInfo)localObject2) + File.separator + "plugin.js"));; localObject2 = null)
      {
        this.mGameInfo = new MiniGameInfo(this.gameConfig.config.appId, this.gameConfig.config.version, this.gameConfig.config.verType, null, (GameDebugInfo)localObject1, (List)localObject2);
        this.mApkgInfo = new ApkgInfo(GpkgManager.getGpkgFolderPath(this.mGameInfo), this.gameConfig);
        if (this.gameBrandRuntime == null)
        {
          this.gameBrandRuntime = new GameBrandRuntime(this, this.mApkgInfo);
          this.gameBrandRuntime.setAppId(this.mApkgInfo.appId);
        }
        if (this.gameJsPluginEngine == null) {
          this.gameJsPluginEngine = getGameJsPluginEngine();
        }
        l = System.currentTimeMillis() - l;
        MiniReportManager.reportEventType(this.gameConfig, 1032, null, null, null, 0, "1", l, null);
        QLog.e("[minigame][timecost] ", 1, new Object[] { "step[initDataMustOnResume] cost time ", Long.valueOf(l) });
        this.loadGameStartTime = System.currentTimeMillis();
        if (this.mIsFromSplash) {
          if (PreloadManager.g().getState() == 2)
          {
            this.mUIHandler.post(new GameActivity.17(this));
            this.mSplashLoadComplete = true;
            this.mProgressStr = "100%";
          }
        }
        for (;;)
        {
          ThreadManagerV2.excute(new GameActivity.18(this), 16, null, false);
          return true;
          if (PreloadManager.g().getState() == 1)
          {
            PreloadManager.g().setListener(this);
            this.mProgressStr = ((int)(PreloadManager.g().getProgress() * 100.0F) + "%");
          }
          else
          {
            MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "load_fail", "splash_exit_when_fail");
            MiniAppReportManager2.reportPageView("2launch_fail", "splash_exit_when_fail", null, this.gameConfig);
            QLog.e("[minigame] GameActivity", 1, "initDataMustOnResume exitWhenFail state=" + PreloadManager.g().getState());
            exitWhenFail();
            continue;
            GameLoadManager.g().setEngineChannel(this.mEngineChannel);
            GameLoadManager.g().start(this.gameConfig, this, this.gameJsPluginEngine);
          }
        }
      }
    }
  }
  
  private void initDebuggerLayout()
  {
    if (this.mDebuggerView == null)
    {
      this.mDebuggerView = ((DragLinearLayout)((ViewStub)findViewById(2131299388)).inflate());
      this.mDebuggerLayer = findViewById(2131299384);
      this.mDebuggerStatusTv = ((TextView)findViewById(2131299387));
      this.mDebuggerEndBtn = ((TextView)findViewById(2131299385));
      this.mDebuggerEndBtn.setOnClickListener(new GameActivity.27(this));
    }
  }
  
  private void initGameUI()
  {
    if (this.hasInit) {
      return;
    }
    boolean bool;
    if ((this.mGameInfo != null) && (GameLoadManager.g().getMiniGamePkg() != null))
    {
      this.mGameInfo.gameConfigJson = GameLoadManager.g().getMiniGamePkg().mGameConfigJson;
      if (this.mGameInfo.gameConfigJson != null)
      {
        this.mGameInfo.openDataPath = this.mGameInfo.gameConfigJson.optString("openDataContext", null);
        this.mGameInfo.deviceOrientation = this.mGameInfo.gameConfigJson.optString("deviceOrientation", null);
        if ("landscape".equals(this.mGameInfo.deviceOrientation))
        {
          this.mIsOrientationLandscape = true;
          setRequestedOrientation(0);
          if (this.mNavBar != null) {
            this.mNavBar.requestLandscapeLayout();
          }
          if (this.vConsoleBtn != null) {
            this.vConsoleBtn.requestLandscapeLayout();
          }
        }
        bool = this.mGameInfo.gameConfigJson.optBoolean("showStatusBar", false);
        QLog.i("[minigame] GameActivity", 1, "initGameUI game config showStatusBar=" + bool);
        if (!bool) {
          getWindow().setFlags(1024, 1024);
        }
      }
    }
    QLog.e("[minigame] GameActivity", 1, "initGameUI start create game SurfaceView & inject preload js");
    long l = System.currentTimeMillis();
    this.mTTEngine.onCreate(this);
    int j = getResources().getDisplayMetrics().widthPixels;
    int i = getResources().getDisplayMetrics().heightPixels;
    Object localObject;
    int k;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject = new DisplayMetrics();
      ((WindowManager)getSystemService("window")).getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
      i = ((DisplayMetrics)localObject).heightPixels;
      j = ((DisplayMetrics)localObject).widthPixels;
      this.mGameDensity = ((DisplayMetrics)localObject).density;
      if (!Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
        break label596;
      }
      k = j;
      if (Settings.Secure.getInt(getContentResolver(), "display_notch_status", 0) == 1)
      {
        k = j;
        if (this.mGameInfo.isOrientationLandscape()) {
          k = j - bajq.a(this);
        }
      }
      j = k;
    }
    label670:
    for (;;)
    {
      int m;
      if ((!this.mGameInfo.isOrientationLandscape()) || (j > i))
      {
        m = i;
        k = j;
        if (!this.mGameInfo.isOrientationLandscape())
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
      this.mGameSurfaceView = this.mTTEngine.createGameView(this, k, m);
      this.contentView.addView(this.mGameSurfaceView, 0);
      GameVideoPlayerManager.getInstance().init(this, (ViewGroup)this.mGameSurfaceView);
      localObject = this.mTTEngine.getGameLauncher();
      if (localObject != null) {
        ((IGameLauncher)localObject).setCurrentGame(this.mGameInfo);
      }
      this.mTTEngine.addFPSCallback(this.mFpsListener);
      this.mTTEngine.setEngineListener(new GameActivity.24(this, l));
      localObject = this.mTTEngine;
      if (QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameCodeCacheEnable", 1) == 1) {}
      for (bool = true;; bool = false)
      {
        ((ITTEngine)localObject).setEnableCodeCache(bool);
        this.hasInit = true;
        return;
        label596:
        if ((!Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) || (Settings.Global.getInt(getContentResolver(), "force_black", 0) != 1)) {
          break label670;
        }
        QLog.i("[minigame] GameActivity", 1, "xiaomi has notch");
        if (this.mGameInfo.isOrientationLandscape())
        {
          j -= bajq.a(this);
          break;
        }
        k = bajq.a(this);
        i -= k;
        break;
      }
    }
  }
  
  private void initJsPluginEngine()
  {
    long l = System.currentTimeMillis();
    if (this.gameBrandRuntime == null)
    {
      this.gameBrandRuntime = new GameBrandRuntime(this, this.mApkgInfo);
      this.gameBrandRuntime.setAppId(this.mApkgInfo.appId);
    }
    if (this.gameJsPluginEngine == null) {
      this.gameJsPluginEngine = getGameJsPluginEngine();
    }
    this.gameJsPluginEngine.init();
    this.gameJsPluginEngine.onCreate(this);
    MiniAppClientQIPCModule.registerModule();
    MiniAppClientQIPCModule.getQIPCModule().attachGameJsPluginEngine(this.gameJsPluginEngine);
    if (this.mNavBar != null) {
      this.mNavBar.setGameJsPluginEngine(this.gameJsPluginEngine, this.gameBrandRuntime);
    }
    syncForceGroundAndRefreshBadge();
    l = System.currentTimeMillis() - l;
    MiniReportManager.reportEventType(this.gameConfig, 1038, null, null, null, 0, "1", l, null);
    QLog.e("[minigame][timecost] ", 1, new Object[] { "step[initJsPluginEngine] cost time ", Long.valueOf(l) });
  }
  
  private void initNavBar()
  {
    this.mNavBar = ((NavigatorBarForMiniGame)findViewById(2131304588));
    this.mNavBar.setApkgInfoAndInit(this.mApkgInfo);
    this.mNavBar.setWindowInfo(fakeWindowInfo());
  }
  
  private void initUI()
  {
    setContentView(2131493711);
    this.contentView = ((ViewGroup)findViewById(2131304586));
    this.mBannerAdContainer = ((FrameLayout)findViewById(2131304584));
    this.LoadingContainer = ((RelativeLayout)findViewById(2131301060));
    this.rightContainer = ((RelativeLayout)findViewById(2131299128));
    Object localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(this, 80.0F), DisplayUtil.dip2px(this, 30.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    if (bjeh.b()) {}
    for (int i = ImmersiveUtils.getStatusBarHeight(this);; i = 0)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(this, 12.5F);
      this.rightContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mCenterLayout = ((LinearLayout)findViewById(2131298446));
      this.mBottonLayout = ((LinearLayout)findViewById(2131297823));
      this.mSplashLayout = ((LinearLayout)findViewById(2131310605));
      this.mGameInstruction = ((TextView)findViewById(2131301307));
      this.mGameVersionDesc = ((TextView)findViewById(2131301331));
      this.mJumpBtn = ((TextView)findViewById(2131303128));
      this.mMoreView = ((ImageView)findViewById(2131298036));
      this.mMoreView.setOnLongClickListener(this);
      this.mCloseView = ((ImageView)findViewById(2131297953));
      this.mNameView = ((TextView)findViewById(2131301313));
      this.mDeveloperDescView = ((TextView)findViewById(2131299518));
      this.mDeveloperDescLayout = ((LinearLayout)findViewById(2131299519));
      this.mLogoView = ((SquareImageView)findViewById(2131303907));
      this.mLogoView.setRoundRect(sIconSize);
      this.mProgressTxt = ((TextView)findViewById(2131312636));
      this.mSplashProgressTxt = ((TextView)findViewById(2131310607));
      this.mSplashProgressBar = ((ProgressBar)findViewById(2131310604));
      this.mMoreView.setOnClickListener(this);
      this.mCloseView.setOnClickListener(this);
      this.mJumpBtn.setOnClickListener(this);
      new ImmersionBar(this, 0, findViewById(2131310658));
      if ((!TextUtils.isEmpty(MiniAppGlobal.CAPSULE_CLOSE_URL)) && (!TextUtils.isEmpty(MiniAppGlobal.CAPSULE_CLOSE_DARK_URL)))
      {
        localObject = MiniAppUtils.getIcon(this, MiniAppGlobal.CAPSULE_CLOSE_URL, true, 2130840808, 40, 30);
        this.mCloseView.setImageDrawable((Drawable)localObject);
      }
      this.mColorNoteController = new alrv(this, false, true);
      this.mColorNoteController.a(this);
      this.mColorNoteController.a(new GameActivity.22(this));
      this.mColorNoteController.a(new GameActivity.23(this));
      this.mVConsoleManager = new VConsoleLogManager();
      VConsoleManager.getInstance().registerLogManager(Process.myPid(), this.mVConsoleManager);
      return;
    }
  }
  
  private void initVConsoleLayout()
  {
    if ((this.vConsoleBtn == null) || (this.vConsoleViewHasInited)) {
      return;
    }
    this.vConsoleView = new VConsoleView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.vConsoleView.setLayoutParams(localLayoutParams);
    this.contentView.addView(this.vConsoleView);
    this.vConsoleView.setVisibility(8);
    this.vConsoleView.bringToFront();
    this.vConsoleBtn.bringToFront();
    this.vConsoleBtn.setListener(null);
    this.vConsoleViewHasInited = true;
  }
  
  private void initVConsoleView()
  {
    this.vConsoleBtn = new VConsoleDragView(this);
    this.vConsoleBtn.setImageResource(2130840650);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(bajq.b(90.0F), -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    localLayoutParams.setMargins(0, 0, bajq.b(12.0F), bajq.b(12.0F));
    this.vConsoleBtn.setLayoutParams(localLayoutParams);
    this.vConsoleBtn.setListener(this);
    this.contentView.addView(this.vConsoleBtn);
    this.vConsoleBtn.bringToFront();
    this.vConsoleBtn.setVisibility(0);
    this.mUIHandler.postDelayed(new GameActivity.13(this), 1500L);
  }
  
  private void injectAccountInfoConfig()
  {
    if ((this.gameConfig != null) && (this.gameConfig.config != null))
    {
      String str = "var __wxConfig = __wxConfig || {}; __wxConfig.accountInfo = __wxConfig.accountInfo || {}; \n__wxConfig.accountInfo.appId = '" + this.gameConfig.config.appId + "';\n__wxConfig.accountInfo.icon = '" + this.gameConfig.config.iconUrl + "'; __wxConfig.deviceinfo='" + bfpj.a().f() + "'; __wxConfig.miniapp_version='" + this.gameConfig.config.version + "';";
      if (QLog.isColorLevel()) {
        QLog.i("[minigame] GameActivity", 1, "injectAccountInfoConfig:" + str);
      }
      this.mTTEngine.getJsRuntime(1).evaluateJs(str);
      this.mTTEngine.getJsRuntime(2).evaluateJs(str);
    }
  }
  
  private static boolean isFromDesktop(int paramInt)
  {
    return (paramInt >= 3001) && (paramInt <= 3010);
  }
  
  private static boolean isInWnsBlackList(int paramInt)
  {
    boolean bool2 = false;
    try
    {
      Object localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_exit_confirm_animation_scene_black_list", "");
      boolean bool1 = bool2;
      int j;
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        bool1 = bool2;
        if (localObject != null)
        {
          j = localObject.length;
          i = 0;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        String str;
        if (i < j) {
          str = localObject[i];
        }
        try
        {
          int k = Integer.parseInt(str);
          if (k == paramInt)
          {
            bool1 = true;
            return bool1;
          }
        }
        catch (Exception localException)
        {
          QLog.e("[minigame] GameActivity", 2, "isInWnsBlackList", localException);
          i += 1;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[minigame] GameActivity", 2, "isInWnsBlackList", localThrowable);
    }
  }
  
  private void launchGame()
  {
    if (!this.mIsForground)
    {
      MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "load_fail", "not_foreground");
      MiniAppReportManager2.reportPageView("2launch_fail", "not_foreground", null, this.gameConfig);
      this.mNeedLaunchGameOnResume = true;
      QLog.e("[minigame] GameActivity", 1, "not in forground, donot lauchGame");
    }
    do
    {
      return;
      this.mNeedLaunchGameOnResume = false;
    } while (this.hasLaunchedGame);
    NetworkTimeoutInfo localNetworkTimeoutInfo = this.mApkgInfo.mAppConfigInfo.networkTimeoutInfo;
    MiniOkHttpClientFactory.init(localNetworkTimeoutInfo.request, localNetworkTimeoutInfo.uploadFile, localNetworkTimeoutInfo.downloadFile);
    runOnUiThread(new GameActivity.28(this));
    this.hasLaunchedGame = true;
  }
  
  private void lifecycleReport(String paramString)
  {
    MiniAppConfig localMiniAppConfig = this.gameConfig;
    Object localObject = localMiniAppConfig;
    if (localMiniAppConfig == null) {
      localObject = loadMiniAppConfig(getIntent());
    }
    if (localObject != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("app_config", this.gameConfig);
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
  
  private void performMiniGameClose()
  {
    QLog.e("[minigame] GameActivity", 1, "[btn_close, loading page close]");
    MiniReportManager.reportEventType(this.gameConfig, 1026, "1");
    MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "close", "loading_page");
    MiniAppReportManager2.reportPageView("2close", "loading_page", null, this.gameConfig);
    finishActivity();
  }
  
  private void reportBannerAd(String paramString)
  {
    QLog.i("[minigame] GameActivity", 1, "reportBannerAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new GameActivity.33(this, paramString));
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
  
  private void requestFail(long paramLong, String paramString)
  {
    runOnUiThread(new GameActivity.19(this, paramString, paramLong));
  }
  
  private void setAppConfig()
  {
    MiniAppConfig localMiniAppConfig = loadMiniAppConfig(getIntent());
    if (localMiniAppConfig != null) {
      GameInfoManager.g().setMiniAppConfig(localMiniAppConfig);
    }
  }
  
  private void setLaunchStatus(int paramInt)
  {
    this.mLaunchStatus = paramInt;
  }
  
  private void setProgressTxt(String paramString)
  {
    runOnUiThread(new GameActivity.5(this, paramString));
  }
  
  private void setupUI()
  {
    this.mProgressTxt.setText(this.mProgressStr);
    this.mSplashProgressTxt.setText(this.mProgressStr);
    label95:
    Object localObject;
    if (this.gameConfig.config != null)
    {
      this.mNameView.setText(this.gameConfig.config.name);
      if (this.gameConfig.config.isReportTypeMiniApp())
      {
        this.mGameInstruction.setVisibility(4);
        if (!TextUtils.isEmpty(this.gameConfig.config.developerDesc)) {
          break label268;
        }
        this.mDeveloperDescLayout.setVisibility(8);
      }
      for (;;)
      {
        if ((this.gameConfig.config.qualifications != null) && (this.gameConfig.config.qualifications.size() > 0))
        {
          this.mDeveloperDescLayout.setVisibility(8);
          this.mGameVersionDesc.setVisibility(0);
          localObject = new StringBuilder();
          int i = 0;
          for (;;)
          {
            if (i < this.gameConfig.config.qualifications.size())
            {
              if ((i > 0) && (!TextUtils.isEmpty((CharSequence)this.gameConfig.config.qualifications.get(i - 1)))) {
                ((StringBuilder)localObject).append("\n");
              }
              if (!TextUtils.isEmpty((CharSequence)this.gameConfig.config.qualifications.get(i))) {
                ((StringBuilder)localObject).append((String)this.gameConfig.config.qualifications.get(i));
              }
              i += 1;
              continue;
              this.mGameInstruction.setVisibility(0);
              break;
              label268:
              this.mDeveloperDescLayout.setVisibility(0);
              this.mDeveloperDescView.setText(ajjy.a(2131639224) + this.gameConfig.config.developerDesc + ajjy.a(2131639223));
              break label95;
            }
          }
          this.mGameVersionDesc.setText(((StringBuilder)localObject).toString());
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.gameConfig.config.iconUrl))
      {
        if (sDrawableOptions == null)
        {
          sDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          sDrawableOptions.mRequestWidth = sIconSize;
          sDrawableOptions.mRequestHeight = sIconSize;
          sDrawableOptions.mFailedDrawable = defaultDrawable;
          sDrawableOptions.mLoadingDrawable = defaultDrawable;
        }
        localObject = URLDecoder.decode(this.gameConfig.config.iconUrl);
      }
      try
      {
        sGameDrawable = URLDrawable.getDrawable((String)localObject, sDrawableOptions);
        sGameDrawable.run();
        this.mLogoView.setImageDrawable(sGameDrawable);
        if (this.mIsFromSplash)
        {
          this.rightContainer.setVisibility(8);
          this.mBottonLayout.setVisibility(8);
          this.mCenterLayout.setVisibility(8);
          this.mSplashLayout.setVisibility(0);
          this.mJumpBtn.setVisibility(0);
          if (Build.VERSION.SDK_INT < 16) {
            break label641;
          }
          this.LoadingContainer.setBackground(new BitmapDrawable(getResources(), PreloadManager.g().mSlashPic));
          if (PreloadManager.g().mStartBtnPic != null)
          {
            this.mStartView = ((ImageView)findViewById(2131298116));
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
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("[minigame] GameActivity", 1, "initDataMustOnResume setGameDrawable error, url = " + (String)localObject, localException);
          continue;
          label641:
          this.LoadingContainer.setBackgroundDrawable(new BitmapDrawable(getResources(), PreloadManager.g().mSlashPic));
        }
      }
    }
  }
  
  private void showStartView()
  {
    this.mSplashProgressBar.setVisibility(8);
    this.mSplashProgressTxt.setVisibility(8);
    this.mStartView.setVisibility(0);
  }
  
  private void showUpdateMobileQQDialog()
  {
    Object localObject1 = "";
    try
    {
      Object localObject3 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
      Object localObject2 = "";
      Object localObject4 = localObject2;
      localObject1 = localObject3;
      if (this.gameConfig != null)
      {
        localObject4 = localObject2;
        localObject1 = localObject3;
        if (this.gameConfig.config != null)
        {
          localObject1 = localObject3;
          localObject4 = this.gameConfig.config.appId;
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
    ThreadManagerV2.excute(new GameActivity.35(this), 16, null, true);
  }
  
  private void updateDebuggerStatus(String paramString1, String paramString2, boolean paramBoolean)
  {
    runOnUiThread(new GameActivity.26(this, paramString1, paramString2, paramBoolean));
  }
  
  public boolean clickMonitorPanel()
  {
    if (this.contentView != null)
    {
      if (this.mMiniAppMonitorInfoView != null) {
        break label100;
      }
      this.mMiniAppMonitorInfoView = new MiniAppMonitorInfoView(this, null, 1);
      this.mMiniAppMonitorInfoView.setMiniAppType(1);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      this.contentView.addView(this.mMiniAppMonitorInfoView, localLayoutParams);
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
      this.bannerParams = new ykt();
      this.bannerParams.jdField_a_of_type_Yjs = getBannerClickParams();
      this.bannerParams.jdField_a_of_type_Int = 0;
      this.bannerParams.b = gameDpTopx(paramBannerAdPosInfo.mAdRealWidth);
      this.bannerParams.jdField_c_of_type_Int = gameDpTopx(paramBannerAdPosInfo.mAdRealHeight);
      this.mGdtBannerView = ykv.a(this.bannerParams);
      if (this.mGdtBannerView != null)
      {
        this.bannerParams.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick = new GdtDwellTimeStatisticsAfterClick(new GdtAd(this.mBannerAdOpInfo), new WeakReference(this.mGdtBannerView.a()));
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
          break label232;
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
    label232:
    return false;
  }
  
  public void destroyBannerAd()
  {
    try
    {
      runOnUiThread(new GameActivity.32(this));
      this.mGdtBannerView = null;
      this.mGdtDwellTimeStatisticsAfterClick = null;
      this.mBannerAdPosInfo = null;
      this.mBannerAdOpInfo = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("[minigame] GameActivity", 1, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    if (paramInt1 == 1001)
    {
      if ((getNavBar() != null) && (getNavBar().getCapsuleButton() != null)) {
        getNavBar().getCapsuleButton().doOnActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
    }
    MiniAppController.getInstance().notifyResultListener(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    QLog.e("[minigame] GameActivity", 1, "[doOnBackPressed]");
    if (this.gameConfig != null) {
      if (getLaunchStatus() == 0) {
        MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "load_fail", "loading_page_back_press");
      }
    }
    for (;;)
    {
      if (this.mQQDebugSocket != null) {
        this.mQQDebugSocket.sendQuitDebugMsgInfo();
      }
      if (this.mIsFromSplash)
      {
        startMainActivity();
        this.mUIHandler.postDelayed(new GameActivity.31(this), 300L);
      }
      moveTaskToBack(true);
      return;
      if (getLaunchStatus() == 1)
      {
        MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "show_fail", "loading_page_back_press");
        continue;
        QLog.e("[minigame] GameActivity", 1, "doOnBackPressed gameConfig=null");
      }
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    QLog.d("[minigame] GameActivity", 1, "--onConfigurationChanged-- screenWidthDp=" + paramConfiguration.screenWidthDp + ", screenHeightDp=" + paramConfiguration.screenHeightDp);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.i("[minigame] GameActivity", 1, "doOnCreate " + this);
    this.beginOnCreate = System.currentTimeMillis();
    Intent localIntent = getIntent();
    MiniAppConfig localMiniAppConfig = loadMiniAppConfig(localIntent);
    long l = localIntent.getLongExtra("startDuration", 0L);
    int i = localIntent.getIntExtra("start_mode", 3);
    l = this.beginOnCreate - l;
    if (localMiniAppConfig != null) {
      MiniReportManager.reportEventType(localMiniAppConfig, 1030, null, null, null, i, "1", l, null);
    }
    QLog.e("[minigame][timecost] ", 1, new Object[] { "step[startActivity] cost time ", Long.valueOf(l), ", startMode " + i });
    if (CPUUtil.sIsX86Emulator)
    {
      if (localMiniAppConfig != null)
      {
        MiniProgramLpReportDC04239.reportPageView(localMiniAppConfig, "1", null, "load_fail", "system_version_limit_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "system_version_limit_fail", null, localMiniAppConfig);
      }
      bbmy.a(getApplicationContext(), 2131628635, 1).a();
      finish();
      return false;
    }
    QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnCreate saved=" + paramBundle);
    try
    {
      super.getIntent().putExtra("fling_action_key", 0);
      MiniGdtReporter.prepareReport();
      this.mNeedStatusTrans = false;
      requestWindowFeature(1);
      getWindow().setFormat(-2);
      setRequestedOrientation(1);
      reportLaunch();
      this.mTTEngine = GameLoadManager.g().getGameEngine();
      this.mActNeedImmersive = false;
      bjeh.a(this);
      if (bjeh.b())
      {
        if ((Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) && ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27))) {
          enableXiaoMiNotch(this);
        }
      }
      else
      {
        boolean bool = super.doOnCreate(paramBundle);
        this.mReportHandler = ThreadManager.getSubThreadHandler();
        initUI();
        initMonitor();
        l = System.currentTimeMillis() - this.beginOnCreate;
        if (localMiniAppConfig != null) {
          MiniReportManager.reportEventType(localMiniAppConfig, 1031, null, null, null, 0, "1", l, null);
        }
        QLog.e("[minigame][timecost] ", 1, new Object[] { "step[doOnCreate] cost time ", Long.valueOf(l) });
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("[minigame] GameActivity", 1, "[MiniEng]禁用右滑关闭失败:" + localThrowable.getMessage());
        continue;
        bjeh.c(this);
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy " + this + ", killAllGamesWhenDestroy:" + killAllGamesWhenDestroy);
    GameLoadManager.g().detachListener(this);
    MiniAppClientQIPCModule.unRegisterModule();
    if (this.mTTEngine != null)
    {
      this.mTTEngine.removeFPSCallback(this.mFpsListener);
      if (killAllGamesWhenDestroy != 1)
      {
        QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy killAllGamesWhenDestroy :" + killAllGamesWhenDestroy);
        ThreadManagerV2.excute(new GameActivity.15(this), 16, null, false);
      }
    }
    if ((this.gameJsPluginEngine != null) && (this.gameJsPluginEngine.hasInit())) {
      this.gameJsPluginEngine.onDestroy();
    }
    try
    {
      if (this.mBroadcastReceiver != null) {
        unregisterReceiver(this.mBroadcastReceiver);
      }
      MiniReportManager.reportEventType(this.gameConfig, 22, "1");
      if (this.gameConfig != null)
      {
        if ((getLaunchStatus() == 0) || (getLaunchStatus() == 1))
        {
          MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "load_fail", "loading_page_kill");
          MiniAppReportManager2.reportPageView("2launch_fail", "loading_page_kill", null, this.gameConfig);
        }
        MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "unload", null);
        MiniAppReportManager2.reportPageView("2unload", null, null, this.gameConfig);
        MiniProgramLpReportDC04239.deleteRecordDurationMsg();
        VConsoleManager.getInstance().unRegisterLogManager(Process.myPid());
        if (this.mGdtBannerView != null) {
          this.mGdtBannerView.c(this);
        }
        if (this.mColorNoteController != null) {
          this.mColorNoteController.c();
        }
        if (killAllGamesWhenDestroy == 1)
        {
          QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy killProcess  :");
          QLog.e("[minigame] GameActivity", 1, "doOnDestroy kill process" + getGameInfo());
          this.mUIHandler.postDelayed(new GameActivity.16(this), 300L);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        QLog.e("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy kill self gameConfig=null");
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    QLog.e("[minigame] GameActivity", 1, "--doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    if (paramIntent != null)
    {
      MiniAppConfig localMiniAppConfig = GameInfoManager.g().getMiniAppConfig();
      paramIntent = loadMiniAppConfig(paramIntent);
      if ((!MiniAppConfig.isValid(localMiniAppConfig)) || (!MiniAppConfig.isValid(paramIntent)) || (!MiniAppConfig.equalObj(localMiniAppConfig.config.appId, paramIntent.config.appId)) || (!MiniAppConfig.equalObj(Integer.valueOf(localMiniAppConfig.config.verType), Integer.valueOf(paramIntent.config.verType)))) {
        break label114;
      }
      if (!paramIntent.isShortcutFakeApp()) {
        GameInfoManager.g().updateMiniAppConfig(paramIntent);
      }
    }
    for (;;)
    {
      MiniGdtReporter.prepareReport();
      return;
      label114:
      GameInfoManager.g().updateMiniAppConfig(paramIntent);
    }
  }
  
  public void doOnPause()
  {
    QLog.e("[minigame] GameActivity", 1, "doOnPause " + getGameInfo());
    super.doOnPause();
    lifecycleReport("launch_report_app_pause");
    this.mIsForground = false;
    long l = this.mTTEngine.getLastBlackTime();
    if ((this.mOnFirstBlackScreenReport) && (l > 0L))
    {
      l = System.currentTimeMillis() - l;
      if (l > 0L)
      {
        this.mOnFirstBlackScreenReport = false;
        MiniReportManager.reportEventType(this.gameConfig, 1018, null, null, null, 0, "1", l, null);
        QLog.e("[minigame] GameActivity", 1, "doOnPause blackTimeDuration " + l);
      }
    }
    this.mIsEngineResumed = false;
    this.mTTEngine.onPause();
    if ((this.gameJsPluginEngine != null) && (this.gameJsPluginEngine.hasInit())) {
      this.gameJsPluginEngine.onPause();
    }
    if (this.mGdtBannerView != null) {
      this.mGdtBannerView.a(this);
    }
    hideKeyBoard();
    GameInfoManager.g().resetQuery();
    if ((this.mOnFirstHide) && (this.mOnShowTime > 0L))
    {
      this.mOnFirstHide = false;
      MiniReportManager.reportEventType(this.gameConfig, 1016, "1");
      l = System.currentTimeMillis() - this.mOnShowTime;
      if (l > 0L) {
        MiniReportManager.reportEventType(this.gameConfig, 1020, null, null, null, 0, "1", l, null);
      }
    }
    l = System.currentTimeMillis() - this.mOnShowTime;
    if ((l > 0L) && (this.mOnShowTime > 0L)) {
      MiniReportManager.reportEventType(this.gameConfig, 1021, null, null, null, 0, "1", l, null);
    }
    l = Storage.getCurrentStorageSize(GameInfoManager.g().getAppId());
    if ((l >= 0L) && (!sStorageReport))
    {
      sStorageReport = true;
      MiniReportManager.reportEventType(this.gameConfig, 639, null, String.valueOf(l), null, 1, "1", 0L, null);
    }
    MiniReportManager.reportEventType(this.gameConfig, 20, "1");
    if (this.mOnShowReported)
    {
      this.mOnShowReported = false;
      MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "hide", null);
    }
    for (;;)
    {
      MiniAppReportManager2.reportPageView("2hide", null, null, this.gameConfig);
      MiniProgramLpReportDC04239.deleteRecordDurationMsg();
      if (this.mColorNoteController != null) {
        this.mColorNoteController.b();
      }
      aluq.a(this, 2, true);
      return;
      QLog.e("[minigame] GameActivity", 1, "no need report product onHide, mOnShowReported=false");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.beginOnResume = System.currentTimeMillis();
    Intent localIntent = getIntent();
    if ((this.gameConfig == null) && (localIntent != null)) {
      this.gameConfig = loadMiniAppConfig(localIntent);
    }
    MiniAppReportManager2.reportPageView("2show", "bring_to_front", null, this.gameConfig);
    MiniReportManager.reportEventType(this.gameConfig, 1, "1");
    bbqo.a(this);
    lifecycleReport("launch_report_app_resume");
    long l;
    label245:
    ResultReceiver localResultReceiver;
    label306:
    int i;
    if (!this.mHasInited)
    {
      if (!initDataMustOnResume())
      {
        if (this.gameConfig != null)
        {
          MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "load_fail", "init_data_fail");
          MiniAppReportManager2.reportPageView("2launch_fail", "init_data_fail", null, this.gameConfig);
        }
        QLog.e("[minigame] GameActivity", 1, "doOnResume initDataMustOnResume==false finishactivity");
        return;
      }
      setupUI();
      if ((this.mGameInfo != null) && (getEnableDebug()) && (this.vConsoleBtn == null)) {
        initVConsoleView();
      }
      this.mHasInited = true;
      MiniReportManager.reportEventType(this.gameConfig, 1013, "1");
      AppBrandProxy.g().setMiniAppConfig(this.gameConfig);
      changeWindowInfo(this.gameConfig);
      callEngineOnResume();
      if ((this.gameJsPluginEngine != null) && (this.gameJsPluginEngine.hasInit())) {
        this.gameJsPluginEngine.onResume();
      }
      if (localIntent == null) {
        break label680;
      }
      l = localIntent.getLongExtra("startDuration", 0L);
      if ((l != 0L) && (MiniAppMonitorInfoView.sStartTime != l))
      {
        MiniAppMonitorInfoView.sStartTime = l;
        MiniAppMonitorInfoView.sStartDuration = System.currentTimeMillis() - l;
      }
      if (this.mGdtBannerView != null) {
        this.mGdtBannerView.b(this);
      }
      if (localIntent == null) {
        break label685;
      }
      localResultReceiver = (ResultReceiver)localIntent.getParcelableExtra("receiver");
      if (localResultReceiver != null) {
        localResultReceiver.send(0, new Bundle());
      }
      if ((this.gameConfig != null) && (this.gameConfig.config != null) && (!TextUtils.isEmpty(this.gameConfig.config.appId)))
      {
        if (localIntent == null) {
          break label691;
        }
        i = localIntent.getIntExtra("start_mode", 3);
        label372:
        if (i != 3) {
          break label696;
        }
        MiniAppStartState.setProcessLoad(this.gameConfig.config.appId, false);
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
      aluq.a(this, 2, false);
      l = System.currentTimeMillis() - this.beginOnResume;
      if (!this.hasReportStepOnResume)
      {
        this.hasReportStepOnResume = true;
        MiniReportManager.reportEventType(this.gameConfig, 1035, null, null, null, 0, "1", l, null);
      }
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[onResume] cost time ", Long.valueOf(l), ", include steps[initDataMustOnResume, setupUI] " + getGameInfo() });
      GameGrowthGuardianManager.executeBegin(this, this.gameConfig);
      return;
      this.mOnShowTime = System.currentTimeMillis();
      MiniReportManager.reportEventType(this.gameConfig, 21, "1");
      if ((getLaunchStatus() == 2) && (this.mOnShowTime - this.mLastOnShowReportTime > this.mOnShowReportInterval))
      {
        this.mOnShowReported = true;
        MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "show", "bring_to_front");
      }
      for (;;)
      {
        if (getLaunchStatus() == 2) {
          MiniAppReportManager2.reportPageView("2launch", "click_resume", null, this.gameConfig);
        }
        this.mLastOnShowReportTime = this.mOnShowTime;
        MiniGdtReporter.report(GameInfoManager.g().getMiniAppConfig(), 0);
        break;
        QLog.e("[minigame] GameActivity", 1, "no need report product onShow, less than interval " + this.mOnShowReportInterval + " getLaunchStatus=" + getLaunchStatus());
      }
      label680:
      l = 0L;
      break label245;
      label685:
      localResultReceiver = null;
      break label306;
      label691:
      i = 3;
      break label372;
      label696:
      MiniAppStartState.setProcessLoad(this.gameConfig.config.appId, true);
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
      if (this.gameConfig != null)
      {
        MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "load_fail", "start_no_intent");
        MiniAppReportManager2.reportPageView("2launch_fail", "start_no_intent", null, this.gameConfig);
      }
      return;
    }
    if (killAllGamesWhenReuse == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        MiniAppConfig localMiniAppConfig = this.gameConfig;
        localObject = loadMiniAppConfig((Intent)localObject);
        if ((localObject != null) && (((MiniAppConfig)localObject).config != null) && (((MiniAppConfig)localObject).config.appId != null) && (localMiniAppConfig != null) && (localMiniAppConfig.config != null) && (!((MiniAppConfig)localObject).config.appId.equals(localMiniAppConfig.config.appId)))
        {
          QLog.e("[minigame] GameActivity", 1, "doOnStart gameConfig exception, kill self current ====> " + localMiniAppConfig + " <=== newGameConfig ====>" + localObject);
          MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject, "1", null, "load_fail", "appid_conflict");
          MiniAppReportManager2.reportPageView("2launch_fail", "appid_conflict", null, this.gameConfig);
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
      return;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    ThreadManagerV2.excute(new GameActivity.14(this), 16, null, true);
    MiniAppBannerIPCModule.notifyEnterBackground(this.mApkgInfo);
    this.mPerformanceStatics.stopReport();
    GameGrowthGuardianManager.executeEnd(this, this.gameConfig);
    this.mColorNoteController.o();
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
      if (this.gameBrandRuntime.appId.equals(str))
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
      this.mUIHandler.postDelayed(new GameActivity.30(this), 300L);
      return;
    }
    finish();
  }
  
  public BannerAdPosInfo getBannerAdPosInfo()
  {
    return this.mBannerAdPosInfo;
  }
  
  public alrv getColorNoteController()
  {
    return this.mColorNoteController;
  }
  
  public boolean getEnableDebug()
  {
    if (this.mGameInfo == null) {
      return false;
    }
    return StorageUtil.getPreference().getBoolean(this.mGameInfo.gameId + "_debug", false);
  }
  
  public GameBrandRuntime getGameBrandRuntime()
  {
    return this.gameBrandRuntime;
  }
  
  public JSONObject getGameConfigJson()
  {
    if (this.mGameInfo == null) {
      return null;
    }
    return this.mGameInfo.gameConfigJson;
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
    QLog.i("[minigame] GameActivity", 1, "density = " + localDisplayMetrics.density + ", ViewUtils.density = " + bajq.a() + ", screenW = " + localDisplayMetrics.widthPixels + ", screenH = " + localDisplayMetrics.heightPixels);
    if (this.mGameDensity != bajq.a()) {
      this.mReportHandler.post(new GameActivity.36(this));
    }
    return this.mGameDensity;
  }
  
  public int getGameHeight()
  {
    return this.mGameHeight;
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
    if (this.keyboardLayout == null)
    {
      this.keyboardLayout = new KeyboardLayout(this);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      this.contentView.addView(this.keyboardLayout, localLayoutParams);
      this.mSoftKeyboardStateHelper = new avwj(this.contentView);
      this.mSoftKeyboardStateHelper.a(this.mListener);
    }
    return this.keyboardLayout;
  }
  
  public String getMenuStyle()
  {
    return this.mMenuStyle;
  }
  
  public String getMiniGameAppId()
  {
    if ((this.gameConfig != null) && (this.gameConfig.config != null)) {
      return this.gameConfig.config.appId;
    }
    return "";
  }
  
  public NavigatorBarForMiniGame getNavBar()
  {
    return this.mNavBar;
  }
  
  public boolean handleMiniGameCloseButtonClick(DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((this.mApkgInfo != null) && (this.mApkgInfo.appConfig != null) && (this.mApkgInfo.appConfig.launchParam != null) && ((this.mApkgInfo.appConfig.launchParam.scene == 2001) || (this.mApkgInfo.appConfig.launchParam.scene == 1001) || (isFromDesktop(this.mApkgInfo.appConfig.launchParam.scene)) || (isInWnsBlackList(this.mApkgInfo.appConfig.launchParam.scene)))) {}
    int i;
    do
    {
      return false;
      i = StorageUtil.getPreference().getInt("pref_key_mini_game_close_confirm_exposure_times", 0);
    } while (i >= MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES_THRESHOLD);
    bafb localbafb = babr.a(this, 230);
    Object localObject = new URLImageView(this);
    ((URLImageView)localObject).setImageDrawable(URLDrawable.getDrawable(QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_exit_confirm_animation_image_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191114160727_AqDlaIYOnx.gif"), true));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    if (getIsOrientationLandscape())
    {
      localLayoutParams.width = (getResources().getDisplayMetrics().heightPixels / 2);
      localLayoutParams.height = ((int)(localLayoutParams.width / 1.05F));
    }
    localLayoutParams.gravity = 1;
    TextView localTextView = new TextView(this);
    localTextView.setText(Html.fromHtml(getApplicationContext().getString(2131628619)), TextView.BufferType.SPANNABLE);
    localTextView.setTextColor(Color.parseColor("#02081B"));
    localTextView.setGravity(17);
    localTextView.setTypeface(Typeface.DEFAULT, 1);
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    localLinearLayout.addView(localTextView, new LinearLayout.LayoutParams(-2, -2));
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    localbafb.setCancelable(false);
    localbafb.setTitle(null).setMessage(null).addView(localLinearLayout, (LinearLayout.LayoutParams)localObject).setPositiveButton(2131628775, new GameActivity.3(this, paramOnClickListener));
    localbafb.getBtnight().setTypeface(Typeface.DEFAULT, 1);
    localbafb.show();
    StorageUtil.getPreference().edit().putInt("pref_key_mini_game_close_confirm_exposure_times", i + 1).apply();
    return true;
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
  
  public void hideKeyBoard()
  {
    if ((this.keyboardLayout != null) && (this.keyboardLayout.getVisibility() == 0))
    {
      KeyboardHandler.get().hideSoftInput(this, this.keyboardLayout.getInputET());
      this.keyboardLayout.setVisibility(8);
    }
  }
  
  protected void initMonitor()
  {
    this.mBroadcastReceiver = new GameActivity.MonitorBroadcastReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action.qq.miniapp.show.monitorview");
    registerReceiver(this.mBroadcastReceiver, localIntentFilter);
  }
  
  public void onBaseLibAndGameReady()
  {
    if (!GameLoadManager.g().isGameReadyStart(this.gameConfig))
    {
      QLog.e("[minigame] GameActivity", 1, "onLoadFail finish game Activity!");
      MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "load_fail", "not_ready");
      MiniAppReportManager2.reportPageView("2launch_fail", "not_ready", null, this.gameConfig);
      return;
    }
    if (badq.a(getActivity()) == 0)
    {
      if (!this.gameConfig.config.isSupportOffline)
      {
        MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "load_fail", "offline_not_support");
        MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_support", null, this.gameConfig);
        bbmy.a(this, ajjy.a(2131639214), 0).a();
        return;
      }
      if (!GpkgManager.isOfflineResourceReady(this.gameConfig))
      {
        MiniProgramLpReportDC04239.reportPageView(this.gameConfig, "1", null, "load_fail", "offline_not_ready");
        MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_ready", null, this.gameConfig);
        bbmy.a(this, ajjy.a(2131639219), 0).a();
        return;
      }
    }
    QLog.i("[minigame] GameActivity", 1, "[MiniEng] Start Game! Engine:" + GameLoadManager.g().getEngine());
    runOnUiThread(new GameActivity.11(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (handleMiniGameCloseButtonClick(new GameActivity.4(this)));
        performMiniGameClose();
        return;
        QLog.e("[minigame] GameActivity", 1, "[jump_btn, loading page close]");
        finishActivity();
        paramView = PreloadManager.g().getMiniAppConfig();
      } while ((paramView == null) || (paramView.config == null));
      MiniProgramLpReportDC04746.report(paramView.config.appId, paramView.config.version, 2, 1);
      return;
      QLog.e("[minigame] GameActivity", 1, "[btn_start]");
      exitWhenSuccess();
      paramView = PreloadManager.g().getMiniAppConfig();
    } while ((paramView == null) || (paramView.config == null));
    MiniProgramLpReportDC04746.report(paramView.config.appId, paramView.config.version, 2, 2);
  }
  
  public void onEngineLoad(boolean paramBoolean, String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.loadGameStartTime;
    paramString = this.gameConfig;
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      MiniReportManager.reportEventType(paramString, 1033, null, null, null, i, "1", l, null);
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[load baseLib] success? " + paramBoolean + ", cost time ", Long.valueOf(l), ", include steps[initTTEngine]" });
      if (!paramBoolean) {
        break;
      }
      this.mIsEngineLoaded = true;
      callEngineOnResume();
      injectAccountInfoConfig();
      return;
    }
    MiniGdtReporter.report(GameInfoManager.g().getMiniAppConfig(), 510);
    QLog.e("[minigame] GameActivity", 1, new Object[] { "step[load baseLib] fail, retCode=", Integer.valueOf(paramInt) });
    runOnUiThread(new GameActivity.9(this, paramInt));
  }
  
  public void onGpkgLoad(boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis() - this.loadGameStartTime;
    paramString = this.gameConfig;
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      MiniReportManager.reportEventType(paramString, 1036, null, null, null, i, "1", l, null);
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[load gpkg] success? " + paramBoolean + ", cost time ", Long.valueOf(l), ", include steps[initFileMgr]" });
      if (!paramBoolean) {
        break;
      }
      setAppConfig();
      return;
    }
    MiniGdtReporter.report(GameInfoManager.g().getMiniAppConfig(), 511);
    runOnUiThread(new GameActivity.7(this));
  }
  
  public void onInitRuntimeDone()
  {
    long l = System.currentTimeMillis() - this.loadGameStartTime;
    MiniReportManager.reportEventType(this.gameConfig, 1037, null, null, null, 0, "1", l, null);
    QLog.e("[minigame][timecost] ", 1, new Object[] { "[MiniEng] step[init runTime] cost time ", Long.valueOf(l), ", include steps[load baseLib, load gpkg]" });
    if (this.mIsFromSplash)
    {
      this.mSplashLoadComplete = true;
      runOnUiThread(new GameActivity.6(this));
      return;
    }
    exitWhenSuccess();
  }
  
  public void onJsPluginEngineLoad(boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis() - this.loadGameStartTime;
    paramString = this.gameConfig;
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      MiniReportManager.reportEventType(paramString, 1034, null, null, null, i, "1", l, null);
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[initJsPluginList] success? " + paramBoolean + ", cost time ", Long.valueOf(l) });
      return;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (GameWnsUtils.needBackPressHint(GameInfoManager.g().getAppId())))
    {
      long l = System.currentTimeMillis();
      if (l - this.mFirstBackPressTime > 2000L)
      {
        if (!TextUtils.isEmpty(this.mBackPressHint)) {
          bbmy.a(this, 0, this.mBackPressHint, 0).a();
        }
        this.mFirstBackPressTime = l;
        if ((this.gameJsPluginEngine != null) && (this.gameJsPluginEngine.getGameJsRuntime(1) != null)) {
          this.gameJsPluginEngine.getGameJsRuntime(1).evaluateSubcribeJS("onPause", "{}", -1);
        }
        return true;
      }
    }
    if (this.gameConfig != null)
    {
      if (getLaunchStatus() != 2) {
        break label137;
      }
      MiniAppReportManager2.reportPageView("2back_key", "inner_page", null, this.gameConfig);
    }
    for (;;)
    {
      return super.onKeyUp(paramInt, paramKeyEvent);
      label137:
      MiniAppReportManager2.reportPageView("2back_key", "loading_page", null, this.gameConfig);
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
  
  public void onTaskProgress(BaseTask paramBaseTask, float paramFloat, String paramString)
  {
    if ((paramBaseTask instanceof GpkgLoadAsyncTask))
    {
      if ((paramFloat > 0.0F) && (paramFloat < 1.0F)) {
        this.mPkgDownloadFlag = true;
      }
      setProgressTxt((int)(100.0F * paramFloat) + "%");
    }
    while (!(paramBaseTask instanceof GameEngineLoadTask)) {
      return;
    }
    setProgressTxt(paramString);
  }
  
  public void onVConsoleMoveUp()
  {
    initVConsoleLayout();
    this.mVConsoleManager.updateVconsoleView(this.vConsoleView, this.vConsoleBtn, true);
  }
  
  public void setColorNoteWithOutMoveTaskToBackThisTime()
  {
    this.doNotMoveTaskToBackThisTime = true;
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
        QLog.e("[minigame] GameActivity", 1, "showBannerAd, just set visible");
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
          if ((this.mHasNewAd) && (this.mBannerAdOpInfo != null) && (this.mBannerAdOpInfo.report_info != null) && (this.mBannerAdOpInfo.report_info.exposure_url != null)) {
            reportBannerAd(this.mBannerAdOpInfo.report_info.exposure_url.get());
          }
          this.mHasNewAd = false;
          bool = true;
        }
        else
        {
          QLog.e("[minigame] GameActivity", 1, "showBannerAd error, mGdtBannerView is null");
        }
      }
    }
  }
  
  public void startLoadGame()
  {
    QLog.e("[minigame] GameActivity", 1, "--startLoadGame--");
    if ((this.mGameInfo != null) && (this.mGameInfo.needOpenDebugSocket()) && (this.gameConfig != null) && (this.gameConfig.launchParam != null) && (this.gameConfig.launchParam.scene == 1011))
    {
      QLog.e("[minigame] GameActivity", 1, "startLoadGame on ide debug mode");
      this.mQQDebugSocket = new QQDebugWebSocket(this.mGameInfo, GameEngineLoadTask.g(this).getInspectorAgentWrapper());
      if ((this.gameJsPluginEngine != null) && (this.gameJsPluginEngine.hasInit())) {
        this.gameJsPluginEngine.registerPlugin(this.mQQDebugSocket.jsPlugin);
      }
      this.mQQDebugSocket.startConnectIDE(new GameActivity.25(this));
      return;
    }
    QLog.e("[minigame] GameActivity", 1, "startLoadGame on real mode");
    launchGame();
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
          this.mGdtBannerView.a(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth), gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight));
          localView.setLayoutParams(localLayoutParams);
        }
      }
      finally {}
      this.mBannerAdPosInfo.mAdLeft = paramInt2;
      continue;
      this.mBannerAdPosInfo.mAdTop = paramInt2;
      continue;
      this.mBannerAdPosInfo.mAdRealWidth = paramInt2;
      this.mBannerAdPosInfo.mAdRealHeight = ykv.a(0, paramInt2);
      continue;
      label275:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity
 * JD-Core Version:    0.7.0.1
 */