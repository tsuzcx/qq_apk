import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.qphone.base.util.QLog;

public class kce
  implements Animator.AnimatorListener
{
  public kce(QavVideoRecordUICtrl paramQavVideoRecordUICtrl) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationCancel");
    }
    this.a.b(3, false);
    QavVideoRecordUICtrl.b(this.a).requestLayout();
    QavVideoRecordUICtrl.b(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationEnd");
    }
    this.a.c(3);
    QavVideoRecordUICtrl.b(this.a).requestLayout();
    QavVideoRecordUICtrl.b(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationStart");
    }
    QavVideoRecordUICtrl.a(this.a).setVisibility(0);
    QavVideoRecordUICtrl.a(this.a).setAlpha(0.0F);
    QavVideoRecordUICtrl.b(this.a).setVisibility(0);
    QavVideoRecordUICtrl.b(this.a).setAlpha(0.0F);
    QavVideoRecordUICtrl.e(this.a).height = -2;
    QavVideoRecordUICtrl.e(this.a).width = -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kce
 * JD-Core Version:    0.7.0.1
 */