import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class qmy
  implements Animation.AnimationListener
{
  qmy(qmx paramqmx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (qmx.a(this.a) != null) {
      qmx.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmy
 * JD-Core Version:    0.7.0.1
 */