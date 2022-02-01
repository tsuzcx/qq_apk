package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"filter", "Lkotlinx/coroutines/flow/Flow;", "T", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "filterIsInstance", "R", "filterNot", "filterNotNull", "map", "transform", "Lkotlin/ParameterName;", "name", "value", "mapNotNull", "onEach", "action", "", "scan", "initial", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "scanReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "withIndex", "Lkotlin/collections/IndexedValue;", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__TransformKt
{
  @NotNull
  public static final <T> Flow<T> filter(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> arg1) {}
  
  @NotNull
  public static final <T> Flow<T> filterNot(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> arg1) {}
  
  @NotNull
  public static final <T> Flow<T> filterNotNull(@NotNull Flow<? extends T> arg0) {}
  
  @NotNull
  public static final <T, R> Flow<R> map(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> arg1) {}
  
  @NotNull
  public static final <T, R> Flow<R> mapNotNull(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> arg1) {}
  
  @NotNull
  public static final <T> Flow<T> onEach(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> arg1) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T, R> Flow<R> scan(@NotNull Flow<? extends T> arg0, R arg1, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> arg2) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> scanReduce(@NotNull Flow<? extends T> arg0, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> arg1) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<IndexedValue<T>> withIndex(@NotNull Flow<? extends T> arg0) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt
 * JD-Core Version:    0.7.0.1
 */