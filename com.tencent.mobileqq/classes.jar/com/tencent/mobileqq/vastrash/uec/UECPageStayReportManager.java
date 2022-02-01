package com.tencent.mobileqq.vastrash.uec;

import NS_USER_ACTION_REPORT.QQStayTimeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.servlet.MobileReportServlet;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.mobilereport.UserCommReportBuilder;
import cooperation.vip.utils.Tools;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class UECPageStayReportManager
{
  public static long a;
  private final ArrayList<QQStayTimeInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_Long = 3L;
  }
  
  private long a()
  {
    QLog.i("UECPageStayReportManager", 1, "UECReportTimeLongTask time = " + jdField_a_of_type_Long);
    return jdField_a_of_type_Long * 1000L;
  }
  
  public static UECPageStayReportManager a()
  {
    return UECPageStayReportManager.SingletonInstance.a();
  }
  
  public static void a(UECPageStayTimeReport.ReportItem paramReportItem)
  {
    if (!a()) {
      QLog.e("UECPageStayReportManager", 1, "startReport switch close");
    }
    do
    {
      return;
      QQStayTimeInfo localQQStayTimeInfo = new QQStayTimeInfo();
      localQQStayTimeInfo.enter_time = paramReportItem.jdField_a_of_type_Long;
      localQQStayTimeInfo.page_info = paramReportItem.jdField_a_of_type_JavaLangString;
      localQQStayTimeInfo.page_info_ext = paramReportItem.jdField_b_of_type_JavaLangString;
      localQQStayTimeInfo.report_time = paramReportItem.jdField_b_of_type_Long;
      localQQStayTimeInfo.stay_time = paramReportItem.a();
      a().a(localQQStayTimeInfo);
    } while (!QLog.isColorLevel());
    QLog.e("UECPageStayReportManager", 2, "startReport:  = " + paramReportItem.toString());
  }
  
  private void a(ArrayList<QQStayTimeInfo> paramArrayList)
  {
    b(paramArrayList);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return;
    }
    MobileReportServlet.a(5, localAppRuntime, paramArrayList, new UserCommReportBuilder().setUin(localAppRuntime.getLongAccountUin()).setNetwork_type(Tools.c()).build());
  }
  
  private static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_BusinessStayTimeReportSwitch", 1) == 1;
  }
  
  private void b(ArrayList<QQStayTimeInfo> paramArrayList) {}
  
  public void a(QQStayTimeInfo paramQQStayTimeInfo)
  {
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramQQStayTimeInfo);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("UECPageStayReportManager", 4, "start report!!!");
          }
          ThreadManager.post(new UECPageStayReportManager.1(this), 2, null, true);
          return;
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("UECPageStayReportManager", 4, "wait to report...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayReportManager
 * JD-Core Version:    0.7.0.1
 */