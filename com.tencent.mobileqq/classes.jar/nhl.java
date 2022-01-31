import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class nhl
  implements Animator.AnimatorListener
{
  nhl(nhi paramnhi) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    nhi.a(false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    nhi.a(false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    nhi.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhl
 * JD-Core Version:    0.7.0.1
 */