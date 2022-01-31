import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class plw
  implements Animator.AnimatorListener
{
  plw(plp paramplp, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      plp.a(this.jdField_a_of_type_Plp).isShowRecommendList = false;
      plp.a(this.jdField_a_of_type_Plp);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plw
 * JD-Core Version:    0.7.0.1
 */