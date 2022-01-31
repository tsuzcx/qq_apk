import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public final class mch
  implements Animation.AnimationListener
{
  public mch(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.a.getTag(-1) != null) && (((Integer)this.a.getTag(-1)).intValue() == 8))
    {
      this.a.clearAnimation();
      this.a.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mch
 * JD-Core Version:    0.7.0.1
 */