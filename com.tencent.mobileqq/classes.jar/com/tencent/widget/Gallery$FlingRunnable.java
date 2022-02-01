package com.tencent.widget;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.util.AnimateUtils;

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
      Gallery localGallery = this.this$0;
      localGallery.onSlotChanged(localGallery.mSelectedPosition, this.this$0.getChildAt(0), this.this$0);
      Gallery.access$800(this.this$0);
    }
    this.this$0.mScrollState = -1;
  }
  
  private float getInterpolation(float paramFloat)
  {
    return AnimateUtils.a(paramFloat);
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
    int i = this.this$0.mItemCount;
    boolean bool1 = true;
    if (i == 0)
    {
      endFling(true);
      return;
    }
    Gallery.access$902(this.this$0, false);
    Object localObject = this.mScroller;
    boolean bool2 = ((OverScroller)localObject).computeScrollOffset();
    i = ((OverScroller)localObject).getCurrX();
    int j = ((OverScroller)localObject).getCurrY();
    int k = this.mLastFlingX;
    int m = this.mLastFlingY;
    float f2;
    float f1;
    if (this.mStartTime >= 0L)
    {
      int n = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
      if (n < Gallery.access$700(this.this$0))
      {
        f2 = getInterpolation(n * this.mDurationReciprocal);
        f1 = this.mStartScale + this.mDeltaScale * f2;
        f2 = this.mStartRotation + f2 * this.mDeltaRotation;
      }
      else
      {
        f1 = this.mStartScale;
        f1 = this.mDeltaScale + f1;
        f2 = this.mStartRotation;
        f2 = this.mDeltaRotation + f2;
      }
      localObject = this.this$0;
      Gallery.access$1000((Gallery)localObject, ((Gallery)localObject).mSelectedChild, f1);
      localObject = this.this$0;
      Gallery.access$1100((Gallery)localObject, ((Gallery)localObject).mSelectedChild, f2);
      if (!this.mScaling) {
        this.mScaling = true;
      }
    }
    this.this$0.trackMotionScroll(i - k, j - m, false);
    if ((bool2) && (!Gallery.access$900(this.this$0)))
    {
      this.mLastFlingX = i;
      this.mLastFlingY = j;
      this.this$0.post(this);
      if ((this.this$0.mScrollState == 1) && (this.this$0.canUpdateRegionRect())) {
        this.this$0.updateShowArea(true, 1);
      }
    }
    else
    {
      if (this.mScaling)
      {
        this.mScaling = false;
        if (this.this$0.canUpdateRegionRect())
        {
          f1 = 1.0F;
          if (this.this$0.mSelectedChild.getTag(2131296385) != null) {
            f1 = ((Float)this.this$0.mSelectedChild.getTag(2131296385)).floatValue();
          }
          localObject = this.this$0;
          f2 = ((Gallery)localObject).getChildScale(((Gallery)localObject).mSelectedChild);
          localObject = this.this$0;
          if (f2 - f1 <= 1.E-005D) {
            bool1 = false;
          }
          Gallery.access$1200((Gallery)localObject, bool1);
        }
      }
      else if (this.this$0.mScrollState == 1)
      {
        localObject = this.this$0;
        ((Gallery)localObject).mScrollDirection = 0;
        if (((Gallery)localObject).canUpdateRegionRect()) {
          Gallery.access$1200(this.this$0, true);
        }
      }
      endFling(false);
    }
  }
  
  public void startUsingDistance(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    startCommon();
    this.mLastFlingX = 0;
    this.mLastFlingY = 0;
    this.mScroller.startScroll(0, 0, paramInt1, paramInt2, Gallery.access$700(this.this$0));
    this.this$0.post(this);
    if (this.this$0.mOnScollListener != null) {
      this.this$0.mOnScollListener.onScrollStart(this.this$0.mSelectedPosition);
    }
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
      this.mScroller.fling(15L + this.this$0.lastMoveTime, 0, 0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, Gallery.access$600(this.this$0), Gallery.access$600(this.this$0));
    } else {
      this.mScroller.fling(0, 0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, Gallery.access$600(this.this$0), Gallery.access$600(this.this$0));
    }
    this.this$0.post(this);
    if (this.this$0.mOnScollListener != null) {
      this.this$0.mOnScollListener.onScrollStart(this.this$0.mSelectedPosition);
    }
  }
  
  public void stop(boolean paramBoolean)
  {
    this.this$0.removeCallbacks(this);
    endFling(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.Gallery.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */