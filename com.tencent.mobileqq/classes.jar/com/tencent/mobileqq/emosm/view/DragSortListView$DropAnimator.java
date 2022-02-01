package com.tencent.mobileqq.emosm.view;

import android.graphics.Point;
import android.view.View;

class DragSortListView$DropAnimator
  extends DragSortListView.SmoothAnimator
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  public DragSortListView$DropAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
  }
  
  private int a()
  {
    int i = this.this$0.getFirstVisiblePosition();
    int j = (this.this$0.h + this.this$0.getDividerHeight()) / 2;
    View localView = this.this$0.getChildAt(this.jdField_a_of_type_Int - i);
    if (localView != null)
    {
      i = this.jdField_a_of_type_Int;
      int k = this.jdField_b_of_type_Int;
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
        j = this.this$0.i;
      }
      return i - j;
    }
    d();
    return -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = this.this$0.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = this.this$0.e;
    DragSortListView localDragSortListView = this.this$0;
    localDragSortListView.g = 2;
    this.jdField_a_of_type_Float = (localDragSortListView.a.y - a());
    this.jdField_b_of_type_Float = (this.this$0.a.x - this.this$0.getPaddingLeft());
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    int i = a();
    int j = this.this$0.getPaddingLeft();
    paramFloat1 = this.this$0.a.y - i;
    float f = this.this$0.a.x - j;
    paramFloat2 = 1.0F - paramFloat2;
    if ((paramFloat2 < Math.abs(paramFloat1 / this.jdField_a_of_type_Float)) || (paramFloat2 < Math.abs(f / this.jdField_b_of_type_Float)))
    {
      this.this$0.a.y = (i + (int)(this.jdField_a_of_type_Float * paramFloat2));
      this.this$0.a.x = (this.this$0.getPaddingLeft() + (int)(this.jdField_b_of_type_Float * paramFloat2));
      this.this$0.a(true);
    }
  }
  
  public void b()
  {
    DragSortListView.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.DropAnimator
 * JD-Core Version:    0.7.0.1
 */