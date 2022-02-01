package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "a", "b", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$1$1", f="Zip.kt", i={0, 0, 0}, l={83}, m="invokeSuspend", n={"$this$combineTransformInternal", "a", "b"}, s={"L$0", "L$1", "L$2"})
final class FlowKt__ZipKt$combineTransform$1$1
  extends SuspendLambda
  implements Function4<FlowCollector<? super R>, T1, T2, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private FlowCollector p$;
  private Object p$0;
  private Object p$1;
  
  FlowKt__ZipKt$combineTransform$1$1(FlowKt__ZipKt.combineTransform.1 param1, Continuation paramContinuation)
  {
    super(4, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull FlowCollector<? super R> paramFlowCollector, T1 paramT1, T2 paramT2, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramContinuation = new 1(this.this$0, paramContinuation);
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
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = this.L$2;
        localObject1 = this.L$1;
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
      Object localObject2 = this.p$0;
      Object localObject3 = this.p$1;
      Function4 localFunction4 = this.this$0.$transform;
      this.L$0 = paramObject;
      this.L$1 = localObject2;
      this.L$2 = localObject3;
      this.label = 1;
      if (localFunction4.invoke(paramObject, localObject2, localObject3, this) == localObject1) {
        return localObject1;
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ZipKt.combineTransform.1.1
 * JD-Core Version:    0.7.0.1
 */