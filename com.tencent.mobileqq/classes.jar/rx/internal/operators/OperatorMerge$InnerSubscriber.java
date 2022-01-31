package rx.internal.operators;

import java.util.Queue;
import rx.Subscriber;
import rx.internal.util.RxRingBuffer;

final class OperatorMerge$InnerSubscriber<T>
  extends Subscriber<T>
{
  static final int limit = RxRingBuffer.SIZE / 4;
  volatile boolean done;
  final long id;
  int outstanding;
  final OperatorMerge.MergeSubscriber<T> parent;
  volatile RxRingBuffer queue;
  
  public OperatorMerge$InnerSubscriber(OperatorMerge.MergeSubscriber<T> paramMergeSubscriber, long paramLong)
  {
    this.parent = paramMergeSubscriber;
    this.id = paramLong;
  }
  
  public void onCompleted()
  {
    this.done = true;
    this.parent.emit();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.done = true;
    this.parent.getOrCreateErrorQueue().offer(paramThrowable);
    this.parent.emit();
  }
  
  public void onNext(T paramT)
  {
    this.parent.tryEmit(this, paramT);
  }
  
  public void onStart()
  {
    this.outstanding = RxRingBuffer.SIZE;
    request(RxRingBuffer.SIZE);
  }
  
  public void requestMore(long paramLong)
  {
    int i = this.outstanding - (int)paramLong;
    if (i > limit) {
      this.outstanding = i;
    }
    do
    {
      return;
      this.outstanding = RxRingBuffer.SIZE;
      i = RxRingBuffer.SIZE - i;
    } while (i <= 0);
    request(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorMerge.InnerSubscriber
 * JD-Core Version:    0.7.0.1
 */