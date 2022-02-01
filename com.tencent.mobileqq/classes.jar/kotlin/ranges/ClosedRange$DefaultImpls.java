package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class ClosedRange$DefaultImpls
{
  public static <T extends Comparable<? super T>> boolean contains(ClosedRange<T> paramClosedRange, @NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "value");
    return (paramT.compareTo(paramClosedRange.getStart()) >= 0) && (paramT.compareTo(paramClosedRange.getEndInclusive()) <= 0);
  }
  
  public static <T extends Comparable<? super T>> boolean isEmpty(ClosedRange<T> paramClosedRange)
  {
    return paramClosedRange.getStart().compareTo(paramClosedRange.getEndInclusive()) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ranges.ClosedRange.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */