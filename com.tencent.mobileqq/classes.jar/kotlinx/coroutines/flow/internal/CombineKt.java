package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getNull", "Lkotlinx/coroutines/internal/Symbol;", "zipImpl", "Lkotlinx/coroutines/flow/Flow;", "R", "T1", "T2", "flow", "flow2", "transform", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "asChannel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "asFairChannel", "combineInternal", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "flows", "", "arrayFactory", "Lkotlin/Function0;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;[Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "combineTransformInternal", "first", "second", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "a", "b", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceive", "Lkotlinx/coroutines/selects/SelectBuilder;", "isClosed", "", "channel", "onClosed", "Lkotlin/Function2;", "value", "(Lkotlinx/coroutines/selects/SelectBuilder;ZLkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class CombineKt
{
  private static final ReceiveChannel<Object> asChannel(@NotNull CoroutineScope paramCoroutineScope, Flow<?> paramFlow)
  {
    return ProduceKt.produce$default(paramCoroutineScope, null, 0, (Function2)new CombineKt.asChannel.1(paramFlow, null), 3, null);
  }
  
  private static final ReceiveChannel<Object> asFairChannel(@NotNull CoroutineScope paramCoroutineScope, Flow<?> paramFlow)
  {
    return ProduceKt.produce$default(paramCoroutineScope, null, 0, (Function2)new CombineKt.asFairChannel.1(paramFlow, null), 3, null);
  }
  
  @PublishedApi
  @Nullable
  public static final <R, T> Object combineInternal(@NotNull FlowCollector<? super R> paramFlowCollector, @NotNull Flow<? extends T>[] paramArrayOfFlow, @NotNull Function0<T[]> paramFunction0, @NotNull Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> paramFunction3, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramFlowCollector = CoroutineScopeKt.coroutineScope((Function2)new CombineKt.combineInternal.2(paramFlowCollector, paramArrayOfFlow, paramFunction0, paramFunction3, null), paramContinuation);
    if (paramFlowCollector == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramFlowCollector;
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public static final <T1, T2, R> Object combineTransformInternal(@NotNull FlowCollector<? super R> paramFlowCollector, @NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> paramFunction4, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramFlowCollector = CoroutineScopeKt.coroutineScope((Function2)new CombineKt.combineTransformInternal.2(paramFlowCollector, paramFlow, paramFlow1, paramFunction4, null), paramContinuation);
    if (paramFlowCollector == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramFlowCollector;
    }
    return Unit.INSTANCE;
  }
  
  @NotNull
  public static final Symbol getNull()
  {
    return NullSurrogateKt.NULL;
  }
  
  private static final void onReceive(@NotNull SelectBuilder<? super Unit> paramSelectBuilder, boolean paramBoolean, ReceiveChannel<? extends Object> paramReceiveChannel, Function0<Unit> paramFunction0, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    if (paramBoolean) {
      return;
    }
    paramSelectBuilder.invoke(paramReceiveChannel.getOnReceiveOrNull(), (Function2)new CombineKt.onReceive.1(paramFunction0, paramFunction2, null));
  }
  
  @NotNull
  public static final <T1, T2, R> Flow<R> zipImpl(@NotNull Flow<? extends T1> paramFlow, @NotNull Flow<? extends T2> paramFlow1, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> paramFunction3)
  {
    return (Flow)new CombineKt.zipImpl..inlined.unsafeFlow.1(paramFlow, paramFlow1, paramFunction3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.CombineKt
 * JD-Core Version:    0.7.0.1
 */