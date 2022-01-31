package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class OperatorBufferWithSingleObservable$BufferingSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> child;
  List<T> chunk;
  boolean done;
  
  public OperatorBufferWithSingleObservable$BufferingSubscriber(Subscriber<? super List<T>> paramSubscriber)
  {
    Object localObject;
    this.child = localObject;
    this.chunk = new ArrayList(paramSubscriber.initialCapacity);
  }
  
  void emit()
  {
    try
    {
      if (this.done) {
        return;
      }
      List localList = this.chunk;
      this.chunk = new ArrayList(this.this$0.initialCapacity);
      try
      {
        this.child.onNext(localList);
        return;
      }
      catch (Throwable localThrowable1)
      {
        unsubscribe();
        try
        {
          if (this.done) {
            return;
          }
        }
        finally {}
      }
      this.done = true;
    }
    finally {}
    Exceptions.throwOrReport(localThrowable2, this.child);
  }
  
  public void onCompleted()
  {
    try
    {
      try
      {
        if (this.done) {
          return;
        }
        this.done = true;
        List localList = this.chunk;
        this.chunk = null;
        this.child.onNext(localList);
        this.child.onCompleted();
        unsubscribe();
        return;
      }
      finally {}
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this.child);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      if (this.done) {
        return;
      }
      this.done = true;
      this.chunk = null;
      this.child.onError(paramThrowable);
      unsubscribe();
      return;
    }
    finally {}
  }
  
  public void onNext(T paramT)
  {
    try
    {
      if (this.done) {
        return;
      }
      this.chunk.add(paramT);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSingleObservable.BufferingSubscriber
 * JD-Core Version:    0.7.0.1
 */