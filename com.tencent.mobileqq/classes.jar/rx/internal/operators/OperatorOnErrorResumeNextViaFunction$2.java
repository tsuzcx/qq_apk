package rx.internal.operators;

import rx.Observable;
import rx.functions.Func1;

final class OperatorOnErrorResumeNextViaFunction$2
  implements Func1<Throwable, Observable<? extends T>>
{
  OperatorOnErrorResumeNextViaFunction$2(Observable paramObservable) {}
  
  public Observable<? extends T> call(Throwable paramThrowable)
  {
    return this.val$other;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorOnErrorResumeNextViaFunction.2
 * JD-Core Version:    0.7.0.1
 */