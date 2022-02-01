package rx;

import rx.functions.Action0;
import rx.functions.Action1;

class Completable$18
  implements Action1<Throwable>
{
  Completable$18(Completable paramCompletable, Action0 paramAction0) {}
  
  public void call(Throwable paramThrowable)
  {
    this.val$onTerminate.call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Completable.18
 * JD-Core Version:    0.7.0.1
 */