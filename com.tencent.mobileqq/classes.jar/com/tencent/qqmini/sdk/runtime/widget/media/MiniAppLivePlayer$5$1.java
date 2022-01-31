package com.tencent.qqmini.sdk.runtime.widget.media;

import android.view.ViewGroup;
import android.view.ViewParent;

class MiniAppLivePlayer$5$1
  implements Runnable
{
  MiniAppLivePlayer$5$1(MiniAppLivePlayer.5 param5) {}
  
  public void run()
  {
    ((CoverLiveView)this.a.this$0.getParent()).setLayoutParams(MiniAppLivePlayer.a(this.a.this$0));
    if (this.a.this$0.getParent().getParent() != null) {
      ((ViewGroup)this.a.this$0.getParent().getParent()).scrollTo(0, MiniAppLivePlayer.c(this.a.this$0));
    }
    this.a.this$0.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.MiniAppLivePlayer.5.1
 * JD-Core Version:    0.7.0.1
 */