package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.EntranceDownloadInfo;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.qroute.QRoute;

final class VideoFeedsFirstVideoRecommendationManager$1
  implements Runnable
{
  VideoFeedsFirstVideoRecommendationManager$1(IEntranceButtonDataSource paramIEntranceButtonDataSource) {}
  
  public void run()
  {
    int i = ReadInJoyHelper.e();
    Object localObject = this.a;
    if ((localObject instanceof VideoInfo))
    {
      localObject = (VideoInfo)localObject;
      if (i == 1)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A23", "0X8009A23", 0, 0, "", "", "", RIJVideoReportManager.a((VideoInfo)localObject, i), false);
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", RIJVideoReportManager.a((VideoInfo)localObject, i), false);
      return;
    }
    if ((localObject instanceof VideoInfo.EntranceDownloadInfo))
    {
      localObject = (VideoInfo.EntranceDownloadInfo)localObject;
      VideoR5.Builder localBuilder = new VideoR5.Builder("", "", "", "");
      localBuilder.V(1).a(((VideoInfo.EntranceDownloadInfo)localObject).c).a(0).U(i).T(ReadinjoyTabFrame.b);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", localBuilder.a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager.1
 * JD-Core Version:    0.7.0.1
 */