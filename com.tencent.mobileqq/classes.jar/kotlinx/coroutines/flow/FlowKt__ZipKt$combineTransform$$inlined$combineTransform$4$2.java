package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6$2"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransform$4$2", f="Zip.kt", i={}, l={}, m="invokeSuspend", n={}, s={})
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransform$4$2
  extends SuspendLambda
  implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  int label;
  private FlowCollector p$;
  private Object[] p$0;
  
  public FlowKt__ZipKt$combineTransform$$inlined$combineTransform$4$2(FlowKt__ZipKt.combineTransform..inlined.combineTransform.4 param4, Continuation paramContinuation)
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
    IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (this.label == 0)
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      Object[] arrayOfObject = this.p$0;
      Continuation localContinuation = (Continuation)this;
      this.this$0.$transform$inlined.invoke(paramObject, arrayOfObject[0], arrayOfObject[1], arrayOfObject[2], arrayOfObject[3], arrayOfObject[4], this);
      return Unit.INSTANCE;
    }
    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
  }
  
  @Nullable
  public final Object invokeSuspend$$forInline(@NotNull Object paramObject)
  {
    paramObject = this.p$;
    Object[] arrayOfObject = this.p$0;
    Continuation localContinuation = (Continuation)this;
    this.this$0.$transform$inlined.invoke(paramObject, arrayOfObject[0], arrayOfObject[1], arrayOfObject[2], arrayOfObject[3], arrayOfObject[4], this);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ZipKt.combineTransform..inlined.combineTransform.4.2
 * JD-Core Version:    0.7.0.1
 */