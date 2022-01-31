package com.tencent.oskplayer.proxy;

import java.util.concurrent.CountDownLatch;

class VideoProxy$2
  implements VideoCancelListener
{
  VideoProxy$2(VideoProxy paramVideoProxy, CountDownLatch paramCountDownLatch) {}
  
  public void onVideoCancelProceed(VideoRequest paramVideoRequest, int paramInt) {}
  
  public void onVideoCancelStart(VideoRequest paramVideoRequest) {}
  
  public void onVideoCancelSuccess(VideoRequest paramVideoRequest)
  {
    this.val$cancelSuccessSignal.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy.2
 * JD-Core Version:    0.7.0.1
 */