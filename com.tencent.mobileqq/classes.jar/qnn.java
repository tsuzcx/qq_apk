import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.app.BaseActivity;

class qnn
  extends AnimatorListenerAdapter
{
  qnn(qnl paramqnl) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new Bundle();
    paramAnimator.putBoolean("key_is_from_floating_window", true);
    paramAnimator.putParcelable("VIDEO_OBJ", qnl.a(this.a).a);
    if (qnl.a(this.a) != null) {}
    for (long l = qnl.a(this.a).a() + 300L;; l = 0L)
    {
      paramAnimator.putLong("VIDEO_PLAY_POSITION", l);
      qoi.a(BaseActivity.sTopActivity, paramAnimator, false, qnl.a(this.a));
      qnl.a(this.a, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnn
 * JD-Core Version:    0.7.0.1
 */