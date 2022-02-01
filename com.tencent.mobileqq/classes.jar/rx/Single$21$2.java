package rx;

import java.util.concurrent.CancellationException;

class Single$21$2
  extends Subscriber<E>
{
  Single$21$2(Single.21 param21, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    onError(new CancellationException("Stream was canceled before emitting a terminal event."));
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$main.onError(paramThrowable);
  }
  
  public void onNext(E paramE)
  {
    onError(new CancellationException("Stream was canceled before emitting a terminal event."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Single.21.2
 * JD-Core Version:    0.7.0.1
 */