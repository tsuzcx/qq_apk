package com.tencent.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Scroller;

class MovingView$1
  extends Handler
{
  MovingView$1(MovingView paramMovingView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (this.a.jdField_a_of_type_Boolean)
      {
        if (this.a.jdField_b_of_type_Boolean) {
          return;
        }
        if (this.a.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
        {
          int i = this.a.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
          int j = this.a.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
          int k = this.a.c;
          int m = this.a.d;
          paramMessage = this.a;
          paramMessage.c = i;
          paramMessage.d = j;
          paramMessage.jdField_a_of_type_Int += i - k;
          paramMessage = this.a;
          paramMessage.jdField_b_of_type_Int += j - m;
          this.a.invalidate();
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 40L);
          return;
        }
        this.a.a();
        return;
      }
      return;
    }
    if (paramMessage.what == 2) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.MovingView.1
 * JD-Core Version:    0.7.0.1
 */