import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.text.TextUtils;

class mng
  extends AccessibilityDelegateCompat
{
  mng(mnc parammnc) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramView = TextUtils.emoticonToTextForTalkBack(((EditText)paramView).getText().toString());
    paramAccessibilityNodeInfoCompat.setText(paramView);
    paramAccessibilityNodeInfoCompat.setContentDescription(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mng
 * JD-Core Version:    0.7.0.1
 */