package com.tencent.superplayer.utils;

import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtil
{
  private static final ExecutorService mThreadPool = Executors.newCachedThreadPool();
  private static volatile ThreadUtil.EventHandler sMainThreadHandler = null;
  
  private static void getMainThreadHandler()
  {
    if (sMainThreadHandler == null) {
      try
      {
        if (sMainThreadHandler == null)
        {
          Looper localLooper = Looper.getMainLooper();
          if (localLooper != null) {
            sMainThreadHandler = new ThreadUtil.EventHandler(localLooper);
          }
        }
        else
        {
          return;
        }
        sMainThreadHandler = null;
        throw new IllegalStateException("cannot get thread looper");
      }
      finally {}
    }
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
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    
    if (sMainThreadHandler != null) {
      sMainThreadHandler.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.ThreadUtil
 * JD-Core Version:    0.7.0.1
 */