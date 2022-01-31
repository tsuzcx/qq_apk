import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.widget.ImageView;

class ozn
  implements Animator.AnimatorListener
{
  ozn(ozm paramozm) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ozm.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ozm.a(this.a).setSelected(this.a.isSelected());
    ozm.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ozm.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozn
 * JD-Core Version:    0.7.0.1
 */