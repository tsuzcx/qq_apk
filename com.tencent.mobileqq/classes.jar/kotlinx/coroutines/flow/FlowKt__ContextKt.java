package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"checkFlowContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "checkFlowContext$FlowKt__ContextKt", "buffer", "Lkotlinx/coroutines/flow/Flow;", "T", "capacity", "", "conflate", "flowOn", "flowWith", "R", "flowContext", "bufferSize", "builder", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ContextKt
{
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> buffer(@NotNull Flow<? extends T> arg0, int arg1) {}
  
  private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext arg0) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> conflate(@NotNull Flow<? extends T> arg0) {}
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> flowOn(@NotNull Flow<? extends T> arg0, @NotNull CoroutineContext arg1) {}
  
  @Deprecated(level=DeprecationLevel.ERROR, message="flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
  @FlowPreview
  @NotNull
  public static final <T, R> Flow<R> flowWith(@NotNull Flow<? extends T> arg0, @NotNull CoroutineContext arg1, int arg2, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> arg3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ContextKt
 * JD-Core Version:    0.7.0.1
 */