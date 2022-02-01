package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;

class MiniAppVideoController$7$2
  implements Runnable
{
  MiniAppVideoController$7$2(MiniAppVideoController.7 param7, AbsVideoPlayer paramAbsVideoPlayer) {}
  
  public void run()
  {
    MiniAppVideoController.access$300(this.this$1.this$0).hideVideoPosterImg();
    MiniAppVideoController.access$300(this.this$1.this$0).showPopCtrViewThenAutoHide(MiniAppVideoController.access$000(this.this$1.this$0));
    MiniAppVideoController.access$300(this.this$1.this$0).hideLoadingView();
    long l1 = this.val$player.getDuration();
    MiniAppVideoController.access$300(this.this$1.this$0).updatePlayingTime(MiniAppVideoController.access$1300(this.val$player.getCurrentPostion()));
    MiniAppVideoController.access$300(this.this$1.this$0).setProgressByPlayingTime(l1, this.val$player.getCurrentPostion());
    long l2 = ImmersiveUtils.getScreenWidth() * 2 / 3;
    if ((l1 >= 0L) && (MiniAppVideoController.access$000(this.this$1.this$0).showProgress))
    {
      if ((DisplayUtil.dip2px(MiniAppVideoController.access$1200(this.this$1.this$0), MiniAppVideoController.access$000(this.this$1.this$0).videoWidth) < l2) && (!MiniAppVideoController.access$000(this.this$1.this$0).isFullScreen))
      {
        MiniAppVideoController.access$000(this.this$1.this$0).hideTimeDesc = true;
        MiniAppVideoController.access$300(this.this$1.this$0).setSeekBarGone();
      }
      else
      {
        MiniAppVideoController.access$000(this.this$1.this$0).hideTimeDesc = false;
        MiniAppVideoController.access$300(this.this$1.this$0).setSeekBarVisible();
        MiniAppVideoController.access$300(this.this$1.this$0).updateTotalTimeText(MiniAppVideoController.access$1300(l1));
      }
    }
    else {
      MiniAppVideoController.access$300(this.this$1.this$0).setSeekBarInvisible();
    }
    MiniAppVideoController.access$300(this.this$1.this$0).resetControlIvDrawable(true);
    MiniAppVideoController.access$000(this.this$1.this$0).isBarrageOpen = MiniAppVideoController.access$300(this.this$1.this$0).getIsBarrageOn();
    MiniAppVideoController.access$300(this.this$1.this$0).resetWindowIvDrawable(MiniAppVideoController.access$000(this.this$1.this$0));
    MiniAppVideoController.access$300(this.this$1.this$0).resetBarrageDrawable(MiniAppVideoController.access$000(this.this$1.this$0));
    MiniAppVideoController.access$2302(this.this$1.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.7.2
 * JD-Core Version:    0.7.0.1
 */