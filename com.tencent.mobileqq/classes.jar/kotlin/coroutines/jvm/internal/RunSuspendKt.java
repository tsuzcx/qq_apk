package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"runSuspend", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class RunSuspendKt
{
  @SinceKotlin(version="1.3")
  public static final void runSuspend(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    RunSuspend localRunSuspend = new RunSuspend();
    ContinuationKt.startCoroutine(paramFunction1, (Continuation)localRunSuspend);
    localRunSuspend.await();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.RunSuspendKt
 * JD-Core Version:    0.7.0.1
 */