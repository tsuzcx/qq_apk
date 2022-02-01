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
    if (MiniAppVideoController.access$200(this.this$0) != null) {
      if (paramView.getId() == R.id.play_status_img)
      {
        MiniAppVideoController.access$800(this.this$0);
      }
      else if ((paramView.getId() != R.id.video_playing_iv_control) && (paramView.getId() != R.id.video_playing_iv_control_center))
      {
        if ((paramView.getId() != R.id.video_playing_iv_window) && (paramView.getId() != R.id.video_playing_iv_back_fullscreen))
        {
          if (paramView.getId() == R.id.video_playing_iv_barrage)
          {
            MiniAppVideoController.access$300(this.this$0).showPopCtrViewThenAutoHide(MiniAppVideoController.access$000(this.this$0));
            MiniAppVideoController.access$300(this.this$0).updateDanmuView(MiniAppVideoController.access$000(this.this$0));
            MiniAppVideoController.access$300(this.this$0).resetBarrageDrawable(MiniAppVideoController.access$000(this.this$0));
          }
          else if (paramView.getId() == R.id.video_playing_iv_mute)
          {
            MiniAppVideoController.access$000(this.this$0).muted = (MiniAppVideoController.access$200(this.this$0).getOutputMute() ^ true);
            MiniAppVideoController.access$200(this.this$0).updateMute(MiniAppVideoController.access$000(this.this$0));
            MiniAppVideoController.access$300(this.this$0).resetMuteImage(MiniAppVideoController.access$000(this.this$0), MiniAppVideoController.access$200(this.this$0).getOutputMute());
          }
        }
        else
        {
          MiniAppVideoController.access$300(this.this$0).showPopCtrViewThenAutoHide(MiniAppVideoController.access$000(this.this$0));
          MiniAppVideoController.access$900(this.this$0);
          MiniAppVideoController.access$300(this.this$0).resetWindowIvDrawable(MiniAppVideoController.access$000(this.this$0));
        }
      }
      else
      {
        this.this$0.operate();
        MiniAppVideoController.access$300(this.this$0).updatePopCtrView(MiniAppVideoController.access$000(this.this$0), MiniAppVideoController.access$200(this.this$0).isPlaying());
        MiniAppVideoController.access$300(this.this$0).resetControlIvDrawable(MiniAppVideoController.access$200(this.this$0).isPlaying());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.2
 * JD-Core Version:    0.7.0.1
 */