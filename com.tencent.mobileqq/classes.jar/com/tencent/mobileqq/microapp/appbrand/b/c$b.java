package com.tencent.mobileqq.microapp.appbrand.b;

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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if (!c.e().isEmpty()) {
        ThreadManager.excute(new f(this), 64, null, false);
      }
    }
    else if ((c.b() != null) && (c.c() != null))
    {
      ThreadManager.excute(new e(this), 64, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.b.c.b
 * JD-Core Version:    0.7.0.1
 */