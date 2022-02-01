package kotlinx.coroutines.flow.internal;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"flowScope", "R", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scopedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "(Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "flowProduce", "Lkotlinx/coroutines/channels/ReceiveChannel;", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class FlowCoroutineKt
{
  @NotNull
  public static final <T> ReceiveChannel<T> flowProduce(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineContext paramCoroutineContext, int paramInt, @BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    Channel localChannel = ChannelKt.Channel(paramInt);
    paramCoroutineScope = new FlowProduceCoroutine(CoroutineContextKt.newCoroutineContext(paramCoroutineScope, paramCoroutineContext), localChannel);
    paramCoroutineScope.start(CoroutineStart.ATOMIC, paramCoroutineScope, paramFunction2);
    return (ReceiveChannel)paramCoroutineScope;
  }
  
  @Nullable
  public static final <R> Object flowScope(@BuilderInference @NotNull Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> paramFunction2, @NotNull Continuation<? super R> paramContinuation)
  {
    FlowCoroutine localFlowCoroutine = new FlowCoroutine(paramContinuation.getContext(), paramContinuation);
    paramFunction2 = UndispatchedKt.startUndispatchedOrReturn((ScopeCoroutine)localFlowCoroutine, localFlowCoroutine, paramFunction2);
    if (paramFunction2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramFunction2;
  }
  
  @NotNull
  public static final <R> Flow<R> scopedFlow(@BuilderInference @NotNull Function3<? super CoroutineScope, ? super FlowCollector<? super R>, ? super Continuation<? super Unit>, ? extends Object> paramFunction3)
  {
    return (Flow)new FlowCoroutineKt.scopedFlow..inlined.unsafeFlow.1(paramFunction3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.FlowCoroutineKt
 * JD-Core Version:    0.7.0.1
 */