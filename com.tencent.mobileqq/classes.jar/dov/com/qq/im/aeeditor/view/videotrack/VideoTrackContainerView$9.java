package dov.com.qq.im.aeeditor.view.videotrack;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup.MarginLayoutParams;
import dov.com.qq.im.aeeditor.view.dragdrop.IDragView;
import java.util.List;

class VideoTrackContainerView$9
  implements Animator.AnimatorListener
{
  VideoTrackContainerView$9(VideoTrackContainerView paramVideoTrackContainerView, IDragView paramIDragView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.b(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, null);
    VideoTrackContainerView.b(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, ((ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).get(0)).getLayoutParams()).leftMargin);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.b(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, false);
    VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, null);
    this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIDragView.a();
    VideoTrackContainerView.b(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView, ((ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).get(0)).getLayoutParams()).leftMargin);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView.9
 * JD-Core Version:    0.7.0.1
 */