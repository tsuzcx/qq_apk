package com.tencent.mobileqq.wink.pick.circle.widget;

import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

class WinkCircleVideoPreviewItemView$3
  implements SeekBar.OnSeekBarChangeListener
{
  WinkCircleVideoPreviewItemView$3(WinkCircleVideoPreviewItemView paramWinkCircleVideoPreviewItemView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((WinkCircleVideoPreviewItemView.f(this.a) != null) && (WinkCircleVideoPreviewItemView.g(this.a) != null))
    {
      if (WinkCircleVideoPreviewItemView.e(this.a) == null) {
        return;
      }
      if (paramBoolean)
      {
        BaseVideoView localBaseVideoView = WinkCircleVideoPreviewItemView.f(this.a);
        float f = paramInt;
        localBaseVideoView.seekTo((int)(f / paramSeekBar.getMax() * (float)WinkCircleVideoPreviewItemView.g(this.a).mDuration));
        WinkCircleVideoPreviewItemView.a(this.a, paramInt);
        WinkCircleVideoPreviewItemView.e(this.a).setText(WinkCircleVideoPreviewItemView.a(this.a, (int)(f / paramSeekBar.getMax() * (float)WinkCircleVideoPreviewItemView.g(this.a).mDuration)));
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (WinkCircleVideoPreviewItemView.h(this.a) != null) {
      WinkCircleVideoPreviewItemView.h(this.a).setVisibility(0);
    }
    paramSeekBar.getLayoutParams().height = ImmersiveUtils.dpToPx(4.0F);
    paramSeekBar.requestLayout();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (WinkCircleVideoPreviewItemView.h(this.a) != null) {
      WinkCircleVideoPreviewItemView.h(this.a).setVisibility(8);
    }
    paramSeekBar.getLayoutParams().height = ImmersiveUtils.dpToPx(1.0F);
    paramSeekBar.requestLayout();
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.widget.WinkCircleVideoPreviewItemView.3
 * JD-Core Version:    0.7.0.1
 */