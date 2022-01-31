import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class oip
  implements Animation.AnimationListener
{
  oip(oio paramoio) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.clearAnimation();
    this.a.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oip
 * JD-Core Version:    0.7.0.1
 */