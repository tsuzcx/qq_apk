import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import java.util.List;

class tgf
  implements Animator.AnimatorListener
{
  tgf(tge paramtge, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    tge.a(this.jdField_a_of_type_Tge).removeView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAnimatorListener(this);
    tge.a(this.jdField_a_of_type_Tge).remove(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tgf
 * JD-Core Version:    0.7.0.1
 */