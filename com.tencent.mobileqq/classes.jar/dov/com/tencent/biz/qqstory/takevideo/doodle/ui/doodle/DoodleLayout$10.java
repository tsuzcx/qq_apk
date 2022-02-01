package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

class DoodleLayout$10
  implements Animation.AnimationListener
{
  DoodleLayout$10(DoodleLayout paramDoodleLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setAnimation(null);
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper.a(null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.10
 * JD-Core Version:    0.7.0.1
 */