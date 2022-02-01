package com.tencent.qqlive.module.videoreport.utils;

import android.os.Looper;

public class ThreadUtils
{
  public static boolean isMainThread()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */