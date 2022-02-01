import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

class mhq
  extends AccessibilityDelegateCompat
{
  mhq(mhn parammhn, int paramInt) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    boolean bool = true;
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setCheckable(true);
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_Mhn.d) {}
    for (;;)
    {
      paramAccessibilityNodeInfoCompat.setChecked(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mhq
 * JD-Core Version:    0.7.0.1
 */