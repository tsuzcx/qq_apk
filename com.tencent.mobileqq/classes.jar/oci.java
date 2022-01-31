import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class oci
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  oci(ocf paramocf, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onSoftKeyboardClosed()
  {
    if (System.currentTimeMillis() - ocf.a(this.jdField_a_of_type_Ocf) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = actj.a(140.5F, ocf.a(this.jdField_a_of_type_Ocf).getResources());
      ocf.a(this.jdField_a_of_type_Ocf).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ocf.b(this.jdField_a_of_type_Ocf, System.currentTimeMillis());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (System.currentTimeMillis() - ocf.a(this.jdField_a_of_type_Ocf) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = actj.a(40.0F, ocf.a(this.jdField_a_of_type_Ocf).getResources());
      ocf.a(this.jdField_a_of_type_Ocf).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ocf.b(this.jdField_a_of_type_Ocf, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oci
 * JD-Core Version:    0.7.0.1
 */