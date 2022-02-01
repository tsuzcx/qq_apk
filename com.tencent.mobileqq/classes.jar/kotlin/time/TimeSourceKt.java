package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"compareTo", "", "Lkotlin/time/TimeMark;", "other", "minus", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;Lkotlin/time/TimeMark;)D", "Clock", "Lkotlin/time/TimeSource;", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "Lkotlin/Deprecated;", "message", "Use TimeSource interface instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "kotlin.time.TimeSource", "expression", "TimeSource", "ClockMark", "Use TimeMark class instead.", "kotlin.time.TimeMark", "TimeMark", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class TimeSourceKt
{
  @Deprecated(level=DeprecationLevel.ERROR, message="Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
  @SinceKotlin(version="1.3")
  @InlineOnly
  @ExperimentalTime
  private static final int compareTo(@NotNull TimeMark paramTimeMark1, TimeMark paramTimeMark2)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeMark1, "$this$compareTo");
    throw ((Throwable)new Error("Operation is disallowed."));
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
  @SinceKotlin(version="1.3")
  @InlineOnly
  @ExperimentalTime
  private static final double minus(@NotNull TimeMark paramTimeMark1, TimeMark paramTimeMark2)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeMark1, "$this$minus");
    throw ((Throwable)new Error("Operation is disallowed."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.time.TimeSourceKt
 * JD-Core Version:    0.7.0.1
 */