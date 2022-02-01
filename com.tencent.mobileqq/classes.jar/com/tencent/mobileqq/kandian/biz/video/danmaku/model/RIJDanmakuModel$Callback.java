package com.tencent.mobileqq.kandian.biz.video.danmaku.model;

import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail;
import com.tencent.mobileqq.kandian.biz.video.danmaku.ReportInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuModel$Callback;", "", "onGetData", "", "list", "", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail;", "reportInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ReportInfo;", "Lkotlin/collections/ArrayList;", "sendDanmakuForbid", "", "clearData", "openText", "", "danmakuCount", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface RIJDanmakuModel$Callback
{
  public abstract void a(@NotNull List<DanmakuDetail> paramList, @NotNull ArrayList<ReportInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, @NotNull String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuModel.Callback
 * JD-Core Version:    0.7.0.1
 */