package com.tencent.qapmsdk.common.util;

import com.tencent.qapmsdk.common.logger.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/TimeUtil$Companion;", "", "()V", "DEFAULT_DATE_FORMAT", "", "DEFAULT_TIMESTAMP_FORMAT", "TAG", "formatDateByUtc", "formatDateByUtc$annotations", "getFormatDateByUtc", "()Ljava/lang/String;", "formatDateByZone", "formatDateByZone$annotations", "getFormatDateByZone", "formatDateMs", "formatDateMs$annotations", "getFormatDateMs", "beforeTime", "", "firstTime", "secondTime", "getForwardHour", "what", "", "getForwardMinute", "getUtcDateFormat", "date", "Ljava/util/Date;", "common_release"}, k=1, mv={1, 1, 15})
public final class TimeUtil$Companion
{
  @JvmStatic
  public final boolean beforeTime(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "firstTime");
    Intrinsics.checkParameterIsNotNull(paramString2, "secondTime");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm", Locale.US);
    try
    {
      boolean bool = localSimpleDateFormat.parse(paramString1).before(localSimpleDateFormat.parse(paramString2));
      return bool;
    }
    catch (ParseException paramString1)
    {
      Logger.INSTANCE.exception("QAPM_common_TimeUtil", (Throwable)paramString1);
    }
    return false;
  }
  
  @NotNull
  public final String getFormatDateByUtc()
  {
    Object localObject = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    localObject = ((SimpleDateFormat)localObject).format(new Date());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "dateFormat.format(Date())");
    return localObject;
  }
  
  @NotNull
  public final String getFormatDateByZone()
  {
    String str = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US).format(new Date());
    Intrinsics.checkExpressionValueIsNotNull(str, "SimpleDateFormat(DEFAULT…Locale.US).format(Date())");
    return str;
  }
  
  @NotNull
  public final String getFormatDateMs()
  {
    String str = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss.ms", Locale.US).format(new Date());
    Intrinsics.checkExpressionValueIsNotNull(str, "SimpleDateFormat(\"yyyy-M…Locale.US).format(Date())");
    return str;
  }
  
  @JvmStatic
  @NotNull
  public final String getForwardHour(int paramInt)
  {
    Object localObject = new SimpleDateFormat("yyyyMMddHHmm", Locale.US);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(10, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localCalendar, "calendar");
    localObject = ((SimpleDateFormat)localObject).format(localCalendar.getTime());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "dateFormat.format(dateFrom)");
    return localObject;
  }
  
  @JvmStatic
  @NotNull
  public final String getForwardMinute(int paramInt)
  {
    Object localObject = new SimpleDateFormat("yyyyMMddHHmm", Locale.US);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(12, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localCalendar, "calendar");
    localObject = ((SimpleDateFormat)localObject).format(localCalendar.getTime());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "dateFormat.format(dateFrom)");
    return localObject;
  }
  
  @JvmStatic
  @NotNull
  public final String getUtcDateFormat(@NotNull Date paramDate)
  {
    Intrinsics.checkParameterIsNotNull(paramDate, "date");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    paramDate = localSimpleDateFormat.format(paramDate);
    Intrinsics.checkExpressionValueIsNotNull(paramDate, "dateFormat.format(date)");
    return paramDate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.TimeUtil.Companion
 * JD-Core Version:    0.7.0.1
 */