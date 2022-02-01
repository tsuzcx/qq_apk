package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE", "()D", "D", "ZERO", "getZERO", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Duration$Companion
{
  public final double convert(double paramDouble, @NotNull TimeUnit paramTimeUnit1, @NotNull TimeUnit paramTimeUnit2)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit1, "sourceUnit");
    Intrinsics.checkParameterIsNotNull(paramTimeUnit2, "targetUnit");
    return DurationUnitKt.convertDurationUnit(paramDouble, paramTimeUnit1, paramTimeUnit2);
  }
  
  public final double getINFINITE()
  {
    return Duration.access$getINFINITE$cp();
  }
  
  public final double getZERO()
  {
    return Duration.access$getZERO$cp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.time.Duration.Companion
 * JD-Core Version:    0.7.0.1
 */