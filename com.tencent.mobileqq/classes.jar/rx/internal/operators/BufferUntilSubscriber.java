package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import rx.Observer;
import rx.subjects.Subject;

public final class BufferUntilSubscriber<T>
  extends Subject<T, T>
{
  static final Observer EMPTY_OBSERVER = new BufferUntilSubscriber.1();
  private boolean forward = false;
  final BufferUntilSubscriber.State<T> state;
  
  private BufferUntilSubscriber(BufferUntilSubscriber.State<T> paramState)
  {
    super(new BufferUntilSubscriber.OnSubscribeAction(paramState));
    this.state = paramState;
  }
  
  public static <T> BufferUntilSubscriber<T> create()
  {
    return new BufferUntilSubscriber(new BufferUntilSubscriber.State());
  }
  
  private void emit(Object paramObject)
  {
    synchronized (this.state.guard)
    {
      this.state.buffer.add(paramObject);
      if ((this.state.get() != null) && (!this.state.emitting))
      {
        this.forward = true;
        this.state.emitting = true;
      }
      if (this.forward)
      {
        paramObject = this.state.buffer.poll();
        if (paramObject != null) {
          this.state.nl.accept((Observer)this.state.get(), paramObject);
        }
      }
    }
  }
  
  public boolean hasObservers()
  {
    for (;;)
    {
      synchronized (this.state.guard)
      {
        if (this.state.get() != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void onCompleted()
  {
    if (this.forward)
    {
      ((Observer)this.state.get()).onCompleted();
      return;
    }
    emit(this.state.nl.completed());
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.forward)
    {
      ((Observer)this.state.get()).onError(paramThrowable);
      return;
    }
    emit(this.state.nl.error(paramThrowable));
  }
  
  public void onNext(T paramT)
  {
    if (this.forward)
    {
      ((Observer)this.state.get()).onNext(paramT);
      return;
    }
    emit(this.state.nl.next(paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.BufferUntilSubscriber
 * JD-Core Version:    0.7.0.1
 */