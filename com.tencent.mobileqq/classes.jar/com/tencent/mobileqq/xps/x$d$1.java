package com.tencent.mobileqq.xps;

import java.util.concurrent.CountDownLatch;

final class x$d$1
  implements Runnable
{
  x$d$1(String paramString, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    System.loadLibrary(this.a);
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.xps.x.d.1
 * JD-Core Version:    0.7.0.1
 */