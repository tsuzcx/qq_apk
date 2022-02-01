package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "cause", "", "attempt", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6", f="Errors.kt", i={}, l={}, m="invokeSuspend", n={}, s={})
final class FlowKt__ErrorsKt$retry$6
  extends SuspendLambda
  implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object>
{
  int label;
  private FlowCollector p$;
  private Throwable p$0;
  private long p$1;
  
  FlowKt__ErrorsKt$retry$6(int paramInt, Function1 paramFunction1, Continuation paramContinuation)
  {
    super(4, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Throwable paramThrowable, long paramLong, @NotNull Continuation<? super Boolean> paramContinuation)
  {
    paramContinuation = new 6(this.$retries, this.$predicate, paramContinuation);
    paramContinuation.p$ = paramFlowCollector;
    paramContinuation.p$0 = paramThrowable;
    paramContinuation.p$1 = paramLong;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return ((6)create((FlowCollector)paramObject1, (Throwable)paramObject2, ((Number)paramObject3).longValue(), (Continuation)paramObject4)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (this.label == 0)
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      paramObject = this.p$0;
      long l = this.p$1;
      boolean bool;
      if ((((Boolean)this.$predicate.invoke(paramObject)).booleanValue()) && (l < this.$retries)) {
        bool = true;
      } else {
        bool = false;
      }
      return Boxing.boxBoolean(bool);
    }
    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ErrorsKt.retry.6
 * JD-Core Version:    0.7.0.1
 */