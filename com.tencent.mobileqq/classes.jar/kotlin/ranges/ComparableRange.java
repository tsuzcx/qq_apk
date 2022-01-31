package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/ComparableRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "start", "endInclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getEndInclusive", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getStart", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
class ComparableRange<T extends Comparable<? super T>>
  implements ClosedRange<T>
{
  @NotNull
  private final T endInclusive;
  @NotNull
  private final T start;
  
  public ComparableRange(@NotNull T paramT1, @NotNull T paramT2)
  {
    this.start = paramT1;
    this.endInclusive = paramT2;
  }
  
  public boolean contains(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "value");
    return ClosedRange.DefaultImpls.contains(this, paramT);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ComparableRange)) && (((isEmpty()) && (((ComparableRange)paramObject).isEmpty())) || ((Intrinsics.areEqual(getStart(), ((ComparableRange)paramObject).getStart())) && (Intrinsics.areEqual(getEndInclusive(), ((ComparableRange)paramObject).getEndInclusive()))));
  }
  
  @NotNull
  public T getEndInclusive()
  {
    return this.endInclusive;
  }
  
  @NotNull
  public T getStart()
  {
    return this.start;
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return getStart().hashCode() * 31 + getEndInclusive().hashCode();
  }
  
  public boolean isEmpty()
  {
    return ClosedRange.DefaultImpls.isEmpty(this);
  }
  
  @NotNull
  public String toString()
  {
    return getStart() + ".." + getEndInclusive();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.ranges.ComparableRange
 * JD-Core Version:    0.7.0.1
 */