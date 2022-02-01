package com.tencent.mobileqq.emosm.view;

import android.os.SystemClock;
import android.view.View;
import arbu;

class DragSortListView$DragScroller
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  
  public DragSortListView$DragScroller(DragSortListView paramDragSortListView) {}
  
  public int a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      this.c = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Long = this.c;
      this.jdField_b_of_type_Int = paramInt;
      this.this$0.post(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.this$0.removeCallbacks(this);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    int j = this.this$0.getFirstVisiblePosition();
    int i = this.this$0.getLastVisiblePosition();
    int m = this.this$0.getCount();
    int k = this.this$0.getPaddingTop();
    int n = this.this$0.getHeight() - k - this.this$0.getPaddingBottom();
    int i1 = Math.min(this.this$0.k, this.this$0.jdField_a_of_type_Int + this.this$0.j);
    int i2 = Math.max(this.this$0.k, this.this$0.jdField_a_of_type_Int - this.this$0.j);
    View localView;
    if (this.jdField_b_of_type_Int == 0)
    {
      localView = this.this$0.getChildAt(0);
      if (localView == null)
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      if ((j == 0) && (localView.getTop() == k))
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      this.jdField_b_of_type_Float = this.this$0.jdField_a_of_type_Arbu.a((this.this$0.jdField_b_of_type_Float - i2) / this.this$0.c, this.jdField_a_of_type_Long);
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Float = ((float)(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
      this.jdField_a_of_type_Int = Math.round(this.jdField_b_of_type_Float * this.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_Int < 0) {
        break label470;
      }
      this.jdField_a_of_type_Int = Math.min(n, this.jdField_a_of_type_Int);
      i = j;
    }
    for (;;)
    {
      localView = this.this$0.getChildAt(i - j);
      m = localView.getTop() + this.jdField_a_of_type_Int;
      j = m;
      if (i == 0)
      {
        j = m;
        if (m > k) {
          j = k;
        }
      }
      DragSortListView.a(this.this$0, true);
      this.this$0.setSelectionFromTop(i, j - k);
      this.this$0.layoutChildren();
      this.this$0.invalidate();
      DragSortListView.a(this.this$0, false);
      this.this$0.a(i, localView, false);
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      this.this$0.post(this);
      return;
      localView = this.this$0.getChildAt(i - j);
      if (localView == null)
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      if ((i == m - 1) && (localView.getBottom() <= n + k))
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      this.jdField_b_of_type_Float = (-this.this$0.jdField_a_of_type_Arbu.a((i1 - this.this$0.jdField_a_of_type_Float) / this.this$0.d, this.jdField_a_of_type_Long));
      break;
      label470:
      this.jdField_a_of_type_Int = Math.max(-n, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.DragScroller
 * JD-Core Version:    0.7.0.1
 */