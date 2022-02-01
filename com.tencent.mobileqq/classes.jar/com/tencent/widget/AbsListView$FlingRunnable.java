package com.tencent.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;

class AbsListView$FlingRunnable
  implements Runnable
{
  private static final int FLYWHEEL_TIMEOUT = 40;
  private final Runnable mCheckFlywheel = new AbsListView.FlingRunnable.1(this);
  private int mLastFlingY;
  private final OverScroller mScroller;
  
  AbsListView$FlingRunnable(AbsListView paramAbsListView)
  {
    this.mScroller = new OverScroller(paramAbsListView.getContext());
  }
  
  private void preceedFling(int paramInt)
  {
    this.this$0.invalidate();
    this.mLastFlingY = paramInt;
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.this$0.postOnAnimation(this);
      return;
    }
    this.this$0.post(this);
  }
  
  @TargetApi(9)
  void edgeReached(int paramInt)
  {
    if (this.this$0.mForHongBao) {
      i = this.this$0.getSpringbackOffset();
    } else {
      i = 0;
    }
    Object localObject = this.mScroller;
    int j;
    if (paramInt > 0) {
      j = this.this$0.mTopOverflingDistance;
    } else {
      j = this.this$0.mBottomOverflingDistance;
    }
    ((OverScroller)localObject).notifyVerticalEdgeReached(paramInt, i, j);
    int i = this.this$0.getOverScrollMode();
    if ((i != 0) && ((i != 1) || (AbsListView.access$1800(this.this$0))))
    {
      localObject = this.this$0;
      ((AbsListView)localObject).mTouchMode = -1;
      if (((AbsListView)localObject).mPositionScroller != null) {
        this.this$0.mPositionScroller.stop();
      }
      if (AbsListView.access$1900(this.this$0) != null) {
        AbsListView.access$1900(this.this$0).stop();
      }
    }
    else
    {
      this.this$0.mTouchMode = 6;
      i = (int)this.mScroller.getCurrVelocity();
      if (this.this$0.mEdgeGlowTop != null) {
        if (paramInt > 0) {
          this.this$0.mEdgeGlowTop.onAbsorb(i);
        } else {
          this.this$0.mEdgeGlowBottom.onAbsorb(i);
        }
      }
    }
    this.this$0.invalidate();
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.this$0.postOnAnimation(this);
      return;
    }
    this.this$0.post(this);
  }
  
  void endFling()
  {
    AbsListView localAbsListView = this.this$0;
    localAbsListView.mTouchMode = -1;
    localAbsListView.removeCallbacks(this);
    this.this$0.removeCallbacks(this.mCheckFlywheel);
    this.this$0.reportScrollStateChange(0);
    AbsListView.access$2000(this.this$0);
    this.mScroller.abortAnimation();
    if (AbsListView.access$1600(this.this$0) != null)
    {
      localAbsListView = this.this$0;
      AbsListView.access$1602(localAbsListView, AbsListView.access$2100(localAbsListView, AbsListView.access$1600(localAbsListView)));
    }
  }
  
  void flywheelTouch()
  {
    this.this$0.postDelayed(this.mCheckFlywheel, 40L);
  }
  
  @TargetApi(9)
  public void run()
  {
    int i = this.this$0.mTouchMode;
    int j = 1;
    int k = 1;
    int m;
    if (i != 3)
    {
      if (i != 4)
      {
        if (i != 6)
        {
          endFling();
          return;
        }
        try
        {
          OverScroller localOverScroller = this.mScroller;
          if (localOverScroller.computeScrollOffset())
          {
            k = this.this$0.getScrollY();
            m = localOverScroller.getCurrY();
            if (this.this$0.overScrollBy(0, m - k, 0, k, 0, 0, 0, this.this$0.mOverscrollDistance, false))
            {
              if ((k > 0) || (m <= 0)) {
                break label644;
              }
              i = 1;
              break label646;
              startSpringback(0);
              return;
              label110:
              k = (int)localOverScroller.getCurrVelocity();
              i = k;
              if (j != 0) {
                i = -k;
              }
              localOverScroller.abortAnimation();
              start(i);
              return;
            }
            this.this$0.invalidate();
            if (Build.VERSION.SDK_INT >= 16)
            {
              this.this$0.postOnAnimation(this);
              return;
            }
            this.this$0.post(this);
            return;
          }
          endFling();
          return;
        }
        finally {}
      }
    }
    else if (this.mScroller.isFinished()) {
      return;
    }
    AdapterView.traceBegin("AbsListView.FlingRunable.onfling");
    for (;;)
    {
      try
      {
        if (this.this$0.mDataChanged) {
          this.this$0.layoutChildren();
        }
        if ((this.this$0.mItemCount != 0) && (this.this$0.getChildCount() != 0))
        {
          Object localObject2 = this.mScroller;
          boolean bool = ((OverScroller)localObject2).computeScrollOffset();
          m = ((OverScroller)localObject2).getCurrY();
          i = this.mLastFlingY - m;
          if (i > 0)
          {
            this.this$0.mMotionPosition = this.this$0.mFirstPosition;
            localObject2 = this.this$0.getChildAt(0);
            this.this$0.mMotionViewOriginalTop = ((View)localObject2).getTop();
            i = Math.min(this.this$0.getHeight() - this.this$0.getPaddingBottom() - this.this$0.getPaddingTop() - 1, i);
          }
          else
          {
            j = this.this$0.getChildCount() - 1;
            this.this$0.mMotionPosition = (this.this$0.mFirstPosition + j);
            localObject2 = this.this$0.getChildAt(j);
            this.this$0.mMotionViewOriginalTop = ((View)localObject2).getTop();
            i = Math.max(-(this.this$0.getHeight() - this.this$0.getPaddingBottom() - this.this$0.getPaddingTop() - 1), i);
          }
          localObject2 = this.this$0.getChildAt(this.this$0.mMotionPosition - this.this$0.mFirstPosition);
          if (localObject2 == null) {
            break label671;
          }
          j = ((View)localObject2).getTop();
          if ((!this.this$0.trackMotionScroll(i, i)) || (i == 0)) {
            break label676;
          }
          if (k != 0)
          {
            if (localObject2 != null) {
              if ((AbsListView.access$2200(this.this$0) != null) && (AbsListView.access$2200(this.this$0).onNestedScrolling(i) == i))
              {
                preceedFling(m);
              }
              else
              {
                j = -(i - (((View)localObject2).getTop() - j));
                if ((!this.this$0.mForHongBao) || (j <= 0))
                {
                  i = j;
                  if (bool)
                  {
                    edgeReached(j);
                    i = this.mScroller.getCurrY();
                  }
                  this.this$0.overScrollBy(0, i, 0, this.this$0.getScrollY(), 0, 0, 0, this.this$0.mOverscrollDistance, false);
                }
              }
            }
            AdapterView.traceEnd();
            return;
          }
          if ((bool) && (k == 0))
          {
            preceedFling(m);
            continue;
          }
          endFling();
          continue;
        }
        endFling();
        AdapterView.traceEnd();
        return;
      }
      finally
      {
        AdapterView.traceEnd();
      }
      for (;;)
      {
        throw localObject3;
      }
      label644:
      i = 0;
      label646:
      if ((k < 0) || (m >= 0)) {
        j = 0;
      }
      if (i != 0) {
        break label110;
      }
      if (j == 0) {
        break;
      }
      break label110;
      label671:
      j = 0;
      continue;
      label676:
      k = 0;
    }
  }
  
  void start(int paramInt)
  {
    int i;
    if (paramInt < 0) {
      i = 2147483647;
    } else {
      i = 0;
    }
    this.mLastFlingY = i;
    this.mScroller.fling(0, i, 0, paramInt, 0, 2147483647, 0, 2147483647);
    this.this$0.mTouchMode = 4;
    if (Build.VERSION.SDK_INT >= 16) {
      this.this$0.postOnAnimation(this);
    } else {
      this.this$0.post(this);
    }
    if (AbsListView.access$1600(this.this$0) == null)
    {
      AbsListView localAbsListView = this.this$0;
      AbsListView.access$1602(localAbsListView, AbsListView.access$1700(localAbsListView, "AbsListView-fling"));
    }
  }
  
  void startOverfling(int paramInt)
  {
    this.mScroller.fling(0, this.this$0.getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, this.this$0.getHeight());
    AbsListView localAbsListView = this.this$0;
    localAbsListView.mTouchMode = 6;
    localAbsListView.invalidate();
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.this$0.postOnAnimation(this);
      return;
    }
    this.this$0.post(this);
  }
  
  void startScroll(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < 0) {
      i = 2147483647;
    } else {
      i = 0;
    }
    this.mLastFlingY = i;
    this.mScroller.startScroll(0, i, 0, paramInt1, paramInt2);
    this.this$0.mTouchMode = 4;
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.this$0.postOnAnimation(this);
      return;
    }
    this.this$0.post(this);
  }
  
  void startScrollImmediately(int paramInt1, int paramInt2)
  {
    this.mScroller.computeScrollOffset();
    int i = this.mScroller.getCurrY();
    i = this.mLastFlingY - i;
    if (i != 0)
    {
      i = -i;
    }
    else
    {
      localObject = this.mScroller.getInterpolator();
      float f;
      if (localObject != null)
      {
        f = ((Interpolator)localObject).getInterpolation(16.0F / paramInt2);
      }
      else
      {
        f = 1.0F - 16.0F / paramInt2;
        f = 1.0F - f * f;
      }
      i = (int)f * paramInt1;
    }
    int j;
    if (paramInt1 < 0) {
      j = 2147483647;
    } else {
      j = 0;
    }
    this.mLastFlingY = j;
    this.mScroller.startScroll(0, j + i, 0, paramInt1 - i, paramInt2);
    Object localObject = this.this$0;
    ((AbsListView)localObject).mTouchMode = 4;
    ((AbsListView)localObject).invalidate();
    this.this$0.removeCallbacks(this);
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.this$0.postOnAnimation(this);
      return;
    }
    this.this$0.post(this);
  }
  
  void startSpringback(int paramInt)
  {
    if (this.mScroller.springBack(0, this.this$0.getScrollY(), paramInt, paramInt, paramInt, paramInt))
    {
      localAbsListView = this.this$0;
      localAbsListView.mTouchMode = 6;
      localAbsListView.invalidate();
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimation(this);
        return;
      }
      this.this$0.post(this);
      return;
    }
    AbsListView localAbsListView = this.this$0;
    localAbsListView.mTouchMode = -1;
    localAbsListView.reportScrollStateChange(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsListView.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */