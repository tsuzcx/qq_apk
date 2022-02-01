package com.tencent.mobileqq.together.clockin;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class HasClockView$1
  implements View.OnTouchListener
{
  HasClockView$1(HasClockView paramHasClockView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return true;
        }
        HasClockView.a(this.a, 1.0F);
        return true;
      }
      HasClockView.a(this.a, 1.0F);
      this.a.a();
      return true;
    }
    HasClockView.a(this.a, 0.5F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.HasClockView.1
 * JD-Core Version:    0.7.0.1
 */