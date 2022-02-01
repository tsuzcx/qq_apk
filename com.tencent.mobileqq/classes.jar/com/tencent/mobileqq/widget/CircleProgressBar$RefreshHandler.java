package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;

class CircleProgressBar$RefreshHandler
  extends Handler
{
  CircleProgressBar$RefreshHandler(CircleProgressBar paramCircleProgressBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10000) {
      return;
    }
    paramMessage = this.a;
    paramMessage.i += 3;
    this.a.postInvalidate();
    if (this.a.a) {
      sendEmptyMessageDelayed(10000, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgressBar.RefreshHandler
 * JD-Core Version:    0.7.0.1
 */