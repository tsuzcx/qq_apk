package rx.internal.operators;

import rx.Single;
import rx.functions.Func1;

final class SingleOperatorOnErrorResumeNext$1
  implements Func1<Throwable, Single<? extends T>>
{
  SingleOperatorOnErrorResumeNext$1(Single paramSingle) {}
  
  public Single<? extends T> call(Throwable paramThrowable)
  {
    return this.val$resumeSingleInCaseOfError;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.SingleOperatorOnErrorResumeNext.1
 * JD-Core Version:    0.7.0.1
 */