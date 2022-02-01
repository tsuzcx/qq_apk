package com.tencent.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.richmediabrowser.model.MainBrowserModel;
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
  private RelativeLayout contentView;
  private boolean isEnter = false;
  public LinearLayoutManager linearLayoutManager;
  public PagerSnapHelper linearSnapHelper;
  public BrowserAdapter mAdapter;
  public Context mContext;
  public RelativeLayout mRoot;
  public MainBrowserPresenter mainBrowserPresenter;
  protected AbstractProgressView progressView;
  protected ProgressViewHelper progressViewHelper;
  public BrowserRecyclerView recyclerView;
  protected RelativeLayout rootView;
  public BrowserScrollListener scrollListener;
  
  public BrowserBaseScene(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public boolean back()
  {
    if (needExitRectAnimation())
    {
      getAnimationManager().addAnimationListener(this);
      doExitAnimation(getAnimationManager().startExitAnimation());
    }
    else
    {
      onExitAnimationEnd();
    }
    return false;
  }
  
  public void buildComplete() {}
  
  public void buildParams(Intent paramIntent)
  {
    this.scrollListener = new BrowserScrollListener();
    this.scrollListener.setMainBrowserPresenter(this.mainBrowserPresenter);
  }
  
  public void buildView()
  {
    onCreate();
    RelativeLayout localRelativeLayout = this.mRoot;
    if (localRelativeLayout != null) {
      localRelativeLayout.addView(createAnimationView());
    }
    this.animationManager = createAnimationManager(this.mContext, this.mainBrowserPresenter.browserModel);
  }
  
  public AbstractAnimationManager createAnimationManager(Context paramContext, MainBrowserModel paramMainBrowserModel)
  {
    paramContext = new AnimationManager(paramContext, paramMainBrowserModel, this.mRoot);
    paramContext.setMainBrowserPresenter(this.mainBrowserPresenter);
    return paramContext;
  }
  
  public AnimationView createAnimationView()
  {
    AnimationView localAnimationView = new AnimationView(this.mContext, null);
    localAnimationView.setId(2131362696);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  protected BrowserAdapter createGalleryAdapter(Context paramContext)
  {
    return new BrowserAdapter(paramContext);
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
  
  public RelativeLayout getContentView()
  {
    return this.contentView;
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
  
  public RelativeLayout getRootView()
  {
    return this.rootView;
  }
  
  public void hideProgress()
  {
    AbstractProgressView localAbstractProgressView = this.progressView;
    if (localAbstractProgressView != null) {
      localAbstractProgressView.hide();
    }
  }
  
  public boolean isAnimating()
  {
    return getAnimationManager().isAnimating();
  }
  
  public boolean needEnterRectAnimation()
  {
    return false;
  }
  
  public boolean needExitRectAnimation()
  {
    return false;
  }
  
  public void onCreate()
  {
    this.mRoot = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559324, null));
    Object localObject = this.mContext;
    if ((localObject instanceof Activity)) {
      ((Activity)localObject).addContentView(this.mRoot, new ViewGroup.LayoutParams(-1, -1));
    }
    this.rootView = ((RelativeLayout)this.mRoot.findViewById(2131376809));
    this.recyclerView = ((BrowserRecyclerView)this.mRoot.findViewById(2131376306));
    this.bgView = this.mRoot.findViewById(2131363349);
    this.contentView = ((RelativeLayout)this.rootView.findViewById(2131365169));
    this.progressView = createProgressBar();
    localObject = this.progressView;
    if (localObject != null) {
      ((AbstractProgressView)localObject).init(this.mContext, this);
    }
    this.progressViewHelper = new ProgressViewHelper();
    this.mAdapter = createGalleryAdapter(this.mContext);
    this.mAdapter.setPresenter(this.mainBrowserPresenter);
    localObject = this.progressView;
    if (localObject != null)
    {
      this.progressViewHelper.setProgressView((AbstractProgressView)localObject);
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
  }
  
  public void onDestroy()
  {
    AbstractAnimationManager localAbstractAnimationManager = this.animationManager;
    if (localAbstractAnimationManager != null) {
      localAbstractAnimationManager.onDestroy();
    }
  }
  
  public void onEnterAnimationEnd()
  {
    Object localObject = this.recyclerView;
    if ((localObject != null) && (((BrowserRecyclerView)localObject).getVisibility() != 0)) {
      this.recyclerView.setVisibility(0);
    }
    localObject = this.mRoot;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(0);
    }
  }
  
  public void onEnterAnimationStart()
  {
    if ((this.mainBrowserPresenter != null) && (getAnimationManager().isRectAnimation))
    {
      BrowserRecyclerView localBrowserRecyclerView = this.recyclerView;
      if (localBrowserRecyclerView != null) {
        localBrowserRecyclerView.setVisibility(4);
      }
    }
  }
  
  public void onExitAnimationEnd()
  {
    if (this.mContext != null)
    {
      Object localObject = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BrowserBaseScene.onExitAnimationEnd[");
      localStringBuilder.append(this.mContext.hashCode());
      localStringBuilder.append("]");
      ((IBrowserLog)localObject).i("RichMediaBrowserManager", 2, localStringBuilder.toString());
      localObject = this.mContext;
      if ((localObject instanceof Activity)) {
        ((Activity)localObject).finish();
      }
    }
  }
  
  public void onExitAnimationStart()
  {
    if ((this.mainBrowserPresenter != null) && (getAnimationManager().isRectAnimation))
    {
      localObject = this.recyclerView;
      if (localObject != null) {
        ((BrowserRecyclerView)localObject).setVisibility(4);
      }
    }
    Object localObject = this.progressView;
    if ((localObject != null) && (((AbstractProgressView)localObject).isShow())) {
      this.progressView.hide();
    }
  }
  
  public void onItemSelected(int paramInt)
  {
    if (!isAnimating())
    {
      localObject = this.progressView;
      if ((localObject != null) && (!((AbstractProgressView)localObject).isShow())) {
        this.progressView.show();
      }
    }
    Object localObject = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GalleryBaseView.onItemSelected(): position=");
    localStringBuilder.append(paramInt);
    ((IBrowserLog)localObject).i("GalleryBaseScene", 2, localStringBuilder.toString());
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
  
  public void onWindowFocusChanged()
  {
    enter();
    this.mRoot.setVisibility(0);
  }
  
  public void setGalleryBlack()
  {
    BrowserRecyclerView localBrowserRecyclerView = this.recyclerView;
    if (localBrowserRecyclerView != null) {
      localBrowserRecyclerView.setBackgroundColor(-16777216);
    }
  }
  
  public void showContentView(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.contentView;
    if (localRelativeLayout != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localRelativeLayout.setVisibility(i);
    }
  }
  
  protected void updateSystemUIVisablity()
  {
    this.mRoot.setSystemUiVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BrowserBaseScene
 * JD-Core Version:    0.7.0.1
 */