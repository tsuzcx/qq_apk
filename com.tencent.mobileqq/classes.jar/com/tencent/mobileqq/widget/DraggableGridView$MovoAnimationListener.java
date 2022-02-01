package com.tencent.mobileqq.widget;

import android.graphics.Point;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.GridView;
import com.tencent.widget.ListView;

class DraggableGridView$MovoAnimationListener
  implements Animation.AnimationListener
{
  private int jdField_a_of_type_Int = 0;
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private boolean jdField_a_of_type_Boolean;
  private Point b;
  
  public DraggableGridView$MovoAnimationListener(DraggableGridView paramDraggableGridView, Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(paramPoint1);
    this.b = new Point(paramPoint2);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = 0;
    DraggableGridView.b(paramDraggableGridView, true);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = this.jdField_a_of_type_Int - 1;
    this.jdField_a_of_type_Int = i;
    if (i <= 0)
    {
      i = 0;
      while (i < DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).getChildCount())
      {
        paramAnimation = DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).getChildAt(i);
        if ((paramAnimation instanceof MeasureGridView))
        {
          paramAnimation = (GridView)paramAnimation;
          int j = 0;
          while (j < paramAnimation.getChildCount())
          {
            paramAnimation.getChildAt(j).clearAnimation();
            if ((((Integer)paramAnimation.getTag()).intValue() == DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).y) && (j == DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).x) && (!this.jdField_a_of_type_Boolean)) {
              paramAnimation.getChildAt(j).setVisibility(4);
            } else {
              paramAnimation.getChildAt(j).setVisibility(0);
            }
            j += 1;
          }
        }
        i += 1;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(this.jdField_a_of_type_AndroidGraphicsPoint.y, this.jdField_a_of_type_AndroidGraphicsPoint.x);
        DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).set(-1, -1);
      }
      else
      {
        DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(this.jdField_a_of_type_AndroidGraphicsPoint.y, this.jdField_a_of_type_AndroidGraphicsPoint.x, this.b.y, this.b.x);
      }
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).notifyDataSetChanged();
      DraggableGridView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView, false);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView.MovoAnimationListener
 * JD-Core Version:    0.7.0.1
 */