package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.view.View;
import com.tencent.mobileqq.kandian.base.utils.VideoSessionUtils;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.video.report.VideoDTReport;
import com.tencent.mobileqq.kandian.glue.video.report.VideoDTReport.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "player", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;", "videoView", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoView;", "originView", "Landroid/view/View;", "article", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class VideoDtReportController$reportDtVideoStart$1
  extends Lambda
  implements Function4<IPlayer, IVideoView, View, AbsBaseArticleInfo, Unit>
{
  VideoDtReportController$reportDtVideoStart$1(VideoDtReportController paramVideoDtReportController)
  {
    super(4);
  }
  
  public final void invoke(@NotNull IPlayer paramIPlayer, @NotNull IVideoView paramIVideoView, @NotNull View paramView, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
    Intrinsics.checkParameterIsNotNull(paramIVideoView, "videoView");
    Intrinsics.checkParameterIsNotNull(paramView, "originView");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "article");
    this.this$0.c(VideoSessionUtils.a());
    paramIVideoView = VideoDTReport.Builder.a((VideoInfo)null).a(this.this$0.a()).a(paramAbsBaseArticleInfo.mChannelID).b(paramAbsBaseArticleInfo.innerUniqueID).c(paramAbsBaseArticleInfo.getSubscribeUin()).b(paramIPlayer.a()).d(this.this$0.b()).c(1).e(paramView.getWidth()).f(paramView.getHeight());
    Intrinsics.checkExpressionValueIsNotNull(paramIVideoView, "VideoDTReport.Builder.ma…Height(originView.height)");
    VideoDTReport.a(paramView.getContext(), paramIPlayer, paramIVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoDtReportController.reportDtVideoStart.1
 * JD-Core Version:    0.7.0.1
 */