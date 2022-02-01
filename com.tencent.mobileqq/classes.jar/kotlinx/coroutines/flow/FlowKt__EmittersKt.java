package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"invokeSafely", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "invokeSafely$FlowKt__EmittersKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCompletion", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "onStart", "transform", "R", "value", "unsafeTransform", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__EmittersKt
{
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> onCompletion(@NotNull Flow<? extends T> arg0, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> arg1) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> onStart(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> arg1) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T, R> Flow<R> transform(@NotNull Flow<? extends T> arg0, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> arg1) {}
  
  @PublishedApi
  @NotNull
  public static final <T, R> Flow<R> unsafeTransform(@NotNull Flow<? extends T> arg0, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__EmittersKt
 * JD-Core Version:    0.7.0.1
 */