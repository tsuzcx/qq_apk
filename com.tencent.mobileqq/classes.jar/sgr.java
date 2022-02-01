import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class sgr
  implements Animation.AnimationListener
{
  sgr(sgp paramsgp) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)sgp.a(this.a).findViewById(2131380357);
    ImageView localImageView = (ImageView)sgp.a(this.a).findViewById(2131380358);
    sgp.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgr
 * JD-Core Version:    0.7.0.1
 */