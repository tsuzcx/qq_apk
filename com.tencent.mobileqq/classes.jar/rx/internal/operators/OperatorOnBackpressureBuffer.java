package rx.internal.operators;

import rx.BackpressureOverflow;
import rx.BackpressureOverflow.Strategy;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action0;

public class OperatorOnBackpressureBuffer<T>
  implements Observable.Operator<T, T>
{
  private final Long capacity;
  private final Action0 onOverflow;
  private final BackpressureOverflow.Strategy overflowStrategy;
  
  OperatorOnBackpressureBuffer()
  {
    this.capacity = null;
    this.onOverflow = null;
    this.overflowStrategy = BackpressureOverflow.ON_OVERFLOW_DEFAULT;
  }
  
  public OperatorOnBackpressureBuffer(long paramLong)
  {
    this(paramLong, null, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
  }
  
  public OperatorOnBackpressureBuffer(long paramLong, Action0 paramAction0)
  {
    this(paramLong, paramAction0, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
  }
  
  public OperatorOnBackpressureBuffer(long paramLong, Action0 paramAction0, BackpressureOverflow.Strategy paramStrategy)
  {
    if (paramLong > 0L)
    {
      if (paramStrategy != null)
      {
        this.capacity = Long.valueOf(paramLong);
        this.onOverflow = paramAction0;
        this.overflowStrategy = paramStrategy;
        return;
      }
      throw new NullPointerException("The BackpressureOverflow strategy must not be null");
    }
    throw new IllegalArgumentException("Buffer capacity must be > 0");
  }
  
  public static <T> OperatorOnBackpressureBuffer<T> instance()
  {
    return OperatorOnBackpressureBuffer.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorOnBackpressureBuffer.BufferSubscriber localBufferSubscriber = new OperatorOnBackpressureBuffer.BufferSubscriber(paramSubscriber, this.capacity, this.onOverflow, this.overflowStrategy);
    paramSubscriber.add(localBufferSubscriber);
    paramSubscriber.setProducer(localBufferSubscriber.manager());
    return localBufferSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureBuffer
 * JD-Core Version:    0.7.0.1
 */