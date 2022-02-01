package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$3$3", f="Zip.kt", i={0, 0}, l={325}, m="invokeSuspend", n={"$receiver", "it"}, s={"L$0", "L$1"})
public final class FlowKt__ZipKt$combine$$inlined$combine$3$3
  extends SuspendLambda
  implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private FlowCollector p$;
  private Object[] p$0;
  
  public FlowKt__ZipKt$combine$$inlined$combine$3$3(Continuation paramContinuation, FlowKt__ZipKt.combine..inlined.combine.3 param3)
  {
    super(3, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull FlowCollector<? super R> paramFlowCollector, @NotNull Object[] paramArrayOfObject, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramContinuation = new 3(paramContinuation, this.this$0);
    paramContinuation.p$ = paramFlowCollector;
    paramContinuation.p$0 = paramArrayOfObject;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return ((3)create((FlowCollector)paramObject1, (Object[])paramObject2, (Continuation)paramObject3)).invokeSuspend(Unit.INSTANCE);
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
      Object localObject2 = (Continuation)this;
      localObject2 = this.this$0.$transform$inlined$1.invoke(arrayOfObject[0], arrayOfObject[1], arrayOfObject[2], arrayOfObject[3], arrayOfObject[4], this);
      this.L$0 = paramObject;
      this.L$1 = arrayOfObject;
      this.label = 1;
      if (paramObject.emit(localObject2, this) == localObject1) {
        return localObject1;
      }
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public final Object invokeSuspend$$forInline(@NotNull Object paramObject)
  {
    paramObject = this.p$;
    Object localObject = this.p$0;
    Continuation localContinuation = (Continuation)this;
    localObject = this.this$0.$transform$inlined$1.invoke(localObject[0], localObject[1], localObject[2], localObject[3], localObject[4], this);
    InlineMarker.mark(0);
    paramObject.emit(localObject, this);
    InlineMarker.mark(2);
    InlineMarker.mark(1);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.combine.3.3
 * JD-Core Version:    0.7.0.1
 */