package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.internal.util.LinkedArrayList;
import rx.subscriptions.SerialSubscription;

final class CachedObservable$CacheState<T>
  extends LinkedArrayList
  implements Observer<T>
{
  static final CachedObservable.ReplayProducer<?>[] EMPTY = new CachedObservable.ReplayProducer[0];
  final SerialSubscription connection;
  volatile boolean isConnected;
  final NotificationLite<T> nl;
  volatile CachedObservable.ReplayProducer<?>[] producers;
  final Observable<? extends T> source;
  boolean sourceDone;
  
  public CachedObservable$CacheState(Observable<? extends T> paramObservable, int paramInt)
  {
    super(paramInt);
    this.source = paramObservable;
    this.producers = EMPTY;
    this.nl = NotificationLite.instance();
    this.connection = new SerialSubscription();
  }
  
  public void addProducer(CachedObservable.ReplayProducer<T> paramReplayProducer)
  {
    synchronized (this.connection)
    {
      CachedObservable.ReplayProducer[] arrayOfReplayProducer1 = this.producers;
      int i = arrayOfReplayProducer1.length;
      CachedObservable.ReplayProducer[] arrayOfReplayProducer2 = new CachedObservable.ReplayProducer[i + 1];
      System.arraycopy(arrayOfReplayProducer1, 0, arrayOfReplayProducer2, 0, i);
      arrayOfReplayProducer2[i] = paramReplayProducer;
      this.producers = arrayOfReplayProducer2;
      return;
    }
  }
  
  public void connect()
  {
    CachedObservable.CacheState.1 local1 = new CachedObservable.CacheState.1(this);
    this.connection.set(local1);
    this.source.unsafeSubscribe(local1);
    this.isConnected = true;
  }
  
  void dispatch()
  {
    CachedObservable.ReplayProducer[] arrayOfReplayProducer = this.producers;
    int j = arrayOfReplayProducer.length;
    int i = 0;
    while (i < j)
    {
      arrayOfReplayProducer[i].replay();
      i += 1;
    }
  }
  
  public void onCompleted()
  {
    if (!this.sourceDone)
    {
      this.sourceDone = true;
      add(this.nl.completed());
      this.connection.unsubscribe();
      dispatch();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.sourceDone)
    {
      this.sourceDone = true;
      add(this.nl.error(paramThrowable));
      this.connection.unsubscribe();
      dispatch();
    }
  }
  
  public void onNext(T paramT)
  {
    if (!this.sourceDone)
    {
      add(this.nl.next(paramT));
      dispatch();
    }
  }
  
  public void removeProducer(CachedObservable.ReplayProducer<T> paramReplayProducer)
  {
    int i = 0;
    for (;;)
    {
      CachedObservable.ReplayProducer[] arrayOfReplayProducer;
      int j;
      synchronized (this.connection)
      {
        arrayOfReplayProducer = this.producers;
        j = arrayOfReplayProducer.length;
        if (i >= j) {
          break label107;
        }
        if (!arrayOfReplayProducer[i].equals(paramReplayProducer)) {
          break label112;
        }
        if (i < 0) {
          return;
        }
        if (j == 1)
        {
          this.producers = EMPTY;
          return;
        }
      }
      paramReplayProducer = new CachedObservable.ReplayProducer[j - 1];
      System.arraycopy(arrayOfReplayProducer, 0, paramReplayProducer, 0, i);
      System.arraycopy(arrayOfReplayProducer, i + 1, paramReplayProducer, i, j - i - 1);
      this.producers = paramReplayProducer;
      return;
      label107:
      i = -1;
      continue;
      label112:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.CachedObservable.CacheState
 * JD-Core Version:    0.7.0.1
 */