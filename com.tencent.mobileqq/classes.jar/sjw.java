import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate.LikeExplosionCenterView;

public class sjw
  extends AnimatorListenerAdapter
{
  public sjw(VideoFeedsLikeAnimate.LikeExplosionCenterView paramLikeExplosionCenterView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    VideoFeedsLikeAnimate.LikeExplosionCenterView.a(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VideoFeedsLikeAnimate.LikeExplosionCenterView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjw
 * JD-Core Version:    0.7.0.1
 */