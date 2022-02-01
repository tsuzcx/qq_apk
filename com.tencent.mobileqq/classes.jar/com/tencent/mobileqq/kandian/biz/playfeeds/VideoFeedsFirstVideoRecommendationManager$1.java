package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.EntranceDownloadInfo;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;

final class VideoFeedsFirstVideoRecommendationManager$1
  implements Runnable
{
  VideoFeedsFirstVideoRecommendationManager$1(IEntranceButtonDataSource paramIEntranceButtonDataSource) {}
  
  public void run()
  {
    int i = ReadInJoyHelper.K();
    Object localObject = this.a;
    if ((localObject instanceof VideoInfo))
    {
      localObject = (VideoInfo)localObject;
      if (i == 1)
      {
        PublicAccountReportUtils.a(null, "", "0X8009A23", "0X8009A23", 0, 0, "", "", "", RIJVideoReportManager.a((VideoInfo)localObject, i), false);
        return;
      }
      PublicAccountReportUtils.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", RIJVideoReportManager.a((VideoInfo)localObject, i), false);
      return;
    }
    if ((localObject instanceof VideoInfo.EntranceDownloadInfo))
    {
      localObject = (VideoInfo.EntranceDownloadInfo)localObject;
      VideoR5.Builder localBuilder = new VideoR5.Builder("", "", "", "");
      localBuilder.W(1).b(((VideoInfo.EntranceDownloadInfo)localObject).d).a(0).V(i).U(ReadinjoyTabFrame.g);
      PublicAccountReportUtils.a(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", localBuilder.b().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager.1
 * JD-Core Version:    0.7.0.1
 */