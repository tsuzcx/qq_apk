package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"drop", "Lkotlinx/coroutines/flow/Flow;", "T", "count", "", "dropWhile", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "emitAbort", "", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "emitAbort$FlowKt__LimitKt", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "take", "takeWhile", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__LimitKt
{
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> drop(@NotNull Flow<? extends T> arg0, int arg1) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> dropWhile(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> arg1) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> take(@NotNull Flow<? extends T> arg0, int arg1) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> takeWhile(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__LimitKt
 * JD-Core Version:    0.7.0.1
 */