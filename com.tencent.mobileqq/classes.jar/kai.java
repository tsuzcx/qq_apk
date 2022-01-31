import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.av.ui.VideoControlUI;

public class kai
  implements Animation.AnimationListener
{
  public kai(VideoControlUI paramVideoControlUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.clearAnimation();
    this.a.c.clearAnimation();
    this.a.b.clearAnimation();
    this.a.e.clearAnimation();
    this.a.l(true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kai
 * JD-Core Version:    0.7.0.1
 */