import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGuideView;

public class qoj
  extends AnimatorListenerAdapter
{
  private qoj(VideoFeedsGuideView paramVideoFeedsGuideView) {}
  
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
 * Qualified Name:     qoj
 * JD-Core Version:    0.7.0.1
 */