package rx.observables;

import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

class BlockingObservable$9
  implements Observer<T>
{
  BlockingObservable$9(BlockingObservable paramBlockingObservable, Action1 paramAction11, Action1 paramAction12, Action0 paramAction0) {}
  
  public void onCompleted()
  {
    this.val$onCompleted.call();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$onError.call(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.val$onNext.call(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.observables.BlockingObservable.9
 * JD-Core Version:    0.7.0.1
 */