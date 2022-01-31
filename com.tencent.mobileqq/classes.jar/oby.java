import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class oby
  implements Animator.AnimatorListener
{
  oby(obv paramobv) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    obv.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    obv.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    obv.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    obv.a(this.a, true);
    obv.a(this.a).setAlpha(0.0F);
    obv.b(this.a).setAlpha(0.0F);
    obv.c(this.a).setAlpha(0.0F);
    obv.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oby
 * JD-Core Version:    0.7.0.1
 */