import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;

public class rde
  implements Animator.AnimatorListener
{
  public rde(ZImageView paramZImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ZImageView.a(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ZImageView.a(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rde
 * JD-Core Version:    0.7.0.1
 */