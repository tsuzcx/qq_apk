import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.EffectSettingUi;

public class jtp
  implements Animation.AnimationListener
{
  public jtp(EffectSettingUi paramEffectSettingUi) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a != null) {
      this.a.a.setVisibility(0);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jtp
 * JD-Core Version:    0.7.0.1
 */