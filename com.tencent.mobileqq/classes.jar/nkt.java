import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import java.util.List;

class nkt
  implements Animator.AnimatorListener
{
  nkt(nkp paramnkp) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    nkp.a(this.a).remove(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    nkp.a(this.a).remove(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    nkp.a(this.a).add(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nkt
 * JD-Core Version:    0.7.0.1
 */