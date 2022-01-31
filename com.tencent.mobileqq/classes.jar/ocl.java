import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class ocl
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  ocl(oci paramoci, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onSoftKeyboardClosed()
  {
    if (System.currentTimeMillis() - oci.a(this.jdField_a_of_type_Oci) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = actn.a(140.5F, oci.a(this.jdField_a_of_type_Oci).getResources());
      oci.a(this.jdField_a_of_type_Oci).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      oci.b(this.jdField_a_of_type_Oci, System.currentTimeMillis());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (System.currentTimeMillis() - oci.a(this.jdField_a_of_type_Oci) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = actn.a(40.0F, oci.a(this.jdField_a_of_type_Oci).getResources());
      oci.a(this.jdField_a_of_type_Oci).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      oci.b(this.jdField_a_of_type_Oci, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocl
 * JD-Core Version:    0.7.0.1
 */