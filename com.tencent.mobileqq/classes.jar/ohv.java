import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import com.tencent.biz.qqstory.takevideo.doodle.ui.animation.AnimatorFactory.AnimatorListener;

public final class ohv
  implements Animator.AnimatorListener
{
  public ohv(AnimatorFactory.AnimatorListener paramAnimatorListener, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener.d(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener.c(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiAnimationAnimatorFactory$AnimatorListener.b(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohv
 * JD-Core Version:    0.7.0.1
 */