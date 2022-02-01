import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;

public class rvx
  implements Animation.AnimationListener
{
  public rvx(VideoFeedsAioGuideView paramVideoFeedsAioGuideView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    VideoFeedsAioGuideView.b(this.a).setStartOffset(360L);
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvx
 * JD-Core Version:    0.7.0.1
 */