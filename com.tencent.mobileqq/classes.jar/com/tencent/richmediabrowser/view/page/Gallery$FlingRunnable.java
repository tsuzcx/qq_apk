package com.tencent.richmediabrowser.view.page;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.richmediabrowser.animation.AnimateUtils;

class Gallery$FlingRunnable
  implements Runnable
{
  private float mDeltaRotation;
  private float mDeltaScale;
  private float mDurationReciprocal;
  private int mLastFlingX;
  private int mLastFlingY;
  private boolean mScaling;
  private OverScroller mScroller;
  private float mStartRotation;
  private float mStartScale;
  private long mStartTime;
  
  public Gallery$FlingRunnable(Gallery paramGallery)
  {
    this.mScroller = new OverScroller(paramGallery.getContext());
    this.mScroller.setFriction(0.04F);
  }
  
  private void endFling(boolean paramBoolean)
  {
    this.mScroller.forceFinished(true);
    this.mStartTime = -1L;
    if (this.this$0.mOnScollListener != null) {
      this.this$0.mOnScollListener.onScrollEnd(this.this$0.mSelectedPosition);
    }
    if (this.this$0.mScrollState == 2)
    {
      this.this$0.onSlotChanged(this.this$0.mSelectedPosition, this.this$0.getChildAt(0), this.this$0);
      Gallery.access$800(this.this$0);
    }
    this.this$0.mScrollState = -1;
  }
  
  private float getInterpolation(float paramFloat)
  {
    return AnimateUtils.viscousFluid(paramFloat);
  }
  
  private void startCommon()
  {
    this.this$0.removeCallbacks(this);
  }
  
  public int calcFlingDistance(int paramInt1, int paramInt2)
  {
    this.mScroller.fling(paramInt1, 0, paramInt2, 0, -2147483648, 2147483647, 0, 0);
    return this.mScroller.getFinalX();
  }
  
  public void run()
  {
    if (this.this$0.mSelectedChild == null) {
      return;
    }
    if (this.this$0.mItemCount == 0)
    {
      endFling(true);
      return;
    }
    Gallery.access$902(this.this$0, false);
    Object localObject = this.mScroller;
    boolean bool = ((OverScroller)localObject).computeScrollOffset();
    int i = ((OverScroller)localObject).getCurrX();
    int j = ((OverScroller)localObject).getCurrY();
    int k = this.mLastFlingX;
    int m = this.mLastFlingY;
    float f2;
    float f3;
    if (this.mStartTime >= 0L)
    {
      int n = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
      if (n >= Gallery.access$700(this.this$0)) {
        break label273;
      }
      f1 = getInterpolation(n * this.mDurationReciprocal);
      f2 = this.mStartScale + this.mDeltaScale * f1;
      f3 = this.mStartRotation;
    }
    for (float f1 = f1 * this.mDeltaRotation + f3;; f1 = this.mStartRotation + this.mDeltaRotation)
    {
      Gallery.access$1000(this.this$0, this.this$0.mSelectedChild, f2);
      Gallery.access$1100(this.this$0, this.this$0.mSelectedChild, f1);
      if (!this.mScaling) {
        this.mScaling = true;
      }
      this.this$0.trackMotionScroll(i - k, j - m, false);
      if ((!bool) || (Gallery.access$900(this.this$0))) {
        break label298;
      }
      this.mLastFlingX = i;
      this.mLastFlingY = j;
      this.this$0.post(this);
      if ((this.this$0.mScrollState != 1) || (!this.this$0.canUpdateRegionRect())) {
        break;
      }
      this.this$0.updateShowArea(true, 1);
      return;
      label273:
      f1 = this.mStartScale;
      f2 = this.mDeltaScale + f1;
    }
    label298:
    if (this.mScaling)
    {
      this.mScaling = false;
      if (this.this$0.canUpdateRegionRect())
      {
        f1 = 1.0F;
        if (this.this$0.mSelectedChild.getTag(2131296385) != null) {
          f1 = ((Float)this.this$0.mSelectedChild.getTag(2131296385)).floatValue();
        }
        f2 = this.this$0.getChildScale(this.this$0.mSelectedChild);
        localObject = this.this$0;
        if (f2 - f1 <= 1.E-005D) {
          break label404;
        }
        bool = true;
        Gallery.access$1200((Gallery)localObject, bool);
      }
    }
    for (;;)
    {
      endFling(false);
      return;
      label404:
      bool = false;
      break;
      if (this.this$0.mScrollState == 1)
      {
        this.this$0.mScrollDirection = 0;
        if (this.this$0.canUpdateRegionRect()) {
          Gallery.access$1200(this.this$0, true);
        }
      }
    }
  }
  
  public void startUsingDistance(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    do
    {
      return;
      startCommon();
      this.mLastFlingX = 0;
      this.mLastFlingY = 0;
      this.mScroller.startScroll(0, 0, paramInt1, paramInt2, Gallery.access$700(this.this$0));
      this.this$0.post(this);
    } while (this.this$0.mOnScollListener == null);
    this.this$0.mOnScollListener.onScrollStart(this.this$0.mSelectedPosition);
  }
  
  public void startUsingDistance(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramFloat1 == paramFloat2) && (paramFloat3 == paramFloat4)) {
      return;
    }
    startCommon();
    this.mLastFlingX = 0;
    this.mLastFlingY = 0;
    this.mScroller.startScroll(0, 0, paramInt1, paramInt2, Gallery.access$700(this.this$0));
    this.this$0.post(this);
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStartScale = paramFloat1;
    this.mDeltaScale = (paramFloat2 - paramFloat1);
    this.mDurationReciprocal = (1.0F / Gallery.access$700(this.this$0));
    this.mStartRotation = paramFloat3;
    this.mDeltaRotation = (paramFloat4 - paramFloat3);
  }
  
  public void startUsingVelocity(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    startCommon();
    this.mLastFlingX = 0;
    this.mLastFlingY = 0;
    if (AnimationUtils.currentAnimationTimeMillis() - this.this$0.lastMoveTime > 15L) {
      this.mScroller.fling(this.this$0.lastMoveTime + 15L, 0, 0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, Gallery.access$600(this.this$0), Gallery.access$600(this.this$0));
    }
    for (;;)
    {
      this.this$0.post(this);
      if (this.this$0.mOnScollListener == null) {
        break;
      }
      this.this$0.mOnScollListener.onScrollStart(this.this$0.mSelectedPosition);
      return;
      this.mScroller.fling(0, 0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, Gallery.access$600(this.this$0), Gallery.access$600(this.this$0));
    }
  }
  
  public void stop(boolean paramBoolean)
  {
    this.this$0.removeCallbacks(this);
    endFling(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.Gallery.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */