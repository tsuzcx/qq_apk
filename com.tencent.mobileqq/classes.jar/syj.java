import android.view.animation.Interpolator;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;

public class syj
  implements Interpolator
{
  public syj(DailyTitleBarSwitcher paramDailyTitleBarSwitcher) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syj
 * JD-Core Version:    0.7.0.1
 */