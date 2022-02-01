import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate.LikeExplosionView;

public class sjx
  extends AnimatorListenerAdapter
{
  public sjx(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    VideoFeedsLikeAnimate.LikeExplosionView.a(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VideoFeedsLikeAnimate.LikeExplosionView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjx
 * JD-Core Version:    0.7.0.1
 */