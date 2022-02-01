import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class sbs
  extends AnimatorListenerAdapter
{
  sbs(sbp paramsbp, rvv paramrvv) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Sbp.b(this.jdField_a_of_type_Rvv);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    sbp.a(this.jdField_a_of_type_Sbp).setRepeatCount(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbs
 * JD-Core Version:    0.7.0.1
 */