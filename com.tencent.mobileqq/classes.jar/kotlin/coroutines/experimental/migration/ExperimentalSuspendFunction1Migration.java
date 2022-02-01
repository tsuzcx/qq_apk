package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/migration/ExperimentalSuspendFunction1Migration;", "T1", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "", "function", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;)V", "getFunction", "()Lkotlin/jvm/functions/Function2;", "invoke", "t1", "continuation", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
final class ExperimentalSuspendFunction1Migration<T1, R>
  implements Function2<T1, kotlin.coroutines.experimental.Continuation<? super R>, Object>
{
  @NotNull
  private final Function2<T1, kotlin.coroutines.Continuation<? super R>, Object> function;
  
  public ExperimentalSuspendFunction1Migration(@NotNull Function2<? super T1, ? super kotlin.coroutines.Continuation<? super R>, ? extends Object> paramFunction2)
  {
    this.function = paramFunction2;
  }
  
  @NotNull
  public final Function2<T1, kotlin.coroutines.Continuation<? super R>, Object> getFunction()
  {
    return this.function;
  }
  
  @Nullable
  public Object invoke(T1 paramT1, @NotNull kotlin.coroutines.experimental.Continuation<? super R> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "continuation");
    return this.function.invoke(paramT1, CoroutinesMigrationKt.toContinuation(paramContinuation));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.experimental.migration.ExperimentalSuspendFunction1Migration
 * JD-Core Version:    0.7.0.1
 */