import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySlidingIndicator;

public class sld
  extends View.AccessibilityDelegate
{
  public sld(ReadinjoySlidingIndicator paramReadinjoySlidingIndicator) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 4096) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sld
 * JD-Core Version:    0.7.0.1
 */