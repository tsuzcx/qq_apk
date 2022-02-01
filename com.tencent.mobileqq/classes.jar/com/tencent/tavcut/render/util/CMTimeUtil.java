package com.tencent.tavcut.render.util;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/util/CMTimeUtil;", "", "()V", "DEFAULT_TIME_SCALE", "", "SECOND_TO_US", "", "genCMTimeFromUs", "Lcom/tencent/tav/coremedia/CMTime;", "timeUs", "timeScale", "genCMTimeRangeFromUs", "Lcom/tencent/tav/coremedia/CMTimeRange;", "start", "duration", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class CMTimeUtil
{
  public static final CMTimeUtil a = new CMTimeUtil();
  
  @NotNull
  public final CMTime a(long paramLong, int paramInt)
  {
    return new CMTime(((float)paramLong / (float)1000000L * paramInt), paramInt);
  }
  
  @NotNull
  public final CMTimeRange a(long paramLong1, long paramLong2, int paramInt)
  {
    return new CMTimeRange(a(paramLong1, paramInt), a(paramLong2, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.util.CMTimeUtil
 * JD-Core Version:    0.7.0.1
 */