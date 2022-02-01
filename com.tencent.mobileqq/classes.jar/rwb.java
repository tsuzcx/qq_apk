import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class rwb
  implements Animation.AnimationListener
{
  rwb(rwa paramrwa) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (rwa.a(this.a) != null) {
      rwa.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwb
 * JD-Core Version:    0.7.0.1
 */