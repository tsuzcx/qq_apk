package rx.internal.operators;

import rx.Observer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.RxRingBuffer;

final class OperatorZip$Zip$InnerSubscriber
  extends Subscriber
{
  final RxRingBuffer items = RxRingBuffer.getSpmcInstance();
  
  OperatorZip$Zip$InnerSubscriber(OperatorZip.Zip paramZip) {}
  
  public void onCompleted()
  {
    this.items.onCompleted();
    this.this$0.tick();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$0.child.onError(paramThrowable);
  }
  
  public void onNext(Object paramObject)
  {
    try
    {
      this.items.onNext(paramObject);
    }
    catch (MissingBackpressureException paramObject)
    {
      onError(paramObject);
    }
    this.this$0.tick();
  }
  
  public void onStart()
  {
    request(RxRingBuffer.SIZE);
  }
  
  public void requestMore(long paramLong)
  {
    request(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorZip.Zip.InnerSubscriber
 * JD-Core Version:    0.7.0.1
 */