package com.tencent.qqmini.miniapp.widget.media;

import android.view.ViewGroup;
import android.view.ViewParent;

class MiniAppLivePlayer$5$1
  implements Runnable
{
  MiniAppLivePlayer$5$1(MiniAppLivePlayer.5 param5) {}
  
  public void run()
  {
    ((CoverLiveView)this.this$1.this$0.getParent()).setLayoutParams(MiniAppLivePlayer.access$200(this.this$1.this$0));
    if (this.this$1.this$0.getParent().getParent() != null) {
      ((ViewGroup)this.this$1.this$0.getParent().getParent()).scrollTo(0, MiniAppLivePlayer.access$300(this.this$1.this$0));
    }
    this.this$1.this$0.isBusyInChangeScreen = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.5.1
 * JD-Core Version:    0.7.0.1
 */