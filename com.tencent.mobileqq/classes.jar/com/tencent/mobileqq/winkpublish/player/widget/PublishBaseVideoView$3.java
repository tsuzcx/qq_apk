package com.tencent.mobileqq.winkpublish.player.widget;

import android.app.Activity;
import android.view.Window;

class PublishBaseVideoView$3
  implements Runnable
{
  PublishBaseVideoView$3(PublishBaseVideoView paramPublishBaseVideoView, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.getContext() instanceof Activity))
    {
      if (this.a)
      {
        ((Activity)this.this$0.getContext()).getWindow().addFlags(128);
        return;
      }
      ((Activity)this.this$0.getContext()).getWindow().clearFlags(128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.widget.PublishBaseVideoView.3
 * JD-Core Version:    0.7.0.1
 */