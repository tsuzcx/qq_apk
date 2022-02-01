package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;

final class OperatorDebounceWithTime$DebounceState<T>
{
  boolean emitting;
  boolean hasValue;
  int index;
  boolean terminate;
  T value;
  
  public void clear()
  {
    try
    {
      this.index += 1;
      this.value = null;
      this.hasValue = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void emit(int paramInt, Subscriber<T> paramSubscriber, Subscriber<?> paramSubscriber1)
  {
    try
    {
      if ((!this.emitting) && (this.hasValue) && (paramInt == this.index))
      {
        Object localObject = this.value;
        this.value = null;
        this.hasValue = false;
        this.emitting = true;
        try
        {
          paramSubscriber.onNext(localObject);
          try
          {
            if (!this.terminate)
            {
              this.emitting = false;
              return;
            }
            paramSubscriber.onCompleted();
            return;
          }
          finally {}
        }
        catch (Throwable paramSubscriber)
        {
          Exceptions.throwOrReport(paramSubscriber, paramSubscriber1, localObject);
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  public void emitAndComplete(Subscriber<T> paramSubscriber, Subscriber<?> paramSubscriber1)
  {
    try
    {
      if (this.emitting)
      {
        this.terminate = true;
        return;
      }
      Object localObject = this.value;
      boolean bool = this.hasValue;
      this.value = null;
      this.hasValue = false;
      this.emitting = true;
      if (bool) {
        try
        {
          paramSubscriber.onNext(localObject);
        }
        catch (Throwable paramSubscriber)
        {
          Exceptions.throwOrReport(paramSubscriber, paramSubscriber1, localObject);
          return;
        }
      }
      paramSubscriber.onCompleted();
      return;
    }
    finally {}
  }
  
  public int next(T paramT)
  {
    try
    {
      this.value = paramT;
      this.hasValue = true;
      int i = this.index + 1;
      this.index = i;
      return i;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorDebounceWithTime.DebounceState
 * JD-Core Version:    0.7.0.1
 */