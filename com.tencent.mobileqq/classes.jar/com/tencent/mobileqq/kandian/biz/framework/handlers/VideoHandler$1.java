package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;

class VideoHandler$1
  implements Runnable
{
  VideoHandler$1(VideoHandler paramVideoHandler) {}
  
  public void run()
  {
    VideoVolumeControl.getInstance().setshouldIgnoreVolumeReceiver(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.1
 * JD-Core Version:    0.7.0.1
 */