package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/SequenceBuilderIterator;", "T", "Lkotlin/sequences/SequenceScope;", "", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/Continuation;", "setNextStep", "(Lkotlin/coroutines/Continuation;)V", "nextValue", "Ljava/lang/Object;", "state", "", "Lkotlin/sequences/State;", "exceptionalState", "", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "yield", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class SequenceBuilderIterator<T>
  extends SequenceScope<T>
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
      Unit localUnit = Unit.INSTANCE;
      Result.Companion localCompanion = Result.Companion;
      ((Continuation)localObject).resumeWith(Result.constructor-impl(localUnit));
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
  
  public void resumeWith(@NotNull Object paramObject)
  {
    ResultKt.throwOnFailure(paramObject);
    this.state = 4;
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
    this.nextStep = paramContinuation;
    paramT = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (paramT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    if (paramT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramT;
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public Object yieldAll(@NotNull Iterator<? extends T> paramIterator, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if (!paramIterator.hasNext()) {
      return Unit.INSTANCE;
    }
    this.nextIterator = paramIterator;
    this.state = 2;
    this.nextStep = paramContinuation;
    paramIterator = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (paramIterator == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    if (paramIterator == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramIterator;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SequenceBuilderIterator
 * JD-Core Version:    0.7.0.1
 */