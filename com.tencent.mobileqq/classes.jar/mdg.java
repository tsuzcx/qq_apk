import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;

public class mdg
  implements Animation.AnimationListener
{
  public mdg(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)this.a.findViewById(2131365588);
    ImageView localImageView = (ImageView)this.a.findViewById(2131365589);
    VideoFeedsPlayActivity.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdg
 * JD-Core Version:    0.7.0.1
 */