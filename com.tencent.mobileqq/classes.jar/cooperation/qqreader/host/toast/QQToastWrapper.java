package cooperation.qqreader.host.toast;

import android.content.Context;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;

public class QQToastWrapper
  implements Toast
{
  private android.widget.Toast jdField_a_of_type_AndroidWidgetToast;
  private bbmy jdField_a_of_type_Bbmy;
  
  public static Toast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramContext = new QQToastWrapper();
    paramContext.jdField_a_of_type_Bbmy = bbmy.a(BaseApplicationImpl.getApplication(), paramInt2, paramCharSequence, paramInt1);
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
    if (this.jdField_a_of_type_Bbmy == null) {
      this.jdField_a_of_type_Bbmy = new bbmy(BaseApplicationImpl.getApplication());
    }
    this.jdField_a_of_type_Bbmy.d(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_Bbmy == null) {
      this.jdField_a_of_type_Bbmy = new bbmy(BaseApplicationImpl.getApplication());
    }
    this.jdField_a_of_type_Bbmy.a(paramCharSequence);
  }
  
  public void show()
  {
    if (this.jdField_a_of_type_Bbmy == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetToast = this.jdField_a_of_type_Bbmy.a();
  }
  
  public void show(int paramInt)
  {
    if (this.jdField_a_of_type_Bbmy == null) {
      return;
    }
    this.jdField_a_of_type_Bbmy.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.host.toast.QQToastWrapper
 * JD-Core Version:    0.7.0.1
 */