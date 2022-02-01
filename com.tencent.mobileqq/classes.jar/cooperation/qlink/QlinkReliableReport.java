package cooperation.qlink;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class QlinkReliableReport
{
  private static QlinkReliableReport a;
  private final Object b = new Object();
  private List<QlinkReliableReport.PerformanceReporting> c;
  private Runnable d;
  
  public static void a()
  {
    QlinkReliableReport localQlinkReliableReport = c();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.f();
    }
  }
  
  private void a(QlinkReliableReport.PerformanceReporting paramPerformanceReporting)
  {
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("addPerformanceReporting:");
      ((StringBuilder)???).append(paramPerformanceReporting);
      QLog.d("QlinkReliableReport", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.b)
    {
      if (this.c == null) {
        this.c = new ArrayList();
      }
      this.c.add(paramPerformanceReporting);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("collectPerformance:tagName[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("]");
      QLog.d("QlinkReliableReport", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = c();
    if (localObject != null) {
      ((QlinkReliableReport)localObject).a(new QlinkReliableReport.PerformanceReporting(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap));
    }
  }
  
  public static void b()
  {
    QlinkReliableReport localQlinkReliableReport = c();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.g();
    }
  }
  
  public static QlinkReliableReport c()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QlinkReliableReport();
        }
      }
      finally {}
    }
    return a;
  }
  
  private static void i()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "start:");
    }
    QlinkReliableReport localQlinkReliableReport = c();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.j();
    }
  }
  
  private void j()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QlinkReliableReport", 2, "doReportPerformance: network is not surpport");
      }
      return;
    }
    synchronized (this.b)
    {
      List localList = this.c;
      this.c = null;
      if (localList != null)
      {
        if (localList.size() == 0) {
          return;
        }
        ??? = StatisticCollector.getInstance(BaseApplication.getContext());
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          QlinkReliableReport.PerformanceReporting localPerformanceReporting = (QlinkReliableReport.PerformanceReporting)localIterator.next();
          ((StatisticCollector)???).collectPerformance(localPerformanceReporting.a(), localPerformanceReporting.b(), localPerformanceReporting.c(), localPerformanceReporting.d(), localPerformanceReporting.e(), localPerformanceReporting.f(), null);
        }
        localList.clear();
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  protected void d() {}
  
  protected void e()
  {
    g();
    try
    {
      a = null;
      return;
    }
    finally {}
  }
  
  public void f()
  {
    QLog.d("QlinkReliableReport", 2, "doStartReportTimer");
    if (this.d == null)
    {
      this.d = new QlinkReliableReport.1(this);
      ThreadManager.getSubThreadHandler().postDelayed(this.d, 60000L);
    }
  }
  
  public void g()
  {
    QLog.d("QlinkReliableReport", 2, "doStopReportTimer");
    if (this.d != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.d);
      this.d = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QlinkReliableReport
 * JD-Core Version:    0.7.0.1
 */