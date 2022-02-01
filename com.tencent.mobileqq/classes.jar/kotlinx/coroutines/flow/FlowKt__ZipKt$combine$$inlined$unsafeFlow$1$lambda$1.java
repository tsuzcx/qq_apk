package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "a", "b", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$1$1"}, k=3, mv={1, 1, 16})
final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1
  extends SuspendLambda
  implements Function4<FlowCollector<? super R>, T1, T2, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  int label;
  private FlowCollector p$;
  private Object p$0;
  private Object p$1;
  
  FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1(Continuation paramContinuation, FlowKt__ZipKt.combine..inlined.unsafeFlow.1 param1)
  {
    super(4, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull FlowCollector<? super R> paramFlowCollector, T1 paramT1, T2 paramT2, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramContinuation = new 1(paramContinuation, this.this$0);
    paramContinuation.p$ = paramFlowCollector;
    paramContinuation.p$0 = paramT1;
    paramContinuation.p$1 = paramT2;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return ((1)create((FlowCollector)paramObject1, paramObject2, paramObject3, (Continuation)paramObject4)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject1 = this.L$2;
          localObject1 = this.L$1;
          localObject1 = (FlowCollector)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          break label224;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject1 = (FlowCollector)this.L$3;
      localObject2 = this.L$2;
      localObject3 = this.L$1;
      localObject4 = (FlowCollector)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject5 = paramObject;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      localObject3 = this.p$0;
      localObject1 = this.p$1;
      localObject2 = this.this$0.$transform$inlined;
      this.L$0 = paramObject;
      this.L$1 = localObject3;
      this.L$2 = localObject1;
      this.L$3 = paramObject;
      this.label = 1;
      localObject5 = ((Function3)localObject2).invoke(localObject3, localObject1, this);
      if (localObject5 == localObject6) {
        return localObject6;
      }
      localObject4 = paramObject;
      localObject2 = localObject1;
      localObject1 = paramObject;
    }
    this.L$0 = localObject4;
    this.L$1 = localObject3;
    this.L$2 = localObject2;
    this.label = 2;
    if (((FlowCollector)localObject1).emit(localObject5, this) == localObject6) {
      return localObject6;
    }
    label224:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.unsafeFlow.1.lambda.1
 * JD-Core Version:    0.7.0.1
 */