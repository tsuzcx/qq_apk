import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class qtx
  implements Animator.AnimatorListener
{
  qtx(qtv paramqtv) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    qtv.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    qtv.a(this.a, false);
    qtv.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qtx
 * JD-Core Version:    0.7.0.1
 */