package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f="Delay.kt", i={0, 0, 0, 0, 0}, l={137}, m="invokeSuspend", n={"$this$scopedFlow", "downstream", "values", "lastValue", "ticker"}, s={"L$0", "L$1", "L$2", "L$3", "L$4"})
final class FlowKt__DelayKt$sample$2
  extends SuspendLambda
  implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  int label;
  private CoroutineScope p$;
  private FlowCollector p$0;
  
  FlowKt__DelayKt$sample$2(Flow paramFlow, long paramLong, Continuation paramContinuation)
  {
    super(3, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull CoroutineScope paramCoroutineScope, @NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramContinuation = new 2(this.$this_sample, this.$periodMillis, paramContinuation);
    paramContinuation.p$ = paramCoroutineScope;
    paramContinuation.p$0 = paramFlowCollector;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return ((2)create((CoroutineScope)paramObject1, (FlowCollector)paramObject2, (Continuation)paramObject3)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject2;
    Object localObject3;
    ReceiveChannel localReceiveChannel;
    FlowCollector localFlowCollector;
    CoroutineScope localCoroutineScope;
    Object localObject4;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject2 = (2)this.L$5;
        localObject3 = (ReceiveChannel)this.L$4;
        localObject2 = (Ref.ObjectRef)this.L$3;
        localReceiveChannel = (ReceiveChannel)this.L$2;
        localFlowCollector = (FlowCollector)this.L$1;
        localCoroutineScope = (CoroutineScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
        localObject1 = localObject3;
        localObject3 = this;
        localObject4 = paramObject;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localCoroutineScope = this.p$;
      localFlowCollector = this.p$0;
      localReceiveChannel = ProduceKt.produce$default(localCoroutineScope, null, -1, (Function2)new FlowKt__DelayKt.sample.2.values.1(this, null), 1, null);
      localObject2 = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject2).element = null;
      localObject3 = FlowKt.fixedPeriodTicker$default(localCoroutineScope, this.$periodMillis, 0L, 2, null);
      paramObject = localObject1;
      localObject1 = localObject3;
      localObject3 = this;
    }
    while (((Ref.ObjectRef)localObject2).element != NullSurrogateKt.DONE)
    {
      ((2)localObject3).L$0 = localCoroutineScope;
      ((2)localObject3).L$1 = localFlowCollector;
      ((2)localObject3).L$2 = localReceiveChannel;
      ((2)localObject3).L$3 = localObject2;
      ((2)localObject3).L$4 = localObject1;
      ((2)localObject3).L$5 = localObject3;
      ((2)localObject3).label = 1;
      Continuation localContinuation = (Continuation)localObject3;
      Object localObject6 = new SelectBuilderImpl(localContinuation);
      try
      {
        localObject4 = (SelectBuilder)localObject6;
        SelectClause1 localSelectClause1 = localReceiveChannel.getOnReceiveOrNull();
        try
        {
          ((SelectBuilder)localObject4).invoke(localSelectClause1, (Function2)new FlowKt__DelayKt.sample.2.invokeSuspend..inlined.select.lambda.1(null, localReceiveChannel, localObject1, (Ref.ObjectRef)localObject2, localFlowCollector));
          ((SelectBuilder)localObject4).invoke(localObject1.getOnReceive(), (Function2)new FlowKt__DelayKt.sample.2.invokeSuspend..inlined.select.lambda.2(null, localReceiveChannel, localObject1, (Ref.ObjectRef)localObject2, localFlowCollector));
        }
        catch (Throwable localThrowable1) {}
        ((SelectBuilderImpl)localObject6).handleBuilderException(localThrowable2);
      }
      catch (Throwable localThrowable2) {}
      localObject6 = ((SelectBuilderImpl)localObject6).getResult();
      if (localObject6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended(localContinuation);
      }
      Object localObject5 = paramObject;
      if (localObject6 == paramObject) {
        return paramObject;
      }
      paramObject = localObject5;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2
 * JD-Core Version:    0.7.0.1
 */