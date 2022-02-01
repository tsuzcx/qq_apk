package dov.com.qq.im.aeeditor.view.videotrack;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.aeeditor.view.dragdrop.IDragView;
import dov.com.qq.im.aeeditor.view.playtrack.view.PlayTrackExpandWidthView;
import dov.com.qq.im.aeeditor.view.timebar.ScaleTimeBar;
import dov.com.qq.im.aeeditor.view.timebar.scale.ScaleAdapter;

class VideoTrackContainerView$8
  implements ValueAnimator.AnimatorUpdateListener
{
  VideoTrackContainerView$8(VideoTrackContainerView paramVideoTrackContainerView, IDragView paramIDragView, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ((VideoTrackTimeLineView)this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIDragView).b(i);
    int j = this.jdField_a_of_type_Int;
    i = VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).a(this.b - i) + j;
    ((VideoTrackTimeLineView)this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIDragView).a().scrollTo(i, 0);
    VideoTrackContainerView.a(this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView).scrollTo(i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView.8
 * JD-Core Version:    0.7.0.1
 */