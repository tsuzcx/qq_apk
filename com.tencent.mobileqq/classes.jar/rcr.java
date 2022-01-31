import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.app.BaseActivity;

class rcr
  extends AnimatorListenerAdapter
{
  rcr(rcp paramrcp) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new Bundle();
    paramAnimator.putBoolean("key_is_from_floating_window", true);
    paramAnimator.putParcelable("VIDEO_OBJ", rcp.a(this.a).a);
    if (rcp.a(this.a) != null) {}
    for (long l = rcp.a(this.a).a() + 300L;; l = 0L)
    {
      paramAnimator.putLong("VIDEO_PLAY_POSITION", l);
      rdm.a(BaseActivity.sTopActivity, paramAnimator, false, rcp.a(this.a));
      rcp.a(this.a, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rcr
 * JD-Core Version:    0.7.0.1
 */