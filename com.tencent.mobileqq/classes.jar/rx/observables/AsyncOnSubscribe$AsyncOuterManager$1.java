package rx.observables;

import rx.Subscriber;
import rx.internal.operators.BufferUntilSubscriber;

class AsyncOnSubscribe$AsyncOuterManager$1
  extends Subscriber<T>
{
  long remaining = this.val$expected;
  
  AsyncOnSubscribe$AsyncOuterManager$1(AsyncOnSubscribe.AsyncOuterManager paramAsyncOuterManager, long paramLong, BufferUntilSubscriber paramBufferUntilSubscriber) {}
  
  public void onCompleted()
  {
    this.val$buffer.onCompleted();
    long l = this.remaining;
    if (l > 0L) {
      this.this$0.requestRemaining(l);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$buffer.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.remaining -= 1L;
    this.val$buffer.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.AsyncOuterManager.1
 * JD-Core Version:    0.7.0.1
 */