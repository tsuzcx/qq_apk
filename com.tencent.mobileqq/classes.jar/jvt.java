import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.EffectSettingUi;

public class jvt
  implements Animation.AnimationListener
{
  public jvt(EffectSettingUi paramEffectSettingUi) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a != null) {
      this.a.a.setVisibility(0);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jvt
 * JD-Core Version:    0.7.0.1
 */