package rx.internal.operators;

import rx.Observable;
import rx.functions.Func1;

final class OperatorOnErrorResumeNextViaFunction$1
  implements Func1<Throwable, Observable<? extends T>>
{
  OperatorOnErrorResumeNextViaFunction$1(Func1 paramFunc1) {}
  
  public Observable<? extends T> call(Throwable paramThrowable)
  {
    return Observable.just(this.val$resumeFunction.call(paramThrowable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorOnErrorResumeNextViaFunction.1
 * JD-Core Version:    0.7.0.1
 */