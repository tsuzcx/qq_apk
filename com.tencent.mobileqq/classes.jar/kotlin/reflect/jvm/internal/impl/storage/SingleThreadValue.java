package kotlin.reflect.jvm.internal.impl.storage;

class SingleThreadValue<T>
{
  private final Thread thread;
  private final T value;
  
  SingleThreadValue(T paramT)
  {
    this.value = paramT;
    this.thread = Thread.currentThread();
  }
  
  public T getValue()
  {
    if (hasValue()) {
      return this.value;
    }
    throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
  }
  
  public boolean hasValue()
  {
    return this.thread == Thread.currentThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.SingleThreadValue
 * JD-Core Version:    0.7.0.1
 */