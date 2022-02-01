package com.tencent.qqmini.sdk.widget.media;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MiniAppVideoController$4
  implements SeekBar.OnSeekBarChangeListener
{
  private long position;
  
  MiniAppVideoController$4(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) || (MiniAppVideoController.access$200(this.this$0) == null)) {
      return;
    }
    this.position = (MiniAppVideoController.access$200(this.this$0).getDuration() * paramInt / paramSeekBar.getMax());
    MiniAppVideoController.access$300(this.this$0).onProgressChanged(MiniAppVideoController.access$1300(paramInt));
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    MiniAppVideoController.access$300(this.this$0).onStartTrackingTouch(MiniAppVideoController.access$000(this.this$0));
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (MiniAppVideoController.access$200(this.this$0) != null) {
      this.this$0.seekTo((int)this.position);
    }
    MiniAppVideoController.access$300(this.this$0).onStopTrackingTouch(MiniAppVideoController.access$000(this.this$0));
    MiniAppVideoController.access$300(this.this$0).setProgressByPlayingTime(MiniAppVideoController.access$200(this.this$0).getDuration(), MiniAppVideoController.access$200(this.this$0).getCurrentPostion());
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.4
 * JD-Core Version:    0.7.0.1
 */