package com.tencent.mobileqq.utils;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class SimpleModeHelper$3
  implements View.OnTouchListener
{
  float a = this.b.getAlpha();
  
  SimpleModeHelper$3(View paramView, GestureDetector paramGestureDetector) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.isEnabled())
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i != 1) && (i != 3)) {
          return false;
        }
        SimpleModeHelper.b = true;
        if (SimpleModeHelper.c)
        {
          paramView.setAlpha(this.a);
          return false;
        }
      }
      else
      {
        SimpleModeHelper.b = false;
        SimpleModeHelper.c = false;
        this.c.onTouchEvent(paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SimpleModeHelper.3
 * JD-Core Version:    0.7.0.1
 */