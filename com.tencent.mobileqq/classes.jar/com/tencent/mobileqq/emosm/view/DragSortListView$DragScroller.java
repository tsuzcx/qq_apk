package com.tencent.mobileqq.emosm.view;

import android.os.SystemClock;
import android.view.View;

class DragSortListView$DragScroller
  implements Runnable
{
  private boolean a;
  private long b;
  private long c;
  private int d;
  private float e;
  private long f;
  private int g;
  private float h;
  private boolean i = false;
  
  public DragSortListView$DragScroller(DragSortListView paramDragSortListView) {}
  
  public void a(int paramInt)
  {
    if (!this.i)
    {
      this.a = false;
      this.i = true;
      this.f = SystemClock.uptimeMillis();
      this.b = this.f;
      this.g = paramInt;
      this.this$0.post(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.this$0.removeCallbacks(this);
      this.i = false;
      return;
    }
    this.a = true;
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public int b()
  {
    if (this.i) {
      return this.g;
    }
    return -1;
  }
  
  public void run()
  {
    if (this.a)
    {
      this.i = false;
      return;
    }
    int k = this.this$0.getFirstVisiblePosition();
    int j = this.this$0.getLastVisiblePosition();
    int i1 = this.this$0.getCount();
    int m = this.this$0.getPaddingTop();
    int n = this.this$0.getHeight() - m - this.this$0.getPaddingBottom();
    int i2 = Math.min(this.this$0.r, this.this$0.b + this.this$0.k);
    int i3 = Math.max(this.this$0.r, this.this$0.b - this.this$0.k);
    if (this.g == 0)
    {
      localView = this.this$0.getChildAt(0);
      if (localView == null)
      {
        this.i = false;
        return;
      }
      if ((k == 0) && (localView.getTop() == m))
      {
        this.i = false;
        return;
      }
      this.h = this.this$0.q.a((this.this$0.m - i3) / this.this$0.n, this.b);
    }
    else
    {
      localView = this.this$0.getChildAt(j - k);
      if (localView == null)
      {
        this.i = false;
        return;
      }
      if ((j == i1 - 1) && (localView.getBottom() <= n + m))
      {
        this.i = false;
        return;
      }
      this.h = (-this.this$0.q.a((i2 - this.this$0.l) / this.this$0.o, this.b));
    }
    this.c = SystemClock.uptimeMillis();
    this.e = ((float)(this.c - this.b));
    this.d = Math.round(this.h * this.e);
    i1 = this.d;
    if (i1 >= 0)
    {
      this.d = Math.min(n, i1);
      j = k;
    }
    else
    {
      this.d = Math.max(-n, i1);
    }
    View localView = this.this$0.getChildAt(j - k);
    n = localView.getTop() + this.d;
    k = n;
    if (j == 0)
    {
      k = n;
      if (n > m) {
        k = m;
      }
    }
    DragSortListView.a(this.this$0, true);
    this.this$0.setSelectionFromTop(j, k - m);
    this.this$0.layoutChildren();
    this.this$0.invalidate();
    DragSortListView.a(this.this$0, false);
    this.this$0.a(j, localView, false);
    this.b = this.c;
    this.this$0.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.DragScroller
 * JD-Core Version:    0.7.0.1
 */