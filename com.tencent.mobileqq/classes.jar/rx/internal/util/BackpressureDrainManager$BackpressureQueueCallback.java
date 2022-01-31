package rx.internal.util;

public abstract interface BackpressureDrainManager$BackpressureQueueCallback
{
  public abstract boolean accept(Object paramObject);
  
  public abstract void complete(Throwable paramThrowable);
  
  public abstract Object peek();
  
  public abstract Object poll();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
 * JD-Core Version:    0.7.0.1
 */