package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T1", "T2", "R", "value", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$combineTransformInternal$2$1$2"}, k=3, mv={1, 1, 16})
final class CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1
  extends SuspendLambda
  implements Function2<Object, Continuation<? super Unit>, Object>
{
  Object L$0;
  int label;
  private Object p$0;
  
  CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1(Continuation paramContinuation, CombineKt.combineTransformInternal.2 param2, Ref.BooleanRef paramBooleanRef1, ReceiveChannel paramReceiveChannel1, Ref.ObjectRef paramObjectRef1, Ref.ObjectRef paramObjectRef2, Ref.BooleanRef paramBooleanRef2, ReceiveChannel paramReceiveChannel2)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(paramContinuation, this.this$0, this.$firstIsClosed$inlined, this.$firstChannel$inlined, this.$firstValue$inlined, this.$secondValue$inlined, this.$secondIsClosed$inlined, this.$secondChannel$inlined);
    paramContinuation.p$0 = paramObject;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject1;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = this.L$0;
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
      Object localObject4 = this.p$0;
      this.$firstValue$inlined.element = localObject4;
      if (this.$secondValue$inlined.element != null)
      {
        Function4 localFunction4 = this.this$0.$transform;
        FlowCollector localFlowCollector = this.this$0.$this_combineTransformInternal;
        Symbol localSymbol = CombineKt.getNull();
        Object localObject2 = this.$firstValue$inlined.element;
        localObject1 = null;
        paramObject = localObject2;
        if (localObject2 == localSymbol) {
          paramObject = null;
        }
        localSymbol = CombineKt.getNull();
        localObject2 = this.$secondValue$inlined.element;
        if (localObject2 != localSymbol) {
          localObject1 = localObject2;
        }
        this.L$0 = localObject4;
        this.label = 1;
        if (localFunction4.invoke(localFlowCollector, paramObject, localObject1, this) == localObject3) {
          return localObject3;
        }
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.CombineKt.combineTransformInternal.2.invokeSuspend..inlined.select.lambda.1
 * JD-Core Version:    0.7.0.1
 */