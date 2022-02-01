package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"catch", "Lkotlinx/coroutines/flow/Flow;", "T", "action", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "catchImpl", "collector", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCancellationCause", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "isCancellationCause$FlowKt__ErrorsKt", "isSameExceptionAs", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "onErrorCollect", "fallback", "predicate", "Lkotlin/Function1;", "retry", "retries", "", "", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "ExceptionPredicate", "Lkotlin/Deprecated;", "level", "Lkotlin/DeprecationLevel;", "ERROR", "message", "Use (Throwable) -> Boolean functional type", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "(Throwable) -> Boolean", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ErrorsKt
{
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> jdMethod_catch(@NotNull Flow<? extends T> arg0, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> arg1) {}
  
  @Nullable
  public static final <T> Object catchImpl(@NotNull Flow<? extends T> arg0, @NotNull FlowCollector<? super T> arg1, @NotNull Continuation<? super Throwable> arg2) {}
  
  private static final boolean isCancellationCause$FlowKt__ErrorsKt(@NotNull Throwable arg0, CoroutineContext arg1) {}
  
  private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(@NotNull Throwable arg0, Throwable arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith=@ReplaceWith(expression="catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports={}))
  @NotNull
  public static final <T> Flow<T> onErrorCollect(@NotNull Flow<? extends T> arg0, @NotNull Flow<? extends T> arg1, @NotNull Function1<? super Throwable, Boolean> arg2) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> retry(@NotNull Flow<? extends T> arg0, long arg1, @NotNull Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> arg3) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> retryWhen(@NotNull Flow<? extends T> arg0, @NotNull Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ErrorsKt
 * JD-Core Version:    0.7.0.1
 */