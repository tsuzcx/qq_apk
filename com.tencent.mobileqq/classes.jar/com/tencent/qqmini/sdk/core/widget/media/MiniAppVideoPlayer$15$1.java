package com.tencent.qqmini.sdk.core.widget.media;

import android.view.ViewGroup;
import android.view.ViewParent;

class MiniAppVideoPlayer$15$1
  implements Runnable
{
  MiniAppVideoPlayer$15$1(MiniAppVideoPlayer.15 param15) {}
  
  public void run()
  {
    ((CoverVideoView)this.a.this$0.getParent()).setLayoutParams(MiniAppVideoPlayer.a(this.a.this$0));
    if (this.a.this$0.getParent().getParent() != null) {
      ((ViewGroup)this.a.this$0.getParent().getParent()).scrollTo(0, MiniAppVideoPlayer.k(this.a.this$0));
    }
    this.a.this$0.D = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.15.1
 * JD-Core Version:    0.7.0.1
 */