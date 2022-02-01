package rx;

class Single$19$1$1
  extends SingleSubscriber<T>
{
  Single$19$1$1(Single.19.1 param1) {}
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      this.this$2.val$t.onError(paramThrowable);
      return;
    }
    finally
    {
      this.this$2.val$w.unsubscribe();
    }
  }
  
  public void onSuccess(T paramT)
  {
    try
    {
      this.this$2.val$t.onSuccess(paramT);
      return;
    }
    finally
    {
      this.this$2.val$w.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Single.19.1.1
 * JD-Core Version:    0.7.0.1
 */