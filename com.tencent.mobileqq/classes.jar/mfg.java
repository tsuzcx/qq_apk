import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager;

public class mfg
  implements Animation.AnimationListener
{
  public mfg(VideoFeedsCommentManager paramVideoFeedsCommentManager) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (VideoFeedsCommentManager.a(this.a) != null) {
      VideoFeedsCommentManager.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfg
 * JD-Core Version:    0.7.0.1
 */