import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.tencent.mobileqq.text.TextUtils;

class mme
  extends AccessibilityDelegateCompat
{
  mme(mmd parammmd, mmn parammmn) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (this.jdField_a_of_type_Mmn.a() != null)
    {
      paramView = TextUtils.emoticonToTextForTalkBack(this.jdField_a_of_type_Mmn.a().toString());
      paramAccessibilityNodeInfoCompat.setText(paramView);
      paramAccessibilityNodeInfoCompat.setContentDescription(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mme
 * JD-Core Version:    0.7.0.1
 */