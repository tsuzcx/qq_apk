package com.tencent.ttpic.videoshelf.ui;

import android.os.Handler;
import android.os.Message;

class VideoShelfPlayView$1
  extends Handler
{
  VideoShelfPlayView$1(VideoShelfPlayView paramVideoShelfPlayView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      this.this$0.flush();
      return;
    }
    this.this$0.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView.1
 * JD-Core Version:    0.7.0.1
 */