package cooperation.qqreader.host.toast;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class QQToastWrapper
  implements Toast
{
  private android.widget.Toast jdField_a_of_type_AndroidWidgetToast;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  
  public static Toast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramContext = new QQToastWrapper();
    paramContext.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(BaseApplicationImpl.getApplication(), paramInt2, paramCharSequence, paramInt1);
    return paramContext;
  }
  
  public void cancel()
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
  }
  
  public void setDuration(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = new QQToast(BaseApplicationImpl.getApplication());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = new QQToast(BaseApplicationImpl.getApplication());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a(paramCharSequence);
  }
  
  public void show()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetToast = this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
  }
  
  public void show(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.toast.QQToastWrapper
 * JD-Core Version:    0.7.0.1
 */