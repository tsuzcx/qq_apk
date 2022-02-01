package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.SoftAdDownloadBarInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoR5Builder;", "", "adGuideAreaVideoReportInfo", "softAdDownloadBarInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo$SoftAdDownloadBarInfo;", "isPlay", "", "isUG", "put", "key", "", "value", "rowKey", "toJsonString", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoR5Builder
{
  @NotNull
  public abstract IVideoR5Builder a(@Nullable VideoInfo.SoftAdDownloadBarInfo paramSoftAdDownloadBarInfo);
  
  @NotNull
  public abstract IVideoR5Builder a(@Nullable String paramString);
  
  @NotNull
  public abstract IVideoR5Builder a(@Nullable String paramString, @Nullable Object paramObject);
  
  @NotNull
  public abstract IVideoR5Builder a(boolean paramBoolean);
  
  @NotNull
  public abstract String a();
  
  @NotNull
  public abstract IVideoR5Builder b(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoR5Builder
 * JD-Core Version:    0.7.0.1
 */