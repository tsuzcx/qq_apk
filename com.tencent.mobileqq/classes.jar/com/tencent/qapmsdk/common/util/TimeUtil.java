package com.tencent.qapmsdk.common.util;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/TimeUtil;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class TimeUtil
{
  public static final TimeUtil.Companion Companion = new TimeUtil.Companion(null);
  private static final String DEFAULT_DATE_FORMAT = "yyyyMMddHHmm";
  private static final String DEFAULT_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  private static final String TAG = "QAPM_common_TimeUtil";
  
  @JvmStatic
  public static final boolean beforeTime(@NotNull String paramString1, @NotNull String paramString2)
  {
    return Companion.beforeTime(paramString1, paramString2);
  }
  
  @NotNull
  public static final String getFormatDateByUtc()
  {
    return Companion.getFormatDateByUtc();
  }
  
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
  
  @JvmStatic
  @NotNull
  public static final String getForwardHour(int paramInt)
  {
    return Companion.getForwardHour(paramInt);
  }
  
  @JvmStatic
  @NotNull
  public static final String getForwardMinute(int paramInt)
  {
    return Companion.getForwardMinute(paramInt);
  }
  
  @JvmStatic
  @NotNull
  public static final String getUtcDateFormat(@NotNull Date paramDate)
  {
    return Companion.getUtcDateFormat(paramDate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.TimeUtil
 * JD-Core Version:    0.7.0.1
 */