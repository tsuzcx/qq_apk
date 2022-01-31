package com.tencent.mobileqq.videoplatform;

import bbwe;
import bbwh;
import bbwi;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

class VideoPlaySDKManager$1$1$1
  implements Runnable
{
  VideoPlaySDKManager$1$1$1(VideoPlaySDKManager.1.1 param1) {}
  
  public void run()
  {
    bbwh.a(this.a.a.a).set(2);
    if (bbwh.a() != null)
    {
      Iterator localIterator = bbwh.a().iterator();
      while (localIterator.hasNext()) {
        ((bbwe)localIterator.next()).a(true);
      }
      bbwh.a().clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlaySDKManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */