package com.tencent.weseevideo.editor.utils;

import android.os.Handler;
import android.os.Looper;

public class HandlerUtils
{
  private static Handler mMainHandler;
  private static final Object mMainHandlerLock = new Object();
  
  public static Handler getMainHandler()
  {
    if (mMainHandler == null) {
      synchronized (mMainHandlerLock)
      {
        if (mMainHandler == null) {
          mMainHandler = new Handler(Looper.getMainLooper());
        }
      }
    }
    return mMainHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.utils.HandlerUtils
 * JD-Core Version:    0.7.0.1
 */