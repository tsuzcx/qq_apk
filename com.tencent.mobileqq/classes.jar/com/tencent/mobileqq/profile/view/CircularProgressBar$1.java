package com.tencent.mobileqq.profile.view;

import android.os.Handler;
import android.os.Message;

class CircularProgressBar$1
  extends Handler
{
  CircularProgressBar$1(CircularProgressBar paramCircularProgressBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    this.a.invalidate();
    if (CircularProgressBar.a(this.a))
    {
      paramMessage = this.a;
      CircularProgressBar.a(paramMessage, CircularProgressBar.b(paramMessage) + CircularProgressBar.c(this.a));
      if (CircularProgressBar.b(this.a) > 360) {
        CircularProgressBar.a(this.a, 0);
      }
      CircularProgressBar.e(this.a).sendEmptyMessageDelayed(0, CircularProgressBar.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.CircularProgressBar.1
 * JD-Core Version:    0.7.0.1
 */