package kotlin.ranges;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "start", "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive", "()Lkotlin/UInt;", "getStart", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public final class UIntRange
  extends UIntProgression
  implements ClosedRange<UInt>
{
  public static final UIntRange.Companion Companion = new UIntRange.Companion(null);
  @NotNull
  private static final UIntRange EMPTY = new UIntRange(-1, 0, null);
  
  private UIntRange(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1, null);
  }
  
  public boolean contains-WZ4Q5Ns(int paramInt)
  {
    return (UnsignedKt.uintCompare(getFirst(), paramInt) <= 0) && (UnsignedKt.uintCompare(paramInt, getLast()) <= 0);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof UIntRange)) && (((isEmpty()) && (((UIntRange)paramObject).isEmpty())) || ((getFirst() == ((UIntRange)paramObject).getFirst()) && (getLast() == ((UIntRange)paramObject).getLast())));
  }
  
  @NotNull
  public UInt getEndInclusive()
  {
    return UInt.box-impl(getLast());
  }
  
  @NotNull
  public UInt getStart()
  {
    return UInt.box-impl(getFirst());
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return 31 * getFirst() + getLast();
  }
  
  public boolean isEmpty()
  {
    return UnsignedKt.uintCompare(getFirst(), getLast()) > 0;
  }
  
  @NotNull
  public String toString()
  {
    return UInt.toString-impl(getFirst()) + ".." + UInt.toString-impl(getLast());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ranges.UIntRange
 * JD-Core Version:    0.7.0.1
 */