import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class slx
  implements Animator.AnimatorListener
{
  slx(slw paramslw, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    slw.a(this.jdField_a_of_type_Slw, this.jdField_a_of_type_Boolean);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    slw.a(this.jdField_a_of_type_Slw, this.jdField_a_of_type_Boolean);
    slw.a(this.jdField_a_of_type_Slw);
    this.jdField_a_of_type_Slw.b.clearAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     slx
 * JD-Core Version:    0.7.0.1
 */