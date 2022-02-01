package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isActive", "", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "DisposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "block", "Lkotlin/Function0;", "", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "Job0", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "disposeOnCompletion", "handle", "ensureActive", "orCancellation", "job", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/JobKt")
final class JobKt__JobKt
{
  @InternalCoroutinesApi
  @NotNull
  public static final DisposableHandle DisposableHandle(@NotNull Function0<Unit> arg0) {}
  
  @NotNull
  public static final CompletableJob Job(@Nullable Job arg0) {}
  
  public static final void cancel(@NotNull CoroutineContext arg0, @Nullable CancellationException arg1) {}
  
  public static final void cancel(@NotNull Job arg0, @NotNull String arg1, @Nullable Throwable arg2) {}
  
  @Nullable
  public static final Object cancelAndJoin(@NotNull Job arg0, @NotNull Continuation<? super Unit> arg1) {}
  
  public static final void cancelChildren(@NotNull CoroutineContext arg0, @Nullable CancellationException arg1) {}
  
  public static final void cancelChildren(@NotNull Job arg0, @Nullable CancellationException arg1) {}
  
  @NotNull
  public static final DisposableHandle disposeOnCompletion(@NotNull Job arg0, @NotNull DisposableHandle arg1) {}
  
  public static final void ensureActive(@NotNull CoroutineContext arg0) {}
  
  public static final void ensureActive(@NotNull Job arg0) {}
  
  public static final boolean isActive(@NotNull CoroutineContext arg0) {}
  
  private static final Throwable orCancellation$JobKt__JobKt(@Nullable Throwable arg0, Job arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobKt__JobKt
 * JD-Core Version:    0.7.0.1
 */