package com.tencent.mobileqq.widget;

import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.pic.Logger;

class SwipeUpAndDragListener$GestureHandler$4
  implements Runnable
{
  SwipeUpAndDragListener$GestureHandler$4(SwipeUpAndDragListener.GestureHandler paramGestureHandler, SwipeUpAndDragListener paramSwipeUpAndDragListener) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler.b.a.a = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPanel.mDisableGuestrueSend = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$GestureHandler.b.a.a);
    Logger.a("PhotoListPanel", "enableGuestrue", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.GestureHandler.4
 * JD-Core Version:    0.7.0.1
 */