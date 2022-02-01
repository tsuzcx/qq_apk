package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Timestamped;

class OperatorSkipLastTimed$1
  extends Subscriber<T>
{
  private Deque<Timestamped<T>> buffer = new ArrayDeque();
  
  OperatorSkipLastTimed$1(OperatorSkipLastTimed paramOperatorSkipLastTimed, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  private void emitItemsOutOfWindow(long paramLong)
  {
    long l = this.this$0.timeInMillis;
    while (!this.buffer.isEmpty())
    {
      Timestamped localTimestamped = (Timestamped)this.buffer.getFirst();
      if (localTimestamped.getTimestampMillis() >= paramLong - l) {
        break;
      }
      this.buffer.removeFirst();
      this.val$subscriber.onNext(localTimestamped.getValue());
    }
  }
  
  public void onCompleted()
  {
    emitItemsOutOfWindow(this.this$0.scheduler.now());
    this.val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    long l = this.this$0.scheduler.now();
    emitItemsOutOfWindow(l);
    this.buffer.offerLast(new Timestamped(l, paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorSkipLastTimed.1
 * JD-Core Version:    0.7.0.1
 */