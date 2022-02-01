package com.tencent.richmediabrowser.animation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.model.BrowserAnimation;
import com.tencent.richmediabrowser.model.MainBrowserModel;
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
  private MainBrowserPresenter mMainBrowserPresenter;
  RelativeLayout mRoot;
  MainBrowserModel model;
  View recyclerView;
  View rootView;
  
  public AnimationManager(Context paramContext, MainBrowserModel paramMainBrowserModel, RelativeLayout paramRelativeLayout)
  {
    this.mRoot = paramRelativeLayout;
    this.model = paramMainBrowserModel;
    this.densityDpi = paramContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private Rect getAnimationEndDstRect()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mMainBrowserPresenter;
    if (localMainBrowserPresenter != null) {
      return localMainBrowserPresenter.getAnimationEndDstRect();
    }
    return null;
  }
  
  private Drawable makeAnimationRect(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, BrowserAnimation paramBrowserAnimation, boolean paramBoolean)
  {
    if (paramBrowserAnimation == null) {
      return null;
    }
    Drawable localDrawable = paramBrowserAnimation.getAnimationDrawable();
    paramRect1 = paramBrowserAnimation.getThumbRect();
    if ((paramRect1 != null) && (localDrawable != null))
    {
      if (!paramBrowserAnimation.needAnimation(paramBoolean)) {
        return null;
      }
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
    return null;
  }
  
  public void init()
  {
    this.recyclerView = this.mRoot.findViewById(2131376306);
    this.animationView = ((AnimationView)this.mRoot.findViewById(2131362696));
    this.rootView = this.mRoot.findViewById(2131376809);
    this.bgView = this.mRoot.findViewById(2131363349);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AnimationView localAnimationView = this.animationView;
    if (localAnimationView != null) {
      localAnimationView.onDestroy();
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
    boolean bool2 = isAnimating();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (this.recyclerView == null) {
      init();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Object localObject = this.model.getSelectedItem();
    if (localObject != null)
    {
      if (((RichMediaBrowserInfo)localObject).baseData == null) {
        return false;
      }
      localObject = this.mMainBrowserPresenter.getParamsBuilder().a(((RichMediaBrowserInfo)localObject).baseData);
      if (localObject == null) {
        return false;
      }
      Rect localRect3 = ((BrowserAnimation)localObject).getStartSrcRect();
      Rect localRect4 = new Rect();
      Drawable localDrawable = makeAnimationRect(null, localRect4, localRect1, localRect2, (BrowserAnimation)localObject, true);
      this.mIsAnimating = true;
      if (localDrawable == null) {
        bool1 = false;
      }
      this.isRectAnimation = bool1;
      if (!this.isRectAnimation)
      {
        this.animationView.setVisibility(4);
      }
      else
      {
        this.animationView.setVisibility(0);
        this.animationView.setAnimationListener(this);
        this.animationView.isImgCenterCropMode = ((BrowserAnimation)localObject).isImgCenterCropMode;
        if (localRect3 == null) {
          this.animationView.startEnterAnimation(localDrawable, localRect1, localRect2, ((BrowserAnimation)localObject).getCutValue(), this.animationDuring);
        } else {
          this.animationView.startEnterAnimationFreeMode(localDrawable, localRect3, localRect4, localRect1, localRect2, this.animationDuring);
        }
      }
      return this.isRectAnimation;
    }
    return false;
  }
  
  public boolean startExitAnimation()
  {
    boolean bool2 = isAnimating();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (this.recyclerView == null) {
      init();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Object localObject = this.model.getSelectedItem();
    if (localObject != null)
    {
      if (((RichMediaBrowserInfo)localObject).baseData == null) {
        return false;
      }
      localObject = this.mMainBrowserPresenter.getParamsBuilder().a(((RichMediaBrowserInfo)localObject).baseData);
      if (localObject == null) {
        return false;
      }
      Rect localRect3 = ((BrowserAnimation)localObject).getStartSrcRect();
      Rect localRect4 = new Rect();
      Drawable localDrawable = makeAnimationRect(localRect3, localRect4, localRect1, localRect2, (BrowserAnimation)localObject, false);
      this.mIsAnimating = true;
      if (localDrawable == null) {
        bool1 = false;
      }
      this.isRectAnimation = bool1;
      if (!this.isRectAnimation)
      {
        this.animationView.setVisibility(4);
      }
      else
      {
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
      return this.isRectAnimation;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.animation.AnimationManager
 * JD-Core Version:    0.7.0.1
 */