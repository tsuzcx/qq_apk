package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty0.Getter;

public abstract class PropertyReference0
  extends PropertyReference
  implements KProperty0
{
  public PropertyReference0() {}
  
  @SinceKotlin(version="1.1")
  public PropertyReference0(Object paramObject)
  {
    super(paramObject);
  }
  
  protected KCallable computeReflected()
  {
    return Reflection.property0(this);
  }
  
  @SinceKotlin(version="1.1")
  public Object getDelegate()
  {
    return ((KProperty0)getReflected()).getDelegate();
  }
  
  public KProperty0.Getter getGetter()
  {
    return ((KProperty0)getReflected()).getGetter();
  }
  
  public Object invoke()
  {
    return get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.jvm.internal.PropertyReference0
 * JD-Core Version:    0.7.0.1
 */