package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoySrtUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;

public class ReadinjoyReportUtils$CoreReport
{
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
    localReportInfo.mChannelId = paramInt;
    localReportInfo.mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
    localReportInfo.mOperation = 1;
    localReportInfo.mServerContext = paramAbsBaseArticleInfo.mServerContext;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramAbsBaseArticleInfo.innerUniqueID;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      localObject1 = new FeedsReportData();
      ((FeedsReportData)localObject1).a = paramAbsBaseArticleInfo.mSocialFeedInfo.a;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) {
        ((FeedsReportData)localObject1).b = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
      }
      ((FeedsReportData)localObject1).d = paramAbsBaseArticleInfo.mSocialFeedInfo.h;
      ((FeedsReportData)localObject1).e = paramAbsBaseArticleInfo.mSocialFeedInfo.j;
      Object localObject2 = paramAbsBaseArticleInfo.mSocialFeedInfo.d;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        ((FeedsReportData)localObject1).c = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)((Iterator)localObject2).next();
          if (localFeedsInfoUser != null) {
            ((FeedsReportData)localObject1).c.add(Long.valueOf(localFeedsInfoUser.a));
          }
        }
      }
      localReportInfo.mFeedsReportData = ((FeedsReportData)localObject1);
    }
    if (DailyModeConfigHandler.c((int)paramAbsBaseArticleInfo.mChannelID)) {
      localReportInfo.mSearchTagName = RIJTransMergeKanDianReport.d(paramAbsBaseArticleInfo);
    }
    Object localObject1 = ReadInJoySrtUtils.a().b();
    if (localObject1 != null) {
      localReportInfo.srtClickInfo = ((oidb_cmd0x64e.SRTClickInfo)localObject1);
    }
    if ((!UGRuleManager.c(paramAbsBaseArticleInfo)) && (!ReadInJoySrtUtils.a().e()) && (RIJTransMergeKanDianReport.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramAbsBaseArticleInfo))) {
      localReportInfo.noDifferenceJump = 1;
    }
    localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    ReadInJoyLogicEngine.a().a((List)localObject1);
    RIJFeedsInsertUtil.a.b(paramInt, paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.CoreReport
 * JD-Core Version:    0.7.0.1
 */