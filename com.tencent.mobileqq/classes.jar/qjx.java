import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class qjx
  implements Animation.AnimationListener
{
  qjx(qjv paramqjv) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)qjv.a(this.a).findViewById(2131312925);
    ImageView localImageView = (ImageView)qjv.a(this.a).findViewById(2131312926);
    qjv.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjx
 * JD-Core Version:    0.7.0.1
 */