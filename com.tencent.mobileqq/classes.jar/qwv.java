import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.HorizontalRefreshLayout;

public class qwv
  extends AnimatorListenerAdapter
{
  public qwv(HorizontalRefreshLayout paramHorizontalRefreshLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    HorizontalRefreshLayout.a(this.a, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwv
 * JD-Core Version:    0.7.0.1
 */