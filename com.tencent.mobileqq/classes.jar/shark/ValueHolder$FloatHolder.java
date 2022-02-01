package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ValueHolder$FloatHolder;", "Lshark/ValueHolder;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class ValueHolder$FloatHolder
  extends ValueHolder
{
  private final float b;
  
  public ValueHolder$FloatHolder(float paramFloat)
  {
    super(null);
    this.b = paramFloat;
  }
  
  public final float a()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FloatHolder))
      {
        paramObject = (FloatHolder)paramObject;
        if (Float.compare(this.b, paramObject.b) == 0) {}
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
    return Float.floatToIntBits(this.b);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FloatHolder(value=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ValueHolder.FloatHolder
 * JD-Core Version:    0.7.0.1
 */