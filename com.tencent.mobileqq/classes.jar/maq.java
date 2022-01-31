import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager;

public class maq
  implements Animation.AnimationListener
{
  public maq(VideoFeedsCommentManager paramVideoFeedsCommentManager) {}
  
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
 * Qualified Name:     maq
 * JD-Core Version:    0.7.0.1
 */