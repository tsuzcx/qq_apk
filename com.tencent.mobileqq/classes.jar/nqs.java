import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class nqs
  implements Animator.AnimatorListener
{
  nqs(nqp paramnqp) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    nqp.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    nqp.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    nqp.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    nqp.a(this.a, true);
    nqp.a(this.a).setAlpha(0.0F);
    nqp.b(this.a).setAlpha(0.0F);
    nqp.c(this.a).setAlpha(0.0F);
    nqp.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqs
 * JD-Core Version:    0.7.0.1
 */