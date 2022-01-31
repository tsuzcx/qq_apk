package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.SingleSubscriber;
import rx.Subscriber;

class OnSubscribeSingle$1
  extends Subscriber<T>
{
  private T emission = null;
  private boolean emittedTooMany = false;
  private boolean itemEmitted = false;
  
  OnSubscribeSingle$1(OnSubscribeSingle paramOnSubscribeSingle, SingleSubscriber paramSingleSubscriber) {}
  
  public void onCompleted()
  {
    if (this.emittedTooMany) {
      return;
    }
    if (this.itemEmitted)
    {
      this.val$child.onSuccess(this.emission);
      return;
    }
    this.val$child.onError(new NoSuchElementException("Observable emitted no items"));
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    if (this.itemEmitted)
    {
      this.emittedTooMany = true;
      this.val$child.onError(new IllegalArgumentException("Observable emitted too many elements"));
      unsubscribe();
      return;
    }
    this.itemEmitted = true;
    this.emission = paramT;
  }
  
  public void onStart()
  {
    request(2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeSingle.1
 * JD-Core Version:    0.7.0.1
 */