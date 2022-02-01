package kotlin.reflect.jvm.internal.impl.protobuf;

public class LazyField
  extends LazyFieldLite
{
  private final MessageLite defaultInstance;
  
  public boolean equals(Object paramObject)
  {
    return getValue().equals(paramObject);
  }
  
  public MessageLite getValue()
  {
    return getValue(this.defaultInstance);
  }
  
  public int hashCode()
  {
    return getValue().hashCode();
  }
  
  public String toString()
  {
    return getValue().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.LazyField
 * JD-Core Version:    0.7.0.1
 */