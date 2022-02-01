package com.tencent.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import blbm;
import bldq;

class AbsListView$FlingRunnable
  implements Runnable
{
  private static final int FLYWHEEL_TIMEOUT = 40;
  private final Runnable mCheckFlywheel = new AbsListView.FlingRunnable.1(this);
  private int mLastFlingY;
  private final bldq mScroller;
  
  AbsListView$FlingRunnable(AbsListView paramAbsListView)
  {
    this.mScroller = new bldq(paramAbsListView.getContext());
  }
  
  @TargetApi(9)
  void edgeReached(int paramInt)
  {
    int i = 0;
    if (this.this$0.mForHongBao) {
      i = this.this$0.getSpringbackOffset();
    }
    bldq localbldq = this.mScroller;
    int j;
    if (paramInt > 0)
    {
      j = this.this$0.mTopOverflingDistance;
      localbldq.a(paramInt, i, j);
      i = this.this$0.getOverScrollMode();
      if ((i != 0) && ((i != 1) || (AbsListView.access$1800(this.this$0)))) {
        break label165;
      }
      this.this$0.mTouchMode = 6;
      i = (int)this.mScroller.a();
      if (this.this$0.mEdgeGlowTop != null)
      {
        if (paramInt <= 0) {
          break label151;
        }
        this.this$0.mEdgeGlowTop.a(i);
      }
    }
    for (;;)
    {
      this.this$0.invalidate();
      if (Build.VERSION.SDK_INT < 16) {
        break label216;
      }
      this.this$0.postOnAnimation(this);
      return;
      j = this.this$0.mBottomOverflingDistance;
      break;
      label151:
      this.this$0.mEdgeGlowBottom.a(i);
      continue;
      label165:
      this.this$0.mTouchMode = -1;
      if (this.this$0.mPositionScroller != null) {
        this.this$0.mPositionScroller.stop();
      }
      if (AbsListView.access$1900(this.this$0) != null) {
        AbsListView.access$1900(this.this$0).stop();
      }
    }
    label216:
    this.this$0.post(this);
  }
  
  void endFling()
  {
    this.this$0.mTouchMode = -1;
    this.this$0.removeCallbacks(this);
    this.this$0.removeCallbacks(this.mCheckFlywheel);
    this.this$0.reportScrollStateChange(0);
    AbsListView.access$2000(this.this$0);
    this.mScroller.a();
    if (AbsListView.access$1600(this.this$0) != null) {
      AbsListView.access$1602(this.this$0, AbsListView.access$2100(this.this$0, AbsListView.access$1600(this.this$0)));
    }
  }
  
  void flywheelTouch()
  {
    this.this$0.postDelayed(this.mCheckFlywheel, 40L);
  }
  
  @TargetApi(9)
  public void run()
  {
    int k = 1;
    int i;
    int j;
    switch (this.this$0.mTouchMode)
    {
    case 5: 
    default: 
      endFling();
    case 3: 
      do
      {
        return;
      } while (this.mScroller.a());
    case 4: 
      AdapterView.traceBegin("AbsListView.FlingRunable.onfling");
      for (;;)
      {
        try
        {
          if (this.this$0.mDataChanged) {
            this.this$0.layoutChildren();
          }
          if ((this.this$0.mItemCount == 0) || (this.this$0.getChildCount() == 0))
          {
            endFling();
            return;
          }
          Object localObject1 = this.mScroller;
          boolean bool = ((bldq)localObject1).b();
          int m = ((bldq)localObject1).b();
          i = this.mLastFlingY - m;
          if (i > 0)
          {
            this.this$0.mMotionPosition = this.this$0.mFirstPosition;
            localObject1 = this.this$0.getChildAt(0);
            this.this$0.mMotionViewOriginalTop = ((View)localObject1).getTop();
            i = Math.min(this.this$0.getHeight() - AbsListView.access$2200(this.this$0) - AbsListView.access$2300(this.this$0) - 1, i);
            localObject1 = this.this$0.getChildAt(this.this$0.mMotionPosition - this.this$0.mFirstPosition);
            if (localObject1 == null) {
              break;
            }
            j = ((View)localObject1).getTop();
            if ((!this.this$0.trackMotionScroll(i, i)) || (i == 0)) {
              break label652;
            }
            label254:
            if (k != 0) {
              if (localObject1 != null)
              {
                j = -(i - (((View)localObject1).getTop() - j));
                if ((!this.this$0.mForHongBao) || (j <= 0))
                {
                  i = j;
                  if (bool)
                  {
                    edgeReached(j);
                    i = this.mScroller.b();
                  }
                  this.this$0.overScrollBy(0, i, 0, this.this$0.getScrollY(), 0, 0, 0, this.this$0.mOverscrollDistance, false);
                }
              }
            }
          }
          else
          {
            j = this.this$0.getChildCount() - 1;
            this.this$0.mMotionPosition = (this.this$0.mFirstPosition + j);
            localObject1 = this.this$0.getChildAt(j);
            this.this$0.mMotionViewOriginalTop = ((View)localObject1).getTop();
            i = Math.max(-(this.this$0.getHeight() - AbsListView.access$2400(this.this$0) - AbsListView.access$2500(this.this$0) - 1), i);
            continue;
          }
          if ((bool) && (k == 0))
          {
            this.this$0.invalidate();
            this.mLastFlingY = m;
            if (Build.VERSION.SDK_INT >= 16)
            {
              this.this$0.postOnAnimation(this);
              return;
            }
            this.this$0.post(this);
            continue;
          }
          endFling();
        }
        finally
        {
          AdapterView.traceEnd();
        }
      }
    }
    label642:
    label652:
    label657:
    for (;;)
    {
      bldq localbldq;
      label560:
      try
      {
        localbldq = this.mScroller;
        if (!localbldq.b()) {
          break label642;
        }
        j = this.this$0.getScrollY();
        k = localbldq.b();
        if (!this.this$0.overScrollBy(0, k - j, 0, j, 0, 0, 0, this.this$0.mOverscrollDistance, false)) {
          break label608;
        }
        if ((j > 0) || (k <= 0)) {
          break label592;
        }
        i = 1;
        break label657;
      }
      finally {}
      k = (int)localbldq.a();
      i = k;
      if (j != 0) {
        i = -k;
      }
      localbldq.a();
      start(i);
      return;
      label592:
      i = 0;
      break label657;
      label597:
      j = 0;
      label608:
      do
      {
        startSpringback(0);
        return;
        this.this$0.invalidate();
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.this$0.postOnAnimation(this);
          return;
        }
        this.this$0.post(this);
        return;
        endFling();
        return;
        j = 0;
        break;
        k = 0;
        break label254;
        if ((j < 0) || (k >= 0)) {
          break label597;
        }
        j = 1;
        if (i != 0) {
          break label560;
        }
      } while (j == 0);
    }
  }
  
  void start(int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      i = 2147483647;
      this.mLastFlingY = i;
      this.mScroller.a(0, i, 0, paramInt, 0, 2147483647, 0, 2147483647);
      this.this$0.mTouchMode = 4;
      if (Build.VERSION.SDK_INT < 16) {
        break label90;
      }
      this.this$0.postOnAnimation(this);
    }
    for (;;)
    {
      if (AbsListView.access$1600(this.this$0) == null) {
        AbsListView.access$1602(this.this$0, AbsListView.access$1700(this.this$0, "AbsListView-fling"));
      }
      return;
      i = 0;
      break;
      label90:
      this.this$0.post(this);
    }
  }
  
  void startOverfling(int paramInt)
  {
    this.mScroller.a(0, this.this$0.getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, this.this$0.getHeight());
    this.this$0.mTouchMode = 6;
    this.this$0.invalidate();
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.this$0.postOnAnimation(this);
      return;
    }
    this.this$0.post(this);
  }
  
  void startScroll(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 2147483647;; i = 0)
    {
      this.mLastFlingY = i;
      this.mScroller.a(0, i, 0, paramInt1, paramInt2);
      this.this$0.mTouchMode = 4;
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      this.this$0.postOnAnimation(this);
      return;
    }
    this.this$0.post(this);
  }
  
  void startScrollImmediately(int paramInt1, int paramInt2)
  {
    this.mScroller.b();
    int i = this.mScroller.b();
    i = this.mLastFlingY - i;
    if (i != 0)
    {
      i = -i;
      if (paramInt1 >= 0) {
        break label170;
      }
    }
    label170:
    for (int j = 2147483647;; j = 0)
    {
      this.mLastFlingY = j;
      this.mScroller.a(0, j + i, 0, paramInt1 - i, paramInt2);
      this.this$0.mTouchMode = 4;
      this.this$0.invalidate();
      this.this$0.removeCallbacks(this);
      if (Build.VERSION.SDK_INT < 16) {
        break label176;
      }
      this.this$0.postOnAnimation(this);
      return;
      Interpolator localInterpolator = this.mScroller.a();
      if (localInterpolator != null)
      {
        i = (int)localInterpolator.getInterpolation(16.0F / paramInt2) * paramInt1;
        break;
      }
      float f = 16.0F / paramInt2;
      i = (int)(1.0F - (1.0F - f) * (1.0F - f)) * paramInt1;
      break;
    }
    label176:
    this.this$0.post(this);
  }
  
  void startSpringback(int paramInt)
  {
    if (this.mScroller.a(0, this.this$0.getScrollY(), paramInt, paramInt, paramInt, paramInt))
    {
      this.this$0.mTouchMode = 6;
      this.this$0.invalidate();
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimation(this);
        return;
      }
      this.this$0.post(this);
      return;
    }
    this.this$0.mTouchMode = -1;
    this.this$0.reportScrollStateChange(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */