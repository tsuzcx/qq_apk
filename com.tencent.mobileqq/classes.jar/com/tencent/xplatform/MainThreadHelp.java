package com.tencent.xplatform;

import android.os.Handler;
import android.os.Looper;

public class MainThreadHelp
{
  public static native void nativeProcessTask(long paramLong);
  
  public static void postRunnable(Runnable paramRunnable)
  {
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  public static void postTask(long paramLong)
  {
    new Handler(Looper.getMainLooper()).post(new MainThreadHelp.1(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xplatform.MainThreadHelp
 * JD-Core Version:    0.7.0.1
 */