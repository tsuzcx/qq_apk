package com.tencent.ttpic.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class HandlerUtil
{
  public static void waitDone(Handler paramHandler)
  {
    if (paramHandler == null) {
      return;
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    HandlerUtil.1 local1 = new HandlerUtil.1(localCountDownLatch);
    if (Looper.myLooper() == paramHandler.getLooper()) {
      local1.run();
    }
    for (;;)
    {
      try
      {
        localCountDownLatch.await();
        return;
      }
      catch (InterruptedException paramHandler)
      {
        paramHandler.printStackTrace();
        return;
      }
      paramHandler.post(local1);
    }
  }
  
  public static void waitDone(Handler paramHandler, int paramInt)
  {
    if (paramHandler == null) {
      return;
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    HandlerUtil.2 local2 = new HandlerUtil.2(localCountDownLatch);
    if (Looper.myLooper() == paramHandler.getLooper()) {
      local2.run();
    }
    for (;;)
    {
      long l = paramInt;
      try
      {
        localCountDownLatch.await(l, TimeUnit.MILLISECONDS);
        return;
      }
      catch (InterruptedException paramHandler)
      {
        paramHandler.printStackTrace();
        return;
      }
      paramHandler.post(local2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.HandlerUtil
 * JD-Core Version:    0.7.0.1
 */