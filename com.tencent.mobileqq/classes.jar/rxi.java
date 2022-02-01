import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class rxi
  implements Animation.AnimationListener
{
  rxi(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setTag(-1, null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxi
 * JD-Core Version:    0.7.0.1
 */