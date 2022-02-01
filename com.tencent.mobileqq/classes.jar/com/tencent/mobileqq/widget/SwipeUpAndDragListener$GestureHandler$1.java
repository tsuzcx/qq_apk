package com.tencent.mobileqq.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

class SwipeUpAndDragListener$GestureHandler$1
  implements View.OnTouchListener
{
  SwipeUpAndDragListener$GestureHandler$1(SwipeUpAndDragListener.GestureHandler paramGestureHandler, SwipeUpAndDragListener paramSwipeUpAndDragListener) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.GestureHandler.1
 * JD-Core Version:    0.7.0.1
 */