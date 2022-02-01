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
  private static CopyOnWriteArrayList<Map<String, Object>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private static boolean jdField_a_of_type_Boolean = false;
  private static CopyOnWriteArrayList<Throwable> b = new CopyOnWriteArrayList();
  
  public static ReportCallback a()
  {
    return ReportCallback.SHolder.a();
  }
  
  private void a(Throwable paramThrowable)
  {
    CaughtExceptionReport.a(paramThrowable);
  }
  
  public void a()
  {
    try
    {
      jdField_a_of_type_Boolean = true;
      Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
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
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      localObject = b.iterator();
      while (((Iterator)localObject).hasNext()) {
        a((Throwable)((Iterator)localObject).next());
      }
      b.clear();
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
    if (jdField_a_of_type_Boolean)
    {
      a(paramThrowable);
      return;
    }
    b.add(paramThrowable);
  }
  
  public void statistics(String paramString, int paramInt, Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      try
      {
        paramMap.put("id", paramString);
        paramMap.put("phase", String.valueOf(paramInt));
        if (jdField_a_of_type_Boolean)
        {
          paramString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString, "vfs_statistics_tag", true, 0L, 0L, (HashMap)paramMap, null);
        }
        else
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramMap);
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("report params -> ");
          paramString.append(paramMap);
          paramString.append(", mCanAccurReport = ");
          paramString.append(jdField_a_of_type_Boolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vfs.ReportCallback
 * JD-Core Version:    0.7.0.1
 */