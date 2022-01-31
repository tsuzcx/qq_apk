import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class rlq
  implements Animation.AnimationListener
{
  rlq(rlo paramrlo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)rlo.a(this.a).findViewById(2131379373);
    ImageView localImageView = (ImageView)rlo.a(this.a).findViewById(2131379374);
    rlo.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rlq
 * JD-Core Version:    0.7.0.1
 */