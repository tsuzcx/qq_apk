import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;

public class rtu
  implements ValueAnimator.AnimatorUpdateListener
{
  public rtu(TabLayoutCompat paramTabLayoutCompat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.scrollTo(((Integer)paramValueAnimator.getAnimatedValue()).intValue(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rtu
 * JD-Core Version:    0.7.0.1
 */