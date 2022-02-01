package com.tencent.oskplayer.proxy;

import java.util.concurrent.CountDownLatch;

class VideoProxy$ProbeContentRequestListener
  implements VideoRequestManager.RequestListener
{
  CountDownLatch latch;
  public int mFlags = 0;
  String uuid;
  
  public VideoProxy$ProbeContentRequestListener(VideoProxy paramVideoProxy, String paramString, CountDownLatch paramCountDownLatch)
  {
    this.uuid = paramString;
    this.latch = paramCountDownLatch;
  }
  
  public int getFlag()
  {
    return this.mFlags;
  }
  
  public void onBeforeRequestRemove(VideoRequest paramVideoRequest)
  {
    if (paramVideoRequest.getUuid().equals(this.uuid))
    {
      this.mFlags = paramVideoRequest.getContentFormatFlag();
      this.latch.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy.ProbeContentRequestListener
 * JD-Core Version:    0.7.0.1
 */