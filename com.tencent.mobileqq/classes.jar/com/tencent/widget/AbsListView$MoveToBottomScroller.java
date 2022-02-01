package com.tencent.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.util.AnimateUtils;

class AbsListView$MoveToBottomScroller
  implements Runnable
{
  private static final int SCROLL_DURATION = 400;
  private static final int STATUS_ACCERLERING = 0;
  private static final int STATUS_DECERLERING = 1;
  private static final int STATUS_UNIFORM = 2;
  private static final int STATUS_VISCOUS_FLUID = 3;
  private int lastMotionY = 0;
  private float mAccerleration;
  private float mCurrVelocity;
  private int mDistance;
  private int mDuration;
  private float mMaxVeloctiy;
  private long mStartTime;
  private int mStatus;
  private int mTargetPosition;
  private boolean mUseViscousFluid = false;
  
  AbsListView$MoveToBottomScroller(AbsListView paramAbsListView) {}
  
  public void run()
  {
    AdapterView.traceBegin("AbsListView.MoveToBottomScroller.run");
    try
    {
      j = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
      i = this.mStatus;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              i = 0;
            }
            else
            {
              if (j > this.mDuration)
              {
                i = this.mDistance;
                j = this.lastMotionY;
                localAbsListView = this.this$0;
                i = -(i - j);
                localAbsListView.trackMotionScroll(i, i);
                AdapterView.traceEnd();
                return;
              }
              f1 = j;
              f1 = AnimateUtils.a(f1 / this.mDuration) * this.mDistance;
              break label604;
            }
          }
          else
          {
            f1 = this.mMaxVeloctiy * j - this.mMaxVeloctiy * 400.0F / 8.0F;
            break label604;
          }
        }
        else
        {
          if (j > this.mDuration)
          {
            i = this.mDistance;
            j = this.lastMotionY;
            localAbsListView = this.this$0;
            i = -(i - j);
            localAbsListView.trackMotionScroll(i, i);
            AdapterView.traceEnd();
            return;
          }
          this.mCurrVelocity -= this.mAccerleration * j;
          f1 = this.mDistance - this.mCurrVelocity * (this.mDuration - j) / 2.0F;
          break label604;
        }
      }
      else if (j > 100)
      {
        this.mCurrVelocity = this.mMaxVeloctiy;
        i = (int)(this.mMaxVeloctiy * j - this.mMaxVeloctiy * 400.0F / 8.0F);
        this.mAccerleration = 0.0F;
        this.mStatus = 2;
      }
      else
      {
        f1 = this.mAccerleration;
        float f2 = j;
        this.mCurrVelocity = (f1 * f2);
        f1 = this.mCurrVelocity * f2 / 2.0F;
      }
    }
    finally
    {
      for (;;)
      {
        int j;
        AbsListView localAbsListView;
        float f1;
        int k;
        int m;
        int n;
        AdapterView.traceEnd();
        for (;;)
        {
          throw localObject;
        }
        int i = (int)f1;
      }
    }
    k = this.lastMotionY;
    localAbsListView = this.this$0;
    i = -(i - k);
    if (!localAbsListView.trackMotionScroll(i, i))
    {
      i = this.this$0.getChildCount();
      k = this.this$0.mFirstPosition;
      if ((this.mStatus != 3) && (this.mStatus != 1) && (k + i - 1 >= this.mTargetPosition))
      {
        k = this.this$0.getBottom();
        m = this.this$0.getTop();
        n = this.this$0.mListPadding.bottom;
        this.mDistance = (this.this$0.getChildAt(i - 1).getBottom() - (k - m - n));
        if (this.mDistance == 0)
        {
          stop();
          AdapterView.traceEnd();
          return;
        }
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
        }
        else
        {
          this.mStatus = 3;
        }
      }
      if (Build.VERSION.SDK_INT >= 16) {
        this.this$0.postOnAnimation(this);
      } else {
        this.this$0.post(this);
      }
    }
    else
    {
      stop();
    }
    AdapterView.traceEnd();
  }
  
  void start()
  {
    int i = this.this$0.mFirstPosition;
    int j = this.this$0.getChildCount();
    boolean bool = true;
    i = this.this$0.mItemCount - (i + j - 1) - 1;
    if (i == 0)
    {
      i = this.this$0.getBottom();
      j = this.this$0.getTop();
      int k = this.this$0.mListPadding.bottom;
      AbsListView localAbsListView = this.this$0;
      this.mDistance = (localAbsListView.getChildAt(localAbsListView.getChildCount() - 1).getBottom() - (i - j - k));
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
    if (i != 1) {
      bool = false;
    }
    this.mUseViscousFluid = bool;
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.this$0.postOnAnimation(this);
      return;
    }
    this.this$0.post(this);
  }
  
  void stop()
  {
    this.this$0.removeCallbacks(this);
    this.this$0.mScrollToBottom = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsListView.MoveToBottomScroller
 * JD-Core Version:    0.7.0.1
 */