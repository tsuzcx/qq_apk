package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

final class OperatorSampleWithTime$SamplerSubscriber<T>
  extends Subscriber<T>
  implements Action0
{
  private static final Object EMPTY_TOKEN = new Object();
  private final Subscriber<? super T> subscriber;
  final AtomicReference<Object> value = new AtomicReference(EMPTY_TOKEN);
  
  public OperatorSampleWithTime$SamplerSubscriber(Subscriber<? super T> paramSubscriber)
  {
    this.subscriber = paramSubscriber;
  }
  
  public void call()
  {
    Object localObject = this.value.getAndSet(EMPTY_TOKEN);
    if (localObject != EMPTY_TOKEN) {}
    try
    {
      this.subscriber.onNext(localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this);
    }
  }
  
  public void onCompleted()
  {
    this.subscriber.onCompleted();
    unsubscribe();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.subscriber.onError(paramThrowable);
    unsubscribe();
  }
  
  public void onNext(T paramT)
  {
    this.value.set(paramT);
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorSampleWithTime.SamplerSubscriber
 * JD-Core Version:    0.7.0.1
 */