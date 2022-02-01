package com.tencent.mobileqq.triton.internal.lifecycle;

import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "T", "", "initialValue", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "engineLock", "Ljava/util/concurrent/locks/Lock;", "(Ljava/lang/Object;Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;Ljava/util/concurrent/locks/Lock;)V", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "(Ljava/lang/Object;Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;)V", "(Ljava/lang/Object;)V", "observers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "getValue", "()Ljava/lang/Object;", "setValue", "Ljava/lang/Object;", "observe", "observer", "unobserve", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class ValueHolder<T>
{
  public static final ValueHolder.Companion Companion = new ValueHolder.Companion(null);
  private final Lock engineLock;
  private final LifeCycleOwner lifeCycleOwner;
  private final CopyOnWriteArrayList<Function1<T, Unit>> observers = new CopyOnWriteArrayList();
  private volatile T value;
  
  private ValueHolder(T paramT)
  {
    setValue(paramT);
    this.lifeCycleOwner = ((LifeCycleOwner)null);
    this.engineLock = ((Lock)null);
  }
  
  public ValueHolder(T paramT, @NotNull EngineContext paramEngineContext)
  {
    this(paramT, paramEngineContext.getLifeCycleOwner(), (Lock)paramEngineContext.getLock());
  }
  
  public ValueHolder(T paramT, @NotNull LifeCycleOwner paramLifeCycleOwner, @NotNull Lock paramLock)
  {
    setValue(paramT);
    this.lifeCycleOwner = paramLifeCycleOwner;
    this.engineLock = paramLock;
    paramLifeCycleOwner.observeLifeCycle((LifeCycle)new ValueHolder.1(this));
  }
  
  public final T getValue()
  {
    return this.value;
  }
  
  public final void observe(@NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "observer");
    Object localObject = this.lifeCycleOwner;
    if (localObject != null) {
      localObject = ((LifeCycleOwner)localObject).getEngineState();
    } else {
      localObject = null;
    }
    if (localObject == EngineState.DESTROYED) {
      return;
    }
    this.observers.addIfAbsent(paramFunction1);
    paramFunction1.invoke(this.value);
  }
  
  public final void setValue(T paramT)
  {
    this.value = paramT;
    Iterator localIterator;
    if (this.engineLock != null) {
      localIterator = ((Iterable)this.observers).iterator();
    }
    Object localObject1;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Object localObject2 = (Function1)localIterator.next();
      localObject1 = this.engineLock;
      ((Lock)localObject1).lock();
      try
      {
        ((Function1)localObject2).invoke(paramT);
        localObject2 = Unit.INSTANCE;
        ((Lock)localObject1).unlock();
      }
      finally
      {
        ((Lock)localObject1).unlock();
      }
    }
    while (((Iterator)localObject1).hasNext()) {
      ((Function1)((Iterator)localObject1).next()).invoke(paramT);
    }
  }
  
  public final void unobserve(@NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "observer");
    this.observers.remove(paramFunction1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder
 * JD-Core Version:    0.7.0.1
 */