package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.playfeeds.QualityReporter;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;

class VideoPlayManager$5
  implements Runnable
{
  VideoPlayManager$5(VideoPlayManager paramVideoPlayManager, int paramInt1, int paramInt2, String paramString, VideoPlayerWrapper paramVideoPlayerWrapper) {}
  
  public void run()
  {
    if (VideoPlayManager.d(this.this$0) != null)
    {
      int i = this.a;
      int j = this.b;
      Object localObject = this.this$0;
      VideoPlayManager.a((VideoPlayManager)localObject, VideoPlayManager.d((VideoPlayManager)localObject), VideoPlayManager.c(this.this$0), 6, new int[] { i, j });
      localObject = VideoPlayManager.d(this.this$0).z;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(":");
      localStringBuilder.append(this.b);
      ((AbsReadInJoyVideoReportData)localObject).k = localStringBuilder.toString();
      VideoPlayManager.d(this.this$0).z.l = this.c;
      VideoPlayManager.d(this.this$0).z.h = 0L;
      VideoPlayManager.d(this.this$0).z.j = false;
      VideoPlayManager.d(this.this$0).z.E = this.d.J();
      VideoPlayManager.d(this.this$0).z.F = this.d.K();
      VideoPlayManager.d(this.this$0).z.G = this.d.L();
      VideoPlayManager.d(this.this$0).z.H = this.d.g;
      VideoPlayManager.d(this.this$0).z.M = this.d.e;
      VideoPlayManager.d(this.this$0).z.L = this.d.c;
      VideoPlayManager.d(this.this$0).z.N = this.d.P();
      VideoPlayManager.d(this.this$0).z.at = this.d.Z();
      localObject = this.this$0;
      VideoPlayManager.b((VideoPlayManager)localObject, VideoPlayManager.d((VideoPlayManager)localObject));
      this.d.a(VideoPlayManager.d(this.this$0).z.b());
      RIJStatisticCollectorReport.a(VideoPlayManager.e(this.this$0).getApplicationContext(), RIJQQAppInterfaceUtil.d(), false, VideoPlayManager.d(this.this$0).z.a());
      QualityReporter.a(VideoPlayManager.d(this.this$0).z);
      RIJStatisticCollectorReport.a(false, VideoPlayManager.d(this.this$0).z.T, VideoPlayManager.d(this.this$0).z.G, VideoPlayManager.d(this.this$0).z.g, VideoPlayManager.d(this.this$0).z.o, 56, VideoPlayManager.d(this.this$0).z.k, VideoPlayManager.d(this.this$0).z.e);
      localObject = VideoPlayManager.d(this.this$0).D;
      if ((localObject != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd((int)((AbsBaseArticleInfo)localObject).mChannelID)) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject)) && (VideoPlayManager.d(this.this$0).M))
      {
        i = (int)VideoPlayManager.c(this.this$0).d(true);
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(VideoPlayManager.e(this.this$0)).a(6).b(11).a((AdvertisementInfo)localObject).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(0, i, 0, 0, 0, 0, ((AbsBaseArticleInfo)localObject).mVideoDuration * 1000, 1, 2, 0, ReportConstants.VideoEndType.OTHER)));
      }
      localObject = VideoPlayManager.d(this.this$0).D;
      if ((localObject != null) && (((AbsBaseArticleInfo)localObject).mChannelID == 56L) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject))) {
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(VideoPlayManager.e(this.this$0)).a(6).b(4).a((AdvertisementInfo)localObject).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(0, 0, 0, 0, 0, 0, ((AbsBaseArticleInfo)localObject).mVideoDuration * 1000, 9, 2, 0, ReportConstants.VideoEndType.OTHER)));
      }
    }
    VideoPlayManager.a(this.this$0, null);
    VideoPlayManager.b(this.this$0, null);
    this.d.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.5
 * JD-Core Version:    0.7.0.1
 */