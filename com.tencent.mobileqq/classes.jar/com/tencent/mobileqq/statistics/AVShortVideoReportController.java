package com.tencent.mobileqq.statistics;

import NearbyGroup.LBSInfo;
import android.content.Intent;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class AVShortVideoReportController
{
  private static Pair<LBSInfo, Long> jdField_a_of_type_AndroidUtilPair;
  public static String a = "";
  static boolean jdField_a_of_type_Boolean = false;
  
  private static String a(String paramString1, String paramString2, String paramString3, AVShortVideoReportController.ReportData paramReportData, int paramInt)
  {
    QLog.e("AVShortVideoReportController", 1, "getReportingDetail");
    paramString1 = new StringBuilder(64);
    paramString1.append(paramString2);
    paramString1.append('|');
    paramString1.append(paramString3);
    paramString1.append('|');
    paramString1.append("${count_unknown}");
    paramString1.append('|');
    paramString1.append(paramReportData.a);
    paramString1.append('|');
    paramString1.append(paramReportData.b);
    paramString1.append('|');
    paramString1.append(paramReportData.c);
    paramString1.append('|');
    paramString1.append(paramReportData.d);
    paramString1.append('|');
    paramString1.append(paramReportData.e);
    paramString1.append('|');
    paramString1.append(paramReportData.f);
    paramString1.append('|');
    paramString1.append(paramReportData.g);
    paramString1.append('|');
    paramString1.append(paramReportData.h);
    paramString1.append('|');
    paramString1.append(paramReportData.i);
    paramString1.append('|');
    paramString1.append(paramReportData.j);
    paramString1.append('|');
    paramString1.append(paramReportData.k);
    paramString1.append('|');
    paramString1.append(paramReportData.l);
    paramString1.append('|');
    paramString1.append(paramReportData.m);
    paramString1.append('|');
    paramString1.append(paramReportData.n);
    paramString1.append('|');
    paramString1.append(paramReportData.o);
    paramString1.append('|');
    paramString1.append(paramReportData.p);
    paramString1.append('|');
    paramString1.append(paramReportData.q);
    paramString1.append('|');
    paramString1.append(paramReportData.r);
    paramString1.append('|');
    paramString1.append(paramReportData.s);
    paramString1.append('|');
    paramString1.append(paramReportData.t);
    paramString1.append('|');
    paramString1.append(paramReportData.u);
    paramString1.append('|');
    paramString1.append(paramReportData.v);
    paramString1.append('|');
    return paramString1.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, AVShortVideoReportController.ReportData paramReportData)
  {
    paramString1 = a(paramString2, paramString1, paramString3, paramReportData, 1);
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("POST getReportingDetail=");
      paramString3.append(paramString1);
      QLog.i("AVShortVideoReportController", 2, paramString3.toString());
    }
    paramString3 = new Intent();
    paramString3.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
    paramString3.putExtra("reporting_tag", paramString2);
    paramString3.putExtra("reporting_detail", paramString1);
    paramString3.putExtra("reporting_count", 1);
    paramString3.putExtra("is_runtime", 0);
    BaseApplicationImpl.getApplication().sendBroadcast(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.AVShortVideoReportController
 * JD-Core Version:    0.7.0.1
 */