package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$3
  implements Runnable
{
  VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$3(VideoFeedsPlayManager.MediaPlayListenerAdapterImpl paramMediaPlayListenerAdapterImpl) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.b(this.a.a) != null) && (VideoFeedsPlayManager.b(this.a.a).o != null)) {
      VideoFeedsPlayManager.b(this.a.a).o.i(VideoFeedsPlayManager.b(this.a.a));
    }
    if (VideoFeedsPlayManager.g(this.a.a) != null)
    {
      Iterator localIterator = VideoFeedsPlayManager.g(this.a.a).iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).d(VideoFeedsPlayManager.b(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.3
 * JD-Core Version:    0.7.0.1
 */