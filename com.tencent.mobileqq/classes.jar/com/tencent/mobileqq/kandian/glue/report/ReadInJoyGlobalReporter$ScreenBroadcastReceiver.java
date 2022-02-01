package com.tencent.mobileqq.kandian.glue.report;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyGlobalReporter$ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString = null;
  
  private ReadInJoyGlobalReporter$ScreenBroadcastReceiver(ReadInJoyGlobalReporter paramReadInJoyGlobalReporter) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("ScreenBroadcastReceiver ACTION_SCREEN_ON appstatus=");
        paramContext.append(ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter));
        QLog.d("ReadInJoyGlobalReporter", 2, paramContext.toString());
      }
    }
    else if ("android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("ScreenBroadcastReceiver ACTION_SCREEN_OFF appstatus = ");
        paramContext.append(ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter));
        QLog.d("ReadInJoyGlobalReporter", 2, paramContext.toString());
      }
      if (ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter) == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter.a();
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter.f();
      }
    }
    else if ("android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("ScreenBroadcastReceiver ACTION_USER_PRESENT app status=");
        paramContext.append(ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter));
        QLog.d("ReadInJoyGlobalReporter", 2, paramContext.toString());
      }
      if ((ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter) == 2) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)))
      {
        paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (paramContext != null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoyGlobalReporter.a(paramContext, NetConnInfoCenter.getServerTimeMillis());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */