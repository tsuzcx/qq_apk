import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class sny
  extends AnimatorListenerAdapter
{
  sny(snv paramsnv, swu paramswu) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Snv.b(this.jdField_a_of_type_Swu);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    snv.a(this.jdField_a_of_type_Snv).setRepeatCount(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sny
 * JD-Core Version:    0.7.0.1
 */