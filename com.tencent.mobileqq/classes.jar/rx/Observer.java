package rx;

public abstract interface Observer<T>
{
  public abstract void onCompleted();
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onNext(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Observer
 * JD-Core Version:    0.7.0.1
 */