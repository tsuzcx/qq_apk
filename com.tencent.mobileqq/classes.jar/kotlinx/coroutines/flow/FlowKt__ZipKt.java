package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"combine", "Lkotlinx/coroutines/flow/Flow;", "R", "T", "flows", "", "transform", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "T1", "T2", "T3", "T4", "T5", "flow", "flow2", "flow3", "flow4", "flow5", "Lkotlin/Function6;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "a", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "combineTransform", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function7;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function7;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "flowCombine", "flowCombineTransform", "zip", "other", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ZipKt
{
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, R> Flow<R> combine(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> arg2) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, R> Flow<R> combine(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Flow<? extends T3> arg2, @BuilderInference @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> arg3) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, T4, R> Flow<R> combine(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Flow<? extends T3> arg2, @NotNull Flow<? extends T4> arg3, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> arg4) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Flow<? extends T3> arg2, @NotNull Flow<? extends T4> arg3, @NotNull Flow<? extends T5> arg4, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> arg5) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> arg2) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Flow<? extends T3> arg2, @BuilderInference @NotNull Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> arg3) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Flow<? extends T3> arg2, @NotNull Flow<? extends T4> arg3, @BuilderInference @NotNull Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> arg4) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Flow<? extends T3> arg2, @NotNull Flow<? extends T4> arg3, @NotNull Flow<? extends T5> arg4, @BuilderInference @NotNull Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> arg5) {}
  
  @JvmName(name="flowCombine")
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, R> Flow<R> flowCombine(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> arg2) {}
  
  @JvmName(name="flowCombineTransform")
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, R> Flow<R> flowCombineTransform(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> arg2) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T1, T2, R> Flow<R> zip(@NotNull Flow<? extends T1> arg0, @NotNull Flow<? extends T2> arg1, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> arg2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ZipKt
 * JD-Core Version:    0.7.0.1
 */