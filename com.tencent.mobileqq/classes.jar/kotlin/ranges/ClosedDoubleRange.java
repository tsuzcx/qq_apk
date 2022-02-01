package kotlin.ranges;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ClosedDoubleRange
  implements ClosedFloatingPointRange<Double>
{
  private final double _endInclusive;
  private final double _start;
  
  public ClosedDoubleRange(double paramDouble1, double paramDouble2)
  {
    this._start = paramDouble1;
    this._endInclusive = paramDouble2;
  }
  
  public boolean contains(double paramDouble)
  {
    return (paramDouble >= this._start) && (paramDouble <= this._endInclusive);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ClosedDoubleRange)) {
      if ((!isEmpty()) || (!((ClosedDoubleRange)paramObject).isEmpty()))
      {
        double d = this._start;
        paramObject = (ClosedDoubleRange)paramObject;
        if ((d != paramObject._start) || (this._endInclusive != paramObject._endInclusive)) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public Double getEndInclusive()
  {
    return Double.valueOf(this._endInclusive);
  }
  
  @NotNull
  public Double getStart()
  {
    return Double.valueOf(this._start);
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return Double.valueOf(this._start).hashCode() * 31 + Double.valueOf(this._endInclusive).hashCode();
  }
  
  public boolean isEmpty()
  {
    return this._start > this._endInclusive;
  }
  
  public boolean lessThanOrEquals(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 <= paramDouble2;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this._start);
    localStringBuilder.append("..");
    localStringBuilder.append(this._endInclusive);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.ranges.ClosedDoubleRange
 * JD-Core Version:    0.7.0.1
 */