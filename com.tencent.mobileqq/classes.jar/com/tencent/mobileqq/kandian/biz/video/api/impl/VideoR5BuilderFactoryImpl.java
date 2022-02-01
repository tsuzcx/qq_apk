package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.biz.video.api.IVideoR5Builder;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoR5BuilderFactory;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoR5BuilderFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoR5BuilderFactory;", "()V", "create", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoR5Builder;", "md5", "", "puin", "vid", "aid", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoR5BuilderFactoryImpl
  implements IVideoR5BuilderFactory
{
  @NotNull
  public IVideoR5Builder create(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4)
  {
    return (IVideoR5Builder)new VideoR5.Builder(paramString1, paramString2, paramString3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoR5BuilderFactoryImpl
 * JD-Core Version:    0.7.0.1
 */