package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty1.Setter;
import kotlin.reflect.KProperty1.Getter;

public abstract class MutablePropertyReference1
  extends MutablePropertyReference
  implements KMutableProperty1
{
  public MutablePropertyReference1() {}
  
  @SinceKotlin(version="1.1")
  public MutablePropertyReference1(Object paramObject)
  {
    super(paramObject);
  }
  
  protected KCallable computeReflected()
  {
    return Reflection.mutableProperty1(this);
  }
  
  @SinceKotlin(version="1.1")
  public Object getDelegate(Object paramObject)
  {
    return ((KMutableProperty1)getReflected()).getDelegate(paramObject);
  }
  
  public KProperty1.Getter getGetter()
  {
    return ((KMutableProperty1)getReflected()).getGetter();
  }
  
  public KMutableProperty1.Setter getSetter()
  {
    return ((KMutableProperty1)getReflected()).getSetter();
  }
  
  public Object invoke(Object paramObject)
  {
    return get(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.internal.MutablePropertyReference1
 * JD-Core Version:    0.7.0.1
 */