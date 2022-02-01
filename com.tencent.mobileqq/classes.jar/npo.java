import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class npo
  implements Animation.AnimationListener
{
  npo(npm paramnpm) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a.setVisibility(0);
    this.a.a.a.startAnimation(this.a.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npo
 * JD-Core Version:    0.7.0.1
 */