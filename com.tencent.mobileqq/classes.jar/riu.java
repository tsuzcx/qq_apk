import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;

public class riu
  implements ValueAnimator.AnimatorUpdateListener
{
  public riu(TickerView paramTickerView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    TickerView.a(this.a).a(paramValueAnimator.getAnimatedFraction());
    TickerView.a(this.a);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     riu
 * JD-Core Version:    0.7.0.1
 */