import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class ozo
  implements Animator.AnimatorListener
{
  ozo(ozm paramozm) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ozm.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ozm.a(this.a, false);
    ozm.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozo
 * JD-Core Version:    0.7.0.1
 */