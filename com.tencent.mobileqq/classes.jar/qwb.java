import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class qwb
  implements Animation.AnimationListener
{
  qwb(qwa paramqwa) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    qwa.a(this.a).startAnimation(qwa.a(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwb
 * JD-Core Version:    0.7.0.1
 */