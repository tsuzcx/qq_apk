package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;

class VideoPlayerProxy$5
  implements Runnable
{
  VideoPlayerProxy$5(VideoPlayerProxy paramVideoPlayerProxy, int paramInt) {}
  
  public void run()
  {
    if (VideoPlayerProxy.access$600(this.this$0) != null) {
      VideoPlayerProxy.access$600(this.this$0).onStateChange(this.this$0.mID, this.val$newState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlayerProxy.5
 * JD-Core Version:    0.7.0.1
 */