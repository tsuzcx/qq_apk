package com.tencent.oskplayer.proxy;

import java.util.concurrent.CountDownLatch;

final class VideoProxy$WaitRequestRunnable
  implements Runnable
{
  private CountDownLatch startSignal;
  
  public VideoProxy$WaitRequestRunnable(VideoProxy paramVideoProxy, CountDownLatch paramCountDownLatch)
  {
    this.startSignal = paramCountDownLatch;
  }
  
  public void run()
  {
    this.startSignal.countDown();
    VideoProxy.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy.WaitRequestRunnable
 * JD-Core Version:    0.7.0.1
 */