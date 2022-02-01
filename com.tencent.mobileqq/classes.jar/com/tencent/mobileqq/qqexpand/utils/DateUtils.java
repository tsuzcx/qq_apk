package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/DateUtils;", "", "()V", "formatDate", "", "time", "", "isDayMore", "", "compareDay", "", "lastTime", "isThisTime", "pattern", "isToday", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public final class DateUtils
{
  public static final DateUtils a = new DateUtils();
  
  private final boolean a(long paramLong, String paramString)
  {
    Date localDate = new Date(paramLong);
    paramString = new SimpleDateFormat(paramString, Locale.SIMPLIFIED_CHINESE);
    return Intrinsics.areEqual(paramString.format(localDate), paramString.format(new Date(NetConnInfoCenter.getServerTimeMillis())));
  }
  
  @Nullable
  public final String a(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
  }
  
  public final boolean a(int paramInt, long paramLong)
  {
    double d = System.currentTimeMillis() - paramLong;
    Double.isNaN(d);
    return d * 1.0D / 86400000.0D >= paramInt;
  }
  
  public final boolean a(long paramLong)
  {
    return a(paramLong, "yyyy-MM-dd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.DateUtils
 * JD-Core Version:    0.7.0.1
 */