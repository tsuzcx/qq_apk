import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class qst
  extends AnimatorListenerAdapter
{
  qst(qsq paramqsq, qmp paramqmp) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Qsq.b(this.jdField_a_of_type_Qmp);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    qsq.a(this.jdField_a_of_type_Qsq).setRepeatCount(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qst
 * JD-Core Version:    0.7.0.1
 */