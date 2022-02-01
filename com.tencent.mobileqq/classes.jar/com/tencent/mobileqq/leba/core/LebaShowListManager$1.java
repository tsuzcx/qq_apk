package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class LebaShowListManager$1
  implements Runnable
{
  LebaShowListManager$1(LebaShowListManager paramLebaShowListManager, AppRuntime paramAppRuntime, long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, boolean paramBoolean2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        i = (int)this.jdField_a_of_type_Long;
        boolean bool = this.jdField_a_of_type_Boolean;
        if (this.jdField_b_of_type_Long != -9223372036854775808L) {
          continue;
        }
        l = this.c;
        i = localIRedTouchManager.updateSettingById(i, bool, l, this.jdField_b_of_type_Boolean);
      }
      catch (Exception localException)
      {
        long l;
        int j = -2;
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.lebatab.mgr", 2, localException.toString());
        i = j;
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, result = " + i);
      }
      return;
      l = this.jdField_b_of_type_Long;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaShowListManager.1
 * JD-Core Version:    0.7.0.1
 */