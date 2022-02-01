package com.tencent.mobileqq.kandian.biz.video;

import android.os.Handler;
import android.os.Message;

class VideoUIManager$2
  extends Handler
{
  VideoUIManager$2(VideoUIManager paramVideoUIManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 105: 
      VideoUIManager.g(this.a);
      return;
    case 104: 
      VideoUIManager.f(this.a);
      return;
    case 103: 
      VideoUIManager.a(this.a, 3);
      return;
    case 102: 
      VideoUIManager.c(this.a);
      sendEmptyMessageDelayed(102, 1000L);
      if (VideoUIManager.d(this.a) == 1)
      {
        VideoUIManager.e(this.a);
        return;
      }
      break;
    case 101: 
      this.a.t();
      return;
    case 100: 
      VideoUIManager.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager.2
 * JD-Core Version:    0.7.0.1
 */