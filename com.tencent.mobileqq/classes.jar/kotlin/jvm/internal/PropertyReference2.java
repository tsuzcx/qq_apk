package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KProperty2.Getter;

public abstract class PropertyReference2
  extends PropertyReference
  implements KProperty2
{
  protected KCallable computeReflected()
  {
    return Reflection.property2(this);
  }
  
  @SinceKotlin(version="1.1")
  public Object getDelegate(Object paramObject1, Object paramObject2)
  {
    return ((KProperty2)getReflected()).getDelegate(paramObject1, paramObject2);
  }
  
  public KProperty2.Getter getGetter()
  {
    return ((KProperty2)getReflected()).getGetter();
  }
  
  public Object invoke(Object paramObject1, Object paramObject2)
  {
    return get(paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.internal.PropertyReference2
 * JD-Core Version:    0.7.0.1
 */