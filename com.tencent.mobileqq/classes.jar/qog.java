import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGuideView;

public class qog
  extends AnimatorListenerAdapter
{
  private qog(VideoFeedsGuideView paramVideoFeedsGuideView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    VideoFeedsGuideView.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    VideoFeedsGuideView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qog
 * JD-Core Version:    0.7.0.1
 */