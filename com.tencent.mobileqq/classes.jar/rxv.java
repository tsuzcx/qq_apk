import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class rxv
  implements Animation.AnimationListener
{
  rxv(rxt paramrxt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)rxt.a(this.a).findViewById(2131380543);
    ImageView localImageView = (ImageView)rxt.a(this.a).findViewById(2131380544);
    rxt.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxv
 * JD-Core Version:    0.7.0.1
 */