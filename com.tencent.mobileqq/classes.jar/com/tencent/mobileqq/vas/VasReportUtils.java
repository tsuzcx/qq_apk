package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.statistics.DcReportUtil;

public class VasReportUtils
{
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    paramString6 = new StringBuilder();
    paramString6.append(paramString1);
    paramString6.append("|");
    paramString6.append(paramString2);
    paramString6.append("|");
    paramString6.append(paramString3);
    paramString6.append("|");
    paramString6.append(paramString4);
    paramString6.append("|");
    paramString6.append(paramString5);
    paramString6.append("|");
    paramString6.append(paramString7);
    paramString6.append("|");
    paramString6.append(paramString8);
    paramString6.append("|");
    paramString6.append(paramString9);
    paramString6.append("|");
    paramString6.append(paramString10);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_errorcode_report", paramString6.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasReportUtils
 * JD-Core Version:    0.7.0.1
 */