package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyGlobalReporter$3
  implements Runnable
{
  ReadInJoyGlobalReporter$3(ReadInJoyGlobalReporter paramReadInJoyGlobalReporter) {}
  
  public void run()
  {
    try
    {
      if (ReadInJoyGlobalReporter.b(this.this$0) == 1)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.this$0.j);
        ReadInJoyGlobalReporter.a(this.this$0, 0);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyGlobalReporter", 2, "unRegisterScreenListener");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unRegisterScreenListener:");
        localStringBuilder.append(localException.toString());
        QLog.e("ReadInJoyGlobalReporter", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter.3
 * JD-Core Version:    0.7.0.1
 */