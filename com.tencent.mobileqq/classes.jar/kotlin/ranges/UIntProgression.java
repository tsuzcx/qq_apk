package kotlin.ranges;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.UIntIterator;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst", "()I", "I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/UIntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public class UIntProgression
  implements Iterable<UInt>, KMappedMarker
{
  public static final UIntProgression.Companion Companion = new UIntProgression.Companion(null);
  private final int first;
  private final int last;
  private final int step;
  
  private UIntProgression(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      throw ((Throwable)new IllegalArgumentException("Step must be non-zero."));
    }
    if (paramInt3 == -2147483648) {
      throw ((Throwable)new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation."));
    }
    this.first = paramInt1;
    this.last = UProgressionUtilKt.getProgressionLastElement-Nkh28Cs(paramInt1, paramInt2, paramInt3);
    this.step = paramInt3;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof UIntProgression)) && (((isEmpty()) && (((UIntProgression)paramObject).isEmpty())) || ((this.first == ((UIntProgression)paramObject).first) && (this.last == ((UIntProgression)paramObject).last) && (this.step == ((UIntProgression)paramObject).step)));
  }
  
  public final int getFirst()
  {
    return this.first;
  }
  
  public final int getLast()
  {
    return this.last;
  }
  
  public final int getStep()
  {
    return this.step;
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return (this.first * 31 + this.last) * 31 + this.step;
  }
  
  public boolean isEmpty()
  {
    if (this.step > 0) {
      if (UnsignedKt.uintCompare(this.first, this.last) <= 0) {}
    }
    while (UnsignedKt.uintCompare(this.first, this.last) < 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  @NotNull
  public UIntIterator iterator()
  {
    return (UIntIterator)new UIntProgressionIterator(this.first, this.last, this.step, null);
  }
  
  @NotNull
  public String toString()
  {
    if (this.step > 0) {
      return UInt.toString-impl(this.first) + ".." + UInt.toString-impl(this.last) + " step " + this.step;
    }
    return UInt.toString-impl(this.first) + " downTo " + UInt.toString-impl(this.last) + " step " + -this.step;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ranges.UIntProgression
 * JD-Core Version:    0.7.0.1
 */