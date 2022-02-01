package com.tencent.mobileqq.kandian.glue.viola.components;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuInfo;
import com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoDanmakuComponent$doReport$1
  implements Runnable
{
  VideoDanmakuComponent$doReport$1(VideoDanmakuComponent paramVideoDanmakuComponent, DanmakuDetail paramDanmakuDetail, long paramLong, String paramString) {}
  
  public final void run()
  {
    Object localObject = VideoDanmakuComponent.access$getDanmakuManager$p(this.this$0);
    if (localObject != null) {
      localObject = ((RIJDanmakuManager)localObject).a();
    } else {
      localObject = null;
    }
    localObject = new VideoR5.Builder("", (String)localObject, "", "").j(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuDetail.a().c()).a("time", Long.valueOf(this.jdField_a_of_type_Long)).a("shown_place", VideoDanmakuComponent.access$getSrcAttr(this.this$0, "shown_place")).a("danmu_id", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuDetail.a().a()).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "VideoR5.Builder(\"\", danm…          .toJsonString()");
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str = this.jdField_a_of_type_JavaLangString;
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", str, str, 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuDanmakuDetail.a().c(), (String)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.components.VideoDanmakuComponent.doReport.1
 * JD-Core Version:    0.7.0.1
 */