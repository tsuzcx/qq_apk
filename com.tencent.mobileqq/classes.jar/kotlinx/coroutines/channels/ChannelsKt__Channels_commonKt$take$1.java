package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$take$1", f="Channels.common.kt", i={0, 0, 1, 1, 1}, l={994, 995}, m="invokeSuspend", n={"$this$produce", "remaining", "$this$produce", "remaining", "e"}, s={"L$0", "I$0", "L$0", "I$0", "L$1"})
final class ChannelsKt__Channels_commonKt$take$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>
{
  int I$0;
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private ProducerScope p$;
  
  ChannelsKt__Channels_commonKt$take$1(ReceiveChannel paramReceiveChannel, int paramInt, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_take, this.$n, paramContinuation);
    paramContinuation.p$ = ((ProducerScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject4;
    Object localObject2;
    Object localObject5;
    Object localObject3;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          localObject4 = (ChannelIterator)this.L$2;
          localObject2 = this.L$1;
          i = this.I$0;
          localObject5 = (ProducerScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject2 = this;
          localObject3 = localObject1;
          localObject1 = localObject5;
          paramObject = localObject4;
          break label335;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject5 = (ChannelIterator)this.L$1;
      i = this.I$0;
      localObject3 = (ProducerScope)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject2 = localObject1;
      localObject4 = this;
      localObject1 = localObject5;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this.p$;
      i = this.$n;
      if (i == 0) {
        return Unit.INSTANCE;
      }
      if (i >= 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        break label354;
      }
      i = this.$n;
      paramObject = this.$this_take.iterator();
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = this;
    }
    for (;;)
    {
      ((1)localObject2).L$0 = localObject1;
      ((1)localObject2).I$0 = i;
      ((1)localObject2).L$1 = paramObject;
      ((1)localObject2).label = 1;
      localObject5 = paramObject.hasNext((Continuation)localObject2);
      if (localObject5 == localObject3) {
        return localObject3;
      }
      localObject4 = localObject2;
      localObject2 = localObject5;
      localObject5 = paramObject;
      paramObject = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject1;
      localObject1 = localObject5;
      if (!((Boolean)paramObject).booleanValue()) {
        break;
      }
      paramObject = localObject1.next();
      ((1)localObject4).L$0 = localObject3;
      ((1)localObject4).I$0 = i;
      ((1)localObject4).L$1 = paramObject;
      ((1)localObject4).L$2 = localObject1;
      ((1)localObject4).label = 2;
      if (((ProducerScope)localObject3).send(paramObject, (Continuation)localObject4) == localObject2) {
        return localObject2;
      }
      paramObject = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject2 = paramObject;
      paramObject = localObject1;
      localObject1 = localObject4;
      label335:
      i -= 1;
      if (i == 0) {
        return Unit.INSTANCE;
      }
    }
    return Unit.INSTANCE;
    label354:
    paramObject = new StringBuilder();
    paramObject.append("Requested element count ");
    paramObject.append(this.$n);
    paramObject.append(" is less than zero.");
    paramObject = (Throwable)new IllegalArgumentException(paramObject.toString().toString());
    for (;;)
    {
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.take.1
 * JD-Core Version:    0.7.0.1
 */