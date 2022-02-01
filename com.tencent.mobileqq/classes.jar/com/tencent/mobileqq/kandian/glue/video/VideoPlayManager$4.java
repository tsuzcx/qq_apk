package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import java.util.Iterator;
import java.util.Set;

class VideoPlayManager$4
  implements Runnable
{
  VideoPlayManager$4(VideoPlayManager paramVideoPlayManager) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    VideoPlayManager.a((VideoPlayManager)localObject, VideoPlayManager.d((VideoPlayManager)localObject), VideoPlayManager.c(this.this$0), 7, null);
    if (VideoPlayManager.i(this.this$0) != null)
    {
      localObject = VideoPlayManager.i(this.this$0).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoPlayManager.VideoStatusListener localVideoStatusListener = (VideoPlayManager.VideoStatusListener)((Iterator)localObject).next();
        if (localVideoStatusListener != null) {
          localVideoStatusListener.a(VideoPlayManager.d(this.this$0), VideoPlayManager.j(this.this$0).c());
        }
      }
    }
    if (VideoPlayManager.d(this.this$0) != null)
    {
      VideoPlayManager.d(this.this$0).p = -1;
      VideoPlayManager.d(this.this$0).k = 0L;
      VideoPlayManager.a(this.this$0, null);
    }
    if (VideoPlayManager.c(this.this$0) != null)
    {
      VideoPlayManager.c(this.this$0).D();
      VideoPlayManager.b(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.4
 * JD-Core Version:    0.7.0.1
 */