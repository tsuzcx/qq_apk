import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class qsw
  extends AnimatorListenerAdapter
{
  qsw(qst paramqst, qms paramqms) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Qst.b(this.jdField_a_of_type_Qms);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    qst.a(this.jdField_a_of_type_Qst).setRepeatCount(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsw
 * JD-Core Version:    0.7.0.1
 */