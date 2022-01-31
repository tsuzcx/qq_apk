package com.tencent.mobileqq.minigame.ui;

import aaji;
import aajj;
import aajk;
import alpo;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anxn;
import aobd;
import aobe;
import ayrh;
import ayri;
import bdee;
import bdkf;
import betl;
import bhos;
import bize;
import bngs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler.Params;
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
import com.tencent.mobileqq.mini.apkg.DebugInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniGamePluginInfo;
import com.tencent.mobileqq.mini.apkg.NavigationBarInfo;
import com.tencent.mobileqq.mini.apkg.WindowInfo;
import com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule;
import com.tencent.mobileqq.mini.app.PreCacheManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.onActivityFinishListener;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
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
import com.tencent.mobileqq.mini.ui.MiniAIOEntryView;
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
import com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager;
import com.tencent.mobileqq.minigame.jsapi.widgets.KeyboardLayout;
import com.tencent.mobileqq.minigame.manager.BannerAdViolationManager;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.manager.EngineInstanceManager;
import com.tencent.mobileqq.minigame.manager.GameCloseManager;
import com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader.GameRuntimeListener;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.manager.PreloadManager;
import com.tencent.mobileqq.minigame.manager.PreloadManager.PreloadListener;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.task.GpkgLoadAsyncTask;
import com.tencent.mobileqq.minigame.task.InstalledEngineLoadTask;
import com.tencent.mobileqq.minigame.task.TritonEngineInitTask;
import com.tencent.mobileqq.minigame.utils.CPUUtil;
import com.tencent.mobileqq.minigame.utils.GameActivityStatusWatcher;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
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

public class GameActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener, GameRuntimeLoader.GameRuntimeListener, PreloadManager.PreloadListener, VConsoleDragView.Listener
{
  private static final int LAUNCH_STATUS_CLICK = 0;
  private static final int LAUNCH_STATUS_FIRST_FRAME = 2;
  private static final int LAUNCH_STATUS_LOAD = 1;
  private static final String TAG = "[minigame] GameActivity";
  private static final Drawable defaultDrawable;
  private static boolean killAllGamesWhenDestroy = GameWnsUtils.killAllGamesWhenDestroy();
  private static boolean killAllGamesWhenReuse;
  public static boolean mHasStorageReport;
  public static final int sIconSize = DisplayUtil.dip2px(BaseApplicationImpl.getContext(), 100.0F);
  private aaji bannerParams;
  protected boolean doNotMoveTaskToBackThisTime;
  Runnable execJS = new GameActivity.32(this);
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
  private ImageView mCloseView;
  protected anxn mColorNoteController;
  private aobe mColorNoteServiceListenr;
  private ViewGroup mContentView;
  private TextView mDebuggerEndBtn;
  private View mDebuggerLayer;
  private TextView mDebuggerStatusTv;
  private DragLinearLayout mDebuggerView;
  private LinearLayout mDeveloperDescLayout;
  private TextView mDeveloperDescView;
  private long mFirstBackPressTime;
  private FPSCallback mFpsListener = new GameActivity.1(this);
  protected MiniAppConfig mGameAppConfig;
  private float mGameDensity = -1.0F;
  private URLImageView mGameFakeFirstFrame;
  private RelativeLayout mGameFakeFirstFrameDownLoadRect;
  private TextView mGameFakeFrameGameName;
  private ProgressBar mGameFakeFrameProgres;
  private TextView mGameFakeFrameProgressText;
  private SquareImageView mGameFakeGameLogo;
  private int mGameHeight;
  private MiniGameInfo mGameInfo;
  private TextView mGameInstruction;
  private GameRuntimeLoader mGameRuntimeLoader;
  private View mGameSurfaceView;
  private TextView mGameVersionDesc;
  private int mGameWidth;
  protected aajj mGdtBannerView;
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
  private int mLaunchResult;
  private int mLaunchStatus = 0;
  private ayri mListener = new GameActivity.37(this);
  private long mLoadGameStartTime;
  private RelativeLayout mLoadingContainer;
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
  private RelativeLayout mRightContainer;
  private ayrh mSoftKeyboardStateHelper;
  private LinearLayout mSplashLayout;
  private boolean mSplashLoadComplete;
  private ProgressBar mSplashProgressBar;
  private TextView mSplashProgressTxt;
  private int mStartMode = 3;
  private ImageView mStartView;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private VConsoleLogManager mVConsoleManager;
  private MiniAIOEntryView miniAIOEntryView;
  private VConsoleDragView vConsoleBtn;
  private VConsoleView vConsoleView;
  private boolean vConsoleViewHasInited;
  
  static
  {
    defaultDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130841009);
    killAllGamesWhenReuse = GameWnsUtils.killAllGamesWhenReuse();
  }
  
  private void callEngineOnResume()
  {
    runOnUiThread(new GameActivity.8(this));
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
  
  private void destroyJsPluginEngine()
  {
    if (this.mGameRuntimeLoader != null)
    {
      GameJsPluginEngine localGameJsPluginEngine = this.mGameRuntimeLoader.getJsPluginEngine();
      if (localGameJsPluginEngine.hasInit()) {
        localGameJsPluginEngine.onDestroy();
      }
    }
  }
  
  private void doOnEngineExit()
  {
    QLog.i("[minigame] GameActivity", 1, "doOnEngineExit");
    GameRuntimeLoaderManager.g().unbindAndRemove(this);
  }
  
  private void doRequestByAppid(String paramString1, String paramString2, String paramString3, LaunchParam paramLaunchParam)
  {
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramString1, paramString2, paramString3, new GameActivity.21(this, paramLaunchParam));
  }
  
  private void doRequestByLink(String paramString1, int paramInt, String paramString2, LaunchParam paramLaunchParam)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString1, paramInt, new GameActivity.22(this, paramLaunchParam));
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
    if (this.mBannerAdOpInfo == null) {
      return null;
    }
    if (this.mGgtAppReceiver == null)
    {
      this.mGgtAppReceiver = new GdtAppReceiver();
      this.mGgtAppReceiver.register(this);
    }
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_c_of_type_Int = 11;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(this.mBannerAdOpInfo);
    localParams.jdField_a_of_type_Boolean = true;
    localParams.jdField_b_of_type_Boolean = true;
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.mGgtAppReceiver);
    localParams.jdField_b_of_type_JavaLangClass = GameBannerAdFragment.class;
    Bundle localBundle = new Bundle();
    localBundle.putString("big_brother_ref_source_key", "biz_src_miniapp");
    localParams.jdField_a_of_type_AndroidOsBundle = localBundle;
    return localParams;
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
  
  private void hideLoadingLayout()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.mLoadingContainer, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.addListener(new GameActivity.11(this));
    localObjectAnimator.start();
    localObjectAnimator = ObjectAnimator.ofFloat(this.mGameSurfaceView, "alpha", new float[] { 0.5F, 1.0F });
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.start();
    if ((!this.mIsOrientationLandscape) && (bngs.jdField_c_of_type_Int > bngs.b))
    {
      bngs.jdField_c_of_type_Boolean = false;
      bngs.a(this);
      if (bngs.b()) {
        bngs.c(this);
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
    if (this.mGameAppConfig == null) {
      this.mGameAppConfig = loadMiniAppConfig((Intent)localObject1);
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
    if ((this.mGameAppConfig.config != null) && (!TextUtils.isEmpty(this.mGameAppConfig.config.appId))) {
      if (this.mGameAppConfig.config.debugInfo == null) {
        break label773;
      }
    }
    label773:
    for (localObject1 = new GameDebugInfo(this.mGameAppConfig.config.debugInfo.wsUrl, this.mGameAppConfig.config.debugInfo.roomId, 0);; localObject1 = null)
    {
      if (this.mGameAppConfig.config.miniGamePluginInfo != null) {
        localObject2 = this.mGameAppConfig.config.miniGamePluginInfo;
      }
      for (Object localObject2 = Collections.singletonList(new GamePluginInfo(((MiniGamePluginInfo)localObject2).name, ((MiniGamePluginInfo)localObject2).id, ((MiniGamePluginInfo)localObject2).version, ApkgManager.getGpkgPluginFolderPath((MiniGamePluginInfo)localObject2) + File.separator + "plugin.js"));; localObject2 = null)
      {
        this.mGameInfo = new MiniGameInfo(this.mGameAppConfig.config.appId, ApkgManager.getApkgFolderPath(this.mGameAppConfig.config), null, (GameDebugInfo)localObject1, (List)localObject2);
        this.mApkgInfo = new ApkgInfo(ApkgManager.getApkgFolderPath(this.mGameAppConfig.config), this.mGameAppConfig);
        localObject1 = new GameBrandRuntime(this, this.mApkgInfo);
        ((GameBrandRuntime)localObject1).setAppId(this.mApkgInfo.appId);
        localObject2 = this.mGameRuntimeLoader.getJsPluginEngine();
        ((GameJsPluginEngine)localObject2).onAttachWindow(this);
        ((GameJsPluginEngine)localObject2).setAppBrandRuntime((BaseAppBrandRuntime)localObject1);
        l = System.currentTimeMillis() - l;
        MiniReportManager.reportEventType(this.mGameAppConfig, 1032, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
        QLog.e("[minigame][timecost] ", 1, new Object[] { "step[initDataMustOnResume] cost time ", Long.valueOf(l) });
        this.mLoadGameStartTime = System.currentTimeMillis();
        if (this.mIsFromSplash) {
          if (PreloadManager.g().getState() == 2)
          {
            this.mUIHandler.post(new GameActivity.18(this));
            this.mSplashLoadComplete = true;
            this.mProgressStr = "100%";
          }
        }
        for (;;)
        {
          ThreadManagerV2.excute(new GameActivity.19(this), 16, null, false);
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
    }
  }
  
  private void initDebuggerLayout()
  {
    if (this.mDebuggerView == null)
    {
      this.mDebuggerView = ((DragLinearLayout)((ViewStub)findViewById(2131365040)).inflate());
      this.mDebuggerLayer = findViewById(2131365036);
      this.mDebuggerStatusTv = ((TextView)findViewById(2131365039));
      this.mDebuggerEndBtn = ((TextView)findViewById(2131365037));
      this.mDebuggerEndBtn.setOnClickListener(new GameActivity.31(this));
    }
  }
  
  private void initGameUI()
  {
    if (this.mHasInitUI) {
      return;
    }
    if ((this.mGameInfo != null) && (this.mGameRuntimeLoader.getMiniGamePkg() != null))
    {
      this.mGameInfo.gameConfigJson = this.mGameRuntimeLoader.getMiniGamePkg().mGameConfigJson;
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
        boolean bool = this.mGameInfo.gameConfigJson.optBoolean("showStatusBar", false);
        QLog.i("[minigame] GameActivity", 1, "initGameUI game config showStatusBar=" + bool);
        if (bool)
        {
          localObject1 = getWindow().getAttributes();
          ((WindowManager.LayoutParams)localObject1).flags &= 0xFFFFFBFF;
          getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
          getWindow().clearFlags(512);
        }
      }
    }
    QLog.e("[minigame] GameActivity", 1, "initGameUI start create game SurfaceView");
    long l = System.currentTimeMillis();
    Object localObject1 = this.mGameRuntimeLoader.getGameEngine();
    ((ITTEngine)localObject1).onCreate(this);
    int j = getResources().getDisplayMetrics().widthPixels;
    int i = getResources().getDisplayMetrics().heightPixels;
    Object localObject2;
    int k;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject2 = new DisplayMetrics();
      ((WindowManager)getSystemService("window")).getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject2);
      i = ((DisplayMetrics)localObject2).heightPixels;
      j = ((DisplayMetrics)localObject2).widthPixels;
      this.mGameDensity = ((DisplayMetrics)localObject2).density;
      if (!Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
        break label612;
      }
      k = j;
      if (Settings.Secure.getInt(getContentResolver(), "display_notch_status", 0) == 1)
      {
        k = j;
        if (this.mGameInfo.isOrientationLandscape()) {
          k = j - bdkf.a(this);
        }
      }
      j = k;
    }
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
      this.mGameSurfaceView = ((ITTEngine)localObject1).createGameView(this, k, m);
      this.mGameSurfaceView.setId(2131370566);
      this.mContentView.addView(this.mGameSurfaceView, 0);
      GameVideoPlayerManager.getInstance().init(this, (ViewGroup)this.mGameSurfaceView);
      localObject2 = ((ITTEngine)localObject1).getGameLauncher();
      if (localObject2 != null) {
        ((IGameLauncher)localObject2).setCurrentGame(this.mGameInfo);
      }
      ((ITTEngine)localObject1).addFPSCallback(this.mFpsListener);
      ((ITTEngine)localObject1).setEngineListener(new GameActivity.27(this, l));
      ((ITTEngine)localObject1).setEnableCodeCache(GameWnsUtils.isCodeCacheEnable());
      this.mHasInitUI = true;
      return;
      label612:
      if ((Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) && (Settings.Global.getInt(getContentResolver(), "force_black", 0) == 1))
      {
        QLog.i("[minigame] GameActivity", 1, "xiaomi has notch");
        if (this.mGameInfo.isOrientationLandscape())
        {
          j -= bdkf.a(this);
        }
        else
        {
          k = bdkf.a(this);
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
    localGameJsPluginEngine.onCreate(this);
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
    this.mNavBar = ((NavigatorBarForMiniGame)findViewById(2131370565));
    this.mNavBar.setApkgInfoAndInit(this.mApkgInfo);
    this.mNavBar.setWindowInfo(fakeWindowInfo());
  }
  
  private void initUI()
  {
    setContentView(2131559325);
    this.mContentView = ((ViewGroup)findViewById(2131370563));
    this.mBannerAdContainer = ((FrameLayout)findViewById(2131370561));
    this.mLoadingContainer = ((RelativeLayout)findViewById(2131366789));
    this.mRightContainer = ((RelativeLayout)findViewById(2131364766));
    Object localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(this, 80.0F), DisplayUtil.dip2px(this, 30.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    if (bngs.b()) {}
    for (int i = ImmersiveUtils.getStatusBarHeight(this) + DisplayUtil.dip2px(this, 10.0F);; i = DisplayUtil.dip2px(this, 10.0F))
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(this, 12.5F);
      this.mRightContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mCenterLayout = ((LinearLayout)findViewById(2131364063));
      this.mBottonLayout = ((LinearLayout)findViewById(2131363407));
      this.mSplashLayout = ((LinearLayout)findViewById(2131376904));
      this.mGameInstruction = ((TextView)findViewById(2131367037));
      this.mGameVersionDesc = ((TextView)findViewById(2131367058));
      this.mJumpBtn = ((TextView)findViewById(2131368987));
      this.mMoreView = ((ImageView)findViewById(2131363630));
      this.mMoreView.setOnLongClickListener(this);
      this.mCloseView = ((ImageView)findViewById(2131363541));
      this.mNameView = ((TextView)findViewById(2131367041));
      this.mDeveloperDescView = ((TextView)findViewById(2131365170));
      this.mDeveloperDescLayout = ((LinearLayout)findViewById(2131365171));
      this.mLogoView = ((SquareImageView)findViewById(2131369845));
      this.mLogoView.setRoundRect(sIconSize);
      this.mGameFakeFirstFrameDownLoadRect = ((RelativeLayout)findViewById(2131370632));
      this.mGameFakeFirstFrame = ((URLImageView)findViewById(2131367036));
      this.mGameFakeFrameProgres = ((ProgressBar)findViewById(2131370630));
      this.mGameFakeFrameProgressText = ((TextView)findViewById(2131370631));
      this.mGameFakeFrameGameName = ((TextView)findViewById(2131370629));
      this.mGameFakeGameLogo = ((SquareImageView)findViewById(2131370628));
      this.mProgressTxt = ((TextView)findViewById(2131379077));
      this.mSplashProgressTxt = ((TextView)findViewById(2131376906));
      this.mSplashProgressBar = ((ProgressBar)findViewById(2131376903));
      this.mMoreView.setOnClickListener(this);
      this.mCloseView.setOnClickListener(this);
      this.mJumpBtn.setOnClickListener(this);
      new ImmersionBar(this, 0, findViewById(2131376953));
      if ((!TextUtils.isEmpty(MiniAppGlobal.CAPSULE_CLOSE_URL)) && (!TextUtils.isEmpty(MiniAppGlobal.CAPSULE_CLOSE_DARK_URL)))
      {
        localObject = MiniAppUtils.getIcon(this, MiniAppGlobal.CAPSULE_CLOSE_URL, true, 2130840978, 40, 30);
        this.mCloseView.setImageDrawable((Drawable)localObject);
      }
      this.mColorNoteController = new anxn(this, false, true);
      this.mColorNoteController.a(this);
      this.mColorNoteController.a(new GameActivity.23(this));
      this.mColorNoteController.a(new GameActivity.24(this));
      this.mColorNoteServiceListenr = new GameActivity.25(this);
      this.mColorNoteController.a(this.mColorNoteServiceListenr);
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
    this.vConsoleBtn.setImageResource(2130840793);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(bdkf.b(90.0F), -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    localLayoutParams.setMargins(0, 0, bdkf.b(12.0F), bdkf.b(12.0F));
    this.vConsoleBtn.setLayoutParams(localLayoutParams);
    this.vConsoleBtn.setListener(this);
    this.mContentView.addView(this.vConsoleBtn);
    this.vConsoleBtn.bringToFront();
    this.vConsoleBtn.setVisibility(0);
    this.mUIHandler.postDelayed(new GameActivity.14(this), 1500L);
  }
  
  private void injectAccountInfoConfig()
  {
    if ((this.mGameAppConfig != null) && (this.mGameAppConfig.config != null))
    {
      String str = "var __wxConfig = __wxConfig || {}; __wxConfig.accountInfo = __wxConfig.accountInfo || {}; \n__wxConfig.accountInfo.appId = '" + this.mGameAppConfig.config.appId + "';\n__wxConfig.accountInfo.icon = '" + this.mGameAppConfig.config.iconUrl + "'; __wxConfig.deviceinfo='" + bize.a().f() + "'; __wxConfig.miniapp_version='" + this.mGameAppConfig.config.version + "';";
      if (QLog.isColorLevel()) {
        QLog.i("[minigame] GameActivity", 1, "injectAccountInfoConfig:" + str);
      }
      ITTEngine localITTEngine = this.mGameRuntimeLoader.getGameEngine();
      localITTEngine.getJsRuntime(1).evaluateJs(str);
      localITTEngine.getJsRuntime(2).evaluateJs(str);
    }
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
  
  private void onPauseReport()
  {
    lifecycleReport("launch_report_app_pause");
    this.mIsForground = false;
    long l = this.mGameRuntimeLoader.getGameEngine().getLastBlackTime();
    if ((this.mOnFirstBlackScreenReport) && (l > 0L))
    {
      l = System.currentTimeMillis() - l;
      if (l > 0L)
      {
        this.mOnFirstBlackScreenReport = false;
        MiniReportManager.reportEventType(this.mGameAppConfig, 1018, null, null, null, 0, "1", l, null);
        QLog.e("[minigame] GameActivity", 1, "doOnPause blackTimeDuration " + l);
      }
    }
    if ((this.mOnFirstHide) && (this.mOnShowTime > 0L))
    {
      this.mOnFirstHide = false;
      MiniReportManager.reportEventType(this.mGameAppConfig, 1016, "1");
      l = System.currentTimeMillis() - this.mOnShowTime;
      if (l > 0L) {
        MiniReportManager.reportEventType(this.mGameAppConfig, 1020, null, null, null, 0, "1", l, null);
      }
    }
    l = System.currentTimeMillis() - this.mOnShowTime;
    if ((l > 0L) && (this.mOnShowTime > 0L)) {
      MiniReportManager.reportEventType(this.mGameAppConfig, 1021, null, null, null, 0, "1", l, null);
    }
    l = Storage.getCurrentStorageSize(this.mGameRuntimeLoader.getGameInfoManager().getAppId());
    if ((l >= 0L) && (!mHasStorageReport))
    {
      mHasStorageReport = true;
      MiniReportManager.reportEventType(this.mGameAppConfig, 639, null, String.valueOf(l), null, 1, "1", 0L, null);
    }
    MiniReportManager.reportEventType(this.mGameAppConfig, 20, "1");
    if (this.mOnShowReported)
    {
      this.mOnShowReported = false;
      MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "hide", null);
    }
    for (;;)
    {
      MiniAppReportManager2.reportPageView("2hide", null, null, this.mGameAppConfig);
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
      ThreadManagerV2.excute(new GameActivity.28(this), 16, null, false);
    }
  }
  
  private void reportBannerAd(String paramString)
  {
    QLog.i("[minigame] GameActivity", 1, "reportBannerAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new GameActivity.36(this, paramString));
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
    runOnUiThread(new GameActivity.20(this, paramString, paramLong));
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
              this.mDeveloperDescView.setText(alpo.a(2131705392) + this.mGameAppConfig.config.developerDesc + alpo.a(2131705391));
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
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = sIconSize;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = sIconSize;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = defaultDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = defaultDrawable;
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
          if (!bhos.a((String)localObject1)) {
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
          Drawable localDrawable = getResources().getDrawable(2131167138);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
          localObject2 = URLDrawable.getDrawable(URLDecoder.decode((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2);
          this.mGameFakeFirstFrame.setURLDrawableDownListener(new GameActivity.26(this));
          ((URLDrawable)localObject2).run();
          this.mGameFakeFirstFrame.setImageDrawable((Drawable)localObject2);
          label592:
          if (this.mIsFromSplash)
          {
            this.mRightContainer.setVisibility(8);
            this.mBottonLayout.setVisibility(8);
            this.mCenterLayout.setVisibility(8);
            this.mSplashLayout.setVisibility(0);
            this.mJumpBtn.setVisibility(0);
            if (Build.VERSION.SDK_INT < 16) {
              break label822;
            }
            this.mLoadingContainer.setBackground(new BitmapDrawable(getResources(), PreloadManager.g().mSlashPic));
            if (PreloadManager.g().mStartBtnPic != null)
            {
              this.mStartView = ((ImageView)findViewById(2131363720));
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
            label822:
            this.mLoadingContainer.setBackgroundDrawable(new BitmapDrawable(getResources(), PreloadManager.g().mSlashPic));
          }
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
    ThreadManagerV2.excute(new GameActivity.38(this), 16, null, true);
  }
  
  private void updateDebuggerStatus(String paramString1, String paramString2, boolean paramBoolean)
  {
    runOnUiThread(new GameActivity.30(this, paramString1, paramString2, paramBoolean));
  }
  
  protected void changeWindowInfo(MiniAppConfig paramMiniAppConfig)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ThreadManagerV2.excute(new GameActivity.13(this, paramMiniAppConfig), 16, null, false);
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
      this.bannerParams = new aaji();
      this.bannerParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = getBannerClickParams();
      this.bannerParams.jdField_a_of_type_Int = 0;
      this.bannerParams.b = gameDpTopx(paramBannerAdPosInfo.mAdRealWidth);
      this.bannerParams.jdField_c_of_type_Int = gameDpTopx(paramBannerAdPosInfo.mAdRealHeight);
      this.mGdtBannerView = aajk.a(this.bannerParams);
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
      runOnUiThread(new GameActivity.35(this));
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
    reportOnBackPressed();
    quitDebugSocket();
    notifyGameStop();
    if (this.mIsFromSplash)
    {
      startMainActivity();
      this.mUIHandler.postDelayed(new GameActivity.34(this), 300L);
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
    QLog.i("[minigame] GameActivity", 1, "doOnCreate " + this + ", pid:" + Process.myPid());
    this.mIsFakeFrameValid = false;
    this.mBeginOnCreate = System.currentTimeMillis();
    this.mBroadCastWatcher = new GameActivityStatusWatcher(this);
    this.mBroadCastWatcher.setOnHomePressedListener(new GameActivity.10(this));
    this.mBroadCastWatcher.startWatch();
    Object localObject = getIntent();
    MiniAppConfig localMiniAppConfig = loadMiniAppConfig((Intent)localObject);
    long l = ((Intent)localObject).getLongExtra("startDuration", 0L);
    this.mStartMode = ((Intent)localObject).getIntExtra("start_mode", 3);
    l = this.mBeginOnCreate - l;
    if (localMiniAppConfig != null) {
      MiniReportManager.reportEventType(localMiniAppConfig, 1030, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
    }
    QLog.e("[minigame][timecost] ", 1, new Object[] { "step[startActivity] cost time ", Long.valueOf(l), ", startMode " + this.mStartMode });
    if (CPUUtil.sIsX86Emulator)
    {
      if (localMiniAppConfig != null)
      {
        MiniProgramLpReportDC04239.reportPageView(localMiniAppConfig, "1", null, "load_fail", "system_version_limit_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "system_version_limit_fail", null, localMiniAppConfig);
      }
      QQToast.a(getApplicationContext(), 2131694435, 1).a();
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
      getWindow().setFlags(1024, 1024);
      getWindow().setFormat(-2);
      setRequestedOrientation(1);
      reportLaunch();
      localObject = (EngineChannel)((Intent)localObject).getParcelableExtra("engineChannel");
      EngineInstanceManager.g().setEngineChannelIfNeed((EngineChannel)localObject);
      if (this.mIsFromSplash)
      {
        this.mGameRuntimeLoader = GameRuntimeLoaderManager.g().getBindRuntimeLoader(BaseApplicationImpl.getApplication());
        GameRuntimeLoaderManager.g().reBindRuntimeLoader(this.mGameRuntimeLoader, this);
        this.mActNeedImmersive = false;
        bngs.a(this);
        if (bngs.b())
        {
          if ((!Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) || ((Build.VERSION.SDK_INT != 26) && (Build.VERSION.SDK_INT != 27))) {
            break label635;
          }
          enableXiaoMiNotch(this);
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
        label635:
        bngs.c(this);
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
    MiniAppClientQIPCModule.unRegisterModule();
    ITTEngine localITTEngine;
    if (this.mGameRuntimeLoader != null) {
      localITTEngine = this.mGameRuntimeLoader.getGameEngine();
    }
    for (;;)
    {
      if (localITTEngine != null)
      {
        localITTEngine.removeFPSCallback(this.mFpsListener);
        if (!killAllGamesWhenDestroy)
        {
          QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy killAllGamesWhenDestroy :" + killAllGamesWhenDestroy);
          ThreadManagerV2.excute(new GameActivity.16(this, localITTEngine), 16, null, false);
        }
      }
      destroyJsPluginEngine();
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
          if (this.mGdtBannerView != null) {
            this.mGdtBannerView.c(this);
          }
          if (this.mGgtAppReceiver == null) {}
        }
        try
        {
          this.mGgtAppReceiver.unregister(this);
          label287:
          this.mGgtAppReceiver = null;
          if (this.mColorNoteController != null) {
            this.mColorNoteController.c();
          }
          if ((this.mNavBar != null) && (this.mNavBar.getCapsuleButton() != null) && (this.mNavBar.getCapsuleButton().mGameActivityFinishListener != null)) {
            this.mNavBar.getCapsuleButton().mGameActivityFinishListener.onActivityFinish();
          }
          while (!killAllGamesWhenDestroy)
          {
            return;
            localITTEngine = null;
            break;
            QLog.e("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy kill self gameConfig=null");
            break label216;
          }
          QLog.i("[minigame] GameActivity", 1, "[MiniEng]doOnDestroy killProcess  :");
          QLog.e("[minigame] GameActivity", 1, "doOnDestroy kill process" + getGameInfo());
          this.mUIHandler.postDelayed(new GameActivity.17(this), 300L);
          return;
        }
        catch (Throwable localThrowable1)
        {
          break label287;
        }
      }
      catch (Throwable localThrowable2)
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
          break label138;
        }
        if ((!paramIntent.isShortcutFakeApp()) && (localGameInfoManager != null)) {
          localGameInfoManager.updateMiniAppConfig(paramIntent);
        }
      }
    }
    for (;;)
    {
      MiniGdtReporter.prepareReport();
      return;
      localGameInfoManager = null;
      break;
      label138:
      localGameInfoManager.updateMiniAppConfig(paramIntent);
    }
  }
  
  public void doOnPause()
  {
    QLog.e("[minigame] GameActivity", 1, "doOnPause " + getGameInfo());
    super.doOnPause();
    onPauseReport();
    this.mIsEngineResumed = false;
    ITTEngine localITTEngine = this.mGameRuntimeLoader.getGameEngine();
    GameJsPluginEngine localGameJsPluginEngine = this.mGameRuntimeLoader.getJsPluginEngine();
    if ((localGameJsPluginEngine != null) && (localGameJsPluginEngine.hasInit())) {
      localGameJsPluginEngine.onPause();
    }
    notifyGameOnHide();
    if (this.mGdtBannerView != null) {
      this.mGdtBannerView.a(this);
    }
    hideKeyBoard();
    this.mGameRuntimeLoader.getGameInfoManager().resetQuery();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.b();
    }
    WebAudioManager.getInstance().suspendAudioContext(localITTEngine);
    aobd.a(BaseApplicationImpl.getContext(), 2, true);
    GameGrowthGuardianManager.executeEnd(this, this.mGameAppConfig);
    localITTEngine.onPause();
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
    MiniReportManager.reportEventType(this.mGameAppConfig, 1, "1");
    betl.a(this);
    lifecycleReport("launch_report_app_resume");
    Object localObject;
    long l;
    label267:
    label328:
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
      if ((this.mGameInfo != null) && (getEnableDebug()) && (this.vConsoleBtn == null)) {
        initVConsoleView();
      }
      this.mHasInitDataMustOnResume = true;
      MiniReportManager.reportEventType(this.mGameAppConfig, 1013, "1");
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
      if (this.mGdtBannerView != null) {
        this.mGdtBannerView.b(this);
      }
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
        label394:
        if (i != 3) {
          break label743;
        }
        MiniAppStartState.setProcessLoad(this.mGameAppConfig.config.appId, false);
      }
    }
    for (;;)
    {
      WebAudioManager.getInstance().resumeAudioContext(this.mGameRuntimeLoader.getGameEngine());
      this.mIsForground = true;
      if (this.mNeedLaunchGameOnResume) {
        launchGame();
      }
      if (this.mColorNoteController != null) {
        this.mColorNoteController.a();
      }
      aobd.a(BaseApplicationImpl.getContext(), 2, false);
      l = System.currentTimeMillis() - this.mBeginOnResume;
      if (!this.mHasReportStepOnResume)
      {
        this.mHasReportStepOnResume = true;
        MiniReportManager.reportEventType(this.mGameAppConfig, 1035, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
      }
      QLog.e("[minigame][timecost] ", 1, new Object[] { "step[onResume] cost time ", Long.valueOf(l), ", include steps[initDataMustOnResume, setupUI] " + getGameInfo() });
      GameGrowthGuardianManager.executeBegin(this, this.mGameAppConfig);
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
      break label267;
      label732:
      localObject = null;
      break label328;
      label738:
      i = 3;
      break label394;
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
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    ThreadManagerV2.excute(new GameActivity.15(this), 16, null, true);
    MiniAppBannerIPCModule.notifyEnterBackground(this.mApkgInfo);
    this.mPerformanceStatics.stopReport(this.mGameRuntimeLoader.getGameEngine().getTargetFPS());
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
      this.mUIHandler.postDelayed(new GameActivity.33(this), 300L);
      return;
    }
    finish();
  }
  
  public BannerAdPosInfo getBannerAdPosInfo()
  {
    return this.mBannerAdPosInfo;
  }
  
  public anxn getColorNoteController()
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
    return (GameBrandRuntime)this.mGameRuntimeLoader.getJsPluginEngine().appBrandRuntime;
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
    QLog.i("[minigame] GameActivity", 1, "density = " + localDisplayMetrics.density + ", ViewUtils.density = " + bdkf.a() + ", screenW = " + localDisplayMetrics.widthPixels + ", screenH = " + localDisplayMetrics.heightPixels);
    if (this.mGameDensity != bdkf.a()) {
      this.mReportHandler.post(new GameActivity.39(this));
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
    if (this.mKeyboardLayout == null)
    {
      this.mKeyboardLayout = new KeyboardLayout(this);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      this.mContentView.addView(this.mKeyboardLayout, localLayoutParams);
      this.mSoftKeyboardStateHelper = new ayrh(this.mContentView);
      this.mSoftKeyboardStateHelper.a(this.mListener);
    }
    return this.mKeyboardLayout;
  }
  
  public String getLaunchResult()
  {
    return String.valueOf(this.mLaunchResult);
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
      this.miniAIOEntryView.destroy();
      this.miniAIOEntryView = null;
    }
  }
  
  public void notifyGameOnHide()
  {
    GameJsPluginEngine localGameJsPluginEngine = this.mGameRuntimeLoader.getJsPluginEngine();
    if (localGameJsPluginEngine.hasInit())
    {
      QLog.e("[minigame] GameActivity", 1, "onHide()");
      localGameJsPluginEngine.callJsApi("onAppEnterBackground", null);
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
        break label79;
      }
    }
    label79:
    for (String str = "";; str = localJSONObject.toString())
    {
      QLog.e("[minigame] GameActivity", 1, str + ")");
      localGameJsPluginEngine.callJsApi("onAppEnterForeground", localJSONObject);
      return;
    }
  }
  
  public void notifyGameStop()
  {
    GameJsPluginEngine localGameJsPluginEngine = this.mGameRuntimeLoader.getJsPluginEngine();
    if (localGameJsPluginEngine.hasInit())
    {
      QLog.e("[minigame] GameActivity", 1, "onAppStop()");
      localGameJsPluginEngine.callJsApi("onAppStop", null);
    }
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
        } while ((GameCloseManager.showAlertViewForBattleGame(this, this.mGameAppConfig, new GameActivity.3(this))) || (GameCloseManager.showPullDownGuideDialog(this, this.mGameAppConfig, new GameActivity.4(this))));
        performMiniGameClose();
        return;
        QLog.e("[minigame] GameActivity", 1, "[jump_btn, loading page close]");
        finishActivity();
        paramView = PreloadManager.g().getMiniAppConfig();
      } while ((paramView == null) || (paramView.config == null));
      MiniProgramLpReportDC04746.report(paramView.config.appId, paramView.config.version, 2, 1);
      return;
      QLog.e("[minigame] GameActivity", 1, "[btn_start]");
      tryStartGameWhenReady();
      paramView = PreloadManager.g().getMiniAppConfig();
    } while ((paramView == null) || (paramView.config == null));
    MiniProgramLpReportDC04746.report(paramView.config.appId, paramView.config.version, 2, 2);
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
      injectAccountInfoConfig();
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
          paramKeyEvent = this.mGameRuntimeLoader.getJsPluginEngine();
          if (paramKeyEvent.getGameJsRuntime(1) != null) {
            paramKeyEvent.getGameJsRuntime(1).evaluateSubcribeJS("onPause", "{}", -1);
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
  
  public void onTaskProgress(BaseTask paramBaseTask, float paramFloat, String paramString)
  {
    if ((paramBaseTask instanceof GpkgLoadAsyncTask))
    {
      if ((paramFloat > 0.0F) && (paramFloat < 1.0F)) {
        this.mPkgDownloadFlag = true;
      }
      setProgressTxt(paramFloat, paramString);
    }
    while ((!(paramBaseTask instanceof TritonEngineInitTask)) && (!(paramBaseTask instanceof InstalledEngineLoadTask))) {
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
        BannerAdViolationManager.scheduleViolationDetectTask(getMiniGameAppId(), this.mBannerAdOpInfo, this.mGdtBannerView.a());
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
          BannerAdViolationManager.scheduleViolationDetectTask(getMiniGameAppId(), this.mBannerAdOpInfo, this.mGdtBannerView.a());
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
        this.miniAIOEntryView.setStyle(paramJSONObject);
        this.miniAIOEntryView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mContentView.requestLayout();
      }
      j = -10;
    }
  }
  
  public void startLoadGame()
  {
    QLog.e("[minigame] GameActivity", 1, "--startLoadGame--");
    if ((this.mGameInfo != null) && (this.mGameInfo.needOpenDebugSocket()) && (this.mGameAppConfig != null) && (this.mGameAppConfig.launchParam != null) && (this.mGameAppConfig.launchParam.scene == 1011))
    {
      QLog.e("[minigame] GameActivity", 1, "startLoadGame on ide debug mode");
      this.mQQDebugSocket = new QQDebugWebSocket(this.mGameInfo, this.mGameRuntimeLoader.getInspectorAgentWrapper());
      GameJsPluginEngine localGameJsPluginEngine = this.mGameRuntimeLoader.getJsPluginEngine();
      if (localGameJsPluginEngine.hasInit()) {
        localGameJsPluginEngine.registerPlugin(this.mQQDebugSocket.jsPlugin);
      }
      this.mQQDebugSocket.startConnectIDE(new GameActivity.29(this));
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
    if (bdee.a(getActivity()) == 0)
    {
      if (!this.mGameAppConfig.config.isSupportOffline)
      {
        MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "load_fail", "offline_not_support");
        MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_support", null, this.mGameAppConfig);
        QQToast.a(this, alpo.a(2131705382), 0).a();
        return;
      }
      if (!GpkgManager.isOfflineResourceReady(this.mGameAppConfig))
      {
        MiniProgramLpReportDC04239.reportPageView(this.mGameAppConfig, "1", null, "load_fail", "offline_not_ready");
        MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_ready", null, this.mGameAppConfig);
        QQToast.a(this, alpo.a(2131705387), 0).a();
        return;
      }
    }
    QLog.i("[minigame] GameActivity", 1, "[MiniEng] Start Game! SO Engine:" + this.mGameRuntimeLoader.getInstalledEngine());
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
      this.mBannerAdPosInfo.mAdRealHeight = aajk.a(0, paramInt2);
      continue;
      label275:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity
 * JD-Core Version:    0.7.0.1
 */