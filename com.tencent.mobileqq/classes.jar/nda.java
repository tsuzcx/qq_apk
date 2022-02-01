import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import com.tencent.avgame.gameroom.gamelist.GameListRecyclerViewAdapter.1;

public class nda
  implements Animator.AnimatorListener
{
  public nda(GameListRecyclerViewAdapter.1 param1) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ncz.a(this.a.this$0) != null) {
      ncz.a(this.a.this$0).start();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nda
 * JD-Core Version:    0.7.0.1
 */