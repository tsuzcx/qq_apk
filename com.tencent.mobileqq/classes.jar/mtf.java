import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class mtf
  implements Animation.AnimationListener
{
  mtf(mtc parammtc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    mtc.a(this.a, this.a.a.c, this.a.a.d, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtf
 * JD-Core Version:    0.7.0.1
 */