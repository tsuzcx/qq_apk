package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", f="Delay.kt", i={0, 0}, l={137}, m="invokeSuspend", n={"$this$produce", "$this$collect$iv"}, s={"L$0", "L$1"})
final class FlowKt__DelayKt$sample$2$values$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  int label;
  private ProducerScope p$;
  
  FlowKt__DelayKt$sample$2$values$1(FlowKt__DelayKt.sample.2 param2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.this$0, paramContinuation);
    paramContinuation.p$ = ((ProducerScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject = (Flow)this.L$1;
        localObject = (ProducerScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      Flow localFlow = this.this$0.$this_sample;
      FlowCollector localFlowCollector = (FlowCollector)new FlowKt__DelayKt.sample.2.values.1.invokeSuspend..inlined.collect.1(paramObject);
      this.L$0 = paramObject;
      this.L$1 = localFlow;
      this.label = 1;
      if (localFlow.collect(localFlowCollector, this) == localObject) {
        return localObject;
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1
 * JD-Core Version:    0.7.0.1
 */