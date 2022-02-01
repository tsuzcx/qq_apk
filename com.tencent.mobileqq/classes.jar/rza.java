import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.HorizontalRefreshLayout;

public class rza
  extends AnimatorListenerAdapter
{
  public rza(HorizontalRefreshLayout paramHorizontalRefreshLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    HorizontalRefreshLayout.a(this.a, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rza
 * JD-Core Version:    0.7.0.1
 */