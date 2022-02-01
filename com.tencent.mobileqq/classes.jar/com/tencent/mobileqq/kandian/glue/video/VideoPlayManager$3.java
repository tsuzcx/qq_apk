package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.qroute.QRoute;

class VideoPlayManager$3
  implements Runnable
{
  VideoPlayManager$3(VideoPlayManager paramVideoPlayManager, VideoPlayParam paramVideoPlayParam, VideoRecommendManager paramVideoRecommendManager) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam == null) {
      return;
    }
    int i = 0;
    long l;
    if ((VideoPlayManager.a(this.this$0) != null) && (VideoPlayManager.a(this.this$0).getIntent() != null))
    {
      i = VideoPlayManager.a(this.this$0).getIntent().getIntExtra("channel_from", -1);
      l = VideoPlayManager.a(this.this$0).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    }
    else
    {
      l = 0L;
    }
    String str2 = new VideoR5.Builder(null, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.k, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.j).c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Int * 1000).d(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.a).a((int)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Long).e(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_g_of_type_Long).c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_g_of_type_Int).a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_Long).a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager).d(VideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.k)).e(VideoPlayManager.a(this.this$0)).g(VideoReporter.a).d(VideoPlayManager.a(this.this$0)).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Int * 1000).a(Boolean.valueOf(RIJFeedsType.g(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.videoReportInfo).z(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.n).A(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.o).B(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.l).C(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.m).N(i).b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).d(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, true).aa(VideoFeedsHelper.f()).W(RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)).a().a();
    Object localObject = new ReportInfo.VideoExtraRepoerData();
    ((ReportInfo.VideoExtraRepoerData)localObject).d = (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Int * 1000);
    ((ReportInfo.VideoExtraRepoerData)localObject).e = (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Int * 1000);
    if (l == 0L) {
      i = 1;
    } else {
      i = 2;
    }
    ((ReportInfo.VideoExtraRepoerData)localObject).c = i;
    if (VideoPlayManager.a(this.this$0) != null)
    {
      ((ReportInfo.VideoExtraRepoerData)localObject).b = true;
      ((ReportInfo.VideoExtraRepoerData)localObject).a = (VideoPlayManager.a(this.this$0).canAutoPlayVideo() ^ true);
    }
    VideoReporter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, (int)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Long, 12, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.a, (ReportInfo.VideoExtraRepoerData)localObject);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.k;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_Long == l) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    String str1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.j)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.j;
    } else {
      str1 = "0";
    }
    localIPublicAccountReportUtils.videoDataReportWithFansInfoInR5(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.a = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.3
 * JD-Core Version:    0.7.0.1
 */