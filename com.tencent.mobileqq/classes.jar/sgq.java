import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class sgq
  implements Animation.AnimationListener
{
  sgq(sgp paramsgp) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    sgp.a(this.a).startAnimation(sgp.a(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgq
 * JD-Core Version:    0.7.0.1
 */