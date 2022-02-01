package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ValueHolder$DoubleHolder;", "Lshark/ValueHolder;", "value", "", "(D)V", "getValue", "()D", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class ValueHolder$DoubleHolder
  extends ValueHolder
{
  private final double b;
  
  public ValueHolder$DoubleHolder(double paramDouble)
  {
    super(null);
    this.b = paramDouble;
  }
  
  public final double a()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DoubleHolder))
      {
        paramObject = (DoubleHolder)paramObject;
        if (Double.compare(this.b, paramObject.b) == 0) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.b);
    return (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoubleHolder(value=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ValueHolder.DoubleHolder
 * JD-Core Version:    0.7.0.1
 */