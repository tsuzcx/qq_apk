import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.avgame.gameroom.seat.PkMemberItemView;
import com.tencent.avgame.gameroom.seat.TalkingEffectLayout;

public class njx
  implements Animator.AnimatorListener
{
  public njx(PkMemberItemView paramPkMemberItemView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njx
 * JD-Core Version:    0.7.0.1
 */