package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class OperatorBufferWithTime$InexactSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super List<T>> child;
  final List<List<T>> chunks;
  boolean done;
  final Scheduler.Worker inner;
  
  public OperatorBufferWithTime$InexactSubscriber(Subscriber<? super List<T>> paramSubscriber, Scheduler.Worker paramWorker)
  {
    this.child = paramWorker;
    Object localObject;
    this.inner = localObject;
    this.chunks = new LinkedList();
  }
  
  void emitChunk(List<T> paramList)
  {
    try
    {
      if (this.done) {
        return;
      }
      Iterator localIterator = this.chunks.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while ((List)localIterator.next() != paramList);
      localIterator.remove();
      i = 1;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw paramList;
        }
        int i = 0;
      }
    }
    if (i != 0) {
      try
      {
        this.child.onNext(paramList);
        return;
      }
      catch (Throwable paramList)
      {
        Exceptions.throwOrReport(paramList, this);
      }
    }
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
        Object localObject1 = new LinkedList(this.chunks);
        this.chunks.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          List localList = (List)((Iterator)localObject1).next();
          this.child.onNext(localList);
        }
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
      this.chunks.clear();
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
      Iterator localIterator = this.chunks.iterator();
      Object localObject1 = null;
      while (localIterator.hasNext())
      {
        List localList = (List)localIterator.next();
        localList.add(paramT);
        if (localList.size() == this.this$0.count)
        {
          localIterator.remove();
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new LinkedList();
          }
          ((List)localObject2).add(localList);
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null)
      {
        paramT = ((List)localObject1).iterator();
        while (paramT.hasNext())
        {
          localObject1 = (List)paramT.next();
          this.child.onNext(localObject1);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramT;
    }
  }
  
  void scheduleChunk()
  {
    this.inner.schedulePeriodically(new OperatorBufferWithTime.InexactSubscriber.1(this), this.this$0.timeshift, this.this$0.timeshift, this.this$0.unit);
  }
  
  void startNewChunk()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (this.done) {
        return;
      }
      this.chunks.add(localArrayList);
      this.inner.schedule(new OperatorBufferWithTime.InexactSubscriber.2(this, localArrayList), this.this$0.timespan, this.this$0.unit);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithTime.InexactSubscriber
 * JD-Core Version:    0.7.0.1
 */