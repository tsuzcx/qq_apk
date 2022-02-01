package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Scheduler.Worker;
import rx.Subscriber;

final class OperatorWindowWithTime$InexactSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super Observable<T>> child;
  final List<OperatorWindowWithTime.CountedSerializedSubject<T>> chunks;
  boolean done;
  final Object guard;
  final Scheduler.Worker worker;
  
  public OperatorWindowWithTime$InexactSubscriber(Subscriber<? super Observable<T>> paramSubscriber, Scheduler.Worker paramWorker)
  {
    super(paramWorker);
    this.child = paramWorker;
    Object localObject;
    this.worker = localObject;
    this.guard = new Object();
    this.chunks = new LinkedList();
  }
  
  OperatorWindowWithTime.CountedSerializedSubject<T> createCountedSerializedSubject()
  {
    UnicastSubject localUnicastSubject = UnicastSubject.create();
    return new OperatorWindowWithTime.CountedSerializedSubject(localUnicastSubject, localUnicastSubject);
  }
  
  public void onCompleted()
  {
    synchronized (this.guard)
    {
      if (this.done) {
        return;
      }
      this.done = true;
      ArrayList localArrayList = new ArrayList(this.chunks);
      this.chunks.clear();
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext()) {
        ((OperatorWindowWithTime.CountedSerializedSubject)((Iterator)???).next()).consumer.onCompleted();
      }
      this.child.onCompleted();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    synchronized (this.guard)
    {
      if (this.done) {
        return;
      }
      this.done = true;
      ArrayList localArrayList = new ArrayList(this.chunks);
      this.chunks.clear();
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext()) {
        ((OperatorWindowWithTime.CountedSerializedSubject)((Iterator)???).next()).consumer.onError(paramThrowable);
      }
      this.child.onError(paramThrowable);
      return;
    }
    for (;;)
    {
      throw paramThrowable;
    }
  }
  
  public void onNext(T paramT)
  {
    synchronized (this.guard)
    {
      if (this.done) {
        return;
      }
      Object localObject2 = new ArrayList(this.chunks);
      Iterator localIterator = this.chunks.iterator();
      while (localIterator.hasNext())
      {
        OperatorWindowWithTime.CountedSerializedSubject localCountedSerializedSubject = (OperatorWindowWithTime.CountedSerializedSubject)localIterator.next();
        int i = localCountedSerializedSubject.count + 1;
        localCountedSerializedSubject.count = i;
        if (i == this.this$0.size) {
          localIterator.remove();
        }
      }
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (OperatorWindowWithTime.CountedSerializedSubject)((Iterator)???).next();
        ((OperatorWindowWithTime.CountedSerializedSubject)localObject2).consumer.onNext(paramT);
        if (((OperatorWindowWithTime.CountedSerializedSubject)localObject2).count == this.this$0.size) {
          ((OperatorWindowWithTime.CountedSerializedSubject)localObject2).consumer.onCompleted();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramT;
    }
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
  
  void scheduleChunk()
  {
    this.worker.schedulePeriodically(new OperatorWindowWithTime.InexactSubscriber.1(this), this.this$0.timeshift, this.this$0.timeshift, this.this$0.unit);
  }
  
  void startNewChunk()
  {
    OperatorWindowWithTime.CountedSerializedSubject localCountedSerializedSubject = createCountedSerializedSubject();
    synchronized (this.guard)
    {
      if (this.done) {
        return;
      }
      this.chunks.add(localCountedSerializedSubject);
      try
      {
        this.child.onNext(localCountedSerializedSubject.producer);
        this.worker.schedule(new OperatorWindowWithTime.InexactSubscriber.2(this, localCountedSerializedSubject), this.this$0.timespan, this.this$0.unit);
        return;
      }
      catch (Throwable localThrowable)
      {
        onError(localThrowable);
        return;
      }
    }
  }
  
  void terminateChunk(OperatorWindowWithTime.CountedSerializedSubject<T> paramCountedSerializedSubject)
  {
    int i;
    synchronized (this.guard)
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
      } while ((OperatorWindowWithTime.CountedSerializedSubject)localIterator.next() != paramCountedSerializedSubject);
      i = 1;
      localIterator.remove();
      if (i != 0) {
        paramCountedSerializedSubject.consumer.onCompleted();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.InexactSubscriber
 * JD-Core Version:    0.7.0.1
 */