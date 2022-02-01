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
    this.this$0.g = 1;
    this.jdField_a_of_type_Float = this.this$0.jdField_a_of_type_AndroidGraphicsPoint.x;
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      float f = this.this$0.getWidth() * 2.0F;
      if (this.this$0.f == 0.0F)
      {
        DragSortListView localDragSortListView = this.this$0;
        if (this.jdField_a_of_type_Float < 0.0F) {
          localDragSortListView.f = (i * f);
        }
      }
      do
      {
        return;
        i = 1;
        break;
        f *= 2.0F;
        if ((this.this$0.f < 0.0F) && (this.this$0.f > -f))
        {
          this.this$0.f = (-f);
          return;
        }
      } while ((this.this$0.f <= 0.0F) || (this.this$0.f >= f));
      this.this$0.f = f;
      return;
    }
    this.this$0.b();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = 1.0F - paramFloat2;
    int j = this.this$0.getFirstVisiblePosition();
    View localView = this.this$0.getChildAt(this.jdField_c_of_type_Int - j);
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      paramFloat2 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / 1000.0F;
      if (paramFloat2 != 0.0F) {}
    }
    do
    {
      do
      {
        return;
        float f1 = this.this$0.f;
        int k = this.this$0.getWidth();
        localObject = this.this$0;
        float f2 = ((DragSortListView)localObject).f;
        if (this.this$0.f > 0.0F) {}
        for (i = 1;; i = -1)
        {
          ((DragSortListView)localObject).f = (i * paramFloat2 * k + f2);
          this.jdField_a_of_type_Float += f1 * paramFloat2;
          this.this$0.jdField_a_of_type_AndroidGraphicsPoint.x = ((int)this.jdField_a_of_type_Float);
          if ((this.jdField_a_of_type_Float >= k) || (this.jdField_a_of_type_Float <= -k)) {
            break;
          }
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
          this.this$0.a(true);
          return;
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
          ((ViewGroup.LayoutParams)localObject).height = (i + this.jdField_a_of_type_Int);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      } while (this.d == this.jdField_c_of_type_Int);
      localView = this.this$0.getChildAt(this.d - j);
    } while (localView == null);
    if (this.jdField_b_of_type_Int == -1)
    {
      this.jdField_b_of_type_Int = DragSortListView.a(this.this$0, this.d, localView, false);
      this.jdField_c_of_type_Float = (localView.getHeight() - this.jdField_b_of_type_Int);
    }
    int i = Math.max((int)(this.jdField_c_of_type_Float * paramFloat1), 1);
    Object localObject = localView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (i + this.jdField_b_of_type_Int);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void b()
  {
    DragSortListView.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.RemoveAnimator
 * JD-Core Version:    0.7.0.1
 */