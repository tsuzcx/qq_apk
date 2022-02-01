import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class qcm
  implements Animator.AnimatorListener
{
  qcm(qcf paramqcf, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      qcf.a(this.jdField_a_of_type_Qcf).isShowRecommendList = false;
      qcf.a(this.jdField_a_of_type_Qcf);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcm
 * JD-Core Version:    0.7.0.1
 */