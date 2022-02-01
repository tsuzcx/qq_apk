package com.tencent.mtt.abtestsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class HandlerThreadUtil
{
  private static HandlerThread mHandlerThread;
  private static Handler mSingleHandler;
  
  public static Handler getHandler()
  {
    if (mSingleHandler == null) {
      init();
    }
    return mSingleHandler;
  }
  
  static Looper getLooper(int paramInt)
  {
    try
    {
      if (mHandlerThread != null)
      {
        mHandlerThread.quit();
        mHandlerThread = null;
      }
      mHandlerThread = new HandlerThread("GetDataThread", paramInt);
      mHandlerThread.start();
      Looper localLooper = mHandlerThread.getLooper();
      return localLooper;
    }
    finally {}
  }
  
  static void init()
  {
    try
    {
      Looper localLooper2 = getLooper(0);
      Looper localLooper1 = localLooper2;
      if (localLooper2 == null)
      {
        ABTestLog.warn("mThreadLooper is null in thread_priority_default", new Object[0]);
        localLooper1 = getLooper(-2);
      }
      mSingleHandler = new HandlerThreadUtil.1(localLooper1);
      return;
    }
    catch (Exception localException)
    {
      ABTestLog.error(localException.getMessage(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.HandlerThreadUtil
 * JD-Core Version:    0.7.0.1
 */