import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.avgame.gameroom.seat.background.SurvivalMemberItemView;

public class nkn
  implements Animator.AnimatorListener
{
  public nkn(SurvivalMemberItemView paramSurvivalMemberItemView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.a(0);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.a(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nkn
 * JD-Core Version:    0.7.0.1
 */