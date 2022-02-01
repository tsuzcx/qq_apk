package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoReq;

public class QualityReporter
{
  public static void a(AbsReadInJoyVideoReportData paramAbsReadInJoyVideoReportData)
  {
    ThreadManager.excute(new QualityReporter.1(paramAbsReadInJoyVideoReportData), 16, null, true);
  }
  
  private static void b(cc_sso_report_svr.ReportInfoReq paramReportInfoReq)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
    localNewIntent.putExtra("cmd", "FeedsContentCenter.QualityReport");
    localNewIntent.putExtra("data", paramReportInfoReq.toByteArray());
    localNewIntent.setObserver(new QualityReporter.ResponseObserver(localNewIntent));
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.QualityReporter
 * JD-Core Version:    0.7.0.1
 */