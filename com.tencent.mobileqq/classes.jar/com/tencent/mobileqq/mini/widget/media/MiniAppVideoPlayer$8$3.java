package com.tencent.mobileqq.mini.widget.media;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.mini.widget.media.danmu.BarrageView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class MiniAppVideoPlayer$8$3
  implements Runnable
{
  MiniAppVideoPlayer$8$3(MiniAppVideoPlayer.8 param8) {}
  
  public void run()
  {
    boolean bool = true;
    MiniAppVideoPlayer.access$1200(this.this$1.this$0);
    MiniAppVideoPlayer.access$2200(this.this$1.this$0).setVisibility(8);
    MiniAppVideoPlayer.access$3100(this.this$1.this$0);
    MiniAppVideoPlayer.access$2300(this.this$1.this$0);
    MiniAppVideoPlayer localMiniAppVideoPlayer;
    if ((MiniAppVideoPlayer.access$800(this.this$1.this$0).getDuration() < 0L) || (!this.this$1.this$0.showProgress))
    {
      MiniAppVideoPlayer.access$3200(this.this$1.this$0).setVisibility(4);
      MiniAppVideoPlayer.access$1900(this.this$1.this$0).setVisibility(4);
      MiniAppVideoPlayer.access$3300(this.this$1.this$0).setVisibility(4);
      MiniAppVideoPlayer.access$1400(this.this$1.this$0, true);
      localMiniAppVideoPlayer = this.this$1.this$0;
      if ((MiniAppVideoPlayer.access$3400(this.this$1.this$0) == null) || (MiniAppVideoPlayer.access$3400(this.this$1.this$0).getVisibility() != 0)) {
        break label284;
      }
    }
    for (;;)
    {
      localMiniAppVideoPlayer.isBarrageOpen = bool;
      MiniAppVideoPlayer.access$3500(this.this$1.this$0);
      MiniAppVideoPlayer.access$3600(this.this$1.this$0);
      MiniAppVideoPlayer.access$2002(this.this$1.this$0, false);
      return;
      MiniAppVideoPlayer.access$3200(this.this$1.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$1900(this.this$1.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$3300(this.this$1.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$3200(this.this$1.this$0).setText(MiniAppVideoPlayer.access$1700(MiniAppVideoPlayer.access$800(this.this$1.this$0).getDuration()));
      break;
      label284:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.8.3
 * JD-Core Version:    0.7.0.1
 */