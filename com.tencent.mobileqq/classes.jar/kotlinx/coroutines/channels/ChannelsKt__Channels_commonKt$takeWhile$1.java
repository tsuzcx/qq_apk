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
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$takeWhile$1", f="Channels.common.kt", i={0, 1, 1, 2, 2}, l={1017, 1018, 1019}, m="invokeSuspend", n={"$this$produce", "$this$produce", "e", "$this$produce", "e"}, s={"L$0", "L$0", "L$1", "L$0", "L$1"})
final class ChannelsKt__Channels_commonKt$takeWhile$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private ProducerScope p$;
  
  ChannelsKt__Channels_commonKt$takeWhile$1(ReceiveChannel paramReceiveChannel, Function2 paramFunction2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_takeWhile, this.$predicate, paramContinuation);
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
    ChannelIterator localChannelIterator;
    Object localObject4;
    Object localObject5;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            localChannelIterator = (ChannelIterator)this.L$2;
            localObject2 = this.L$1;
            localObject2 = (ProducerScope)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            paramObject = localObject2;
          }
          else
          {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
        }
        else
        {
          localChannelIterator = (ChannelIterator)this.L$2;
          localObject4 = this.L$1;
          localObject3 = (ProducerScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject2 = localObject1;
          localObject1 = localObject3;
          localObject3 = this;
          localObject5 = paramObject;
          break label320;
        }
      }
      else
      {
        localChannelIterator = (ChannelIterator)this.L$1;
        localObject4 = (ProducerScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject3 = localObject1;
        localObject2 = this;
        localObject1 = localObject4;
        localObject5 = paramObject;
        break label232;
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      localChannelIterator = this.$this_takeWhile.iterator();
    }
    Object localObject3 = this;
    Object localObject2 = localObject1;
    for (;;)
    {
      ((1)localObject3).L$0 = paramObject;
      ((1)localObject3).L$1 = localChannelIterator;
      ((1)localObject3).label = 1;
      localObject5 = localChannelIterator.hasNext((Continuation)localObject3);
      if (localObject5 == localObject2) {
        return localObject2;
      }
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject1 = paramObject;
      localObject2 = localObject4;
      label232:
      if (!((Boolean)localObject5).booleanValue()) {
        break;
      }
      paramObject = localChannelIterator.next();
      localObject4 = ((1)localObject2).$predicate;
      ((1)localObject2).L$0 = localObject1;
      ((1)localObject2).L$1 = paramObject;
      ((1)localObject2).L$2 = localChannelIterator;
      ((1)localObject2).label = 2;
      localObject5 = ((Function2)localObject4).invoke(paramObject, localObject2);
      if (localObject5 == localObject3) {
        return localObject3;
      }
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject4;
      localObject4 = paramObject;
      label320:
      if (!((Boolean)localObject5).booleanValue()) {
        return Unit.INSTANCE;
      }
      ((1)localObject3).L$0 = localObject1;
      ((1)localObject3).L$1 = localObject4;
      ((1)localObject3).L$2 = localChannelIterator;
      ((1)localObject3).label = 3;
      if (localObject1.send(localObject4, (Continuation)localObject3) == localObject2) {
        return localObject2;
      }
      paramObject = localObject1;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.takeWhile.1
 * JD-Core Version:    0.7.0.1
 */