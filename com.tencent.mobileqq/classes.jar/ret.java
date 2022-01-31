import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate.LikeExplosionCenterView;

public class ret
  extends AnimatorListenerAdapter
{
  public ret(VideoFeedsLikeAnimate.LikeExplosionCenterView paramLikeExplosionCenterView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    VideoFeedsLikeAnimate.LikeExplosionCenterView.a(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VideoFeedsLikeAnimate.LikeExplosionCenterView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ret
 * JD-Core Version:    0.7.0.1
 */