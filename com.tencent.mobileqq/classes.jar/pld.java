import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class pld
  implements Animator.AnimatorListener
{
  pld(plb paramplb) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    plb.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    plb.a(this.a, false);
    plb.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pld
 * JD-Core Version:    0.7.0.1
 */