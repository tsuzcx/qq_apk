package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.superplayer.api.ISuperPlayer;

class VideoPlayerProxy$1
  implements Runnable
{
  VideoPlayerProxy$1(VideoPlayerProxy paramVideoPlayerProxy, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (VideoPlayerProxy.access$000(this.this$0) != null)
      {
        if (this.val$recordPos)
        {
          long l = (int)VideoPlayerProxy.access$000(this.this$0).getCurrentPositionMs();
          if (LogUtil.isColorLevel()) {
            LogUtil.d(this.this$0.getLogTag(), 2, "releasePlayer,record play pos = " + l);
          }
          if (VideoPlayerProxy.access$100(this.this$0) != null) {
            VideoPlayerProxy.access$100(this.this$0).mLastPlayPosMs = l;
          }
        }
        VideoPlayerProxy.access$000(this.this$0).stop();
        VideoPlayerProxy.access$000(this.this$0).release();
        VideoPlayerProxy.access$002(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlayerProxy.1
 * JD-Core Version:    0.7.0.1
 */