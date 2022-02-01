import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class qik
  implements Animator.AnimatorListener
{
  qik(qid paramqid, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      qid.a(this.jdField_a_of_type_Qid).isShowRecommendList = false;
      qid.a(this.jdField_a_of_type_Qid);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qik
 * JD-Core Version:    0.7.0.1
 */