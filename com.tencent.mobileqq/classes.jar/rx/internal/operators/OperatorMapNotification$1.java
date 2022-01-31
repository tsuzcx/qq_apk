package rx.internal.operators;

import rx.Producer;

class OperatorMapNotification$1
  implements Producer
{
  OperatorMapNotification$1(OperatorMapNotification paramOperatorMapNotification, OperatorMapNotification.MapNotificationSubscriber paramMapNotificationSubscriber) {}
  
  public void request(long paramLong)
  {
    this.val$parent.requestInner(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorMapNotification.1
 * JD-Core Version:    0.7.0.1
 */