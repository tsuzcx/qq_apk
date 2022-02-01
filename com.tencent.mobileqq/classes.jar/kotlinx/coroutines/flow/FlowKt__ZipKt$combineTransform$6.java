package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", f="Zip.kt", i={0}, l={265}, m="invokeSuspend", n={"$this$flow"}, s={"L$0"})
public final class FlowKt__ZipKt$combineTransform$6
  extends SuspendLambda
  implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>
{
  Object L$0;
  int label;
  private FlowCollector p$;
  
  public FlowKt__ZipKt$combineTransform$6(Flow[] paramArrayOfFlow, Function3 paramFunction3, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 6(this.$flows, this.$transform, paramContinuation);
    paramContinuation.p$ = ((FlowCollector)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((6)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
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
      Flow[] arrayOfFlow = this.$flows;
      Intrinsics.needClassReification();
      Function0 localFunction0 = (Function0)new FlowKt__ZipKt.combineTransform.6.1(this);
      Function3 localFunction3 = (Function3)new FlowKt__ZipKt.combineTransform.6.2(this, null);
      this.L$0 = paramObject;
      this.label = 1;
      if (CombineKt.combineInternal(paramObject, arrayOfFlow, localFunction0, localFunction3, this) == localObject) {
        return localObject;
      }
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public final Object invokeSuspend$$forInline(@NotNull Object paramObject)
  {
    paramObject = this.p$;
    Flow[] arrayOfFlow = this.$flows;
    Intrinsics.needClassReification();
    Function0 localFunction0 = (Function0)new FlowKt__ZipKt.combineTransform.6.1(this);
    Function3 localFunction3 = (Function3)new FlowKt__ZipKt.combineTransform.6.2(this, null);
    InlineMarker.mark(0);
    CombineKt.combineInternal(paramObject, arrayOfFlow, localFunction0, localFunction3, this);
    InlineMarker.mark(2);
    InlineMarker.mark(1);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ZipKt.combineTransform.6
 * JD-Core Version:    0.7.0.1
 */