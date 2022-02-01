package rx;

public final class Notification<T>
{
  private static final Notification<Void> ON_COMPLETED = new Notification(Notification.Kind.OnCompleted, null, null);
  private final Notification.Kind kind;
  private final Throwable throwable;
  private final T value;
  
  private Notification(Notification.Kind paramKind, T paramT, Throwable paramThrowable)
  {
    this.value = paramT;
    this.throwable = paramThrowable;
    this.kind = paramKind;
  }
  
  public static <T> Notification<T> createOnCompleted()
  {
    return ON_COMPLETED;
  }
  
  public static <T> Notification<T> createOnCompleted(Class<T> paramClass)
  {
    return ON_COMPLETED;
  }
  
  public static <T> Notification<T> createOnError(Throwable paramThrowable)
  {
    return new Notification(Notification.Kind.OnError, null, paramThrowable);
  }
  
  public static <T> Notification<T> createOnNext(T paramT)
  {
    return new Notification(Notification.Kind.OnNext, paramT, null);
  }
  
  public void accept(Observer<? super T> paramObserver)
  {
    if (isOnNext())
    {
      paramObserver.onNext(getValue());
      return;
    }
    if (isOnCompleted())
    {
      paramObserver.onCompleted();
      return;
    }
    if (isOnError()) {
      paramObserver.onError(getThrowable());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    paramObject = (Notification)paramObject;
    if (paramObject.getKind() != getKind()) {
      return false;
    }
    if ((hasValue()) && (!getValue().equals(paramObject.getValue()))) {
      return false;
    }
    if ((hasThrowable()) && (!getThrowable().equals(paramObject.getThrowable()))) {
      return false;
    }
    if ((!hasValue()) && (!hasThrowable()) && (paramObject.hasValue())) {
      return false;
    }
    return (hasValue()) || (hasThrowable()) || (!paramObject.hasThrowable());
  }
  
  public Notification.Kind getKind()
  {
    return this.kind;
  }
  
  public Throwable getThrowable()
  {
    return this.throwable;
  }
  
  public T getValue()
  {
    return this.value;
  }
  
  public boolean hasThrowable()
  {
    return (isOnError()) && (this.throwable != null);
  }
  
  public boolean hasValue()
  {
    return (isOnNext()) && (this.value != null);
  }
  
  public int hashCode()
  {
    int j = getKind().hashCode();
    int i = j;
    if (hasValue()) {
      i = j * 31 + getValue().hashCode();
    }
    j = i;
    if (hasThrowable()) {
      j = i * 31 + getThrowable().hashCode();
    }
    return j;
  }
  
  public boolean isOnCompleted()
  {
    return getKind() == Notification.Kind.OnCompleted;
  }
  
  public boolean isOnError()
  {
    return getKind() == Notification.Kind.OnError;
  }
  
  public boolean isOnNext()
  {
    return getKind() == Notification.Kind.OnNext;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" ");
    localStringBuilder.append(getKind());
    if (hasValue())
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(getValue());
    }
    if (hasThrowable())
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(getThrowable().getMessage());
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Notification
 * JD-Core Version:    0.7.0.1
 */