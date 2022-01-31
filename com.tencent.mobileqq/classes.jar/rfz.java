import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView;

public class rfz
  implements Animator.AnimatorListener
{
  public rfz(ReadInjoyTabDragAnimationView paramReadInjoyTabDragAnimationView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setScaleX(1.0F);
    this.a.setScaleY(1.0F);
    this.a.setRotation(0.0F);
    this.a.setAlpha(1.0F);
    if (ReadInjoyTabDragAnimationView.a(this.a) != 0) {
      this.a.a(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rfz
 * JD-Core Version:    0.7.0.1
 */