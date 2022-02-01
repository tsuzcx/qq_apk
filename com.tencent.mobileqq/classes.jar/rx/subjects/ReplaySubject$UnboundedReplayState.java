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
    int i = get();
    if (i > 0)
    {
      Object localObject = this.list.get(i - 1);
      if ((!this.nl.isCompleted(localObject)) && (!this.nl.isError(localObject))) {
        return this.nl.getValue(localObject);
      }
      if (i > 1) {
        return this.nl.getValue(this.list.get(i - 2));
      }
    }
    return null;
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
      Object localObject1 = (Integer)paramSubjectObserver.index();
      if (localObject1 != null)
      {
        paramSubjectObserver.index(Integer.valueOf(replayObserverFromIndex((Integer)localObject1, paramSubjectObserver).intValue()));
        return true;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("failed to find lastEmittedLink for: ");
      ((StringBuilder)localObject1).append(paramSubjectObserver);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    finally {}
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
    int i = get();
    if (i > 0)
    {
      Object localObject = this.list;
      int j = i - 1;
      localObject = ((ArrayList)localObject).get(j);
      if ((this.nl.isCompleted(localObject)) || (this.nl.isError(localObject))) {
        return j;
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
    int k = size();
    int j = 0;
    Object localObject2;
    if (k > 0)
    {
      int i = j;
      Object localObject1 = paramArrayOfT;
      if (k > paramArrayOfT.length)
      {
        localObject1 = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), k);
        i = j;
      }
      while (i < k)
      {
        localObject1[i] = this.list.get(i);
        i += 1;
      }
      localObject2 = localObject1;
      if (localObject1.length > k)
      {
        localObject1[k] = null;
        return localObject1;
      }
    }
    else
    {
      localObject2 = paramArrayOfT;
      if (paramArrayOfT.length > 0)
      {
        paramArrayOfT[0] = null;
        localObject2 = paramArrayOfT;
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.subjects.ReplaySubject.UnboundedReplayState
 * JD-Core Version:    0.7.0.1
 */