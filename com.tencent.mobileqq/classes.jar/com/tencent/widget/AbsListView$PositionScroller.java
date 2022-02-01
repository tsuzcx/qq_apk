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
    int m = this.this$0.getHeight();
    int k = this.this$0.mFirstPosition;
    int n = this.mMode;
    int j = 0;
    int i = 0;
    Object localObject;
    int i1;
    if (n != 1)
    {
      if (n != 2)
      {
        if (n != 3)
        {
          if (n != 4)
          {
            if (n != 5) {
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
            n = k + j - 1;
            if (m < k) {
              i = k - m + 1;
            } else if (m > n) {
              i = m - n;
            }
            float f = Math.min(Math.abs(i / j), 1.0F);
            if (m < k)
            {
              localObject = this.this$0;
              ((AbsListView)localObject).smoothScrollBy((int)(-((AbsListView)localObject).getHeight() * f), this.mScrollDuration);
              if (Build.VERSION.SDK_INT >= 16)
              {
                this.this$0.postOnAnimation(this);
                return;
              }
              this.this$0.post(this);
              return;
            }
            if (m > n)
            {
              localObject = this.this$0;
              ((AbsListView)localObject).smoothScrollBy((int)(((AbsListView)localObject).getHeight() * f), this.mScrollDuration);
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
            return;
          }
          j = this.this$0.getChildCount() - 2;
          if (j < 0) {
            return;
          }
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
          localObject = this.this$0.getChildAt(j);
          j = ((View)localObject).getHeight();
          k = ((View)localObject).getTop();
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
          if (i > j) {
            this.this$0.smoothScrollBy(-(i - j), this.mScrollDuration);
          }
        }
        else
        {
          i = this.this$0.getChildCount();
          if ((k != this.mBoundPos) && (i > 1))
          {
            if (i + k >= this.this$0.mItemCount) {
              return;
            }
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
            localObject = this.this$0.getChildAt(1);
            j = ((View)localObject).getHeight();
            k = ((View)localObject).getTop();
            m = this.mExtraScroll;
            if (i < this.mBoundPos)
            {
              this.this$0.smoothScrollBy(Math.max(0, j + k - m), this.mScrollDuration);
              this.mLastSeenPos = i;
              if (Build.VERSION.SDK_INT >= 16)
              {
                this.this$0.postOnAnimation(this);
                return;
              }
              this.this$0.post(this);
              return;
            }
            if (k <= m) {
              return;
            }
            this.this$0.smoothScrollBy(k - m, this.mScrollDuration);
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("XListView", 2, new Object[] { " MOVE_UP_POS:firstPos=", Integer.valueOf(k), " mLastSeenPos=", Integer.valueOf(this.mLastSeenPos), " mTargetPos", Integer.valueOf(this.mTargetPos) });
        }
        if ((k == this.mLastSeenPos) && (k <= this.mTargetPos)) {
          return;
        }
        if ((AbsListView.access$2300(this.this$0)) && (this.mTargetPos == 0))
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
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("fight.scroolTop..firstPos = ");
              ((StringBuilder)localObject).append(k);
              ((StringBuilder)localObject).append(",targetPos = ");
              ((StringBuilder)localObject).append(this.mTargetPos);
              ((StringBuilder)localObject).append(",duration = ");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(",childCount ");
              ((StringBuilder)localObject).append(m);
              QLog.d("XListView", 2, ((StringBuilder)localObject).toString());
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
        localObject = this.this$0.getChildAt(0);
        if (localObject == null) {
          return;
        }
        j = ((View)localObject).getTop();
        if (k > 0) {
          i = this.mExtraScroll;
        } else {
          i = this.this$0.mListPadding.top;
        }
        this.this$0.smoothScrollBy(j - i, this.mScrollDuration);
        this.mLastSeenPos = k;
        if (k > this.mTargetPos)
        {
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.this$0.postOnAnimation(this);
            return;
          }
          this.this$0.post(this);
        }
      }
    }
    else
    {
      i = this.this$0.getChildCount() - 1;
      n = k + i;
      if (i < 0) {
        return;
      }
      if ((!AbsListView.access$2300(this.this$0)) && (n == this.mLastSeenPos))
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.this$0.postOnAnimation(this);
          return;
        }
        this.this$0.post(this);
        return;
      }
      if (AbsListView.access$2300(this.this$0))
      {
        i1 = this.mTargetPos;
        if ((n >= i1) && (k <= i1))
        {
          i = this.this$0.getChildAt(i1 - k).getTop();
          this.this$0.smoothScrollBy(i, 200);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("fight.scroolTop..firstPos = ");
            ((StringBuilder)localObject).append(k);
            ((StringBuilder)localObject).append(",targetPos = ");
            ((StringBuilder)localObject).append(this.mTargetPos);
            QLog.d("XListView", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
      }
      localObject = this.this$0.getChildAt(i);
      k = ((View)localObject).getHeight();
      i1 = ((View)localObject).getTop();
      int i2 = this.this$0.mListPadding.bottom;
      i = j;
      if (n < this.mTargetPos)
      {
        i = j;
        if (n < this.this$0.mItemCount - 1) {
          i = this.mExtraScroll;
        }
      }
      this.this$0.smoothScrollBy(k - (m - i1 - i2) + i, this.mScrollDuration);
      this.mLastSeenPos = n;
      if (n < this.mTargetPos)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.this$0.postOnAnimation(this);
          return;
        }
        this.this$0.post(this);
      }
    }
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
    }
    else if (paramInt >= j)
    {
      i = paramInt - j + 1;
      this.mMode = 1;
    }
    else
    {
      if (!AbsListView.access$2300(this.this$0)) {
        return;
      }
      i = paramInt - i;
      this.mMode = 1;
    }
    if (i > 0) {
      this.mScrollDuration = (400 / i);
    } else {
      this.mScrollDuration = 400;
    }
    this.mTargetPos = paramInt;
    this.mBoundPos = -1;
    this.mLastSeenPos = -1;
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.this$0.postOnAnimation(this);
      return;
    }
    this.this$0.post(this);
  }
  
  void start(int paramInt1, int paramInt2)
  {
    stop();
    if (paramInt2 == -1)
    {
      start(paramInt1);
      return;
    }
    int i = this.this$0.mFirstPosition;
    int j = this.this$0.getChildCount() + i - 1;
    if (paramInt1 <= i)
    {
      j -= paramInt2;
      if (j < 1) {
        return;
      }
      i = i - paramInt1 + 1;
      j -= 1;
      if (j < i)
      {
        this.mMode = 4;
        i = j;
      }
    }
    for (;;)
    {
      break;
      this.mMode = 2;
      break;
      if (paramInt1 < j) {
        return;
      }
      int k = paramInt2 - i;
      if (k < 1) {
        return;
      }
      i = paramInt1 - j + 1;
      j = k - 1;
      if (j < i)
      {
        this.mMode = 3;
        i = j;
      }
      else
      {
        this.mMode = 1;
      }
    }
    if (i > 0) {
      this.mScrollDuration = (400 / i);
    } else {
      this.mScrollDuration = 400;
    }
    this.mTargetPos = paramInt1;
    this.mBoundPos = paramInt2;
    this.mLastSeenPos = -1;
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.this$0.postOnAnimation(this);
      return;
    }
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
    if (paramInt1 < j)
    {
      paramInt1 = j - paramInt1;
    }
    else
    {
      if (paramInt1 <= k) {
        break label131;
      }
      paramInt1 -= k;
    }
    float f = paramInt1 / i;
    this.mScrollDuration = ((int)(paramInt3 / f));
    this.mLastSeenPos = -1;
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.this$0.postOnAnimation(this);
      return;
    }
    this.this$0.post(this);
    return;
    label131:
    paramInt1 = this.this$0.getChildAt(paramInt1 - j).getTop();
    this.this$0.smoothScrollBy(paramInt1 - paramInt2, paramInt3);
  }
  
  void stop()
  {
    this.this$0.removeCallbacks(this);
    if (AbsListView.access$1900(this.this$0) != null) {
      AbsListView.access$1900(this.this$0).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsListView.PositionScroller
 * JD-Core Version:    0.7.0.1
 */