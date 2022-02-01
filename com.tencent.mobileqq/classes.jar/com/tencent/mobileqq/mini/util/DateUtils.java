package com.tencent.mobileqq.mini.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/util/DateUtils;", "", "()V", "FORMAT_PATTERN_DATE", "", "isToday", "", "timestamp", "", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class DateUtils
{
  private static final String FORMAT_PATTERN_DATE = "yyyy-MM-dd";
  public static final DateUtils INSTANCE = new DateUtils();
  
  public final boolean isToday(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.SIMPLIFIED_CHINESE);
    return Intrinsics.areEqual(localSimpleDateFormat.format(new Date(System.currentTimeMillis())), localSimpleDateFormat.format(new Date(paramLong)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.DateUtils
 * JD-Core Version:    0.7.0.1
 */