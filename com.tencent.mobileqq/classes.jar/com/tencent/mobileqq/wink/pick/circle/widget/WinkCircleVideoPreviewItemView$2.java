package com.tencent.mobileqq.wink.pick.circle.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WinkCircleVideoPreviewItemView$2
  implements View.OnClickListener
{
  WinkCircleVideoPreviewItemView$2(WinkCircleVideoPreviewItemView paramWinkCircleVideoPreviewItemView) {}
  
  public void onClick(View paramView)
  {
    if (WinkCircleVideoPreviewItemView.f(this.a) != null) {
      if (WinkCircleVideoPreviewItemView.f(this.a).isPlaying())
      {
        WinkCircleVideoPreviewItemView.f(this.a).pause();
        WinkCircleVideoPreviewItemView.b(this.a).setVisibility(0);
      }
      else
      {
        WinkCircleVideoPreviewItemView.f(this.a).resume();
        WinkCircleVideoPreviewItemView.a(this.a).setVisibility(8);
        WinkCircleVideoPreviewItemView.b(this.a).setVisibility(8);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.widget.WinkCircleVideoPreviewItemView.2
 * JD-Core Version:    0.7.0.1
 */