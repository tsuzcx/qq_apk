import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;

public class qcd
  implements Animator.AnimatorListener
{
  public qcd(VideoView paramVideoView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (VideoView.access$2700(this.a) != null) {
      VideoView.access$2700(this.a).setVisibility(4);
    }
    if (VideoView.access$2800(this.a) != null) {
      VideoView.access$2800(this.a).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcd
 * JD-Core Version:    0.7.0.1
 */