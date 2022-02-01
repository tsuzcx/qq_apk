package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

class DoodleLayout$LineLayerTouchListener$1
  implements Animation.AnimationListener
{
  DoodleLayout$LineLayerTouchListener$1(DoodleLayout.LineLayerTouchListener paramLineLayerTouchListener) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setAnimation(null);
    if (this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper != null) {
      this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper.a(null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.LineLayerTouchListener.1
 * JD-Core Version:    0.7.0.1
 */