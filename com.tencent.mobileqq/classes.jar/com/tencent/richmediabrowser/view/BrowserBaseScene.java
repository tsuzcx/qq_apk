package com.tencent.richmediabrowser.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.richmediabrowser.animation.AbstractAnimationManager;
import com.tencent.richmediabrowser.animation.AnimationLister;
import com.tencent.richmediabrowser.animation.AnimationManager;
import com.tencent.richmediabrowser.animation.AnimationView;
import com.tencent.richmediabrowser.animation.IGalleryAnimationEvent;
import com.tencent.richmediabrowser.animation.ViscousFluidInterpolator;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.IBrowserModel;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.progress.AbstractProgressView;
import com.tencent.richmediabrowser.view.progress.GalleryProgressView;
import com.tencent.richmediabrowser.view.progress.ProgressViewHelper;
import com.tencent.richmediabrowser.view.recyclerview.BrowserAdapter;
import com.tencent.richmediabrowser.view.recyclerview.BrowserRecyclerView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScrollListener;

public class BrowserBaseScene
  implements AnimationLister, IGalleryAnimationEvent
{
  private static final String TAG = "GalleryBaseScene";
  private AbstractAnimationManager animationManager;
  protected View bgView;
  private boolean isEnter = false;
  public LinearLayoutManager linearLayoutManager;
  public PagerSnapHelper linearSnapHelper;
  public BrowserAdapter mAdapter;
  public Activity mContext;
  public RelativeLayout mRoot;
  public MainBrowserPresenter mainBrowserPresenter;
  protected AbstractProgressView progressView;
  protected ProgressViewHelper progressViewHelper;
  public BrowserRecyclerView recyclerView;
  protected View rootView;
  public BrowserScrollListener scrollListener;
  
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
    this.animationManager = createAnimationManager(this.mContext, this.mainBrowserPresenter.browserModel);
    this.scrollListener = new BrowserScrollListener();
    this.scrollListener.setMainBrowserPresenter(this.mainBrowserPresenter);
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
    paramActivity = new AnimationManager(paramActivity, paramIBrowserModel);
    paramActivity.setMainBrowserPresenter(this.mainBrowserPresenter);
    return paramActivity;
  }
  
  public AnimationView createAnimationView()
  {
    AnimationView localAnimationView = new AnimationView(this.mContext, null);
    localAnimationView.setId(2131362741);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  protected BrowserAdapter createGalleryAdapter(Activity paramActivity)
  {
    return new BrowserAdapter(paramActivity);
  }
  
  protected RelativeLayout createLayout()
  {
    return (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558825, null);
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
    if (this.recyclerView.getAnimation() != null) {
      this.recyclerView.clearAnimation();
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
    this.recyclerView.startAnimation(localAnimationSet);
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
  
  public int getPosition(View paramView)
  {
    if (paramView != null) {
      return this.linearLayoutManager.getPosition(paramView);
    }
    return -1;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.recyclerView;
  }
  
  public View getRootView()
  {
    return this.rootView;
  }
  
  public void hideProgress()
  {
    if (this.progressView != null) {
      this.progressView.hide();
    }
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
      this.rootView = this.mRoot.findViewById(2131377356);
      this.recyclerView = ((BrowserRecyclerView)this.mRoot.findViewById(2131376814));
      this.bgView = this.mRoot.findViewById(2131363419);
      this.progressView = createProgressBar();
      if (this.progressView != null) {
        this.progressView.init(this.mContext, this);
      }
      this.progressViewHelper = new ProgressViewHelper();
      this.mAdapter = createGalleryAdapter(this.mContext);
      this.mAdapter.setPresenter(this.mainBrowserPresenter);
      if (this.progressView != null)
      {
        this.progressViewHelper.setProgressView(this.progressView);
        this.progressView.show();
      }
      this.linearLayoutManager = new LinearLayoutManager(this.mContext, 0, false);
      this.recyclerView.setLayoutManager(this.linearLayoutManager);
      this.recyclerView.setAdapter(this.mAdapter);
      this.recyclerView.addOnScrollListener(this.scrollListener);
      this.linearSnapHelper = new PagerSnapHelper();
      this.linearSnapHelper.attachToRecyclerView(this.recyclerView);
      this.recyclerView.setMainBrowserPresenter(this.mainBrowserPresenter);
      this.recyclerView.setLinearLayoutManager(this.linearLayoutManager);
      this.recyclerView.setPageSnapHelper(this.linearSnapHelper);
      this.mRoot.setVisibility(0);
      return;
      paramViewGroup.addView(this.mRoot, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void onDestroy()
  {
    if (this.animationManager != null) {
      this.animationManager.onDestroy();
    }
  }
  
  public void onEnterAnimationEnd()
  {
    if ((this.recyclerView != null) && (this.recyclerView.getVisibility() != 0)) {
      this.recyclerView.setVisibility(0);
    }
    if (this.mRoot != null) {
      this.mRoot.setVisibility(0);
    }
  }
  
  public void onEnterAnimationStart()
  {
    if ((this.mainBrowserPresenter != null) && (getAnimationManager().isRectAnimation) && (this.recyclerView != null)) {
      this.recyclerView.setVisibility(4);
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
    if ((this.mainBrowserPresenter != null) && (getAnimationManager().isRectAnimation) && (this.recyclerView != null)) {
      this.recyclerView.setVisibility(4);
    }
    if ((this.progressView != null) && (this.progressView.isShow())) {
      this.progressView.hide();
    }
  }
  
  public void onItemSelected(int paramInt)
  {
    if ((!isAnimating()) && (this.progressView != null) && (!this.progressView.isShow())) {
      this.progressView.show();
    }
    BrowserLogHelper.getInstance().getGalleryLog().i("GalleryBaseScene", 2, "GalleryBaseView.onItemSelected(): position=" + paramInt);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onLoadFinish(int paramInt, boolean paramBoolean)
  {
    this.progressViewHelper.onLoadFinish(paramInt, paramBoolean);
  }
  
  public void onLoadStart(int paramInt1, int paramInt2)
  {
    this.progressViewHelper.onLoadStart(paramInt1, paramInt2);
  }
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.progressViewHelper.onLoadFinish(paramInt, paramBoolean);
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void onWindowFocusChanged()
  {
    enter();
    this.mRoot.setVisibility(0);
  }
  
  public void setGalleryBlack()
  {
    if (this.recyclerView != null) {
      this.recyclerView.setBackgroundColor(-16777216);
    }
  }
  
  protected void updateSystemUIVisablity()
  {
    this.mRoot.setSystemUiVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BrowserBaseScene
 * JD-Core Version:    0.7.0.1
 */