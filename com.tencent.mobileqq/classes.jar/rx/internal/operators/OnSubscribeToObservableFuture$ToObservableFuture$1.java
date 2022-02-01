package rx.internal.operators;

import java.util.concurrent.Future;
import rx.functions.Action0;

class OnSubscribeToObservableFuture$ToObservableFuture$1
  implements Action0
{
  OnSubscribeToObservableFuture$ToObservableFuture$1(OnSubscribeToObservableFuture.ToObservableFuture paramToObservableFuture) {}
  
  public void call()
  {
    this.this$0.that.cancel(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeToObservableFuture.ToObservableFuture.1
 * JD-Core Version:    0.7.0.1
 */