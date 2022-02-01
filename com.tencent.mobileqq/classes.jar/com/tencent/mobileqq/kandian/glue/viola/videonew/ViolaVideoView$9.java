package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;

class ViolaVideoView$9
  implements SeekBar.OnSeekBarChangeListener
{
  ViolaVideoView$9(ViolaVideoView paramViolaVideoView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!ViolaVideoView.a(this.a).b()) {
      return;
    }
    long l = ViolaVideoView.a(this.a).c();
    double d1 = paramInt;
    Double.isNaN(d1);
    d1 /= 100.0D;
    double d2 = l;
    Double.isNaN(d2);
    paramInt = (int)(d1 * d2);
    VideoFeedsHelper.a(ViolaVideoView.a(this.a), paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    ViolaVideoView.a(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (!ViolaVideoView.a(this.a).b()) {
      return;
    }
    ViolaVideoView.a(this.a, false);
    int i = paramSeekBar.getProgress();
    long l = ViolaVideoView.a(this.a).c();
    double d1 = i;
    Double.isNaN(d1);
    d1 /= 100.0D;
    double d2 = l;
    Double.isNaN(d2);
    i = (int)(d1 * d2);
    ViolaVideoView.a(this.a).b(i);
    if (ViolaVideoView.a(this.a) != null) {
      ViolaVideoView.a(this.a).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.ViolaVideoView.9
 * JD-Core Version:    0.7.0.1
 */