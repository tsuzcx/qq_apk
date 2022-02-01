package com.tencent.qqmini.sdk.widget.media;

import android.view.ViewGroup;
import android.view.ViewParent;

class IVideoPlayerUIImpl$1
  implements Runnable
{
  IVideoPlayerUIImpl$1(IVideoPlayerUIImpl paramIVideoPlayerUIImpl, MiniAppVideoConfig paramMiniAppVideoConfig) {}
  
  public void run()
  {
    ((CoverVideoView)this.this$0.getParent()).setLayoutParams(IVideoPlayerUIImpl.access$000(this.this$0));
    if (this.this$0.getParent().getParent() != null) {
      ((ViewGroup)this.this$0.getParent().getParent()).scrollTo(0, IVideoPlayerUIImpl.access$100(this.this$0));
    }
    this.val$config.isBusyInChangeScreen = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.IVideoPlayerUIImpl.1
 * JD-Core Version:    0.7.0.1
 */