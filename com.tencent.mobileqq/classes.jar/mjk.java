import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class mjk
  implements Animator.AnimatorListener
{
  mjk(mji parammji) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationCancel");
    }
    this.a.b(3, false);
    if (mji.a(this.a) != null) {
      mji.a(this.a).requestLayout();
    }
    mji.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationEnd");
    }
    this.a.c(3);
    if (mji.a(this.a) != null) {
      mji.a(this.a).requestLayout();
    }
    mji.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationStart");
    }
    mji.a(this.a).setVisibility(0);
    mji.a(this.a).setAlpha(0.0F);
    mji.a(this.a).setVisibility(0);
    mji.a(this.a).setAlpha(0.0F);
    mji.a(this.a).height = -2;
    mji.a(this.a).width = -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mjk
 * JD-Core Version:    0.7.0.1
 */