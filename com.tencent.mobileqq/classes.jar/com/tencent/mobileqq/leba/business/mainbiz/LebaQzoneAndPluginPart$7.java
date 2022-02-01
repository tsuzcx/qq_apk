package com.tencent.mobileqq.leba.business.mainbiz;

import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QZoneEntryReporterInLeba;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.report.lp.LinkReport;
import java.util.HashMap;

class LebaQzoneAndPluginPart$7
  implements Runnable
{
  LebaQzoneAndPluginPart$7(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, LebaViewItem paramLebaViewItem, QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidWidgetTextView != null) && (this.this$0.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
    try
    {
      this.this$0.a(null, true, this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      ThreadRegulator.a().a(4);
      ThreadRegulator.a().a(4, 2000L);
      this.this$0.jdField_a_of_type_Boolean = true;
      QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
      if (localQZoneManagerImp != null)
      {
        if ((localQZoneManagerImp.a(1) <= 0) && (localQZoneManagerImp.a(2) <= 0))
        {
          Object localObject = new QZoneClickReport.ReportInfo();
          ((QZoneClickReport.ReportInfo)localObject).actionType = "1";
          ((QZoneClickReport.ReportInfo)localObject).subactionType = "0";
          ((QZoneClickReport.ReportInfo)localObject).tabletype = 4;
          ((QZoneClickReport.ReportInfo)localObject).sourceType = "3";
          ((QZoneClickReport.ReportInfo)localObject).sourceFrom = "mainEntrance";
          ((QZoneClickReport.ReportInfo)localObject).sourceTo = "activefeed";
          QZoneClickReport.report(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject, false);
          localObject = new HashMap();
          ((HashMap)localObject).put("source_type", "3");
          ((HashMap)localObject).put("source_from", "mainEntrance");
          ((HashMap)localObject).put("source_to", "activefeed");
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject, null);
        }
        QZoneEntryReporterInLeba.a(localQZoneManagerImp, false, this.this$0.a());
        if ((this.this$0.c != null) && (this.this$0.c.getVisibility() == 0))
        {
          localQZoneManagerImp.c(61);
          localQZoneManagerImp.c(6);
        }
        if (this.this$0.jdField_a_of_type_Int == 3) {
          localQZoneManagerImp.c(3);
        }
        if (this.this$0.jdField_a_of_type_Int == 1013) {
          localQZoneManagerImp.c(1013);
        }
      }
      LinkReport.reportClickQZoneEntry(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("LebaBusinessPartImpl", 1, "clickAction", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.7
 * JD-Core Version:    0.7.0.1
 */