package com.tencent.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AnimationUtils;
import bkxo;

class AbsListView$MoveToBottomScroller
  implements Runnable
{
  private static final int SCROLL_DURATION = 400;
  private static final int STATUS_ACCERLERING = 0;
  private static final int STATUS_DECERLERING = 1;
  private static final int STATUS_UNIFORM = 2;
  private static final int STATUS_VISCOUS_FLUID = 3;
  private int lastMotionY;
  private float mAccerleration;
  private float mCurrVelocity;
  private int mDistance;
  private int mDuration;
  private float mMaxVeloctiy;
  private long mStartTime;
  private int mStatus;
  private int mTargetPosition;
  private boolean mUseViscousFluid;
  
  AbsListView$MoveToBottomScroller(AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i = 0;
    AdapterView.traceBegin("AbsListView.MoveToBottomScroller.run");
    for (;;)
    {
      int j;
      try
      {
        j = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
        switch (this.mStatus)
        {
        case 0: 
          i -= this.lastMotionY;
          if (this.this$0.trackMotionScroll(-i, -i)) {
            break label564;
          }
          i = this.this$0.getChildCount();
          int k = this.this$0.mFirstPosition;
          if ((this.mStatus == 3) || (this.mStatus == 1) || (k + i - 1 < this.mTargetPosition)) {
            break label524;
          }
          k = AbsListView.access$2800(this.this$0);
          int m = AbsListView.access$2900(this.this$0);
          int n = this.this$0.mListPadding.bottom;
          this.mDistance = (this.this$0.getChildAt(i - 1).getBottom() - (k - m - n));
          if (this.mDistance != 0) {
            break label426;
          }
          stop();
          return;
        }
      }
      finally
      {
        AdapterView.traceEnd();
      }
      if (j > 100)
      {
        this.mCurrVelocity = this.mMaxVeloctiy;
        i = (int)(this.mMaxVeloctiy * j - this.mMaxVeloctiy * 400.0F / 8.0F);
        this.mAccerleration = 0.0F;
        this.mStatus = 2;
      }
      else
      {
        this.mCurrVelocity = (this.mAccerleration * j);
        i = (int)(this.mCurrVelocity * j / 2.0F);
        continue;
        i = (int)(this.mMaxVeloctiy * j - this.mMaxVeloctiy * 400.0F / 8.0F);
        continue;
        if (j > this.mDuration)
        {
          i = this.mDistance - this.lastMotionY;
          this.this$0.trackMotionScroll(-i, -i);
          AdapterView.traceEnd();
          return;
        }
        this.mCurrVelocity -= this.mAccerleration * j;
        i = (int)(this.mDistance - this.mCurrVelocity * (this.mDuration - j) / 2.0F);
        continue;
        if (j > this.mDuration)
        {
          i = this.mDistance - this.lastMotionY;
          this.this$0.trackMotionScroll(-i, -i);
          AdapterView.traceEnd();
          return;
        }
        float f = j;
        i = (int)(bkxo.a(f / this.mDuration) * this.mDistance);
        continue;
        label426:
        this.mDuration = (400 - j);
        if (this.mDuration < 100) {
          this.mDuration = 100;
        }
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.lastMotionY = 0;
        if ((this.mCurrVelocity * 1000.0F > AbsListView.access$1500(this.this$0)) && (!this.mUseViscousFluid))
        {
          this.mStatus = 1;
          this.mCurrVelocity = (this.mDistance * 2.0F / this.mDuration);
          this.mAccerleration = (this.mCurrVelocity / this.mDuration);
          label524:
          if (Build.VERSION.SDK_INT < 16) {
            break label552;
          }
          this.this$0.postOnAnimation(this);
        }
        for (;;)
        {
          AdapterView.traceEnd();
          return;
          this.mStatus = 3;
          break;
          label552:
          this.this$0.post(this);
          continue;
          label564:
          stop();
        }
      }
    }
  }
  
  void start()
  {
    boolean bool = true;
    int i = this.this$0.mFirstPosition;
    int j = this.this$0.getChildCount();
    i = this.this$0.mItemCount - (i + j - 1) - 1;
    if (i == 0)
    {
      i = AbsListView.access$2600(this.this$0);
      j = AbsListView.access$2700(this.this$0);
      int k = this.this$0.mListPadding.bottom;
      this.mDistance = (this.this$0.getChildAt(this.this$0.getChildCount() - 1).getBottom() - (i - j - k));
      if (this.mDistance == 0)
      {
        stop();
        return;
      }
      this.mDuration = 400;
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.lastMotionY = 0;
      this.mStatus = 3;
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimation(this);
        return;
      }
      this.this$0.post(this);
      return;
    }
    this.mMaxVeloctiy = (this.this$0.getHeight() * i / this.this$0.getChildCount() / 300.0F);
    this.mAccerleration = (this.mMaxVeloctiy / 100.0F);
    this.mCurrVelocity = 0.0F;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStatus = 0;
    this.lastMotionY = 0;
    this.mTargetPosition = (this.this$0.mItemCount - 1);
    if (i == 1) {}
    for (;;)
    {
      this.mUseViscousFluid = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      this.this$0.postOnAnimation(this);
      return;
      bool = false;
    }
    this.this$0.post(this);
  }
  
  void stop()
  {
    this.this$0.removeCallbacks(this);
    this.this$0.mScrollToBottom = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.MoveToBottomScroller
 * JD-Core Version:    0.7.0.1
 */