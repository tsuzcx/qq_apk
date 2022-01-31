import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class qox
  implements Animation.AnimationListener
{
  qox(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setTag(-1, null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qox
 * JD-Core Version:    0.7.0.1
 */