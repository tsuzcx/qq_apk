package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.IntRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$onReceive$1", "kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2$$special$$inlined$onReceive$1"}, k=3, mv={1, 1, 16})
public final class CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2
  extends SuspendLambda
  implements Function2<Object, Continuation<? super Unit>, Object>
{
  Object L$0;
  int label;
  private Object p$0;
  
  public CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2(Function2 paramFunction2, Continuation paramContinuation, int paramInt1, CombineKt.combineInternal.2 param2, int paramInt2, Boolean[] paramArrayOfBoolean, ReceiveChannel[] paramArrayOfReceiveChannel, Object[] paramArrayOfObject, Ref.IntRef paramIntRef1, Ref.IntRef paramIntRef2)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 2(this.$onReceive, paramContinuation, this.$i$inlined, this.this$0, this.$size$inlined, this.$isClosed$inlined, this.$channels$inlined, this.$latestValues$inlined, this.$remainingNulls$inlined, this.$nonClosed$inlined);
    paramContinuation.p$0 = paramObject;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((2)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
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
        this.$isClosed$inlined[this.$i$inlined] = Boxing.boxBoolean(true);
        paramObject = this.$nonClosed$inlined;
        paramObject.element -= 1;
        i = paramObject.element;
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
 * Qualified Name:     kotlinx.coroutines.flow.internal.CombineKt.combineInternal.2.invokeSuspend..inlined.select.lambda.2
 * JD-Core Version:    0.7.0.1
 */