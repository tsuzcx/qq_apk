package com.tencent.mobileqq.kandian.glue.viola.components;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuInfo;
import com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoDanmakuComponent$doReport$1
  implements Runnable
{
  VideoDanmakuComponent$doReport$1(VideoDanmakuComponent paramVideoDanmakuComponent, String paramString1, long paramLong, DanmakuDetail paramDanmakuDetail, String paramString2) {}
  
  public final void run()
  {
    Object localObject = VideoDanmakuComponent.access$getDanmakuManager$p(this.this$0);
    if (localObject != null) {
      localObject = ((RIJDanmakuManager)localObject).b();
    } else {
      localObject = null;
    }
    localObject = new VideoR5.Builder("", (String)localObject, "", "").k(this.a).b("time", Long.valueOf(this.b)).b("shown_place", VideoDanmakuComponent.access$getSrcAttr(this.this$0, "shown_place")).b("danmu_id", this.c.a().a()).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "VideoR5.Builder(\"\", danm…          .toJsonString()");
    String str = this.d;
    PublicAccountReportUtils.a(null, "", str, str, 0, 0, "", "", this.c.a().f(), (String)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.components.VideoDanmakuComponent.doReport.1
 * JD-Core Version:    0.7.0.1
 */