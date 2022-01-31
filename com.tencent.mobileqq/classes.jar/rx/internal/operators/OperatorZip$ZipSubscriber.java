package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

final class OperatorZip$ZipSubscriber
  extends Subscriber<Observable[]>
{
  final Subscriber<? super R> child;
  final OperatorZip.ZipProducer<R> producer;
  boolean started = false;
  final OperatorZip.Zip<R> zipper;
  
  public OperatorZip$ZipSubscriber(Subscriber<? super R> paramSubscriber, OperatorZip.Zip<R> paramZip, OperatorZip.ZipProducer<R> paramZipProducer)
  {
    this.child = paramZip;
    this.zipper = paramZipProducer;
    Object localObject;
    this.producer = localObject;
  }
  
  public void onCompleted()
  {
    if (!this.started) {
      this.child.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.child.onError(paramThrowable);
  }
  
  public void onNext(Observable[] paramArrayOfObservable)
  {
    if ((paramArrayOfObservable == null) || (paramArrayOfObservable.length == 0))
    {
      this.child.onCompleted();
      return;
    }
    this.started = true;
    this.zipper.start(paramArrayOfObservable, this.producer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorZip.ZipSubscriber
 * JD-Core Version:    0.7.0.1
 */