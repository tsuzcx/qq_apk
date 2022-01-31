package rx.internal.operators;

import rx.Notification;
import rx.functions.Func2;

class OnSubscribeRedo$RetryWithPredicate$1
  implements Func2<Notification<Integer>, Notification<?>, Notification<Integer>>
{
  OnSubscribeRedo$RetryWithPredicate$1(OnSubscribeRedo.RetryWithPredicate paramRetryWithPredicate) {}
  
  public Notification<Integer> call(Notification<Integer> paramNotification, Notification<?> paramNotification1)
  {
    int i = ((Integer)paramNotification.getValue()).intValue();
    paramNotification = paramNotification1;
    if (((Boolean)this.this$0.predicate.call(Integer.valueOf(i), paramNotification1.getThrowable())).booleanValue()) {
      paramNotification = Notification.createOnNext(Integer.valueOf(i + 1));
    }
    return paramNotification;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.RetryWithPredicate.1
 * JD-Core Version:    0.7.0.1
 */