package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ak
  extends Handler
{
  ak(Looper paramLooper)
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
      aj.a();
    }
    catch (Throwable paramMessage)
    {
      paramMessage.printStackTrace();
    }
    aj.b().sendEmptyMessageDelayed(1000, 3600000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ak
 * JD-Core Version:    0.7.0.1
 */