import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;

public class pcf
  implements Animator.AnimatorListener
{
  public pcf(VideoView paramVideoView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (VideoView.a(this.a) != null) {
      VideoView.a(this.a).setVisibility(4);
    }
    if (VideoView.b(this.a) != null) {
      VideoView.b(this.a).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pcf
 * JD-Core Version:    0.7.0.1
 */