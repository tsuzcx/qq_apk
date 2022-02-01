package com.tencent.mobileqq.kandian.base.bandwidth;

import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;

class VideoBufferRangeController$1
  implements Runnable
{
  VideoBufferRangeController$1(VideoBufferRangeController paramVideoBufferRangeController, VideoPlayerWrapper paramVideoPlayerWrapper, int[] paramArrayOfInt, int paramInt) {}
  
  public void run()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.a;
    int[] arrayOfInt = this.b;
    localVideoPlayerWrapper.a(arrayOfInt[0], arrayOfInt[1], this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController.1
 * JD-Core Version:    0.7.0.1
 */