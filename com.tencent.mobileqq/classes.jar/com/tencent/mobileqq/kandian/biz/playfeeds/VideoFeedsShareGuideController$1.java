package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Handler;
import android.os.Message;

class VideoFeedsShareGuideController$1
  extends Handler
{
  VideoFeedsShareGuideController$1(VideoFeedsShareGuideController paramVideoFeedsShareGuideController) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        VideoFeedsShareGuideController.b(this.a);
      }
    }
    else if ((VideoFeedsShareGuideController.a(this.a) != null) && (VideoFeedsShareGuideController.a(this.a) != null)) {
      VideoFeedsShareGuideController.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareGuideController.1
 * JD-Core Version:    0.7.0.1
 */