package com.tencent.mobileqq.vas.qvip.util;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.pb.vasreporter.VasClubAmsReport.AdvReportReq;
import com.tencent.qphone.base.util.QLog;

public class ReportAmsAdvHelper
{
  public static void a(int paramInt, String paramString)
  {
    VasClubAmsReport.AdvReportReq localAdvReportReq = new VasClubAmsReport.AdvReportReq();
    localAdvReportReq.report_type.set(paramInt);
    localAdvReportReq.report_url.set(paramString);
    try
    {
      ((ILiveDelivery)RemoteProxy.getProxy(LiveDelivery.class)).requestPbMsfSSO("qqclubofficialaccount.AdvReport", new String(localAdvReportReq.toByteArray(), "ISO8859_1"), null, -1, new ReportAmsAdvHelper.1(paramInt, paramString));
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("reportAmsAdv Exception=");
      localStringBuilder2.append(localException);
      QLog.e("ReportAmsAdvHelper", 2, localStringBuilder2.toString());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("reportAmsAdv send, reportType =");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append(" reportUrl =");
      localStringBuilder1.append(paramString);
      QLog.d("ReportAmsAdvHelper", 2, localStringBuilder1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.util.ReportAmsAdvHelper
 * JD-Core Version:    0.7.0.1
 */