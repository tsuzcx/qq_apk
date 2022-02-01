package com.tencent.qqmini.minigame;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.debug.GameDebugInfo;
import com.tencent.mobileqq.triton.sdk.game.GamePluginInfo;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.qqmini.minigame.action.GetGameInfoManager;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.manager.CustomButtonManager;
import com.tencent.qqmini.minigame.manager.FloatDragAdManager;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.manager.GameVideoPlayerManager;
import com.tencent.qqmini.minigame.ui.VConsoleDragView;
import com.tencent.qqmini.minigame.ui.VConsoleDragView.Listener;
import com.tencent.qqmini.minigame.ui.VConsoleView;
import com.tencent.qqmini.minigame.utils.VConsoleLogManager;
import com.tencent.qqmini.minigame.utils.VConsoleManager;
import com.tencent.qqmini.minigame.widget.DragLinearLayout;
import com.tencent.qqmini.minigame.widget.GameNavigationBar;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo.Builder;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import java.io.File;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GamePage
  implements VConsoleDragView.Listener, Preloadable<IMiniAppContext>, IPage
{
  private static final String TAG = "GamePage";
  private Activity mActivity;
  private CustomButtonManager mCustomButtonManager;
  private TextView mDebuggerEndBtn;
  private View mDebuggerLayer;
  private TextView mDebuggerStatusTv;
  private DragLinearLayout mDebuggerView;
  private FloatDragAdManager mFloatDragAdManager;
  private float mGameDensity = -1.0F;
  private int mGameHeight = 0;
  private MiniGameInfo mGameInfo;
  private View mGameSurfaceView;
  private int mGameWidth = 0;
  private boolean mIsOrientationLandscape;
  private IMiniAppContext mMiniAppContext;
  private MiniAppMonitorInfoView mMiniAppMonitorInfoView;
  private GameNavigationBar mNavigationBar;
  private View mPayForFriendView;
  private ViewGroup mRootView;
  private ITTEngine mTTEngine;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private VConsoleLogManager mVConsoleManager;
  private VConsoleDragView vConsoleBtn;
  private VConsoleView vConsoleView;
  
  GamePage(ITTEngine paramITTEngine)
  {
    this.mTTEngine = paramITTEngine;
  }
  
  private void attachGameSurfaceView(ViewGroup paramViewGroup)
  {
    if (this.mGameInfo == null)
    {
      QMLog.w("GamePage", "Failed to attach game surface view, game info is null");
      return;
    }
    AppStateEvent.obtain(2031).notifyRuntime(this.mMiniAppContext);
    checkGameLandscape();
    QMLog.i("GamePage", " createGameView width :" + this.mGameWidth + " height:" + this.mGameHeight);
    this.mGameSurfaceView = this.mTTEngine.createGameView(this.mActivity, this.mGameWidth, this.mGameHeight);
    paramViewGroup.addView(this.mGameSurfaceView, 0);
    GameVideoPlayerManager.getInstance().init(this.mActivity, (ViewGroup)this.mGameSurfaceView);
  }
  
  private void attachNavigationBar(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null)
    {
      QMLog.w("GamePage", "Failed to attach navigation bar, root view is null");
      return;
    }
    if ((this.mNavigationBar != null) && (this.mNavigationBar.getParent() != null)) {
      ((ViewGroup)this.mNavigationBar.getParent()).removeView(this.mNavigationBar);
    }
    paramViewGroup.addView(this.mNavigationBar);
  }
  
  private void attachVConsoleView(ViewGroup paramViewGroup)
  {
    if (this.mGameInfo == null) {
      QMLog.w("GamePage", "Failed to attach vConsole view, game info is null");
    }
    while (!StorageUtil.getPreference().getBoolean(this.mGameInfo.gameId + "_debug", false)) {
      return;
    }
    this.vConsoleBtn = createVConsoleBtn();
    paramViewGroup.addView(this.vConsoleBtn);
    this.vConsoleBtn.bringToFront();
    this.vConsoleBtn.setVisibility(0);
  }
  
  private void changeWindowInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    while ((paramMiniAppInfo == null) || (this.mActivity == null) || (QUAUtil.isMicroApp())) {
      return;
    }
    if (paramMiniAppInfo.isInternalApp())
    {
      QMLog.i("GamePage", "skip changeWindowInfo for InternalApp.");
      return;
    }
    ThreadManager.executeOnComputationThreadPool(new GamePage.1(this, paramMiniAppInfo, this.mActivity));
  }
  
  private void checkGameLandscape()
  {
    Object localObject = GetGameInfoManager.obtain(this.mMiniAppContext);
    label39:
    int j;
    label155:
    int i;
    int k;
    if (localObject != null)
    {
      localObject = ((GameInfoManager)localObject).getMiniGamePkg();
      MiniGameInfo localMiniGameInfo = this.mGameInfo;
      if (localObject == null) {
        break label438;
      }
      localObject = ((MiniGamePkg)localObject).mGameConfigJson;
      localMiniGameInfo.gameConfigJson = ((JSONObject)localObject);
      if (this.mGameInfo.gameConfigJson != null)
      {
        this.mGameInfo.openDataPath = this.mGameInfo.gameConfigJson.optString("openDataContext", null);
        this.mGameInfo.deviceOrientation = this.mGameInfo.gameConfigJson.optString("deviceOrientation", null);
        if (!"landscape".equals(this.mGameInfo.deviceOrientation)) {
          break label444;
        }
        this.mIsOrientationLandscape = true;
        this.mActivity.setRequestedOrientation(0);
        if (this.mNavigationBar != null) {
          this.mNavigationBar.requestLandscapeLayout();
        }
        if (this.vConsoleBtn != null) {
          this.vConsoleBtn.requestLandscapeLayout();
        }
        boolean bool = this.mGameInfo.gameConfigJson.optBoolean("showStatusBar", false);
        QMLog.i("GamePage", "initGameUI game config showStatusBar=" + bool);
        if (!bool) {
          this.mActivity.getWindow().setFlags(1024, 1024);
        }
      }
      QMLog.i("GamePage", "initGameUI start create game SurfaceView & inject preload js");
      System.currentTimeMillis();
      j = this.mActivity.getResources().getDisplayMetrics().widthPixels;
      i = this.mActivity.getResources().getDisplayMetrics().heightPixels;
      if (Build.VERSION.SDK_INT >= 17)
      {
        localObject = new DisplayMetrics();
        ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
        i = ((DisplayMetrics)localObject).heightPixels;
        j = ((DisplayMetrics)localObject).widthPixels;
        this.mGameDensity = ((DisplayMetrics)localObject).density;
        if (!Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
          break label460;
        }
        k = j;
        if (Settings.Secure.getInt(this.mActivity.getContentResolver(), "display_notch_status", 0) == 1)
        {
          k = j;
          if (this.mGameInfo.isOrientationLandscape()) {
            k = j - DisplayUtil.getStatusBarHeight(this.mActivity);
          }
        }
        j = k;
      }
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
      return;
      localObject = null;
      break;
      label438:
      localObject = null;
      break label39;
      label444:
      this.mIsOrientationLandscape = false;
      this.mActivity.setRequestedOrientation(1);
      break label155;
      label460:
      if ((Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) && (Settings.Global.getInt(this.mActivity.getContentResolver(), "force_black", 0) == 1))
      {
        QMLog.i("GamePage", "xiaomi has notch");
        if (this.mGameInfo.isOrientationLandscape())
        {
          j -= DisplayUtil.getStatusBarHeight(this.mActivity);
        }
        else
        {
          k = DisplayUtil.getStatusBarHeight(this.mActivity);
          i -= k;
        }
      }
    }
  }
  
  private MiniGameInfo createMiniGameInfo(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMiniAppInfo != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
        if (paramMiniAppInfo.debugInfo == null) {
          break label142;
        }
      }
    }
    label142:
    for (localObject1 = new GameDebugInfo(paramMiniAppInfo.debugInfo.wsUrl, paramMiniAppInfo.debugInfo.roomId, 8507);; localObject1 = null)
    {
      if (paramMiniAppInfo.miniGamePluginInfo != null) {
        localObject2 = paramMiniAppInfo.miniGamePluginInfo;
      }
      for (localObject2 = Collections.singletonList(new GamePluginInfo(((MiniGamePluginInfo)localObject2).name, ((MiniGamePluginInfo)localObject2).id, ((MiniGamePluginInfo)localObject2).version, ApkgManager.getGpkgPluginFolderPath((MiniGamePluginInfo)localObject2) + File.separator + "plugin.js"));; localObject2 = null)
      {
        localObject1 = new MiniGameInfo(paramMiniAppInfo.appId, ApkgManager.getApkgFolderPath(paramMiniAppInfo), null, (GameDebugInfo)localObject1, (List)localObject2);
        return localObject1;
      }
    }
  }
  
  private VConsoleDragView createVConsoleBtn()
  {
    VConsoleDragView localVConsoleDragView = new VConsoleDragView(this.mActivity);
    localVConsoleDragView.setImageResource(R.drawable.mini_sdk_game_vconsole);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mActivity, 90.0F), -2);
    localLayoutParams.gravity = 85;
    localLayoutParams.setMargins(0, 0, DisplayUtil.dip2px(this.mActivity, 12.0F), DisplayUtil.dip2px(this.mActivity, 12.0F));
    localVConsoleDragView.setLayoutParams(localLayoutParams);
    localVConsoleDragView.setListener(this);
    this.mUIHandler.postDelayed(new GamePage.2(this, localVConsoleDragView), 1500L);
    return localVConsoleDragView;
  }
  
  private int dip2px(float paramFloat)
  {
    return DisplayUtil.dip2px(this.mActivity, paramFloat);
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
  
  private int getGameViewHeight()
  {
    if (this.mGameSurfaceView != null) {
      return this.mGameSurfaceView.getMeasuredHeight();
    }
    return 0;
  }
  
  private int getGameViewWidth()
  {
    if (this.mGameSurfaceView != null) {
      return this.mGameSurfaceView.getMeasuredWidth();
    }
    return 0;
  }
  
  private String getMenuButtonBoundingClientRect(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    Object localObject = getCapsuleButton();
    int j;
    int i;
    if (localObject != null)
    {
      j = (int)(((View)localObject).getWidth() / DisplayUtil.getDensity(this.mActivity));
      i = (int)(((View)localObject).getHeight() / DisplayUtil.getDensity(this.mActivity));
      int k = (int)(((View)localObject).getLeft() / DisplayUtil.getDensity(this.mActivity));
      int m = (int)(((View)localObject).getTop() / DisplayUtil.getDensity(this.mActivity));
      int n = (int)(((View)localObject).getRight() / DisplayUtil.getDensity(this.mActivity));
      int i1 = (int)(((View)localObject).getBottom() / DisplayUtil.getDensity(this.mActivity));
      localObject = new Rect(267, 34, 347, 64);
      if (j == 0) {
        break label334;
      }
      localObject = new Rect(k, m, n, i1);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("width", j);
        localJSONObject.put("height", i);
        localJSONObject.put("top", ((Rect)localObject).top);
        localJSONObject.put("right", ((Rect)localObject).right);
        localJSONObject.put("bottom", ((Rect)localObject).bottom);
        localJSONObject.put("left", ((Rect)localObject).left);
        paramNativeViewRequestEvent.ok();
        QMLog.d("GamePage", "getMenuButtonBoundingClientRect : " + localJSONObject.toString());
        localObject = localJSONObject.toString();
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("GamePage", paramNativeViewRequestEvent.event + " error.", localJSONException);
        return "";
      }
      QMLog.e("GamePage", "EVENT_GET_MENU_BUTTON_RECT view is null.");
      paramNativeViewRequestEvent.fail();
      return getMenuButtonDefaultValue();
      label334:
      i = 30;
      j = 80;
    }
  }
  
  private String getMenuButtonDefaultValue()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("width", 80);
      ((JSONObject)localObject).put("height", 30);
      ((JSONObject)localObject).put("top", 34);
      ((JSONObject)localObject).put("right", 347);
      ((JSONObject)localObject).put("bottom", 64);
      ((JSONObject)localObject).put("left", 267);
      QMLog.d("GamePage", "getMenuButtonDefaultValue : " + ((JSONObject)localObject).toString());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("GamePage", "getDefaultValue error.", localJSONException);
    }
    return "";
  }
  
  private void initDebuggerLayout()
  {
    if (this.mDebuggerView == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(dip2px(140.0F), dip2px(25.0F));
      localLayoutParams.setMargins(0, dip2px(50.0F), dip2px(10.0F), 0);
      localLayoutParams.addRule(10, 1);
      localLayoutParams.addRule(11, 1);
      this.mDebuggerView = ((DragLinearLayout)LayoutInflater.from(this.mActivity).inflate(R.layout.mini_sdk_game_debugger_layout, null));
      this.mRootView.addView(this.mDebuggerView, localLayoutParams);
      this.mDebuggerStatusTv = ((TextView)this.mDebuggerView.findViewById(R.id.debugger_status_tv));
      this.mDebuggerEndBtn = ((TextView)this.mDebuggerView.findViewById(R.id.debugger_end_btn));
      this.mDebuggerEndBtn.setOnClickListener(new GamePage.4(this));
      this.mDebuggerLayer = new View(this.mActivity);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.mDebuggerLayer.setBackgroundColor(this.mActivity.getResources().getColor(R.color.mini_sdk_color_hei_trans_8));
      this.mRootView.addView(this.mDebuggerLayer, localLayoutParams);
    }
  }
  
  private void initVConsolePanel()
  {
    if (isVConsoleViewShowing()) {
      return;
    }
    this.vConsoleView = new VConsoleView(this.mActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.vConsoleView.setLayoutParams(localLayoutParams);
    this.mRootView.addView(this.vConsoleView);
    this.vConsoleView.setVisibility(8);
    this.vConsoleView.bringToFront();
    this.vConsoleBtn.bringToFront();
    this.vConsoleBtn.setListener(null);
  }
  
  private boolean isMonitorViewShowing()
  {
    return (this.mMiniAppMonitorInfoView != null) && (this.mMiniAppMonitorInfoView.getVisibility() == 0);
  }
  
  private boolean isVConsoleViewShowing()
  {
    return (this.vConsoleView != null) && (this.vConsoleView.getVisibility() == 0);
  }
  
  public void checkPayForFriendLogic(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId)) || (TextUtils.isEmpty(paramMiniAppInfo.prepayId))) {
      QMLog.d("PayForFriendView", "checkPayForFriendLogic not payforfriend mode");
    }
    PayProxy localPayProxy;
    do
    {
      return;
      if ((this.mPayForFriendView != null) && ((this.mPayForFriendView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.mPayForFriendView.getParent()).removeView(this.mPayForFriendView);
      }
      localPayProxy = (PayProxy)ProxyManager.get(PayProxy.class);
      this.mPayForFriendView = localPayProxy.getPayForFriendView(this.mActivity, paramMiniAppInfo.prepayId, paramMiniAppInfo.appId, paramMiniAppInfo.name, paramMiniAppInfo.iconUrl, paramMiniAppInfo.versionId, paramMiniAppInfo.verType);
    } while (this.mPayForFriendView == null);
    paramMiniAppInfo = new RelativeLayout.LayoutParams(-1, -1);
    this.mPayForFriendView.setLayoutParams(paramMiniAppInfo);
    this.mRootView.addView(this.mPayForFriendView);
    this.mPayForFriendView.setVisibility(0);
    this.mPayForFriendView.bringToFront();
    QMLog.d("PayForFriendView", "checkPayForFriendLogic show webview success");
    ActivityResultManager.g().addActivityResultListener(new GamePage.5(this, localPayProxy));
  }
  
  public String dispatchEventToNativeView(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    if ("getMenuButtonBoundingClientRect".equals(paramNativeViewRequestEvent.event)) {
      return getMenuButtonBoundingClientRect(paramNativeViewRequestEvent);
    }
    return "";
  }
  
  public void dispatchEventToWebView(String paramString1, String paramString2, int[] paramArrayOfInt) {}
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public CapsuleButton getCapsuleButton()
  {
    if (this.mNavigationBar != null) {
      return this.mNavigationBar.getCapsuleButton();
    }
    return null;
  }
  
  public MiniGameInfo getGameInfo()
  {
    return this.mGameInfo;
  }
  
  public int getNaviBarTextStyle()
  {
    return -1;
  }
  
  public int getNaviBarVisibility()
  {
    return 0;
  }
  
  public AppPageInfo getPageInfo(int paramInt)
  {
    return new AppPageInfo.Builder().setSurfaceViewHeight(getGameViewHeight()).setSurfaceViewWidth(getGameViewWidth()).setWindowWidth(this.mGameWidth).setWindowHeight(this.mGameHeight).build();
  }
  
  public String getPageOrientation()
  {
    String str = "";
    Object localObject = GetGameInfoManager.obtain(this.mMiniAppContext);
    if (localObject != null)
    {
      localObject = ((GameInfoManager)localObject).getMiniGamePkg();
      if (localObject == null) {
        break label50;
      }
    }
    label50:
    for (localObject = ((MiniGamePkg)localObject).mGameConfigJson;; localObject = null)
    {
      if (localObject != null) {
        str = ((JSONObject)localObject).optString("deviceOrientation", null);
      }
      return str;
      localObject = null;
      break;
    }
  }
  
  public int getTabBarVisibility()
  {
    return 0;
  }
  
  public void hideSoftInput(View paramView) {}
  
  public void init(IMiniAppContext paramIMiniAppContext)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    this.mNavigationBar = new GameNavigationBar(paramIMiniAppContext.getContext());
    this.mNavigationBar.setContentDescription("NavigationBar");
    this.mNavigationBar.setId(R.id.mini_sdk_navigation_bar);
    this.mNavigationBar.attachMiniAppContext(paramIMiniAppContext);
    this.mNavigationBar.setWindowInfo(fakeWindowInfo());
    this.mVConsoleManager = new VConsoleLogManager();
    VConsoleManager.getInstance().registerLogManager(Process.myPid(), this.mVConsoleManager);
  }
  
  boolean isOrientationLandscape()
  {
    return this.mIsOrientationLandscape;
  }
  
  public void onAttachWindow(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramActivity;
    this.mRootView = paramViewGroup;
    attachNavigationBar(paramViewGroup);
    attachGameSurfaceView(paramViewGroup);
    attachVConsoleView(paramViewGroup);
  }
  
  public void onCreate(MiniAppInfo paramMiniAppInfo)
  {
    this.mGameInfo = createMiniGameInfo(paramMiniAppInfo);
  }
  
  public void onDestroy()
  {
    this.mCustomButtonManager = null;
    if (this.mFloatDragAdManager != null)
    {
      this.mFloatDragAdManager.removeDragAd();
      this.mFloatDragAdManager = null;
    }
    if ((this.mActivity != null) && (!this.mActivity.isFinishing())) {
      this.mActivity.finish();
    }
  }
  
  public void onDetachWindow(Activity paramActivity)
  {
    if (this.mRootView != null) {
      this.mRootView.removeAllViews();
    }
    this.mActivity = null;
    this.mRootView = null;
  }
  
  public void onPause() {}
  
  public void onResume(MiniAppInfo paramMiniAppInfo)
  {
    changeWindowInfo(paramMiniAppInfo);
  }
  
  public void onVConsoleMoveUp()
  {
    initVConsolePanel();
    this.mVConsoleManager.updateVconsoleView(this.vConsoleView, this.vConsoleBtn, true);
  }
  
  public boolean operateCustomButton(String paramString, long paramLong, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    Activity localActivity;
    ViewGroup localViewGroup;
    if (this.mCustomButtonManager == null)
    {
      localActivity = this.mActivity;
      localViewGroup = this.mRootView;
      if (this.mGameInfo == null) {
        break label81;
      }
    }
    label81:
    for (String str = this.mGameInfo.gameId;; str = "")
    {
      this.mCustomButtonManager = new CustomButtonManager(localActivity, localViewGroup, str, DisplayUtil.getDensity(this.mActivity));
      if (!"create".equals(paramString)) {
        break;
      }
      return this.mCustomButtonManager.createCustomButton(paramJSONObject, paramOnClickListener);
    }
    if ("show".equals(paramString)) {
      return this.mCustomButtonManager.setCustomButtonVisible(paramLong, true);
    }
    if ("hide".equals(paramString)) {
      return this.mCustomButtonManager.setCustomButtonVisible(paramLong, false);
    }
    if ("destroy".equals(paramString)) {
      return this.mCustomButtonManager.destroyCustomButton(paramLong);
    }
    if ("update".equals(paramString)) {
      return this.mCustomButtonManager.updateCustomButton(paramJSONObject, paramOnClickListener);
    }
    return false;
  }
  
  public boolean operateFloatDragAd(String paramString, FloatDragAdInfo paramFloatDragAdInfo)
  {
    if ("add".equals(paramString))
    {
      if (this.mFloatDragAdManager == null) {
        this.mFloatDragAdManager = new FloatDragAdManager(this.mActivity, this.mMiniAppContext, this.mRootView);
      }
      return this.mFloatDragAdManager.showDragAd(paramFloatDragAdInfo);
    }
    if (("remove".equals(paramString)) && (this.mFloatDragAdManager != null)) {
      return this.mFloatDragAdManager.removeDragAd();
    }
    return false;
  }
  
  public boolean setMiniAIOEntranceVisible(boolean paramBoolean, JSONObject paramJSONObject)
  {
    return false;
  }
  
  public void setNaviVisibility(int paramInt) {}
  
  public void setTabBarVisibility(int paramInt) {}
  
  void showKingCardTips()
  {
    if ((this.mActivity == null) || (this.mActivity.isFinishing())) {}
    while (getCapsuleButton() == null) {
      return;
    }
    ImageView localImageView = getCapsuleButton().getMoreView();
    ((KingCardProxy)ProxyManager.get(KingCardProxy.class)).showKingCardTips(this.mMiniAppContext, localImageView);
  }
  
  public boolean toggleDebugPanel()
  {
    MiniAppInfo localMiniAppInfo;
    if (this.mMiniAppContext != null)
    {
      localMiniAppInfo = this.mMiniAppContext.getMiniAppInfo();
      if (DebugUtil.getDebugEnabled(localMiniAppInfo)) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      DebugUtil.setDebugEnabled(localMiniAppInfo, bool);
      return bool;
      localMiniAppInfo = null;
      break;
    }
  }
  
  public boolean toggleMonitorPanel()
  {
    if (this.mRootView != null)
    {
      if (this.mMiniAppMonitorInfoView != null) {
        break label81;
      }
      this.mMiniAppMonitorInfoView = new MiniAppMonitorInfoView(this.mActivity, null, 1);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      this.mRootView.addView(this.mMiniAppMonitorInfoView, localLayoutParams);
      this.mMiniAppMonitorInfoView.setVisibility(0);
      this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
    }
    for (;;)
    {
      return isMonitorViewShowing();
      label81:
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
  }
  
  void updateDebuggerStatus(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mActivity.runOnUiThread(new GamePage.3(this, paramString1, paramString2, paramBoolean));
  }
  
  void updateMonitorFPSText(double paramDouble)
  {
    if (isMonitorViewShowing()) {
      this.mMiniAppMonitorInfoView.updateFPSText(this.mMiniAppContext, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage
 * JD-Core Version:    0.7.0.1
 */