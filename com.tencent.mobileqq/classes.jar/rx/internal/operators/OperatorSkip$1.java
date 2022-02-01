package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;

class OperatorSkip$1
  extends Subscriber<T>
{
  int skipped = 0;
  
  OperatorSkip$1(OperatorSkip paramOperatorSkip, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    this.val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (this.skipped >= this.this$0.toSkip)
    {
      this.val$child.onNext(paramT);
      return;
    }
    this.skipped += 1;
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.val$child.setProducer(paramProducer);
    paramProducer.request(this.this$0.toSkip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorSkip.1
 * JD-Core Version:    0.7.0.1
 */