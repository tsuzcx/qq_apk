import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class osx
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  osx(ost paramost, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onSoftKeyboardClosed()
  {
    if (System.currentTimeMillis() - ost.a(this.jdField_a_of_type_Ost) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = afur.a(140.5F, ost.a(this.jdField_a_of_type_Ost).getResources());
      ost.a(this.jdField_a_of_type_Ost).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ost.b(this.jdField_a_of_type_Ost, System.currentTimeMillis());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (System.currentTimeMillis() - ost.a(this.jdField_a_of_type_Ost) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = afur.a(40.0F, ost.a(this.jdField_a_of_type_Ost).getResources());
      ost.a(this.jdField_a_of_type_Ost).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ost.b(this.jdField_a_of_type_Ost, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osx
 * JD-Core Version:    0.7.0.1
 */