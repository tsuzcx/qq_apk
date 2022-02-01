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
    if (this.b.A != null)
    {
      this.b.A.clearAnimation();
      this.b.A.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.b.E, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.GestureHandler.3
 * JD-Core Version:    0.7.0.1
 */