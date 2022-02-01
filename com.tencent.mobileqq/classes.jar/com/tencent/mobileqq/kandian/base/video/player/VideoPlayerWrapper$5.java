package com.tencent.mobileqq.kandian.base.video.player;

import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import java.util.concurrent.atomic.AtomicInteger;

class VideoPlayerWrapper$5
  implements Runnable
{
  VideoPlayerWrapper$5(VideoPlayerWrapper paramVideoPlayerWrapper, boolean paramBoolean) {}
  
  public void run()
  {
    if ((VideoPlayerWrapper.c(this.this$0) != null) && (VideoPlayerWrapper.d(this.this$0).get() != 6) && (VideoPlayerWrapper.d(this.this$0).get() != 8)) {
      VideoPlayerWrapper.c(this.this$0).b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper.5
 * JD-Core Version:    0.7.0.1
 */