package rx.internal.operators;

import rx.Subscriber;

final class OnSubscribeJoin$ResultSink$LeftSubscriber$LeftDurationSubscriber
  extends Subscriber<TLeftDuration>
{
  final int id;
  boolean once = true;
  
  public OnSubscribeJoin$ResultSink$LeftSubscriber$LeftDurationSubscriber(OnSubscribeJoin.ResultSink.LeftSubscriber paramLeftSubscriber, int paramInt)
  {
    this.id = paramInt;
  }
  
  public void onCompleted()
  {
    if (this.once)
    {
      this.once = false;
      this.this$2.expire(this.id, this);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$2.onError(paramThrowable);
  }
  
  public void onNext(TLeftDuration paramTLeftDuration)
  {
    onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin.ResultSink.LeftSubscriber.LeftDurationSubscriber
 * JD-Core Version:    0.7.0.1
 */