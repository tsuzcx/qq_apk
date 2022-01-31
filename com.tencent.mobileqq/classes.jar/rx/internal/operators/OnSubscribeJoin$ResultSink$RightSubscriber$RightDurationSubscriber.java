package rx.internal.operators;

import rx.Subscriber;

final class OnSubscribeJoin$ResultSink$RightSubscriber$RightDurationSubscriber
  extends Subscriber<TRightDuration>
{
  final int id;
  boolean once = true;
  
  public OnSubscribeJoin$ResultSink$RightSubscriber$RightDurationSubscriber(OnSubscribeJoin.ResultSink.RightSubscriber paramRightSubscriber, int paramInt)
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
  
  public void onNext(TRightDuration paramTRightDuration)
  {
    onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin.ResultSink.RightSubscriber.RightDurationSubscriber
 * JD-Core Version:    0.7.0.1
 */