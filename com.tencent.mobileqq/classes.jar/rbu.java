import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;

public class rbu
  implements Animation.AnimationListener
{
  public rbu(VideoFeedsAioGuideView paramVideoFeedsAioGuideView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    VideoFeedsAioGuideView.a(this.a).setStartOffset(360L);
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rbu
 * JD-Core Version:    0.7.0.1
 */