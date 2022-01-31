package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

class SingleOperatorOnErrorResumeNext$2
  extends SingleSubscriber<T>
{
  SingleOperatorOnErrorResumeNext$2(SingleOperatorOnErrorResumeNext paramSingleOperatorOnErrorResumeNext, SingleSubscriber paramSingleSubscriber) {}
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      ((Single)SingleOperatorOnErrorResumeNext.access$000(this.this$0).call(paramThrowable)).subscribe(this.val$child);
      return;
    }
    catch (Throwable paramThrowable)
    {
      Exceptions.throwOrReport(paramThrowable, this.val$child);
    }
  }
  
  public void onSuccess(T paramT)
  {
    this.val$child.onSuccess(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.SingleOperatorOnErrorResumeNext.2
 * JD-Core Version:    0.7.0.1
 */