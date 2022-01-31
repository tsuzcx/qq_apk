import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ngy
  implements Animation.AnimationListener
{
  ngy(ngw paramngw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a.setVisibility(0);
    this.a.a.a.startAnimation(this.a.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ngy
 * JD-Core Version:    0.7.0.1
 */