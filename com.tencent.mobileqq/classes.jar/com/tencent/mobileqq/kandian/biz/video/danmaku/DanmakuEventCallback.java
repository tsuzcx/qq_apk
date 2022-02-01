package com.tencent.mobileqq.kandian.biz.video.danmaku;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuEventCallback;", "", "onClickReport", "", "danmakuDetail", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail;", "onDanmakuClicked", "data", "onDanmakuExposure", "onGetDanmakuData", "sendDanmakuforbid", "", "reportInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/ReportInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface DanmakuEventCallback
{
  public abstract void onClickReport(@NotNull DanmakuDetail paramDanmakuDetail);
  
  public abstract void onDanmakuClicked(@NotNull DanmakuDetail paramDanmakuDetail);
  
  public abstract void onDanmakuExposure(@NotNull DanmakuDetail paramDanmakuDetail);
  
  public abstract void onGetDanmakuData(boolean paramBoolean, @NotNull ArrayList<ReportInfo> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuEventCallback
 * JD-Core Version:    0.7.0.1
 */