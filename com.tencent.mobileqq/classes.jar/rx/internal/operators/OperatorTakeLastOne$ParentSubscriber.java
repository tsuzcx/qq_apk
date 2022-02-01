package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Subscriber;
import rx.exceptions.Exceptions;

class OperatorTakeLastOne$ParentSubscriber<T>
  extends Subscriber<T>
{
  private static final Object ABSENT = new Object();
  private static final int NOT_REQUESTED_COMPLETED = 1;
  private static final int NOT_REQUESTED_NOT_COMPLETED = 0;
  private static final int REQUESTED_COMPLETED = 3;
  private static final int REQUESTED_NOT_COMPLETED = 2;
  private final Subscriber<? super T> child;
  private T last = ABSENT;
  private final AtomicInteger state = new AtomicInteger(0);
  
  OperatorTakeLastOne$ParentSubscriber(Subscriber<? super T> paramSubscriber)
  {
    this.child = paramSubscriber;
  }
  
  private void emit()
  {
    if (isUnsubscribed())
    {
      this.last = null;
      return;
    }
    Object localObject = this.last;
    this.last = null;
    if (localObject != ABSENT) {
      try
      {
        this.child.onNext(localObject);
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwOrReport(localThrowable, this.child);
        return;
      }
    }
    if (!isUnsubscribed()) {
      this.child.onCompleted();
    }
  }
  
  public void onCompleted()
  {
    if (this.last == ABSENT)
    {
      this.child.onCompleted();
      return;
    }
    do
    {
      int i;
      do
      {
        i = this.state.get();
        if (i != 0) {
          break;
        }
      } while (!this.state.compareAndSet(0, 1));
      return;
      if (i != 2) {
        break;
      }
    } while (!this.state.compareAndSet(2, 3));
    emit();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.last = paramT;
  }
  
  void requestMore(long paramLong)
  {
    if (paramLong > 0L)
    {
      do
      {
        int i;
        do
        {
          i = this.state.get();
          if (i != 0) {
            break;
          }
        } while (!this.state.compareAndSet(0, 2));
        return;
        if (i != 1) {
          break;
        }
      } while (!this.state.compareAndSet(1, 3));
      emit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeLastOne.ParentSubscriber
 * JD-Core Version:    0.7.0.1
 */