package rx.internal.operators;

import rx.Observable;
import rx.functions.Func1;

final class OperatorOnErrorResumeNextViaFunction$3
  implements Func1<Throwable, Observable<? extends T>>
{
  OperatorOnErrorResumeNextViaFunction$3(Observable paramObservable) {}
  
  public Observable<? extends T> call(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof Exception)) {
      return this.val$other;
    }
    return Observable.error(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorOnErrorResumeNextViaFunction.3
 * JD-Core Version:    0.7.0.1
 */