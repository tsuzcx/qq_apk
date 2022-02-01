package com.tencent.mobileqq.kandian.biz.viola.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.kandian.base.utils.FlymeOSStatusBarFontUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class ViolaLazyFragment
  extends QPublicBaseFragment
{
  public static final String LEFT_VIEW_BACK_DRAWABLE_BLACK = "drawable_black";
  public static final String LEFT_VIEW_BACK_DRAWABLE_WHITE = "drawable_white";
  public static final String STATUS_BAR_NORMAL_COLOR = "status_bar_color_style";
  private static final String TAG = "ViolaLazyFragment";
  protected long createViewStartTime = 0L;
  private boolean fullScreenAlways = false;
  protected long initEngineEndTime = 0L;
  protected long loadHippyStartTime = 0L;
  protected long loadLibEndTime = 0L;
  protected long loadLibStartTime = 0L;
  protected long loadModuleEndTime = 0L;
  protected long loadModuleStartTime = 0L;
  private ViewGroup mContainer;
  private ViewGroup mContentView;
  private boolean mIsContentInit = false;
  private boolean mIsStart = false;
  private boolean mIsStatusImmersive = false;
  private boolean mIsStatusViewTransparent = false;
  private LayoutInflater mLayoutInflater;
  private View.OnClickListener mOnBackListener = new ViolaLazyFragment.1(this);
  private int mOriginalTitleVisibility = 0;
  protected View mRootView;
  private String mStatusBarColor = "status_bar_color_style";
  private Boolean mStatusBarFontColorWhite = Boolean.valueOf(true);
  private SystemBarCompact mSystemBarComp;
  private TextView mTitleCenterView;
  private NavBarCommon mTitleContainer;
  private ImageView mTitleLeftBackIcon;
  private TextView mTitleLeftBackText;
  private TextView mTitleLeftView;
  private TextView mTitleLeftViewNotBack;
  private TextView mTitleRightHightView;
  private ImageView mTitleRightViewIcon;
  private TextView mTitleRightViewText;
  private RelativeLayout mTitleRootView;
  protected long openPageStartTime = 0L;
  private int originUIFlags = -1;
  
  public static void hideNavBar(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ViolaLazyFragment.2(paramActivity));
    int i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i | 0x2 | 0x400);
  }
  
  private void initTitleView(NavBarCommon paramNavBarCommon)
  {
    this.mTitleLeftView = ((TextView)paramNavBarCommon.findViewById(2131436180));
    this.mTitleLeftView.setOnClickListener(this.mOnBackListener);
    this.mTitleLeftBackText = ((TextView)paramNavBarCommon.findViewById(2131448219));
    this.mTitleLeftBackIcon = ((ImageView)paramNavBarCommon.findViewById(2131436666));
    TextView localTextView = this.mTitleLeftBackText;
    if ((localTextView != null) && (this.mTitleLeftBackIcon != null))
    {
      localTextView.setOnClickListener(this.mOnBackListener);
      this.mTitleLeftBackIcon.setOnClickListener(this.mOnBackListener);
    }
    this.mTitleCenterView = ((TextView)paramNavBarCommon.findViewById(2131436227));
    this.mTitleRightViewText = ((TextView)paramNavBarCommon.findViewById(2131436211));
    this.mTitleRightViewIcon = ((ImageView)paramNavBarCommon.findViewById(2131436194));
  }
  
  private void setStatusBarTrans()
  {
    if ((!this.mIsStatusViewTransparent) && (needImmersive()) && (needStatusTrans()) && (getQBaseActivity().findViewById(16908310) != null))
    {
      ViewParent localViewParent = getQBaseActivity().findViewById(16908310).getParent();
      if ((localViewParent != null) && ((localViewParent instanceof FrameLayout))) {
        ((FrameLayout)localViewParent).setVisibility(8);
      }
    }
  }
  
  public static void setWindowFlag(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      paramActivity.getWindow().setFlags(paramInt, paramInt);
    }
  }
  
  public abstract void doOnBackPressed();
  
  public void exitFullScreen()
  {
    getQBaseActivity().getWindow().getDecorView().setSystemUiVisibility(this.originUIFlags);
    this.originUIFlags = -1;
  }
  
  public ViewGroup getContentView()
  {
    return this.mContentView;
  }
  
  public abstract int getContentViewId();
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public String getStatusBarColor()
  {
    return this.mStatusBarColor;
  }
  
  public Boolean getStatusBarFontColorWhite()
  {
    return this.mStatusBarFontColorWhite;
  }
  
  public ViewGroup getTitleRootView()
  {
    return this.mTitleRootView;
  }
  
  public void hideLeftBackView()
  {
    this.mTitleLeftView.setVisibility(8);
  }
  
  public void hideStatusBar()
  {
    SystemBarCompact localSystemBarCompact = this.mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setStatusBarVisible(2, 0);
    }
  }
  
  public void hideStatusBarByParams()
  {
    if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInSplashActivity(getQBaseActivity())) && (getQBaseActivity().mSystemBarComp != null))
    {
      Window localWindow = getQBaseActivity().getWindow();
      if (localWindow != null) {
        localWindow.setFlags(1024, 1024);
      }
      this.mSystemBarComp = getQBaseActivity().mSystemBarComp;
      this.mSystemBarComp.init();
      hideStatusBar();
    }
  }
  
  public void hideTitleBar()
  {
    try
    {
      if (getRootView() != null)
      {
        this.mTitleContainer = ((NavBarCommon)getRootView().findViewById(2131444897));
        this.mOriginalTitleVisibility = this.mTitleContainer.getVisibility();
        if (this.mTitleContainer.getVisibility() == 0)
        {
          this.mTitleContainer.setVisibility(8);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaLazyFragment", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public abstract void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup);
  
  public abstract void initBeforeVisible(Bundle paramBundle);
  
  protected void initFragmentLazy(ViewGroup paramViewGroup)
  {
    setContentView(getContentViewId(), paramViewGroup);
    setTitleView();
    initAfterVisible(getArguments(), this.mContentView);
  }
  
  public void initStatusBarColor(String paramString)
  {
    if ((!this.mIsStatusImmersive) && (ImmersiveUtils.isSupporImmersive() == 1) && (!"status_bar_color_style".equals(paramString)) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInSplashActivity(getQBaseActivity())) && (getQBaseActivity().mSystemBarComp != null))
    {
      this.mSystemBarComp = getQBaseActivity().mSystemBarComp;
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusBarColor(Color.parseColor(paramString));
    }
  }
  
  public void initViewAfterVisible()
  {
    if ((!this.mIsContentInit) && (getRootView() != null))
    {
      this.mIsContentInit = true;
      initFragmentLazy(this.mContainer);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (Build.VERSION.SDK_INT >= 11) {
      setWindowFlag(getQBaseActivity(), 16777216);
    }
  }
  
  public boolean isTransparent()
  {
    return this.mIsStatusViewTransparent;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity = new StringBuilder();
    paramActivity.append("debugForTimeCost onAttach:");
    paramActivity.append(System.currentTimeMillis());
    QLog.d("ViolaLazyFragment", 2, paramActivity.toString());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("debugForTimeCost onCreate:");
    paramBundle.append(System.currentTimeMillis());
    QLog.d("ViolaLazyFragment", 2, paramBundle.toString());
  }
  
  protected void onCreateFragment(ViewGroup paramViewGroup)
  {
    if ((getUserVisibleHint()) && (!this.mIsContentInit))
    {
      this.mIsContentInit = true;
      initFragmentLazy(paramViewGroup);
      return;
    }
    setLazyEmptyLayout();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("debugForTimeCost onCreateView:");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    QLog.d("ViolaLazyFragment", 2, ((StringBuilder)localObject).toString());
    this.createViewStartTime = System.currentTimeMillis();
    this.mLayoutInflater = paramLayoutInflater;
    this.mContainer = paramViewGroup;
    if (Build.VERSION.SDK_INT >= 11) {
      setWindowFlag(getQBaseActivity(), 16777216);
    }
    onCreateFragment(paramViewGroup);
    View localView = this.mRootView;
    localObject = localView;
    if (localView == null) {
      localObject = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, (View)localObject);
    return localObject;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.mContentView = null;
    this.mLayoutInflater = null;
    if (this.mIsContentInit) {
      onDestroyViewLazy();
    }
    this.mIsContentInit = false;
  }
  
  protected void onDestroyViewLazy() {}
  
  protected void onFragmentStartLazy() {}
  
  protected void onFragmentStopLazy() {}
  
  public void onPause()
  {
    super.onPause();
    if (this.mIsContentInit) {
      onPauseLazy();
    }
  }
  
  protected void onPauseLazy() {}
  
  public void onResume()
  {
    super.onResume();
    initStatusBarColor(this.mStatusBarColor);
    if (getUserVisibleHint()) {
      FlymeOSStatusBarFontUtils.a(getQBaseActivity(), this.mStatusBarFontColorWhite.booleanValue() ^ true);
    }
    if (this.mIsContentInit) {
      onResumeLazy();
    }
  }
  
  protected void onResumeLazy()
  {
    FlymeOSStatusBarFontUtils.a(getQBaseActivity(), this.mStatusBarFontColorWhite.booleanValue() ^ true);
  }
  
  public void onStart()
  {
    super.onStart();
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("debugForTimeCost onStart:");
    localStringBuilder.append(System.currentTimeMillis());
    QLog.d("ViolaLazyFragment", 2, localStringBuilder.toString());
    if ((this.mIsContentInit) && (!this.mIsStart) && (getUserVisibleHint()))
    {
      this.mIsStart = true;
      onFragmentStartLazy();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.mIsContentInit) && (this.mIsStart) && (getUserVisibleHint()))
    {
      this.mIsStart = false;
      onFragmentStopLazy();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.fullScreenAlways) {
      setFullScreen();
    }
  }
  
  public void recoverStatusBar()
  {
    SystemBarCompact localSystemBarCompact = this.mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setStatusBarVisible(0, 0);
    }
  }
  
  public void setCenterTextColor(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mTitleCenterView.getVisibility() != 0) {
        this.mTitleCenterView.setVisibility(0);
      }
      this.mTitleCenterView.setTextColor(Color.parseColor(paramString));
    }
  }
  
  public void setContentFullScreen()
  {
    setWindowFlag(getQBaseActivity(), 1024);
    LiuHaiUtils.f(getQBaseActivity());
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(getQBaseActivity());
    }
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenu(getQBaseActivity());
  }
  
  public void setContentView(int paramInt, ViewGroup paramViewGroup)
  {
    if ((getRootView() == null) || (getRootView().getParent() == null)) {
      this.mRootView = this.mLayoutInflater.inflate(2131624581, paramViewGroup, false);
    }
    try
    {
      this.mTitleRootView = ((RelativeLayout)this.mRootView.findViewById(2131447595));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.mTitleRootView.setFitsSystemWindows(true);
        this.mTitleRootView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getQBaseActivity()), 0, 0);
      }
      paramViewGroup = (ViewGroup)this.mLayoutInflater.inflate(paramInt, (ViewGroup)this.mRootView, false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131444897);
      this.mTitleRootView.addView(paramViewGroup, localLayoutParams);
      this.mContentView = paramViewGroup;
      return;
    }
    catch (Exception paramViewGroup)
    {
      QLog.e("ViolaLazyFragment", 1, paramViewGroup.getMessage());
    }
  }
  
  public void setContentViewColor(String paramString)
  {
    this.mContentView.setBackgroundColor(Color.parseColor(paramString));
  }
  
  public void setFullScreen()
  {
    if (this.originUIFlags < 0) {
      this.originUIFlags = getQBaseActivity().getWindow().getDecorView().getSystemUiVisibility();
    }
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(getQBaseActivity());
  }
  
  public void setFullScreenAlways(boolean paramBoolean)
  {
    this.fullScreenAlways = paramBoolean;
    if (this.fullScreenAlways)
    {
      setFullScreen();
      return;
    }
    exitFullScreen();
  }
  
  protected void setLazyEmptyLayout()
  {
    this.mRootView = this.mLayoutInflater.inflate(2131624581, this.mContainer, false);
    initBeforeVisible(getArguments());
  }
  
  public void setLeftButtonText(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.mTitleLeftView.setVisibility(0);
    this.mTitleLeftView.setText(paramString);
    this.mTitleLeftView.setEnabled(true);
    if (paramOnClickListener != null) {
      this.mTitleLeftView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setLeftTextBackDrawable(String paramString)
  {
    if (getQBaseActivity() != null)
    {
      if ("drawable_black".equals(paramString))
      {
        this.mTitleLeftView.setVisibility(0);
        this.mTitleLeftView.setBackgroundDrawable(getQBaseActivity().getResources().getDrawable(2130851519));
        return;
      }
      if ("drawable_white".equals(paramString))
      {
        this.mTitleLeftView.setVisibility(0);
        this.mTitleLeftView.setBackgroundDrawable(getQBaseActivity().getResources().getDrawable(2130853297));
      }
    }
  }
  
  public void setLeftTextColor(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mTitleLeftView.getVisibility() != 0) {
        this.mTitleLeftView.setVisibility(0);
      }
      this.mTitleLeftView.setTextColor(Color.parseColor(paramString));
    }
  }
  
  public void setNoPadding()
  {
    this.mTitleRootView.setPadding(0, 0, 0, 0);
  }
  
  public void setReadInjoyTitleStyle()
  {
    if (!this.mIsStatusImmersive) {
      setStatusBarColor("#ffffff");
    }
    setTitleContainerBackgroundColor("#ffffff");
    setCenterTextColor("#000000");
    setLeftTextColor("#000000");
    setLeftTextBackDrawable("drawable_black");
    setRightTextColor("#000000");
  }
  
  public void setRightButtonText(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.mTitleRightViewText.setVisibility(0);
    this.mTitleRightViewText.setText(paramString);
    this.mTitleRightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.mTitleRightViewText.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setRightTextColor(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.mTitleRightViewText.getVisibility() != 0) && (!TextUtils.isEmpty(this.mTitleRightViewText.getText()))) {
        this.mTitleRightViewText.setVisibility(0);
      }
      this.mTitleRightViewText.setTextColor(Color.parseColor(paramString));
    }
  }
  
  public void setStatusBarColor(String paramString)
  {
    setStatusBarColor(paramString, false);
  }
  
  public void setStatusBarColor(String paramString, boolean paramBoolean)
  {
    if (("status_bar_color_style".equals(this.mStatusBarColor)) || (paramBoolean)) {
      this.mStatusBarColor = paramString;
    }
  }
  
  public void setStatusBarFontColor(Boolean paramBoolean)
  {
    this.mStatusBarFontColorWhite = paramBoolean;
  }
  
  public void setStatusBarFontColor(Boolean paramBoolean, boolean paramBoolean1)
  {
    if ((paramBoolean1) && (paramBoolean != this.mStatusBarFontColorWhite)) {
      FlymeOSStatusBarFontUtils.a(getQBaseActivity(), paramBoolean.booleanValue() ^ true);
    }
    this.mStatusBarFontColorWhite = paramBoolean;
  }
  
  public void setStatusBarImmersive()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.mIsStatusImmersive = true;
      this.mTitleRootView.setFitsSystemWindows(false);
      setNoPadding();
      if (getQBaseActivity().mSystemBarComp == null)
      {
        getQBaseActivity().setImmersiveStatus(0);
      }
      else
      {
        getQBaseActivity().mSystemBarComp.setStatusBarDrawable(null);
        getQBaseActivity().mSystemBarComp.setStatusBarColor(0);
        getQBaseActivity().mSystemBarComp.setStatusColor(0);
      }
      if (this.mTitleRootView.indexOfChild(this.mTitleContainer) != -1)
      {
        this.mTitleRootView.removeView(this.mTitleContainer);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTitleContainer.getLayoutParams();
        localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
        this.mTitleContainer.setLayoutParams(localLayoutParams);
        this.mTitleRootView.addView(this.mTitleContainer);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.mContentView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitleContainer.setTitle(paramCharSequence);
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    this.mTitleContainer.setTitle(paramCharSequence, paramString);
  }
  
  public void setTitleAlpha(float paramFloat)
  {
    this.mTitleContainer.setAlpha(paramFloat);
  }
  
  public void setTitleContainerBackgroundColor(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mTitleContainer.getVisibility() != 0) {
        this.mTitleContainer.setVisibility(0);
      }
      this.mTitleContainer.setBackgroundColor(Color.parseColor(paramString));
    }
  }
  
  public void setTitleContainerClick(View.OnClickListener paramOnClickListener)
  {
    NavBarCommon localNavBarCommon = this.mTitleContainer;
    if (localNavBarCommon != null) {
      localNavBarCommon.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTitleTransparent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTitleContainer.setBackgroundColor(0);
      return;
    }
    this.mTitleContainer.setBackgroundColor(-1);
  }
  
  public void setTitleView()
  {
    if (getQBaseActivity() == null) {
      return;
    }
    this.mTitleContainer = ((NavBarCommon)this.mTitleRootView.findViewById(2131444897));
    initTitleView(this.mTitleContainer);
  }
  
  public void setTransparent(boolean paramBoolean)
  {
    this.mIsStatusViewTransparent = paramBoolean;
    setStatusBarTrans();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((paramBoolean) && (!this.mIsContentInit)) {
      initViewAfterVisible();
    }
    if ((this.mIsContentInit) && (getRootView() != null))
    {
      if (paramBoolean)
      {
        this.mIsStart = true;
        onFragmentStartLazy();
        onResumeLazy();
        return;
      }
      this.mIsStart = false;
      onPauseLazy();
      onFragmentStopLazy();
    }
  }
  
  public void showLeftBackView()
  {
    this.mTitleLeftView.setVisibility(0);
  }
  
  public void showTitleBar()
  {
    try
    {
      this.mTitleContainer = ((NavBarCommon)this.mTitleRootView.findViewById(2131444897));
      if ((this.mTitleContainer.getVisibility() != 0) && (this.mOriginalTitleVisibility == 0))
      {
        this.mTitleContainer.setVisibility(0);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaLazyFragment", 2, localThrowable, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.view.ViolaLazyFragment
 * JD-Core Version:    0.7.0.1
 */