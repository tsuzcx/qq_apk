package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;

class VideoPlayManager$10
  implements Runnable
{
  VideoPlayManager$10(VideoPlayManager paramVideoPlayManager, VideoPlayParam paramVideoPlayParam, VideoRecommendManager paramVideoRecommendManager, VideoPlayerWrapper paramVideoPlayerWrapper, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    Activity localActivity = VideoPlayManager.e(this.this$0);
    if ((localActivity != null) && (localActivity.getIntent() != null)) {
      i = localActivity.getIntent().getIntExtra("channel_from", -1);
    } else {
      i = 0;
    }
    Object localObject = new VideoR5.Builder(null, this.a.A, this.a.d, this.a.y).c(this.a.l * 1000).d(this.a.z.h).a((int)this.a.f).e(this.a.B).c(this.a.C).a(this.b, this.a.j).a(this.b).f(VideoPlayManager.a(this.a.A)).g(VideoReporter.b).e(VideoPlayManager.g(this.this$0)).e(VideoPlayManager.f(this.this$0)).a(this.a.k).a(Boolean.valueOf(RIJFeedsType.i(this.a.D))).b(this.a.D.videoReportInfo).z(this.a.z.R).A(this.a.z.S).B(this.a.z.O).C(this.a.z.P).O(i).b(this.a.D).d(this.a.D).a(this.a.D, false).k(this.a.D.innerUniqueID).X(RIJFeedsType.g(this.a.D));
    int i = RIJBaseItemViewType.c(this.a.D);
    if (6 == i)
    {
      ((VideoR5.Builder)localObject).ab(VideoFeedsHelper.k());
    }
    else if (118 == i)
    {
      ((VideoR5.Builder)localObject).ab(VideoFeedsHelper.i());
      ((VideoR5.Builder)localObject).b(this.a.D.mVideoColumnInfo);
    }
    else if (128 == i)
    {
      ((VideoR5.Builder)localObject).ab(VideoFeedsHelper.m());
      ((VideoR5.Builder)localObject).b(this.a.D.mSimpleVideoColumnInfo);
    }
    String str2 = ((VideoR5.Builder)localObject).b().a();
    long l;
    if ((localActivity != null) && (localActivity.getIntent() != null)) {
      l = localActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    } else {
      l = 0L;
    }
    localObject = new ReportInfo.VideoExtraRepoerData();
    ((ReportInfo.VideoExtraRepoerData)localObject).d = ((int)this.a.k);
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
      ((ReportInfo.VideoExtraRepoerData)localObject).f = (true ^ VideoPlayManager.h(this.this$0).canAutoPlayVideo());
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
    PublicAccountReportUtils.a("0X8007408", this.a.A, "", "", "", str2);
    VideoPlayManager.b(this.this$0, this.c, this.a);
    this.a.z.h = 0L;
    VideoPlayManager.a(this.this$0, this.d, localActivity, this.a, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.10
 * JD-Core Version:    0.7.0.1
 */