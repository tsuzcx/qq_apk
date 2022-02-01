package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KMutableProperty;

public abstract class MutablePropertyReference
  extends PropertyReference
  implements KMutableProperty
{
  public MutablePropertyReference() {}
  
  @SinceKotlin(version="1.1")
  public MutablePropertyReference(Object paramObject)
  {
    super(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.jvm.internal.MutablePropertyReference
 * JD-Core Version:    0.7.0.1
 */