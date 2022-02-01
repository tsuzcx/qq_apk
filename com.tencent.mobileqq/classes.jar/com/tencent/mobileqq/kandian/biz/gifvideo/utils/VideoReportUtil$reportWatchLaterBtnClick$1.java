package com.tencent.mobileqq.kandian.biz.gifvideo.utils;

import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "article", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "reportR5Builder", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "invoke"}, k=3, mv={1, 1, 16})
final class VideoReportUtil$reportWatchLaterBtnClick$1
  extends Lambda
  implements Function2<AbsBaseArticleInfo, RIJTransMergeKanDianReport.ReportR5Builder, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  VideoReportUtil$reportWatchLaterBtnClick$1()
  {
    super(2);
  }
  
  public final void invoke(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "article");
    Intrinsics.checkParameterIsNotNull(paramReportR5Builder, "reportR5Builder");
    VideoReportUtil localVideoReportUtil = VideoReportUtil.a;
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubscribeID;
    Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "article.mSubscribeID");
    paramReportR5Builder = paramReportR5Builder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramReportR5Builder, "reportR5Builder.toString()");
    localVideoReportUtil.a(paramAbsBaseArticleInfo, "0X800B7A3", paramReportR5Builder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoReportUtil.reportWatchLaterBtnClick.1
 * JD-Core Version:    0.7.0.1
 */