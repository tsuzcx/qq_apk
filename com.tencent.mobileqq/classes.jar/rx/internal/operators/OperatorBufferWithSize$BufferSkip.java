package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Producer;
import rx.Subscriber;

final class OperatorBufferWithSize$BufferSkip<T>
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> actual;
  List<T> buffer;
  final int count;
  long index;
  final int skip;
  
  public OperatorBufferWithSize$BufferSkip(Subscriber<? super List<T>> paramSubscriber, int paramInt1, int paramInt2)
  {
    this.actual = paramSubscriber;
    this.count = paramInt1;
    this.skip = paramInt2;
    request(0L);
  }
  
  Producer createProducer()
  {
    return new OperatorBufferWithSize.BufferSkip.BufferSkipProducer(this);
  }
  
  public void onCompleted()
  {
    List localList = this.buffer;
    if (localList != null)
    {
      this.buffer = null;
      this.actual.onNext(localList);
    }
    this.actual.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.buffer = null;
    this.actual.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    long l = this.index;
    Object localObject = this.buffer;
    if (l == 0L)
    {
      localObject = new ArrayList(this.count);
      this.buffer = ((List)localObject);
    }
    l += 1L;
    if (l == this.skip) {}
    for (this.index = 0L;; this.index = l)
    {
      if (localObject != null)
      {
        ((List)localObject).add(paramT);
        if (((List)localObject).size() == this.count)
        {
          this.buffer = null;
          this.actual.onNext(localObject);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize.BufferSkip
 * JD-Core Version:    0.7.0.1
 */