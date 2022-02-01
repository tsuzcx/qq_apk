package com.tencent.mobileqq.emosm.view;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class DragSortListView$RemoveAnimator
  extends DragSortListView.SmoothAnimator
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  
  public DragSortListView$RemoveAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
  }
  
  public void a()
  {
    int i = -1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = this.this$0.jdField_c_of_type_Int;
    this.d = this.this$0.d;
    this.e = this.this$0.e;
    DragSortListView localDragSortListView = this.this$0;
    localDragSortListView.g = 1;
    this.jdField_a_of_type_Float = localDragSortListView.jdField_a_of_type_AndroidGraphicsPoint.x;
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      float f1 = this.this$0.getWidth() * 2.0F;
      if (this.this$0.f == 0.0F)
      {
        localDragSortListView = this.this$0;
        if (this.jdField_a_of_type_Float >= 0.0F) {
          i = 1;
        }
        localDragSortListView.f = (i * f1);
        return;
      }
      f1 *= 2.0F;
      if (this.this$0.f < 0.0F)
      {
        float f2 = this.this$0.f;
        float f3 = -f1;
        if (f2 > f3)
        {
          this.this$0.f = f3;
          return;
        }
      }
      if ((this.this$0.f > 0.0F) && (this.this$0.f < f1)) {
        this.this$0.f = f1;
      }
    }
    else
    {
      this.this$0.b();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = 1.0F - paramFloat2;
    int j = this.this$0.getFirstVisiblePosition();
    View localView = this.this$0.getChildAt(this.jdField_c_of_type_Int - j);
    Object localObject;
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / 1000.0F;
      if (f1 == 0.0F) {
        return;
      }
      float f2 = this.this$0.f;
      int k = this.this$0.getWidth();
      localObject = this.this$0;
      float f3 = ((DragSortListView)localObject).f;
      if (this.this$0.f > 0.0F) {
        i = 1;
      } else {
        i = -1;
      }
      float f4 = i;
      paramFloat2 = k;
      ((DragSortListView)localObject).f = (f3 + f4 * f1 * paramFloat2);
      this.jdField_a_of_type_Float += f2 * f1;
      localObject = this.this$0.jdField_a_of_type_AndroidGraphicsPoint;
      f1 = this.jdField_a_of_type_Float;
      ((Point)localObject).x = ((int)f1);
      if ((f1 < paramFloat2) && (f1 > -k))
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        this.this$0.a(true);
        return;
      }
    }
    if (localView != null)
    {
      if (this.jdField_a_of_type_Int == -1)
      {
        this.jdField_a_of_type_Int = DragSortListView.a(this.this$0, this.jdField_c_of_type_Int, localView, false);
        this.jdField_b_of_type_Float = (localView.getHeight() - this.jdField_a_of_type_Int);
      }
      i = Math.max((int)(this.jdField_b_of_type_Float * paramFloat1), 1);
      localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (this.jdField_a_of_type_Int + i);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i = this.d;
    if (i != this.jdField_c_of_type_Int)
    {
      localView = this.this$0.getChildAt(i - j);
      if (localView != null)
      {
        if (this.jdField_b_of_type_Int == -1)
        {
          this.jdField_b_of_type_Int = DragSortListView.a(this.this$0, this.d, localView, false);
          this.jdField_c_of_type_Float = (localView.getHeight() - this.jdField_b_of_type_Int);
        }
        i = Math.max((int)(paramFloat1 * this.jdField_c_of_type_Float), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (this.jdField_b_of_type_Int + i);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void b()
  {
    DragSortListView.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.RemoveAnimator
 * JD-Core Version:    0.7.0.1
 */