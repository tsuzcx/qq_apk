package com.tencent.mobileqq.flashshow.player.widget;

import android.widget.SeekBar;

class FSBaseVideoView$2
  implements Runnable
{
  FSBaseVideoView$2(FSBaseVideoView paramFSBaseVideoView, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.getProgressBar() != null) {
      this.this$0.getProgressBar().setProgress(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.widget.FSBaseVideoView.2
 * JD-Core Version:    0.7.0.1
 */