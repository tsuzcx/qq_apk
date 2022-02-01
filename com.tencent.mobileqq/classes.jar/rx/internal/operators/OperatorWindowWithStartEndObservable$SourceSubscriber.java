package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;

final class OperatorWindowWithStartEndObservable$SourceSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super Observable<T>> child;
  final List<OperatorWindowWithStartEndObservable.SerializedSubject<T>> chunks;
  final CompositeSubscription csub;
  boolean done;
  final Object guard;
  
  public OperatorWindowWithStartEndObservable$SourceSubscriber(Subscriber<? super Observable<T>> paramSubscriber, CompositeSubscription paramCompositeSubscription)
  {
    this.child = new SerializedSubscriber(paramCompositeSubscription);
    this.guard = new Object();
    this.chunks = new LinkedList();
    Object localObject;
    this.csub = localObject;
  }
  
  void beginWindow(U paramU)
  {
    Object localObject1 = createSerializedSubject();
    synchronized (this.guard)
    {
      if (this.done) {
        return;
      }
      this.chunks.add(localObject1);
      this.child.onNext(((OperatorWindowWithStartEndObservable.SerializedSubject)localObject1).producer);
      try
      {
        paramU = (Observable)this.this$0.windowClosingSelector.call(paramU);
        localObject1 = new OperatorWindowWithStartEndObservable.SourceSubscriber.1(this, (OperatorWindowWithStartEndObservable.SerializedSubject)localObject1);
        this.csub.add((Subscription)localObject1);
        paramU.unsafeSubscribe((Subscriber)localObject1);
        return;
      }
      catch (Throwable paramU)
      {
        onError(paramU);
        return;
      }
    }
  }
  
  OperatorWindowWithStartEndObservable.SerializedSubject<T> createSerializedSubject()
  {
    UnicastSubject localUnicastSubject = UnicastSubject.create();
    return new OperatorWindowWithStartEndObservable.SerializedSubject(localUnicastSubject, localUnicastSubject);
  }
  
  void endWindow(OperatorWindowWithStartEndObservable.SerializedSubject<T> paramSerializedSubject)
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
      } while ((OperatorWindowWithStartEndObservable.SerializedSubject)localIterator.next() != paramSerializedSubject);
      i = 1;
      localIterator.remove();
      if (i != 0) {
        paramSerializedSubject.consumer.onCompleted();
      }
      return;
    }
  }
  
  public void onCompleted()
  {
    try
    {
      synchronized (this.guard)
      {
        if (this.done)
        {
          this.csub.unsubscribe();
          return;
        }
        this.done = true;
        ArrayList localArrayList = new ArrayList(this.chunks);
        this.chunks.clear();
        ??? = localArrayList.iterator();
        while (((Iterator)???).hasNext()) {
          ((OperatorWindowWithStartEndObservable.SerializedSubject)((Iterator)???).next()).consumer.onCompleted();
        }
        this.child.onCompleted();
        this.csub.unsubscribe();
        return;
      }
      throw localObject2;
    }
    finally
    {
      this.csub.unsubscribe();
    }
    for (;;) {}
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      synchronized (this.guard)
      {
        if (this.done)
        {
          this.csub.unsubscribe();
          return;
        }
        this.done = true;
        ArrayList localArrayList = new ArrayList(this.chunks);
        this.chunks.clear();
        ??? = localArrayList.iterator();
        while (((Iterator)???).hasNext()) {
          ((OperatorWindowWithStartEndObservable.SerializedSubject)((Iterator)???).next()).consumer.onError(paramThrowable);
        }
        this.child.onError(paramThrowable);
        this.csub.unsubscribe();
        return;
      }
      throw paramThrowable;
    }
    finally
    {
      this.csub.unsubscribe();
    }
    for (;;) {}
  }
  
  public void onNext(T paramT)
  {
    synchronized (this.guard)
    {
      if (this.done) {
        return;
      }
      ArrayList localArrayList = new ArrayList(this.chunks);
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext()) {
        ((OperatorWindowWithStartEndObservable.SerializedSubject)((Iterator)???).next()).consumer.onNext(paramT);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber
 * JD-Core Version:    0.7.0.1
 */