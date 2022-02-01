package kotlin.reflect.jvm.internal;

public abstract class ReflectProperties$Val<T>
{
  private static final Object NULL_VALUE = new ReflectProperties.Val.1();
  
  protected Object escape(T paramT)
  {
    Object localObject = paramT;
    if (paramT == null) {
      localObject = NULL_VALUE;
    }
    return localObject;
  }
  
  public final T getValue(Object paramObject1, Object paramObject2)
  {
    return invoke();
  }
  
  public abstract T invoke();
  
  protected T unescape(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == NULL_VALUE) {
      localObject = null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.ReflectProperties.Val
 * JD-Core Version:    0.7.0.1
 */