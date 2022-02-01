package dov.com.qq.im.ae.biz.qcircle.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AECircleVideoPreviewItemView$2
  implements View.OnClickListener
{
  AECircleVideoPreviewItemView$2(AECircleVideoPreviewItemView paramAECircleVideoPreviewItemView) {}
  
  public void onClick(View paramView)
  {
    if (AECircleVideoPreviewItemView.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AECircleVideoPreviewItemView.a(this.a).isPlaying())
      {
        AECircleVideoPreviewItemView.a(this.a).pause();
        AECircleVideoPreviewItemView.b(this.a).setVisibility(0);
      }
      else
      {
        AECircleVideoPreviewItemView.a(this.a).resume();
        AECircleVideoPreviewItemView.a(this.a).setVisibility(8);
        AECircleVideoPreviewItemView.b(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.widget.AECircleVideoPreviewItemView.2
 * JD-Core Version:    0.7.0.1
 */