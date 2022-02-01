package com.tencent.rmonitor.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/TimeUtil;", "", "()V", "DEFAULT_DATE_FORMAT", "", "DEFAULT_TIMESTAMP_FORMAT", "TAG", "formatDateByUtc", "formatDateByUtc$annotations", "getFormatDateByUtc", "()Ljava/lang/String;", "formatDateByZone", "formatDateByZone$annotations", "getFormatDateByZone", "formatDateMs", "formatDateMs$annotations", "getFormatDateMs", "beforeTime", "", "firstTime", "secondTime", "getForwardHour", "what", "", "getForwardMinute", "getUtcDateFormat", "date", "Ljava/util/Date;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class TimeUtil
{
  public static final TimeUtil a = new TimeUtil();
  
  @NotNull
  public static final String a()
  {
    String str = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss.ms", Locale.US).format(new Date());
    Intrinsics.checkExpressionValueIsNotNull(str, "SimpleDateFormat(\"yyyy-M…Locale.US).format(Date())");
    return str;
  }
  
  @NotNull
  public static final String b()
  {
    String str = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US).format(new Date());
    Intrinsics.checkExpressionValueIsNotNull(str, "SimpleDateFormat(DEFAULT…Locale.US).format(Date())");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.TimeUtil
 * JD-Core Version:    0.7.0.1
 */