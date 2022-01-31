import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.funchat.filter.EffectFilterTextPager;
import java.lang.ref.WeakReference;

public class mmx
  implements Animation.AnimationListener
{
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  
  public mmx(EffectFilterTextPager paramEffectFilterTextPager, View paramView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    lcg.c("EffectFilterTextPager", "onAnimationEnd :" + localView + "|" + paramAnimation);
    if (localView != null) {
      localView.setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmx
 * JD-Core Version:    0.7.0.1
 */