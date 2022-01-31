package rx;

class Observable$ThrowObservable<T>
  extends Observable<T>
{
  public Observable$ThrowObservable(Throwable paramThrowable)
  {
    super(new Observable.ThrowObservable.1(paramThrowable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Observable.ThrowObservable
 * JD-Core Version:    0.7.0.1
 */