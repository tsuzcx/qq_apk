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
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$dropWhile$1", f="Channels.common.kt", i={0, 1, 1, 2, 2, 3, 4, 4}, l={725, 726, 727, 731, 732}, m="invokeSuspend", n={"$this$produce", "$this$produce", "e", "$this$produce", "e", "$this$produce", "$this$produce", "e"}, s={"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$1"})
final class ChannelsKt__Channels_commonKt$dropWhile$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private ProducerScope p$;
  
  ChannelsKt__Channels_commonKt$dropWhile$1(ReceiveChannel paramReceiveChannel, Function2 paramFunction2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_dropWhile, this.$predicate, paramContinuation);
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
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                localObject2 = (ChannelIterator)this.L$2;
                localObject3 = this.L$1;
                localObject4 = (ProducerScope)this.L$0;
                ResultKt.throwOnFailure(paramObject);
                paramObject = this;
                localObject5 = localObject1;
                localObject1 = localObject2;
                break label433;
              }
              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            localObject2 = (ChannelIterator)this.L$1;
            localObject4 = (ProducerScope)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject5 = localObject1;
            localObject3 = this;
            localObject1 = localObject4;
            localObject6 = paramObject;
            break label477;
          }
          localObject2 = this.L$1;
          localObject4 = (ProducerScope)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = this;
          localObject5 = localObject1;
          break label423;
        }
        localObject6 = (ChannelIterator)this.L$2;
        localObject7 = this.L$1;
        localObject2 = (ProducerScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject3 = localObject1;
        localObject1 = this;
        break label360;
      }
      localObject6 = (ChannelIterator)this.L$1;
      localObject2 = (ProducerScope)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject3 = localObject1;
      localObject1 = this;
      localObject7 = paramObject;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this.p$;
      localObject6 = this.$this_dropWhile.iterator();
      paramObject = this;
    }
    for (;;)
    {
      paramObject.L$0 = localObject2;
      paramObject.L$1 = localObject6;
      paramObject.label = 1;
      localObject7 = ((ChannelIterator)localObject6).hasNext(paramObject);
      if (localObject7 == localObject1) {
        return localObject1;
      }
      localObject3 = localObject1;
      localObject1 = paramObject;
      paramObject = localObject1;
      localObject4 = localObject2;
      localObject5 = localObject3;
      if (!((Boolean)localObject7).booleanValue()) {
        break;
      }
      localObject7 = ((ChannelIterator)localObject6).next();
      paramObject = ((1)localObject1).$predicate;
      ((1)localObject1).L$0 = localObject2;
      ((1)localObject1).L$1 = localObject7;
      ((1)localObject1).L$2 = localObject6;
      ((1)localObject1).label = 2;
      paramObject = paramObject.invoke(localObject7, localObject1);
      if (paramObject == localObject3) {
        return localObject3;
      }
      label360:
      if (!((Boolean)paramObject).booleanValue())
      {
        ((1)localObject1).L$0 = localObject2;
        ((1)localObject1).L$1 = localObject7;
        ((1)localObject1).label = 3;
        paramObject = localObject1;
        localObject4 = localObject2;
        localObject5 = localObject3;
        if (((ProducerScope)localObject2).send(localObject7, (Continuation)localObject1) != localObject3) {
          break;
        }
        return localObject3;
      }
      paramObject = localObject1;
      localObject1 = localObject3;
    }
    label423:
    for (localObject1 = paramObject.$this_dropWhile.iterator();; localObject1 = localObject2)
    {
      label433:
      paramObject.L$0 = localObject4;
      paramObject.L$1 = localObject1;
      paramObject.label = 4;
      localObject6 = ((ChannelIterator)localObject1).hasNext(paramObject);
      if (localObject6 == localObject5) {
        return localObject5;
      }
      localObject2 = localObject1;
      localObject1 = localObject4;
      localObject3 = paramObject;
      label477:
      if (!((Boolean)localObject6).booleanValue()) {
        break;
      }
      paramObject = ((ChannelIterator)localObject2).next();
      ((1)localObject3).L$0 = localObject1;
      ((1)localObject3).L$1 = paramObject;
      ((1)localObject3).L$2 = localObject2;
      ((1)localObject3).label = 5;
      if (((ProducerScope)localObject1).send(paramObject, (Continuation)localObject3) == localObject5) {
        return localObject5;
      }
      paramObject = localObject3;
      localObject4 = localObject1;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.dropWhile.1
 * JD-Core Version:    0.7.0.1
 */