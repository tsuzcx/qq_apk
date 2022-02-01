package com.tencent.richmediabrowser.animation;

import java.util.ArrayList;

public abstract class AbstractAnimationManager
  implements AnimationLister
{
  public static final long DEFAULT_ANIMATION_DURING = 350L;
  protected long animationDuring = 350L;
  public boolean isRectAnimation = true;
  public boolean jumpToPhotoList;
  protected ArrayList<AnimationLister> listeners = new ArrayList();
  protected boolean mIsAnimating;
  
  public void addAnimationListener(AnimationLister paramAnimationLister)
  {
    if (!this.listeners.contains(paramAnimationLister)) {
      this.listeners.add(paramAnimationLister);
    }
  }
  
  public long getAnimationDuring()
  {
    return this.animationDuring;
  }
  
  public boolean isAnimating()
  {
    return this.mIsAnimating;
  }
  
  public boolean isRectAnimation()
  {
    return this.isRectAnimation;
  }
  
  public void onDestroy()
  {
    this.listeners.clear();
    this.mIsAnimating = false;
  }
  
  public void removeAnimationListener(AnimationLister paramAnimationLister)
  {
    if (this.listeners.contains(paramAnimationLister)) {
      this.listeners.remove(paramAnimationLister);
    }
  }
  
  public void resetAnimationDuring()
  {
    this.animationDuring = 350L;
  }
  
  public void setAnimationDuring(long paramLong)
  {
    this.animationDuring = paramLong;
  }
  
  public abstract boolean startEnterAnimation();
  
  public abstract boolean startExitAnimation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.animation.AbstractAnimationManager
 * JD-Core Version:    0.7.0.1
 */