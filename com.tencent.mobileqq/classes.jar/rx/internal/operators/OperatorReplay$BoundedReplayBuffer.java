package rx.internal.operators;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;

class OperatorReplay$BoundedReplayBuffer<T>
  extends AtomicReference<OperatorReplay.Node>
  implements OperatorReplay.ReplayBuffer<T>
{
  private static final long serialVersionUID = 2346567790059478686L;
  long index;
  final NotificationLite<T> nl = NotificationLite.instance();
  int size;
  OperatorReplay.Node tail;
  
  public OperatorReplay$BoundedReplayBuffer()
  {
    OperatorReplay.Node localNode = new OperatorReplay.Node(null, 0L);
    this.tail = localNode;
    set(localNode);
  }
  
  final void addLast(OperatorReplay.Node paramNode)
  {
    this.tail.set(paramNode);
    this.tail = paramNode;
    this.size += 1;
  }
  
  final void collect(Collection<? super T> paramCollection)
  {
    OperatorReplay.Node localNode = (OperatorReplay.Node)get();
    for (;;)
    {
      localNode = (OperatorReplay.Node)localNode.get();
      if (localNode == null) {
        break;
      }
      Object localObject = leaveTransform(localNode.value);
      if (this.nl.isCompleted(localObject)) {
        break;
      }
      if (this.nl.isError(localObject)) {
        return;
      }
      paramCollection.add(this.nl.getValue(localObject));
    }
  }
  
  public final void complete()
  {
    Object localObject = enterTransform(this.nl.completed());
    long l = this.index + 1L;
    this.index = l;
    addLast(new OperatorReplay.Node(localObject, l));
    truncateFinal();
  }
  
  Object enterTransform(Object paramObject)
  {
    return paramObject;
  }
  
  public final void error(Throwable paramThrowable)
  {
    paramThrowable = enterTransform(this.nl.error(paramThrowable));
    long l = this.index + 1L;
    this.index = l;
    addLast(new OperatorReplay.Node(paramThrowable, l));
    truncateFinal();
  }
  
  boolean hasCompleted()
  {
    return (this.tail.value != null) && (this.nl.isCompleted(leaveTransform(this.tail.value)));
  }
  
  boolean hasError()
  {
    return (this.tail.value != null) && (this.nl.isError(leaveTransform(this.tail.value)));
  }
  
  Object leaveTransform(Object paramObject)
  {
    return paramObject;
  }
  
  public final void next(T paramT)
  {
    paramT = enterTransform(this.nl.next(paramT));
    long l = this.index + 1L;
    this.index = l;
    addLast(new OperatorReplay.Node(paramT, l));
    truncate();
  }
  
  final void removeFirst()
  {
    OperatorReplay.Node localNode = (OperatorReplay.Node)((OperatorReplay.Node)get()).get();
    if (localNode != null)
    {
      this.size -= 1;
      setFirst(localNode);
      return;
    }
    throw new IllegalStateException("Empty list!");
  }
  
  final void removeSome(int paramInt)
  {
    OperatorReplay.Node localNode = (OperatorReplay.Node)get();
    while (paramInt > 0)
    {
      localNode = (OperatorReplay.Node)localNode.get();
      paramInt -= 1;
      this.size -= 1;
    }
    setFirst(localNode);
  }
  
  public final void replay(OperatorReplay.InnerProducer<T> paramInnerProducer)
  {
    try
    {
      if (paramInnerProducer.emitting)
      {
        paramInnerProducer.missed = true;
        return;
      }
      paramInnerProducer.emitting = true;
      for (;;)
      {
        if (paramInnerProducer.isUnsubscribed()) {
          return;
        }
        long l1 = paramInnerProducer.get();
        int i;
        if (l1 == 9223372036854775807L) {
          i = 1;
        } else {
          i = 0;
        }
        OperatorReplay.Node localNode = (OperatorReplay.Node)paramInnerProducer.index();
        Object localObject1 = localNode;
        if (localNode == null)
        {
          localObject1 = (OperatorReplay.Node)get();
          paramInnerProducer.index = localObject1;
          paramInnerProducer.addTotalRequested(((OperatorReplay.Node)localObject1).index);
        }
        if (paramInnerProducer.isUnsubscribed()) {
          return;
        }
        long l2 = 0L;
        while (l1 != 0L)
        {
          localNode = (OperatorReplay.Node)((OperatorReplay.Node)localObject1).get();
          if (localNode != null)
          {
            localObject1 = leaveTransform(localNode.value);
            try
            {
              if (this.nl.accept(paramInnerProducer.child, localObject1))
              {
                paramInnerProducer.index = null;
                return;
              }
              l2 += 1L;
              l1 -= 1L;
              if (paramInnerProducer.isUnsubscribed()) {
                return;
              }
              localObject1 = localNode;
            }
            catch (Throwable localThrowable)
            {
              paramInnerProducer.index = null;
              Exceptions.throwIfFatal(localThrowable);
              paramInnerProducer.unsubscribe();
              if ((!this.nl.isError(localObject1)) && (!this.nl.isCompleted(localObject1))) {
                paramInnerProducer.child.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, this.nl.getValue(localObject1)));
              }
              return;
            }
          }
        }
        if (l2 != 0L)
        {
          paramInnerProducer.index = localObject1;
          if (i == 0) {
            paramInnerProducer.produced(l2);
          }
        }
        try
        {
          if (!paramInnerProducer.missed)
          {
            paramInnerProducer.emitting = false;
            return;
          }
          paramInnerProducer.missed = false;
        }
        finally {}
      }
      throw localObject3;
    }
    finally {}
    for (;;) {}
  }
  
  final void setFirst(OperatorReplay.Node paramNode)
  {
    set(paramNode);
  }
  
  void truncate() {}
  
  void truncateFinal() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.BoundedReplayBuffer
 * JD-Core Version:    0.7.0.1
 */