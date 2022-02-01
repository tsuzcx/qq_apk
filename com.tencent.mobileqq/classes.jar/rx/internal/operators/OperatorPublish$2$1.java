package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;

class OperatorPublish$2$1
  extends Subscriber<R>
{
  OperatorPublish$2$1(OperatorPublish.2 param2, Subscriber paramSubscriber, OnSubscribePublishMulticast paramOnSubscribePublishMulticast) {}
  
  public void onCompleted()
  {
    this.val$op.unsubscribe();
    this.val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$op.unsubscribe();
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(R paramR)
  {
    this.val$child.onNext(paramR);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.val$child.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorPublish.2.1
 * JD-Core Version:    0.7.0.1
 */