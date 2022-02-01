import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.widget.ImageView;

class qbv
  implements Animator.AnimatorListener
{
  qbv(qbu paramqbu) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    qbu.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    qbu.a(this.a).setSelected(this.a.isSelected());
    qbu.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    qbu.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbv
 * JD-Core Version:    0.7.0.1
 */