package com.tencent.videocut.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/TimeUtils;", "", "()V", "MS_TO_US", "", "S_TO_MS", "S_TO_US", "US_TO_MS", "currentTimeUs", "", "formatDuration", "", "us", "msToS", "", "ms", "msToUs", "sToMs", "s", "sToUs", "usToMs", "usToS", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class TimeUtils
{
  @NotNull
  public static final TimeUtils a = new TimeUtils();
  
  public final float a(float paramFloat)
  {
    return paramFloat * 1000000;
  }
  
  public final long a(long paramLong)
  {
    return paramLong * 1000000;
  }
  
  public final float b(float paramFloat)
  {
    return paramFloat / 1000000;
  }
  
  public final long b(long paramLong)
  {
    return paramLong / 1000000;
  }
  
  public final long c(long paramLong)
  {
    return paramLong / 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.TimeUtils
 * JD-Core Version:    0.7.0.1
 */