package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;

final class AnimatorFactory$2
  implements Animator.AnimatorListener
{
  AnimatorFactory$2(AnimatorFactory.AnimatorListener paramAnimatorListener, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener.d(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener.c(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener.b(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation.AnimatorFactory.2
 * JD-Core Version:    0.7.0.1
 */