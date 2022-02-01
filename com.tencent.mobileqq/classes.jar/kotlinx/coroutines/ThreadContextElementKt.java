package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.ThreadLocalElement;
import kotlinx.coroutines.internal.ThreadLocalKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asContextElement", "Lkotlinx/coroutines/ThreadContextElement;", "T", "Ljava/lang/ThreadLocal;", "value", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/ThreadContextElement;", "ensurePresent", "", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPresent", "", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ThreadContextElementKt
{
  @NotNull
  public static final <T> ThreadContextElement<T> asContextElement(@NotNull ThreadLocal<T> paramThreadLocal, T paramT)
  {
    return (ThreadContextElement)new ThreadLocalElement(paramT, paramThreadLocal);
  }
  
  @Nullable
  public static final Object ensurePresent(@NotNull ThreadLocal<?> paramThreadLocal, @NotNull Continuation<? super Unit> paramContinuation)
  {
    boolean bool;
    if (paramContinuation.getContext().get((CoroutineContext.Key)new ThreadLocalKey(paramThreadLocal)) != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (Boxing.boxBoolean(bool).booleanValue()) {
      return Unit.INSTANCE;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ThreadLocal ");
    localStringBuilder.append(paramThreadLocal);
    localStringBuilder.append(" is missing from context ");
    localStringBuilder.append(paramContinuation.getContext());
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  @Nullable
  private static final Object ensurePresent$$forInline(@NotNull ThreadLocal paramThreadLocal, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(3);
    throw new NullPointerException();
  }
  
  @Nullable
  public static final Object isPresent(@NotNull ThreadLocal<?> paramThreadLocal, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    boolean bool;
    if (paramContinuation.getContext().get((CoroutineContext.Key)new ThreadLocalKey(paramThreadLocal)) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return Boxing.boxBoolean(bool);
  }
  
  @Nullable
  private static final Object isPresent$$forInline(@NotNull ThreadLocal paramThreadLocal, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(3);
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ThreadContextElementKt
 * JD-Core Version:    0.7.0.1
 */