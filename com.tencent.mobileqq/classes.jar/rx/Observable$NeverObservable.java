package rx;

class Observable$NeverObservable<T>
  extends Observable<T>
{
  Observable$NeverObservable()
  {
    super(new Observable.NeverObservable.1());
  }
  
  static <T> NeverObservable<T> instance()
  {
    return Observable.NeverObservable.Holder.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Observable.NeverObservable
 * JD-Core Version:    0.7.0.1
 */