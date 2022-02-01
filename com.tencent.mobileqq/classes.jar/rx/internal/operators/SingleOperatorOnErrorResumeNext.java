package rx.internal.operators;

import rx.Single;
import rx.Single.OnSubscribe;
import rx.SingleSubscriber;
import rx.functions.Func1;

public class SingleOperatorOnErrorResumeNext<T>
  implements Single.OnSubscribe<T>
{
  private final Single<? extends T> originalSingle;
  private final Func1<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError;
  
  private SingleOperatorOnErrorResumeNext(Single<? extends T> paramSingle, Func1<Throwable, ? extends Single<? extends T>> paramFunc1)
  {
    if (paramSingle != null)
    {
      if (paramFunc1 != null)
      {
        this.originalSingle = paramSingle;
        this.resumeFunctionInCaseOfError = paramFunc1;
        return;
      }
      throw new NullPointerException("resumeFunctionInCaseOfError must not be null");
    }
    throw new NullPointerException("originalSingle must not be null");
  }
  
  public static <T> SingleOperatorOnErrorResumeNext<T> withFunction(Single<? extends T> paramSingle, Func1<Throwable, ? extends Single<? extends T>> paramFunc1)
  {
    return new SingleOperatorOnErrorResumeNext(paramSingle, paramFunc1);
  }
  
  public static <T> SingleOperatorOnErrorResumeNext<T> withOther(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2)
  {
    if (paramSingle2 != null) {
      return new SingleOperatorOnErrorResumeNext(paramSingle1, new SingleOperatorOnErrorResumeNext.1(paramSingle2));
    }
    throw new NullPointerException("resumeSingleInCaseOfError must not be null");
  }
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    SingleOperatorOnErrorResumeNext.2 local2 = new SingleOperatorOnErrorResumeNext.2(this, paramSingleSubscriber);
    paramSingleSubscriber.add(local2);
    this.originalSingle.subscribe(local2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.SingleOperatorOnErrorResumeNext
 * JD-Core Version:    0.7.0.1
 */