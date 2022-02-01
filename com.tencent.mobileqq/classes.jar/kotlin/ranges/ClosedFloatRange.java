package kotlin.ranges;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(FF)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ClosedFloatRange
  implements ClosedFloatingPointRange<Float>
{
  private final float _endInclusive;
  private final float _start;
  
  public ClosedFloatRange(float paramFloat1, float paramFloat2)
  {
    this._start = paramFloat1;
    this._endInclusive = paramFloat2;
  }
  
  public boolean contains(float paramFloat)
  {
    return (paramFloat >= this._start) && (paramFloat <= this._endInclusive);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ClosedFloatRange)) {
      if ((!isEmpty()) || (!((ClosedFloatRange)paramObject).isEmpty()))
      {
        float f = this._start;
        paramObject = (ClosedFloatRange)paramObject;
        if ((f != paramObject._start) || (this._endInclusive != paramObject._endInclusive)) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public Float getEndInclusive()
  {
    return Float.valueOf(this._endInclusive);
  }
  
  @NotNull
  public Float getStart()
  {
    return Float.valueOf(this._start);
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return Float.valueOf(this._start).hashCode() * 31 + Float.valueOf(this._endInclusive).hashCode();
  }
  
  public boolean isEmpty()
  {
    return this._start > this._endInclusive;
  }
  
  public boolean lessThanOrEquals(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 <= paramFloat2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ranges.ClosedFloatRange
 * JD-Core Version:    0.7.0.1
 */