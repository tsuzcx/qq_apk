import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class ofq
  implements Animator.AnimatorListener
{
  ofq(ofn paramofn) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ofn.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ofn.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    ofn.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ofn.a(this.a, true);
    ofn.a(this.a).setAlpha(0.0F);
    ofn.b(this.a).setAlpha(0.0F);
    ofn.c(this.a).setAlpha(0.0F);
    ofn.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ofq
 * JD-Core Version:    0.7.0.1
 */