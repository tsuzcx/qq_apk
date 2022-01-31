package com.tencent.mobileqq.persistence.qslowtable;

import aulz;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class QSlowTableManager$1
  implements Runnable
{
  public QSlowTableManager$1(aulz paramaulz) {}
  
  public void run()
  {
    try
    {
      if (!aulz.a(this.this$0).verifyAuthentication()) {
        QLog.e("QSlowTableManager", 1, "db verifyAuthentication failed!");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QSlowTableManager", 1, "db verifyAuthentication Exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager.1
 * JD-Core Version:    0.7.0.1
 */