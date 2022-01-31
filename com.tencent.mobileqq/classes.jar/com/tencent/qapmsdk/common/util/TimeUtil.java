package com.tencent.qapmsdk.common.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/TimeUtil;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class TimeUtil
{
  public static final TimeUtil.Companion Companion = new TimeUtil.Companion(null);
  
  @NotNull
  public static final String getFormatDateByZone()
  {
    return Companion.getFormatDateByZone();
  }
  
  @NotNull
  public static final String getFormatDateMs()
  {
    return Companion.getFormatDateMs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.TimeUtil
 * JD-Core Version:    0.7.0.1
 */