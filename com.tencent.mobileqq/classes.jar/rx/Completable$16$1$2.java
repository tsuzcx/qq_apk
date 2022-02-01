package rx;

import rx.functions.Action0;

class Completable$16$1$2
  implements Action0
{
  Completable$16$1$2(Completable.16.1 param1, Throwable paramThrowable) {}
  
  public void call()
  {
    try
    {
      this.this$2.val$s.onError(this.val$e);
      return;
    }
    finally
    {
      this.this$2.val$w.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Completable.16.1.2
 * JD-Core Version:    0.7.0.1
 */