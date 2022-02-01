package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ThreadContextKt
{
  private static final Symbol ZERO = new Symbol("ZERO");
  private static final Function2<Object, CoroutineContext.Element, Object> countAll = (Function2)ThreadContextKt.countAll.1.INSTANCE;
  private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> findOne = (Function2)ThreadContextKt.findOne.1.INSTANCE;
  private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> restoreState = (Function2)ThreadContextKt.restoreState.1.INSTANCE;
  private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> updateState = (Function2)ThreadContextKt.updateState.1.INSTANCE;
  
  public static final void restoreThreadContext(@NotNull CoroutineContext paramCoroutineContext, @Nullable Object paramObject)
  {
    if (paramObject == ZERO) {
      return;
    }
    if ((paramObject instanceof ThreadState))
    {
      ((ThreadState)paramObject).start();
      paramCoroutineContext.fold(paramObject, restoreState);
      return;
    }
    Object localObject = paramCoroutineContext.fold(null, findOne);
    if (localObject != null)
    {
      ((ThreadContextElement)localObject).restoreThreadContext(paramCoroutineContext, paramObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
  }
  
  @NotNull
  public static final Object threadContextElements(@NotNull CoroutineContext paramCoroutineContext)
  {
    paramCoroutineContext = paramCoroutineContext.fold(Integer.valueOf(0), countAll);
    if (paramCoroutineContext == null) {
      Intrinsics.throwNpe();
    }
    return paramCoroutineContext;
  }
  
  @Nullable
  public static final Object updateThreadContext(@NotNull CoroutineContext paramCoroutineContext, @Nullable Object paramObject)
  {
    if (paramObject == null) {
      paramObject = threadContextElements(paramCoroutineContext);
    }
    if (paramObject == Integer.valueOf(0)) {
      return ZERO;
    }
    if ((paramObject instanceof Integer)) {
      return paramCoroutineContext.fold(new ThreadState(paramCoroutineContext, ((Number)paramObject).intValue()), updateState);
    }
    if (paramObject != null) {
      return ((ThreadContextElement)paramObject).updateThreadContext(paramCoroutineContext);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ThreadContextKt
 * JD-Core Version:    0.7.0.1
 */