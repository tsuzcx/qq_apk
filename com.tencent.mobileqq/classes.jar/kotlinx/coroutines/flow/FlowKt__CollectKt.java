package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"collect", "", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectIndexed", "Lkotlin/Function3;", "", "index", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectLatest", "emitAll", "Lkotlinx/coroutines/flow/FlowCollector;", "flow", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchIn", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__CollectKt
{
  @Nullable
  public static final Object collect(@NotNull Flow<?> arg0, @NotNull Continuation<? super Unit> arg1) {}
  
  @Nullable
  public static final <T> Object collect(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> arg1, @NotNull Continuation<? super Unit> arg2) {}
  
  @Nullable
  private static final Object collect$$forInline(@NotNull Flow arg0, @NotNull Function2 arg1, @NotNull Continuation arg2) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object collectIndexed(@NotNull Flow<? extends T> arg0, @NotNull Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> arg1, @NotNull Continuation<? super Unit> arg2) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  private static final Object collectIndexed$$forInline(@NotNull Flow arg0, @NotNull Function3 arg1, @NotNull Continuation arg2) {}
  
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object collectLatest(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> arg1, @NotNull Continuation<? super Unit> arg2) {}
  
  @BuilderInference
  @ExperimentalCoroutinesApi
  @Nullable
  public static final <T> Object emitAll(@NotNull FlowCollector<? super T> arg0, @NotNull Flow<? extends T> arg1, @NotNull Continuation<? super Unit> arg2) {}
  
  @BuilderInference
  @ExperimentalCoroutinesApi
  @Nullable
  private static final Object emitAll$$forInline(@NotNull FlowCollector arg0, @NotNull Flow arg1, @NotNull Continuation arg2) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Job launchIn(@NotNull Flow<? extends T> arg0, @NotNull CoroutineScope arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__CollectKt
 * JD-Core Version:    0.7.0.1
 */