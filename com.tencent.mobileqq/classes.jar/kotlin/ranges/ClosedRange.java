package kotlin.ranges;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/ClosedRange;", "T", "", "", "endInclusive", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface ClosedRange<T extends Comparable<? super T>>
{
  public abstract boolean contains(@NotNull T paramT);
  
  @NotNull
  public abstract T getEndInclusive();
  
  @NotNull
  public abstract T getStart();
  
  public abstract boolean isEmpty();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ranges.ClosedRange
 * JD-Core Version:    0.7.0.1
 */