package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)D", "measureTimedValue", "Lkotlin/time/TimedValue;", "T", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)D", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class MeasureTimeKt
{
  @SinceKotlin(version="1.3")
  @ExperimentalTime
  public static final double measureTime(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    TimeMark localTimeMark = ((TimeSource)TimeSource.Monotonic.INSTANCE).markNow();
    paramFunction0.invoke();
    return localTimeMark.elapsedNow();
  }
  
  @SinceKotlin(version="1.3")
  @ExperimentalTime
  public static final double measureTime(@NotNull TimeSource paramTimeSource, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeSource, "$this$measureTime");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramTimeSource = paramTimeSource.markNow();
    paramFunction0.invoke();
    return paramTimeSource.elapsedNow();
  }
  
  @SinceKotlin(version="1.3")
  @ExperimentalTime
  @NotNull
  public static final <T> TimedValue<T> measureTimedValue(@NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    TimeMark localTimeMark = ((TimeSource)TimeSource.Monotonic.INSTANCE).markNow();
    return new TimedValue(paramFunction0.invoke(), localTimeMark.elapsedNow(), null);
  }
  
  @SinceKotlin(version="1.3")
  @ExperimentalTime
  @NotNull
  public static final <T> TimedValue<T> measureTimedValue(@NotNull TimeSource paramTimeSource, @NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeSource, "$this$measureTimedValue");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramTimeSource = paramTimeSource.markNow();
    return new TimedValue(paramFunction0.invoke(), paramTimeSource.elapsedNow(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.time.MeasureTimeKt
 * JD-Core Version:    0.7.0.1
 */