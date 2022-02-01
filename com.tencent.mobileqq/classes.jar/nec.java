import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.avgame.gameroom.stage.CountDownClockView;

public class nec
  implements ValueAnimator.AnimatorUpdateListener
{
  public nec(CountDownClockView paramCountDownClockView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    CountDownClockView.a(this.a, i);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nec
 * JD-Core Version:    0.7.0.1
 */