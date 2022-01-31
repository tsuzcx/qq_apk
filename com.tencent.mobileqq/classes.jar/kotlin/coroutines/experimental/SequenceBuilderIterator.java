package kotlin.coroutines.experimental;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/SequenceBuilderIterator;", "T", "Lkotlin/coroutines/experimental/SequenceBuilder;", "", "Lkotlin/coroutines/experimental/Continuation;", "", "()V", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/experimental/Continuation;", "setNextStep", "(Lkotlin/coroutines/experimental/Continuation;)V", "nextValue", "Ljava/lang/Object;", "state", "", "Lkotlin/coroutines/experimental/State;", "exceptionalState", "", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "resume", "value", "(Lkotlin/Unit;)V", "resumeWithException", "exception", "yield", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
final class SequenceBuilderIterator<T>
  extends SequenceBuilder<T>
  implements Iterator<T>, Continuation<Unit>, KMappedMarker
{
  private Iterator<? extends T> nextIterator;
  @Nullable
  private Continuation<? super Unit> nextStep;
  private T nextValue;
  private int state;
  
  private final Throwable exceptionalState()
  {
    switch (this.state)
    {
    default: 
      return (Throwable)new IllegalStateException("Unexpected state of the iterator: " + this.state);
    case 4: 
      return (Throwable)new NoSuchElementException();
    }
    return (Throwable)new IllegalStateException("Iterator has failed.");
  }
  
  private final T nextNotReady()
  {
    if (!hasNext()) {
      throw ((Throwable)new NoSuchElementException());
    }
    return next();
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
  }
  
  @Nullable
  public final Continuation<Unit> getNextStep()
  {
    return this.nextStep;
  }
  
  public boolean hasNext()
  {
    for (;;)
    {
      Object localObject;
      switch (this.state)
      {
      default: 
        throw exceptionalState();
      case 1: 
        localObject = this.nextIterator;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        if (((Iterator)localObject).hasNext())
        {
          this.state = 2;
          return true;
        }
        this.nextIterator = ((Iterator)null);
      case 0: 
        this.state = 5;
        localObject = this.nextStep;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        this.nextStep = ((Continuation)null);
        ((Continuation)localObject).resume(Unit.INSTANCE);
      }
    }
    return false;
    return true;
  }
  
  public T next()
  {
    switch (this.state)
    {
    default: 
      throw exceptionalState();
    case 0: 
    case 1: 
      return nextNotReady();
    case 2: 
      this.state = 1;
      localObject = this.nextIterator;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return ((Iterator)localObject).next();
    }
    this.state = 0;
    Object localObject = this.nextValue;
    this.nextValue = null;
    return localObject;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void resume(@NotNull Unit paramUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramUnit, "value");
    this.state = 4;
  }
  
  public void resumeWithException(@NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    throw paramThrowable;
  }
  
  public final void setNextStep(@Nullable Continuation<? super Unit> paramContinuation)
  {
    this.nextStep = paramContinuation;
  }
  
  @Nullable
  public Object yield(T paramT, @NotNull Continuation<? super Unit> paramContinuation)
  {
    this.nextValue = paramT;
    this.state = 3;
    setNextStep(CoroutineIntrinsics.normalizeContinuation(paramContinuation));
    return IntrinsicsKt.getCOROUTINE_SUSPENDED();
  }
  
  @Nullable
  public Object yieldAll(@NotNull Iterator<? extends T> paramIterator, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if (!paramIterator.hasNext()) {
      return Unit.INSTANCE;
    }
    this.nextIterator = paramIterator;
    this.state = 2;
    setNextStep(CoroutineIntrinsics.normalizeContinuation(paramContinuation));
    return IntrinsicsKt.getCOROUTINE_SUSPENDED();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.experimental.SequenceBuilderIterator
 * JD-Core Version:    0.7.0.1
 */