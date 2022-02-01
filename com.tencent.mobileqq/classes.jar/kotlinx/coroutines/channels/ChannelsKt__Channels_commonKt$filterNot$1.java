package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "E", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$filterNot$1", f="Channels.common.kt", i={0}, l={837}, m="invokeSuspend", n={"it"}, s={"L$0"})
final class ChannelsKt__Channels_commonKt$filterNot$1
  extends SuspendLambda
  implements Function2<E, Continuation<? super Boolean>, Object>
{
  Object L$0;
  int label;
  private Object p$0;
  
  ChannelsKt__Channels_commonKt$filterNot$1(Function2 paramFunction2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$predicate, paramContinuation);
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
      paramObject = this.p$0;
      localObject1 = this.$predicate;
      this.L$0 = paramObject;
      this.label = 1;
      localObject1 = ((Function2)localObject1).invoke(paramObject, this);
      paramObject = localObject1;
      if (localObject1 == localObject2) {
        return localObject2;
      }
    }
    return Boxing.boxBoolean(((Boolean)paramObject).booleanValue() ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.filterNot.1
 * JD-Core Version:    0.7.0.1
 */