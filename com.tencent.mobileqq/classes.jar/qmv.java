import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class qmv
  implements Animation.AnimationListener
{
  qmv(qmu paramqmu) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (qmu.a(this.a) != null) {
      qmu.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmv
 * JD-Core Version:    0.7.0.1
 */