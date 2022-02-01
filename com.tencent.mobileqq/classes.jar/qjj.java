import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.widget.ImageView;

class qjj
  implements Animator.AnimatorListener
{
  qjj(qji paramqji) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    qji.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    qji.a(this.a).setSelected(this.a.isSelected());
    qji.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    qji.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjj
 * JD-Core Version:    0.7.0.1
 */