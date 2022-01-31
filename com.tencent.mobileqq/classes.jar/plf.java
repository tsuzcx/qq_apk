import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.widget.ImageView;

class plf
  implements Animator.AnimatorListener
{
  plf(ple parample) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ple.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ple.a(this.a).setSelected(this.a.isSelected());
    ple.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ple.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plf
 * JD-Core Version:    0.7.0.1
 */