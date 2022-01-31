import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.app.BaseActivity;

class qbs
  extends AnimatorListenerAdapter
{
  qbs(qbq paramqbq) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new Bundle();
    paramAnimator.putBoolean("key_is_from_floating_window", true);
    paramAnimator.putParcelable("VIDEO_OBJ", qbq.a(this.a).a);
    if (qbq.a(this.a) != null) {}
    for (long l = qbq.a(this.a).a() + 300L;; l = 0L)
    {
      paramAnimator.putLong("VIDEO_PLAY_POSITION", l);
      qcn.a(BaseActivity.sTopActivity, paramAnimator, false, qbq.a(this.a));
      qbq.a(this.a, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbs
 * JD-Core Version:    0.7.0.1
 */