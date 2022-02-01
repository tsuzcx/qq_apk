package rx.internal.operators;

import rx.Subscriber;
import rx.functions.Action0;

class OperatorDoAfterTerminate$1
  extends Subscriber<T>
{
  OperatorDoAfterTerminate$1(OperatorDoAfterTerminate paramOperatorDoAfterTerminate, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    try
    {
      this.val$child.onCompleted();
      return;
    }
    finally
    {
      this.this$0.action.call();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      this.val$child.onError(paramThrowable);
      return;
    }
    finally
    {
      this.this$0.action.call();
    }
  }
  
  public void onNext(T paramT)
  {
    this.val$child.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorDoAfterTerminate.1
 * JD-Core Version:    0.7.0.1
 */