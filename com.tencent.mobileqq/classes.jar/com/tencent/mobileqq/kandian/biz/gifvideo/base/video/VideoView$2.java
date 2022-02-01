package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class VideoView$2
  extends Handler
{
  VideoView$2(VideoView paramVideoView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != -2) {
      return;
    }
    if ((VideoView.access$300(this.a) != null) && (!VideoView.access$300(this.a).a())) {
      this.a.updateSeekBarImmediately();
    }
    this.a.postPlayProgressMessage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView.2
 * JD-Core Version:    0.7.0.1
 */