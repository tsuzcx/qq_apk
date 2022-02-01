package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class ClosedFloatingPointRange$DefaultImpls
{
  public static <T extends Comparable<? super T>> boolean contains(ClosedFloatingPointRange<T> paramClosedFloatingPointRange, @NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "value");
    return (paramClosedFloatingPointRange.lessThanOrEquals(paramClosedFloatingPointRange.getStart(), paramT)) && (paramClosedFloatingPointRange.lessThanOrEquals(paramT, paramClosedFloatingPointRange.getEndInclusive()));
  }
  
  public static <T extends Comparable<? super T>> boolean isEmpty(ClosedFloatingPointRange<T> paramClosedFloatingPointRange)
  {
    return paramClosedFloatingPointRange.lessThanOrEquals(paramClosedFloatingPointRange.getStart(), paramClosedFloatingPointRange.getEndInclusive()) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ranges.ClosedFloatingPointRange.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */