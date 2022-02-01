import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

class mmv
  extends AccessibilityDelegateCompat
{
  mmv(mmu parammmu, mne parammne) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (this.jdField_a_of_type_Mne.a() != null)
    {
      paramView = behh.e(this.jdField_a_of_type_Mne.a().toString());
      paramAccessibilityNodeInfoCompat.setText(paramView);
      paramAccessibilityNodeInfoCompat.setContentDescription(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mmv
 * JD-Core Version:    0.7.0.1
 */