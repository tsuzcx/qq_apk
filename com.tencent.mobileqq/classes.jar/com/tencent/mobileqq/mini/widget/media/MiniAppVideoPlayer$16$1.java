package com.tencent.mobileqq.mini.widget.media;

import android.view.ViewGroup;
import android.view.ViewParent;

class MiniAppVideoPlayer$16$1
  implements Runnable
{
  MiniAppVideoPlayer$16$1(MiniAppVideoPlayer.16 param16) {}
  
  public void run()
  {
    ((CoverVideoView)this.this$1.this$0.getParent()).setLayoutParams(MiniAppVideoPlayer.access$4500(this.this$1.this$0));
    if (this.this$1.this$0.getParent().getParent() != null) {
      ((ViewGroup)this.this$1.this$0.getParent().getParent()).scrollTo(0, MiniAppVideoPlayer.access$4600(this.this$1.this$0));
    }
    this.this$1.this$0.isBusyInChangeScreen = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.16.1
 * JD-Core Version:    0.7.0.1
 */