package com.tencent.mobileqq.emosm.view;

import android.graphics.Point;
import android.view.View;

class DragSortListView$DropAnimator
  extends DragSortListView.SmoothAnimator
{
  private int b;
  private int c;
  private float d;
  private float e;
  
  public DragSortListView$DropAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
  }
  
  private int e()
  {
    int i = this.this$0.getFirstVisiblePosition();
    int j = (this.this$0.i + this.this$0.getDividerHeight()) / 2;
    View localView = this.this$0.getChildAt(this.b - i);
    if (localView != null)
    {
      i = this.b;
      int k = this.c;
      if (i == k) {
        return localView.getTop();
      }
      if (i < k)
      {
        i = localView.getTop();
      }
      else
      {
        i = localView.getBottom() + j;
        j = this.this$0.j;
      }
      return i - j;
    }
    d();
    return -1;
  }
  
  public void a()
  {
    this.b = this.this$0.c;
    this.c = this.this$0.f;
    DragSortListView localDragSortListView = this.this$0;
    localDragSortListView.h = 2;
    this.d = (localDragSortListView.a.y - e());
    this.e = (this.this$0.a.x - this.this$0.getPaddingLeft());
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    int i = e();
    int j = this.this$0.getPaddingLeft();
    paramFloat1 = this.this$0.a.y - i;
    float f = this.this$0.a.x - j;
    paramFloat2 = 1.0F - paramFloat2;
    if ((paramFloat2 < Math.abs(paramFloat1 / this.d)) || (paramFloat2 < Math.abs(f / this.e)))
    {
      this.this$0.a.y = (i + (int)(this.d * paramFloat2));
      this.this$0.a.x = (this.this$0.getPaddingLeft() + (int)(this.e * paramFloat2));
      this.this$0.b(true);
    }
  }
  
  public void b()
  {
    DragSortListView.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.DropAnimator
 * JD-Core Version:    0.7.0.1
 */