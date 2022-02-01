package com.tencent.qqmini.sdk.widget.media;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.media.danmu.BarrageView;

class MiniAppVideoPlayer$9$3
  implements Runnable
{
  MiniAppVideoPlayer$9$3(MiniAppVideoPlayer.9 param9) {}
  
  public void run()
  {
    boolean bool = true;
    MiniAppVideoPlayer.access$900(this.this$1.this$0);
    MiniAppVideoPlayer.access$700(this.this$1.this$0).setVisibility(8);
    MiniAppVideoPlayer.access$3300(this.this$1.this$0);
    MiniAppVideoPlayer.access$800(this.this$1.this$0);
    long l1 = MiniAppVideoPlayer.access$000(this.this$1.this$0).getDuration();
    long l2 = ImmersiveUtils.getScreenWidth() * 2 / 3;
    MiniAppVideoPlayer localMiniAppVideoPlayer;
    if ((l1 < 0L) || (!this.this$1.this$0.showProgress))
    {
      MiniAppVideoPlayer.access$3400(this.this$1.this$0).setVisibility(4);
      MiniAppVideoPlayer.access$300(this.this$1.this$0).setVisibility(4);
      MiniAppVideoPlayer.access$3500(this.this$1.this$0).setVisibility(4);
      MiniAppVideoPlayer.access$1500(this.this$1.this$0, true);
      localMiniAppVideoPlayer = this.this$1.this$0;
      if ((MiniAppVideoPlayer.access$3700(this.this$1.this$0) == null) || (MiniAppVideoPlayer.access$3700(this.this$1.this$0).getVisibility() != 0)) {
        break label408;
      }
    }
    for (;;)
    {
      localMiniAppVideoPlayer.isBarrageOpen = bool;
      MiniAppVideoPlayer.access$3800(this.this$1.this$0);
      MiniAppVideoPlayer.access$3900(this.this$1.this$0);
      MiniAppVideoPlayer.access$402(this.this$1.this$0, false);
      return;
      if ((DisplayUtil.dip2px(MiniAppVideoPlayer.access$3600(this.this$1.this$0), this.this$1.this$0.videoWidth) < l2) && (!this.this$1.this$0.isFullScreen))
      {
        this.this$1.this$0.hideTimeDesc = true;
        MiniAppVideoPlayer.access$3400(this.this$1.this$0).setVisibility(8);
        MiniAppVideoPlayer.access$300(this.this$1.this$0).setVisibility(8);
        MiniAppVideoPlayer.access$3500(this.this$1.this$0).setVisibility(8);
        break;
      }
      this.this$1.this$0.hideTimeDesc = false;
      MiniAppVideoPlayer.access$3400(this.this$1.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$300(this.this$1.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$3500(this.this$1.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$3400(this.this$1.this$0).setText(MiniAppVideoPlayer.access$100(MiniAppVideoPlayer.access$000(this.this$1.this$0).getDuration()));
      break;
      label408:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.9.3
 * JD-Core Version:    0.7.0.1
 */