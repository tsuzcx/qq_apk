package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.util.RxRingBuffer;

final class OperatorPublish$2
  implements Observable.OnSubscribe<R>
{
  OperatorPublish$2(boolean paramBoolean, Func1 paramFunc1, Observable paramObservable) {}
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    OnSubscribePublishMulticast localOnSubscribePublishMulticast = new OnSubscribePublishMulticast(RxRingBuffer.SIZE, this.val$delayError);
    OperatorPublish.2.1 local1 = new OperatorPublish.2.1(this, paramSubscriber, localOnSubscribePublishMulticast);
    paramSubscriber.add(localOnSubscribePublishMulticast);
    paramSubscriber.add(local1);
    ((Observable)this.val$selector.call(Observable.create(localOnSubscribePublishMulticast))).unsafeSubscribe(local1);
    this.val$source.unsafeSubscribe(localOnSubscribePublishMulticast.subscriber());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorPublish.2
 * JD-Core Version:    0.7.0.1
 */