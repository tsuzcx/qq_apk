import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar;

public class scx
  extends AccessibilityDelegateCompat
{
  public scx(BaseTabbar paramBaseTabbar) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (BaseTabbar.a(this.a, paramView) == BaseTabbar.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityNodeInfoCompat.setSelected(bool);
      return;
    }
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scx
 * JD-Core Version:    0.7.0.1
 */