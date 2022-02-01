package org.light.utils;

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
    } else {
      paramHandler.post(local1);
    }
    try
    {
      localCountDownLatch.await();
      return;
    }
    catch (InterruptedException paramHandler)
    {
      paramHandler.printStackTrace();
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
    } else {
      paramHandler.post(local2);
    }
    long l = paramInt;
    try
    {
      localCountDownLatch.await(l, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException paramHandler)
    {
      paramHandler.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.utils.HandlerUtil
 * JD-Core Version:    0.7.0.1
 */