package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.util.LogUtil;

class VideoPlayerProxy$4
  implements Runnable
{
  VideoPlayerProxy$4(VideoPlayerProxy paramVideoPlayerProxy) {}
  
  public void run()
  {
    if (VideoPlayerProxy.access$400(this.this$0) == null)
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(this.this$0.getLogTag(), 2, "mVideoView == null, createVideoView.  ");
      }
      VideoPlayerProxy.access$402(this.this$0, VideoPlayerProxy.access$500(this.this$0));
    }
    this.this$0.changeState(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlayerProxy.4
 * JD-Core Version:    0.7.0.1
 */