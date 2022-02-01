import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.avgame.gameroom.seat.TalkingEffectLayout;

public class neb
  implements Animator.AnimatorListener
{
  public neb(TalkingEffectLayout paramTalkingEffectLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (TalkingEffectLayout.a(this.a) != null) {
      TalkingEffectLayout.a(this.a).onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (TalkingEffectLayout.a(this.a) != null) {
      TalkingEffectLayout.a(this.a).onAnimationEnd(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (TalkingEffectLayout.a(this.a) != null) {
      TalkingEffectLayout.a(this.a).onAnimationRepeat(paramAnimator);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (TalkingEffectLayout.a(this.a) != null) {
      TalkingEffectLayout.a(this.a).onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     neb
 * JD-Core Version:    0.7.0.1
 */