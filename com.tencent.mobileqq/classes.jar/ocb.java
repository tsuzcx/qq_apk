import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class ocb
  implements Animator.AnimatorListener
{
  ocb(oby paramoby) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    oby.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    oby.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    oby.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    oby.a(this.a, true);
    oby.a(this.a).setAlpha(0.0F);
    oby.b(this.a).setAlpha(0.0F);
    oby.c(this.a).setAlpha(0.0F);
    oby.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocb
 * JD-Core Version:    0.7.0.1
 */