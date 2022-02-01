package com.tencent.mobileqq.kandian.biz.video;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class VideoExtractFrameTask$TaskHandler
  extends Handler
{
  public VideoExtractFrameTask$TaskHandler(VideoExtractFrameTask paramVideoExtractFrameTask, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (VideoExtractFrameTask.a(this.a) != null) {
      VideoExtractFrameTask.a(this.a).a(4, null, null, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoExtractFrameTask.TaskHandler
 * JD-Core Version:    0.7.0.1
 */