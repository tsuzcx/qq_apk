package com.tencent.mobileqq.kandian.repo.feeds.preload;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class FeedsPreloadExposeReport
{
  public static void a(List<AbsBaseArticleInfo> paramList, String paramString)
  {
    QLog.d("FeedsPreloadExposeReport", 1, "reportFeedsExposeRewrite.");
    Object localObject = (ReadInJoyLogicManager)((QQAppInterface)RIJQQAppInterfaceUtil.e()).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
      FeedsPreloadManager.a().a(new FeedsPreloadExposeReport.1((ReadInJoyLogicEngine)localObject, paramList, paramString));
      return;
    }
    QLog.d("FeedsPreloadExposeReport", 1, "readInJoyLogicManager is null.");
  }
  
  public static void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    String str = RIJQQAppInterfaceUtil.d();
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    localHashMap.put("uin", str);
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if ((localAppRuntime != null) && (paramLong >= 0L) && (paramLong <= 30000L))
    {
      StatisticCollector.getInstance(localAppRuntime.getApplication()).collectPerformance(str, "actFeedsPreloadExposeReport", paramBoolean, paramLong, 0L, localHashMap, null);
      return;
    }
    QLog.d("FeedsPreloadExposeReport", 1, "app is null or cost is not available, reportFeedsPreloadExposeMonitorData");
  }
  
  private static List<ReportInfo> b(List<AbsBaseArticleInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = new ArrayList(paramList).iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (AbsBaseArticleInfo)paramList.next();
        Object localObject2;
        if ((RIJFeedsType.P((AbsBaseArticleInfo)localObject1)) && (((AbsBaseArticleInfo)localObject1).mNewPolymericInfo != null) && (((AbsBaseArticleInfo)localObject1).mNewPolymericInfo.p != null))
        {
          localObject1 = ((AbsBaseArticleInfo)localObject1).mNewPolymericInfo.p.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (NewPolymericInfo.PackArticleInfo)((Iterator)localObject1).next();
            ReportInfo localReportInfo = new ReportInfo();
            localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
            localReportInfo.mOperation = 56;
            localReportInfo.mSourceArticleId = ((NewPolymericInfo.PackArticleInfo)localObject2).a;
            localReportInfo.mInnerId = ((NewPolymericInfo.PackArticleInfo)localObject2).l;
            localReportInfo.mAlgorithmId = ((int)((NewPolymericInfo.PackArticleInfo)localObject2).i);
            localReportInfo.mGWCommonData = "";
            localArrayList.add(localReportInfo);
          }
        }
        else
        {
          localObject2 = new ReportInfo();
          ((ReportInfo)localObject2).mUin = RIJQQAppInterfaceUtil.c();
          ((ReportInfo)localObject2).mOperation = 56;
          ((ReportInfo)localObject2).mSourceArticleId = ((AbsBaseArticleInfo)localObject1).mArticleID;
          ((ReportInfo)localObject2).mInnerId = ((AbsBaseArticleInfo)localObject1).innerUniqueID;
          ((ReportInfo)localObject2).mAlgorithmId = ((int)((AbsBaseArticleInfo)localObject1).mAlgorithmID);
          ((ReportInfo)localObject2).mGWCommonData = ((AbsBaseArticleInfo)localObject1).mGWCommonData;
          localArrayList.add(localObject2);
          if (BaseArticleInfoKt.a((AbsBaseArticleInfo)localObject1))
          {
            localObject1 = (AbsBaseArticleInfo)((AbsBaseArticleInfo)localObject1).mSubArticleList.get(0);
            localObject2 = new ReportInfo();
            ((ReportInfo)localObject2).mUin = RIJQQAppInterfaceUtil.c();
            ((ReportInfo)localObject2).mOperation = 56;
            ((ReportInfo)localObject2).mSourceArticleId = ((AbsBaseArticleInfo)localObject1).mArticleID;
            ((ReportInfo)localObject2).mInnerId = ((AbsBaseArticleInfo)localObject1).innerUniqueID;
            ((ReportInfo)localObject2).mAlgorithmId = ((int)((AbsBaseArticleInfo)localObject1).mAlgorithmID);
            ((ReportInfo)localObject2).mGWCommonData = ((AbsBaseArticleInfo)localObject1).mGWCommonData;
            localArrayList.add(localObject2);
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadExposeReport
 * JD-Core Version:    0.7.0.1
 */