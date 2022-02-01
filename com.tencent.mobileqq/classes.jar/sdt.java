import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class sdt
  extends AnimatorListenerAdapter
{
  sdt(sdq paramsdq, rxy paramrxy) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Sdq.b(this.jdField_a_of_type_Rxy);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    sdq.a(this.jdField_a_of_type_Sdq).setRepeatCount(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdt
 * JD-Core Version:    0.7.0.1
 */