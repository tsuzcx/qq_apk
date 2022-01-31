import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.widget.ImageView;

class plc
  implements Animator.AnimatorListener
{
  plc(plb paramplb) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    plb.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    plb.a(this.a).setSelected(this.a.isSelected());
    plb.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    plb.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plc
 * JD-Core Version:    0.7.0.1
 */