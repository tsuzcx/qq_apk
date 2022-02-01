package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Handler;
import android.os.Message;

class VideoFeedsGuideView$AnimateHandler
  extends Handler
{
  private VideoFeedsGuideView$AnimateHandler(VideoFeedsGuideView paramVideoFeedsGuideView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return;
    }
    VideoFeedsGuideView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGuideView.AnimateHandler
 * JD-Core Version:    0.7.0.1
 */