import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;

public class njv
  extends AnimatorListenerAdapter
{
  public njv(VideoCoverView paramVideoCoverView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    VideoCoverView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     njv
 * JD-Core Version:    0.7.0.1
 */