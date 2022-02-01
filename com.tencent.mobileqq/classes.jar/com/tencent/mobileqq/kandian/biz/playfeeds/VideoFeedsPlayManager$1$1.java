package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsPlayManager$1$1
  implements Runnable
{
  VideoFeedsPlayManager$1$1(VideoFeedsPlayManager.1 param1) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.a.a) != null) && (VideoFeedsPlayManager.a(this.a.a).a != null)) {
      VideoFeedsPlayManager.a(this.a.a).a.i(VideoFeedsPlayManager.a(this.a.a));
    }
    if (VideoFeedsPlayManager.a(this.a.a) != null)
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a.a).iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).d(VideoFeedsPlayManager.a(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.1.1
 * JD-Core Version:    0.7.0.1
 */