package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest;", "T", "R", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "transform", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "(Lkotlin/jvm/functions/Function3;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;I)V", "Lkotlin/jvm/functions/Function3;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flowCollect", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ChannelFlowTransformLatest<T, R>
  extends ChannelFlowOperator<T, R>
{
  private final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> transform;
  
  public ChannelFlowTransformLatest(@NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> paramFunction3, @NotNull Flow<? extends T> paramFlow, @NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    super(paramFlow, paramCoroutineContext, paramInt);
    this.transform = paramFunction3;
  }
  
  @NotNull
  protected ChannelFlow<R> create(@NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    return (ChannelFlow)new ChannelFlowTransformLatest(this.transform, this.flow, paramCoroutineContext, paramInt);
  }
  
  @Nullable
  protected Object flowCollect(@NotNull FlowCollector<? super R> paramFlowCollector, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if ((DebugKt.getASSERTIONS_ENABLED()) && (!Boxing.boxBoolean(paramFlowCollector instanceof SendingCollector).booleanValue())) {
      throw ((Throwable)new AssertionError());
    }
    paramFlowCollector = FlowCoroutineKt.flowScope((Function2)new ChannelFlowTransformLatest.flowCollect.3(this, paramFlowCollector, null), paramContinuation);
    if (paramFlowCollector == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramFlowCollector;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest
 * JD-Core Version:    0.7.0.1
 */