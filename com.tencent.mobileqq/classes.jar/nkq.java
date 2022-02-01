import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import java.util.List;

class nkq
  implements Animator.AnimatorListener
{
  nkq(nkp paramnkp, Animator.AnimatorListener paramAnimatorListener, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationCancel(paramAnimator);
    }
    nkp.a(this.jdField_a_of_type_Nkp).remove(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationEnd(paramAnimator);
    }
    nkp.a(this.jdField_a_of_type_Nkp).remove(paramAnimator);
    if (nkp.a(this.jdField_a_of_type_Nkp)) {
      nkp.a(this.jdField_a_of_type_Nkp, this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationRepeat(paramAnimator);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationStart(paramAnimator);
    }
    nkp.a(this.jdField_a_of_type_Nkp).add(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nkq
 * JD-Core Version:    0.7.0.1
 */