package com.tencent.ttpic.videoshelf.ui;

import android.os.Handler;
import android.os.Message;

class VideoShelfPlayView$1
  extends Handler
{
  VideoShelfPlayView$1(VideoShelfPlayView paramVideoShelfPlayView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.this$0.start();
      return;
    }
    this.this$0.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView.1
 * JD-Core Version:    0.7.0.1
 */