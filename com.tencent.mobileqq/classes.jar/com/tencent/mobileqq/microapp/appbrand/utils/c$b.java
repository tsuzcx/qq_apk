package com.tencent.mobileqq.microapp.appbrand.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.LinkedBlockingQueue;

final class c$b
  extends Handler
{
  private c$b(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((c.c() == null) || (c.d() == null));
      ThreadManager.excute(new e(this), 64, null, false);
      return;
    } while (c.f().isEmpty());
    ThreadManager.excute(new f(this), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.utils.c.b
 * JD-Core Version:    0.7.0.1
 */