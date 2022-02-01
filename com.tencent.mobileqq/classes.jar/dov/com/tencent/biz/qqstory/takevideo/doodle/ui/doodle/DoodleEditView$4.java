package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;

class DoodleEditView$4
  extends AnimatorListenerAdapter
{
  DoodleEditView$4(DoodleEditView paramDoodleEditView, GestureHelper.ZoomItem paramZoomItem) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SLog.b("DoodleEditView", "onAnimationEnd");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.n = 1.0F;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SLog.b("DoodleEditView", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.4
 * JD-Core Version:    0.7.0.1
 */