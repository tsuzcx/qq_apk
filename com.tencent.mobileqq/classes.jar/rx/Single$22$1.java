package rx;

class Single$22$1
  extends Subscriber<T>
{
  Single$22$1(Single.22 param22, Subscriber paramSubscriber1, boolean paramBoolean, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1, paramBoolean);
  }
  
  public void onCompleted()
  {
    try
    {
      this.val$serial.onCompleted();
      return;
    }
    finally
    {
      this.val$serial.unsubscribe();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      this.val$serial.onError(paramThrowable);
      return;
    }
    finally
    {
      this.val$serial.unsubscribe();
    }
  }
  
  public void onNext(T paramT)
  {
    this.val$serial.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Single.22.1
 * JD-Core Version:    0.7.0.1
 */