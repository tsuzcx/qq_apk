package rx;

import java.util.concurrent.CancellationException;

class Single$20$2
  implements Completable.CompletableSubscriber
{
  Single$20$2(Single.20 param20, Subscriber paramSubscriber1, Subscriber paramSubscriber2) {}
  
  public void onCompleted()
  {
    onError(new CancellationException("Stream was canceled before emitting a terminal event."));
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$main.onError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$serial.add(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Single.20.2
 * JD-Core Version:    0.7.0.1
 */