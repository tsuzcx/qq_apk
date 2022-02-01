package com.tencent.mobileqq.winkpublish.player.widget;

import android.widget.SeekBar;

class PublishBaseVideoView$2
  implements Runnable
{
  PublishBaseVideoView$2(PublishBaseVideoView paramPublishBaseVideoView, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.getProgressBar() != null) {
      this.this$0.getProgressBar().setProgress(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.widget.PublishBaseVideoView.2
 * JD-Core Version:    0.7.0.1
 */