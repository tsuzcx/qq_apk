package com.tencent.mobileqq.mini.ui;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.NavigationBarInfo;
import com.tencent.mobileqq.mini.apkg.WindowInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.widget.WebViewProgressBar;
import com.tencent.mobileqq.mini.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NavigationBar
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final String TAG = "NavigationBar";
  private AppBrandRuntime appBrandRuntime;
  private NavigationBarInfo barInfo;
  private int mBackGroundColor = -16777216;
  private ImageView mBackIcon;
  private RelativeLayout mBackIconContainer;
  private String mBackText;
  private TextView mBackTextView;
  private String mBarStyle;
  private String mBarText = "";
  private int mBarTextStyle = -1;
  private CapsuleButton mCapsuleButton;
  private RelativeLayout mContainer;
  private WebViewProgressBarController mController;
  private boolean mEnableBackIcon;
  private boolean mEnableLeftText;
  private NavigationBar.Listener mListener;
  private Drawable mLoadingDrawable;
  private View mLoadingMask;
  private ProgressBar mLoadingProgressBar;
  private WebViewProgressBar mProgressBar;
  private View mStatusBarMask;
  private TextView mTitleView;
  
  public NavigationBar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void changeNavIcon()
  {
    if (this.mBarTextStyle == -1) {
      this.mBackIcon.setImageResource(2130840807);
    }
    for (;;)
    {
      if (this.mCapsuleButton != null) {
        this.mCapsuleButton.changeNavIcon(this.mBarTextStyle);
      }
      return;
      this.mBackIcon.setImageResource(2130840806);
    }
  }
  
  private void init()
  {
    if (getContext() != null)
    {
      this.mContainer = getContainerView();
      this.mContainer.setClipChildren(false);
      this.mCapsuleButton = new CapsuleButton(getContext());
      this.mCapsuleButton.setId(2131299128);
      localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 80.0F), DisplayUtil.dip2px(getContext(), 30.0F));
      localLayoutParams.addRule(11, -1);
      localLayoutParams.topMargin = DisplayUtil.dip2px(getContext(), 9.0F);
      localLayoutParams.rightMargin = DisplayUtil.dip2px(getContext(), 12.5F);
      this.mContainer.addView(this.mCapsuleButton, localLayoutParams);
      this.mStatusBarMask = new View(getContext());
      this.mStatusBarMask.setBackgroundColor(-3684405);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(getContext()));
      this.mStatusBarMask.setLayoutParams(localLayoutParams);
      addView(this.mStatusBarMask);
      this.mStatusBarMask.setVisibility(8);
      addView(this.mContainer);
      this.mBackIconContainer = ((RelativeLayout)findViewById(2131297075));
      this.mBackIcon = ((ImageView)findViewById(2131297074));
      this.mTitleView = ((TextView)findViewById(2131297072));
      this.mBackTextView = ((TextView)findViewById(2131304999));
      this.mLoadingProgressBar = ((ProgressBar)findViewById(2131305002));
      this.mBackIcon.setOnClickListener(this);
      if (this.mBackIconContainer != null) {
        this.mBackIconContainer.setOnClickListener(this);
      }
      this.mProgressBar = ((WebViewProgressBar)findViewById(2131305000));
      this.mLoadingMask = findViewById(2131305001);
      this.mLoadingDrawable = getResources().getDrawable(2130839110);
    }
    while (!QLog.isColorLevel())
    {
      RelativeLayout.LayoutParams localLayoutParams;
      return;
    }
    QLog.d("NavigationBar", 2, "[init] context null");
  }
  
  private void updateBarStyle()
  {
    if (isCustomBarStyle())
    {
      if (this.mTitleView != null) {
        this.mTitleView.setVisibility(4);
      }
      if (this.mBackIcon != null) {
        this.mBackIcon.setVisibility(4);
      }
      if (this.mBackIconContainer != null) {
        this.mBackIconContainer.setVisibility(4);
      }
      if (this.mBackTextView != null) {
        this.mBackTextView.setVisibility(4);
      }
      setNavBackgroundColor(0);
    }
    do
    {
      return;
      setVisibility(0);
      if (this.mTitleView != null) {
        this.mTitleView.setVisibility(0);
      }
      if (this.mBackIcon != null) {
        this.mBackIcon.setVisibility(0);
      }
      if (this.mBackIconContainer != null) {
        this.mBackIconContainer.setVisibility(0);
      }
    } while (this.barInfo == null);
    setNavBackgroundColor(this.barInfo.backgoundColor);
    setTextStyle(this.barInfo.textStyle);
  }
  
  private void updateUI()
  {
    this.mTitleView.setText(this.mBarText);
    this.mTitleView.setTextColor(this.mBarTextStyle);
    this.mTitleView.setTextColor(-1);
    this.mTitleView.setSingleLine(true);
    this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
    this.mTitleView.setGravity(15);
    this.mTitleView.setMaxEms(8);
    this.mTitleView.setTextSize(1, 18.0F);
    this.mContainer.setBackgroundColor(this.mBackGroundColor);
    this.mLoadingMask.setBackgroundColor(this.mBackGroundColor);
    this.mLoadingProgressBar.setIndeterminateDrawable(this.mLoadingDrawable);
    this.mLoadingProgressBar.setIndeterminate(true);
    this.mLoadingProgressBar.setVisibility(8);
    this.mProgressBar.setVisibility(8);
    this.mLoadingMask.setVisibility(8);
    if (this.mEnableLeftText)
    {
      this.mBackTextView.setTextSize(1, 18.0F);
      this.mBackTextView.setTextColor(-16777216);
      this.mBackTextView.setVisibility(0);
      this.mBackTextView.setText(this.mBackText);
      if (!this.mEnableBackIcon) {
        break label245;
      }
      this.mBackIcon.setVisibility(0);
      this.mBackIconContainer.setVisibility(0);
    }
    for (;;)
    {
      if (this.mCapsuleButton != null) {
        this.mCapsuleButton.updateUI();
      }
      changeNavIcon();
      return;
      this.mBackTextView.setVisibility(8);
      break;
      label245:
      this.mBackIcon.setVisibility(4);
      this.mBackIconContainer.setVisibility(4);
    }
  }
  
  public CapsuleButton getCapsuleButton()
  {
    return this.mCapsuleButton;
  }
  
  public RelativeLayout getContainerView()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = new ViewGroup.LayoutParams(-1, -2);
    localRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject1).setId(2131303829);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 30.0F));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), 9.0F);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = DisplayUtil.dip2px(getContext(), 7.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject2).setId(2131297075);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-2, -1));
    Object localObject3 = new ImageView(getContext());
    ((ImageView)localObject3).setId(2131297074);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 12.0F), DisplayUtil.dip2px(getContext(), 21.5F));
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 16.0F);
    localLayoutParams.rightMargin = DisplayUtil.dip2px(getContext(), 8.0F);
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((RelativeLayout)localObject2).addView((View)localObject3, localLayoutParams);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setId(2131304999);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131297075);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((TextView)localObject2).setGravity(15);
    ((TextView)localObject2).setMaxEms(5);
    ((TextView)localObject2).setTextSize(1, 17.0F);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setId(2131297072);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine(true);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setMaxEms(8);
    ((TextView)localObject2).setTextSize(1, 17.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new ProgressBar(getContext());
    ((ProgressBar)localObject2).setId(2131305002);
    localObject3 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 19.0F), DisplayUtil.dip2px(getContext(), 19.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131297072);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = DisplayUtil.dip2px(getContext(), 2.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(2131305001);
    localObject2 = new RelativeLayout.LayoutParams(-1, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131303829);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), 5.0F);
    ((View)localObject1).setBackgroundColor(getContext().getResources().getColor(2131101491));
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new WebViewProgressBar(getContext());
    ((WebViewProgressBar)localObject1).setId(2131305000);
    localObject2 = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 2.0F));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), -2.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131303829);
    ((WebViewProgressBar)localObject1).setBackgroundColor(getContext().getResources().getColor(2131099812));
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public boolean getEnableDebug()
  {
    return StorageUtil.getPreference().getBoolean(this.appBrandRuntime.apkgInfo.appId + "_debug", false);
  }
  
  public String getNavbarStyle()
  {
    return this.mBarStyle;
  }
  
  public int getStatusNavigationBarTextStyle()
  {
    return this.mBarTextStyle;
  }
  
  public String getTitleText()
  {
    return this.mBackText;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void hideLoading()
  {
    if (this.mLoadingProgressBar != null) {
      this.mLoadingProgressBar.setVisibility(4);
    }
  }
  
  public void initAppBrandRuntime(AppBrandRuntime paramAppBrandRuntime)
  {
    this.appBrandRuntime = paramAppBrandRuntime;
    if (this.mCapsuleButton != null) {
      this.mCapsuleButton.attachAppBrandRuntime(paramAppBrandRuntime);
    }
    updateUI();
  }
  
  protected boolean isCustomBarStyle()
  {
    return "custom".equals(this.mBarStyle);
  }
  
  public void onClick(View paramView)
  {
    if (((paramView.getId() == 2131297074) || (paramView.getId() == 2131297075)) && (this.mListener != null)) {
      this.mListener.onClickBack(this);
    }
  }
  
  public NavigationBar setBarStyle(String paramString)
  {
    this.mBarStyle = paramString;
    updateBarStyle();
    return this;
  }
  
  public NavigationBar setEnableBackIcon(boolean paramBoolean)
  {
    this.mEnableBackIcon = paramBoolean;
    if (this.mBackIcon != null)
    {
      if ((paramBoolean) && ("default".equals(this.mBarStyle)))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTitleView.getLayoutParams();
        localLayoutParams.leftMargin = 0;
        this.mTitleView.setLayoutParams(localLayoutParams);
        this.mTitleView.requestLayout();
        this.mBackIcon.setVisibility(0);
        this.mBackIconContainer.setVisibility(0);
      }
    }
    else {
      return this;
    }
    this.mBackIcon.setVisibility(8);
    this.mBackIconContainer.setVisibility(8);
    return this;
  }
  
  public void setEnableDebug(boolean paramBoolean)
  {
    StorageUtil.getPreference().edit().putBoolean(this.appBrandRuntime.apkgInfo.appId + "_debug", paramBoolean).commit();
  }
  
  public NavigationBar setEnableLeftText(boolean paramBoolean, String paramString)
  {
    this.mEnableLeftText = paramBoolean;
    this.mBackText = paramString;
    if (this.mBackTextView != null)
    {
      if (paramBoolean)
      {
        this.mBackTextView.setVisibility(0);
        this.mBackTextView.setText(this.mBackText);
      }
    }
    else {
      return this;
    }
    this.mBackTextView.setVisibility(8);
    return this;
  }
  
  public NavigationBar setLeftText(String paramString)
  {
    this.mBackText = paramString;
    if (this.mBackTextView != null) {
      this.mBackTextView.setText(this.mBackText);
    }
    return this;
  }
  
  public NavigationBar setListener(NavigationBar.Listener paramListener)
  {
    this.mListener = paramListener;
    return this;
  }
  
  public NavigationBar setNavBackgroundColor(int paramInt)
  {
    this.mBackGroundColor = paramInt;
    if (this.mContainer != null)
    {
      if ("custom".equals(this.mBarStyle)) {
        this.mContainer.setBackgroundColor(0);
      }
    }
    else {
      return this;
    }
    this.mContainer.setBackgroundColor(this.mBackGroundColor);
    return this;
  }
  
  public NavigationBar setNavBackgroundColor(int paramInt, long paramLong, String paramString)
  {
    ObjectAnimator localObjectAnimator;
    if (this.mContainer != null)
    {
      localObjectAnimator = ObjectAnimator.ofInt(this.mContainer, "backgroundColor", new int[] { this.mBackGroundColor, paramInt });
      localObjectAnimator.setDuration(paramLong);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      if (!"linear".equals(paramString)) {
        break label87;
      }
      localObjectAnimator.setInterpolator(new LinearInterpolator());
    }
    for (;;)
    {
      localObjectAnimator.start();
      this.mBackGroundColor = paramInt;
      return this;
      label87:
      if ("easeIn".equals(paramString))
      {
        if (Build.VERSION.SDK_INT >= 21) {
          localObjectAnimator.setInterpolator(new PathInterpolator(0.42F, 0.0F, 1.0F, 1.0F));
        }
      }
      else if ("easeOut".equals(paramString))
      {
        if (Build.VERSION.SDK_INT >= 21) {
          localObjectAnimator.setInterpolator(new PathInterpolator(0.0F, 0.0F, 0.58F, 1.0F));
        }
      }
      else if (("easeInOut".equals(paramString)) && (Build.VERSION.SDK_INT >= 21)) {
        localObjectAnimator.setInterpolator(new PathInterpolator(0.42F, 0.0F, 0.58F, 1.0F));
      }
    }
  }
  
  public NavigationBar setTextStyle(String paramString)
  {
    com.tencent.mobileqq.mini.config.AppConst.CURRENT_NAV_BAR_STYLE_COLOR = paramString;
    if ("black".equals(paramString)) {
      this.mBarTextStyle = -16777216;
    }
    for (;;)
    {
      if (this.mTitleView != null) {
        this.mTitleView.setTextColor(this.mBarTextStyle);
      }
      if (this.mBackTextView != null) {
        this.mBackTextView.setTextColor(this.mBarTextStyle);
      }
      changeNavIcon();
      return this;
      if ("white".equals(paramString)) {
        this.mBarTextStyle = -1;
      }
    }
  }
  
  public NavigationBar setTitleText(String paramString)
  {
    this.mBarText = paramString;
    if (this.mTitleView != null) {
      this.mTitleView.setText(this.mBarText);
    }
    return this;
  }
  
  public void setUseCustomStatusBarStyle(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.mStatusBarMask != null) && (this.mContainer != null))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.mContainer.getLayoutParams();
      if (!paramBoolean) {
        break label69;
      }
      this.mStatusBarMask.setVisibility(8);
      this.mContainer.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
    }
    for (localLayoutParams.topMargin = 0;; localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext()))
    {
      this.mContainer.setLayoutParams(localLayoutParams);
      return;
      label69:
      this.mStatusBarMask.setVisibility(0);
      this.mContainer.setPadding(0, 0, 0, 0);
    }
  }
  
  public NavigationBar setWindowInfo(WindowInfo paramWindowInfo, Activity paramActivity)
  {
    boolean bool2 = false;
    if (paramWindowInfo != null)
    {
      this.barInfo = paramWindowInfo.navigationBarInfo;
      if (this.barInfo == null) {
        break label147;
      }
      setTitleText(this.barInfo.titleText);
      if (!TextUtils.isEmpty(this.barInfo.textStyle)) {
        setTextStyle(this.barInfo.textStyle);
      }
      this.mBackGroundColor = this.barInfo.backgoundColor;
      setNavBackgroundColor(this.barInfo.backgoundColor);
      hideLoading();
      if (!TextUtils.isEmpty(this.barInfo.style)) {
        setBarStyle(this.barInfo.style);
      }
    }
    label147:
    for (boolean bool1 = "black".equals(this.barInfo.textStyle);; bool1 = false)
    {
      if (paramActivity != null) {
        bool2 = ImmersiveUtils.a(bool1, paramActivity.getWindow());
      }
      setUseCustomStatusBarStyle(bool2);
      return this;
    }
  }
  
  public void showLoading()
  {
    if (this.mLoadingProgressBar != null) {
      this.mLoadingProgressBar.setVisibility(0);
    }
  }
  
  public void updateProgress(byte paramByte)
  {
    if (this.mController == null)
    {
      this.mController = new WebViewProgressBarController();
      if (this.mProgressBar != null)
      {
        this.mProgressBar.setController(this.mController);
        this.mController.setProgressBar(this.mProgressBar);
      }
    }
    if ((paramByte == 0) && (this.mProgressBar != null)) {
      this.mProgressBar.setVisibility(0);
    }
    if ((paramByte == 2) && (this.mProgressBar != null)) {
      this.mProgressBar.setVisibility(8);
    }
    this.mController.enterStatus(paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.NavigationBar
 * JD-Core Version:    0.7.0.1
 */