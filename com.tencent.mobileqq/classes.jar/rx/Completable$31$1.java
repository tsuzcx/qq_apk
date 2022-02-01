package rx;

import rx.functions.Func0;

class Completable$31$1
  implements Completable.CompletableSubscriber
{
  Completable$31$1(Completable.31 param31, SingleSubscriber paramSingleSubscriber) {}
  
  public void onCompleted()
  {
    try
    {
      Object localObject = this.this$1.val$completionValueFunc0.call();
      if (localObject == null)
      {
        this.val$s.onError(new NullPointerException("The value supplied is null"));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      this.val$s.onError(localThrowable);
      return;
    }
    this.val$s.onSuccess(localThrowable);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$s.onError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$s.add(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Completable.31.1
 * JD-Core Version:    0.7.0.1
 */