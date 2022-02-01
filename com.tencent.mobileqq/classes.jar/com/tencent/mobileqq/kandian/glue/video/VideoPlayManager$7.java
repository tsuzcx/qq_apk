package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class VideoPlayManager$7
  implements Runnable
{
  VideoPlayManager$7(VideoPlayManager paramVideoPlayManager, VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (VideoPlayManager.k(this.this$0) != null)
    {
      Iterator localIterator = VideoPlayManager.k(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        OnPlayStateListener localOnPlayStateListener = (OnPlayStateListener)localIterator.next();
        if (localOnPlayStateListener != null) {
          localOnPlayStateListener.a(this.a, this.b, this.c, this.d, this.e);
        }
      }
    }
    VideoPlayManager.a(this.this$0, this.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.7
 * JD-Core Version:    0.7.0.1
 */