package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;

final class OperatorBufferWithSize$BufferOverlap<T>
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> actual;
  final int count;
  long index;
  long produced;
  final ArrayDeque<List<T>> queue;
  final AtomicLong requested;
  final int skip;
  
  public OperatorBufferWithSize$BufferOverlap(Subscriber<? super List<T>> paramSubscriber, int paramInt1, int paramInt2)
  {
    this.actual = paramSubscriber;
    this.count = paramInt1;
    this.skip = paramInt2;
    this.queue = new ArrayDeque();
    this.requested = new AtomicLong();
    request(0L);
  }
  
  Producer createProducer()
  {
    return new OperatorBufferWithSize.BufferOverlap.BufferOverlapProducer(this);
  }
  
  public void onCompleted()
  {
    long l = this.produced;
    if (l != 0L)
    {
      if (l > this.requested.get())
      {
        Subscriber localSubscriber = this.actual;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("More produced than requested? ");
        localStringBuilder.append(l);
        localSubscriber.onError(new MissingBackpressureException(localStringBuilder.toString()));
        return;
      }
      this.requested.addAndGet(-l);
    }
    BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.queue.clear();
    this.actual.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    long l = this.index;
    if (l == 0L)
    {
      localObject = new ArrayList(this.count);
      this.queue.offer(localObject);
    }
    l += 1L;
    if (l == this.skip) {
      this.index = 0L;
    } else {
      this.index = l;
    }
    Object localObject = this.queue.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((List)((Iterator)localObject).next()).add(paramT);
    }
    paramT = (List)this.queue.peek();
    if ((paramT != null) && (paramT.size() == this.count))
    {
      this.queue.poll();
      this.produced += 1L;
      this.actual.onNext(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize.BufferOverlap
 * JD-Core Version:    0.7.0.1
 */