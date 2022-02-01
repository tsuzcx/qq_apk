package dov.com.qq.im.aeeditor.view.videotrack;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoTrackContainerView$4
  implements View.OnClickListener
{
  VideoTrackContainerView$4(VideoTrackContainerView paramVideoTrackContainerView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!paramView.isSelected()) {
      paramView.setSelected(true);
    }
    if (VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView) != null) {
      VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView.4
 * JD-Core Version:    0.7.0.1
 */