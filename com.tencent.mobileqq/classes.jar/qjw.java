import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class qjw
  implements Animation.AnimationListener
{
  qjw(qjv paramqjv) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    qjv.a(this.a).startAnimation(qjv.a(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjw
 * JD-Core Version:    0.7.0.1
 */