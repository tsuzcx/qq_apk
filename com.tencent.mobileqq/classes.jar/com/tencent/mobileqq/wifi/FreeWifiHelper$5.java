package com.tencent.mobileqq.wifi;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class FreeWifiHelper$5
  implements Runnable
{
  FreeWifiHelper$5(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692612);
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.d, str, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener).show();
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398667);
      FreeWifiHelper.a("0X80094F2");
      return;
    }
    if ((i != 2) && (i != 5))
    {
      if (i == 3)
      {
        FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398670);
        FreeWifiHelper.a("0X80094F3");
        return;
      }
      if (i == 4)
      {
        FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398689);
        FreeWifiHelper.a("0X80094F1");
      }
    }
    else
    {
      FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398667);
      FreeWifiHelper.a("0X80094F1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.5
 * JD-Core Version:    0.7.0.1
 */