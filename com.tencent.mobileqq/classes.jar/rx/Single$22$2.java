package rx;

import java.util.concurrent.CancellationException;

class Single$22$2
  extends SingleSubscriber<E>
{
  Single$22$2(Single.22 param22, Subscriber paramSubscriber) {}
  
  public void onError(Throwable paramThrowable)
  {
    this.val$main.onError(paramThrowable);
  }
  
  public void onSuccess(E paramE)
  {
    onError(new CancellationException("Stream was canceled before emitting a terminal event."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Single.22.2
 * JD-Core Version:    0.7.0.1
 */