package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"probeCoroutineCreated", "Lkotlin/coroutines/Continuation;", "T", "completion", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ProbesSupportKt
{
  @NotNull
  public static final <T> Continuation<T> probeCoroutineCreated(@NotNull Continuation<? super T> paramContinuation)
  {
    return DebugProbesKt.probeCoroutineCreated(paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ProbesSupportKt
 * JD-Core Version:    0.7.0.1
 */