package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

final class OnSubscribeJoin$ResultSink
{
  final CompositeSubscription group;
  final Object guard = new Object();
  boolean leftDone;
  int leftId;
  final Map<Integer, TLeft> leftMap;
  boolean rightDone;
  int rightId;
  final Map<Integer, TRight> rightMap;
  final Subscriber<? super R> subscriber;
  
  public OnSubscribeJoin$ResultSink(Subscriber<? super R> paramSubscriber)
  {
    Object localObject;
    this.subscriber = localObject;
    this.group = new CompositeSubscription();
    this.leftMap = new HashMap();
    this.rightMap = new HashMap();
  }
  
  public void run()
  {
    this.subscriber.add(this.group);
    OnSubscribeJoin.ResultSink.LeftSubscriber localLeftSubscriber = new OnSubscribeJoin.ResultSink.LeftSubscriber(this);
    OnSubscribeJoin.ResultSink.RightSubscriber localRightSubscriber = new OnSubscribeJoin.ResultSink.RightSubscriber(this);
    this.group.add(localLeftSubscriber);
    this.group.add(localRightSubscriber);
    this.this$0.left.unsafeSubscribe(localLeftSubscriber);
    this.this$0.right.unsafeSubscribe(localRightSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin.ResultSink
 * JD-Core Version:    0.7.0.1
 */