import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;

public class mcd
  implements Animation.AnimationListener
{
  public mcd(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)this.a.findViewById(2131365561);
    ImageView localImageView = (ImageView)this.a.findViewById(2131365562);
    VideoFeedsPlayActivity.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcd
 * JD-Core Version:    0.7.0.1
 */