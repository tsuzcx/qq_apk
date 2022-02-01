package com.tencent.mobileqq.qqlive.utils;

import android.os.Handler;
import android.text.TextUtils;

public class ThreadCenter
{
  static ThreadCenter.ThreadImpl a = new ThreadCenter.ThreadImpl();
  public static boolean b = false;
  public static ThreadCenter.HandlerKeyable c = new ThreadCenter.1();
  
  public static Handler a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return a.a(paramString);
    }
    throw new RuntimeException("Thread name null!");
  }
  
  public static void a(ThreadCenter.HandlerKeyable paramHandlerKeyable)
  {
    a.a(paramHandlerKeyable);
  }
  
  public static void a(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable)
  {
    a.a(paramHandlerKeyable, paramRunnable, 0L, false);
  }
  
  public static void a(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable, long paramLong)
  {
    a.a(paramHandlerKeyable, paramRunnable, paramLong, false);
  }
  
  public static void b(ThreadCenter.HandlerKeyable paramHandlerKeyable, Runnable paramRunnable)
  {
    a.a(paramHandlerKeyable, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.utils.ThreadCenter
 * JD-Core Version:    0.7.0.1
 */