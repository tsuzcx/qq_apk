package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ValueHolder$ReferenceHolder;", "Lshark/ValueHolder;", "value", "", "(J)V", "isNull", "", "()Z", "getValue", "()J", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class ValueHolder$ReferenceHolder
  extends ValueHolder
{
  private final long b;
  
  public ValueHolder$ReferenceHolder(long paramLong)
  {
    super(null);
    this.b = paramLong;
  }
  
  public final boolean a()
  {
    return this.b == 0L;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ReferenceHolder))
      {
        paramObject = (ReferenceHolder)paramObject;
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
    long l = this.b;
    return (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReferenceHolder(value=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ValueHolder.ReferenceHolder
 * JD-Core Version:    0.7.0.1
 */