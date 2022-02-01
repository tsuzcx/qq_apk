package com.tencent.qav.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class ThreadManager
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("qav_sdk_thread_sub");
  private static Handler b = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  public static Handler a()
  {
    return jdField_a_of_type_AndroidOsHandler;
  }
  
  public static void a(Runnable paramRunnable)
  {
    b.post(paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    b.postDelayed(paramRunnable, paramLong);
  }
  
  public static Handler b()
  {
    return b;
  }
  
  public static void b(Runnable paramRunnable)
  {
    b.removeCallbacks(paramRunnable);
  }
  
  public static void c(Runnable paramRunnable)
  {
    jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qav.thread.ThreadManager
 * JD-Core Version:    0.7.0.1
 */