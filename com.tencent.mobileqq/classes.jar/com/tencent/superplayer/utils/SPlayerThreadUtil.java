package com.tencent.superplayer.utils;

import android.os.Looper;

public class SPlayerThreadUtil
{
  private static volatile SPlayerThreadUtil.EventHandler mMainThreadHandler = null;
  
  private static void getMainThreadHandler()
  {
    if (mMainThreadHandler == null) {
      try
      {
        if (mMainThreadHandler == null)
        {
          Looper localLooper = Looper.getMainLooper();
          if (localLooper != null) {
            mMainThreadHandler = new SPlayerThreadUtil.EventHandler(localLooper);
          }
        }
        else
        {
          return;
        }
        mMainThreadHandler = null;
        throw new IllegalStateException("cannot get thread looper");
      }
      finally {}
    }
  }
  
  public static void postRunnableOnMainThread(Runnable paramRunnable)
  {
    
    if (mMainThreadHandler != null) {
      mMainThreadHandler.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.SPlayerThreadUtil
 * JD-Core Version:    0.7.0.1
 */