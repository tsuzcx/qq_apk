package rx.internal.operators;

import rx.Notification;
import rx.Subscriber;

class OperatorDematerialize$1
  extends Subscriber<Notification<T>>
{
  boolean terminated;
  
  OperatorDematerialize$1(OperatorDematerialize paramOperatorDematerialize, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    if (!this.terminated)
    {
      this.terminated = true;
      this.val$child.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.terminated)
    {
      this.terminated = true;
      this.val$child.onError(paramThrowable);
    }
  }
  
  public void onNext(Notification<T> paramNotification)
  {
    int i = OperatorDematerialize.2.$SwitchMap$rx$Notification$Kind[paramNotification.getKind().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        onCompleted();
        return;
      }
      onError(paramNotification.getThrowable());
      return;
    }
    if (!this.terminated) {
      this.val$child.onNext(paramNotification.getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorDematerialize.1
 * JD-Core Version:    0.7.0.1
 */