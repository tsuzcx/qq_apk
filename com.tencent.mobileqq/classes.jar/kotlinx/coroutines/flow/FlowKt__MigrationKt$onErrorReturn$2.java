package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "e", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f="Migration.kt", i={0, 0}, l={308}, m="invokeSuspend", n={"$this$catch", "e"}, s={"L$0", "L$1"})
final class FlowKt__MigrationKt$onErrorReturn$2
  extends SuspendLambda
  implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  int label;
  private FlowCollector p$;
  private Throwable p$0;
  
  FlowKt__MigrationKt$onErrorReturn$2(Function1 paramFunction1, Object paramObject, Continuation paramContinuation)
  {
    super(3, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Throwable paramThrowable, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramContinuation = new 2(this.$predicate, this.$fallback, paramContinuation);
    paramContinuation.p$ = paramFlowCollector;
    paramContinuation.p$0 = paramThrowable;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return ((2)create((FlowCollector)paramObject1, (Throwable)paramObject2, (Continuation)paramObject3)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Throwable localThrowable;
    if (i != 0)
    {
      if (i == 1)
      {
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
      localThrowable = this.p$0;
      if (!((Boolean)this.$predicate.invoke(localThrowable)).booleanValue()) {
        break label127;
      }
      Object localObject2 = this.$fallback;
      this.L$0 = paramObject;
      this.L$1 = localThrowable;
      this.label = 1;
      if (paramObject.emit(localObject2, this) == localObject1) {
        return localObject1;
      }
    }
    return Unit.INSTANCE;
    label127:
    throw localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__MigrationKt.onErrorReturn.2
 * JD-Core Version:    0.7.0.1
 */