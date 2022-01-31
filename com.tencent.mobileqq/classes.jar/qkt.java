import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.HorizontalRefreshLayout;

public class qkt
  extends AnimatorListenerAdapter
{
  public qkt(HorizontalRefreshLayout paramHorizontalRefreshLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    HorizontalRefreshLayout.a(this.a, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qkt
 * JD-Core Version:    0.7.0.1
 */