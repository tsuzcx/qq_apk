package com.tencent.webbundle.sdk;

import android.os.Handler;
import android.os.Looper;

public class ThreadManager
{
  private static volatile Handler sUiHandler;
  
  static void checkMainThread(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" need to be invoke in main thread.");
    throw new IllegalThreadStateException(localStringBuilder.toString());
  }
  
  static void executeOnUiThread(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    getUiHandler().postAtFrontOfQueue(paramRunnable);
  }
  
  public static Handler getUiHandler()
  {
    if (sUiHandler == null) {
      try
      {
        if (sUiHandler == null) {
          sUiHandler = new Handler(Looper.getMainLooper());
        }
      }
      finally {}
    }
    return sUiHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.webbundle.sdk.ThreadManager
 * JD-Core Version:    0.7.0.1
 */