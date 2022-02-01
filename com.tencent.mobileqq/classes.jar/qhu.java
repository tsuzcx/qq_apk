import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class qhu
  implements Animator.AnimatorListener
{
  qhu(qhs paramqhs) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    qhs.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    qhs.a(this.a, false);
    qhs.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhu
 * JD-Core Version:    0.7.0.1
 */