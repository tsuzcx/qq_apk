package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ValueHolder$ShortHolder;", "Lshark/ValueHolder;", "value", "", "(S)V", "getValue", "()S", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class ValueHolder$ShortHolder
  extends ValueHolder
{
  private final short b;
  
  public ValueHolder$ShortHolder(short paramShort)
  {
    super(null);
    this.b = paramShort;
  }
  
  public final short a()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ShortHolder))
      {
        paramObject = (ShortHolder)paramObject;
        if (this.b == paramObject.b) {}
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
    return this.b;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShortHolder(value=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ValueHolder.ShortHolder
 * JD-Core Version:    0.7.0.1
 */