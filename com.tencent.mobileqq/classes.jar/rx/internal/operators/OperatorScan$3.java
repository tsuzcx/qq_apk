package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

class OperatorScan$3
  extends Subscriber<T>
{
  private R value = this.val$initialValue;
  
  OperatorScan$3(OperatorScan paramOperatorScan, Object paramObject, OperatorScan.InitialProducer paramInitialProducer) {}
  
  public void onCompleted()
  {
    this.val$ip.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$ip.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    Object localObject = this.value;
    try
    {
      localObject = this.this$0.accumulator.call(localObject, paramT);
      this.value = localObject;
      this.val$ip.onNext(localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this, paramT);
    }
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.val$ip.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorScan.3
 * JD-Core Version:    0.7.0.1
 */