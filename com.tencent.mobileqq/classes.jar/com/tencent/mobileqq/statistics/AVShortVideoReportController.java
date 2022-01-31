package com.tencent.mobileqq.statistics;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class AVShortVideoReportController
{
  public static String a = "";
  
  private static String a(String paramString1, String paramString2, String paramString3, AVShortVideoReportController.ReportData paramReportData, int paramInt)
  {
    QLog.e("AVShortVideoReportController", 1, "getReportingDetail");
    paramString1 = new StringBuilder(64);
    paramString1.append(paramString2).append('|');
    paramString1.append(paramString3).append('|');
    paramString1.append("${count_unknown}").append('|');
    paramString1.append(paramReportData.a).append('|');
    paramString1.append(paramReportData.b).append('|');
    paramString1.append(paramReportData.c).append('|');
    paramString1.append(paramReportData.d).append('|');
    paramString1.append(paramReportData.e).append('|');
    paramString1.append(paramReportData.f).append('|');
    paramString1.append(paramReportData.g).append('|');
    paramString1.append(paramReportData.h).append('|');
    paramString1.append(paramReportData.i).append('|');
    paramString1.append(paramReportData.j).append('|');
    paramString1.append(paramReportData.k).append('|');
    paramString1.append(paramReportData.l).append('|');
    paramString1.append(paramReportData.m).append('|');
    paramString1.append(paramReportData.n).append('|');
    paramString1.append(paramReportData.o).append('|');
    paramString1.append(paramReportData.p).append('|');
    paramString1.append(paramReportData.q).append('|');
    paramString1.append(paramReportData.r).append('|');
    paramString1.append(paramReportData.s).append('|');
    paramString1.append(paramReportData.t).append('|');
    paramString1.append(paramReportData.u).append('|');
    paramString1.append(paramReportData.v).append('|');
    return paramString1.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, AVShortVideoReportController.ReportData paramReportData)
  {
    paramString1 = a(paramString2, paramString1, paramString3, paramReportData, 1);
    if (QLog.isColorLevel()) {
      QLog.i("AVShortVideoReportController", 2, "POST getReportingDetail=" + paramString1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.AVShortVideoReportController
 * JD-Core Version:    0.7.0.1
 */