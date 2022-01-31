import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.widget.ImageView;

class prg
  implements Animator.AnimatorListener
{
  prg(prf paramprf) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    prf.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    prf.a(this.a).setSelected(this.a.isSelected());
    prf.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    prf.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     prg
 * JD-Core Version:    0.7.0.1
 */