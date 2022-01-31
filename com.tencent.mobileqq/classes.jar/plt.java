import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class plt
  implements Animator.AnimatorListener
{
  plt(plm paramplm, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      plm.a(this.jdField_a_of_type_Plm).isShowRecommendList = false;
      plm.a(this.jdField_a_of_type_Plm);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plt
 * JD-Core Version:    0.7.0.1
 */