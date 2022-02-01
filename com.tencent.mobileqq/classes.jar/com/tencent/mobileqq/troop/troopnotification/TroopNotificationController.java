package com.tencent.mobileqq.troop.troopnotification;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public abstract class TroopNotificationController
{
  protected static String d;
  protected AppRuntime c;
  
  public TroopNotificationController(AppRuntime paramAppRuntime)
  {
    this.c = paramAppRuntime;
    d = a();
  }
  
  private String a()
  {
    String str2 = d();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "TroopNotificationController unknown";
    }
    return str1;
  }
  
  @CallSuper
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "clearAllMsgCache");
    }
  }
  
  public abstract void c();
  
  @Nullable
  protected abstract String d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationController
 * JD-Core Version:    0.7.0.1
 */