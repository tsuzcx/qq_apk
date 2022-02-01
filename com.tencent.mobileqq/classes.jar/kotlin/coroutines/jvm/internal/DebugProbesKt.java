package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"probeCoroutineCreated", "Lkotlin/coroutines/Continuation;", "T", "completion", "probeCoroutineResumed", "", "frame", "probeCoroutineSuspended", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class DebugProbesKt
{
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T> Continuation<T> probeCoroutineCreated(@NotNull Continuation<? super T> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    return paramContinuation;
  }
  
  @SinceKotlin(version="1.3")
  public static final void probeCoroutineResumed(@NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "frame");
  }
  
  @SinceKotlin(version="1.3")
  public static final void probeCoroutineSuspended(@NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "frame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.DebugProbesKt
 * JD-Core Version:    0.7.0.1
 */