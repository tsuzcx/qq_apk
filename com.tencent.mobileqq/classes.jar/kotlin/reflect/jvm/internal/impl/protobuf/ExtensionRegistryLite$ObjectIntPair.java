package kotlin.reflect.jvm.internal.impl.protobuf;

final class ExtensionRegistryLite$ObjectIntPair
{
  private final int number;
  private final Object object;
  
  ExtensionRegistryLite$ObjectIntPair(Object paramObject, int paramInt)
  {
    this.object = paramObject;
    this.number = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ObjectIntPair;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (ObjectIntPair)paramObject;
    bool1 = bool2;
    if (this.object == paramObject.object)
    {
      bool1 = bool2;
      if (this.number == paramObject.number) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this.object) * 65535 + this.number;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite.ObjectIntPair
 * JD-Core Version:    0.7.0.1
 */