package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class ReadInJoyGlobalReporter$1
  extends TimerTask
{
  ReadInJoyGlobalReporter$1(ReadInJoyGlobalReporter paramReadInJoyGlobalReporter) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TimerTask heart = ");
      ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTimeMillis());
      QLog.i("ReadInJoyGlobalReporter", 2, ((StringBuilder)localObject).toString());
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      this.this$0.b((QQAppInterface)localObject, NetConnInfoCenter.getServerTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter.1
 * JD-Core Version:    0.7.0.1
 */