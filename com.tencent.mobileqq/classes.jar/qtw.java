import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.widget.ImageView;

class qtw
  implements Animator.AnimatorListener
{
  qtw(qtv paramqtv) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    qtv.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    qtv.a(this.a).setSelected(this.a.isSelected());
    qtv.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    qtv.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qtw
 * JD-Core Version:    0.7.0.1
 */