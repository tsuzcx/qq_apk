import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class nzw
  implements Animation.AnimationListener
{
  nzw(nzu paramnzu) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a.setVisibility(0);
    this.a.a.a.startAnimation(this.a.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzw
 * JD-Core Version:    0.7.0.1
 */