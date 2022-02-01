package com.tencent.richmediabrowser.animation;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.model.BrowserAnimation;
import com.tencent.richmediabrowser.model.IBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.util.ArrayList;
import java.util.Iterator;

public class AnimationManager
  extends AbstractAnimationManager
{
  public static final String KEY_THUMBNAL_BOUND = "KEY_THUMBNAL_BOUND";
  AnimationView animationView;
  View bgView;
  int densityDpi;
  Activity mContext;
  private MainBrowserPresenter mMainBrowserPresenter;
  IBrowserModel model;
  View recyclerView;
  View rootView;
  
  public AnimationManager(Activity paramActivity, IBrowserModel paramIBrowserModel)
  {
    this.mContext = paramActivity;
    this.model = paramIBrowserModel;
    this.densityDpi = paramActivity.getResources().getDisplayMetrics().densityDpi;
  }
  
  private Rect getAnimationEndDstRect()
  {
    if (this.mMainBrowserPresenter != null) {
      return this.mMainBrowserPresenter.getAnimationEndDstRect();
    }
    return null;
  }
  
  private Drawable makeAnimationRect(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, BrowserAnimation paramBrowserAnimation, boolean paramBoolean)
  {
    if (paramBrowserAnimation == null) {}
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = paramBrowserAnimation.getAnimationDrawable();
      paramRect1 = paramBrowserAnimation.getThumbRect();
    } while ((paramRect1 == null) || (localDrawable == null) || (!paramBrowserAnimation.needAnimation(paramBoolean)));
    int i = this.recyclerView.getWidth();
    int j = this.recyclerView.getHeight();
    int k = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    paramRect2.set(0, 0, k, m);
    paramRect3.set(paramRect1);
    paramRect2 = getAnimationEndDstRect();
    paramRect1 = paramRect2;
    if (paramRect2 == null) {
      paramRect1 = AnimationUtils.getAnimationEndDstRect(k, m, i, j);
    }
    paramRect4.set(paramRect1);
    return localDrawable;
  }
  
  public void init()
  {
    this.recyclerView = this.mContext.findViewById(2131376172);
    this.animationView = ((AnimationView)this.mContext.findViewById(2131362699));
    this.rootView = this.mContext.findViewById(2131376679);
    this.bgView = this.mContext.findViewById(2131363274);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.animationView != null) {
      this.animationView.onDestroy();
    }
  }
  
  public void onEnterAnimationEnd()
  {
    this.mIsAnimating = false;
    this.animationView.setVisibility(4);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).onEnterAnimationEnd();
    }
    this.listeners.clear();
  }
  
  public void onEnterAnimationStart()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).onEnterAnimationStart();
    }
  }
  
  public void onExitAnimationEnd()
  {
    this.mIsAnimating = false;
    this.animationView.setVisibility(4);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).onExitAnimationEnd();
    }
    this.listeners.clear();
  }
  
  public void onExitAnimationStart()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).onExitAnimationStart();
    }
  }
  
  public void setMainBrowserPresenter(MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.mMainBrowserPresenter = paramMainBrowserPresenter;
  }
  
  public boolean startEnterAnimation()
  {
    boolean bool = true;
    if (isAnimating()) {
      return true;
    }
    if (this.recyclerView == null) {
      init();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Object localObject = this.model.getSelectedItem();
    if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {
      return false;
    }
    localObject = RichMediaBrowserManager.getInstance().getBrowserAnimation(((RichMediaBrowserInfo)localObject).baseData);
    Rect localRect3 = ((BrowserAnimation)localObject).getStartSrcRect();
    Rect localRect4 = new Rect();
    Drawable localDrawable = makeAnimationRect(null, localRect4, localRect1, localRect2, (BrowserAnimation)localObject, true);
    this.mIsAnimating = true;
    if (localDrawable != null)
    {
      this.isRectAnimation = bool;
      if (this.isRectAnimation) {
        break label147;
      }
      this.animationView.setVisibility(4);
    }
    for (;;)
    {
      return this.isRectAnimation;
      bool = false;
      break;
      label147:
      this.animationView.setVisibility(0);
      this.animationView.setAnimationListener(this);
      this.animationView.isImgCenterCropMode = ((BrowserAnimation)localObject).isImgCenterCropMode;
      if (localRect3 == null) {
        this.animationView.startEnterAnimation(localDrawable, localRect1, localRect2, ((BrowserAnimation)localObject).getCutValue(), this.animationDuring);
      } else {
        this.animationView.startEnterAnimationFreeMode(localDrawable, localRect3, localRect4, localRect1, localRect2, this.animationDuring);
      }
    }
  }
  
  public boolean startExitAnimation()
  {
    if (isAnimating()) {
      return true;
    }
    if (this.recyclerView == null) {
      init();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Object localObject = this.model.getSelectedItem();
    if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {
      return false;
    }
    localObject = RichMediaBrowserManager.getInstance().getBrowserAnimation(((RichMediaBrowserInfo)localObject).baseData);
    if (localObject == null) {
      return false;
    }
    Rect localRect3 = ((BrowserAnimation)localObject).getStartSrcRect();
    Rect localRect4 = new Rect();
    Drawable localDrawable = makeAnimationRect(localRect3, localRect4, localRect1, localRect2, (BrowserAnimation)localObject, false);
    this.mIsAnimating = true;
    boolean bool;
    if (localDrawable != null)
    {
      bool = true;
      this.isRectAnimation = bool;
      if (this.isRectAnimation) {
        break label155;
      }
      this.animationView.setVisibility(4);
    }
    for (;;)
    {
      return this.isRectAnimation;
      bool = false;
      break;
      label155:
      this.animationView.setVisibility(0);
      this.animationView.setAnimationListener(this);
      this.animationView.isImgCenterCropMode = ((BrowserAnimation)localObject).isImgCenterCropMode;
      this.animationView.startBackAnimation(localDrawable, localRect1, localRect2, ((BrowserAnimation)localObject).getCutValue(), ((BrowserAnimation)localObject).getStartX(), ((BrowserAnimation)localObject).getStartY(), this.animationDuring);
      if (localRect3 == null) {
        this.animationView.startBackAnimation(localDrawable, localRect1, localRect2, ((BrowserAnimation)localObject).getCutValue(), ((BrowserAnimation)localObject).getStartX(), ((BrowserAnimation)localObject).getStartY(), this.animationDuring);
      } else {
        this.animationView.startBackAnimationFreeMode(localDrawable, localRect3, localRect4, localRect1, localRect2, this.animationDuring);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.animation.AnimationManager
 * JD-Core Version:    0.7.0.1
 */