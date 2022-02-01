package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "cause", "", "attempt", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f="Errors.kt", i={0, 0, 0}, l={126}, m="invokeSuspend", n={"$this$retryWhen", "cause", "attempt"}, s={"L$0", "L$1", "J$0"})
final class FlowKt__ErrorsKt$retry$3
  extends SuspendLambda
  implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object>
{
  long J$0;
  Object L$0;
  Object L$1;
  int label;
  private FlowCollector p$;
  private Throwable p$0;
  private long p$1;
  
  FlowKt__ErrorsKt$retry$3(long paramLong, Function2 paramFunction2, Continuation paramContinuation)
  {
    super(4, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Throwable paramThrowable, long paramLong, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    paramContinuation = new 3(this.$retries, this.$predicate, paramContinuation);
    paramContinuation.p$ = paramFlowCollector;
    paramContinuation.p$0 = paramThrowable;
    paramContinuation.p$1 = paramLong;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return ((3)create((FlowCollector)paramObject1, (Throwable)paramObject2, ((Number)paramObject3).longValue(), (Continuation)paramObject4)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    boolean bool = true;
    long l;
    Object localObject1;
    if (i != 0)
    {
      if (i == 1)
      {
        l = this.J$0;
        localObject1 = (Throwable)this.L$1;
        localObject1 = (FlowCollector)this.L$0;
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
      localObject1 = this.p$0;
      l = this.p$1;
      if (l >= this.$retries) {
        break label159;
      }
      Function2 localFunction2 = this.$predicate;
      this.L$0 = paramObject;
      this.L$1 = localObject1;
      this.J$0 = l;
      this.label = 1;
      localObject1 = localFunction2.invoke(localObject1, this);
      paramObject = localObject1;
      if (localObject1 == localObject2) {
        return localObject2;
      }
    }
    if (!((Boolean)paramObject).booleanValue()) {
      label159:
      bool = false;
    }
    return Boxing.boxBoolean(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ErrorsKt.retry.3
 * JD-Core Version:    0.7.0.1
 */