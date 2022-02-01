import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class mjf
  implements Animator.AnimatorListener
{
  mjf(mjd parammjd) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationCancel");
    }
    this.a.b(3, false);
    if (mjd.a(this.a) != null) {
      mjd.a(this.a).requestLayout();
    }
    mjd.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationEnd");
    }
    this.a.c(3);
    if (mjd.a(this.a) != null) {
      mjd.a(this.a).requestLayout();
    }
    mjd.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationStart");
    }
    mjd.a(this.a).setVisibility(0);
    mjd.a(this.a).setAlpha(0.0F);
    mjd.a(this.a).setVisibility(0);
    mjd.a(this.a).setAlpha(0.0F);
    mjd.a(this.a).height = -2;
    mjd.a(this.a).width = -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mjf
 * JD-Core Version:    0.7.0.1
 */