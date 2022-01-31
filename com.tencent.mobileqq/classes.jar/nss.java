import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class nss
  implements Animator.AnimatorListener
{
  nss(nsp paramnsp) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    nsp.a(false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    nsp.a(false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    nsp.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nss
 * JD-Core Version:    0.7.0.1
 */