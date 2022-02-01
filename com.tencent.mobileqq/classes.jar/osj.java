import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class osj
  implements Animator.AnimatorListener
{
  osj(osg paramosg) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    osg.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    osg.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    osg.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    osg.a(this.a, true);
    osg.a(this.a).setAlpha(0.0F);
    osg.b(this.a).setAlpha(0.0F);
    osg.c(this.a).setAlpha(0.0F);
    osg.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osj
 * JD-Core Version:    0.7.0.1
 */