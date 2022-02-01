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
    int i = this.state;
    if (i != 4)
    {
      if (i != 5)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unexpected state of the iterator: ");
        localStringBuilder.append(this.state);
        return (Throwable)new IllegalStateException(localStringBuilder.toString());
      }
      return (Throwable)new IllegalStateException("Iterator has failed.");
    }
    return (Throwable)new NoSuchElementException();
  }
  
  private final T nextNotReady()
  {
    if (hasNext()) {
      return next();
    }
    throw ((Throwable)new NoSuchElementException());
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
      int i = this.state;
      if (i != 0)
      {
        if (i != 1)
        {
          if ((i != 2) && (i != 3))
          {
            if (i == 4) {
              return false;
            }
            throw exceptionalState();
          }
          return true;
        }
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
      }
      this.state = 5;
      Object localObject = this.nextStep;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      this.nextStep = ((Continuation)null);
      ((Continuation)localObject).resume(Unit.INSTANCE);
    }
  }
  
  public T next()
  {
    int i = this.state;
    if ((i != 0) && (i != 1))
    {
      if (i != 2)
      {
        if (i == 3)
        {
          this.state = 0;
          localObject = this.nextValue;
          this.nextValue = null;
          return localObject;
        }
        throw exceptionalState();
      }
      this.state = 1;
      Object localObject = this.nextIterator;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return ((Iterator)localObject).next();
    }
    return nextNotReady();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.experimental.SequenceBuilderIterator
 * JD-Core Version:    0.7.0.1
 */