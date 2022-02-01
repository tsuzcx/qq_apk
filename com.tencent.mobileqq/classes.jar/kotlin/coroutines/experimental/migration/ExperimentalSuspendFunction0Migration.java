package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/migration/ExperimentalSuspendFunction0Migration;", "R", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "", "function", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)V", "getFunction", "()Lkotlin/jvm/functions/Function1;", "invoke", "continuation", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
final class ExperimentalSuspendFunction0Migration<R>
  implements Function1<kotlin.coroutines.experimental.Continuation<? super R>, Object>
{
  @NotNull
  private final Function1<kotlin.coroutines.Continuation<? super R>, Object> function;
  
  public ExperimentalSuspendFunction0Migration(@NotNull Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends Object> paramFunction1)
  {
    this.function = paramFunction1;
  }
  
  @NotNull
  public final Function1<kotlin.coroutines.Continuation<? super R>, Object> getFunction()
  {
    return this.function;
  }
  
  @Nullable
  public Object invoke(@NotNull kotlin.coroutines.experimental.Continuation<? super R> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    return this.function.invoke(CoroutinesMigrationKt.toContinuation(paramContinuation));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.experimental.migration.ExperimentalSuspendFunction0Migration
 * JD-Core Version:    0.7.0.1
 */