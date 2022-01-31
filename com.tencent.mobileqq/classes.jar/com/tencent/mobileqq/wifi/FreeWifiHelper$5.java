package com.tencent.mobileqq.wifi;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import babr;
import bafb;
import bbrm;

public final class FreeWifiHelper$5
  implements Runnable
{
  public FreeWifiHelper$5(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131627078);
    babr.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.d, str, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener).show();
    if (this.jdField_a_of_type_Int == 1)
    {
      bbrm.b(this.jdField_a_of_type_AndroidAppActivity, 398667);
      bbrm.a("0X80094F2");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 5))
      {
        bbrm.b(this.jdField_a_of_type_AndroidAppActivity, 398667);
        bbrm.a("0X80094F1");
        return;
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        bbrm.b(this.jdField_a_of_type_AndroidAppActivity, 398670);
        bbrm.a("0X80094F3");
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    bbrm.b(this.jdField_a_of_type_AndroidAppActivity, 398689);
    bbrm.a("0X80094F1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.5
 * JD-Core Version:    0.7.0.1
 */