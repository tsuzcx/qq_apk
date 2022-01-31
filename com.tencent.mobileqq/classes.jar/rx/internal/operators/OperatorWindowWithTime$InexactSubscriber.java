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
      if (((Iterator)???).hasNext()) {
        ((OperatorWindowWithTime.CountedSerializedSubject)((Iterator)???).next()).consumer.onCompleted();
      }
    }
    this.child.onCompleted();
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
      if (((Iterator)???).hasNext()) {
        ((OperatorWindowWithTime.CountedSerializedSubject)((Iterator)???).next()).consumer.onError(paramThrowable);
      }
    }
    this.child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    Object localObject2;
    synchronized (this.guard)
    {
      if (this.done) {
        return;
      }
      localObject2 = new ArrayList(this.chunks);
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
    }
  }
  
  void terminateChunk(OperatorWindowWithTime.CountedSerializedSubject<T> paramCountedSerializedSubject)
  {
    for (;;)
    {
      synchronized (this.guard)
      {
        if (this.done) {
          return;
        }
        Iterator localIterator = this.chunks.iterator();
        if (localIterator.hasNext())
        {
          if ((OperatorWindowWithTime.CountedSerializedSubject)localIterator.next() != paramCountedSerializedSubject) {
            continue;
          }
          i = 1;
          localIterator.remove();
          if (i == 0) {
            break;
          }
          paramCountedSerializedSubject.consumer.onCompleted();
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.InexactSubscriber
 * JD-Core Version:    0.7.0.1
 */