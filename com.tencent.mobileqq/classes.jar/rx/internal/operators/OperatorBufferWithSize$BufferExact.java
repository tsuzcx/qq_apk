package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Producer;
import rx.Subscriber;

final class OperatorBufferWithSize$BufferExact<T>
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> actual;
  List<T> buffer;
  final int count;
  
  public OperatorBufferWithSize$BufferExact(Subscriber<? super List<T>> paramSubscriber, int paramInt)
  {
    this.actual = paramSubscriber;
    this.count = paramInt;
    request(0L);
  }
  
  Producer createProducer()
  {
    return new OperatorBufferWithSize.BufferExact.1(this);
  }
  
  public void onCompleted()
  {
    List localList = this.buffer;
    if (localList != null) {
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
    List localList = this.buffer;
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(this.count);
      this.buffer = ((List)localObject);
    }
    ((List)localObject).add(paramT);
    if (((List)localObject).size() == this.count)
    {
      this.buffer = null;
      this.actual.onNext(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize.BufferExact
 * JD-Core Version:    0.7.0.1
 */