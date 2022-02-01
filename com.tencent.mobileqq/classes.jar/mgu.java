import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

class mgu
  extends AccessibilityDelegateCompat
{
  mgu(mgr parammgr, int paramInt) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    boolean bool = true;
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setCheckable(true);
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_Mgr.d) {}
    for (;;)
    {
      paramAccessibilityNodeInfoCompat.setChecked(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgu
 * JD-Core Version:    0.7.0.1
 */