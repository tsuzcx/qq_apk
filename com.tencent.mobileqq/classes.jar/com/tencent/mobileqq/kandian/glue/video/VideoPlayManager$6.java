package com.tencent.mobileqq.kandian.glue.video;

import java.util.Iterator;
import java.util.Set;

class VideoPlayManager$6
  implements Runnable
{
  VideoPlayManager$6(VideoPlayManager paramVideoPlayManager) {}
  
  public void run()
  {
    if (VideoPlayManager.i(this.this$0) != null)
    {
      Iterator localIterator = VideoPlayManager.i(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        VideoPlayManager.VideoStatusListener localVideoStatusListener = (VideoPlayManager.VideoStatusListener)localIterator.next();
        if (localVideoStatusListener != null) {
          localVideoStatusListener.a(VideoPlayManager.d(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.6
 * JD-Core Version:    0.7.0.1
 */