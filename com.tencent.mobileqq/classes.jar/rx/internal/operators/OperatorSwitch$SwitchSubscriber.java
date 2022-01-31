package rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.internal.producers.ProducerArbiter;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.SerialSubscription;

final class OperatorSwitch$SwitchSubscriber<T>
  extends Subscriber<Observable<? extends T>>
{
  final ProducerArbiter arbiter;
  final Subscriber<? super T> child;
  final boolean delayError;
  boolean emitting;
  Throwable error;
  long index;
  boolean innerActive;
  boolean mainDone;
  boolean missed;
  List<T> queue;
  final SerialSubscription ssub;
  
  OperatorSwitch$SwitchSubscriber(Subscriber<? super T> paramSubscriber, boolean paramBoolean)
  {
    this.child = paramSubscriber;
    this.arbiter = new ProducerArbiter();
    this.ssub = new SerialSubscription();
    this.delayError = paramBoolean;
  }
  
  void complete(long paramLong)
  {
    try
    {
      if (paramLong != this.index) {
        return;
      }
      this.innerActive = false;
      if (this.emitting)
      {
        this.missed = true;
        return;
      }
    }
    finally {}
    Throwable localThrowable = this.error;
    if (!this.mainDone) {
      return;
    }
    if (localThrowable != null)
    {
      this.child.onError(localThrowable);
      return;
    }
    this.child.onCompleted();
  }
  
  void emit(T paramT, long paramLong)
  {
    Object localObject;
    try
    {
      if (paramLong != this.index) {
        return;
      }
      if (this.emitting)
      {
        List localList = this.queue;
        localObject = localList;
        if (localList == null)
        {
          localObject = new ArrayList(4);
          this.queue = ((List)localObject);
        }
        ((List)localObject).add(paramT);
        this.missed = true;
        return;
      }
    }
    finally {}
    this.emitting = true;
    this.child.onNext(paramT);
    this.arbiter.produced(1L);
    while (!this.child.isUnsubscribed())
    {
      try
      {
        if (!this.missed)
        {
          this.emitting = false;
          return;
        }
      }
      finally {}
      paramT = this.error;
      boolean bool1 = this.mainDone;
      localObject = this.queue;
      boolean bool2 = this.innerActive;
      if ((!this.delayError) && (paramT != null))
      {
        this.child.onError(paramT);
        return;
      }
      if ((localObject == null) && (!bool2) && (bool1))
      {
        if (paramT != null)
        {
          this.child.onError(paramT);
          return;
        }
        this.child.onCompleted();
        return;
      }
      if (localObject != null)
      {
        paramT = ((List)localObject).iterator();
        int i = 0;
        while (paramT.hasNext())
        {
          localObject = paramT.next();
          if (this.child.isUnsubscribed()) {
            return;
          }
          this.child.onNext(localObject);
          i += 1;
        }
        this.arbiter.produced(i);
      }
    }
  }
  
  void error(Throwable paramThrowable, long paramLong)
  {
    int i = 0;
    try
    {
      if (paramLong != this.index) {
        break label80;
      }
      this.innerActive = false;
      paramThrowable = updateError(paramThrowable);
      if (this.emitting)
      {
        this.missed = true;
        return;
      }
      if ((this.delayError) && (!this.mainDone)) {
        return;
      }
    }
    finally {}
    this.emitting = true;
    for (;;)
    {
      if (i == 0) {
        break;
      }
      pluginError(paramThrowable);
      return;
      label80:
      i = 1;
    }
    this.child.onError(paramThrowable);
  }
  
  void init()
  {
    this.child.add(this.ssub);
    this.child.setProducer(new OperatorSwitch.SwitchSubscriber.1(this));
  }
  
  public void onCompleted()
  {
    try
    {
      this.mainDone = true;
      if (this.emitting)
      {
        this.missed = true;
        return;
      }
      if (this.innerActive) {
        return;
      }
    }
    finally {}
    this.emitting = true;
    Throwable localThrowable = this.error;
    if (localThrowable == null)
    {
      this.child.onCompleted();
      return;
    }
    this.child.onError(localThrowable);
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      paramThrowable = updateError(paramThrowable);
      this.mainDone = true;
      if (this.emitting)
      {
        this.missed = true;
        return;
      }
      if ((this.delayError) && (this.innerActive)) {
        return;
      }
    }
    finally {}
    this.emitting = true;
    this.child.onError(paramThrowable);
  }
  
  public void onNext(Observable<? extends T> paramObservable)
  {
    try
    {
      long l = this.index + 1L;
      this.index = l;
      OperatorSwitch.InnerSubscriber localInnerSubscriber = new OperatorSwitch.InnerSubscriber(l, this);
      this.innerActive = true;
      this.ssub.set(localInnerSubscriber);
      paramObservable.unsafeSubscribe(localInnerSubscriber);
      return;
    }
    finally {}
  }
  
  void pluginError(Throwable paramThrowable)
  {
    RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
  }
  
  Throwable updateError(Throwable paramThrowable)
  {
    Object localObject = this.error;
    if (localObject == null)
    {
      this.error = paramThrowable;
      return paramThrowable;
    }
    if ((localObject instanceof CompositeException))
    {
      localObject = new ArrayList(((CompositeException)localObject).getExceptions());
      ((List)localObject).add(paramThrowable);
      paramThrowable = new CompositeException((Collection)localObject);
      this.error = paramThrowable;
      return paramThrowable;
    }
    paramThrowable = new CompositeException(Arrays.asList(new Throwable[] { localObject, paramThrowable }));
    this.error = paramThrowable;
    return paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorSwitch.SwitchSubscriber
 * JD-Core Version:    0.7.0.1
 */