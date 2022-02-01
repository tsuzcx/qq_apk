package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class aj
  extends Handler
{
  aj(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    try
    {
      ai.a();
      ai.b().sendEmptyMessageDelayed(1000, 3600000L);
      return;
    }
    catch (Throwable paramMessage)
    {
      for (;;)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.aj
 * JD-Core Version:    0.7.0.1
 */