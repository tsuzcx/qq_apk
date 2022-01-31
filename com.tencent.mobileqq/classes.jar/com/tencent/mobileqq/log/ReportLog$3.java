package com.tencent.mobileqq.log;

import ardv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ReportLog$3
  implements Runnable
{
  public ReportLog$3(ardv paramardv, MobileQQ paramMobileQQ) {}
  
  public void run()
  {
    if ((this.a instanceof BaseApplicationImpl))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        localObject = (QQAppInterface)localObject;
        QLog.d("ReportLog", 1, "uncaughtException QQAppInterface exit.");
        ((QQAppInterface)localObject).b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.log.ReportLog.3
 * JD-Core Version:    0.7.0.1
 */