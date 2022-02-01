package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.FuncN;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

class SingleOperatorZip$1$1
  extends SingleSubscriber<T>
{
  SingleOperatorZip$1$1(SingleOperatorZip.1 param1, Object[] paramArrayOfObject, int paramInt, AtomicInteger paramAtomicInteger, SingleSubscriber paramSingleSubscriber, AtomicBoolean paramAtomicBoolean) {}
  
  public void onError(Throwable paramThrowable)
  {
    if (this.val$once.compareAndSet(false, true))
    {
      this.val$subscriber.onError(paramThrowable);
      return;
    }
    RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
  }
  
  public void onSuccess(T paramT)
  {
    this.val$values[this.val$j] = paramT;
    if (this.val$wip.decrementAndGet() == 0) {}
    try
    {
      paramT = this.this$0.val$zipper.call(this.val$values);
      this.val$subscriber.onSuccess(paramT);
      return;
    }
    catch (Throwable paramT)
    {
      Exceptions.throwIfFatal(paramT);
      onError(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.SingleOperatorZip.1.1
 * JD-Core Version:    0.7.0.1
 */