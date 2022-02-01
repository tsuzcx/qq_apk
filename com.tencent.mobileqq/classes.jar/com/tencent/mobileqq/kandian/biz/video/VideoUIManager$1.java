package com.tencent.mobileqq.kandian.biz.video;

import android.os.Handler;
import android.os.Message;

class VideoUIManager$1
  extends Handler
{
  VideoUIManager$1(VideoUIManager paramVideoUIManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 105: 
      VideoUIManager.e(this.a);
      return;
    case 104: 
      VideoUIManager.d(this.a);
      return;
    case 103: 
      VideoUIManager.a(this.a, 3);
      return;
    case 102: 
      VideoUIManager.b(this.a);
      sendEmptyMessageDelayed(102, 1000L);
      if (VideoUIManager.a(this.a) == 1)
      {
        VideoUIManager.c(this.a);
        return;
      }
      break;
    case 101: 
      this.a.l();
      return;
    case 100: 
      VideoUIManager.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager.1
 * JD-Core Version:    0.7.0.1
 */