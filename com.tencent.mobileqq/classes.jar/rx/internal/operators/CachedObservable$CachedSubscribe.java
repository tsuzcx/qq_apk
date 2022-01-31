package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

final class CachedObservable$CachedSubscribe<T>
  extends AtomicBoolean
  implements Observable.OnSubscribe<T>
{
  private static final long serialVersionUID = -2817751667698696782L;
  final CachedObservable.CacheState<T> state;
  
  public CachedObservable$CachedSubscribe(CachedObservable.CacheState<T> paramCacheState)
  {
    this.state = paramCacheState;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    CachedObservable.ReplayProducer localReplayProducer = new CachedObservable.ReplayProducer(paramSubscriber, this.state);
    this.state.addProducer(localReplayProducer);
    paramSubscriber.add(localReplayProducer);
    paramSubscriber.setProducer(localReplayProducer);
    if ((!get()) && (compareAndSet(false, true))) {
      this.state.connect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.CachedObservable.CachedSubscribe
 * JD-Core Version:    0.7.0.1
 */