package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.pts.utils.PTSReportUtil.DefaultPTSReport;

final class PTSHelper$1
  extends PTSReportUtil.DefaultPTSReport
{
  public void reportEvent(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = new PTSReport.R5Builder().a("tag", paramString1).a("msg", paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("");
    paramString2.append(paramInt);
    PTSReport.a("0X800B241", "", "", "", paramString1.a("reportType", paramString2.toString()).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSHelper.1
 * JD-Core Version:    0.7.0.1
 */