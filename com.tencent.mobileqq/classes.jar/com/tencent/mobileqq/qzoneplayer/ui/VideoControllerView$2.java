package com.tencent.mobileqq.qzoneplayer.ui;

import android.widget.TextView;

class VideoControllerView$2
  implements Runnable
{
  VideoControllerView$2(VideoControllerView paramVideoControllerView, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mPlayer == null) {
      return;
    }
    if (VideoControllerView.access$000(this.this$0) != null)
    {
      String str = this.this$0.mPlayer.time2str(this.this$0.mVideoDuration);
      VideoControllerView.access$000(this.this$0).setText(str);
    }
    if (VideoControllerView.access$100(this.this$0) != null) {
      VideoControllerView.access$100(this.this$0).setText(this.this$0.mPlayer.time2str(this.val$position2));
    }
    this.this$0.updatePausePlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.2
 * JD-Core Version:    0.7.0.1
 */