package dov.com.qq.im.aeeditor.view.videotrack;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class VideoTrackTimeLineView$2
  extends AnimatorListenerAdapter
{
  VideoTrackTimeLineView$2(VideoTrackTimeLineView paramVideoTrackTimeLineView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VideoTrackTimeLineView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView).removeView(this.jdField_a_of_type_AndroidViewView);
    VideoTrackTimeLineView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackTimeLineView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.videotrack.VideoTrackTimeLineView.2
 * JD-Core Version:    0.7.0.1
 */