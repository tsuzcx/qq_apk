import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView;

public class mjr
  implements Animator.AnimatorListener
{
  public mjr(ReadInjoyTabDragAnimationView paramReadInjoyTabDragAnimationView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setRotation(0.0F);
    this.a.setAlpha(1.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjr
 * JD-Core Version:    0.7.0.1
 */