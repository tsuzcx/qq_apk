package com.tencent.qqmini.sdk.widget;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.color;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

public class NavigationBar
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final String STYLE_CUSTOM = "custom";
  public static final String STYLE_DEFAULT = "default";
  public static final String TEXT_STYLE_BLACK = "black";
  public static final String TEXT_STYLE_WHITE = "white";
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
  private NavigationBar.NavBarBackListener mClickBackListener;
  private RelativeLayout mContainer;
  private WebViewProgressBarController mController;
  private boolean mEnableBackIcon;
  private boolean mEnableLeftText;
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
      this.mBackIcon.setImageResource(R.drawable.mini_sdk_nav_bar_title_back_img_white);
    } else {
      this.mBackIcon.setImageResource(R.drawable.mini_sdk_nav_bar_title_back_img);
    }
    CapsuleButton localCapsuleButton = this.mCapsuleButton;
    if (localCapsuleButton != null) {
      localCapsuleButton.changeNavIcon(this.mBarTextStyle);
    }
  }
  
  public static int getDefaultNaviBarHeight(Context paramContext)
  {
    return DisplayUtil.dip2px(paramContext, 44.0F) + DisplayUtil.getStatusBarHeight(paramContext);
  }
  
  private void init()
  {
    if (getContext() != null)
    {
      this.mContainer = getContainerView();
      this.mContainer.setClipChildren(false);
      this.mCapsuleButton = new CapsuleButton(getContext());
      this.mCapsuleButton.setId(R.id.mini_sdk_nav_capsule_btn);
      Object localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 80.0F), DisplayUtil.dip2px(getContext(), 30.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(getContext(), 9.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(getContext(), 12.5F);
      this.mContainer.addView(this.mCapsuleButton, (ViewGroup.LayoutParams)localObject);
      this.mStatusBarMask = new View(getContext());
      this.mStatusBarMask.setBackgroundResource(R.color.mini_sdk_nav_mask);
      localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.getStatusBarHeight(getContext()));
      this.mStatusBarMask.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addView(this.mStatusBarMask);
      this.mStatusBarMask.setVisibility(8);
      addView(this.mContainer);
      this.mBackIconContainer = ((RelativeLayout)findViewById(R.id.mini_sdk_top_bar_title_back_container));
      this.mBackIcon = ((ImageView)findViewById(R.id.mini_sdk_top_bar_title_back));
      this.mTitleView = ((TextView)findViewById(R.id.mini_sdk_nav_title));
      this.mBackTextView = ((TextView)findViewById(R.id.mini_sdk_nav_back_text));
      this.mLoadingProgressBar = ((ProgressBar)findViewById(R.id.mini_sdk_nav_loading_view));
      this.mBackIcon.setOnClickListener(this);
      localObject = this.mBackIconContainer;
      if (localObject != null) {
        ((RelativeLayout)localObject).setOnClickListener(this);
      }
      this.mProgressBar = ((WebViewProgressBar)findViewById(R.id.mini_sdk_nav_loading));
      this.mLoadingMask = findViewById(R.id.mini_sdk_nav_loading_mask);
      this.mLoadingDrawable = getResources().getDrawable(R.drawable.mini_sdk_common_loading);
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
      }
      else
      {
        this.mBackTextView.setVisibility(8);
      }
      if (this.mEnableBackIcon)
      {
        this.mBackIcon.setVisibility(0);
        this.mBackIconContainer.setVisibility(0);
      }
      else
      {
        this.mBackIcon.setVisibility(4);
        this.mBackIconContainer.setVisibility(4);
      }
      changeNavIcon();
    }
  }
  
  private void updateBarStyle()
  {
    if ("custom".equals(this.mBarStyle))
    {
      localObject = this.mTitleView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(4);
      }
      localObject = this.mBackIcon;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
      localObject = this.mBackIconContainer;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(4);
      }
      localObject = this.mBackTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(4);
      }
      setNavBackgroundColor(0);
      return;
    }
    setVisibility(0);
    Object localObject = this.mTitleView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    if ((this.mEnableBackIcon) && ("default".equals(this.mBarStyle)))
    {
      localObject = this.mBackIcon;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = this.mBackIconContainer;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(0);
      }
    }
    localObject = this.barInfo;
    if (localObject != null)
    {
      setNavBackgroundColor(((NavigationBarInfo)localObject).backgoundColor);
      setTextStyle(this.barInfo.textStyle);
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
    localRelativeLayout.setPadding(0, DisplayUtil.getStatusBarHeight(getContext()), 0, 0);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject1).setId(R.id.mini_sdk_loading_nav_container);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 30.0F));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), 9.0F);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = DisplayUtil.dip2px(getContext(), 7.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject2).setId(R.id.mini_sdk_top_bar_title_back_container);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-2, -1));
    Object localObject3 = new ImageView(getContext());
    ((ImageView)localObject3).setId(R.id.mini_sdk_top_bar_title_back);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 12.0F), DisplayUtil.dip2px(getContext(), 21.5F));
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 16.0F);
    localLayoutParams.rightMargin = DisplayUtil.dip2px(getContext(), 8.0F);
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((RelativeLayout)localObject2).addView((View)localObject3, localLayoutParams);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setId(R.id.mini_sdk_nav_back_text);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(1, R.id.mini_sdk_top_bar_title_back_container);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((TextView)localObject2).setGravity(15);
    ((TextView)localObject2).setMaxEms(5);
    ((TextView)localObject2).setTextSize(1, 17.0F);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setId(R.id.mini_sdk_nav_title);
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
    ((ProgressBar)localObject2).setId(R.id.mini_sdk_nav_loading_view);
    localObject3 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 19.0F), DisplayUtil.dip2px(getContext(), 19.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, R.id.mini_sdk_nav_title);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = DisplayUtil.dip2px(getContext(), 2.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(R.id.mini_sdk_nav_loading_mask);
    localObject2 = new RelativeLayout.LayoutParams(-1, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.mini_sdk_loading_nav_container);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), 5.0F);
    ((View)localObject1).setBackgroundColor(0);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new WebViewProgressBar(getContext());
    ((WebViewProgressBar)localObject1).setId(R.id.mini_sdk_nav_loading);
    localObject2 = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 2.0F));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), -2.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.mini_sdk_loading_nav_container);
    ((WebViewProgressBar)localObject1).setBackgroundColor(getContext().getResources().getColor(R.color.mini_sdk_nav_colorPrimary));
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
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
  
  public void hideLoading()
  {
    ProgressBar localProgressBar = this.mLoadingProgressBar;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(4);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == R.id.mini_sdk_top_bar_title_back) || (paramView.getId() == R.id.mini_sdk_top_bar_title_back_container))
    {
      NavigationBar.NavBarBackListener localNavBarBackListener = this.mClickBackListener;
      if (localNavBarBackListener != null) {
        localNavBarBackListener.onClickBack(this);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public NavigationBar setBarStyle(String paramString)
  {
    this.mBarStyle = paramString;
    updateBarStyle();
    return this;
  }
  
  public NavigationBar setClickBackListener(NavigationBar.NavBarBackListener paramNavBarBackListener)
  {
    this.mClickBackListener = paramNavBarBackListener;
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
        return this;
      }
      this.mBackIcon.setVisibility(8);
      this.mBackIconContainer.setVisibility(8);
    }
    return this;
  }
  
  public NavigationBar setEnableLeftText(boolean paramBoolean, String paramString)
  {
    this.mEnableLeftText = paramBoolean;
    this.mBackText = paramString;
    paramString = this.mBackTextView;
    if (paramString != null)
    {
      if (paramBoolean)
      {
        paramString.setVisibility(0);
        this.mBackTextView.setText(this.mBackText);
        return this;
      }
      paramString.setVisibility(8);
    }
    return this;
  }
  
  public NavigationBar setLeftText(String paramString)
  {
    this.mBackText = paramString;
    paramString = this.mBackTextView;
    if (paramString != null) {
      paramString.setText(this.mBackText);
    }
    return this;
  }
  
  public NavigationBar setNavBackgroundColor(int paramInt)
  {
    this.mBackGroundColor = paramInt;
    if (this.mContainer != null)
    {
      if ("custom".equals(this.mBarStyle))
      {
        this.mContainer.setBackgroundColor(0);
        return this;
      }
      this.mContainer.setBackgroundColor(this.mBackGroundColor);
    }
    return this;
  }
  
  public NavigationBar setNavBackgroundColor(int paramInt, long paramLong, String paramString)
  {
    Object localObject = this.mContainer;
    if (localObject != null)
    {
      localObject = ObjectAnimator.ofInt(localObject, "backgroundColor", new int[] { this.mBackGroundColor, paramInt });
      ((ValueAnimator)localObject).setDuration(paramLong);
      ((ValueAnimator)localObject).setEvaluator(new ArgbEvaluator());
      if ("linear".equals(paramString)) {
        ((ValueAnimator)localObject).setInterpolator(new LinearInterpolator());
      } else if ("easeIn".equals(paramString))
      {
        if (Build.VERSION.SDK_INT >= 21) {
          ((ValueAnimator)localObject).setInterpolator(new PathInterpolator(0.42F, 0.0F, 1.0F, 1.0F));
        }
      }
      else if ("easeOut".equals(paramString))
      {
        if (Build.VERSION.SDK_INT >= 21) {
          ((ValueAnimator)localObject).setInterpolator(new PathInterpolator(0.0F, 0.0F, 0.58F, 1.0F));
        }
      }
      else if (("easeInOut".equals(paramString)) && (Build.VERSION.SDK_INT >= 21)) {
        ((ValueAnimator)localObject).setInterpolator(new PathInterpolator(0.42F, 0.0F, 0.58F, 1.0F));
      }
      ((ValueAnimator)localObject).start();
    }
    this.mBackGroundColor = paramInt;
    return this;
  }
  
  public NavigationBar setTextStyle(String paramString)
  {
    if ("black".equals(paramString)) {
      this.mBarTextStyle = -16777216;
    } else if ("white".equals(paramString)) {
      this.mBarTextStyle = -1;
    }
    paramString = this.mTitleView;
    if (paramString != null) {
      paramString.setTextColor(this.mBarTextStyle);
    }
    paramString = this.mBackTextView;
    if (paramString != null) {
      paramString.setTextColor(this.mBarTextStyle);
    }
    changeNavIcon();
    return this;
  }
  
  public NavigationBar setTitleText(String paramString)
  {
    this.mBarText = paramString;
    paramString = this.mTitleView;
    if (paramString != null) {
      paramString.setText(this.mBarText);
    }
    return this;
  }
  
  public void setUseCustomStatusBarStyle(boolean paramBoolean)
  {
    if (this.mStatusBarMask != null)
    {
      Object localObject = this.mContainer;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
        if (paramBoolean)
        {
          this.mStatusBarMask.setVisibility(8);
          this.mContainer.setPadding(0, DisplayUtil.getStatusBarHeight(getContext()), 0, 0);
          ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        }
        else
        {
          this.mStatusBarMask.setVisibility(0);
          this.mContainer.setPadding(0, 0, 0, 0);
          ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.getStatusBarHeight(getContext());
        }
        this.mContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public NavigationBar setWindowInfo(WindowInfo paramWindowInfo, Activity paramActivity)
  {
    if (paramWindowInfo != null)
    {
      this.barInfo = paramWindowInfo.navigationBarInfo;
      paramWindowInfo = this.barInfo;
      boolean bool2 = false;
      boolean bool1;
      if (paramWindowInfo != null)
      {
        setTitleText(paramWindowInfo.titleText);
        if (!TextUtils.isEmpty(this.barInfo.textStyle)) {
          setTextStyle(this.barInfo.textStyle);
        }
        this.mBackGroundColor = this.barInfo.backgoundColor;
        setNavBackgroundColor(this.barInfo.backgoundColor);
        hideLoading();
        if (!TextUtils.isEmpty(this.barInfo.style)) {
          setBarStyle(this.barInfo.style);
        }
        bool1 = "black".equals(this.barInfo.textStyle);
      }
      else
      {
        bool1 = false;
      }
      if (paramActivity != null) {
        bool2 = DisplayUtil.setStatusTextColor(bool1, paramActivity.getWindow());
      }
      setUseCustomStatusBarStyle(bool2);
    }
    return this;
  }
  
  public void showLoading()
  {
    ProgressBar localProgressBar = this.mLoadingProgressBar;
    if (localProgressBar != null) {
      localProgressBar.setVisibility(0);
    }
  }
  
  public void updateProgress(byte paramByte)
  {
    WebViewProgressBar localWebViewProgressBar;
    if (this.mController == null)
    {
      this.mController = new WebViewProgressBarController();
      localWebViewProgressBar = this.mProgressBar;
      if (localWebViewProgressBar != null)
      {
        localWebViewProgressBar.setController(this.mController);
        this.mController.setProgressBar(this.mProgressBar);
      }
    }
    if (paramByte == 0)
    {
      localWebViewProgressBar = this.mProgressBar;
      if (localWebViewProgressBar != null) {
        localWebViewProgressBar.setVisibility(0);
      }
    }
    if (paramByte == 2)
    {
      localWebViewProgressBar = this.mProgressBar;
      if (localWebViewProgressBar != null) {
        localWebViewProgressBar.setVisibility(8);
      }
    }
    this.mController.enterStatus(paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.NavigationBar
 * JD-Core Version:    0.7.0.1
 */