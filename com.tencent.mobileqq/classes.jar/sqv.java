import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.qphone.base.util.QLog;

public class sqv
  extends AnimatorListenerAdapter
{
  public sqv(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    SlideActiveAnimController.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim onAnimationCancel");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    SlideActiveAnimController.a(this.a, false);
    SlideActiveAnimController.a(this.a, SlideActiveAnimController.a());
    SlideActiveAnimController.a(this.a).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim onAnimationEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sqv
 * JD-Core Version:    0.7.0.1
 */