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
    if (paramLong3 == 0L) {
      throw ((Throwable)new IllegalArgumentException("Step must be non-zero."));
    }
    if (paramLong3 == -9223372036854775808L) {
      throw ((Throwable)new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation."));
    }
    this.first = paramLong1;
    this.last = ProgressionUtilKt.getProgressionLastElement(paramLong1, paramLong2, paramLong3);
    this.step = paramLong3;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof LongProgression)) && (((isEmpty()) && (((LongProgression)paramObject).isEmpty())) || ((this.first == ((LongProgression)paramObject).first) && (this.last == ((LongProgression)paramObject).last) && (this.step == ((LongProgression)paramObject).step)));
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
    return (int)(31 * (31 * (this.first ^ this.first >>> 32) + (this.last ^ this.last >>> 32)) + (this.step ^ this.step >>> 32));
  }
  
  public boolean isEmpty()
  {
    if (this.step > 0L) {
      if (this.first <= this.last) {}
    }
    while (this.first < this.last)
    {
      return true;
      return false;
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
    if (this.step > 0L) {
      return this.first + ".." + this.last + " step " + this.step;
    }
    return this.first + " downTo " + this.last + " step " + -this.step;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.ranges.LongProgression
 * JD-Core Version:    0.7.0.1
 */