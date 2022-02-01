package com.tencent.mobileqq.conditionsearch.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class TimeSelectView$2
  implements View.OnTouchListener
{
  TimeSelectView$2(TimeSelectView paramTimeSelectView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.2
 * JD-Core Version:    0.7.0.1
 */