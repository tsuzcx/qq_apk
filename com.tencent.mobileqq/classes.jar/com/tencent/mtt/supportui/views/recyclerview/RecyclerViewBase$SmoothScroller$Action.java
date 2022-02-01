package com.tencent.mtt.supportui.views.recyclerview;

import android.view.animation.Interpolator;

public class RecyclerViewBase$SmoothScroller$Action
{
  public static final int UNDEFINED_DURATION = -2147483648;
  boolean changed = false;
  int consecutiveUpdates = 0;
  int mDuration;
  int mDx;
  int mDy;
  Interpolator mInterpolator;
  
  public RecyclerViewBase$SmoothScroller$Action(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, -2147483648, null);
  }
  
  public RecyclerViewBase$SmoothScroller$Action(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, null);
  }
  
  public RecyclerViewBase$SmoothScroller$Action(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    this.mDx = paramInt1;
    this.mDy = paramInt2;
    this.mDuration = paramInt3;
    this.mInterpolator = paramInterpolator;
  }
  
  public int getDuration()
  {
    return this.mDuration;
  }
  
  public int getDx()
  {
    return this.mDx;
  }
  
  public int getDy()
  {
    return this.mDy;
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  void runInNecessary(RecyclerViewBase paramRecyclerViewBase)
  {
    if (this.changed)
    {
      validate();
      if (this.mInterpolator == null)
      {
        if (this.mDuration == -2147483648) {
          paramRecyclerViewBase.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, false);
        } else {
          paramRecyclerViewBase.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, false);
        }
      }
      else {
        paramRecyclerViewBase.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator, false);
      }
      this.consecutiveUpdates += 1;
      int i = this.consecutiveUpdates;
      this.changed = false;
      return;
    }
    this.consecutiveUpdates = 0;
  }
  
  public void setDuration(int paramInt)
  {
    this.changed = true;
    this.mDuration = paramInt;
  }
  
  public void setDx(int paramInt)
  {
    this.changed = true;
    this.mDx = paramInt;
  }
  
  public void setDy(int paramInt)
  {
    this.changed = true;
    this.mDy = paramInt;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.changed = true;
    this.mInterpolator = paramInterpolator;
  }
  
  public void update(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    this.mDx = paramInt1;
    this.mDy = paramInt2;
    this.mDuration = paramInt3;
    this.mInterpolator = paramInterpolator;
    this.changed = true;
  }
  
  void validate()
  {
    if ((this.mInterpolator != null) && (this.mDuration < 1)) {
      throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
    }
    if (this.mDuration >= 1) {
      return;
    }
    throw new IllegalStateException("Scroll duration must be a positive number");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.SmoothScroller.Action
 * JD-Core Version:    0.7.0.1
 */