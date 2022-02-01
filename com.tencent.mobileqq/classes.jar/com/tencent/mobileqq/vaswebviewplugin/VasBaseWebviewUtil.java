package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.CrashStepStatsEntry;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;

public class VasBaseWebviewUtil
{
  public static final String TAG = "VasBaseWebviewUtil";
  
  public static void doSonicErrorCodeReport(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_sonic_errorcode_report_hour", localStringBuilder.toString(), true);
  }
  
  public static void doSonicSpeedReport(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, int paramInt3, int paramInt4, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong5);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong6);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong7);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong8);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong9);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong10);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong11);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_sonic_speed_report", localStringBuilder.toString(), true);
  }
  
  public static void reportNetworkSpeedTimeFromX5(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, String paramString4, String paramString5, String paramString6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong5);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong6);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong7);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong8);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong9);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong10);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong11);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLong12);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString6);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_network_speed_time_from_x5", localStringBuilder.toString(), true);
  }
  
  public static void reportNetworkSpeedTimeFromX5(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, String paramString4)
  {
    reportNetworkSpeedTimeFromX5(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, 0L, 0L, 0L, 0L, 0L, 0L, paramString4, "", "");
  }
  
  public static void reportQBWebInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, int paramInt3, int paramInt4, String paramString8, String paramString9)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString6);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString7);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString8);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString9);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_qbwebview_report", localStringBuilder.toString(), true);
  }
  
  public static void reportVasStatus(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "0";
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_status_report", localStringBuilder.toString(), true);
  }
  
  public static void reportX5SpeedData(SwiftBrowserStatistics paramSwiftBrowserStatistics)
  {
    if ((paramSwiftBrowserStatistics != null) && (!paramSwiftBrowserStatistics.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramSwiftBrowserStatistics.jdField_a_of_type_JavaLangString)) && (paramSwiftBrowserStatistics.e != 0L))
    {
      paramSwiftBrowserStatistics.jdField_a_of_type_Boolean = true;
      String str3 = paramSwiftBrowserStatistics.jdField_a_of_type_JavaLangString;
      String str4 = HttpUtil.getNetWorkTypeByStr();
      int j = QbSdk.getTbsVersion(BaseApplication.getContext());
      String str2 = paramSwiftBrowserStatistics.jdField_c_of_type_JavaLangString;
      boolean bool = TextUtils.isEmpty(str2);
      int i = 0;
      String str1 = str2;
      if (!bool)
      {
        str1 = str2;
        if (str2.contains("?")) {
          str1 = str2.substring(0, str2.indexOf("?"));
        }
      }
      int k = paramSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b;
      if (paramSwiftBrowserStatistics.t) {
        i = 2;
      } else if (SwiftBrowserStatistics.p) {
        i = 1;
      }
      long l1 = paramSwiftBrowserStatistics.b;
      long l2 = paramSwiftBrowserStatistics.jdField_c_of_type_Long;
      long l3 = paramSwiftBrowserStatistics.r;
      long l4 = paramSwiftBrowserStatistics.f;
      long l5 = paramSwiftBrowserStatistics.g;
      long l6 = paramSwiftBrowserStatistics.e;
      if (QLog.isColorLevel()) {
        QLog.d("VasBaseWebviewUtil", 2, "reportX5SpeedData");
      }
      reportNetworkSpeedTimeFromX5(str1, String.valueOf(k), i, 0, j, str4, l1, l2, l3, l4, l5, l6, str3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil
 * JD-Core Version:    0.7.0.1
 */