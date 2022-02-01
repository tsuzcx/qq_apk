package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;

final class PhoneNumQuickLoginManager$13
  implements DialogInterface.OnClickListener
{
  PhoneNumQuickLoginManager$13(Context paramContext, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, "showUnbindPhoneNumDialog okBtn click");
    paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidContentContext, RegisterPhoneNumActivity.class);
    paramDialogInterface.putExtra("key_register_from", 9);
    paramDialogInterface.putExtra("key_report_extra_from", 2);
    paramDialogInterface.putExtra("key_phone_num", this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.putExtra("key_token", this.b);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
    PhoneNumQuickLoginManager.b("0X800B8D7");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.13
 * JD-Core Version:    0.7.0.1
 */