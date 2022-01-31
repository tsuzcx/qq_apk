import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class mlh
  implements Animator.AnimatorListener
{
  mlh(mlf parammlf) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationCancel");
    }
    this.a.b(3, false);
    if (mlf.a(this.a) != null) {
      mlf.a(this.a).requestLayout();
    }
    mlf.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationEnd");
    }
    this.a.c(3);
    if (mlf.a(this.a) != null) {
      mlf.a(this.a).requestLayout();
    }
    mlf.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationStart");
    }
    mlf.a(this.a).setVisibility(0);
    mlf.a(this.a).setAlpha(0.0F);
    mlf.a(this.a).setVisibility(0);
    mlf.a(this.a).setAlpha(0.0F);
    mlf.a(this.a).height = -2;
    mlf.a(this.a).width = -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mlh
 * JD-Core Version:    0.7.0.1
 */