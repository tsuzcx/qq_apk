package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"convertDurationUnit", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "DurationUnit", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitJvmKt
{
  @SinceKotlin(version="1.3")
  @ExperimentalTime
  public static final double convertDurationUnit(double paramDouble, @NotNull TimeUnit paramTimeUnit1, @NotNull TimeUnit paramTimeUnit2)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit1, "sourceUnit");
    Intrinsics.checkParameterIsNotNull(paramTimeUnit2, "targetUnit");
    long l = paramTimeUnit2.convert(1L, paramTimeUnit1);
    if (l > 0L) {
      return l * paramDouble;
    }
    return paramDouble / paramTimeUnit1.convert(1L, paramTimeUnit2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.time.DurationUnitKt__DurationUnitJvmKt
 * JD-Core Version:    0.7.0.1
 */