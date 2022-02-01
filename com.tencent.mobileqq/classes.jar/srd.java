import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class srd
  implements Animation.AnimationListener
{
  srd(src paramsrc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    src.a(this.a).startAnimation(src.a(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srd
 * JD-Core Version:    0.7.0.1
 */