package com.tencent.youtu.ytcommon.tools;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class YTThreadOperate
{
  private static ExecutorService mExecutorService = Executors.newFixedThreadPool(3);
  private static Handler mHandler = new Handler(Looper.getMainLooper());
  
  public static <T> Future<T> runOnSubThread(Callable<T> paramCallable)
  {
    return mExecutorService.submit(new YTThreadOperate.2(paramCallable));
  }
  
  public static void runOnSubThread(Runnable paramRunnable)
  {
    mExecutorService.submit(new YTThreadOperate.1(paramRunnable));
  }
  
  public static <T> void runOnSubThread(Callable<T> paramCallable, YTThreadOperate.UiThreadCallback<T> paramUiThreadCallback)
  {
    mExecutorService.submit(new YTThreadOperate.3(paramCallable, paramUiThreadCallback));
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    mHandler.post(paramRunnable);
  }
  
  public static void runOnUiThreadDelay(Runnable paramRunnable, long paramLong)
  {
    mHandler.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTThreadOperate
 * JD-Core Version:    0.7.0.1
 */