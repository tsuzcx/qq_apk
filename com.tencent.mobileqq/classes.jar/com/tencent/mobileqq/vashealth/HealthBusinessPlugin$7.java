package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class HealthBusinessPlugin$7
  implements QQPermissionCallback
{
  HealthBusinessPlugin$7(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("permission of ");
      paramArrayOfString.append(this.jdField_a_of_type_JavaLangString);
      paramArrayOfString.append(" is granted.");
      QLog.d("HealthBusinessPlugin", 2, paramArrayOfString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.7
 * JD-Core Version:    0.7.0.1
 */