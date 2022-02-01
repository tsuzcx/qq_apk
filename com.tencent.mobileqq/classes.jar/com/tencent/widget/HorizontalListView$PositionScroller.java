package com.tencent.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;

class HorizontalListView$PositionScroller
  implements Runnable
{
  private static final int MOVE_DOWN_BOUND = 3;
  private static final int MOVE_DOWN_POS = 1;
  private static final int MOVE_OFFSET = 5;
  private static final int MOVE_UP_BOUND = 4;
  private static final int MOVE_UP_POS = 2;
  private static final int SCROLL_DURATION = 2000;
  private int mBoundPos;
  private final int mExtraScroll;
  private int mLastSeenPos;
  private int mMode;
  private int mOffsetFromStart;
  private int mScrollDuration;
  private int mTargetPos;
  
  HorizontalListView$PositionScroller(HorizontalListView paramHorizontalListView)
  {
    this.mExtraScroll = ViewConfiguration.get(paramHorizontalListView.getContext()).getScaledFadingEdgeLength();
  }
  
  @TargetApi(16)
  void postOnAnimation(Runnable paramRunnable)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimation(paramRunnable);
        return;
      }
      this.this$0.post(this);
      return;
    }
    catch (Exception paramRunnable)
    {
      paramRunnable.printStackTrace();
    }
  }
  
  public void run()
  {
    this.this$0.getHeight();
    if (!this.this$0.isFromRightToLeft) {
      j = this.this$0.mLeftViewAdapterIndex;
    } else {
      j = this.this$0.mRightViewAdapterIndex;
    }
    if (this.mMode != 5) {
      return;
    }
    if (this.mLastSeenPos == j)
    {
      postOnAnimation(this);
      return;
    }
    this.mLastSeenPos = j;
    int i1 = this.this$0.getChildCount();
    int m = this.mTargetPos;
    int k = 1;
    int n = j + i1 - 1;
    int i = 0;
    if (m < j) {
      i = j - m + 1;
    } else if (m > n) {
      i = m - n;
    }
    float f = Math.min(Math.abs(i / i1), 1.0F);
    if (!this.this$0.isFromRightToLeft) {
      i = k;
    } else {
      i = -1;
    }
    f *= i;
    if (m < j)
    {
      i = (int)(this.this$0.getWidth() * f);
      j = (int)(this.mScrollDuration * Math.abs(f));
      this.this$0.smoothScrollBy(i, j);
      postOnAnimation(this);
      return;
    }
    if (m > n)
    {
      i = (int)(-this.this$0.getWidth() * f);
      j = (int)(this.mScrollDuration * Math.abs(f));
      this.this$0.smoothScrollBy(i, j);
      postOnAnimation(this);
      return;
    }
    View localView = this.this$0.getChildAt(m - j);
    if (!this.this$0.isFromRightToLeft) {
      i = -localView.getLeft();
    } else {
      i = this.this$0.getWidth() - localView.getRight();
    }
    i -= this.mOffsetFromStart;
    int j = (int)(this.mScrollDuration * (Math.abs(i) / this.this$0.getWidth()));
    this.this$0.smoothScrollBy(i, j);
  }
  
  void scrollToVisible(int paramInt1, int paramInt2)
  {
    scrollToVisible(paramInt1, 0, paramInt2);
  }
  
  void scrollToVisible(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.this$0.mLeftViewAdapterIndex;
    int j = this.this$0.getChildCount();
    View localView = this.this$0.getChildAt(0);
    if ((paramInt1 >= i) && (paramInt1 <= j + i - 1)) {
      paramInt1 = this.this$0.getChildAt(paramInt1 - i).getLeft() - Math.abs(localView.getLeft());
    } else {
      paramInt1 = (paramInt1 - i) * (this.this$0.getChildAt(1).getLeft() - localView.getLeft()) + localView.getLeft();
    }
    if (paramInt1 == 0) {
      return;
    }
    this.this$0.smoothScrollBy(-(paramInt1 + paramInt2), paramInt3);
  }
  
  void start(int paramInt)
  {
    start(paramInt, 0, 2000);
  }
  
  void start(int paramInt1, int paramInt2)
  {
    start(paramInt1, paramInt2, 2000);
  }
  
  void start(int paramInt1, int paramInt2, int paramInt3)
  {
    stop();
    if (this.this$0.mDataChanged)
    {
      this.this$0.mPositionScrollAfterLayout = new HorizontalListView.PositionScroller.1(this, paramInt1, paramInt2);
      return;
    }
    int j = this.this$0.getChildCount();
    if (j == 0) {
      return;
    }
    int i;
    if (!this.this$0.isFromRightToLeft) {
      i = this.this$0.mLeftViewAdapterIndex;
    } else {
      i = this.this$0.mRightViewAdapterIndex;
    }
    j = j + i - 1;
    int k = Math.max(0, Math.min(this.this$0.mAdapter.getCount() - 1, paramInt1));
    if (k < i) {}
    for (paramInt1 = i - k;; paramInt1 = k - j)
    {
      paramInt1 += 1;
      break;
      if (k <= j) {
        break label192;
      }
    }
    if (paramInt1 > 0) {
      this.mScrollDuration = (paramInt3 * (paramInt1 / (j - i)));
    } else {
      this.mScrollDuration = paramInt3;
    }
    this.mTargetPos = k;
    scrollToVisible(this.mTargetPos, paramInt2, this.mScrollDuration);
    return;
    label192:
    scrollToVisible(k, paramInt3);
  }
  
  void startWithOffset(int paramInt1, int paramInt2, int paramInt3)
  {
    stop();
    if (this.this$0.mDataChanged)
    {
      this.this$0.mPositionScrollAfterLayout = new HorizontalListView.PositionScroller.2(this, paramInt1, paramInt2, paramInt3);
      return;
    }
    int j = this.this$0.getChildCount();
    if (j == 0) {
      return;
    }
    if (!this.this$0.isFromRightToLeft) {
      i = this.this$0.getPaddingLeft();
    } else {
      i = this.this$0.getPaddingRight();
    }
    paramInt2 += i;
    this.mTargetPos = Math.max(0, Math.min(this.this$0.mAdapter.getCount() - 1, paramInt1));
    this.mOffsetFromStart = paramInt2;
    this.mBoundPos = -1;
    this.mLastSeenPos = -1;
    this.mMode = 5;
    if (!this.this$0.isFromRightToLeft) {
      paramInt1 = this.this$0.mLeftViewAdapterIndex;
    } else {
      paramInt1 = this.this$0.mRightViewAdapterIndex;
    }
    int i = paramInt1 + j - 1;
    int k = this.mTargetPos;
    if (k < paramInt1)
    {
      paramInt1 -= k;
    }
    else
    {
      if (k <= i) {
        break label241;
      }
      paramInt1 = k - i;
    }
    float f = paramInt1 / j;
    if (f >= 1.0F) {
      paramInt3 = (int)(paramInt3 / f);
    }
    this.mScrollDuration = paramInt3;
    this.mLastSeenPos = -1;
    postOnAnimation(this);
    return;
    label241:
    View localView = this.this$0.getChildAt(k - paramInt1);
    if (!this.this$0.isFromRightToLeft) {
      paramInt1 = -localView.getLeft();
    } else {
      paramInt1 = this.this$0.getWidth() - localView.getRight();
    }
    this.this$0.smoothScrollBy(paramInt1 - paramInt2, paramInt3);
  }
  
  void stop()
  {
    this.this$0.removeCallbacks(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.PositionScroller
 * JD-Core Version:    0.7.0.1
 */