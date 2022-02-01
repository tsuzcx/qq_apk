package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.DcReportUtil;

public class VasWebviewUtils
{
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "0";
    }
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramInt1).append("|");
    localStringBuilder.append(paramInt2).append("|");
    localStringBuilder.append(paramInt3).append("|");
    localStringBuilder.append(paramInt4).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_status_report", localStringBuilder.toString(), true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    localStringBuilder.append(paramString3).append("|");
    localStringBuilder.append(paramInt1).append("|");
    localStringBuilder.append(paramInt2).append("|");
    localStringBuilder.append(paramInt3).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_sonic_errorcode_report_hour", localStringBuilder.toString(), true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, int paramInt3, int paramInt4, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    localStringBuilder.append(paramString3).append("|");
    localStringBuilder.append(paramInt1).append("|");
    localStringBuilder.append(paramInt2).append("|");
    localStringBuilder.append(paramLong1).append("|");
    localStringBuilder.append(paramLong2).append("|");
    localStringBuilder.append(paramLong3).append("|");
    localStringBuilder.append(paramLong4).append("|");
    localStringBuilder.append(paramLong5).append("|");
    localStringBuilder.append(paramLong6).append("|");
    localStringBuilder.append(paramLong7).append("|");
    localStringBuilder.append(paramLong8).append("|");
    localStringBuilder.append(paramLong9).append("|");
    localStringBuilder.append(paramLong10).append("|");
    localStringBuilder.append(paramLong11).append("|");
    localStringBuilder.append(paramInt3).append("|");
    localStringBuilder.append(paramInt4).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_sonic_speed_report", localStringBuilder.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtils
 * JD-Core Version:    0.7.0.1
 */