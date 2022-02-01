package com.tencent.tkd.topicsdk.common;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/TimeUtils;", "", "()V", "formatSeconds", "", "seconds", "", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class TimeUtils
{
  public static final TimeUtils a = new TimeUtils();
  
  @NotNull
  public final String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return "00:00";
    }
    long l1 = 60;
    if (paramLong < l1)
    {
      str = String.format(Locale.getDefault(), "00:%02d", new Object[] { Long.valueOf(paramLong % l1) });
      Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(… \"00:%02d\", seconds % 60)");
      return str;
    }
    long l2 = 3600;
    if (paramLong < l2)
    {
      str = String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Long.valueOf(paramLong / l1), Long.valueOf(paramLong % l1) });
      Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(…econds % 60\n            )");
      return str;
    }
    String str = String.format(Locale.getDefault(), "%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong / l2), Long.valueOf(paramLong % l2 / l1), Long.valueOf(paramLong % l1) });
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(…econds % 60\n            )");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.TimeUtils
 * JD-Core Version:    0.7.0.1
 */