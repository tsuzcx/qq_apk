import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.app.BaseActivity;

class qnq
  extends AnimatorListenerAdapter
{
  qnq(qno paramqno) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new Bundle();
    paramAnimator.putBoolean("key_is_from_floating_window", true);
    paramAnimator.putParcelable("VIDEO_OBJ", qno.a(this.a).a);
    if (qno.a(this.a) != null) {}
    for (long l = qno.a(this.a).a() + 300L;; l = 0L)
    {
      paramAnimator.putLong("VIDEO_PLAY_POSITION", l);
      qol.a(BaseActivity.sTopActivity, paramAnimator, false, qno.a(this.a));
      qno.a(this.a, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnq
 * JD-Core Version:    0.7.0.1
 */