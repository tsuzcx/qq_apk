package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"DEFAULT_CONCURRENCY", "", "DEFAULT_CONCURRENCY$annotations", "()V", "getDEFAULT_CONCURRENCY", "()I", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "", "DEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "merge", "Lkotlinx/coroutines/flow/Flow;", "T", "flows", "", "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "flatMapConcat", "R", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatMapLatest", "flatMapMerge", "concurrency", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flattenConcat", "flattenMerge", "mapLatest", "", "transformLatest", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__MergeKt
{
  private static final int DEFAULT_CONCURRENCY;
  
  @FlowPreview
  @NotNull
  public static final <T, R> Flow<R> flatMapConcat(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> arg1) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T, R> Flow<R> flatMapLatest(@NotNull Flow<? extends T> arg0, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> arg1) {}
  
  @FlowPreview
  @NotNull
  public static final <T, R> Flow<R> flatMapMerge(@NotNull Flow<? extends T> arg0, int arg1, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> arg2) {}
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> flattenConcat(@NotNull Flow<? extends Flow<? extends T>> arg0) {}
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> flattenMerge(@NotNull Flow<? extends Flow<? extends T>> arg0, int arg1) {}
  
  public static final int getDEFAULT_CONCURRENCY() {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T, R> Flow<R> mapLatest(@NotNull Flow<? extends T> arg0, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> arg1) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> merge(@NotNull Iterable<? extends Flow<? extends T>> arg0) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> merge(@NotNull Flow<? extends T>... arg0) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T, R> Flow<R> transformLatest(@NotNull Flow<? extends T> arg0, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__MergeKt
 * JD-Core Version:    0.7.0.1
 */