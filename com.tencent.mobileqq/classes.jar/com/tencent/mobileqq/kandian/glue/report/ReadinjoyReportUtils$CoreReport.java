package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.api.IReadInJoySrtUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.ugc.api.IUGRuleManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;

public class ReadinjoyReportUtils$CoreReport
{
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
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
      ((FeedsReportData)localObject1).jdField_a_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
        ((FeedsReportData)localObject1).jdField_b_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
      }
      ((FeedsReportData)localObject1).jdField_a_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((FeedsReportData)localObject1).jdField_b_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.d;
      Object localObject2 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        ((FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)((Iterator)localObject2).next();
          if (localFeedsInfoUser != null) {
            ((FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = ((FeedsReportData)localObject1);
    }
    if (DailyModeConfigHandler.c((int)paramAbsBaseArticleInfo.mChannelID)) {
      localReportInfo.mSearchTagName = RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo);
    }
    Object localObject1 = ((IReadInJoySrtUtils)QRoute.api(IReadInJoySrtUtils.class)).getNoDifferenceDiversionInfo();
    if (localObject1 != null) {
      localReportInfo.srtClickInfo = ((oidb_cmd0x64e.SRTClickInfo)localObject1);
    }
    if ((!((IUGRuleManager)QRoute.api(IUGRuleManager.class)).isUgCard(paramAbsBaseArticleInfo)) && (!((IReadInJoySrtUtils)QRoute.api(IReadInJoySrtUtils.class)).judgeHasSrtInfoHandle()) && (RIJTransMergeKanDianReport.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramAbsBaseArticleInfo))) {
      localReportInfo.noDifferenceJump = 1;
    }
    localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    ReadInJoyLogicEngine.a().a((List)localObject1);
    ((IRIJFeedsInsertUtil)QRoute.api(IRIJFeedsInsertUtil.class)).updateLastClickArticleInfo(paramInt, paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.CoreReport
 * JD-Core Version:    0.7.0.1
 */