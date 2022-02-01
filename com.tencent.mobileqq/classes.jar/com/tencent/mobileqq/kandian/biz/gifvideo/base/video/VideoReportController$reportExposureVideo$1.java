package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoReportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoReportController$reportExposureVideo$1
  extends Lambda
  implements Function0<Unit>
{
  VideoReportController$reportExposureVideo$1(VideoReportController paramVideoReportController)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject1 = this.this$0.a();
    if (localObject1 != null)
    {
      localObject1 = ((VideoPlayController)localObject1).a();
      if (localObject1 != null)
      {
        Object localObject2 = this.this$0.a();
        if (localObject2 != null)
        {
          localObject2 = ((VideoPlayController)localObject2).a();
          if ((localObject2 != null) && (!VideoReportController.a.a().contains(((AbsBaseArticleInfo)localObject1).innerUniqueID)))
          {
            VideoReportController.a.a().add(((AbsBaseArticleInfo)localObject1).innerUniqueID);
            localObject2 = VideoReportUtil.a.a((AbsBaseArticleInfo)localObject1, ((IPlayer)localObject2).b());
            localObject1 = VideoReportUtil.a;
            localObject2 = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).build();
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "reportBuilder.build()");
            ((VideoReportUtil)localObject1).a("", "0X8007801", (String)localObject2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoReportController.reportExposureVideo.1
 * JD-Core Version:    0.7.0.1
 */