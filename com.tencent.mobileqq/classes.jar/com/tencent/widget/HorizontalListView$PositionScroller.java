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
    if (!this.this$0.isFromRightToLeft) {}
    for (int j = this.this$0.mLeftViewAdapterIndex;; j = this.this$0.mRightViewAdapterIndex) {
      switch (this.mMode)
      {
      default: 
        return;
      }
    }
    if (this.mLastSeenPos == j)
    {
      postOnAnimation(this);
      return;
    }
    this.mLastSeenPos = j;
    int n = this.this$0.getChildCount();
    int k = this.mTargetPos;
    int m = j + n - 1;
    int i = 0;
    float f1;
    if (k < j)
    {
      i = j - k + 1;
      f1 = Math.min(Math.abs(i / n), 1.0F);
      if (this.this$0.isFromRightToLeft) {
        break label220;
      }
    }
    float f2;
    label220:
    for (i = 1;; i = -1)
    {
      f1 = i * f1;
      if (k >= j) {
        break label225;
      }
      i = (int)(this.this$0.getWidth() * f1);
      f2 = this.mScrollDuration;
      j = (int)(Math.abs(f1) * f2);
      this.this$0.smoothScrollBy(i, j);
      postOnAnimation(this);
      return;
      if (k <= m) {
        break;
      }
      i = k - m;
      break;
    }
    label225:
    if (k > m)
    {
      i = (int)(-this.this$0.getWidth() * f1);
      f2 = this.mScrollDuration;
      j = (int)(Math.abs(f1) * f2);
      this.this$0.smoothScrollBy(i, j);
      postOnAnimation(this);
      return;
    }
    View localView = this.this$0.getChildAt(k - j);
    if (!this.this$0.isFromRightToLeft) {}
    for (i = -localView.getLeft();; i = this.this$0.getWidth() - localView.getRight())
    {
      i -= this.mOffsetFromStart;
      j = (int)(this.mScrollDuration * (Math.abs(i) / this.this$0.getWidth()));
      this.this$0.smoothScrollBy(i, j);
      return;
    }
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
    if ((paramInt1 < i) || (paramInt1 > j + i - 1)) {}
    for (paramInt1 = (paramInt1 - i) * (this.this$0.getChildAt(1).getLeft() - localView.getLeft()) + localView.getLeft(); paramInt1 == 0; paramInt1 = this.this$0.getChildAt(paramInt1 - i).getLeft() - Math.abs(localView.getLeft())) {
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
    if (this.this$0.mDataChanged) {
      this.this$0.mPositionScrollAfterLayout = new HorizontalListView.PositionScroller.1(this, paramInt1, paramInt2);
    }
    int j;
    do
    {
      return;
      j = this.this$0.getChildCount();
    } while (j == 0);
    int i;
    int k;
    if (!this.this$0.isFromRightToLeft)
    {
      i = this.this$0.mLeftViewAdapterIndex;
      j = j + i - 1;
      k = Math.max(0, Math.min(this.this$0.mAdapter.getCount() - 1, paramInt1));
      if (k >= i) {
        break label162;
      }
      paramInt1 = i - k + 1;
      label113:
      if (paramInt1 <= 0) {
        break label188;
      }
    }
    label162:
    label188:
    for (this.mScrollDuration = (paramInt1 / (j - i) * paramInt3);; this.mScrollDuration = paramInt3)
    {
      this.mTargetPos = k;
      scrollToVisible(this.mTargetPos, paramInt2, this.mScrollDuration);
      return;
      i = this.this$0.mRightViewAdapterIndex;
      break;
      if (k > j)
      {
        paramInt1 = k - j + 1;
        break label113;
      }
      scrollToVisible(k, paramInt3);
      return;
    }
  }
  
  void startWithOffset(int paramInt1, int paramInt2, int paramInt3)
  {
    stop();
    if (this.this$0.mDataChanged) {
      this.this$0.mPositionScrollAfterLayout = new HorizontalListView.PositionScroller.2(this, paramInt1, paramInt2, paramInt3);
    }
    int j;
    do
    {
      return;
      j = this.this$0.getChildCount();
    } while (j == 0);
    int i;
    label135:
    label158:
    float f;
    if (!this.this$0.isFromRightToLeft)
    {
      i = this.this$0.getPaddingLeft();
      paramInt2 += i;
      this.mTargetPos = Math.max(0, Math.min(this.this$0.mAdapter.getCount() - 1, paramInt1));
      this.mOffsetFromStart = paramInt2;
      this.mBoundPos = -1;
      this.mLastSeenPos = -1;
      this.mMode = 5;
      if (this.this$0.isFromRightToLeft) {
        break label201;
      }
      paramInt1 = this.this$0.mLeftViewAdapterIndex;
      i = paramInt1 + j - 1;
      if (this.mTargetPos >= paramInt1) {
        break label212;
      }
      paramInt1 -= this.mTargetPos;
      f = paramInt1 / j;
      if (f >= 1.0F) {
        break label293;
      }
    }
    for (;;)
    {
      this.mScrollDuration = paramInt3;
      this.mLastSeenPos = -1;
      postOnAnimation(this);
      return;
      i = this.this$0.getPaddingRight();
      break;
      label201:
      paramInt1 = this.this$0.mRightViewAdapterIndex;
      break label135;
      label212:
      if (this.mTargetPos > i)
      {
        paramInt1 = this.mTargetPos - i;
        break label158;
      }
      View localView = this.this$0.getChildAt(this.mTargetPos - paramInt1);
      if (!this.this$0.isFromRightToLeft) {}
      for (paramInt1 = -localView.getLeft();; paramInt1 = this.this$0.getWidth() - localView.getRight())
      {
        this.this$0.smoothScrollBy(paramInt1 - paramInt2, paramInt3);
        return;
      }
      label293:
      paramInt3 = (int)(paramInt3 / f);
    }
  }
  
  void stop()
  {
    this.this$0.removeCallbacks(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.PositionScroller
 * JD-Core Version:    0.7.0.1
 */