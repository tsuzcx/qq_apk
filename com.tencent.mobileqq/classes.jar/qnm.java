import android.view.animation.Interpolator;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;

public class qnm
  implements Interpolator
{
  public qnm(DailyTitleBarSwitcher paramDailyTitleBarSwitcher) {}
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.2F) {
      return 0.0F;
    }
    if (paramFloat < 0.5F) {
      return (paramFloat - 0.2F) / 0.3F;
    }
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnm
 * JD-Core Version:    0.7.0.1
 */