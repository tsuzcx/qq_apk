package com.tencent.mobileqq.persistence.qslowtable;

import com.tencent.qphone.base.util.QLog;

class QSlowTableManager$1
  implements Runnable
{
  QSlowTableManager$1(QSlowTableManager paramQSlowTableManager) {}
  
  public void run()
  {
    try
    {
      if (!QSlowTableManager.a(this.this$0).verifyAuthentication())
      {
        QLog.e("QSlowTableManager", 1, "db verifyAuthentication failed!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QSlowTableManager", 1, "db verifyAuthentication Exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager.1
 * JD-Core Version:    0.7.0.1
 */