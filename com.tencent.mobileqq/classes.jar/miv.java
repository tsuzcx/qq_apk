import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanel;

public class miv
  implements Animator.AnimatorListener
{
  public miv(QavPanel paramQavPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QavPanel.a(this.a))
    {
      paramAnimator = this.a.a.a().a();
      paramAnimator.a("tryPlayBtnMuteAnimation onAnimationEnd", true);
      paramAnimator.b("tryPlayBtnMuteAnimation onAnimationEnd", 1);
      this.a.a("tryPlayBtnMuteAnimation onAnimationEnd", 2, 1, false);
      return;
    }
    this.a.a.a().g("tryPlayBtnMuteAnimation onAnimationEnd", 1);
    this.a.a("tryPlayBtnMuteAnimation onAnimationEnd", 2, 1, false);
    QavPanel.a(this.a).a(false, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QavPanel.a(this.a).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     miv
 * JD-Core Version:    0.7.0.1
 */