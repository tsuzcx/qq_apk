import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.QQLogo;

public class jzd
  implements Animation.AnimationListener
{
  public jzd(QQLogo paramQQLogo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzd
 * JD-Core Version:    0.7.0.1
 */