package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.IntRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "R", "T", "value", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2$1$2"}, k=3, mv={1, 1, 16})
final class CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1
  extends SuspendLambda
  implements Function2<Object, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  int label;
  private Object p$0;
  
  CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1(int paramInt1, Continuation paramContinuation, CombineKt.combineInternal.2 param2, int paramInt2, Boolean[] paramArrayOfBoolean, ReceiveChannel[] paramArrayOfReceiveChannel, Object[] paramArrayOfObject, Ref.IntRef paramIntRef1, Ref.IntRef paramIntRef2)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$i, paramContinuation, this.this$0, this.$size$inlined, this.$isClosed$inlined, this.$channels$inlined, this.$latestValues$inlined, this.$remainingNulls$inlined, this.$nonClosed$inlined);
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
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject1;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = (Object[])this.L$1;
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
      Object localObject3 = this.p$0;
      if (this.$latestValues$inlined[this.$i] == null)
      {
        paramObject = this.$remainingNulls$inlined;
        paramObject.element -= 1;
        i = paramObject.element;
      }
      this.$latestValues$inlined[this.$i] = localObject3;
      if (this.$remainingNulls$inlined.element != 0) {
        return Unit.INSTANCE;
      }
      Object[] arrayOfObject = (Object[])this.this$0.$arrayFactory.invoke();
      i = 0;
      int j = this.$size$inlined;
      while (i < j)
      {
        Symbol localSymbol = NullSurrogateKt.NULL;
        localObject1 = this.$latestValues$inlined[i];
        paramObject = localObject1;
        if (localObject1 == localSymbol) {
          paramObject = null;
        }
        arrayOfObject[i] = paramObject;
        i += 1;
      }
      paramObject = this.this$0.$transform;
      localObject1 = this.this$0.$this_combineInternal;
      if (arrayOfObject == null) {
        break label246;
      }
      this.L$0 = localObject3;
      this.L$1 = arrayOfObject;
      this.label = 1;
      if (paramObject.invoke(localObject1, arrayOfObject, this) == localObject2) {
        return localObject2;
      }
    }
    return Unit.INSTANCE;
    label246:
    paramObject = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.CombineKt.combineInternal.2.invokeSuspend..inlined.select.lambda.1
 * JD-Core Version:    0.7.0.1
 */