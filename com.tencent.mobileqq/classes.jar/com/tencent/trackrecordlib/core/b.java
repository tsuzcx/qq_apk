package com.tencent.trackrecordlib.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;

public class b
  extends HandlerThread
{
  private static final String a = "HookThread";
  private static Handler b;
  private static MessageQueue c;
  private static Runnable d;
  private static boolean e = true;
  
  public b()
  {
    super("HookThread");
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    if (e)
    {
      boolean bool2 = false;
      e = false;
      d = null;
      Handler localHandler = b;
      boolean bool1 = bool2;
      if (localHandler != null)
      {
        bool1 = bool2;
        if (localHandler.post(paramRunnable)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    d = paramRunnable;
    return true;
  }
  
  private void c()
  {
    MessageQueue localMessageQueue = c;
    if ((localMessageQueue != null) && (b != null)) {
      localMessageQueue.addIdleHandler(new b.1(this));
    }
  }
  
  protected void onLooperPrepared()
  {
    super.onLooperPrepared();
    b = new Handler(Looper.myLooper());
    c = Looper.myQueue();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.b
 * JD-Core Version:    0.7.0.1
 */