package dov.com.qq.im.aeeditor.view.videotrack;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.view.transition.listener.OnTransitionListener;

class VideoTrackContainerView$5
  implements View.OnClickListener
{
  VideoTrackContainerView$5(VideoTrackContainerView paramVideoTrackContainerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoTrackContainerView.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = VideoTrackContainerView.a(this.a, (ImageView)paramView);
      if (i != -1)
      {
        VideoTrackContainerView.a(this.a, paramView);
        VideoTrackContainerView.a(this.a).a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView.5
 * JD-Core Version:    0.7.0.1
 */