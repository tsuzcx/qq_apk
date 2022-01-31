package com.tencent.superplayer.utils;

import android.os.Looper;

public class ThreadUtil
{
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
  
  public static void postRunnableOnMainThread(Runnable paramRunnable)
  {
    
    if (sMainThreadHandler != null) {
      sMainThreadHandler.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.utils.ThreadUtil
 * JD-Core Version:    0.7.0.1
 */