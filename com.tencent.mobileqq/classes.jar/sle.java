import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySlidingIndicator;

public class sle
  implements ValueAnimator.AnimatorUpdateListener
{
  public sle(ReadinjoySlidingIndicator paramReadinjoySlidingIndicator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ReadinjoySlidingIndicator.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sle
 * JD-Core Version:    0.7.0.1
 */