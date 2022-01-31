import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingBtn;
import com.tencent.av.ui.EffectSettingUi;
import java.lang.ref.WeakReference;

public class jty
  implements Animation.AnimationListener
{
  public jty(EffectSettingUi paramEffectSettingUi) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingBtn != null) {
      this.a.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.b();
    }
    EffectSettingUi.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    ((AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).m();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jty
 * JD-Core Version:    0.7.0.1
 */