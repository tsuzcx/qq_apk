import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class qbw
  implements Animator.AnimatorListener
{
  qbw(qbu paramqbu) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    qbu.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    qbu.a(this.a, false);
    qbu.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbw
 * JD-Core Version:    0.7.0.1
 */