package com.tencent.timi.game.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class ThreadPool
{
  private static final Handler a = new Handler(ThreadManager.getSubThreadLooper());
  private static final Handler b = new Handler(Looper.getMainLooper());
  
  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    b.post(paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, int paramInt)
  {
    ThreadManager.excute(paramRunnable, paramInt, null, true);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return;
    }
    b.postDelayed(paramRunnable, paramLong);
  }
  
  public static void b(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    b.removeCallbacks(paramRunnable);
  }
  
  public static void c(Runnable paramRunnable)
  {
    a(paramRunnable, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.ThreadPool
 * JD-Core Version:    0.7.0.1
 */