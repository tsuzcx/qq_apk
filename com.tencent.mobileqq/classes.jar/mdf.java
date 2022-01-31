import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;

public class mdf
  implements Animation.AnimationListener
{
  public mdf(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoFeedsPlayActivity.b(this.a).startAnimation(this.a.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdf
 * JD-Core Version:    0.7.0.1
 */