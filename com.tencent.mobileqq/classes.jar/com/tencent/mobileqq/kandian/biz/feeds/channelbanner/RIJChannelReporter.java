package com.tencent.mobileqq.kandian.biz.feeds.channelbanner;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public class RIJChannelReporter
{
  public static void a(int paramInt, String paramString)
  {
    try
    {
      ReadInJoyChannelViewPagerController.a("0X8009B94", "", new RIJTransMergeKanDianReport.ReportR5Builder().addString("source", paramString).addChannelId(paramInt).addKandianModeNew().addStringNotThrow("style", 0).build());
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("RIJChannelReporter", 2, "report click channel bar exception, e = ", paramString);
    }
  }
  
  public static void a(BaseReportData paramBaseReportData, int paramInt)
  {
    QLog.d("RIJChannelReporter", 1, new Object[] { "reportChannelExposure = ", paramBaseReportData });
    if (paramBaseReportData != null)
    {
      TabChannelCoverInfo localTabChannelCoverInfo = paramBaseReportData.a;
      if (localTabChannelCoverInfo != null) {
        ThreadManager.executeOnSubThread(new RIJChannelReporter.1(localTabChannelCoverInfo, paramBaseReportData, paramInt));
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QLog.d("RIJChannelReporter", 1, new Object[] { "actionName = ", paramString1, "\n", "r5 = ", paramString2 });
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, "", "", "", paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter
 * JD-Core Version:    0.7.0.1
 */