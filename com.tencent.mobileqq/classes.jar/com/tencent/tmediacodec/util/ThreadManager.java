package com.tencent.tmediacodec.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ThreadManager
{
  private static final Handler mHandler = new Handler(Looper.getMainLooper());
  private static final HandlerThread mHandlerThread;
  private static final ExecutorService mThreadPool = Executors.newCachedThreadPool();
  private static Handler sSubHandler = new Handler(mHandlerThread.getLooper());
  
  static
  {
    mHandlerThread = new HandlerThread("tmediacodec-sub");
    mHandlerThread.start();
  }
  
  public static void execute(@NonNull Runnable paramRunnable)
  {
    mThreadPool.execute(paramRunnable);
  }
  
  public static void postOnSubThread(@NonNull Runnable paramRunnable)
  {
    sSubHandler.post(paramRunnable);
  }
  
  public static void runOnSubThread(@NonNull Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      mThreadPool.execute(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  public static void runOnUiThread(@NonNull Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    mHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.util.ThreadManager
 * JD-Core Version:    0.7.0.1
 */