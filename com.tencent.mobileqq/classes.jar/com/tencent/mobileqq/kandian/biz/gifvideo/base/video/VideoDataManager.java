package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoDataManager;", "", "()V", "rowKeyAndProgressMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getRowKeyAndProgressMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setRowKeyAndProgressMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "rowKeyAndTotalDurationMap", "getRowKeyAndTotalDurationMap", "setRowKeyAndTotalDurationMap", "getProgressByRowKey", "rowKey", "getTotalDurationByRowKey", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoDataManager
{
  public static final VideoDataManager a = new VideoDataManager();
  @NotNull
  private static ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
  @NotNull
  private static ConcurrentHashMap<String, Long> c = new ConcurrentHashMap();
  
  public final long a(@Nullable String paramString)
  {
    if (paramString != null)
    {
      paramString = (Long)b.get(paramString);
      if (paramString != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramString, "it");
        return paramString.longValue();
      }
      paramString = (Void)null;
    }
    return 0L;
  }
  
  @NotNull
  public final ConcurrentHashMap<String, Long> a()
  {
    return b;
  }
  
  public final long b(@Nullable String paramString)
  {
    if (paramString != null)
    {
      paramString = (Long)c.get(paramString);
      if (paramString != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramString, "it");
        return paramString.longValue();
      }
      paramString = (Void)null;
    }
    return 0L;
  }
  
  @NotNull
  public final ConcurrentHashMap<String, Long> b()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoDataManager
 * JD-Core Version:    0.7.0.1
 */