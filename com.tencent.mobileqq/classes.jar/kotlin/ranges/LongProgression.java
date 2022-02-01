package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public class LongProgression
  implements Iterable<Long>, KMappedMarker
{
  public static final LongProgression.Companion Companion = new LongProgression.Companion(null);
  private final long first;
  private final long last;
  private final long step;
  
  public LongProgression(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 != 0L)
    {
      if (paramLong3 != -9223372036854775808L)
      {
        this.first = paramLong1;
        this.last = ProgressionUtilKt.getProgressionLastElement(paramLong1, paramLong2, paramLong3);
        this.step = paramLong3;
        return;
      }
      throw ((Throwable)new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation."));
    }
    throw ((Throwable)new IllegalArgumentException("Step must be non-zero."));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof LongProgression)) {
      if ((!isEmpty()) || (!((LongProgression)paramObject).isEmpty()))
      {
        long l = this.first;
        paramObject = (LongProgression)paramObject;
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
    long l1 = 31;
    long l2 = this.first;
    long l3 = this.last;
    long l4 = this.step;
    return (int)(l1 * ((l2 ^ l2 >>> 32) * l1 + (l3 ^ l3 >>> 32)) + (l4 ^ l4 >>> 32));
  }
  
  public boolean isEmpty()
  {
    if (this.step > 0L)
    {
      if (this.first > this.last) {
        return true;
      }
    }
    else if (this.first < this.last) {
      return true;
    }
    return false;
  }
  
  @NotNull
  public LongIterator iterator()
  {
    return (LongIterator)new LongProgressionIterator(this.first, this.last, this.step);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder;
    long l;
    if (this.step > 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.first);
      localStringBuilder.append("..");
      localStringBuilder.append(this.last);
      localStringBuilder.append(" step ");
      l = this.step;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.first);
      localStringBuilder.append(" downTo ");
      localStringBuilder.append(this.last);
      localStringBuilder.append(" step ");
      l = -this.step;
    }
    localStringBuilder.append(l);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.ranges.LongProgression
 * JD-Core Version:    0.7.0.1
 */