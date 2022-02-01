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
      if (this.a.p)
      {
        if (this.a.q) {
          return;
        }
        if (this.a.m.computeScrollOffset())
        {
          int i = this.a.m.getCurrX();
          int j = this.a.m.getCurrY();
          int k = this.a.h;
          int m = this.a.i;
          paramMessage = this.a;
          paramMessage.h = i;
          paramMessage.i = j;
          paramMessage.f += i - k;
          paramMessage = this.a;
          paramMessage.g += j - m;
          this.a.invalidate();
          this.a.r.sendEmptyMessageDelayed(1, 40L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.MovingView.1
 * JD-Core Version:    0.7.0.1
 */