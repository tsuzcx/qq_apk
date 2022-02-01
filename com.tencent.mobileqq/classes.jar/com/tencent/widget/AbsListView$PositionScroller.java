package com.tencent.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;

class AbsListView$PositionScroller
  implements Runnable
{
  private static final int MOVE_DOWN_BOUND = 3;
  private static final int MOVE_DOWN_POS = 1;
  private static final int MOVE_OFFSET = 5;
  private static final int MOVE_UP_BOUND = 4;
  private static final int MOVE_UP_POS = 2;
  private static final int SCROLL_DURATION = 400;
  private int mBoundPos;
  private final int mExtraScroll;
  private int mLastSeenPos;
  private int mMode;
  private int mOffsetFromTop;
  private int mScrollDuration;
  private int mTargetPos;
  
  AbsListView$PositionScroller(AbsListView paramAbsListView)
  {
    this.mExtraScroll = ViewConfiguration.get(paramAbsListView.getContext()).getScaledFadingEdgeLength();
  }
  
  public void run()
  {
    int i = 0;
    int j = 0;
    int m = this.this$0.getHeight();
    int k = this.this$0.mFirstPosition;
    switch (this.mMode)
    {
    default: 
    case 1: 
    case 3: 
    case 2: 
    case 4: 
      label944:
      do
      {
        do
        {
          do
          {
            int i1;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        i = this.this$0.getChildCount() - 1;
                        n = k + i;
                      } while (i < 0);
                      if ((!AbsListView.access$3000(this.this$0)) && (n == this.mLastSeenPos))
                      {
                        if (Build.VERSION.SDK_INT >= 16)
                        {
                          this.this$0.postOnAnimation(this);
                          return;
                        }
                        this.this$0.post(this);
                        return;
                      }
                      if ((!AbsListView.access$3000(this.this$0)) || (n < this.mTargetPos) || (k > this.mTargetPos)) {
                        break;
                      }
                      i = this.mTargetPos;
                      i = this.this$0.getChildAt(i - k).getTop();
                      this.this$0.smoothScrollBy(i, 200);
                    } while (!QLog.isColorLevel());
                    QLog.d("XListView", 2, "fight.scroolTop..firstPos = " + k + ",targetPos = " + this.mTargetPos);
                    return;
                    localView = this.this$0.getChildAt(i);
                    k = localView.getHeight();
                    i1 = localView.getTop();
                    int i2 = this.this$0.mListPadding.bottom;
                    i = j;
                    if (n < this.mTargetPos)
                    {
                      i = j;
                      if (n < this.this$0.mItemCount - 1) {
                        i = this.mExtraScroll;
                      }
                    }
                    this.this$0.smoothScrollBy(i + (k - (m - i1 - i2)), this.mScrollDuration);
                    this.mLastSeenPos = n;
                  } while (n >= this.mTargetPos);
                  if (Build.VERSION.SDK_INT >= 16)
                  {
                    this.this$0.postOnAnimation(this);
                    return;
                  }
                  this.this$0.post(this);
                  return;
                  i = this.this$0.getChildCount();
                } while ((k == this.mBoundPos) || (i <= 1) || (i + k >= this.this$0.mItemCount));
                i = k + 1;
                if (i == this.mLastSeenPos)
                {
                  if (Build.VERSION.SDK_INT >= 16)
                  {
                    this.this$0.postOnAnimation(this);
                    return;
                  }
                  this.this$0.post(this);
                  return;
                }
                localView = this.this$0.getChildAt(1);
                j = localView.getHeight();
                k = localView.getTop();
                m = this.mExtraScroll;
                if (i < this.mBoundPos)
                {
                  this.this$0.smoothScrollBy(Math.max(0, k + j - m), this.mScrollDuration);
                  this.mLastSeenPos = i;
                  if (Build.VERSION.SDK_INT >= 16)
                  {
                    this.this$0.postOnAnimation(this);
                    return;
                  }
                  this.this$0.post(this);
                  return;
                }
              } while (k <= m);
              this.this$0.smoothScrollBy(k - m, this.mScrollDuration);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("XListView", 2, new Object[] { " MOVE_UP_POS:firstPos=", Integer.valueOf(k), " mLastSeenPos=", Integer.valueOf(this.mLastSeenPos), " mTargetPos", Integer.valueOf(this.mTargetPos) });
              }
            } while ((k == this.mLastSeenPos) && (k <= this.mTargetPos));
            if ((AbsListView.access$3000(this.this$0)) && (this.mTargetPos == 0))
            {
              m = this.this$0.getChildCount();
              if ((this.this$0.mItemCount > 30) && (k + m - 1 > m * 3 - 1))
              {
                j = this.mScrollDuration * m / 2;
                i = j;
                if (j < 30) {
                  i = 30;
                }
                j = this.this$0.getHeight();
                n = this.this$0.mListPadding.top;
                i1 = this.this$0.mListPadding.bottom;
                this.this$0.smoothScrollBy(-(j - n - i1), i);
                if (QLog.isColorLevel()) {
                  QLog.d("XListView", 2, "fight.scroolTop..firstPos = " + k + ",targetPos = " + this.mTargetPos + ",duration = " + i + ",childCount " + m);
                }
                this.mLastSeenPos = k;
                if (Build.VERSION.SDK_INT >= 16)
                {
                  this.this$0.postOnAnimation(this);
                  return;
                }
                this.this$0.post(this);
                return;
              }
            }
            localView = this.this$0.getChildAt(0);
          } while (localView == null);
          j = localView.getTop();
          if (k > 0) {}
          for (i = this.mExtraScroll;; i = this.this$0.mListPadding.top)
          {
            this.this$0.smoothScrollBy(j - i, this.mScrollDuration);
            this.mLastSeenPos = k;
            if (k <= this.mTargetPos) {
              break;
            }
            if (Build.VERSION.SDK_INT < 16) {
              break label944;
            }
            this.this$0.postOnAnimation(this);
            return;
          }
          this.this$0.post(this);
          return;
          j = this.this$0.getChildCount() - 2;
        } while (j < 0);
        i = k + j;
        if (i == this.mLastSeenPos)
        {
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.this$0.postOnAnimation(this);
            return;
          }
          this.this$0.post(this);
          return;
        }
        View localView = this.this$0.getChildAt(j);
        j = localView.getHeight();
        k = localView.getTop();
        this.mLastSeenPos = i;
        if (i > this.mBoundPos)
        {
          this.this$0.smoothScrollBy(-(m - k - this.mExtraScroll), this.mScrollDuration);
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.this$0.postOnAnimation(this);
            return;
          }
          this.this$0.post(this);
          return;
        }
        i = m - this.mExtraScroll;
        j = k + j;
      } while (i <= j);
      this.this$0.smoothScrollBy(-(i - j), this.mScrollDuration);
      return;
    }
    if (this.mLastSeenPos == k)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimation(this);
        return;
      }
      this.this$0.post(this);
      return;
    }
    this.mLastSeenPos = k;
    j = this.this$0.getChildCount();
    m = this.mTargetPos;
    int n = k + j - 1;
    if (m < k) {
      i = k - m + 1;
    }
    float f;
    for (;;)
    {
      f = Math.min(Math.abs(i / j), 1.0F);
      if (m >= k) {
        break label1292;
      }
      this.this$0.smoothScrollBy((int)(f * -this.this$0.getHeight()), this.mScrollDuration);
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      this.this$0.postOnAnimation(this);
      return;
      if (m > n) {
        i = m - n;
      }
    }
    this.this$0.post(this);
    return;
    label1292:
    if (m > n)
    {
      this.this$0.smoothScrollBy((int)(f * this.this$0.getHeight()), this.mScrollDuration);
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimation(this);
        return;
      }
      this.this$0.post(this);
      return;
    }
    i = this.this$0.getChildAt(m - k).getTop() - this.mOffsetFromTop;
    j = Math.abs((int)(this.mScrollDuration * (i / this.this$0.getHeight())));
    this.this$0.smoothScrollBy(i, j);
  }
  
  void start(int paramInt)
  {
    stop();
    int i = this.this$0.mFirstPosition;
    int j = this.this$0.getChildCount() + i - 1;
    if (paramInt <= i)
    {
      i = i - paramInt + 1;
      this.mMode = 2;
      if (i <= 0) {
        break label126;
      }
    }
    label126:
    for (this.mScrollDuration = (400 / i);; this.mScrollDuration = 400)
    {
      this.mTargetPos = paramInt;
      this.mBoundPos = -1;
      this.mLastSeenPos = -1;
      if (Build.VERSION.SDK_INT < 16) {
        break label136;
      }
      this.this$0.postOnAnimation(this);
      do
      {
        return;
        if (paramInt >= j)
        {
          i = paramInt - j + 1;
          this.mMode = 1;
          break;
        }
      } while (!AbsListView.access$3000(this.this$0));
      i = paramInt - i;
      this.mMode = 1;
      break;
    }
    label136:
    this.this$0.post(this);
  }
  
  void start(int paramInt1, int paramInt2)
  {
    stop();
    if (paramInt2 == -1) {
      start(paramInt1);
    }
    int j;
    do
    {
      return;
      i = this.this$0.mFirstPosition;
      j = this.this$0.getChildCount() + i - 1;
      if (paramInt1 > i) {
        break;
      }
      j -= paramInt2;
    } while (j < 1);
    int i = i - paramInt1 + 1;
    j -= 1;
    if (j < i)
    {
      this.mMode = 4;
      i = j;
      label79:
      if (i <= 0) {
        break label187;
      }
    }
    label185:
    label187:
    for (this.mScrollDuration = (400 / i);; this.mScrollDuration = 400)
    {
      this.mTargetPos = paramInt1;
      this.mBoundPos = paramInt2;
      this.mLastSeenPos = -1;
      if (Build.VERSION.SDK_INT < 16) {
        break label197;
      }
      this.this$0.postOnAnimation(this);
      return;
      for (this.mMode = 2;; this.mMode = 1)
      {
        break label79;
        if (paramInt1 < j) {
          break label185;
        }
        int k = paramInt2 - i;
        if (k < 1) {
          break;
        }
        i = paramInt1 - j + 1;
        j = k - 1;
        if (j < i)
        {
          this.mMode = 3;
          i = j;
          break label79;
        }
      }
      break;
    }
    label197:
    this.this$0.post(this);
  }
  
  void startWithOffset(int paramInt1, int paramInt2)
  {
    startWithOffset(paramInt1, paramInt2, 400);
  }
  
  void startWithOffset(int paramInt1, int paramInt2, int paramInt3)
  {
    stop();
    this.mTargetPos = paramInt1;
    this.mOffsetFromTop = paramInt2;
    this.mBoundPos = -1;
    this.mLastSeenPos = -1;
    this.mMode = 5;
    int j = this.this$0.mFirstPosition;
    int i = this.this$0.getChildCount();
    int k = j + i - 1;
    if (paramInt1 < j) {
      paramInt1 = j - paramInt1;
    }
    for (;;)
    {
      float f = paramInt1 / i;
      this.mScrollDuration = ((int)(paramInt3 / f));
      this.mLastSeenPos = -1;
      if (Build.VERSION.SDK_INT < 16) {
        break label148;
      }
      this.this$0.postOnAnimation(this);
      return;
      if (paramInt1 <= k) {
        break;
      }
      paramInt1 -= k;
    }
    paramInt1 = this.this$0.getChildAt(paramInt1 - j).getTop();
    this.this$0.smoothScrollBy(paramInt1 - paramInt2, paramInt3);
    return;
    label148:
    this.this$0.post(this);
  }
  
  void stop()
  {
    this.this$0.removeCallbacks(this);
    if (AbsListView.access$1900(this.this$0) != null) {
      AbsListView.access$1900(this.this$0).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.PositionScroller
 * JD-Core Version:    0.7.0.1
 */