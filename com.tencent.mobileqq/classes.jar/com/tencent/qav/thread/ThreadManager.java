package com.tencent.qav.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class ThreadManager
{
  private static HandlerThread a = new HandlerThread("qav_sdk_thread_sub");
  private static Handler b = new Handler(Looper.getMainLooper());
  private static Handler c = new Handler(a.getLooper());
  
  static
  {
    a.start();
  }
  
  public static Handler a()
  {
    return b;
  }
  
  public static void a(Runnable paramRunnable)
  {
    c.post(paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    c.postDelayed(paramRunnable, paramLong);
  }
  
  public static Handler b()
  {
    return c;
  }
  
  public static void b(Runnable paramRunnable)
  {
    c.removeCallbacks(paramRunnable);
  }
  
  public static void b(Runnable paramRunnable, long paramLong)
  {
    b.postDelayed(paramRunnable, paramLong);
  }
  
  public static void c(Runnable paramRunnable)
  {
    b.post(paramRunnable);
  }
  
  public static void d(Runnable paramRunnable)
  {
    b.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qav.thread.ThreadManager
 * JD-Core Version:    0.7.0.1
 */