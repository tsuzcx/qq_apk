package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper$ImageThumbTask;", "", "requestTimeMs", "", "startTimeUs", "(JJ)V", "getStartTimeUs", "()J", "compareTo", "", "other", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
final class ThumbnailGeneratorHelper$ImageThumbTask
  implements Comparable<ImageThumbTask>
{
  private final long a;
  private final long b;
  
  public ThumbnailGeneratorHelper$ImageThumbTask(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public int a(@NotNull ImageThumbTask paramImageThumbTask)
  {
    Intrinsics.checkParameterIsNotNull(paramImageThumbTask, "other");
    return (int)(this.a - paramImageThumbTask.a);
  }
  
  public final long a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailGeneratorHelper.ImageThumbTask
 * JD-Core Version:    0.7.0.1
 */