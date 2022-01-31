import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;

public class mgt
  implements Animation.AnimationListener
{
  public mgt(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)this.a.findViewById(2131365593);
    ImageView localImageView = (ImageView)this.a.findViewById(2131365594);
    VideoFeedsPlayActivity.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgt
 * JD-Core Version:    0.7.0.1
 */