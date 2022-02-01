import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class sre
  implements Animation.AnimationListener
{
  sre(src paramsrc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)src.a(this.a).findViewById(2131380602);
    ImageView localImageView = (ImageView)src.a(this.a).findViewById(2131380603);
    src.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sre
 * JD-Core Version:    0.7.0.1
 */