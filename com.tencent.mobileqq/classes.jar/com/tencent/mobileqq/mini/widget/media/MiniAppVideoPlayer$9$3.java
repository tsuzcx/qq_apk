package com.tencent.mobileqq.mini.widget.media;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.mini.widget.media.danmu.BarrageView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class MiniAppVideoPlayer$9$3
  implements Runnable
{
  MiniAppVideoPlayer$9$3(MiniAppVideoPlayer.9 param9) {}
  
  public void run()
  {
    boolean bool = true;
    MiniAppVideoPlayer.access$1500(this.this$1.this$0);
    MiniAppVideoPlayer.access$2500(this.this$1.this$0).setVisibility(8);
    MiniAppVideoPlayer.access$3400(this.this$1.this$0);
    MiniAppVideoPlayer.access$2600(this.this$1.this$0);
    MiniAppVideoPlayer localMiniAppVideoPlayer;
    if ((MiniAppVideoPlayer.access$1100(this.this$1.this$0).getDuration() < 0L) || (!this.this$1.this$0.showProgress))
    {
      MiniAppVideoPlayer.access$3500(this.this$1.this$0).setVisibility(4);
      MiniAppVideoPlayer.access$2200(this.this$1.this$0).setVisibility(4);
      MiniAppVideoPlayer.access$3600(this.this$1.this$0).setVisibility(4);
      MiniAppVideoPlayer.access$1700(this.this$1.this$0, true);
      localMiniAppVideoPlayer = this.this$1.this$0;
      if ((MiniAppVideoPlayer.access$3700(this.this$1.this$0) == null) || (MiniAppVideoPlayer.access$3700(this.this$1.this$0).getVisibility() != 0)) {
        break label380;
      }
    }
    for (;;)
    {
      localMiniAppVideoPlayer.isBarrageOpen = bool;
      MiniAppVideoPlayer.access$3800(this.this$1.this$0);
      MiniAppVideoPlayer.access$3900(this.this$1.this$0);
      MiniAppVideoPlayer.access$2302(this.this$1.this$0, false);
      return;
      if ((this.this$1.this$0.videoWidth < 300) && (!this.this$1.this$0.isFullScreen))
      {
        this.this$1.this$0.hideTimeDesc = true;
        MiniAppVideoPlayer.access$3500(this.this$1.this$0).setVisibility(4);
        MiniAppVideoPlayer.access$2200(this.this$1.this$0).setVisibility(4);
        MiniAppVideoPlayer.access$3600(this.this$1.this$0).setVisibility(4);
        break;
      }
      this.this$1.this$0.hideTimeDesc = false;
      MiniAppVideoPlayer.access$3500(this.this$1.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$2200(this.this$1.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$3600(this.this$1.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$3500(this.this$1.this$0).setText(MiniAppVideoPlayer.access$2000(MiniAppVideoPlayer.access$1100(this.this$1.this$0).getDuration()));
      break;
      label380:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.9.3
 * JD-Core Version:    0.7.0.1
 */