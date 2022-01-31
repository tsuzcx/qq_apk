import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class plg
  implements Animator.AnimatorListener
{
  plg(ple parample) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ple.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ple.a(this.a, false);
    ple.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plg
 * JD-Core Version:    0.7.0.1
 */