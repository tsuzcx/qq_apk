import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.widget.RotateLayout;

public class mlt
  implements Animation.AnimationListener
{
  private mlt(VideoLayerUI paramVideoLayerUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoLayerUI.a(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlt
 * JD-Core Version:    0.7.0.1
 */