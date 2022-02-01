package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.util.RegisterTVideoUtil;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

class VideoPlaySDKManager$1$1
  implements Runnable
{
  VideoPlaySDKManager$1$1(VideoPlaySDKManager.1 param1) {}
  
  public void run()
  {
    VideoPlaySDKManager.access$100(this.this$1.this$0, this.this$1.val$context, this.this$1.val$option);
    RegisterTVideoUtil.registerTVideo();
    VideoPlaySDKManager.access$200(this.this$1.this$0).set(2);
    if (VideoPlaySDKManager.access$300(this.this$1.this$0) != null)
    {
      Iterator localIterator = VideoPlaySDKManager.access$300(this.this$1.this$0).iterator();
      while (localIterator.hasNext()) {
        ((SDKInitListener)localIterator.next()).onSDKInited(true);
      }
      VideoPlaySDKManager.access$300(this.this$1.this$0).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlaySDKManager.1.1
 * JD-Core Version:    0.7.0.1
 */