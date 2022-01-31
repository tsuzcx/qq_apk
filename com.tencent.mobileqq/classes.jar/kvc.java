import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;

public class kvc
  extends AnimatorListenerAdapter
{
  public kvc(VideoCoverView paramVideoCoverView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    VideoCoverView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvc
 * JD-Core Version:    0.7.0.1
 */