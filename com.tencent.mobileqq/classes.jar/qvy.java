import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class qvy
  implements Animation.AnimationListener
{
  qvy(qvx paramqvx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    qvx.a(this.a).startAnimation(qvx.a(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qvy
 * JD-Core Version:    0.7.0.1
 */