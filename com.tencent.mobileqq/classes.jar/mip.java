import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class mip
  implements Animator.AnimatorListener
{
  mip(min parammin) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationCancel");
    }
    this.a.b(3, false);
    if (min.a(this.a) != null) {
      min.a(this.a).requestLayout();
    }
    min.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationEnd");
    }
    this.a.c(3);
    if (min.a(this.a) != null) {
      min.a(this.a).requestLayout();
    }
    min.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationStart");
    }
    min.a(this.a).setVisibility(0);
    min.a(this.a).setAlpha(0.0F);
    min.a(this.a).setVisibility(0);
    min.a(this.a).setAlpha(0.0F);
    min.a(this.a).height = -2;
    min.a(this.a).width = -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mip
 * JD-Core Version:    0.7.0.1
 */