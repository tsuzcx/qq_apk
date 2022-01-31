import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.QavPanel;

public class jsp
  implements Animation.AnimationListener
{
  public jsp(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a != null)
    {
      this.a.b = true;
      this.a.a.g();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jsp
 * JD-Core Version:    0.7.0.1
 */