import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class rec
  implements Animation.AnimationListener
{
  rec(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.a.getTag(-1) != null) && (((Integer)this.a.getTag(-1)).intValue() == 8))
    {
      this.a.clearAnimation();
      this.a.setVisibility(8);
      this.a.setTag(-1, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rec
 * JD-Core Version:    0.7.0.1
 */