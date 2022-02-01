import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.widget.EditText;

class mmd
  extends AccessibilityDelegateCompat
{
  mmd(mlz parammlz) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramView = bdol.e(((EditText)paramView).getText().toString());
    paramAccessibilityNodeInfoCompat.setText(paramView);
    paramAccessibilityNodeInfoCompat.setContentDescription(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mmd
 * JD-Core Version:    0.7.0.1
 */