package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import rx.Observer;
import rx.functions.Func1;
import rx.internal.operators.NotificationLite;

final class ReplaySubject$BoundedState<T>
  implements ReplaySubject.ReplayState<T, ReplaySubject.NodeList.Node<Object>>
{
  final Func1<Object, Object> enterTransform;
  final ReplaySubject.EvictionPolicy evictionPolicy;
  final Func1<Object, Object> leaveTransform;
  final ReplaySubject.NodeList<Object> list = new ReplaySubject.NodeList();
  final NotificationLite<T> nl = NotificationLite.instance();
  volatile ReplaySubject.NodeList.Node<Object> tail = this.list.tail;
  volatile boolean terminated;
  
  public ReplaySubject$BoundedState(ReplaySubject.EvictionPolicy paramEvictionPolicy, Func1<Object, Object> paramFunc11, Func1<Object, Object> paramFunc12)
  {
    this.evictionPolicy = paramEvictionPolicy;
    this.enterTransform = paramFunc11;
    this.leaveTransform = paramFunc12;
  }
  
  public void accept(Observer<? super T> paramObserver, ReplaySubject.NodeList.Node<Object> paramNode)
  {
    this.nl.accept(paramObserver, this.leaveTransform.call(paramNode.value));
  }
  
  public void acceptTest(Observer<? super T> paramObserver, ReplaySubject.NodeList.Node<Object> paramNode, long paramLong)
  {
    paramNode = paramNode.value;
    if (!this.evictionPolicy.test(paramNode, paramLong)) {
      this.nl.accept(paramObserver, this.leaveTransform.call(paramNode));
    }
  }
  
  public void complete()
  {
    if (!this.terminated)
    {
      this.terminated = true;
      this.list.addLast(this.enterTransform.call(this.nl.completed()));
      this.evictionPolicy.evictFinal(this.list);
      this.tail = this.list.tail;
    }
  }
  
  public void error(Throwable paramThrowable)
  {
    if (!this.terminated)
    {
      this.terminated = true;
      this.list.addLast(this.enterTransform.call(this.nl.error(paramThrowable)));
      this.evictionPolicy.evictFinal(this.list);
      this.tail = this.list.tail;
    }
  }
  
  public ReplaySubject.NodeList.Node<Object> head()
  {
    return this.list.head;
  }
  
  public boolean isEmpty()
  {
    Object localObject = head().next;
    if (localObject == null) {}
    do
    {
      return true;
      localObject = this.leaveTransform.call(((ReplaySubject.NodeList.Node)localObject).value);
    } while ((this.nl.isError(localObject)) || (this.nl.isCompleted(localObject)));
    return false;
  }
  
  public T latest()
  {
    Object localObject1 = head().next;
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      return null;
      localObject2 = null;
      while (localObject1 != tail())
      {
        ReplaySubject.NodeList.Node localNode = ((ReplaySubject.NodeList.Node)localObject1).next;
        localObject2 = localObject1;
        localObject1 = localNode;
      }
      localObject1 = this.leaveTransform.call(((ReplaySubject.NodeList.Node)localObject1).value);
      if ((!this.nl.isError(localObject1)) && (!this.nl.isCompleted(localObject1))) {
        break;
      }
    } while (localObject2 == null);
    localObject1 = this.leaveTransform.call(localObject2.value);
    return this.nl.getValue(localObject1);
    return this.nl.getValue(localObject1);
  }
  
  public void next(T paramT)
  {
    if (!this.terminated)
    {
      this.list.addLast(this.enterTransform.call(this.nl.next(paramT)));
      this.evictionPolicy.evict(this.list);
      this.tail = this.list.tail;
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
      paramSubjectObserver.index(replayObserverFromIndex((ReplaySubject.NodeList.Node)paramSubjectObserver.index(), paramSubjectObserver));
      return true;
    }
    finally {}
  }
  
  public ReplaySubject.NodeList.Node<Object> replayObserverFromIndex(ReplaySubject.NodeList.Node<Object> paramNode, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
  {
    while (paramNode != tail())
    {
      accept(paramSubjectObserver, paramNode.next);
      paramNode = paramNode.next;
    }
    return paramNode;
  }
  
  public ReplaySubject.NodeList.Node<Object> replayObserverFromIndexTest(ReplaySubject.NodeList.Node<Object> paramNode, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong)
  {
    while (paramNode != tail())
    {
      acceptTest(paramSubjectObserver, paramNode.next, paramLong);
      paramNode = paramNode.next;
    }
    return paramNode;
  }
  
  public int size()
  {
    Object localObject1 = head();
    Object localObject2 = ((ReplaySubject.NodeList.Node)localObject1).next;
    int i = 0;
    Object localObject3 = localObject1;
    localObject1 = localObject2;
    while (localObject1 != null)
    {
      localObject3 = ((ReplaySubject.NodeList.Node)localObject1).next;
      i += 1;
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject2;
    }
    int j = i;
    if (((ReplaySubject.NodeList.Node)localObject3).value != null)
    {
      localObject1 = this.leaveTransform.call(((ReplaySubject.NodeList.Node)localObject3).value);
      j = i;
      if (localObject1 != null) {
        if (!this.nl.isError(localObject1))
        {
          j = i;
          if (!this.nl.isCompleted(localObject1)) {}
        }
        else
        {
          j = i - 1;
        }
      }
    }
    return j;
  }
  
  public ReplaySubject.NodeList.Node<Object> tail()
  {
    return this.tail;
  }
  
  public boolean terminated()
  {
    return this.terminated;
  }
  
  public T[] toArray(T[] paramArrayOfT)
  {
    ArrayList localArrayList = new ArrayList();
    for (ReplaySubject.NodeList.Node localNode = head().next;; localNode = localNode.next)
    {
      Object localObject;
      if (localNode != null)
      {
        localObject = this.leaveTransform.call(localNode.value);
        if ((localNode.next != null) || ((!this.nl.isError(localObject)) && (!this.nl.isCompleted(localObject)))) {}
      }
      else
      {
        return localArrayList.toArray(paramArrayOfT);
      }
      localArrayList.add(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.subjects.ReplaySubject.BoundedState
 * JD-Core Version:    0.7.0.1
 */