package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class ReadInJoyCardViewCostBall$SuspendedBallTouchListener
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  private ReadInJoyCardViewCostBall$SuspendedBallTouchListener(ReadInJoyCardViewCostBall paramReadInJoyCardViewCostBall) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i == 2))
      {
        ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCardViewCostBall).x = (this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float - paramMotionEvent.getRawX()));
        ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCardViewCostBall).y = (this.jdField_b_of_type_Int + (int)(paramMotionEvent.getRawY() - this.jdField_b_of_type_Float));
        ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCardViewCostBall).updateViewLayout(paramView, ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCardViewCostBall));
      }
    }
    else
    {
      this.jdField_a_of_type_Int = ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCardViewCostBall).x;
      this.jdField_b_of_type_Int = ReadInJoyCardViewCostBall.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCardViewCostBall).y;
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyCardViewCostBall.SuspendedBallTouchListener
 * JD-Core Version:    0.7.0.1
 */