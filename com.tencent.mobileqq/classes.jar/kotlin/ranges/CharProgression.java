package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public class CharProgression
  implements Iterable<Character>, KMappedMarker
{
  public static final CharProgression.Companion Companion = new CharProgression.Companion(null);
  private final char first;
  private final char last;
  private final int step;
  
  public CharProgression(char paramChar1, char paramChar2, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != -2147483648)
      {
        this.first = paramChar1;
        this.last = ((char)ProgressionUtilKt.getProgressionLastElement(paramChar1, paramChar2, paramInt));
        this.step = paramInt;
        return;
      }
      throw ((Throwable)new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation."));
    }
    throw ((Throwable)new IllegalArgumentException("Step must be non-zero."));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof CharProgression)) {
      if ((!isEmpty()) || (!((CharProgression)paramObject).isEmpty()))
      {
        int i = this.first;
        paramObject = (CharProgression)paramObject;
        if ((i != paramObject.first) || (this.last != paramObject.last) || (this.step != paramObject.step)) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public final char getFirst()
  {
    return this.first;
  }
  
  public final char getLast()
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
    return (this.first * '\037' + this.last) * 31 + this.step;
  }
  
  public boolean isEmpty()
  {
    if (this.step > 0)
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
  public CharIterator iterator()
  {
    return (CharIterator)new CharProgressionIterator(this.first, this.last, this.step);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder;
    int i;
    if (this.step > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.first);
      localStringBuilder.append("..");
      localStringBuilder.append(this.last);
      localStringBuilder.append(" step ");
      i = this.step;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.first);
      localStringBuilder.append(" downTo ");
      localStringBuilder.append(this.last);
      localStringBuilder.append(" step ");
      i = -this.step;
    }
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ranges.CharProgression
 * JD-Core Version:    0.7.0.1
 */