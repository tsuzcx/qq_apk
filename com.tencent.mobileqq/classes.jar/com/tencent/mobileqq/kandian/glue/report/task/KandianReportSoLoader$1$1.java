package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class KandianReportSoLoader$1$1
  implements Runnable
{
  KandianReportSoLoader$1$1(KandianReportSoLoader.1 param1) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        FileUtils.deleteDirectory(KandianReportSoLoader.i());
        boolean bool = KandianReportSoLoader.j();
        if (!bool) {
          break label144;
        }
        i = 1;
        PublicAccountReportUtils.a(null, "", "0X8009A1C", "0X8009A1C", 0, i, "", "", "", "copy file step", false);
        if (!bool)
        {
          QLog.d("kandianreport.KandianReportSoLoader", 1, "copy fail, delete so");
          FileUtils.deleteDirectory(KandianReportSoLoader.k());
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("copy file exception : ");
        localStringBuilder.append(localThrowable.toString());
        PublicAccountReportUtils.a(null, "", "0X8009A1C", "0X8009A1C", 0, 0, "", "", "", localStringBuilder.toString(), false);
        QLog.d("kandianreport.KandianReportSoLoader", 1, "jscjni downloadSoFiles read so config fail");
      }
      if (this.this$0.a != null) {
        this.this$0.a.run();
      }
      return;
      label144:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.KandianReportSoLoader.1.1
 * JD-Core Version:    0.7.0.1
 */