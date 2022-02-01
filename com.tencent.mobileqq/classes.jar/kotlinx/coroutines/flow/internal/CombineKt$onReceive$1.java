package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.internal.CombineKt$onReceive$1", f="Combine.kt", i={0}, l={89}, m="invokeSuspend", n={"it"}, s={"L$0"})
public final class CombineKt$onReceive$1
  extends SuspendLambda
  implements Function2<Object, Continuation<? super Unit>, Object>
{
  Object L$0;
  int label;
  private Object p$0;
  
  public CombineKt$onReceive$1(Function0 paramFunction0, Function2 paramFunction2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$onClosed, this.$onReceive, paramContinuation);
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
        this.$onClosed.invoke();
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
  
  @Nullable
  public final Object invokeSuspend$$forInline(@NotNull Object paramObject)
  {
    paramObject = this.p$0;
    if (paramObject == null)
    {
      this.$onClosed.invoke();
    }
    else
    {
      Function2 localFunction2 = this.$onReceive;
      InlineMarker.mark(0);
      localFunction2.invoke(paramObject, this);
      InlineMarker.mark(2);
      InlineMarker.mark(1);
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.CombineKt.onReceive.1
 * JD-Core Version:    0.7.0.1
 */