package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

final class VideoReporter$1
  implements Runnable
{
  VideoReporter$1(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData, int paramInt7, String paramString2, String paramString3) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
    localReportInfo.mSource = 0;
    localReportInfo.mOpSource = this.a;
    localReportInfo.mSourceArticleId = this.b;
    localReportInfo.mInnerId = this.c;
    localReportInfo.mChannelId = this.d;
    localReportInfo.mAlgorithmId = this.e;
    localReportInfo.mStrategyId = this.f;
    localReportInfo.mOperation = this.g;
    localReportInfo.mPlayTimeLength = this.h;
    localReportInfo.mVideoExtraRepoerData = this.i;
    localReportInfo.mColumnID = this.j;
    localReportInfo.videoReportInfo = this.k;
    localReportInfo.firstVideoRowkey = this.l;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportVideoUserOperationByOidbOfVideoFeedsmUin:");
      localStringBuilder.append(localReportInfo.mUin);
      localStringBuilder.append("; mSource:");
      localStringBuilder.append(localReportInfo.mSource);
      localStringBuilder.append("; mOpSource:");
      localStringBuilder.append(localReportInfo.mOpSource);
      localStringBuilder.append("; mSourceArticleId: ");
      localStringBuilder.append(localReportInfo.mSourceArticleId);
      localStringBuilder.append("; mInnerId:");
      localStringBuilder.append(localReportInfo.mInnerId);
      localStringBuilder.append("; mChannelId:");
      localStringBuilder.append(localReportInfo.mChannelId);
      localStringBuilder.append("; mAlgorithmId:");
      localStringBuilder.append(localReportInfo.mAlgorithmId);
      localStringBuilder.append("; mStrategyId:");
      localStringBuilder.append(localReportInfo.mStrategyId);
      localStringBuilder.append("; mOperation:");
      localStringBuilder.append(localReportInfo.mOperation);
      localStringBuilder.append("; mPlayTimeLength:");
      localStringBuilder.append(localReportInfo.mPlayTimeLength);
      localStringBuilder.append("; mColumnID:");
      localStringBuilder.append(localReportInfo.mColumnID);
      localStringBuilder.append("; videoReportInfo:");
      localStringBuilder.append(localReportInfo.videoReportInfo);
      localStringBuilder.append("; videoExtraRepoerData:");
      Object localObject = this.i;
      if (localObject != null) {
        localObject = ((ReportInfo.VideoExtraRepoerData)localObject).toString();
      } else {
        localObject = "null";
      }
      localStringBuilder.append((String)localObject);
      QLog.d("VideoReporter", 2, localStringBuilder.toString());
    }
    localArrayList.add(localReportInfo);
    UserOperationModule.getInstance().request0x64eUserOperationReport(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter.1
 * JD-Core Version:    0.7.0.1
 */