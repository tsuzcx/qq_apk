package com.tencent.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;

class HorizontalListView$PositionScroller
  implements Runnable
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private final int f;
  private int g;
  
  HorizontalListView$PositionScroller(HorizontalListView paramHorizontalListView)
  {
    this.f = ViewConfiguration.get(paramHorizontalListView.getContext()).getScaledFadingEdgeLength();
  }
  
  void a()
  {
    this.this$0.removeCallbacks(this);
  }
  
  void a(int paramInt)
  {
    a(paramInt, 0, 2000);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 2000);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
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
    for (this.e = (paramInt1 / (j - i) * paramInt3);; this.e = paramInt3)
    {
      this.b = k;
      c(this.b, paramInt2, this.e);
      return;
      i = this.this$0.mRightViewAdapterIndex;
      break;
      if (k > j)
      {
        paramInt1 = k - j + 1;
        break label113;
      }
      b(k, paramInt3);
      return;
    }
  }
  
  @TargetApi(16)
  void a(Runnable paramRunnable)
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
  
  void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, 0, paramInt2);
  }
  
  void b(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
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
    float f1;
    if (!this.this$0.isFromRightToLeft)
    {
      i = this.this$0.getPaddingLeft();
      paramInt2 += i;
      this.b = Math.max(0, Math.min(this.this$0.mAdapter.getCount() - 1, paramInt1));
      this.g = paramInt2;
      this.c = -1;
      this.d = -1;
      this.a = 5;
      if (this.this$0.isFromRightToLeft) {
        break label201;
      }
      paramInt1 = this.this$0.mLeftViewAdapterIndex;
      i = paramInt1 + j - 1;
      if (this.b >= paramInt1) {
        break label212;
      }
      paramInt1 -= this.b;
      f1 = paramInt1 / j;
      if (f1 >= 1.0F) {
        break label293;
      }
    }
    for (;;)
    {
      this.e = paramInt3;
      this.d = -1;
      a(this);
      return;
      i = this.this$0.getPaddingRight();
      break;
      label201:
      paramInt1 = this.this$0.mRightViewAdapterIndex;
      break label135;
      label212:
      if (this.b > i)
      {
        paramInt1 = this.b - i;
        break label158;
      }
      View localView = this.this$0.getChildAt(this.b - paramInt1);
      if (!this.this$0.isFromRightToLeft) {}
      for (paramInt1 = -localView.getLeft();; paramInt1 = this.this$0.getWidth() - localView.getRight())
      {
        this.this$0.smoothScrollBy(paramInt1 - paramInt2, paramInt3);
        return;
      }
      label293:
      paramInt3 = (int)(paramInt3 / f1);
    }
  }
  
  void c(int paramInt1, int paramInt2, int paramInt3)
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
  
  public void run()
  {
    this.this$0.getHeight();
    if (!this.this$0.isFromRightToLeft) {}
    for (int j = this.this$0.mLeftViewAdapterIndex;; j = this.this$0.mRightViewAdapterIndex) {
      switch (this.a)
      {
      default: 
        return;
      }
    }
    if (this.d == j)
    {
      a(this);
      return;
    }
    this.d = j;
    int n = this.this$0.getChildCount();
    int k = this.b;
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
      f2 = this.e;
      j = (int)(Math.abs(f1) * f2);
      this.this$0.smoothScrollBy(i, j);
      a(this);
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
      f2 = this.e;
      j = (int)(Math.abs(f1) * f2);
      this.this$0.smoothScrollBy(i, j);
      a(this);
      return;
    }
    View localView = this.this$0.getChildAt(k - j);
    if (!this.this$0.isFromRightToLeft) {}
    for (i = -localView.getLeft();; i = this.this$0.getWidth() - localView.getRight())
    {
      i -= this.g;
      j = (int)(this.e * (Math.abs(i) / this.this$0.getWidth()));
      this.this$0.smoothScrollBy(i, j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.PositionScroller
 * JD-Core Version:    0.7.0.1
 */