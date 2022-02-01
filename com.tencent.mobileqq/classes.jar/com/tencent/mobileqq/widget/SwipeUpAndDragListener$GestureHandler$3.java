package com.tencent.mobileqq.widget;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class SwipeUpAndDragListener$GestureHandler$3
  implements Runnable
{
  SwipeUpAndDragListener$GestureHandler$3(SwipeUpAndDragListener.GestureHandler paramGestureHandler, SwipeUpAndDragListener paramSwipeUpAndDragListener) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler.d != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler.d.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler.d.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler.b, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.GestureHandler.3
 * JD-Core Version:    0.7.0.1
 */