package com.tencent.mobileqq.mini.widget.media;

import android.view.ViewGroup;
import android.view.ViewParent;

class MiniAppVideoPlayer$17$1
  implements Runnable
{
  MiniAppVideoPlayer$17$1(MiniAppVideoPlayer.17 param17) {}
  
  public void run()
  {
    ((CoverVideoView)this.this$1.this$0.getParent()).setLayoutParams(MiniAppVideoPlayer.access$4800(this.this$1.this$0));
    if (this.this$1.this$0.getParent().getParent() != null) {
      ((ViewGroup)this.this$1.this$0.getParent().getParent()).scrollTo(0, MiniAppVideoPlayer.access$4900(this.this$1.this$0));
    }
    this.this$1.this$0.isBusyInChangeScreen = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.17.1
 * JD-Core Version:    0.7.0.1
 */