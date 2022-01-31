package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observer;
import rx.internal.operators.NotificationLite;

final class ReplaySubject$UnboundedReplayState<T>
  extends AtomicInteger
  implements ReplaySubject.ReplayState<T, Integer>
{
  private final ArrayList<Object> list;
  private final NotificationLite<T> nl = NotificationLite.instance();
  private volatile boolean terminated;
  
  public ReplaySubject$UnboundedReplayState(int paramInt)
  {
    this.list = new ArrayList(paramInt);
  }
  
  public void accept(Observer<? super T> paramObserver, int paramInt)
  {
    this.nl.accept(paramObserver, this.list.get(paramInt));
  }
  
  public void complete()
  {
    if (!this.terminated)
    {
      this.terminated = true;
      this.list.add(this.nl.completed());
      getAndIncrement();
    }
  }
  
  public void error(Throwable paramThrowable)
  {
    if (!this.terminated)
    {
      this.terminated = true;
      this.list.add(this.nl.error(paramThrowable));
      getAndIncrement();
    }
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public T latest()
  {
    Object localObject2 = null;
    int i = get();
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject1 = this.list.get(i - 1);
      if ((!this.nl.isCompleted(localObject1)) && (!this.nl.isError(localObject1))) {
        break label73;
      }
      localObject1 = localObject2;
      if (i > 1) {
        localObject1 = this.nl.getValue(this.list.get(i - 2));
      }
    }
    return localObject1;
    label73:
    return this.nl.getValue(localObject1);
  }
  
  public void next(T paramT)
  {
    if (!this.terminated)
    {
      this.list.add(this.nl.next(paramT));
      getAndIncrement();
    }
  }
  
  public boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
  {
    try
    {
      paramSubjectObserver.first = false;
      if (paramSubjectObserver.emitting) {
        return false;
      }
      Integer localInteger = (Integer)paramSubjectObserver.index();
      if (localInteger != null)
      {
        paramSubjectObserver.index(Integer.valueOf(replayObserverFromIndex(localInteger, paramSubjectObserver).intValue()));
        return true;
      }
    }
    finally {}
    throw new IllegalStateException("failed to find lastEmittedLink for: " + paramSubjectObserver);
  }
  
  public Integer replayObserverFromIndex(Integer paramInteger, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
  {
    int i = paramInteger.intValue();
    while (i < get())
    {
      accept(paramSubjectObserver, i);
      i += 1;
    }
    return Integer.valueOf(i);
  }
  
  public Integer replayObserverFromIndexTest(Integer paramInteger, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong)
  {
    return replayObserverFromIndex(paramInteger, paramSubjectObserver);
  }
  
  public int size()
  {
    int j = get();
    int i = j;
    if (j > 0)
    {
      Object localObject = this.list.get(j - 1);
      if (!this.nl.isCompleted(localObject))
      {
        i = j;
        if (!this.nl.isError(localObject)) {}
      }
      else
      {
        i = j - 1;
      }
    }
    return i;
  }
  
  public boolean terminated()
  {
    return this.terminated;
  }
  
  public T[] toArray(T[] paramArrayOfT)
  {
    int i = 0;
    int j = size();
    if (j > 0)
    {
      if (j <= paramArrayOfT.length) {
        break label81;
      }
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    }
    label81:
    for (;;)
    {
      if (i < j)
      {
        paramArrayOfT[i] = this.list.get(i);
        i += 1;
      }
      else
      {
        if (paramArrayOfT.length > j) {
          paramArrayOfT[j] = null;
        }
        return paramArrayOfT;
        if (paramArrayOfT.length > 0) {
          paramArrayOfT[0] = null;
        }
        return paramArrayOfT;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.subjects.ReplaySubject.UnboundedReplayState
 * JD-Core Version:    0.7.0.1
 */