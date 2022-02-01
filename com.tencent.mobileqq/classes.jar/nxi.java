import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;

public class nxi
  extends AnimatorListenerAdapter
{
  public nxi(VideoCoverView paramVideoCoverView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    VideoCoverView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nxi
 * JD-Core Version:    0.7.0.1
 */