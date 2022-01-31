package com.tencent.qqmini.sdk.core.widget.media;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import bdjz;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.widget.media.danmu.BarrageView;

public class MiniAppVideoPlayer$7$3
  implements Runnable
{
  public MiniAppVideoPlayer$7$3(bdjz parambdjz) {}
  
  public void run()
  {
    boolean bool = true;
    MiniAppVideoPlayer.a(this.a.a);
    MiniAppVideoPlayer.b(this.a.a).setVisibility(8);
    MiniAppVideoPlayer.f(this.a.a);
    MiniAppVideoPlayer.d(this.a.a);
    MiniAppVideoPlayer localMiniAppVideoPlayer;
    if ((MiniAppVideoPlayer.a(this.a.a).getDuration() < 0L) || (!this.a.a.q))
    {
      MiniAppVideoPlayer.c(this.a.a).setVisibility(4);
      MiniAppVideoPlayer.b(this.a.a).setVisibility(4);
      MiniAppVideoPlayer.a(this.a.a).setVisibility(4);
      MiniAppVideoPlayer.a(this.a.a, true);
      localMiniAppVideoPlayer = this.a.a;
      if ((MiniAppVideoPlayer.a(this.a.a) == null) || (MiniAppVideoPlayer.a(this.a.a).getVisibility() != 0)) {
        break label280;
      }
    }
    for (;;)
    {
      localMiniAppVideoPlayer.d = bool;
      MiniAppVideoPlayer.g(this.a.a);
      MiniAppVideoPlayer.h(this.a.a);
      MiniAppVideoPlayer.a(this.a.a, false);
      return;
      MiniAppVideoPlayer.c(this.a.a).setVisibility(0);
      MiniAppVideoPlayer.b(this.a.a).setVisibility(0);
      MiniAppVideoPlayer.a(this.a.a).setVisibility(0);
      MiniAppVideoPlayer.c(this.a.a).setText(MiniAppVideoPlayer.a(MiniAppVideoPlayer.a(this.a.a).getDuration()));
      break;
      label280:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.7.3
 * JD-Core Version:    0.7.0.1
 */