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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$flatMap$1", f="Channels.common.kt", i={0, 1, 1, 2, 2}, l={1291, 1292, 1292}, m="invokeSuspend", n={"$this$produce", "$this$produce", "e", "$this$produce", "e"}, s={"L$0", "L$0", "L$1", "L$0", "L$1"})
final class ChannelsKt__Channels_commonKt$flatMap$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private ProducerScope p$;
  
  ChannelsKt__Channels_commonKt$flatMap$1(ReceiveChannel paramReceiveChannel, Function2 paramFunction2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_flatMap, this.$transform, paramContinuation);
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
    Object localObject3;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            localObject3 = (ChannelIterator)this.L$2;
            localObject2 = this.L$1;
            localObject2 = (ProducerScope)this.L$0;
            ResultKt.throwOnFailure(paramObject);
          }
          else
          {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
        }
        else
        {
          localObject4 = (ChannelIterator)this.L$2;
          localObject5 = this.L$1;
          localObject2 = (ProducerScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject3 = localObject1;
          localObject1 = this;
          localObject6 = paramObject;
          break label287;
        }
      }
      else
      {
        localObject3 = (ChannelIterator)this.L$1;
        localObject2 = (ProducerScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject4 = localObject1;
        localObject1 = this;
        localObject5 = paramObject;
        break label204;
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this.p$;
      localObject3 = this.$this_flatMap.iterator();
    }
    paramObject = this;
    for (;;)
    {
      paramObject.L$0 = localObject2;
      paramObject.L$1 = localObject3;
      paramObject.label = 1;
      localObject5 = ((ChannelIterator)localObject3).hasNext(paramObject);
      if (localObject5 == localObject1) {
        return localObject1;
      }
      localObject4 = localObject1;
      localObject1 = paramObject;
      label204:
      if (!((Boolean)localObject5).booleanValue()) {
        break;
      }
      paramObject = ((ChannelIterator)localObject3).next();
      localObject5 = ((1)localObject1).$transform;
      ((1)localObject1).L$0 = localObject2;
      ((1)localObject1).L$1 = paramObject;
      ((1)localObject1).L$2 = localObject3;
      ((1)localObject1).label = 2;
      localObject6 = ((Function2)localObject5).invoke(paramObject, localObject1);
      if (localObject6 == localObject4) {
        return localObject4;
      }
      localObject5 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject5;
      localObject5 = paramObject;
      label287:
      paramObject = (ReceiveChannel)localObject6;
      localObject6 = (SendChannel)localObject2;
      ((1)localObject1).L$0 = localObject2;
      ((1)localObject1).L$1 = localObject5;
      ((1)localObject1).L$2 = localObject4;
      ((1)localObject1).label = 3;
      if (ChannelsKt.toChannel(paramObject, (SendChannel)localObject6, (Continuation)localObject1) == localObject3) {
        return localObject3;
      }
      paramObject = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.flatMap.1
 * JD-Core Version:    0.7.0.1
 */