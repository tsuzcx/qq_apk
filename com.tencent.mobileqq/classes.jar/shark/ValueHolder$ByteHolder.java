package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ValueHolder$ByteHolder;", "Lshark/ValueHolder;", "value", "", "(B)V", "getValue", "()B", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class ValueHolder$ByteHolder
  extends ValueHolder
{
  private final byte b;
  
  public ValueHolder$ByteHolder(byte paramByte)
  {
    super(null);
    this.b = paramByte;
  }
  
  public final byte a()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ByteHolder))
      {
        paramObject = (ByteHolder)paramObject;
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
    localStringBuilder.append("ByteHolder(value=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ValueHolder.ByteHolder
 * JD-Core Version:    0.7.0.1
 */