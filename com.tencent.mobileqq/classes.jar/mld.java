import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.widget.RotateLayout;

public class mld
  implements Animation.AnimationListener
{
  private mld(VideoLayerUI paramVideoLayerUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoLayerUI.a(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mld
 * JD-Core Version:    0.7.0.1
 */