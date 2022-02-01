package rx.exceptions;

public final class OnErrorThrowable
  extends RuntimeException
{
  private static final long serialVersionUID = -569558213262703934L;
  private final boolean hasValue;
  private final Object value;
  
  private OnErrorThrowable(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.hasValue = false;
    this.value = null;
  }
  
  private OnErrorThrowable(Throwable paramThrowable, Object paramObject)
  {
    super(paramThrowable);
    this.hasValue = true;
    this.value = paramObject;
  }
  
  public static Throwable addValueAsLastCause(Throwable paramThrowable, Object paramObject)
  {
    Object localObject = paramThrowable;
    if (paramThrowable == null) {
      localObject = new NullPointerException();
    }
    paramThrowable = Exceptions.getFinalCause((Throwable)localObject);
    if ((paramThrowable != null) && ((paramThrowable instanceof OnErrorThrowable.OnNextValue)) && (((OnErrorThrowable.OnNextValue)paramThrowable).getValue() == paramObject)) {
      return localObject;
    }
    Exceptions.addCause((Throwable)localObject, new OnErrorThrowable.OnNextValue(paramObject));
    return localObject;
  }
  
  public static OnErrorThrowable from(Throwable paramThrowable)
  {
    Object localObject = paramThrowable;
    if (paramThrowable == null) {
      localObject = new NullPointerException();
    }
    paramThrowable = Exceptions.getFinalCause((Throwable)localObject);
    if ((paramThrowable instanceof OnErrorThrowable.OnNextValue)) {
      return new OnErrorThrowable((Throwable)localObject, ((OnErrorThrowable.OnNextValue)paramThrowable).getValue());
    }
    return new OnErrorThrowable((Throwable)localObject);
  }
  
  public Object getValue()
  {
    return this.value;
  }
  
  public boolean isValueNull()
  {
    return this.hasValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.exceptions.OnErrorThrowable
 * JD-Core Version:    0.7.0.1
 */