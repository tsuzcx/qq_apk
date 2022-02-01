package com.tencent.mobileqq.qqgift.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class LongClickHandler$3
  implements View.OnTouchListener
{
  LongClickHandler$3(LongClickHandler paramLongClickHandler, LongClickHandler.OnLongClickListener paramOnLongClickListener) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((LongClickHandler.c(this.b)) && ((i == 1) || (i == 3)))
    {
      this.b.a();
      this.a.c(LongClickHandler.a(this.b));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.LongClickHandler.3
 * JD-Core Version:    0.7.0.1
 */