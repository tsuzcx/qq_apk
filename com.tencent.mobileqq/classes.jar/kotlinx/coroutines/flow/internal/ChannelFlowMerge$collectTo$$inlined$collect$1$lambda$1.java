package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Semaphore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/ChannelFlowMerge$collectTo$2$1"}, k=3, mv={1, 1, 16})
final class ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object L$0;
  int label;
  private CoroutineScope p$;
  
  ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(Flow paramFlow, Continuation paramContinuation, ChannelFlowMerge.collectTo..inlined.collect.1 param1)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$inner, paramContinuation, this.this$0);
    paramContinuation.p$ = ((CoroutineScope)paramObject);
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
    if (i != 0) {
      if (i == 1) {
        localObject = (CoroutineScope)this.L$0;
      }
    }
    try
    {
      ResultKt.throwOnFailure(paramObject);
      break label98;
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      Flow localFlow = this.$inner;
      FlowCollector localFlowCollector = (FlowCollector)this.this$0.$collector$inlined;
      this.L$0 = paramObject;
      this.label = 1;
      paramObject = localFlow.collect(localFlowCollector, this);
      if (paramObject == localObject) {
        return localObject;
      }
      label98:
      return Unit.INSTANCE;
    }
    finally
    {
      this.this$0.$semaphore$inlined.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChannelFlowMerge.collectTo..inlined.collect.1.lambda.1
 * JD-Core Version:    0.7.0.1
 */