package rx;

class Observable$1
  implements Observable.OnSubscribe<T>
{
  Observable$1(Observable paramObservable) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.add(Observable.access$000(paramSubscriber, this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Observable.1
 * JD-Core Version:    0.7.0.1
 */