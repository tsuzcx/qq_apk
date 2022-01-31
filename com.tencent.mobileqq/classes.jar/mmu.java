import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import java.lang.ref.WeakReference;

public class mmu
  implements Animation.AnimationListener
{
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  
  public mmu(EffectFilterPanel paramEffectFilterPanel, View paramView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    lcg.c("EffectFilterPanel", "MyTextAlphaAnimationListener onAnimationEnd :" + localView + "|" + paramAnimation);
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmu
 * JD-Core Version:    0.7.0.1
 */