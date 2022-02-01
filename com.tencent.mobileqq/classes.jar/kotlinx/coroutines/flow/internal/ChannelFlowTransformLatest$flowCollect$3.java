package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f="Merge.kt", i={0, 0, 0}, l={99}, m="invokeSuspend", n={"$this$flowScope", "previousFlow", "$this$collect$iv"}, s={"L$0", "L$1", "L$2"})
final class ChannelFlowTransformLatest$flowCollect$3
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private CoroutineScope p$;
  
  ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest paramChannelFlowTransformLatest, FlowCollector paramFlowCollector, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 3(this.this$0, this.$collector, paramContinuation);
    paramContinuation.p$ = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((3)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
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
        localObject = (Flow)this.L$2;
        localObject = (Ref.ObjectRef)this.L$1;
        localObject = (CoroutineScope)this.L$0;
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
      Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
      localObjectRef.element = ((Job)null);
      Flow localFlow = this.this$0.flow;
      FlowCollector localFlowCollector = (FlowCollector)new ChannelFlowTransformLatest.flowCollect.3.invokeSuspend..inlined.collect.1(this, paramObject, localObjectRef);
      this.L$0 = paramObject;
      this.L$1 = localObjectRef;
      this.L$2 = localFlow;
      this.label = 1;
      if (localFlow.collect(localFlowCollector, this) == localObject) {
        return localObject;
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3
 * JD-Core Version:    0.7.0.1
 */