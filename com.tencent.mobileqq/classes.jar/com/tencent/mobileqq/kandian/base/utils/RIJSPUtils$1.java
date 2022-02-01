package com.tencent.mobileqq.kandian.base.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

final class RIJSPUtils$1
  implements Runnable
{
  RIJSPUtils$1(boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    Object localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), this.jdField_a_of_type_Boolean, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).apply();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete data in sp successful ! key : ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("RIJSPUtils", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJSPUtils.1
 * JD-Core Version:    0.7.0.1
 */