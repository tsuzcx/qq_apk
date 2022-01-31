import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class ogb
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  ogb(ofx paramofx, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onSoftKeyboardClosed()
  {
    if (System.currentTimeMillis() - ofx.a(this.jdField_a_of_type_Ofx) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = aekt.a(140.5F, ofx.a(this.jdField_a_of_type_Ofx).getResources());
      ofx.a(this.jdField_a_of_type_Ofx).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ofx.b(this.jdField_a_of_type_Ofx, System.currentTimeMillis());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (System.currentTimeMillis() - ofx.a(this.jdField_a_of_type_Ofx) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = aekt.a(40.0F, ofx.a(this.jdField_a_of_type_Ofx).getResources());
      ofx.a(this.jdField_a_of_type_Ofx).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ofx.b(this.jdField_a_of_type_Ofx, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ogb
 * JD-Core Version:    0.7.0.1
 */