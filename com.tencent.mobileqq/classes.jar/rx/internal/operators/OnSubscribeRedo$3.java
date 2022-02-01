package rx.internal.operators;

import rx.Notification;
import rx.Observable.Operator;
import rx.Subscriber;

class OnSubscribeRedo$3
  implements Observable.Operator<Notification<?>, Notification<?>>
{
  OnSubscribeRedo$3(OnSubscribeRedo paramOnSubscribeRedo) {}
  
  public Subscriber<? super Notification<?>> call(Subscriber<? super Notification<?>> paramSubscriber)
  {
    return new OnSubscribeRedo.3.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.3
 * JD-Core Version:    0.7.0.1
 */