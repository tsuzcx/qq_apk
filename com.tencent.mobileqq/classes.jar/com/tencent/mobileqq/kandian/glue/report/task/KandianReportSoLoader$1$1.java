package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
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
        FileUtils.deleteDirectory(KandianReportSoLoader.b());
        boolean bool = KandianReportSoLoader.d();
        IPublicAccountReportUtils localIPublicAccountReportUtils1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        if (!bool) {
          break label170;
        }
        i = 1;
        localIPublicAccountReportUtils1.publicAccountReportClickEvent(null, "", "0X8009A1C", "0X8009A1C", 0, i, "", "", "", "copy file step", false);
        if (!bool)
        {
          QLog.d("kandianreport.KandianReportSoLoader", 1, "copy fail, delete so");
          FileUtils.deleteDirectory(KandianReportSoLoader.c());
        }
      }
      catch (Throwable localThrowable)
      {
        IPublicAccountReportUtils localIPublicAccountReportUtils2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("copy file exception : ");
        localStringBuilder.append(localThrowable.toString());
        localIPublicAccountReportUtils2.publicAccountReportClickEvent(null, "", "0X8009A1C", "0X8009A1C", 0, 0, "", "", "", localStringBuilder.toString(), false);
        QLog.d("kandianreport.KandianReportSoLoader", 1, "jscjni downloadSoFiles read so config fail");
      }
      if (this.this$0.a != null) {
        this.this$0.a.run();
      }
      return;
      label170:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.KandianReportSoLoader.1.1
 * JD-Core Version:    0.7.0.1
 */