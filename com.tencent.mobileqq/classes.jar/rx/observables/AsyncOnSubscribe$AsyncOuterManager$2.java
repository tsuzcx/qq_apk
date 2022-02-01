package rx.observables;

import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

class AsyncOnSubscribe$AsyncOuterManager$2
  implements Action0
{
  AsyncOnSubscribe$AsyncOuterManager$2(AsyncOnSubscribe.AsyncOuterManager paramAsyncOuterManager, Subscriber paramSubscriber) {}
  
  public void call()
  {
    this.this$0.subscriptions.remove(this.val$s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.AsyncOuterManager.2
 * JD-Core Version:    0.7.0.1
 */