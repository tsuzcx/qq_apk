package com.tencent.qqmini.sdk.widget.media;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;

class MiniAppVideoPlayer$2
  implements SeekBar.OnSeekBarChangeListener
{
  private long position;
  
  MiniAppVideoPlayer$2(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) || (MiniAppVideoPlayer.access$000(this.this$0) == null)) {
      return;
    }
    this.position = (MiniAppVideoPlayer.access$000(this.this$0).getDuration() * paramInt / paramSeekBar.getMax());
    MiniAppVideoPlayer.access$200(this.this$0).setText(MiniAppVideoPlayer.access$100(this.position));
    MiniAppVideoPlayer.access$300(this.this$0).setText(MiniAppVideoPlayer.access$100(this.position));
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    MiniAppVideoPlayer.access$402(this.this$0, true);
    MiniAppVideoPlayer.access$200(this.this$0).setVisibility(0);
    MiniAppVideoPlayer.access$200(this.this$0).setText("");
    MiniAppVideoPlayer.access$500(this.this$0);
    if ((this.this$0.showCenterPlayBtn) && ("center".equals(this.this$0.playBtnPosition))) {
      MiniAppVideoPlayer.access$600(this.this$0).setVisibility(8);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    MiniAppVideoPlayer.access$402(this.this$0, false);
    if (MiniAppVideoPlayer.access$000(this.this$0) != null) {
      MiniAppVideoPlayer.access$000(this.this$0).seekTo((int)this.position);
    }
    MiniAppVideoPlayer.access$700(this.this$0).setVisibility(0);
    MiniAppVideoPlayer.access$200(this.this$0).setVisibility(8);
    MiniAppVideoPlayer.access$800(this.this$0);
    MiniAppVideoPlayer.access$900(this.this$0);
    if ((this.this$0.showCenterPlayBtn) && ("center".equals(this.this$0.playBtnPosition))) {
      MiniAppVideoPlayer.access$600(this.this$0).setVisibility(0);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */