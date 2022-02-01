package rx.internal.operators;

import java.util.ArrayList;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;

final class OperatorReplay$UnboundedReplayBuffer<T>
  extends ArrayList<Object>
  implements OperatorReplay.ReplayBuffer<T>
{
  private static final long serialVersionUID = 7063189396499112664L;
  final NotificationLite<T> nl = NotificationLite.instance();
  volatile int size;
  
  public OperatorReplay$UnboundedReplayBuffer(int paramInt)
  {
    super(paramInt);
  }
  
  public void complete()
  {
    add(this.nl.completed());
    this.size += 1;
  }
  
  public void error(Throwable paramThrowable)
  {
    add(this.nl.error(paramThrowable));
    this.size += 1;
  }
  
  public void next(T paramT)
  {
    add(this.nl.next(paramT));
    this.size += 1;
  }
  
  public void replay(OperatorReplay.InnerProducer<T> paramInnerProducer)
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
        int j = this.size;
        Object localObject1 = (Integer)paramInnerProducer.index();
        int i;
        if (localObject1 != null) {
          i = ((Integer)localObject1).intValue();
        } else {
          i = 0;
        }
        long l3 = paramInnerProducer.get();
        long l2 = l3;
        long l1 = 0L;
        while ((l2 != 0L) && (i < j))
        {
          localObject1 = get(i);
          try
          {
            boolean bool = this.nl.accept(paramInnerProducer.child, localObject1);
            if (bool) {
              return;
            }
            if (paramInnerProducer.isUnsubscribed()) {
              return;
            }
            i += 1;
            l2 -= 1L;
            l1 += 1L;
          }
          catch (Throwable localThrowable)
          {
            Exceptions.throwIfFatal(localThrowable);
            paramInnerProducer.unsubscribe();
            if ((!this.nl.isError(localObject1)) && (!this.nl.isCompleted(localObject1))) {
              paramInnerProducer.child.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, this.nl.getValue(localObject1)));
            }
            return;
          }
        }
        if (l1 != 0L)
        {
          paramInnerProducer.index = Integer.valueOf(i);
          if (l3 != 9223372036854775807L) {
            paramInnerProducer.produced(l1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.UnboundedReplayBuffer
 * JD-Core Version:    0.7.0.1
 */