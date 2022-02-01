package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2", f="Delay.kt", i={0, 0, 0, 0}, l={137}, m="invokeSuspend", n={"$this$scopedFlow", "downstream", "values", "lastValue"}, s={"L$0", "L$1", "L$2", "L$3"})
final class FlowKt__DelayKt$debounce$2
  extends SuspendLambda
  implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  int label;
  private CoroutineScope p$;
  private FlowCollector p$0;
  
  FlowKt__DelayKt$debounce$2(Flow paramFlow, long paramLong, Continuation paramContinuation)
  {
    super(3, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull CoroutineScope paramCoroutineScope, @NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramContinuation = new 2(this.$this_debounce, this.$timeoutMillis, paramContinuation);
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
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject1;
    Object localObject3;
    FlowCollector localFlowCollector;
    CoroutineScope localCoroutineScope;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = (2)this.L$4;
        localObject1 = (Ref.ObjectRef)this.L$3;
        localObject3 = (ReceiveChannel)this.L$2;
        localFlowCollector = (FlowCollector)this.L$1;
        localCoroutineScope = (CoroutineScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject3;
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
      paramObject = ProduceKt.produce$default(localCoroutineScope, null, -1, (Function2)new FlowKt__DelayKt.debounce.2.values.1(this, null), 1, null);
      localObject1 = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject1).element = null;
    }
    while (((Ref.ObjectRef)localObject1).element != NullSurrogateKt.DONE)
    {
      this.L$0 = localCoroutineScope;
      this.L$1 = localFlowCollector;
      this.L$2 = paramObject;
      this.L$3 = localObject1;
      this.L$4 = this;
      this.label = 1;
      localObject3 = (Continuation)this;
      Object localObject4 = new SelectBuilderImpl((Continuation)localObject3);
      try
      {
        SelectBuilder localSelectBuilder = (SelectBuilder)localObject4;
        localSelectBuilder.invoke(paramObject.getOnReceiveOrNull(), (Function2)new FlowKt__DelayKt.debounce.2.invokeSuspend..inlined.select.lambda.1(null, this, paramObject, (Ref.ObjectRef)localObject1, localFlowCollector));
        Object localObject5 = ((Ref.ObjectRef)localObject1).element;
        if (localObject5 != null) {
          localSelectBuilder.onTimeout(this.$timeoutMillis, (Function1)new FlowKt__DelayKt.debounce.2.invokeSuspend..inlined.select.lambda.2(localObject5, null, localSelectBuilder, this, paramObject, (Ref.ObjectRef)localObject1, localFlowCollector));
        }
      }
      catch (Throwable localThrowable)
      {
        ((SelectBuilderImpl)localObject4).handleBuilderException(localThrowable);
      }
      localObject4 = ((SelectBuilderImpl)localObject4).getResult();
      if (localObject4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended((Continuation)localObject3);
      }
      if (localObject4 == localObject2) {
        return localObject2;
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DelayKt.debounce.2
 * JD-Core Version:    0.7.0.1
 */