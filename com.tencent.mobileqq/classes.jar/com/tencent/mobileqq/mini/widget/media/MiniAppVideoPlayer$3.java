package com.tencent.mobileqq.mini.widget.media;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class MiniAppVideoPlayer$3
  implements SeekBar.OnSeekBarChangeListener
{
  private long position;
  
  MiniAppVideoPlayer$3(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) || (MiniAppVideoPlayer.access$800(this.this$0) == null)) {
      return;
    }
    this.position = (MiniAppVideoPlayer.access$800(this.this$0).getDuration() * paramInt / paramSeekBar.getMax());
    MiniAppVideoPlayer.access$1800(this.this$0).setText(MiniAppVideoPlayer.access$1700(this.position));
    MiniAppVideoPlayer.access$1900(this.this$0).setText(MiniAppVideoPlayer.access$1700(this.position));
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    MiniAppVideoPlayer.access$2002(this.this$0, true);
    MiniAppVideoPlayer.access$1800(this.this$0).setVisibility(0);
    MiniAppVideoPlayer.access$1800(this.this$0).setText("");
    MiniAppVideoPlayer.access$1500(this.this$0);
    if ((this.this$0.showCenterPlayBtn) && ("center".equals(this.this$0.playBtnPosition))) {
      MiniAppVideoPlayer.access$2100(this.this$0).setVisibility(8);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    MiniAppVideoPlayer.access$2002(this.this$0, false);
    if (MiniAppVideoPlayer.access$800(this.this$0) != null) {
      MiniAppVideoPlayer.access$800(this.this$0).seekTo((int)this.position);
    }
    MiniAppVideoPlayer.access$2200(this.this$0).setVisibility(0);
    MiniAppVideoPlayer.access$1800(this.this$0).setVisibility(8);
    MiniAppVideoPlayer.access$2300(this.this$0);
    MiniAppVideoPlayer.access$1200(this.this$0);
    if ((this.this$0.showCenterPlayBtn) && ("center".equals(this.this$0.playBtnPosition))) {
      MiniAppVideoPlayer.access$2100(this.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.3
 * JD-Core Version:    0.7.0.1
 */