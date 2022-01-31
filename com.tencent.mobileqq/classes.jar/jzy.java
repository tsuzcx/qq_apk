import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.qphone.base.util.QLog;

public class jzy
  implements Animator.AnimatorListener
{
  public jzy(QavVideoRecordUICtrl paramQavVideoRecordUICtrl) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "fold onAnimationCancel");
    }
    this.a.b(4, false);
    QavVideoRecordUICtrl.b(this.a).requestLayout();
    QavVideoRecordUICtrl.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "fold onAnimationEnd");
    }
    this.a.c(4);
    QavVideoRecordUICtrl.b(this.a).requestLayout();
    QavVideoRecordUICtrl.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "fold onAnimationStart");
    }
    QavVideoRecordUICtrl.d(this.a).setVisibility(0);
    QavVideoRecordUICtrl.d(this.a).setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzy
 * JD-Core Version:    0.7.0.1
 */