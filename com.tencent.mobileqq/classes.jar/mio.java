import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class mio
  implements Animator.AnimatorListener
{
  mio(mim parammim) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationCancel");
    }
    this.a.b(3, false);
    if (mim.a(this.a) != null) {
      mim.a(this.a).requestLayout();
    }
    mim.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationEnd");
    }
    this.a.c(3);
    if (mim.a(this.a) != null) {
      mim.a(this.a).requestLayout();
    }
    mim.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationStart");
    }
    mim.a(this.a).setVisibility(0);
    mim.a(this.a).setAlpha(0.0F);
    mim.a(this.a).setVisibility(0);
    mim.a(this.a).setAlpha(0.0F);
    mim.a(this.a).height = -2;
    mim.a(this.a).width = -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mio
 * JD-Core Version:    0.7.0.1
 */