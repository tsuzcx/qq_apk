package com.tencent.ttpic.util;

import java.util.concurrent.CountDownLatch;

final class HandlerUtil$2
  implements Runnable
{
  HandlerUtil$2(CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    this.val$waitDoneLock.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.HandlerUtil.2
 * JD-Core Version:    0.7.0.1
 */