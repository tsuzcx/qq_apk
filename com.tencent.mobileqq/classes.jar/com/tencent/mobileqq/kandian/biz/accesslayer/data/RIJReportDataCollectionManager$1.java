package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.db.struct.ReportData;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.ProteusReportUtil;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;

final class RIJReportDataCollectionManager$1
  implements Runnable
{
  RIJReportDataCollectionManager$1(AbsBaseArticleInfo paramAbsBaseArticleInfo1, IReadInJoyModel paramIReadInJoyModel, int paramInt, RIJDataManager paramRIJDataManager, long paramLong, AbsBaseArticleInfo paramAbsBaseArticleInfo2) {}
  
  public void run()
  {
    ReportData localReportData = new ReportData();
    localReportData.h = this.a.mStrategyId;
    localReportData.i = this.a.mAlgorithmID;
    if (!TextUtils.isEmpty(this.a.mVideoVid)) {
      localReportData.n = this.a.mVideoVid;
    }
    localReportData.j = RIJFeedsType.g(this.a);
    int i;
    if (this.a.hasChannelInfo()) {
      i = this.a.mChannelInfoId;
    } else {
      i = 0;
    }
    localReportData.o = i;
    localReportData.p = (TextUtils.isEmpty(this.a.mArticleFriendLikeText) ^ true);
    localReportData.q = this.a.mServerContext;
    localReportData.k = RIJFeedsType.k(this.a);
    localReportData.l = this.b.k();
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
    localReportData.m = localAbsBaseArticleInfo;
    RIJReportDataCollectionManager.a(localReportData, localAbsBaseArticleInfo, this.b);
    RIJReportDataCollectionManager.a(localReportData, this.a, this.c, this.b);
    localReportData.r = this.a.mStrCircleId;
    localReportData.t = this.a.innerUniqueID;
    localReportData.u = RIJTransMergeKanDianReport.b();
    localReportData.v = RIJAppSetting.b();
    localReportData.z = this.a.mVideoAdsJumpType;
    localReportData.y = this.a.mVideoAdsSource;
    RIJReportDataCollectionManager.a(this.a, this.d);
    localReportData.A = this.e;
    localReportData.B = this.c;
    localReportData.F = RIJTransMergeKanDianReport.d(this.a);
    if ((this.d.a().B() == 0) || (DailyModeConfigHandler.c(this.d.a().B()))) {
      RIJReportDataCollectionManager.a(localReportData);
    }
    localReportData.E = ReadInJoyBaseFragment.c(this.d.a().B());
    RIJReportDataCollectionManager.a(localReportData, this.a, this.d);
    RIJReportDataCollectionManager.a(localReportData, this.d);
    ProteusReportUtil.a(this.f);
    UGRuleManager.a(this.f, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJReportDataCollectionManager.1
 * JD-Core Version:    0.7.0.1
 */