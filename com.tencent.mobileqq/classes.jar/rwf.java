import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySlidingIndicator;

public class rwf
  extends View.AccessibilityDelegate
{
  public rwf(ReadinjoySlidingIndicator paramReadinjoySlidingIndicator) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 4096) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rwf
 * JD-Core Version:    0.7.0.1
 */