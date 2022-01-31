import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class qvz
  implements Animation.AnimationListener
{
  qvz(qvx paramqvx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)qvx.a(this.a).findViewById(2131378755);
    ImageView localImageView = (ImageView)qvx.a(this.a).findViewById(2131378756);
    qvx.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qvz
 * JD-Core Version:    0.7.0.1
 */