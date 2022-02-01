package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;

class VideoPlayManager$3
  implements Runnable
{
  VideoPlayManager$3(VideoPlayManager paramVideoPlayManager, VideoPlayParam paramVideoPlayParam, VideoRecommendManager paramVideoRecommendManager) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    int i = 0;
    long l;
    if ((VideoPlayManager.e(this.this$0) != null) && (VideoPlayManager.e(this.this$0).getIntent() != null))
    {
      i = VideoPlayManager.e(this.this$0).getIntent().getIntExtra("channel_from", -1);
      l = VideoPlayManager.e(this.this$0).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    }
    else
    {
      l = 0L;
    }
    String str2 = new VideoR5.Builder(null, this.a.A, this.a.d, this.a.y).c(this.a.l * 1000).d(this.a.z.h).a((int)this.a.f).e(this.a.B).c(this.a.C).a(this.b, this.a.j).a(this.b).f(VideoPlayManager.a(this.a.A)).e(VideoPlayManager.g(this.this$0)).g(VideoReporter.b).e(VideoPlayManager.f(this.this$0)).a(this.a.l * 1000).a(Boolean.valueOf(RIJFeedsType.i(this.a.D))).b(this.a.D.videoReportInfo).z(this.a.z.R).A(this.a.z.S).B(this.a.z.O).C(this.a.z.P).O(i).b(this.a.D).c(this.a.D).d(this.a.D).a(this.a.D, true).ab(VideoFeedsHelper.k()).X(RIJFeedsType.g(this.a.D)).b().a();
    Object localObject = new ReportInfo.VideoExtraRepoerData();
    ((ReportInfo.VideoExtraRepoerData)localObject).d = (this.a.l * 1000);
    ((ReportInfo.VideoExtraRepoerData)localObject).e = (this.a.l * 1000);
    if (l == 0L) {
      i = 1;
    } else {
      i = 2;
    }
    ((ReportInfo.VideoExtraRepoerData)localObject).c = i;
    if (VideoPlayManager.h(this.this$0) != null)
    {
      ((ReportInfo.VideoExtraRepoerData)localObject).h = true;
      ((ReportInfo.VideoExtraRepoerData)localObject).f = (VideoPlayManager.h(this.this$0).canAutoPlayVideo() ^ true);
    }
    VideoReporter.a(this.a.D, (int)this.a.f, 12, this.a.z.h, (ReportInfo.VideoExtraRepoerData)localObject);
    String str3 = this.a.A;
    if (this.a.j == l) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    String str1;
    if (!TextUtils.isEmpty(this.a.y)) {
      str1 = this.a.y;
    } else {
      str1 = "0";
    }
    PublicAccountReportUtils.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str1, str2, false);
    this.a.z.h = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.3
 * JD-Core Version:    0.7.0.1
 */