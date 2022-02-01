package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$onReceive$1", "kotlinx/coroutines/flow/internal/CombineKt$combineTransformInternal$2$$special$$inlined$onReceive$2"}, k=3, mv={1, 1, 16})
public final class CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4
  extends SuspendLambda
  implements Function2<Object, Continuation<? super Unit>, Object>
{
  Object L$0;
  int label;
  private Object p$0;
  
  public CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4(Function2 paramFunction2, Continuation paramContinuation, CombineKt.combineTransformInternal.2 param2, Ref.BooleanRef paramBooleanRef1, ReceiveChannel paramReceiveChannel1, Ref.ObjectRef paramObjectRef1, Ref.ObjectRef paramObjectRef2, Ref.BooleanRef paramBooleanRef2, ReceiveChannel paramReceiveChannel2)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 4(this.$onReceive, paramContinuation, this.this$0, this.$firstIsClosed$inlined, this.$firstChannel$inlined, this.$firstValue$inlined, this.$secondValue$inlined, this.$secondIsClosed$inlined, this.$secondChannel$inlined);
    paramContinuation.p$0 = paramObject;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((4)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
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
        localObject = this.L$0;
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
      paramObject = this.p$0;
      if (paramObject == null)
      {
        this.$secondIsClosed$inlined.element = true;
      }
      else
      {
        Function2 localFunction2 = this.$onReceive;
        this.L$0 = paramObject;
        this.label = 1;
        if (localFunction2.invoke(paramObject, this) == localObject) {
          return localObject;
        }
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.CombineKt.combineTransformInternal.2.invokeSuspend..inlined.select.lambda.4
 * JD-Core Version:    0.7.0.1
 */