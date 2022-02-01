package rx.internal.operators;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

public final class OnSubscribeRange
  implements Observable.OnSubscribe<Integer>
{
  private final int endIndex;
  private final int startIndex;
  
  public OnSubscribeRange(int paramInt1, int paramInt2)
  {
    this.startIndex = paramInt1;
    this.endIndex = paramInt2;
  }
  
  public void call(Subscriber<? super Integer> paramSubscriber)
  {
    paramSubscriber.setProducer(new OnSubscribeRange.RangeProducer(paramSubscriber, this.startIndex, this.endIndex));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRange
 * JD-Core Version:    0.7.0.1
 */