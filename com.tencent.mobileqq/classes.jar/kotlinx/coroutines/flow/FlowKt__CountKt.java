package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"count", "", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__CountKt
{
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object count(@NotNull Flow<? extends T> arg0, @NotNull Continuation<? super Integer> arg1) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object count(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> arg1, @NotNull Continuation<? super Integer> arg2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__CountKt
 * JD-Core Version:    0.7.0.1
 */