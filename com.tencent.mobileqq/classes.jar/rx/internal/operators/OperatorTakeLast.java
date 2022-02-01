package rx.internal.operators;

import java.util.ArrayDeque;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorTakeLast<T>
  implements Observable.Operator<T, T>
{
  final int count;
  
  public OperatorTakeLast(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.count = paramInt;
      return;
    }
    throw new IndexOutOfBoundsException("count cannot be negative");
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    ArrayDeque localArrayDeque = new ArrayDeque();
    NotificationLite localNotificationLite = NotificationLite.instance();
    TakeLastQueueProducer localTakeLastQueueProducer = new TakeLastQueueProducer(localNotificationLite, localArrayDeque, paramSubscriber);
    paramSubscriber.setProducer(localTakeLastQueueProducer);
    return new OperatorTakeLast.1(this, paramSubscriber, localArrayDeque, localNotificationLite, localTakeLastQueueProducer, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeLast
 * JD-Core Version:    0.7.0.1
 */