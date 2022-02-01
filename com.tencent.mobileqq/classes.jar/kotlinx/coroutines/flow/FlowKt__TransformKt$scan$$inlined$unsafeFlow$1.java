package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__TransformKt$scan$$inlined$unsafeFlow$1
  implements Flow<R>
{
  public FlowKt__TransformKt$scan$$inlined$unsafeFlow$1(Flow paramFlow, Object paramObject, Function3 paramFunction3) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    Object localObject1;
    if ((paramContinuation instanceof FlowKt__TransformKt.scan..inlined.unsafeFlow.1.1))
    {
      localObject1 = (FlowKt__TransformKt.scan..inlined.unsafeFlow.1.1)paramContinuation;
      if ((((FlowKt__TransformKt.scan..inlined.unsafeFlow.1.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__TransformKt.scan..inlined.unsafeFlow.1.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__TransformKt.scan..inlined.unsafeFlow.1.1(this, paramContinuation);
    label53:
    Object localObject3 = paramContinuation.result;
    Object localObject4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    FlowCollector localFlowCollector1;
    Object localObject2;
    1 local1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramFlowCollector = (Flow)paramContinuation.L$5;
          paramFlowCollector = (Ref.ObjectRef)paramContinuation.L$4;
          paramFlowCollector = (FlowCollector)paramContinuation.L$3;
          paramFlowCollector = (Continuation)paramContinuation.L$2;
          paramFlowCollector = (FlowCollector)paramContinuation.L$1;
          paramFlowCollector = (1)paramContinuation.L$0;
          ResultKt.throwOnFailure(localObject3);
          break label379;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject1 = (Ref.ObjectRef)paramContinuation.L$4;
      localFlowCollector1 = (FlowCollector)paramContinuation.L$3;
      paramFlowCollector = (Continuation)paramContinuation.L$2;
      localObject2 = (FlowCollector)paramContinuation.L$1;
      local1 = (1)paramContinuation.L$0;
      ResultKt.throwOnFailure(localObject3);
      localObject3 = paramFlowCollector;
    }
    else
    {
      ResultKt.throwOnFailure(localObject3);
      localObject3 = (Continuation)paramContinuation;
      localObject1 = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject1).element = this.$initial$inlined;
      localObject2 = ((Ref.ObjectRef)localObject1).element;
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramFlowCollector;
      paramContinuation.L$2 = localObject3;
      paramContinuation.L$3 = paramFlowCollector;
      paramContinuation.L$4 = localObject1;
      paramContinuation.label = 1;
      if (paramFlowCollector.emit(localObject2, paramContinuation) == localObject4) {
        return localObject4;
      }
      local1 = this;
      localObject2 = paramFlowCollector;
      localFlowCollector1 = paramFlowCollector;
    }
    paramFlowCollector = local1.$this_scan$inlined;
    FlowCollector localFlowCollector2 = (FlowCollector)new FlowKt__TransformKt.scan..inlined.unsafeFlow.1.lambda.1(localFlowCollector1, (Ref.ObjectRef)localObject1, local1);
    paramContinuation.L$0 = local1;
    paramContinuation.L$1 = localObject2;
    paramContinuation.L$2 = localObject3;
    paramContinuation.L$3 = localFlowCollector1;
    paramContinuation.L$4 = localObject1;
    paramContinuation.L$5 = paramFlowCollector;
    paramContinuation.label = 2;
    if (paramFlowCollector.collect(localFlowCollector2, paramContinuation) == localObject4) {
      return localObject4;
    }
    label379:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.scan..inlined.unsafeFlow.1
 * JD-Core Version:    0.7.0.1
 */