import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class qwc
  implements Animation.AnimationListener
{
  qwc(qwa paramqwa) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)qwa.a(this.a).findViewById(2131378750);
    ImageView localImageView = (ImageView)qwa.a(this.a).findViewById(2131378751);
    qwa.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwc
 * JD-Core Version:    0.7.0.1
 */