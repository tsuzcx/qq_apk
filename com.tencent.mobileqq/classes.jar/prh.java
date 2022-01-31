import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class prh
  implements Animator.AnimatorListener
{
  prh(prf paramprf) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    prf.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    prf.a(this.a, false);
    prf.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     prh
 * JD-Core Version:    0.7.0.1
 */