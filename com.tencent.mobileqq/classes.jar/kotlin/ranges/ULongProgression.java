package kotlin.ranges;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.collections.ULongIterator;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst", "()J", "J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/ULongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public class ULongProgression
  implements Iterable<ULong>, KMappedMarker
{
  public static final ULongProgression.Companion Companion = new ULongProgression.Companion(null);
  private final long first;
  private final long last;
  private final long step;
  
  private ULongProgression(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 != 0L)
    {
      if (paramLong3 != -9223372036854775808L)
      {
        this.first = paramLong1;
        this.last = UProgressionUtilKt.getProgressionLastElement-7ftBX0g(paramLong1, paramLong2, paramLong3);
        this.step = paramLong3;
        return;
      }
      throw ((Throwable)new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation."));
    }
    throw ((Throwable)new IllegalArgumentException("Step must be non-zero."));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ULongProgression)) {
      if ((!isEmpty()) || (!((ULongProgression)paramObject).isEmpty()))
      {
        long l = this.first;
        paramObject = (ULongProgression)paramObject;
        if ((l != paramObject.first) || (this.last != paramObject.last) || (this.step != paramObject.step)) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public final long getFirst()
  {
    return this.first;
  }
  
  public final long getLast()
  {
    return this.last;
  }
  
  public final long getStep()
  {
    return this.step;
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    long l = this.first;
    int i = (int)ULong.constructor-impl(l ^ ULong.constructor-impl(l >>> 32));
    l = this.last;
    int j = (int)ULong.constructor-impl(l ^ ULong.constructor-impl(l >>> 32));
    l = this.step;
    return (int)(l ^ l >>> 32) + (i * 31 + j) * 31;
  }
  
  public boolean isEmpty()
  {
    if (this.step > 0L)
    {
      if (UnsignedKt.ulongCompare(this.first, this.last) > 0) {
        return true;
      }
    }
    else if (UnsignedKt.ulongCompare(this.first, this.last) < 0) {
      return true;
    }
    return false;
  }
  
  @NotNull
  public ULongIterator iterator()
  {
    return (ULongIterator)new ULongProgressionIterator(this.first, this.last, this.step, null);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder;
    long l;
    if (this.step > 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(ULong.toString-impl(this.first));
      localStringBuilder.append("..");
      localStringBuilder.append(ULong.toString-impl(this.last));
      localStringBuilder.append(" step ");
      l = this.step;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(ULong.toString-impl(this.first));
      localStringBuilder.append(" downTo ");
      localStringBuilder.append(ULong.toString-impl(this.last));
      localStringBuilder.append(" step ");
      l = -this.step;
    }
    localStringBuilder.append(l);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.ranges.ULongProgression
 * JD-Core Version:    0.7.0.1
 */