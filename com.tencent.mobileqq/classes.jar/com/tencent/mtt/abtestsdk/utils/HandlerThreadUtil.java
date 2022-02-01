package com.tencent.mtt.abtestsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;

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
  
  private static void init()
  {
    mHandlerThread = new HandlerThread("GetDataThread");
    mHandlerThread.start();
    mSingleHandler = new HandlerThreadUtil.1(mHandlerThread.getLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.HandlerThreadUtil
 * JD-Core Version:    0.7.0.1
 */