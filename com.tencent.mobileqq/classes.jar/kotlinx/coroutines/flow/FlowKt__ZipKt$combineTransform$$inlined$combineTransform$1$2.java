package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6$2"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransform$1$2", f="Zip.kt", i={0, 0, 0, 0, 0}, l={321}, m="invokeSuspend", n={"$receiver", "it", "continuation", "args", "$receiver"}, s={"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransform$1$2
  extends SuspendLambda
  implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  int label;
  private FlowCollector p$;
  private Object[] p$0;
  
  public FlowKt__ZipKt$combineTransform$$inlined$combineTransform$1$2(FlowKt__ZipKt.combineTransform..inlined.combineTransform.1 param1, Continuation paramContinuation)
  {
    super(3, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull FlowCollector<? super R> paramFlowCollector, @NotNull Object[] paramArrayOfObject, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramContinuation = new 2(this.this$0, paramContinuation);
    paramContinuation.p$ = paramFlowCollector;
    paramContinuation.p$0 = paramArrayOfObject;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return ((2)create((FlowCollector)paramObject1, (Object[])paramObject2, (Continuation)paramObject3)).invokeSuspend(Unit.INSTANCE);
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
        localObject1 = (FlowCollector)this.L$4;
        localObject1 = (Object[])this.L$3;
        localObject1 = (Continuation)this.L$2;
        localObject1 = (Object[])this.L$1;
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
      Object[] arrayOfObject = this.p$0;
      Continuation localContinuation = (Continuation)this;
      Function4 localFunction4 = this.this$0.$transform$inlined;
      Object localObject2 = arrayOfObject[0];
      Object localObject3 = arrayOfObject[1];
      this.L$0 = paramObject;
      this.L$1 = arrayOfObject;
      this.L$2 = localContinuation;
      this.L$3 = arrayOfObject;
      this.L$4 = paramObject;
      this.label = 1;
      if (localFunction4.invoke(paramObject, localObject2, localObject3, this) == localObject1) {
        return localObject1;
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ZipKt.combineTransform..inlined.combineTransform.1.2
 * JD-Core Version:    0.7.0.1
 */