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
import android.view.ViewGroup.LayoutParams;
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
  private GamePackage.Orientation mCurOrientation;
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
  private IMiniAppContext mMiniAppContext;
  private MiniAppMonitorInfoView mMiniAppMonitorInfoView;
  private GameNavigationBar mNavigationBar;
  private View mPayForFriendView;
  private PendantManager mPendantManager;
  private ViewGroup mRootView;
  private GamePackage.Orientation mTargetOrientation;
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
    this.mGameContainerView = ((ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.mini_sdk_game_layout, paramViewGroup, false));
    this.mGameSurfaceView = ((SurfaceView)this.mGameContainerView.findViewById(R.id.mini_sdk_game_layout_surface_view));
    paramViewGroup.addView(this.mGameContainerView, 0);
    paramViewGroup = new StringBuilder();
    paramViewGroup.append(" createGameView width :");
    paramViewGroup.append(this.mGameWidth);
    paramViewGroup.append(" height:");
    paramViewGroup.append(this.mGameHeight);
    QMLog.i("GamePage", paramViewGroup.toString());
  }
  
  private void attachNavigationBar(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null)
    {
      QMLog.w("GamePage", "Failed to attach navigation bar, root view is null");
      return;
    }
    GameNavigationBar localGameNavigationBar = this.mNavigationBar;
    if ((localGameNavigationBar != null) && (localGameNavigationBar.getParent() != null)) {
      ((ViewGroup)this.mNavigationBar.getParent()).removeView(this.mNavigationBar);
    }
    paramViewGroup.addView(this.mNavigationBar);
  }
  
  private void attachVConsoleView(ViewGroup paramViewGroup)
  {
    if (this.mGameInfo == null)
    {
      QMLog.w("GamePage", "Failed to attach vConsole view, game info is null");
      return;
    }
    SharedPreferences localSharedPreferences = StorageUtil.getPreference();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mGameInfo.getId());
    localStringBuilder.append("_debug");
    if (localSharedPreferences.getBoolean(localStringBuilder.toString(), false))
    {
      this.vConsoleBtn = createVConsoleBtn();
      paramViewGroup.addView(this.vConsoleBtn);
      this.vConsoleBtn.bringToFront();
      this.vConsoleBtn.setVisibility(0);
    }
  }
  
  private void calcTargetWidthAndHeight()
  {
    QMLog.i("GamePage", "initGameUI start create game SurfaceView & inject preload js");
    int k;
    if (this.mGameInfo.getOrientation() == GamePackage.Orientation.LANDSCAPE) {
      k = 1;
    } else {
      k = 0;
    }
    int i = this.mActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.mActivity.getResources().getDisplayMetrics().heightPixels;
    int m;
    int n;
    if (Build.VERSION.SDK_INT >= 17)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      m = localDisplayMetrics.heightPixels;
      n = localDisplayMetrics.widthPixels;
      if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
      {
        i = n;
        j = m;
        if (Settings.Secure.getInt(this.mActivity.getContentResolver(), "display_notch_status", 0) != 1) {
          break label254;
        }
        i = n;
        j = m;
        if (k == 0) {
          break label254;
        }
        i = DisplayUtil.getStatusBarHeight(this.mActivity);
      }
      else
      {
        i = n;
        j = m;
        if (!Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
          break label254;
        }
        i = n;
        j = m;
        if (Settings.Global.getInt(this.mActivity.getContentResolver(), "force_black", 0) != 1) {
          break label254;
        }
        QMLog.i("GamePage", "xiaomi has notch");
        if (k == 0) {
          break label240;
        }
        i = DisplayUtil.getStatusBarHeight(this.mActivity);
      }
      i = n - i;
      j = m;
      break label254;
      label240:
      j = m - DisplayUtil.getStatusBarHeight(this.mActivity);
      i = n;
    }
    label254:
    if ((k == 0) || (i > j))
    {
      n = i;
      m = j;
      if (k == 0)
      {
        n = i;
        m = j;
        if (j > i) {}
      }
    }
    else
    {
      m = i;
      n = j;
    }
    this.mGameWidth = n;
    this.mGameHeight = m;
  }
  
  private void changeWindowInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (paramMiniAppInfo == null) {
      return;
    }
    if (this.mActivity == null) {
      return;
    }
    if (QUAUtil.isMicroApp()) {
      return;
    }
    if (paramMiniAppInfo.isInternalApp())
    {
      QMLog.i("GamePage", "skip changeWindowInfo for InternalApp.");
      return;
    }
    ThreadManager.executeOnComputationThreadPool(new GamePage.2(this, paramMiniAppInfo, this.mActivity));
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
    this.mUIHandler.postDelayed(new GamePage.3(this, localVConsoleDragView), 1500L);
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
    ViewGroup localViewGroup = this.mGameContainerView;
    if (localViewGroup != null) {
      return localViewGroup.getMeasuredHeight();
    }
    return 0;
  }
  
  private int getGameViewWidth()
  {
    ViewGroup localViewGroup = this.mGameContainerView;
    if (localViewGroup != null) {
      return localViewGroup.getMeasuredWidth();
    }
    return 0;
  }
  
  private String getMenuButtonBoundingClientRect(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    Object localObject1 = getCapsuleButton();
    if (localObject1 != null)
    {
      int i = (int)(((View)localObject1).getWidth() / DisplayUtil.getDensity(this.mActivity));
      int j = (int)(((View)localObject1).getHeight() / DisplayUtil.getDensity(this.mActivity));
      int k = (int)(((View)localObject1).getLeft() / DisplayUtil.getDensity(this.mActivity));
      int m = (int)(((View)localObject1).getTop() / DisplayUtil.getDensity(this.mActivity));
      int n = (int)(((View)localObject1).getRight() / DisplayUtil.getDensity(this.mActivity));
      int i1 = (int)(((View)localObject1).getBottom() / DisplayUtil.getDensity(this.mActivity));
      localObject1 = new Rect(267, 34, 347, 64);
      if (i != 0)
      {
        localObject1 = new Rect(k, m, n, i1);
      }
      else
      {
        i = 80;
        j = 30;
      }
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("width", i);
        ((JSONObject)localObject2).put("height", j);
        ((JSONObject)localObject2).put("top", ((Rect)localObject1).top);
        ((JSONObject)localObject2).put("right", ((Rect)localObject1).right);
        ((JSONObject)localObject2).put("bottom", ((Rect)localObject1).bottom);
        ((JSONObject)localObject2).put("left", ((Rect)localObject1).left);
        paramNativeViewRequestEvent.ok();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getMenuButtonBoundingClientRect : ");
        ((StringBuilder)localObject1).append(((JSONObject)localObject2).toString());
        QMLog.d("GamePage", ((StringBuilder)localObject1).toString());
        localObject1 = ((JSONObject)localObject2).toString();
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramNativeViewRequestEvent.event);
        ((StringBuilder)localObject2).append(" error.");
        QMLog.e("GamePage", ((StringBuilder)localObject2).toString(), localJSONException);
        return "";
      }
    }
    QMLog.e("GamePage", "EVENT_GET_MENU_BUTTON_RECT view is null.");
    paramNativeViewRequestEvent.fail();
    return getMenuButtonDefaultValue();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMenuButtonDefaultValue : ");
      localStringBuilder.append(((JSONObject)localObject).toString());
      QMLog.d("GamePage", localStringBuilder.toString());
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
      this.mDebuggerEndBtn.setOnClickListener(new GamePage.5(this));
      this.mDebuggerLayer = new View(this.mActivity);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.mDebuggerLayer.setBackgroundColor(this.mActivity.getResources().getColor(R.color.mini_sdk_color_hei_trans_8));
      this.mRootView.addView(this.mDebuggerLayer, localLayoutParams);
    }
  }
  
  private void initOrientation()
  {
    this.mCurOrientation = GamePackage.Orientation.PORTRAIT;
    this.mTargetOrientation = this.mGameInfo.getOrientation();
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
    MiniAppMonitorInfoView localMiniAppMonitorInfoView = this.mMiniAppMonitorInfoView;
    return (localMiniAppMonitorInfoView != null) && (localMiniAppMonitorInfoView.getVisibility() == 0);
  }
  
  private boolean isVConsoleViewShowing()
  {
    VConsoleView localVConsoleView = this.vConsoleView;
    return (localVConsoleView != null) && (localVConsoleView.getVisibility() == 0);
  }
  
  private void setStatusBar()
  {
    try
    {
      boolean bool = new JSONObject(this.mGameInfo.getGameConfig()).optBoolean("showStatusBar", false);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initGameUI game config showStatusBar=");
      localStringBuilder.append(bool);
      QMLog.i("GamePage", localStringBuilder.toString());
      if (!bool)
      {
        this.mActivity.getWindow().setFlags(1024, 1024);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("GamePage", "getStatusBar config error -->", localJSONException);
    }
  }
  
  public void adjustViewForOrientation()
  {
    Activity localActivity = this.mActivity;
    if (localActivity == null) {
      return;
    }
    localActivity.runOnUiThread(new GamePage.1(this));
  }
  
  public void checkPayForFriendLogic(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)) && (!TextUtils.isEmpty(paramMiniAppInfo.prepayId)))
    {
      Object localObject = this.mPayForFriendView;
      if ((localObject != null) && ((((View)localObject).getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.mPayForFriendView.getParent()).removeView(this.mPayForFriendView);
      }
      localObject = (PayProxy)ProxyManager.get(PayProxy.class);
      this.mPayForFriendView = ((PayProxy)localObject).getPayForFriendView(this.mActivity, paramMiniAppInfo.prepayId, paramMiniAppInfo.appId, paramMiniAppInfo.name, paramMiniAppInfo.iconUrl, paramMiniAppInfo.versionId, paramMiniAppInfo.verType);
      if (this.mPayForFriendView != null)
      {
        paramMiniAppInfo = new RelativeLayout.LayoutParams(-1, -1);
        this.mPayForFriendView.setLayoutParams(paramMiniAppInfo);
        this.mRootView.addView(this.mPayForFriendView);
        this.mPayForFriendView.setVisibility(0);
        this.mPayForFriendView.bringToFront();
        QMLog.d("PayForFriendView", "checkPayForFriendLogic show webview success");
        ActivityResultManager.g().addActivityResultListener(new GamePage.6(this, (PayProxy)localObject));
      }
      return;
    }
    QMLog.d("PayForFriendView", "checkPayForFriendLogic not payforfriend mode");
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
    GameNavigationBar localGameNavigationBar = this.mNavigationBar;
    if (localGameNavigationBar != null) {
      return localGameNavigationBar.getCapsuleButton();
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
    if (this.mCurOrientation == this.mTargetOrientation) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    AppPageInfo.Builder localBuilder = new AppPageInfo.Builder();
    int i;
    if (paramInt != 0) {
      i = getGameViewHeight();
    } else {
      i = getGameViewWidth();
    }
    localBuilder = localBuilder.setSurfaceViewHeight(i);
    if (paramInt != 0) {
      paramInt = getGameViewWidth();
    } else {
      paramInt = getGameViewHeight();
    }
    return localBuilder.setSurfaceViewWidth(paramInt).setWindowWidth(this.mGameWidth).setWindowHeight(this.mGameHeight).build();
  }
  
  public String getPageOrientation()
  {
    Object localObject = GetGameInfoManager.obtain(this.mMiniAppContext);
    if (localObject != null) {
      localObject = ((GameInfoManager)localObject).getMiniGamePkg();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localObject = ((MiniGamePkg)localObject).mGameConfigJson;
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return ((JSONObject)localObject).optString("deviceOrientation", null);
    }
    return "";
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
    return this.mTargetOrientation == GamePackage.Orientation.LANDSCAPE;
  }
  
  public void onAttachWindow(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramActivity;
    this.mRootView = paramViewGroup;
    initOrientation();
    setStatusBar();
    attachNavigationBar(paramViewGroup);
    attachGameSurfaceView(paramViewGroup);
    attachVConsoleView(paramViewGroup);
    calcTargetWidthAndHeight();
  }
  
  public void onCreate(MiniAppInfo paramMiniAppInfo)
  {
    this.mGameInfo = MiniGamePackageManager.createGamePackage(this.mMiniAppContext);
  }
  
  public void onDestroy()
  {
    this.mCustomButtonManager = null;
    Object localObject = this.mFloatDragAdManager;
    if (localObject != null)
    {
      ((FloatDragAdManager)localObject).removeDragAd();
      this.mFloatDragAdManager = null;
    }
    localObject = this.mPendantManager;
    if (localObject != null)
    {
      ((PendantManager)localObject).removePendantAd();
      this.mPendantManager = null;
    }
    localObject = this.mActivity;
    if ((localObject != null) && (!((Activity)localObject).isFinishing())) {
      this.mActivity.finish();
    }
  }
  
  public void onDetachWindow(Activity paramActivity)
  {
    paramActivity = this.mRootView;
    if (paramActivity != null) {
      paramActivity.removeAllViews();
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
    if (this.mCustomButtonManager == null)
    {
      Activity localActivity = this.mActivity;
      ViewGroup localViewGroup = this.mRootView;
      Object localObject = this.mGameInfo;
      if (localObject != null) {
        localObject = ((MiniGamePackage)localObject).getId();
      } else {
        localObject = "";
      }
      this.mCustomButtonManager = new CustomButtonManager(localActivity, localViewGroup, (String)localObject, DisplayUtil.getDensity(this.mActivity));
    }
    if ("create".equals(paramString)) {
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
    if ("remove".equals(paramString))
    {
      paramString = this.mFloatDragAdManager;
      if (paramString != null) {
        return paramString.removeDragAd();
      }
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
    if ("remove".equals(paramString))
    {
      paramString = this.mPendantManager;
      if (paramString != null) {
        return paramString.removePendantAd();
      }
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
    Object localObject = this.mActivity;
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      if (getCapsuleButton() == null) {
        return;
      }
      localObject = getCapsuleButton().getMoreView();
      ((KingCardProxy)ProxyManager.get(KingCardProxy.class)).showKingCardTips(this.mMiniAppContext, (ImageView)localObject);
    }
  }
  
  public boolean toggleDebugPanel()
  {
    Object localObject = this.mMiniAppContext;
    if (localObject != null) {
      localObject = ((IMiniAppContext)localObject).getMiniAppInfo();
    } else {
      localObject = null;
    }
    boolean bool = DebugUtil.getDebugEnabled((MiniAppInfo)localObject) ^ true;
    DebugUtil.setDebugEnabled((MiniAppInfo)localObject, bool);
    return bool;
  }
  
  public boolean toggleMonitorPanel()
  {
    if (this.mRootView != null)
    {
      Object localObject = this.mMiniAppMonitorInfoView;
      if (localObject == null)
      {
        this.mMiniAppMonitorInfoView = new MiniAppMonitorInfoView(this.mActivity, null, 1);
        localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).gravity = 53;
        this.mRootView.addView(this.mMiniAppMonitorInfoView, (ViewGroup.LayoutParams)localObject);
        this.mMiniAppMonitorInfoView.setVisibility(0);
        this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
      }
      else if (((MiniAppMonitorInfoView)localObject).getVisibility() == 0)
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
    return isMonitorViewShowing();
  }
  
  void updateDebuggerStatus(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mActivity.runOnUiThread(new GamePage.4(this, paramString1, paramString2, paramBoolean));
  }
  
  void updateMonitorFPSText(double paramDouble)
  {
    if (isMonitorViewShowing()) {
      this.mMiniAppMonitorInfoView.updateFPSText(this.mMiniAppContext, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage
 * JD-Core Version:    0.7.0.1
 */