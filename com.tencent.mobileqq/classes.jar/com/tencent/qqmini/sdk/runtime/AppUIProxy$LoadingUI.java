package com.tencent.qqmini.sdk.runtime;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.SquareImageView;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;

public class AppUIProxy$LoadingUI
  extends RelativeLayout
  implements View.OnClickListener
{
  int iconSize = DisplayUtil.dip2px(getContext(), 60.0F);
  private boolean isForeground = false;
  private View.OnClickListener mClickListener;
  private ImageView mCloseView;
  private LinearLayout mDeveloperInfoContainer;
  private TextView mDeveloperInfoDesc;
  private SquareImageView mLogoView;
  private ImageView mMoreView;
  private TextView mNameView;
  private ProgressBar mProgressBar;
  private ViewGroup mRootView;
  private View mStatusBar;
  private MiniAppInfo miniAppInfo;
  private RelativeLayout rightContainer;
  Handler uiHandler;
  
  public AppUIProxy$LoadingUI(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AppUIProxy$LoadingUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AppUIProxy$LoadingUI(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void cleanAnimation()
  {
    this.mRootView.setVisibility(0);
    this.mRootView.clearAnimation();
    this.mLogoView.clearAnimation();
    this.mNameView.clearAnimation();
    this.mProgressBar.clearAnimation();
  }
  
  private void init()
  {
    this.mRootView = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    this.mRootView.setBackgroundColor(-1);
    this.mRootView.setLayoutParams(localLayoutParams1);
    addView(this.mRootView);
    this.uiHandler = new Handler(Looper.getMainLooper());
    this.rightContainer = new RelativeLayout(getContext());
    localLayoutParams1 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 80.0F), DisplayUtil.dip2px(getContext(), 30.0F));
    localLayoutParams1.addRule(11, -1);
    localLayoutParams1.topMargin = (DisplayUtil.dip2px(getContext(), 9.0F) + ImmersiveUtils.getStatusBarHeight(getContext()));
    localLayoutParams1.rightMargin = DisplayUtil.dip2px(getContext(), 12.5F);
    this.rightContainer.setLayoutParams(localLayoutParams1);
    this.mMoreView = new ImageView(getContext());
    this.mMoreView.setId(R.id.btn_more_menu);
    Object localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 40.0F), -1);
    this.mMoreView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.mMoreView.setImageResource(R.drawable.mini_sdk_top_btns_more_bg);
    this.mMoreView.setOnClickListener(this);
    this.rightContainer.addView(this.mMoreView, (ViewGroup.LayoutParams)localObject);
    this.mCloseView = new ImageView(getContext());
    this.mCloseView.setId(R.id.btn_close);
    localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 40.0F), -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, R.id.btn_more_menu);
    this.mCloseView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.mCloseView.setImageResource(R.drawable.mini_sdk_top_btns_close_bg);
    this.mCloseView.setOnClickListener(this);
    this.rightContainer.addView(this.mCloseView, (ViewGroup.LayoutParams)localObject);
    localObject = new View(getContext());
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 0.5F), DisplayUtil.dip2px(getContext(), 18.0F));
    localLayoutParams2.addRule(13, -1);
    ((View)localObject).setBackgroundColor(436207616);
    ((View)localObject).setVisibility(0);
    this.rightContainer.addView((View)localObject, localLayoutParams2);
    this.mRootView.addView(this.rightContainer, localLayoutParams1);
    this.mLogoView = new SquareImageView(getContext());
    this.mLogoView.setId(R.id.logo_mask);
    localLayoutParams1 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 45.0F), DisplayUtil.dip2px(getContext(), 45.0F));
    localLayoutParams1.topMargin = DisplayUtil.dip2px(getContext(), 60.0F);
    localLayoutParams1.addRule(14, -1);
    this.mLogoView.setRoundRect(40);
    this.mLogoView.setLayerType(1, null);
    this.mRootView.addView(this.mLogoView, localLayoutParams1);
    this.mNameView = new TextView(getContext());
    this.mNameView.setId(R.id.game_name);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.topMargin = DisplayUtil.dip2px(getContext(), 10.0F);
    localLayoutParams1.addRule(14, -1);
    localLayoutParams1.addRule(3, R.id.logo_mask);
    this.mNameView.setTextColor(-1442840576);
    this.mNameView.setTextSize(16.0F);
    this.mNameView.setIncludeFontPadding(false);
    this.mRootView.addView(this.mNameView, localLayoutParams1);
    this.mProgressBar = new ProgressBar(getContext());
    localLayoutParams1 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 60.0F), DisplayUtil.dip2px(getContext(), 14.5F));
    localLayoutParams1.topMargin = DisplayUtil.dip2px(getContext(), 12.0F);
    localLayoutParams1.addRule(3, R.id.game_name);
    localLayoutParams1.addRule(14, -1);
    this.mProgressBar.setIndeterminate(true);
    this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.mini_sdk_loading_drawable));
    this.mRootView.addView(this.mProgressBar, localLayoutParams1);
    this.mDeveloperInfoContainer = new LinearLayout(getContext());
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(12);
    localLayoutParams1.addRule(14);
    localLayoutParams1.bottomMargin = DisplayUtil.dip2px(getContext(), 12.0F);
    this.mDeveloperInfoContainer.setOrientation(0);
    this.mDeveloperInfoContainer.setGravity(17);
    this.mDeveloperInfoContainer.setVisibility(8);
    this.mDeveloperInfoDesc = new TextView(getContext());
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.mDeveloperInfoDesc.setMaxWidth(DisplayUtil.dip2px(getContext(), 187.0F));
    this.mDeveloperInfoDesc.setGravity(1);
    this.mDeveloperInfoDesc.setTextSize(11.0F);
    this.mDeveloperInfoDesc.setMaxEms(99);
    this.mDeveloperInfoDesc.setTextColor(-5196865);
    ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(getContext(), 20.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(getContext(), 20.0F);
    this.mDeveloperInfoContainer.addView(this.mDeveloperInfoDesc, (ViewGroup.LayoutParams)localObject);
    this.mRootView.addView(this.mDeveloperInfoContainer, localLayoutParams1);
  }
  
  private boolean isCurrInterLoadingMode()
  {
    return (this.miniAppInfo != null) && (this.miniAppInfo.appMode != null) && (this.miniAppInfo.appMode.interLoading);
  }
  
  private boolean isInternalApp()
  {
    return (this.miniAppInfo != null) && (this.miniAppInfo.appMode != null) && (this.miniAppInfo.appMode.interMode);
  }
  
  private void setSlideInAnimation()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject1 = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject1).setDuration(500L);
    ((Animation)localObject1).setInterpolator(new LinearInterpolator());
    Object localObject2 = new TranslateAnimation(0.0F, 0.0F, 40.0F, 0.0F);
    ((Animation)localObject2).setDuration(300L);
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    this.mLogoView.setVisibility(0);
    this.mLogoView.setAnimation(localAnimationSet);
    localAnimationSet = new AnimationSet(true);
    localObject1 = new TranslateAnimation(0.0F, 0.0F, 40.0F, 0.0F);
    ((Animation)localObject1).setDuration(300L);
    localObject2 = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject2).setDuration(800L);
    ((Animation)localObject2).setInterpolator(new DecelerateInterpolator());
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    ((Animation)localObject1).setAnimationListener(new AppUIProxy.LoadingUI.2(this));
    this.uiHandler.postDelayed(new AppUIProxy.LoadingUI.3(this, localAnimationSet), 200L);
  }
  
  private void setSlideOutAnimation()
  {
    cleanAnimation();
    Object localObject1 = new AnimationSet(true);
    Object localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject2).setDuration(300L);
    ((Animation)localObject2).setInterpolator(new LinearInterpolator());
    Object localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -80.0F);
    ((Animation)localObject3).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
    ((AnimationSet)localObject1).setInterpolator(new LinearInterpolator());
    ((AnimationSet)localObject1).setFillAfter(true);
    this.mLogoView.setVisibility(0);
    this.mLogoView.setAnimation((Animation)localObject1);
    localObject1 = new AnimationSet(true);
    localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -60.0F);
    ((Animation)localObject2).setDuration(200L);
    localObject3 = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject3).setDuration(300L);
    ((Animation)localObject3).setInterpolator(new DecelerateInterpolator());
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
    ((AnimationSet)localObject1).setFillAfter(true);
    this.uiHandler.postDelayed(new AppUIProxy.LoadingUI.4(this, (AnimationSet)localObject1), 100L);
    this.mProgressBar.setVisibility(8);
    new AnimationSet(true);
    localObject1 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject1).setDuration(400L);
    ((AlphaAnimation)localObject1).setAnimationListener(new AppUIProxy.LoadingUI.5(this));
    this.mRootView.setAnimation((Animation)localObject1);
  }
  
  public int getStatusBarHeight()
  {
    int i = getResources().getIdentifier("status_bar_height", "dimen", "android");
    return getResources().getDimensionPixelSize(i);
  }
  
  public void initData(MiniAppInfo paramMiniAppInfo)
  {
    this.miniAppInfo = paramMiniAppInfo;
  }
  
  public boolean isForeground()
  {
    return this.isForeground;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.btn_close) {
      MiniReportManager.reportEventType(this.miniAppInfo, 1026, "1");
    }
    if (this.mClickListener != null) {
      this.mClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onResume()
  {
    this.isForeground = true;
    cleanAnimation();
    if ((isInternalApp()) || (isCurrInterLoadingMode()))
    {
      this.mLogoView.setVisibility(8);
      this.mNameView.setVisibility(4);
      this.mProgressBar.setVisibility(0);
      if ((this.miniAppInfo != null) && (this.miniAppInfo.appMode != null) && (this.miniAppInfo.appMode.closeTopRightCapsule)) {
        if (this.rightContainer != null) {
          this.rightContainer.setVisibility(4);
        }
      }
      while (this.rightContainer == null) {
        return;
      }
      this.rightContainer.setVisibility(0);
      return;
    }
    Object localObject2;
    Object localObject1;
    if (!TextUtils.isEmpty(this.miniAppInfo.iconUrl))
    {
      localObject2 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      localObject1 = getContext().getResources().getDrawable(R.drawable.mini_sdk_icon_loading_default);
      localObject2 = ((MiniAppProxy)localObject2).getDrawable(getContext(), this.miniAppInfo.iconUrl, this.iconSize, this.iconSize, (Drawable)localObject1);
      if (localObject2 != null) {
        break label257;
      }
    }
    for (;;)
    {
      this.mLogoView.setImageDrawable((Drawable)localObject1);
      if (this.rightContainer != null) {
        this.rightContainer.setVisibility(0);
      }
      this.mNameView.setText(this.miniAppInfo.name);
      this.mNameView.setVisibility(0);
      this.mProgressBar.setVisibility(0);
      this.mLogoView.setVisibility(0);
      this.uiHandler.postDelayed(new AppUIProxy.LoadingUI.1(this), 250L);
      return;
      label257:
      localObject1 = localObject2;
    }
  }
  
  public void onStop()
  {
    this.isForeground = false;
    if (isCurrInterLoadingMode())
    {
      this.mRootView.setVisibility(8);
      return;
    }
    setSlideOutAnimation();
  }
  
  public void setCustomClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.LoadingUI
 * JD-Core Version:    0.7.0.1
 */