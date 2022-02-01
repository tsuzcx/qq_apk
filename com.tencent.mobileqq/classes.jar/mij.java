import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class mij
  implements Animator.AnimatorListener
{
  mij(mih parammih) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationCancel");
    }
    this.a.b(3, false);
    if (mih.a(this.a) != null) {
      mih.a(this.a).requestLayout();
    }
    mih.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationEnd");
    }
    this.a.c(3);
    if (mih.a(this.a) != null) {
      mih.a(this.a).requestLayout();
    }
    mih.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationStart");
    }
    mih.a(this.a).setVisibility(0);
    mih.a(this.a).setAlpha(0.0F);
    mih.a(this.a).setVisibility(0);
    mih.a(this.a).setAlpha(0.0F);
    mih.a(this.a).height = -2;
    mih.a(this.a).width = -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mij
 * JD-Core Version:    0.7.0.1
 */