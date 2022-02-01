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
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Orientation;
import com.tencent.qqmini.minigame.action.GetGameInfoManager;
import com.tencent.qqmini.minigame.api.MiniGamePackage;
import com.tencent.qqmini.minigame.api.MiniGamePackageManager;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.manager.CustomButtonManager;
import com.tencent.qqmini.minigame.manager.FloatDragAdManager;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.manager.PendantManager;
import com.tencent.qqmini.minigame.ui.VConsoleDragView;
import com.tencent.qqmini.minigame.ui.VConsoleDragView.Listener;
import com.tencent.qqmini.minigame.ui.VConsoleView;
import com.tencent.qqmini.minigame.utils.VConsoleLogManager;
import com.tencent.qqmini.minigame.utils.VConsoleManager;
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
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
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
  private ViewGroup mDebuggerView;
  private FloatDragAdManager mFloatDragAdManager;
  private ViewGroup mGameContainerView;
  private int mGameHeight = 0;
  private MiniGamePackage mGameInfo;
  private SurfaceView mGameSurfaceView;
  private int mGameWidth = 0;
  private boolean mIsOrientationLandscape;
  private IMiniAppContext mMiniAppContext;
  private MiniAppMonitorInfoView mMiniAppMonitorInfoView;
  private GameNavigationBar mNavigationBar;
  private View mPayForFriendView;
  private PendantManager mPendantManager;
  private ViewGroup mRootView;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private VConsoleLogManager mVConsoleManager;
  private VConsoleDragView vConsoleBtn;
  private VConsoleView vConsoleView;
  
  private void attachGameSurfaceView(ViewGroup paramViewGroup)
  {
    if (this.mGameInfo == null)
    {
      QMLog.w("GamePage", "Failed to attach game surface view, game info is null");
      return;
    }
    AppStateEvent.obtain(2031).notifyRuntime(this.mMiniAppContext);
    checkGameLandscape();
    this.mGameContainerView = ((ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mini_sdk_game_layout, paramViewGroup, false));
    this.mGameSurfaceView = ((SurfaceView)this.mGameContainerView.findViewById(R.id.mini_sdk_game_layout_surface_view));
    paramViewGroup.addView(this.mGameContainerView, 0);
    QMLog.i("GamePage", " createGameView width :" + this.mGameWidth + " height:" + this.mGameHeight);
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
    do
    {
      do
      {
        return;
      } while (!StorageUtil.getPreference().getBoolean(this.mGameInfo.getId() + "_debug", false));
      this.vConsoleBtn = createVConsoleBtn();
      paramViewGroup.addView(this.vConsoleBtn);
      this.vConsoleBtn.bringToFront();
      this.vConsoleBtn.setVisibility(0);
    } while (this.mGameInfo.getOrientation() != GamePackage.Orientation.LANDSCAPE);
    this.vConsoleBtn.requestLandscapeLayout();
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
    if (this.mGameInfo.getOrientation() == GamePackage.Orientation.LANDSCAPE)
    {
      this.mIsOrientationLandscape = true;
      this.mActivity.setRequestedOrientation(0);
      if (this.mNavigationBar != null) {
        this.mNavigationBar.requestLandscapeLayout();
      }
    }
    try
    {
      boolean bool = new JSONObject(this.mGameInfo.getGameConfig()).optBoolean("showStatusBar", false);
      QMLog.i("GamePage", "initGameUI game config showStatusBar=" + bool);
      if (!bool) {
        this.mActivity.getWindow().setFlags(1024, 1024);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int k;
        int i;
        DisplayMetrics localDisplayMetrics;
        continue;
        int m = i;
        int n = j;
        continue;
        int j = m;
      }
    }
    QMLog.i("GamePage", "initGameUI start create game SurfaceView & inject preload js");
    System.currentTimeMillis();
    if (this.mGameInfo.getOrientation() == GamePackage.Orientation.LANDSCAPE)
    {
      k = 1;
      label137:
      j = this.mActivity.getResources().getDisplayMetrics().widthPixels;
      i = this.mActivity.getResources().getDisplayMetrics().heightPixels;
      if (Build.VERSION.SDK_INT < 17) {
        break label425;
      }
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      i = localDisplayMetrics.heightPixels;
      m = localDisplayMetrics.widthPixels;
      if (!Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
        break label333;
      }
      j = m;
      if (Settings.Secure.getInt(this.mActivity.getContentResolver(), "display_notch_status", 0) == 1)
      {
        j = m;
        if (k != 0) {
          j = m - DisplayUtil.getStatusBarHeight(this.mActivity);
        }
      }
    }
    for (;;)
    {
      if (k != 0)
      {
        m = j;
        n = i;
        if (j <= i) {}
      }
      else
      {
        if ((k != 0) || (i > j)) {
          break label410;
        }
        n = i;
        m = j;
      }
      this.mGameWidth = n;
      this.mGameHeight = m;
      return;
      this.mIsOrientationLandscape = false;
      this.mActivity.setRequestedOrientation(1);
      break;
      k = 0;
      break label137;
      label333:
      if ((!Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) || (Settings.Global.getInt(this.mActivity.getContentResolver(), "force_black", 0) != 1)) {
        break label419;
      }
      QMLog.i("GamePage", "xiaomi has notch");
      if (k != 0)
      {
        j = m - DisplayUtil.getStatusBarHeight(this.mActivity);
      }
      else
      {
        i -= DisplayUtil.getStatusBarHeight(this.mActivity);
        j = m;
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
    if (this.mGameContainerView != null) {
      return this.mGameContainerView.getMeasuredHeight();
    }
    return 0;
  }
  
  private int getGameViewWidth()
  {
    if (this.mGameContainerView != null) {
      return this.mGameContainerView.getMeasuredWidth();
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
      this.mDebuggerView = ((ViewGroup)LayoutInflater.from(this.mActivity).inflate(R.layout.mini_sdk_game_debugger_layout, null));
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
  
  public ViewGroup getGameContainerView()
  {
    return this.mGameContainerView;
  }
  
  public MiniGamePackage getGamePackage()
  {
    return this.mGameInfo;
  }
  
  public SurfaceView getGameSurfaceView()
  {
    return this.mGameSurfaceView;
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
    this.mGameInfo = MiniGamePackageManager.createGamePackage(this.mMiniAppContext);
  }
  
  public void onDestroy()
  {
    this.mCustomButtonManager = null;
    if (this.mFloatDragAdManager != null)
    {
      this.mFloatDragAdManager.removeDragAd();
      this.mFloatDragAdManager = null;
    }
    if (this.mPendantManager != null)
    {
      this.mPendantManager.removePendantAd();
      this.mPendantManager = null;
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
    for (String str = this.mGameInfo.getId();; str = "")
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
  
  public boolean operatePendantAd(String paramString, PendantAdInfo paramPendantAdInfo)
  {
    if ("add".equals(paramString))
    {
      if (this.mPendantManager == null) {
        this.mPendantManager = new PendantManager(this.mActivity, this.mMiniAppContext, this.mRootView);
      }
      return this.mPendantManager.showPendantAd(paramPendantAdInfo);
    }
    if (("remove".equals(paramString)) && (this.mPendantManager != null)) {
      return this.mPendantManager.removePendantAd();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage
 * JD-Core Version:    0.7.0.1
 */