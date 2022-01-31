import android.util.SparseArray;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.EffectSettingUi;

public class jud
  implements Animation.AnimationListener
{
  public jud(EffectSettingUi paramEffectSettingUi) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (BaseToolbar)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(this.a.jdField_a_of_type_Int);
    if (paramAnimation != null) {
      paramAnimation.hideToolbar();
    }
    this.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jud
 * JD-Core Version:    0.7.0.1
 */