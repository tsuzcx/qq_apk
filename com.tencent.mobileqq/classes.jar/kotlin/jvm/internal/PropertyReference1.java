package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty1.Getter;

public abstract class PropertyReference1
  extends PropertyReference
  implements KProperty1
{
  public PropertyReference1() {}
  
  @SinceKotlin(version="1.1")
  public PropertyReference1(Object paramObject)
  {
    super(paramObject);
  }
  
  protected KCallable computeReflected()
  {
    return Reflection.property1(this);
  }
  
  @SinceKotlin(version="1.1")
  public Object getDelegate(Object paramObject)
  {
    return ((KProperty1)getReflected()).getDelegate(paramObject);
  }
  
  public KProperty1.Getter getGetter()
  {
    return ((KProperty1)getReflected()).getGetter();
  }
  
  public Object invoke(Object paramObject)
  {
    return get(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.jvm.internal.PropertyReference1
 * JD-Core Version:    0.7.0.1
 */