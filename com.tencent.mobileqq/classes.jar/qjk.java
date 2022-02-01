import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class qjk
  implements Animator.AnimatorListener
{
  qjk(qji paramqji) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    qji.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    qji.a(this.a, false);
    qji.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjk
 * JD-Core Version:    0.7.0.1
 */