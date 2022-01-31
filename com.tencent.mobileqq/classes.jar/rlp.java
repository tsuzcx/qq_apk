import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class rlp
  implements Animation.AnimationListener
{
  rlp(rlo paramrlo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    rlo.a(this.a).startAnimation(rlo.a(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rlp
 * JD-Core Version:    0.7.0.1
 */