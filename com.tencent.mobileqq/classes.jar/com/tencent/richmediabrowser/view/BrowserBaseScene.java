package com.tencent.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.richmediabrowser.animation.AbstractAnimationManager;
import com.tencent.richmediabrowser.animation.AnimationLister;
import com.tencent.richmediabrowser.animation.AnimationManager;
import com.tencent.richmediabrowser.animation.AnimationView;
import com.tencent.richmediabrowser.animation.IGalleryAnimationEvent;
import com.tencent.richmediabrowser.animation.ViscousFluidInterpolator;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.IBrowserModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.page.AbstractGalleryPageView;
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.AdapterView.OnItemClickListener;
import com.tencent.richmediabrowser.view.page.AdapterView.OnItemLongClickListener;
import com.tencent.richmediabrowser.view.page.AdapterView.OnItemSelectedListener;
import com.tencent.richmediabrowser.view.page.Gallery;
import com.tencent.richmediabrowser.view.page.Gallery.OnItemRotateListener;
import com.tencent.richmediabrowser.view.page.Gallery.OnScollListener;
import com.tencent.richmediabrowser.view.page.GalleryPageView;
import com.tencent.richmediabrowser.view.progress.AbstractProgressView;
import com.tencent.richmediabrowser.view.progress.GalleryProgressView;

public class BrowserBaseScene
  implements AnimationLister, IGalleryAnimationEvent, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener, Gallery.OnItemRotateListener, Gallery.OnScollListener
{
  private static final String TAG = "GalleryBaseScene";
  private AbstractAnimationManager animationManager;
  public BasePresenter basePresenter;
  protected View bgView;
  protected int bottomBarHeight;
  private boolean isEnter = false;
  protected BrowserBaseAdapter mAdapter;
  public Activity mContext;
  public Gallery mGallery;
  public RelativeLayout mRoot;
  protected AbstractProgressView progressView;
  protected ViewGroup rootView;
  
  public BrowserBaseScene(Activity paramActivity)
  {
    this.mContext = paramActivity;
  }
  
  public boolean back()
  {
    if (needExitRectAnimation())
    {
      getAnimationManager().addAnimationListener(this);
      doExitAnimation(getAnimationManager().startExitAnimation());
    }
    for (;;)
    {
      return false;
      onExitAnimationEnd();
    }
  }
  
  public void buildComplete() {}
  
  public void buildParams(Intent paramIntent)
  {
    this.animationManager = createAnimationManager(this.mContext, this.basePresenter.baseModel);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    onCreate(paramViewGroup);
    if (this.mRoot != null) {
      this.mRoot.addView(createAnimationView());
    }
  }
  
  public AbstractAnimationManager createAnimationManager(Activity paramActivity, IBrowserModel paramIBrowserModel)
  {
    return new AnimationManager(paramActivity, paramIBrowserModel);
  }
  
  public AnimationView createAnimationView()
  {
    AnimationView localAnimationView = new AnimationView(this.mContext, null);
    localAnimationView.setId(2131362576);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  protected BrowserBaseAdapter createGalleryAdapter(Context paramContext)
  {
    return new BrowserBaseAdapter();
  }
  
  protected AbstractGalleryPageView createGalleryPageView()
  {
    return new GalleryPageView();
  }
  
  protected RelativeLayout createLayout()
  {
    return (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558689, null);
  }
  
  protected AbstractProgressView createProgressBar()
  {
    return new GalleryProgressView();
  }
  
  public void doEnterAnimation(boolean paramBoolean)
  {
    if (this.bgView.getAnimation() != null) {
      this.bgView.clearAnimation();
    }
    if (this.mGallery.getAnimation() != null) {
      this.mGallery.clearAnimation();
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(getAnimationManager().getAnimationDuring());
    localAlphaAnimation.setFillAfter(true);
    if (paramBoolean)
    {
      this.bgView.startAnimation(localAlphaAnimation);
      return;
    }
    localAlphaAnimation.setAnimationListener(new BrowserBaseScene.1(this));
    getRootView().startAnimation(localAlphaAnimation);
  }
  
  public void doExitAnimation(boolean paramBoolean)
  {
    if (this.bgView.getAnimation() != null) {
      this.bgView.clearAnimation();
    }
    if (getRootView().getAnimation() != null) {
      getRootView().clearAnimation();
    }
    if (paramBoolean)
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setFillAfter(true);
      this.bgView.startAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(getAnimationManager().getAnimationDuring());
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new ViscousFluidInterpolator());
    localAlphaAnimation.setDuration(getAnimationManager().getAnimationDuring());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, this.rootView.getWidth() / 2, this.rootView.getHeight() / 2);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(getAnimationManager().getAnimationDuring());
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new BrowserBaseScene.2(this));
    this.bgView.startAnimation(localAlphaAnimation);
    this.mGallery.startAnimation(localAnimationSet);
  }
  
  public void enter()
  {
    if (this.isEnter) {
      return;
    }
    this.isEnter = true;
    if (needEnterRectAnimation())
    {
      getAnimationManager().addAnimationListener(this);
      doEnterAnimation(getAnimationManager().startEnterAnimation());
      return;
    }
    setGalleryBlack();
    onEnterAnimationEnd();
  }
  
  public AbstractAnimationManager getAnimationManager()
  {
    return this.animationManager;
  }
  
  public Gallery getGallery()
  {
    return this.mGallery;
  }
  
  public ViewGroup getRootView()
  {
    return this.rootView;
  }
  
  public boolean isAnimating()
  {
    return getAnimationManager().isAnimating();
  }
  
  public boolean needEnterRectAnimation()
  {
    return true;
  }
  
  public boolean needExitRectAnimation()
  {
    return true;
  }
  
  public boolean needShowPageView()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    this.mRoot = createLayout();
    if (paramViewGroup == null) {
      this.mContext.addContentView(this.mRoot, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.rootView = ((ViewGroup)this.mRoot.findViewById(2131375981));
      this.mGallery = ((Gallery)this.mContext.findViewById(2131367010));
      this.bgView = this.mContext.findViewById(2131363034);
      this.progressView = createProgressBar();
      if (this.progressView != null) {
        this.progressView.init(this.mContext, this);
      }
      this.mAdapter = createGalleryAdapter(this.mContext);
      this.mAdapter.setPresenter(this.basePresenter);
      if (this.progressView != null)
      {
        this.mAdapter.setProgressView(this.progressView);
        this.progressView.show();
      }
      this.mGallery.setAdapter(this.mAdapter);
      this.mGallery.setSpacing(this.mContext.getResources().getDimensionPixelSize(2131297026));
      this.mGallery.setOnItemSelectedListener(this);
      this.mGallery.setOnItemClickListener(this);
      this.mGallery.setOnItemLongClickListener(this);
      this.mGallery.setOnItemRotateListener(this);
      this.mGallery.setOnScollListener(this);
      this.mRoot.setVisibility(4);
      return;
      paramViewGroup.addView(this.mRoot, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void onDestroy()
  {
    if (this.mGallery != null) {
      this.mGallery.onDestroy();
    }
    if (this.animationManager != null) {
      this.animationManager.onDestroy();
    }
  }
  
  public void onEnterAnimationEnd()
  {
    if ((this.mGallery != null) && (this.mGallery.getVisibility() != 0)) {
      this.mGallery.setVisibility(0);
    }
    if (this.mRoot != null) {
      this.mRoot.setVisibility(0);
    }
  }
  
  public void onEnterAnimationStart()
  {
    if ((this.basePresenter != null) && (getAnimationManager().isRectAnimation) && (this.mGallery != null)) {
      this.mGallery.setVisibility(4);
    }
  }
  
  public void onExitAnimationEnd()
  {
    if (this.mContext != null) {
      this.mContext.finish();
    }
  }
  
  public void onExitAnimationStart()
  {
    if ((this.basePresenter != null) && (getAnimationManager().isRectAnimation) && (this.mGallery != null)) {
      this.mGallery.setVisibility(4);
    }
    if ((this.progressView != null) && (this.progressView.isShow())) {
      this.progressView.hide();
    }
    if (this.mGallery != null) {
      this.mGallery.reset();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if ((!isAnimating()) && (this.progressView != null) && (!this.progressView.isShow())) {
      this.progressView.show();
    }
    this.mAdapter.onLoadProgressUpdate(paramView, paramInt);
    BrowserLogHelper.getInstance().getGalleryLog().i("GalleryBaseScene", 2, "GalleryBaseView.onItemSelected(): position=" + paramInt);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onRotateFinished(View paramView, int paramInt1, int paramInt2) {}
  
  public void onScrollEnd(int paramInt)
  {
    if ((this.progressView != null) && (!this.progressView.isShow())) {
      this.progressView.show();
    }
    BrowserLogHelper.getInstance().getGalleryLog().i("GalleryBaseScene", 2, "onScrollEnd:" + paramInt);
  }
  
  public void onScrollStart(int paramInt)
  {
    if ((this.progressView != null) && (this.progressView.isShow())) {
      this.progressView.hide();
    }
    if ((this.progressView != null) && (this.progressView.isStarted())) {
      this.progressView.stop();
    }
    BrowserLogHelper.getInstance().getGalleryLog().i("GalleryBaseScene", 2, "onScrollStart:" + paramInt);
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    this.mRoot.setVisibility(4);
  }
  
  public void onWindowFocusChanged()
  {
    enter();
    this.mRoot.setVisibility(0);
  }
  
  public void reset()
  {
    if (this.mGallery != null) {
      this.mGallery.reset();
    }
  }
  
  public void setGalleryBlack()
  {
    if (this.mGallery != null) {
      this.mGallery.setBackgroundColor(-16777216);
    }
  }
  
  public void setPresenter(BasePresenter paramBasePresenter)
  {
    this.basePresenter = paramBasePresenter;
  }
  
  protected void updateSystemUIVisablity()
  {
    this.mRoot.setSystemUiVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BrowserBaseScene
 * JD-Core Version:    0.7.0.1
 */