package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ProteusJsHelper$2
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject = new File(this.a);
      if (((File)localObject).exists())
      {
        localObject = FileUtils.readFileToString((File)localObject);
        if (KandianReportSoLoader.a())
        {
          ProteusJsHelper.a((String)localObject, this.b);
          return;
        }
        if (!KandianReportSoLoader.c())
        {
          QLog.d("kandianreport.ProteusJsHelper", 1, "so not ready, now download");
          KandianReportSoLoader.a(new ProteusJsHelper.2.1(this, (String)localObject));
          return;
        }
        KandianReportSoLoader.a();
        ProteusJsHelper.b((String)localObject, this.b);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("kandianreport.ProteusJsHelper", 2, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.ProteusJsHelper.2
 * JD-Core Version:    0.7.0.1
 */