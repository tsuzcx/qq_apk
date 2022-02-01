package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class PTSReport
{
  public static void a(String paramString1, String paramString2)
  {
    a("0X800A833", "", "", "", new PTSReport.R5Builder().a("type", paramString2).a("msg", paramString1).a());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reportData], actionName = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", r2 = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", r3 = ");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(", r4 = ");
    localStringBuilder.append(paramString4);
    localStringBuilder.append(", r5 = ");
    localStringBuilder.append(paramString5);
    QLog.i("PTSReport", 1, localStringBuilder.toString());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, paramString2, paramString3, paramString4, paramString5, false);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a("0X800A832", "", "", "", new PTSReport.R5Builder().a("type", paramString2).a("msg", paramString1).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSReport
 * JD-Core Version:    0.7.0.1
 */