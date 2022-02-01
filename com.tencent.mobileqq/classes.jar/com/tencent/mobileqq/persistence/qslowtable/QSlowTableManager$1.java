package com.tencent.mobileqq.persistence.qslowtable;

import azoq;
import azor;
import com.tencent.qphone.base.util.QLog;

public class QSlowTableManager$1
  implements Runnable
{
  public QSlowTableManager$1(azor paramazor) {}
  
  public void run()
  {
    try
    {
      if (!azor.a(this.this$0).verifyAuthentication()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager.1
 * JD-Core Version:    0.7.0.1
 */