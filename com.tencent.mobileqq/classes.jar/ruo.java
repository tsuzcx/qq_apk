import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ruo
  extends AnimatorListenerAdapter
{
  ruo(rul paramrul, rot paramrot) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Rul.b(this.jdField_a_of_type_Rot);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    rul.a(this.jdField_a_of_type_Rul).setRepeatCount(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ruo
 * JD-Core Version:    0.7.0.1
 */