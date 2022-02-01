import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.widget.ImageView;

class qht
  implements Animator.AnimatorListener
{
  qht(qhs paramqhs) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    qhs.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    qhs.a(this.a).setSelected(this.a.isSelected());
    qhs.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    qhs.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qht
 * JD-Core Version:    0.7.0.1
 */