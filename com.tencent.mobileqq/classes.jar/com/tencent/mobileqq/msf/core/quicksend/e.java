package com.tencent.mobileqq.msf.core.quicksend;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class e
  extends Handler
{
  e(d paramd, Looper paramLooper)
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
      d.a(this.a);
    }
    catch (Throwable paramMessage)
    {
      paramMessage.printStackTrace();
    }
    d.b(this.a).sendEmptyMessageDelayed(1000, 1800000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.e
 * JD-Core Version:    0.7.0.1
 */