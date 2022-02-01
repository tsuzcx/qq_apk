package rx;

import rx.functions.Func0;

class Completable$31
  implements Single.OnSubscribe<T>
{
  Completable$31(Completable paramCompletable, Func0 paramFunc0) {}
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    this.this$0.subscribe(new Completable.31.1(this, paramSingleSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Completable.31
 * JD-Core Version:    0.7.0.1
 */