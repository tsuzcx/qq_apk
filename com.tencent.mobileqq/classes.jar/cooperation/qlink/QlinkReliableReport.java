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
  private static QlinkReliableReport jdField_a_of_type_CooperationQlinkQlinkReliableReport;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private List<QlinkReliableReport.PerformanceReporting> jdField_a_of_type_JavaUtilList;
  
  public static QlinkReliableReport a()
  {
    if (jdField_a_of_type_CooperationQlinkQlinkReliableReport == null) {
      try
      {
        if (jdField_a_of_type_CooperationQlinkQlinkReliableReport == null) {
          jdField_a_of_type_CooperationQlinkQlinkReliableReport = new QlinkReliableReport();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationQlinkQlinkReliableReport;
  }
  
  public static void a()
  {
    QlinkReliableReport localQlinkReliableReport = a();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.e();
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
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(paramPerformanceReporting);
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
    Object localObject = a();
    if (localObject != null) {
      ((QlinkReliableReport)localObject).a(new QlinkReliableReport.PerformanceReporting(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap));
    }
  }
  
  public static void b()
  {
    QlinkReliableReport localQlinkReliableReport = a();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.f();
    }
  }
  
  private static void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkReliableReport", 2, "start:");
    }
    QlinkReliableReport localQlinkReliableReport = a();
    if (localQlinkReliableReport != null) {
      localQlinkReliableReport.i();
    }
  }
  
  private void i()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QlinkReliableReport", 2, "doReportPerformance: network is not surpport");
      }
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList = null;
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
          ((StatisticCollector)???).collectPerformance(localPerformanceReporting.a(), localPerformanceReporting.b(), localPerformanceReporting.a(), localPerformanceReporting.a(), localPerformanceReporting.b(), localPerformanceReporting.a(), null);
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
  
  protected void c() {}
  
  protected void d()
  {
    f();
    try
    {
      jdField_a_of_type_CooperationQlinkQlinkReliableReport = null;
      return;
    }
    finally {}
  }
  
  public void e()
  {
    QLog.d("QlinkReliableReport", 2, "doStartReportTimer");
    if (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      this.jdField_a_of_type_JavaLangRunnable = new QlinkReliableReport.1(this);
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
    }
  }
  
  public void f()
  {
    QLog.d("QlinkReliableReport", 2, "doStopReportTimer");
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qlink.QlinkReliableReport
 * JD-Core Version:    0.7.0.1
 */