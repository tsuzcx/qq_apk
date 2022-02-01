package com.tencent.mobileqq.kandian.repo.feeds.preload;

import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;

public class FeedsPreloadDataReport
{
  public static void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    boolean bool1;
    long l;
    if (paramToServiceMsg != null)
    {
      localObject1 = (Long)paramToServiceMsg.getAttribute("feedsRequestBeginTime");
      localObject2 = (Integer)paramToServiceMsg.getAttribute("channelID");
      Long localLong = (Long)paramToServiceMsg.getAttribute("BeginSeq");
      Boolean localBoolean = (Boolean)paramToServiceMsg.getAttribute("hitFeedsPreloadCache");
      if (localBoolean != null) {
        bool1 = localBoolean.booleanValue();
      } else {
        bool1 = false;
      }
      if ((localObject2 != null) && (((Integer)localObject2).intValue() == 0) && (localLong != null) && (localLong.longValue() == -1L)) {
        if ((localObject1 != null) && (((Long)localObject1).longValue() > 0L))
        {
          paramToServiceMsg = (List)paramToServiceMsg.getAttribute("SubscriptionArticles");
          boolean bool2;
          if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          l = System.currentTimeMillis() - ((Long)localObject1).longValue();
          QLog.d("FeedsPreloadDataReport", 1, new Object[] { "refreshTime = ", Long.valueOf(l), ", hitFeedsPreloadCache = ", Boolean.valueOf(bool1), ", isRedPoint = ", Boolean.valueOf(bool2) });
          localObject2 = RIJTransMergeKanDianReport.g();
          localObject1 = "1";
          if (bool2) {
            paramToServiceMsg = "1";
          }
        }
      }
    }
    for (paramToServiceMsg = "0";; paramToServiceMsg = "0")
    {
      try
      {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).addString("is_reddot", paramToServiceMsg);
        if (!bool1) {
          continue;
        }
        paramToServiceMsg = (ToServiceMsg)localObject1;
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).addString("hit_preload", paramToServiceMsg);
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).addString("refresh_cost", String.valueOf(l));
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).addString("refresh_num", String.valueOf(paramInt));
      }
      catch (JSONException paramToServiceMsg)
      {
        QLog.d("FeedsPreloadDataReport", 1, "reportFeedsRefreshCost, e = ", paramToServiceMsg);
      }
      a("0X8009C16", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).build());
      FeedsPreloadHelper.a(l, bool1);
      return;
      QLog.d("FeedsPreloadDataReport", 1, "beginTime is null, no need to report.");
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    FeedsPreloadManager.a().a(new FeedsPreloadDataReport.1(paramString1, paramString2));
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.g();
    String str1;
    if (paramBoolean) {
      str1 = "1";
    }
    for (;;)
    {
      try
      {
        localReportR5Builder.addString("preload_reddot", str1);
        localReportR5Builder.addString("preload_num", String.valueOf(paramInt));
      }
      catch (JSONException localJSONException)
      {
        QLog.d("FeedsPreloadDataReport", 1, "reportHitFeedsPreloadCache, e = ", localJSONException);
      }
      a("0X8009C15", localReportR5Builder.build());
      return;
      String str2 = "0";
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.g();
    String str3 = "1";
    if (paramBoolean) {
      str1 = "1";
    }
    String str2;
    for (String str1 = "0";; str2 = "0")
    {
      try
      {
        localReportR5Builder.addString("preload_reddot", str1);
        localReportR5Builder.addString("preload_num", String.valueOf(paramInt));
        localReportR5Builder.addString("package_size", String.valueOf(paramLong));
        if (paramLong <= 20000L) {
          continue;
        }
        str1 = str3;
        localReportR5Builder.addString("is_too_large", str1);
      }
      catch (JSONException localJSONException)
      {
        QLog.d("FeedsPreloadDataReport", 1, "reportReceiveFeedsPreload, e = ", localJSONException);
      }
      a("0X8009C14", localReportR5Builder.build());
      return;
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.g();
    String str3 = "1";
    if (paramBoolean1) {
      str1 = "1";
    }
    String str2;
    for (String str1 = "0";; str2 = "0")
    {
      try
      {
        localReportR5Builder.addString("preload_reddot", str1);
        if (!paramBoolean2) {
          continue;
        }
        str1 = str3;
        localReportR5Builder.addString("has_exception", str1);
      }
      catch (JSONException localJSONException)
      {
        QLog.d("FeedsPreloadDataReport", 1, "reportTriggerFeedsPreload, e = ", localJSONException);
      }
      a("0X8009C13", localReportR5Builder.build());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadDataReport
 * JD-Core Version:    0.7.0.1
 */