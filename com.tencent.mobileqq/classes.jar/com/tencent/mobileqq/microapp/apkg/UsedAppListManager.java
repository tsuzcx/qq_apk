package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class UsedAppListManager
  implements Manager
{
  private static final String TAG = "UsedAppListManager";
  
  public UsedAppListManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UsedAppListManager", 2, "UsedAppListManager init");
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.UsedAppListManager
 * JD-Core Version:    0.7.0.1
 */