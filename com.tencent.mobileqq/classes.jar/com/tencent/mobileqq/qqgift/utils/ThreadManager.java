package com.tencent.mobileqq.qqgift.utils;

public class ThreadManager
{
  static ThreadManager.ThreadImpl a = new ThreadManager.ThreadImpl();
  public static boolean b = false;
  public static ThreadManager.HandlerKeyable c = new ThreadManager.1();
  
  public static void a(Runnable paramRunnable)
  {
    a.a(c, paramRunnable, 0L, false);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    a.a(c, paramRunnable, paramLong, false);
  }
  
  public static void a(Runnable paramRunnable, boolean paramBoolean)
  {
    a.a(paramRunnable, 0L, paramBoolean, null);
  }
  
  public static void b(Runnable paramRunnable)
  {
    a.a(c, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.ThreadManager
 * JD-Core Version:    0.7.0.1
 */