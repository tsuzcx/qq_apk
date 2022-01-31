package com.tencent.mobileqq.mini.widget.media;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

class MiniAppVideoPlayer$10$2
  implements Runnable
{
  MiniAppVideoPlayer$10$2(MiniAppVideoPlayer.10 param10) {}
  
  public void run()
  {
    if (this.this$1.this$0.showCenterPlayBtn) {
      MiniAppVideoPlayer.access$4100(this.this$1.this$0).setVisibility(0);
    }
    for (;;)
    {
      MiniAppVideoPlayer.access$1400(this.this$1.this$0).setVisibility(8);
      MiniAppVideoPlayer.access$4200(this.this$1.this$0).removeMessages(2002);
      return;
      MiniAppVideoPlayer.access$4100(this.this$1.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.10.2
 * JD-Core Version:    0.7.0.1
 */