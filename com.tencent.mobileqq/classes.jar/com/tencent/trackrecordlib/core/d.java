package com.tencent.trackrecordlib.core;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class d
  extends Thread
{
  public static final int a = 1001;
  private static final String b = "RecordThread";
  private static Handler c;
  
  public static boolean a(Message paramMessage)
  {
    return (c != null) && (c.sendMessage(paramMessage));
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    return (c != null) && (c.post(paramRunnable));
  }
  
  @SuppressLint({"HandlerLeak"})
  public void run()
  {
    if (Looper.myLooper() == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Looper.prepare();
      }
      c = new d.1(this);
      if (i != 0) {
        Looper.loop();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.d
 * JD-Core Version:    0.7.0.1
 */