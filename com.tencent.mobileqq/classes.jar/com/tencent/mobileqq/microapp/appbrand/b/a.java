package com.tencent.mobileqq.microapp.appbrand.b;

import android.os.Handler;
import android.os.Looper;

public final class a
{
  private static Handler a = new Handler(Looper.getMainLooper());
  
  public static void a(Runnable paramRunnable)
  {
    a.post(paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    a.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.b.a
 * JD-Core Version:    0.7.0.1
 */