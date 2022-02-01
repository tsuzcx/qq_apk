package com.tencent.mobileqq.msf.core.quicksend;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class f
  extends Handler
{
  f(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1000) {
      return;
    }
    try
    {
      e.a(this.a);
    }
    catch (Throwable paramMessage)
    {
      paramMessage.printStackTrace();
    }
    e.b(this.a).sendEmptyMessageDelayed(1000, 1800000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.f
 * JD-Core Version:    0.7.0.1
 */