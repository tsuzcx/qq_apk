import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public final class pim
  implements Animation.AnimationListener
{
  public pim(Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a != null) {
      this.a.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pim
 * JD-Core Version:    0.7.0.1
 */