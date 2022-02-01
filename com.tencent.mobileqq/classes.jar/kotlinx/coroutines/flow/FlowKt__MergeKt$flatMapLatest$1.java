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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f="Merge.kt", i={0, 0, 1, 1, 1, 1}, l={190, 216}, m="invokeSuspend", n={"$this$transformLatest", "it", "$this$transformLatest", "it", "$this$emitAll$iv", "flow$iv"}, s={"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
public final class FlowKt__MergeKt$flatMapLatest$1
  extends SuspendLambda
  implements Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  int label;
  private FlowCollector p$;
  private Object p$0;
  
  public FlowKt__MergeKt$flatMapLatest$1(Function2 paramFunction2, Continuation paramContinuation)
  {
    super(3, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull FlowCollector<? super R> paramFlowCollector, T paramT, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramContinuation = new 1(this.$transform, paramContinuation);
    paramContinuation.p$ = paramFlowCollector;
    paramContinuation.p$0 = paramT;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return ((1)create((FlowCollector)paramObject1, paramObject2, (Continuation)paramObject3)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject1 = (Flow)this.L$3;
          localObject1 = (FlowCollector)this.L$2;
          localObject1 = this.L$1;
          localObject1 = (FlowCollector)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          break label219;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject1 = (FlowCollector)this.L$2;
      localObject2 = this.L$1;
      localObject3 = (FlowCollector)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject4 = paramObject;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      localObject2 = this.p$0;
      localObject1 = this.$transform;
      this.L$0 = paramObject;
      this.L$1 = localObject2;
      this.L$2 = paramObject;
      this.label = 1;
      localObject4 = ((Function2)localObject1).invoke(localObject2, this);
      if (localObject4 == localObject5) {
        return localObject5;
      }
      localObject3 = paramObject;
      localObject1 = paramObject;
    }
    paramObject = (Flow)localObject4;
    this.L$0 = localObject3;
    this.L$1 = localObject2;
    this.L$2 = localObject1;
    this.L$3 = paramObject;
    this.label = 2;
    if (paramObject.collect((FlowCollector)localObject1, this) == localObject5) {
      return localObject5;
    }
    label219:
    return Unit.INSTANCE;
  }
  
  @Nullable
  public final Object invokeSuspend$$forInline(@NotNull Object paramObject)
  {
    paramObject = this.p$;
    Object localObject = this.p$0;
    localObject = (Flow)this.$transform.invoke(localObject, this);
    InlineMarker.mark(0);
    ((Flow)localObject).collect(paramObject, this);
    InlineMarker.mark(2);
    InlineMarker.mark(1);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__MergeKt.flatMapLatest.1
 * JD-Core Version:    0.7.0.1
 */