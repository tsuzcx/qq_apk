package com.tencent.mobileqq.kandian.glue.video.compress;

import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/video/compress/VideoCompressModule$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mobileqq/kandian/glue/video/compress/VideoCompressModule;", "getInstance", "()Lcom/tencent/mobileqq/kandian/glue/video/compress/VideoCompressModule;", "instance$delegate", "Lkotlin/Lazy;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoCompressModule$Companion
{
  @NotNull
  public final VideoCompressModule a()
  {
    Lazy localLazy = VideoCompressModule.b();
    Companion localCompanion = VideoCompressModule.a;
    return (VideoCompressModule)localLazy.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.compress.VideoCompressModule.Companion
 * JD-Core Version:    0.7.0.1
 */