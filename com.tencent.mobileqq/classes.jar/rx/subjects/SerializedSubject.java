package rx.subjects;

import rx.observers.SerializedObserver;

public class SerializedSubject<T, R>
  extends Subject<T, R>
{
  private final Subject<T, R> actual;
  private final SerializedObserver<T> observer;
  
  public SerializedSubject(Subject<T, R> paramSubject)
  {
    super(new SerializedSubject.1(paramSubject));
    this.actual = paramSubject;
    this.observer = new SerializedObserver(paramSubject);
  }
  
  public boolean hasObservers()
  {
    return this.actual.hasObservers();
  }
  
  public void onCompleted()
  {
    this.observer.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.observer.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.observer.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.subjects.SerializedSubject
 * JD-Core Version:    0.7.0.1
 */