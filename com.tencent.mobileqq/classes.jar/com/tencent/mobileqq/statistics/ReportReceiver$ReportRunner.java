package com.tencent.mobileqq.statistics;

import android.content.Intent;
import apcg;
import bcjy;
import bdkg;
import bdll;
import bnyy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModel;
import mqq.app.AppRuntime;

class ReportReceiver$ReportRunner
  implements Runnable
{
  private Intent a;
  
  public ReportReceiver$ReportRunner(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  private void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {}
    for (;;)
    {
      return;
      localObject = (QQAppInterface)localObject;
      try
      {
        localIntent = this.a;
        i = localIntent.getIntExtra("is_runtime", -1);
        if (i == 1001)
        {
          ((apcg)((QQAppInterface)localObject).getManager(126)).a(localIntent);
          return;
        }
        str1 = localIntent.getStringExtra("reporting_tag");
        str2 = localIntent.getStringExtra("reporting_detail");
        j = localIntent.getIntExtra("reporting_count", 1);
      }
      catch (Exception localException)
      {
        try
        {
          Intent localIntent;
          int i;
          String str1;
          String str2;
          int j;
          if ("dc02528".equals(str1))
          {
            if ((i == 0) || (i != 1)) {
              continue;
            }
            bcjy.a(str1, (QQAppInterface)localObject, (ReportModel)localIntent.getSerializableExtra("reporting_detail"));
            return;
          }
          if ("dc02181".equals(str1))
          {
            if (i == 0)
            {
              bdkg.b(str1, (QQAppInterface)localObject, str2);
              return;
            }
            if (i != 1) {
              continue;
            }
            bdkg.a(str1, (QQAppInterface)localObject, str2);
            return;
          }
          if ("dc_qqgame".equals(str1))
          {
            bnyy.a().a((AppRuntime)localObject, str1, str2);
            return;
          }
          if (i == 0)
          {
            bdll.b((QQAppInterface)localObject, str1, str2, j);
            return;
          }
          if (i != 1) {
            continue;
          }
          bdll.a((QQAppInterface)localObject, str1, str2, j);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
        localException = localException;
        return;
      }
    }
  }
  
  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportReceiver.ReportRunner
 * JD-Core Version:    0.7.0.1
 */