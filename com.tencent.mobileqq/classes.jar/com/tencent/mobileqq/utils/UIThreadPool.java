package com.tencent.mobileqq.utils;

import ajsb;

public class UIThreadPool
{
  private static ajsb a;
  
  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (a == null) {
      a = new ajsb(3, 10L);
    }
    a.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.UIThreadPool
 * JD-Core Version:    0.7.0.1
 */