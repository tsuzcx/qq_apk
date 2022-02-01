package com.tencent.mobileqq.widget;

import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.pic.Logger;

class SwipeUpAndDragListener$GestureHandler$4
  implements Runnable
{
  SwipeUpAndDragListener$GestureHandler$4(SwipeUpAndDragListener.GestureHandler paramGestureHandler, SwipeUpAndDragListener paramSwipeUpAndDragListener) {}
  
  public void run()
  {
    this.b.G.i.e = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mPanel.mDisableGuestrueSend = ");
    localStringBuilder.append(this.b.G.i.e);
    Logger.a("PhotoListPanel", "enableGuestrue", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.GestureHandler.4
 * JD-Core Version:    0.7.0.1
 */