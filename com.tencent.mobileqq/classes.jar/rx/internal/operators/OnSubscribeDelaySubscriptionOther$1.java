package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.SerialSubscription;

class OnSubscribeDelaySubscriptionOther$1
  extends Subscriber<U>
{
  boolean done;
  
  OnSubscribeDelaySubscriptionOther$1(OnSubscribeDelaySubscriptionOther paramOnSubscribeDelaySubscriptionOther, Subscriber paramSubscriber, SerialSubscription paramSerialSubscription) {}
  
  public void onCompleted()
  {
    if (this.done) {
      return;
    }
    this.done = true;
    this.val$serial.set(this.val$child);
    this.this$0.main.unsafeSubscribe(this.val$child);
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.done)
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
      return;
    }
    this.done = true;
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(U paramU)
  {
    onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeDelaySubscriptionOther.1
 * JD-Core Version:    0.7.0.1
 */