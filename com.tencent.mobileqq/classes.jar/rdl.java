import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGuideView;

public class rdl
  implements ValueAnimator.AnimatorUpdateListener
{
  private rdl(VideoFeedsGuideView paramVideoFeedsGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (VideoFeedsGuideView.a(this.a) == 1)
    {
      VideoFeedsGuideView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      VideoFeedsGuideView.b(this.a, VideoFeedsGuideView.b(this.a) + VideoFeedsGuideView.c(this.a));
    }
    for (;;)
    {
      this.a.invalidate();
      return;
      VideoFeedsGuideView.c(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      VideoFeedsGuideView.d(this.a, VideoFeedsGuideView.b(this.a) + VideoFeedsGuideView.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rdl
 * JD-Core Version:    0.7.0.1
 */