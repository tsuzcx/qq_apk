package com.tencent.mobileqq.vfs;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.CancellationSignalCompat;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class ReportCallback
  implements VFSReportCallback
{
  private static boolean a = false;
  private static CopyOnWriteArrayList<Map<String, Object>> b = new CopyOnWriteArrayList();
  private static CopyOnWriteArrayList<Throwable> c = new CopyOnWriteArrayList();
  
  private void a(Throwable paramThrowable)
  {
    CaughtExceptionReport.a(paramThrowable);
  }
  
  public static ReportCallback b()
  {
    return ReportCallback.SHolder.a();
  }
  
  public void a()
  {
    try
    {
      a = true;
      Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("statisticsReportCache params -> ");
          localStringBuilder.append(localMap);
          QLog.d("VFSRegisterProxy", 2, localStringBuilder.toString());
        }
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance((String)localObject, "vfs_statistics_tag", true, 0L, 0L, (HashMap)localMap, null);
      }
      b.clear();
      localObject = c.iterator();
      while (((Iterator)localObject).hasNext()) {
        a((Throwable)((Iterator)localObject).next());
      }
      c.clear();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("VFSRegisterProxy", 1, "statisticsReportCache report error!", localException);
    }
  }
  
  public void deleteFiles(CancellationSignalCompat paramCancellationSignalCompat) {}
  
  public void reportError(Throwable paramThrowable)
  {
    QLog.e("VFSRegisterProxy", 1, paramThrowable, new Object[0]);
    if (a)
    {
      a(paramThrowable);
      return;
    }
    c.add(paramThrowable);
  }
  
  public void statistics(String paramString, int paramInt, Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      try
      {
        paramMap.put("id", paramString);
        paramMap.put("phase", String.valueOf(paramInt));
        if (a)
        {
          paramString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString, "vfs_statistics_tag", true, 0L, 0L, (HashMap)paramMap, null);
        }
        else
        {
          b.add(paramMap);
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("report params -> ");
          paramString.append(paramMap);
          paramString.append(", mCanAccurReport = ");
          paramString.append(a);
          QLog.d("VFSRegisterProxy", 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.d("VFSRegisterProxy", 1, "vfs report error!", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vfs.ReportCallback
 * JD-Core Version:    0.7.0.1
 */