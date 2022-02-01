package com.tencent.qqmini.sdk.widget.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.id;

class MiniAppVideoController$2
  implements View.OnClickListener
{
  MiniAppVideoController$2(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void onClick(View paramView)
  {
    if (MiniAppVideoController.access$600(this.this$0) == null) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (paramView.getId() == R.id.play_status_img)
        {
          MiniAppVideoController.access$700(this.this$0);
        }
        else if ((paramView.getId() == R.id.video_playing_iv_control) || (paramView.getId() == R.id.video_playing_iv_control_center))
        {
          this.this$0.operate();
          MiniAppVideoController.access$100(this.this$0).updatePopCtrView(MiniAppVideoController.access$800(this.this$0), MiniAppVideoController.access$600(this.this$0).isPlaying());
          MiniAppVideoController.access$100(this.this$0).resetControlIvDrawable(MiniAppVideoController.access$600(this.this$0).isPlaying());
        }
        else if ((paramView.getId() == R.id.video_playing_iv_window) || (paramView.getId() == R.id.video_playing_iv_back_fullscreen))
        {
          MiniAppVideoController.access$100(this.this$0).showPopCtrViewThenAutoHide(MiniAppVideoController.access$800(this.this$0));
          MiniAppVideoController.access$900(this.this$0);
          MiniAppVideoController.access$100(this.this$0).resetWindowIvDrawable(MiniAppVideoController.access$800(this.this$0));
        }
        else
        {
          if (paramView.getId() != R.id.video_playing_iv_barrage) {
            break;
          }
          MiniAppVideoController.access$100(this.this$0).showPopCtrViewThenAutoHide(MiniAppVideoController.access$800(this.this$0));
          MiniAppVideoController.access$100(this.this$0).updateDanmuView(MiniAppVideoController.access$800(this.this$0));
          MiniAppVideoController.access$100(this.this$0).resetBarrageDrawable(MiniAppVideoController.access$800(this.this$0));
        }
      }
    } while (paramView.getId() != R.id.video_playing_iv_mute);
    IVideoPlayer localIVideoPlayer = MiniAppVideoController.access$600(this.this$0);
    if (!MiniAppVideoController.access$600(this.this$0).getOutputMute()) {}
    for (boolean bool = true;; bool = false)
    {
      localIVideoPlayer.setOutputMute(bool);
      MiniAppVideoController.access$100(this.this$0).resetMuteImage(MiniAppVideoController.access$800(this.this$0), MiniAppVideoController.access$600(this.this$0).getOutputMute());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.2
 * JD-Core Version:    0.7.0.1
 */