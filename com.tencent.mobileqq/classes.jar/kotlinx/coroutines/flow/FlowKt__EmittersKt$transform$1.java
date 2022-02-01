package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f="Emitters.kt", i={0, 0}, l={182}, m="invokeSuspend", n={"$this$flow", "$this$collect$iv"}, s={"L$0", "L$1"})
public final class FlowKt__EmittersKt$transform$1
  extends SuspendLambda
  implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  int label;
  private FlowCollector p$;
  
  public FlowKt__EmittersKt$transform$1(Flow paramFlow, Function3 paramFunction3, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_transform, this.$transform, paramContinuation);
    paramContinuation.p$ = ((FlowCollector)paramObject);
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
        localObject = (FlowCollector)this.L$0;
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
      Flow localFlow = this.$this_transform;
      FlowCollector localFlowCollector = (FlowCollector)new FlowKt__EmittersKt.transform.1.invokeSuspend..inlined.collect.1(this, paramObject);
      this.L$0 = paramObject;
      this.L$1 = localFlow;
      this.label = 1;
      if (localFlow.collect(localFlowCollector, this) == localObject) {
        return localObject;
      }
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public final Object invokeSuspend$$forInline(@NotNull Object paramObject)
  {
    FlowCollector localFlowCollector = this.p$;
    paramObject = this.$this_transform;
    localFlowCollector = (FlowCollector)new FlowKt__EmittersKt.transform.1.invokeSuspend..inlined.collect.1(this, localFlowCollector);
    InlineMarker.mark(0);
    paramObject.collect(localFlowCollector, this);
    InlineMarker.mark(2);
    InlineMarker.mark(1);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__EmittersKt.transform.1
 * JD-Core Version:    0.7.0.1
 */