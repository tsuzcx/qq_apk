package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shortName", "", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitKt
  extends DurationUnitKt__DurationUnitJvmKt
{
  @SinceKotlin(version="1.3")
  @ExperimentalTime
  @NotNull
  public static final String shortName(@NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "$this$shortName");
    switch (DurationUnitKt.WhenMappings.$EnumSwitchMapping$0[paramTimeUnit.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 7: 
      return "d";
    case 6: 
      return "h";
    case 5: 
      return "m";
    case 4: 
      return "s";
    case 3: 
      return "ms";
    case 2: 
      return "us";
    }
    return "ns";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.time.DurationUnitKt__DurationUnitKt
 * JD-Core Version:    0.7.0.1
 */