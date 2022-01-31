package rx.observables;

import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

class BlockingObservable$8
  implements Action1<Throwable>
{
  BlockingObservable$8(BlockingObservable paramBlockingObservable) {}
  
  public void call(Throwable paramThrowable)
  {
    throw new OnErrorNotImplementedException(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.observables.BlockingObservable.8
 * JD-Core Version:    0.7.0.1
 */