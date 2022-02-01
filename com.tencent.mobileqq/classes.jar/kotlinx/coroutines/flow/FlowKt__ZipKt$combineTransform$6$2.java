package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", f="Zip.kt", i={0, 0}, l={265}, m="invokeSuspend", n={"$receiver", "it"}, s={"L$0", "L$1"})
public final class FlowKt__ZipKt$combineTransform$6$2
  extends SuspendLambda
  implements Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  int label;
  private FlowCollector p$;
  private Object[] p$0;
  
  public FlowKt__ZipKt$combineTransform$6$2(FlowKt__ZipKt.combineTransform.6 param6, Continuation paramContinuation)
  {
    super(3, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull FlowCollector<? super R> paramFlowCollector, @NotNull T[] paramArrayOfT, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramContinuation = new 2(this.this$0, paramContinuation);
    paramContinuation.p$ = paramFlowCollector;
    paramContinuation.p$0 = paramArrayOfT;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return ((2)create((FlowCollector)paramObject1, (Object[])paramObject2, (Continuation)paramObject3)).invokeSuspend(Unit.INSTANCE);
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
        localObject = (Object[])this.L$1;
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
      Object[] arrayOfObject = this.p$0;
      Function3 localFunction3 = this.this$0.$transform;
      this.L$0 = paramObject;
      this.L$1 = arrayOfObject;
      this.label = 1;
      if (localFunction3.invoke(paramObject, arrayOfObject, this) == localObject) {
        return localObject;
      }
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public final Object invokeSuspend$$forInline(@NotNull Object paramObject)
  {
    paramObject = this.p$;
    Object[] arrayOfObject = this.p$0;
    this.this$0.$transform.invoke(paramObject, arrayOfObject, this);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ZipKt.combineTransform.6.2
 * JD-Core Version:    0.7.0.1
 */