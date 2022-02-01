package kotlin.ranges;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"checkStepIsPositive", "", "isPositive", "", "step", "", "contains", "T", "", "R", "", "Lkotlin/ranges/ClosedRange;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "rangeTo", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/ranges/RangesKt")
class RangesKt__RangesKt
{
  public static final void checkStepIsPositive(boolean paramBoolean, @NotNull Number paramNumber)
  {
    Intrinsics.checkParameterIsNotNull(paramNumber, "step");
    if (!paramBoolean) {
      throw ((Throwable)new IllegalArgumentException("Step must be positive, was: " + paramNumber + '.'));
    }
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T, R extends Iterable<? extends T>,  extends ClosedRange<T>> boolean contains(@NotNull R paramR, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramR, "$this$contains");
    return (paramT != null) && (((ClosedRange)paramR).contains((Comparable)paramT));
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final ClosedFloatingPointRange<Double> rangeTo(double paramDouble1, double paramDouble2)
  {
    return (ClosedFloatingPointRange)new ClosedDoubleRange(paramDouble1, paramDouble2);
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final ClosedFloatingPointRange<Float> rangeTo(float paramFloat1, float paramFloat2)
  {
    return (ClosedFloatingPointRange)new ClosedFloatRange(paramFloat1, paramFloat2);
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(@NotNull T paramT1, @NotNull T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramT1, "$this$rangeTo");
    Intrinsics.checkParameterIsNotNull(paramT2, "that");
    return (ClosedRange)new ComparableRange(paramT1, paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ranges.RangesKt__RangesKt
 * JD-Core Version:    0.7.0.1
 */