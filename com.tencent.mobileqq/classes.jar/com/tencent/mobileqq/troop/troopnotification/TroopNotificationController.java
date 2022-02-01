package com.tencent.mobileqq.troop.troopnotification;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public abstract class TroopNotificationController
{
  protected static String a;
  protected AppRuntime a;
  
  public TroopNotificationController(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    jdField_a_of_type_JavaLangString = b();
  }
  
  private String b()
  {
    String str2 = a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "TroopNotificationController unknown";
    }
    return str1;
  }
  
  @Nullable
  protected abstract String a();
  
  @CallSuper
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "clearAllMsgCache");
    }
  }
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationController
 * JD-Core Version:    0.7.0.1
 */