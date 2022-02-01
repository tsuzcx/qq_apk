package com.tencent.mobileqq.kandian.biz.video.feeds.api;

import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/feeds/api/IVideoPlay;", "", "playVideo", "", "playParam", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/entity/BaseVideoPlayParam;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoPlay
{
  public abstract void a(@Nullable BaseVideoPlayParam paramBaseVideoPlayParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlay
 * JD-Core Version:    0.7.0.1
 */