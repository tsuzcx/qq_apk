package rx.internal.operators;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

class OperatorReplay$2$1
  implements Action1<Subscription>
{
  OperatorReplay$2$1(OperatorReplay.2 param2, Subscriber paramSubscriber) {}
  
  public void call(Subscription paramSubscription)
  {
    this.val$child.add(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.2.1
 * JD-Core Version:    0.7.0.1
 */