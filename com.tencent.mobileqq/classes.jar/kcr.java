import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.widget.RotateLayout;

public class kcr
  implements Animation.AnimationListener
{
  private kcr(VideoLayerUI paramVideoLayerUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoLayerUI.a(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kcr
 * JD-Core Version:    0.7.0.1
 */