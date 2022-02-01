package com.tencent.qqmini.miniapp.widget.media;

import android.view.ViewGroup;
import android.view.ViewParent;

class MiniAppLivePlayer$6
  implements Runnable
{
  MiniAppLivePlayer$6(MiniAppLivePlayer paramMiniAppLivePlayer) {}
  
  public void run()
  {
    ((CoverLiveView)this.this$0.getParent()).setLayoutParams(MiniAppLivePlayer.access$300(this.this$0));
    if (this.this$0.getParent().getParent() != null) {
      ((ViewGroup)this.this$0.getParent().getParent()).scrollTo(0, MiniAppLivePlayer.access$400(this.this$0));
    }
    this.this$0.isBusyInChangeScreen = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.6
 * JD-Core Version:    0.7.0.1
 */