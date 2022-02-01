package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"first", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fold", "R", "initial", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "acc", "value", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reduce", "S", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "single", "singleOrNull", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ReduceKt
{
  @Nullable
  public static final <T> Object first(@NotNull Flow<? extends T> arg0, @NotNull Continuation<? super T> arg1) {}
  
  @Nullable
  public static final <T> Object first(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> arg1, @NotNull Continuation<? super T> arg2) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T, R> Object fold(@NotNull Flow<? extends T> arg0, R arg1, @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> arg2, @NotNull Continuation<? super R> arg3) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  private static final Object fold$$forInline(@NotNull Flow arg0, Object arg1, @NotNull Function3 arg2, @NotNull Continuation arg3) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <S, T extends S> Object reduce(@NotNull Flow<? extends T> arg0, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> arg1, @NotNull Continuation<? super S> arg2) {}
  
  @Nullable
  public static final <T> Object single(@NotNull Flow<? extends T> arg0, @NotNull Continuation<? super T> arg1) {}
  
  @Nullable
  public static final <T> Object singleOrNull(@NotNull Flow<? extends T> arg0, @NotNull Continuation<? super T> arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ReduceKt
 * JD-Core Version:    0.7.0.1
 */