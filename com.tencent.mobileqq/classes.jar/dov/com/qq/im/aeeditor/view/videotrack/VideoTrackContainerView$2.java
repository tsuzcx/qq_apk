package dov.com.qq.im.aeeditor.view.videotrack;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoTrackContainerView$2
  implements View.OnClickListener
{
  VideoTrackContainerView$2(VideoTrackContainerView paramVideoTrackContainerView) {}
  
  public void onClick(View paramView)
  {
    this.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView.2
 * JD-Core Version:    0.7.0.1
 */