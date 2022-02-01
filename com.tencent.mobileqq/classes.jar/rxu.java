import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class rxu
  implements Animation.AnimationListener
{
  rxu(rxt paramrxt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    rxt.a(this.a).startAnimation(rxt.a(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxu
 * JD-Core Version:    0.7.0.1
 */